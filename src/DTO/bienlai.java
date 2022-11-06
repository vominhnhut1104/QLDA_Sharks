package DTO;

public class bienlai {
	private int soBienLai;
	private String ngayThanhToan;
	private int tongTien;
	private String tenBenhNhan;
	
	public bienlai(int soBienLai, String ngayThanhToan, int tongTien, String tenBenhNhan) {
		super();
		this.soBienLai = soBienLai;
		this.ngayThanhToan = ngayThanhToan;
		this.tongTien = tongTien;
		this.tenBenhNhan = tenBenhNhan;
	}

	public bienlai() {
		
	}
	
	public int getSoBienLai() {
		return soBienLai;
	}

	public void setSoBienLai(int soBienLai) {
		this.soBienLai = soBienLai;
	}

	public String getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(String ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public String getTenBenhNhan() {
		return tenBenhNhan;
	}

	public void setTenBenhNhan(String tenBenhNhan) {
		this.tenBenhNhan = tenBenhNhan;
	}
	
}
