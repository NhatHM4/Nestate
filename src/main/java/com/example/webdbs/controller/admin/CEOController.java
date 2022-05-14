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
import com.example.webdbs.entity.CEO;
import com.example.webdbs.service.CEOService;

@Controller
public class CEOController {
	
	@Value("${upload.path}")
	private String fileUpload;
	
	@Autowired
	private CEOService ceoService;
	
	@GetMapping("/editceo")
	public String editCEO(Model model) {
		CEO ceo = ceoService.findById(Long.valueOf(1));
		model.addAttribute("ceo", ceo);
		return  "Management/Admin/updateCeo";
	}
	
	@PostMapping("/editceo")
	public String doEditCEO(@ModelAttribute("ceo") CEO ceo) {
			CEO ceoOld = ceoService.findById(Long.valueOf(1));
			if (ceo.getFile().getSize() != 0) {

				Map asMap = ObjectUtils.asMap("cloud_name", "haminhnhat711", "api_key", "414128439647965", "api_secret",
						"weG0sfQ2m6mxoYuL56aiCKAOIXs", "secure", true);

				String fileName = ceo.getFile().getOriginalFilename();
				try {
					FileCopyUtils.copy(ceo.getFile().getBytes(), new File(this.fileUpload + fileName));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Cloudinary cloudinary = new Cloudinary(asMap);
				try {
					File file2 = (new AddProdetailController().convert(ceo.getFile()));
					Map upload = cloudinary.uploader().upload(file2, asMap);
					ceoOld.setLinkImage((String) upload.get("secure_url"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			ceoOld.setTitle(ceo.getTitle());
			ceoOld.setName(ceo.getName());
			ceoOld.setContent(ceo.getContent());
			ceoService.save(ceoOld);
		return "redirect:/editceo";
	}
	
	
}
