package com.thuvien.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thuvien.DAO.ThanhvienDAO;
import com.thuvien.model.Thanhvien;

@Controller
@RequestMapping(value = "/home")
@CrossOrigin(origins = "*")

public class HomeController {
	@Autowired
	ThanhvienDAO thanhvienDAO;
	@GetMapping
	public String homePage(HttpSession session) {
		try {
			if (session.getAttribute("NAME").toString().length()==0) {
				return "redirect:/";
			}
			return "home";
		} catch (Exception e) {
			return "redirect:/";
		}
	}
	
}
