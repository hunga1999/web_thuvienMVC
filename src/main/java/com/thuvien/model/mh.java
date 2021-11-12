package com.thuvien.model;

public class mh {

	private Long ids;
	private String name;
	private String ngaymuon;
	private String ngaytra;
	private String trangthai;
	private String trangthaitt;
	private String gia;
	
	public mh(Long ids, String name, String ngaymuon, String ngaytra, String trangthai, String trangthaitt,
			String gia) {
		super();
		this.ids = ids;
		this.name = name;
		this.ngaymuon = ngaymuon;
		this.ngaytra = ngaytra;
		this.trangthai = trangthai;
		this.trangthaitt = trangthaitt;
		this.gia = gia;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Long getIds() {
		return ids;
	}
	public void setIds(Long ids) {
		this.ids = ids;
	}
	
	

}
