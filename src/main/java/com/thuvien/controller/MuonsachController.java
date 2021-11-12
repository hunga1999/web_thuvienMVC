package com.thuvien.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
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
import com.thuvien.model.Muonsach;
import com.thuvien.model.Sach;
import com.thuvien.model.Thanhvien;
import com.thuvien.model.mh;

@Controller
@RequestMapping(value = "/")
@CrossOrigin(origins = "*")
public class MuonsachController {

	@Autowired
	DocgiaDAO docgiaDAO;
	@Autowired
	MuonsachDAO muonsachDAO;
	@Autowired
	SachDAO sachDAO;
	
	private List<mh> mhs=new ArrayList<mh>();
	
	@GetMapping("/muonsach")
	public String muonsach(HttpSession session) {
		mhs=new ArrayList<mh>();
		try {
			String idDG= session.getAttribute("idDG").toString();
		
			if (idDG.trim().length()==0) {
				return "redirect:/home";
			}
			else {
				return "muonsach";
			}
			
		} catch (Exception e) {
			
			return "redirect:/home";
		}
		
		
	}

	@PostMapping("/muonsach")
	public String getMS(ModelMap modelMap, @RequestParam(required = false, name = "idS") String id,
			@RequestParam(required = false, name = "ngaytra") String ns,
			HttpSession session) {

		try {
			Long idDG= Long.parseLong(session.getAttribute("idDG").toString());
			Long idS = Long.parseLong(id);
			
			List<Muonsach> muonsachs= muonsachDAO.findByIDDG(idDG);
			
			int dem=0;
			for (Muonsach muonsach : muonsachs) {
				if (muonsach.getTrangthai().equals("Chưa trả")) {
					dem++;
				}
			}
			if (dem>=5) {
				modelMap.addAttribute("ERRO4", "Bạn đã mượn quả số lượng");
				return "muonsach";
			}
			
			
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();			
			String[] n=ns.split("-");
			c2.set(Integer.parseInt(n[0]), Integer.parseInt(n[1])-1,Integer.parseInt(n[2]));
			long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
			Sach s= sachDAO.getById(idS);
			if (noDay>=1) {
				if(s.getTen()!=null){
					Muonsach ms= new Muonsach(idDG, idS, new SimpleDateFormat("dd-MM-yyyy").format(c1.getTime()), new SimpleDateFormat("dd-MM-yyyy").format(c2.getTime()), "Chưa trả","Chưa thanh toán",noDay*5000+"");
					mh mh=new mh(idS, sachDAO.getById(idS).getTen(), ms.getNgaymuon(), ms.getNgaytra(), ms.getTrangthai(), ms.getTrangthaitt(),ms.getGia());
					mhs.add(mh);
					muonsachDAO.save(ms);
					modelMap.addAttribute("listMH", mhs);
					int sl=Integer.parseInt(session.getAttribute("sosach").toString())+1;
					session.setAttribute("sosach", sl);
					return "muonsach";
					
				}
				else {
					
					modelMap.addAttribute("ERRO4", "Mã sách không tồn tại");
					return "muonsach";
				}
				
			}
			else {
				modelMap.addAttribute("ERRO4", "Ngày không hợp lệ");
				return "muonsach";
			}
			
				
			}

		 catch (Exception e) {
			modelMap.addAttribute("ERRO4", "Nội dung nhập ko hợp lệ");
			return "muonsach";
		}

	}
	@GetMapping("/hoadon")
	public String hoadon(ModelMap modelMap,HttpSession session) {
		List<mh> mhs1=new ArrayList<mh>();
		int tongTien=0;
		try {
			Long idDG= Long.parseLong(session.getAttribute("idDG").toString());
			int soluong= Integer.parseInt(session.getAttribute("sosach").toString());
			List<Muonsach> muonsachs= muonsachDAO.findByIDDG(idDG);
			Collections.reverse(muonsachs);
			for (int i=0;i<soluong;i++) {
				Muonsach ms= muonsachs.get(i);
				mh mh=new mh(ms.getIDsach(), sachDAO.getById(ms.getIDsach()).getTen(), ms.getNgaymuon(), ms.getNgaytra(), ms.getTrangthai(), ms.getTrangthaitt(),ms.getGia());
				tongTien+=Integer.parseInt(ms.getGia());
				mhs1.add(mh);
			}
			mh mh= new mh(null,"Số lượng sách","",
					"","","",soluong+"");
			mhs1.add(mh);
			mh= new mh(null,"Tổng tiền","",
					"","","",tongTien+"");
			mhs1.add(mh);
			modelMap.addAttribute("idDG", idDG);
			modelMap.addAttribute("listMH1", mhs1);
			return "Hoadon";
		} catch (Exception e) {
			return "redirect:/home";
		}
	}
	@GetMapping("/thanhtoan")
	public String thanhtoan(ModelMap modelMap,HttpSession session) {
		List<mh> mhs1=new ArrayList<mh>();
		int tongTien=0;
		try {
			Long idDG= Long.parseLong(session.getAttribute("idDG").toString());
			int soluong= Integer.parseInt(session.getAttribute("sosach").toString());
			List<Muonsach> muonsachs= muonsachDAO.findByIDDG(idDG);
			Collections.reverse(muonsachs);
			for (int i=0;i<soluong;i++) {
				Muonsach ms= muonsachs.get(i);
				ms.setTrangthaitt("Đã thanh toán");
				muonsachDAO.save(ms);
				mh mh=new mh(ms.getIDsach(), sachDAO.getById(ms.getIDsach()).getTen(), ms.getNgaymuon(), ms.getNgaytra(), ms.getTrangthai(), ms.getTrangthaitt(),ms.getGia());
				tongTien+=Integer.parseInt(ms.getGia());
				mhs1.add(mh);
			}
			mh mh= new mh(null,"Số lượng sách","",
					"","","",soluong+"");
			mhs1.add(mh);
			mh= new mh(null,"Tổng tiền","",
					"","","",tongTien+"");
			mhs1.add(mh);
			mh= new mh(null,"khách trả","",
					"","","",tongTien+"");
			mhs1.add(mh);
//			session.setAttribute("sosach", 0);
			session.setAttribute("idDG", "");
			modelMap.addAttribute("idDG", idDG);
			modelMap.addAttribute("listMH1", mhs1);
			return "Hoadon";
		} catch (Exception e) {
			return "redirect:/home";
		}
	
		
	}
}
