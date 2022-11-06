package BLL;

import java.util.List;

import DAL.khambenhDAL;
import DTO.khambenh;

import DTO.bienlai;
import DAL.bienlaiDAL;

public class khambenhBLL {
	khambenhDAL khambenhDAL = new khambenhDAL();
	bienlaiDAL blDAL = new bienlaiDAL();
	
	public List<khambenh> getAllkhambenh() {
		return khambenhDAL.findAll();
	}
	
	public String addkhambenh(khambenh p) {
		if(khambenhDAL.hasSophieukham(p.getSophieukham())) {
			return "Số phiếu khám này đã tồn tại. Vui lòng thử lại";
		}
		if(khambenhDAL.insert(p)) {
			return "Thêm phiếu khám bệnh thành công";
		}
		return "Thêm phiếu khám bệnh không thành công";
	}
	
	public String deletekhambenh(int id) {
		if(khambenhDAL.delete(id)) {
			return "Xóa bác sĩ thành công";
		}
		return "Xóa bác sĩ không thành công";
	}
	
	public String editkhambenh(khambenh p) {
		if(khambenhDAL.update(p)) {
			return "Sửa thông tin phiếu khám bệnh thành công";
		}
		return "Sửa thông tin phiếu khám bệnh không thành công";
	}
	
	public String thanhtoan(bienlai p, int maBN) {
		if(blDAL.insert(p) && khambenhDAL.updatethanhtoan(maBN)) {
			return "Thanh toán thành công";	
		}
		else return "Thanh toán không thành công";
	}
	
	
	public List<khambenh> searchkhambenhs(int maBN) {
		return khambenhDAL.findBysophieukham(maBN);
	}
	
	public int prince(int maBN) {
		return khambenhDAL.prince(maBN);
	}
	
	public List<String> getkhambenhList() {
		return khambenhDAL.getkhambenhList();
	}
	public List<String> getbenhnhanList() {
		return khambenhDAL.getbenhnhanList();
	}
	public List<String> getbacsiList() {
		return khambenhDAL.getbacsiList();
	}
	public List<String> getMabenh() {
		return khambenhDAL.getMabenh();
	}
	public int getData(String table, String dataToGet, String name, String col) {
		return khambenhDAL.getData(table, dataToGet, name, col);
	}
	public String getData1(String table, String dataToGet, String name, String col) {
		return khambenhDAL.getData1(table, dataToGet, name, col);
	}
	public int getSPKMAX() {
		return khambenhDAL.getSPKMAx();
		
	}
}
