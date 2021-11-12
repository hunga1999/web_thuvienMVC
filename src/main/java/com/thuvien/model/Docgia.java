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
@Table(name = "docgia")
public class Docgia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="ten")
	private String ten;
	
	@Column(name="diachi")
	private String diachi;
	
	@Column(name="SDT")
	private String SDT;
	
	@Column(name="email")
	private String email;

	public Docgia(String ten, String diachi, String sDT, String email) {
		this.ten = ten;
		this.diachi = diachi;
		SDT = sDT;
		this.email = email;
	}

	public Docgia(long id, String ten, String diachi, String sDT, String email) {
		super();
		this.id = id;
		this.ten = ten;
		this.diachi = diachi;
		SDT = sDT;
		this.email = email;
	}
	public Docgia() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
