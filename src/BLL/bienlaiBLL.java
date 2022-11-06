package BLL;

import DTO.bienlai;

import java.util.List;

import DAL.bienlaiDAL;

public class bienlaiBLL {
	bienlaiDAL blDAL = new bienlaiDAL();
	
	public List<bienlai> getAllbienlai() {
		return blDAL.findAll();
	}
	
	public int getblmax() {
		return blDAL.getBLMax();
	}
	
	public String delete(int sobl) {
		if(blDAL.delete(sobl)) return "xóa biên lai thành công";
		else return "xóa biên lai không thành công";
	}
	
	public String editbienlai(bienlai p) {
		if(blDAL.update(p)) return "sửa biên lai thành công";
		else return "sửa biên lai không thành công";
	}
	
	public List<bienlai> getbyName(String Name) {
		return blDAL.findByName(Name);
	}
}
