package DAL;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import javax.swing.JOptionPane;

import DTO.*;

// chÆ°a tá»‘i Æ°u hÃ³a code á»Ÿ Ä‘Ã¢y
public class nhanvienDAL {

	private Connection connection;

	public nhanvienDAL() {

	}

//	List<nhanvien> nhanvienList = new ArrayList<nhanvien>();
	// lay tat ca
	public List<nhanvien> findAll() {
		List<nhanvien> nhanvienList = new ArrayList<nhanvien>();

		if (openConnection()) {
			try {
				// query
				String sql = "select * from nhan_vien";
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					nhanvien std = new nhanvien(resultSet.getInt("MANV"), resultSet.getString("TENNV"),
							resultSet.getString("DIACHI"), resultSet.getString("GIOITINH"),
							resultSet.getString("NGAYSINH"));
					nhanvienList.add(std);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return nhanvienList;
	}

	public boolean insert(nhanvien p) {
		boolean result = false;
		if (openConnection()) {
			try {
				// query
				String sql = "insert into nhan_vien(MANV, TENNV,DIACHI,GIOITINH,NGAYSINH) values (?, ?, ?,?,?)";
				PreparedStatement statement = connection.prepareCall(sql);

				statement.setInt(1, p.getManv());
				statement.setString(2, p.getTennv());
				statement.setString(3, p.getDiachi());
				statement.setString(4, p.getGioitinh());
				statement.setString(5, p.getNgaysinh());

				if (statement.executeUpdate() >= 1) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return result;
	}

	// sửa oke
	public boolean update(nhanvien p) {
		boolean result = false;
		if (openConnection()) {
			try {
				// query
				String sql = "update nhan_vien set TENNV=?, DIACHI=?, GIOITINH=?, NGAYSINH=?  where MANV = ?";
				PreparedStatement statement = connection.prepareCall(sql);

				statement.setString(1, p.getTennv());
				statement.setString(2, p.getDiachi());
				statement.setString(3, p.getGioitinh());
				statement.setString(4, p.getNgaysinh());
				statement.setInt(5, p.getManv());

				if (statement.executeUpdate() >= 1) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return result;
	}

	public boolean delete(int id) {
		boolean result = false;
		if (openConnection()) {
			try {
				// query
				String sql = "delete from nhan_vien where MANV = ?";
				PreparedStatement statement = connection.prepareCall(sql);

				statement.setInt(1, id);

				if (statement.executeUpdate() >= 1) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return result;
	}

	public List<nhanvien> findByFullName(String nhanvienName) {
		List<nhanvien> nhanvienList = new ArrayList<nhanvien>();

		if (openConnection()) {
			try {
				// query
				String sql = "select * from nhan_vien where TENNV like ?";
				PreparedStatement statement = connection.prepareCall(sql);
				statement.setString(1, "%" + nhanvienName + "%");

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					nhanvien std = new nhanvien(resultSet.getInt("MANV"), resultSet.getString("TENNV"),
							resultSet.getString("DIACHI"), resultSet.getString("GIOITINH"),
							resultSet.getString("NGAYSINH"));
					nhanvienList.add(std);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return nhanvienList;
	}

	public List<String> getnhanvienList() {
		List<String> nhanvienList = new ArrayList<String>();

		if (openConnection()) {
			try {
				// query
				String sql = "select * from nhan_vien";
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					String std = resultSet.getString("TENNV");
					nhanvienList.add(std);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return nhanvienList;
	}

	// check trung ma
	public boolean hasnhanvienCode(int nhanvienCode) {
		boolean result = false;

		if (openConnection()) {
			try {
				// query
				String sql = "select * from nhan_vien where MANV=" + nhanvienCode;
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);

				result = resultSet.next();
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}

		return result;
	}

	// ham ket noi csdl
	public boolean openConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public nhanvien getnhanvien(int id) {
		nhanvien std = null;
		if (openConnection()) {
			try {
				// query
				String sql = "select * from nhan_vien where TENNV = ?";
				PreparedStatement statement = connection.prepareCall(sql);
				statement.setInt(1, id);

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					std = new nhanvien(resultSet.getInt("MANV"), resultSet.getString("TENNV"),
							resultSet.getString("DIACHI"), resultSet.getString("GIOITINH"),
							resultSet.getString("NGAYSINH"));
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return std;
	}

	public int getMaNVmax() {
		int accountId = -1;

		if (openConnection()) {
			try {
				// query
				String sql = "select MAX(MANV) from nhan_vien";
				PreparedStatement statement = connection.prepareCall(sql);

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					accountId = resultSet.getInt("MAX(MANV)") + 1;
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return accountId;
	}
}
