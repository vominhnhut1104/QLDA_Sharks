package BLL;

import java.util.List;

import DAL.bacsiDAL;
import DTO.bacsi;

public class bacsiBLL {
	bacsiDAL bsDAL = new bacsiDAL();
	
	public List<bacsi> getAllbacsi() {
		return bsDAL.findAll();
	}
	
	public String addbacsi(bacsi p) {
		if(bsDAL.hasbac_siCode(p.getMabs())) {
			return "Mã bác sĩ này đã tồn tại. Vui lòng thử lại";
		}
		else if(bsDAL.hasbac_siNumber(p.getDienthoai())) {
			return "Số điện thoại bác sĩ này đã tồn tại. Vui lòng thử lại";
		}
		else if(bsDAL.insert(p)) {
			return "Thêm bác sĩ thành công";
		}
		return "Thêm bác sĩ không thành công";
	}
	
	public String deletebacsi(int id) {
		if(bsDAL.delete(id)) {
			return "Xóa bác sĩ thành công";
		}
		return "Xóa bác sĩ không thành công";
	}
	
	public String editbacsi(bacsi p) {
		if(bsDAL.update(p)) {
			return "Sửa bác sĩ thành công";
		}
		return "Sửa bác sĩ không thành công";
	}
	
	public int getMaBSMax() {
		return bsDAL.getMaBSMax() ;
	}
	
	public List<bacsi> searchbacsiByName(String bacsiName) {
		return bsDAL.findByFullName(bacsiName);
	}
	
	public List<String> getbacsiList() {
		return bsDAL.getbac_siList();
	}
}
