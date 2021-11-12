package com.thuvien.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thuvien.DAO.ThanhvienDAO;
import com.thuvien.model.Thanhvien;

@Controller
@RequestMapping(value = "/")
@CrossOrigin(origins = "*")
public class LoginController {
	@Autowired
	ThanhvienDAO thanhvienDAO;
	@GetMapping
	public String Login(HttpSession session) {
		try {
			if (session.getAttribute("NAME").toString().length()!=0) {
				return "redirect:/home";
			}
			return "index";
		} catch (Exception e) {
			return "index";
		}
		
		
	}
	@GetMapping("/logout")
	public String Logout(HttpSession session) {
			
				session.setAttribute("idDG", "");
				session.setAttribute("NAME","");
				session.setAttribute("IDNV","");
				return "redirect:/";		
	}
	@PostMapping("/checklogin")
	public String checkLogin(ModelMap model,@RequestParam("username") String username,@RequestParam("password")String password, HttpSession session) {
		try {
			Thanhvien t1=thanhvienDAO.findBytenDN(username);
			
			if (t1.getMatkhau().equals(password)) {
				session.setAttribute("NAME", t1.getTen());
				session.setAttribute("IDNV", t1.getId());
					return "redirect:/home";
			}
			else {
				model.addAttribute("ERRO","Tài khoản hoắc mật khẩu sai");
				return "index";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("ERRO","Tài khoản hoắc mật khẩu sai");
			return "index";
		}
		

	}

}
