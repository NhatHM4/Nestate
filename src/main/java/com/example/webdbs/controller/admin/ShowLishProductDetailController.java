package com.example.webdbs.controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.webdbs.entity.ImageProductDetail;
import com.example.webdbs.entity.ProductDetail;
import com.example.webdbs.service.ImageProductDetailService;
import com.example.webdbs.service.ProductDetailService;

@Controller
public class ShowLishProductDetailController {
	
	@Value("${upload.path}")
    private String fileUpload;

	@Autowired
	private ProductDetailService productDetailService;
	
	@Autowired
	private ImageProductDetailService imageProductDetailService;

	@GetMapping("/showListProductDetail")
	public String showListProductDetail(Model model) {
		List<ProductDetail> listProductDetail = productDetailService.findAllProductDetail();
		model.addAttribute("listProductDetail", listProductDetail);
		return "Management/Admin/showDetailProduct";
	}

	@GetMapping("/delete/{id}")
	public String deleteProductDetail(@PathVariable("id") ProductDetail productDetail, Model model) {

		productDetailService.deleteProductDetail(productDetail);
		return "redirect:/showListProductDetail";

	}

	@GetMapping("/edit/{idProductDetail}")
	public String edit(@PathVariable("idProductDetail") Long id, Model model) {
		
		ProductDetail productDetail = productDetailService.findById(id);
		List<ImageProductDetail> listImage = new LinkedList<ImageProductDetail>(productDetail.getSetImage());
		model.addAttribute("productDetail", productDetail);
		model.addAttribute("listImage", listImage);
		return "Management/Admin/EditDetailProduct";
	}
	
	@PostMapping("/edit")
	public String doEdit(@ModelAttribute("productDetail") ProductDetail productDetail) {
		int i =0;
		Map asMap = ObjectUtils.asMap("cloud_name", "haminhnhat711", "api_key", "414128439647965", "api_secret",
				"weG0sfQ2m6mxoYuL56aiCKAOIXs", "secure", true);
		ProductDetail productDetailOld = productDetailService.findById(productDetail.getId());
		Set<ImageProductDetail> imageProductDetails = productDetailOld.getSetImage();
		for (ImageProductDetail imageProductDetail : imageProductDetails) {
			
			if (productDetail.getListFile().get(i).getSize() != 0) {
				String fileName = productDetail.getListFile().get(i).getOriginalFilename();
				try {
					FileCopyUtils.copy(productDetail.getListFile().get(i).getBytes(), new File(this.fileUpload + fileName));	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Cloudinary cloudinary = new Cloudinary(asMap);
				try {
					
					File file2 = convert(productDetail.getListFile().get(i));
					Map upload = cloudinary.uploader().upload(file2, asMap);
					imageProductDetail.setLinkImage((String) upload.get("secure_url"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			i++;
		}
		productDetailOld.setName(productDetail.getName());
		productDetailOld.setAddress(productDetail.getAddress());
		productDetailOld.setPrice(productDetail.getPrice());
		productDetailOld.setStatus(productDetail.getStatus());
		productDetailOld.setBoss(productDetail.getBoss());
		productDetailOld.setDecription(productDetail.getDecription());
		productDetailOld.setType(productDetail.getType());
		productDetailOld.setBuildDensity(productDetail.getBuildDensity());
		productDetailOld.setPinkBook(productDetail.getPinkBook());
		productDetailOld.setLinkMap(productDetail.getLinkMap());
		productDetailOld.setInfoProject(productDetail.getInfoProject());
		productDetailOld.setTypeInfoDecription(productDetail.getTypeInfoDecription());
		productDetailOld.setBossInfoDecription(productDetail.getBossInfoDecription());
		productDetailService.save(productDetailOld);
		for (ImageProductDetail imageProductDetail : imageProductDetails) {
			imageProductDetailService.save(imageProductDetail);
		}
		return "redirect:/showListProductDetail";
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
