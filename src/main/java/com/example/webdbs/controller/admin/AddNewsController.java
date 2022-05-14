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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.webdbs.entity.Admin;
import com.example.webdbs.entity.ImageNewsDetail;
import com.example.webdbs.entity.NewsDetail;
import com.example.webdbs.service.ImageNewsDetailService;
import com.example.webdbs.service.NewDetailService;

@Controller
@SessionAttributes(types = Admin.class, names = "adminSession")
public class AddNewsController {
	
	@Autowired
	private NewDetailService newDetailService;
	
	@Autowired
	private ImageNewsDetailService imageNewsDetailService;

	@Value("${upload.path}")
    private String fileUpload;
	
	@GetMapping("/addnews")
	public String addNews(@ModelAttribute("adminSession") Admin admin, Model model) {
		if (admin !=null) {
			model.addAttribute("newsDetail", new NewsDetail());
			return "Management/Admin/news";
			
		}
		
		return "redirect:/login";
	}
	
	@ModelAttribute("adminSession")
	public Admin getAdmin() {
		return null;
	}
	
	@PostMapping("/addnews")
	public String addNewsGo(@ModelAttribute("newsDetail") NewsDetail newsDetail) {
		ImageNewsDetail imageNewsDetail = null;
		if (newsDetail.getFile().getSize() != 0) {
			
			Map asMap = ObjectUtils.asMap("cloud_name", "haminhnhat711", "api_key", "414128439647965", "api_secret",
					"weG0sfQ2m6mxoYuL56aiCKAOIXs", "secure", true);
			
			String fileName = newsDetail.getFile().getOriginalFilename();
			try {
				FileCopyUtils.copy(newsDetail.getFile().getBytes(), new File(this.fileUpload + fileName));	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Cloudinary cloudinary = new Cloudinary(asMap);
			try {
				
				File file2 = (new AddProdetailController().convert(newsDetail.getFile()));
				Map upload = cloudinary.uploader().upload(file2, asMap);
				imageNewsDetail = new ImageNewsDetail((String) upload.get("secure_url"),newsDetail);
				newsDetail.setImage(imageNewsDetail);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			newDetailService.save(newsDetail);
			imageNewsDetailService.save(imageNewsDetail);
		} else {
			newDetailService.save(newsDetail);
		}
			
		
		return "redirect:/login";
	}
}
