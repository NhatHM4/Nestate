package com.example.webdbs.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.webdbs.entity.Admin;
import com.example.webdbs.service.AdminService;

@Controller
@SessionAttributes("adminSession")
public class LoginController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("admin", new Admin());
		model.addAttribute("message", "");
		return "Management/Admin/login";
	}
	
	@PostMapping("/login")
	public String loginPost(@ModelAttribute("admin") Admin admin, Model model) {
		 if (checkExistsAdmin(admin)!=null) {
			 return "redirect:/management";
		 }
		model.addAttribute("message", "Sai tài khoản hoặc mật khẩu");
		return "Management/Admin/login";
	}
	
	@ModelAttribute("adminSession")
	private Admin checkExistsAdmin(Admin admin) {
		admin = adminService.findByUsernameAndPassword(admin.getUsername(), admin.getPassword());
		if (admin != null) {
			return admin;
		}
		
		return null;
	}
	
	@GetMapping("/logout")
	public String logout(Model model,HttpSession httpsession, SessionStatus status) {
		model.addAttribute("admin", new Admin());
		status.setComplete();
		httpsession.invalidate();
		return "redirect:/login";
	}
	
}
