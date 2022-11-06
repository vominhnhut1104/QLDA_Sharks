package DTO;
import Check.*;
public class nhanvien extends person {

	private int manv;
	private String tennv;
	private String diachi;
	private String gioitinh;
	private String ngaysinh;
	
	
	public int getManv() {
		return manv;
	}



	public void setManv(int manv) {
		this.manv = manv;
	}



	public String getTennv() {
		return tennv;
	}



	public void setTennv(String tennv) {
		this.tennv = tennv;
	}



	public String getNgaysinh() {
		return ngaysinh;
	}



	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}



	public String getDiachi() {
		return diachi;
	}



	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}



	public String getGioitinh() {
		return gioitinh;
	}



	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}


	public nhanvien(int manv, String tennv, String diachi, String gioitinh, String ngaysinh) {
		super();
		this.manv = manv;
		this.tennv = tennv;
		this.diachi = diachi;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
	}



	public nhanvien() {
		super();

	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
