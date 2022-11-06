package BLL;

import java.util.*;

import DAL.*;
import DTO.*;


public class hsbaBLL {
	hsbaDAL hsbaDAL = new hsbaDAL();
	bacsiDAL bsDAL = new bacsiDAL();
	benhnhanDAL bnDAL = new benhnhanDAL();
	
//	public List<hsba> getBaoCao1() throws ParseException {
//		return hsbaDAL.baoCao1();
//	}
	
	public List<hsba> getAllhsba() {
		return hsbaDAL.findAll();
	}

	public String addhsba(hsba p) {
		if (hsbaDAL.hasho_so_benh_anCode(p.getMahs())) {
			return "Mã hồ sơ này đã tồn tại. Vui lòng thử lại";
		}
		if (hsbaDAL.insert(p)) {
			return "Thêm hồ sơ thành công";
		}
		return "Thêm hồ sơ không thành công";
	}
	
	public String deletehsba(int id) {
		if(hsbaDAL.delete(id)) {
			return "Xóa hồ sơ thành công";
		}
		return "Xóa hồ sơ không thành công";
	}

	public String edithsba(hsba p) {
		if(hsbaDAL.update(p)) {
			return "Sửa hồ sơ thành công";
		}
		return "Sửa hồ sơ không thành công";
	}
	
	public List<hsba> searchhsbaByName(int id) {
		return hsbaDAL.findByFullName(id);
	}
	
	public List<String> getbenhnhanList() {
		return bnDAL.getbenh_nhanList();
	}
	
	public List<String> gethsbaList() {
		return hsbaDAL.getho_so_benh_anList();
	}
	
	public List<String> getbacsiList() {
		return bsDAL.getbac_siList();
	}
	
	public int getMaHSMax() {
		return hsbaDAL.getMaHSMax();
	}
}
