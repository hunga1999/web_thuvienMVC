package com.thuvien.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.zip.ZipEntry;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.thuvien.DAO.DocgiaDAO;
import com.thuvien.DAO.MuonsachDAO;
import com.thuvien.DAO.SachDAO;
import com.thuvien.model.Docgia;
import com.thuvien.model.Muonsach;
import com.thuvien.model.Sach;
import com.thuvien.model.mh;

@Controller
@RequestMapping(value = "/")
@CrossOrigin(origins = "*")
public class DocgiaController {
	@Autowired
	DocgiaDAO docgiaDAO;
	@Autowired
	MuonsachDAO muonsachDAO;
	@Autowired
	SachDAO sachDAO;

	@GetMapping("/docgia")
	public String nhap(HttpSession session) {
		try {
			String a=session.getAttribute("idDG").toString();
			if (a.trim().length()==0) {
				return "nhapID";
			}
			else return "redirect:/ttdocgia";
			
		} catch (Exception e) {
			return "nhapID";
		}
	}

	@PostMapping("/docgia")
	public String getID(ModelMap modelMap, @RequestParam(required = false, name = "idDG") String id,
			HttpSession session) {

		try {
			Long a = Long.parseLong(id);
			Docgia docgia = docgiaDAO.findByid(Long.parseLong(id));
			if (docgia == null) {
				modelMap.addAttribute("ERRO1", "Mã không tồn tại");
				return "nhapID";
			} else {
				session.setAttribute("idDG", docgia.getId());
				session.setAttribute("tenDG", docgia.getTen());
				session.setAttribute("sosach", 0);
				return "redirect:/ttdocgia";
			}

		} catch (Exception e) {
			modelMap.addAttribute("ERRO1", "Mã không tồn tại");
			return "nhapID";
		}

	}

	@GetMapping("/add-docgia")
	public String add() {
		return "themDG";
	}
	
	@GetMapping("/tohome")
	public String quaylai(HttpSession session) {
		session.setAttribute("idDG", "");
		return "redirect:/home";
	}

	@PostMapping("/add-docgia")
	public String Luu(@RequestParam("ten") String ten,
			@RequestParam("diachi") String diachi,
			@RequestParam("SDT") String SDT, 
			@RequestParam("Email") String Email, 
			HttpSession session,
			ModelMap modelMap) {
		if (ten.trim().length() == 0 ||
				diachi.trim().length() == 0 ||
				SDT.trim().length() == 0||
				Email.trim().length() == 0) {
			modelMap.addAttribute("ERRO3", "Bạn nhập thiếu thông tin");
			return "themDG";

		} else {
			Docgia dg = new Docgia(ten, diachi, SDT, Email);
			docgiaDAO.save(dg);
			List<Docgia> docgias = docgiaDAO.findAll();
			dg = docgias.get(docgias.size() - 1);
			session.setAttribute("idDG", dg.getId());
			session.setAttribute("tenDG", dg.getTen());
			session.setAttribute("sosach", 0);
			return "redirect:/ttdocgia";
		}

	}

	@GetMapping("/ttdocgia")
	public String getall(HttpSession session,ModelMap modelMap) {
		try {
			if (session.getAttribute("NAME").toString().length() == 0) {
				System.out.println("a");
				return "redirect:/";

			} else if (session.getAttribute("idDG").toString().length() == 0) {
				System.out.println("a1");
				return "redirect:/home";
			} else {
				Long ids=Long.parseLong(session.getAttribute("idDG").toString());
				List<Muonsach> muonsachs= muonsachDAO.findByIDDG(ids);
				List<mh> mhs= new ArrayList<mh>();
				for (Muonsach ms : muonsachs) {
						mh mh= new mh(ms.getIDsach(),sachDAO.getById(ms.getIDsach()).getTen(),ms.getNgaymuon(),
								ms.getNgaytra(),ms.getTrangthai(),ms.getTrangthaitt(),ms.getGia()
								);
						mhs.add(mh);
					
					
				}
				Collections.reverse(mhs);
				modelMap.addAttribute("listMH", mhs);
				return "TTDocgia";
			}
				
		} catch (Exception e) {
			try {
				if (session.getAttribute("NAME").toString().length() == 0) {
					return "redirect:/";
				}
				return "redirect:/home";
			} catch (Exception e2) {
				return "redirect:/";
			}

		}

	}
	
	

}
