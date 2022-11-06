package DTO;

public class bacsi {
	private int mabs;
	private String tenbs;
	private String dienthoai;
	private String diachi;
	private String gioitinh;
	private String ngaysinh;
	
	public bacsi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public bacsi(int mabs, String tenbs, String dienthoai, String diachi, String gioitinh, String ngaysinh) {
		super();
		this.mabs = mabs;
		this.tenbs = tenbs;
		this.dienthoai = dienthoai;
		this.diachi = diachi;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
	}

	public int getMabs() {
		return mabs;
	}

	public void setMabs(int mabs) {
		this.mabs = mabs;
	}

	public String getTenbs() {
		return tenbs;
	}

	public void setTenbs(String tenbs) {
		this.tenbs = tenbs;
	}

	public String getDienthoai() {
		return dienthoai;
	}

	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
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

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	
}
