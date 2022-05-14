package com.example.webdbs.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.webdbs.entity.ImageNewsDetail;
import com.example.webdbs.entity.NewsDetail;
import com.example.webdbs.service.ImageNewsDetailService;
import com.example.webdbs.service.NewDetailService;

@Controller
public class ShowListNewsController {

	@Value("${upload.path}")
    private String fileUpload;
	
	@Autowired
	private NewDetailService newDetailService;
	
	@Autowired
	private ImageNewsDetailService imageNewsDetailService;
	
	@GetMapping("/listNewsDetail")
	public String showNews(Model model) {
		List<NewsDetail> listNews = newDetailService.findAll();
		model.addAttribute("listNewsDetail", listNews);
		return "Management/Admin/showNews";
	}
	
	@GetMapping("/deleteNewsDetail/{idNewsDetail}")
	public String deleteNewsDetail(@PathVariable("idNewsDetail") NewsDetail newsDetail) {
		newDetailService.delete(newsDetail);
		return "redirect:/listNewsDetail";
	}
	
	@GetMapping("/editNewsDetail/{idNewsDetail}")
	public String editNewsDetail(@PathVariable("idNewsDetail") NewsDetail newsDetail, Model model) {
		model.addAttribute("newsDetail", newsDetail);
		return "Management/Admin/updateNews";
	}
	
	@PostMapping("/editNewsDetail")
	public String doEditNews(@ModelAttribute("newsDetail") NewsDetail newsDetail) {
		NewsDetail newsDetailOld = newDetailService.findById(newsDetail.getId());
		ImageNewsDetail imageNewsDetail = newsDetailOld.getImage();
		
		if (newsDetail.getFile().getSize()!= 0) {
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
					imageNewsDetail.setLinkImage((String) upload.get("secure_url"));
					newsDetail.setImage(imageNewsDetail);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
			newsDetailOld.setName(newsDetail.getName());
			newsDetailOld.setDecription(newsDetail.getDecription());
			newsDetailOld.setAddress(newsDetail.getAddress());
			newsDetailOld.setStatus(newsDetail.getStatus());
			newsDetailOld.setBoss(newsDetail.getBoss());
			newsDetailOld.setInfoProject(newsDetail.getInfoProject());
		
			
			newDetailService.save(newsDetailOld);
			imageNewsDetailService.save(imageNewsDetail);
		
		return "redirect:/listNewsDetail";
	}
}
