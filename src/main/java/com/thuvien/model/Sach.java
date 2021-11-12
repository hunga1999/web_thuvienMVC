package com.thuvien.model;

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
@Table(name = "sach")
public class Sach {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="ten")
	private String ten;
	
	@Column(name="tacgia")
	private String tacgia;
	
	@Column(name="NXB")
	private String NXB;
	
	@Column(name="gia")
	private double gia;
	
	@Column(name="soluong")
	private int soluong;

	public Sach(long id, String ten, String tacgia, String nXB, double gia, int soluong) {
		super();
		this.id = id;
		this.ten = ten;
		this.tacgia = tacgia;
		NXB = nXB;
		this.gia = gia;
		this.soluong = soluong;
	}

	public Sach(String ten, String tacgia, String nXB, double gia, int soluong) {
		super();
		this.ten = ten;
		this.tacgia = tacgia;
		NXB = nXB;
		this.gia = gia;
		this.soluong = soluong;
	}

	public Sach() {
		super();
	}

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

	public String getTacgia() {
		return tacgia;
	}

	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}

	public String getNXB() {
		return NXB;
	}

	public void setNXB(String nXB) {
		NXB = nXB;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
	

}
