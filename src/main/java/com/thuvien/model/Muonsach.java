package com.thuvien.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "muonsach")
public class Muonsach {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="IDDG")
	private long IDDG;
	
	@Column(name="IDS")
	private Long IDsach;
	
	@Column(name="ngaymuon")
	private String ngaymuon;
	
	@Column(name="ngaytra")
	private String ngaytra;
	
	@Column(name="trangthai")
	private String trangthai;
	
	@Column(name="trangthaitt")
	private String trangthaitt;
	
	@Column(name="gia")
	private String gia;



	public Muonsach(long id, long iDDG, Long iDsach, String ngaymuon, String ngaytra, String trangthai,
			String trangthaitt, String gia) {
		super();
		this.id = id;
		IDDG = iDDG;
		IDsach = iDsach;
		this.ngaymuon = ngaymuon;
		this.ngaytra = ngaytra;
		this.trangthai = trangthai;
		this.trangthaitt = trangthaitt;
		this.gia = gia;
	}
	

	public Muonsach(long iDDG, Long iDsach, String ngaymuon, String ngaytra, String trangthai, String trangthaitt,
			String gia) {
		super();
		IDDG = iDDG;
		IDsach = iDsach;
		this.ngaymuon = ngaymuon;
		this.ngaytra = ngaytra;
		this.trangthai = trangthai;
		this.trangthaitt = trangthaitt;
		this.gia = gia;
	}


	public Muonsach() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIDDG() {
		return IDDG;
	}

	public void setIDDG(long iDDG) {
		IDDG = iDDG;
	}

	public Long getIDsach() {
		return IDsach;
	}

	public void setIDsach(Long iDsach) {
		IDsach = iDsach;
	}

	public String getNgaymuon() {
		return ngaymuon;
	}

	public void setNgaymuon(String ngaymuon) {
		this.ngaymuon = ngaymuon;
	}

	public String getNgaytra() {
		return ngaytra;
	}

	public void setNgaytra(String ngaytra) {
		this.ngaytra = ngaytra;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}
	
	public String getTrangthaitt() {
		return trangthaitt;
	}
	public void setTrangthaitt(String trangthaitt) {
		this.trangthaitt = trangthaitt;
	}
	
}
