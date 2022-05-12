package com.example.webdbs.controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.webdbs.entity.ImageProductDetail;
import com.example.webdbs.entity.ProductDetail;
import com.example.webdbs.service.ImageProductDetailService;
import com.example.webdbs.service.ProductDetailService;

@Controller
public class AddProdetailController {
	
	@Value("${upload.path}")
    private String fileUpload;
	
	@Autowired
	private ProductDetailService productDetailService;
	
	@Autowired
	private ImageProductDetailService imageProductDetailService;
	
	@PostMapping("/add")
	public String addProjectDetail(@ModelAttribute("projectDetail") ProductDetail productDetail) {
		List<MultipartFile> listFile = productDetail.getListFile();
		Set<ImageProductDetail> setImage = new HashSet<ImageProductDetail>();
		Map asMap = ObjectUtils.asMap("cloud_name", "haminhnhat711", "api_key", "414128439647965", "api_secret",
				"weG0sfQ2m6mxoYuL56aiCKAOIXs", "secure", true);
		for (MultipartFile file : listFile) {
			String fileName = file.getOriginalFilename();
			try {
				FileCopyUtils.copy(file.getBytes(), new File(this.fileUpload + fileName));	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Cloudinary cloudinary = new Cloudinary(asMap);
			try {
				
				File file2 = convert(file);
				Map upload = cloudinary.uploader().upload(file2, asMap);
				setImage.add(new ImageProductDetail((String) upload.get("secure_url"), productDetail));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		productDetail.setSetImage(setImage);
		productDetailService.save(productDetail);
		for (ImageProductDetail imageProductDetail : setImage) {
			imageProductDetailService.save(imageProductDetail);
		}
		
		return "redirect:/login";
	}

	public File convert(MultipartFile file) throws IOException {
		Path newFile = Paths.get(this.fileUpload+file.getOriginalFilename());
		try (InputStream is = file.getInputStream(); OutputStream os = Files.newOutputStream(newFile)) {
			byte[] buffer = new byte[4096];
			int read = 0;
			while ((read = is.read(buffer)) > 0) {
				os.write(buffer, 0, read);
			}
		}

		return newFile.toFile();
	}
	
	
}
