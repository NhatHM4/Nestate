package com.example.webdbs.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.webdbs.entity.Home;
import com.example.webdbs.service.HomeService;

@Controller
public class HomeController {

	@Value("${upload.path}")
	private String fileUpload;

	@Autowired
	private HomeService homeService;

	@GetMapping("/editHome")
	public String editHome(Model model) {
		Home home = homeService.findById(Long.valueOf(1));
		model.addAttribute("home", home);
		return "Management/Admin/updateHome";
	}

	@PostMapping("/editHome")
	public String doEditHome(@ModelAttribute("home") Home home) {
		Home homeOld = homeService.findById(Long.valueOf(1));
		if (home.getFile().getSize() != 0) {

			Map asMap = ObjectUtils.asMap("cloud_name", "haminhnhat711", "api_key", "414128439647965", "api_secret",
					"weG0sfQ2m6mxoYuL56aiCKAOIXs", "secure", true);

			String fileName = home.getFile().getOriginalFilename();
			try {
				FileCopyUtils.copy(home.getFile().getBytes(), new File(this.fileUpload + fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			Cloudinary cloudinary = new Cloudinary(asMap);
			try {
				File file2 = (new AddProdetailController().convert(home.getFile()));
				Map upload = cloudinary.uploader().upload(file2, asMap);
				homeOld.setLinkImage((String) upload.get("secure_url"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		homeOld.setTitle(home.getTitle());
		homeOld.setLinkAudio(home.getLinkAudio());
		homeOld.setDecription(home.getDecription());
		homeService.save(homeOld);
		return "redirect:/editHome";

	}
}
