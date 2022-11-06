package DAL;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import javax.swing.JOptionPane;


import DTO.benhNhan_DichVu;
import DTO.bienlai;
import DTO.dichvu;
import DTO.khambenh;


// chưa tối ưu hóa code ở đây
public class bienlaiDAL {
	
	private Connection connection;
	
	public bienlaiDAL() {
		
	}
//	List<Product> productList = new ArrayList<Product>();
	// lấy tất cả oke 
	public List<bienlai> findAll() {
		List<bienlai> bienlaiList = new ArrayList<bienlai>();

		if (openConnection()) {
			try {
				// query
				String sql = "SELECT * FROM bien_lai";
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					bienlai std = new bienlai(resultSet.getInt("SO_BL"),resultSet.getString("NGAY_THANH_TOAN"),resultSet.getInt("TONG_TIEN"),resultSet.getString("tenBenhNhan"));
					bienlaiList.add(std);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return bienlaiList;
	}
	public boolean insert(bienlai p) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
	            String sql = "insert into bien_lai(SO_BL, NGAY_THANH_TOAN, TONG_TIEN, tenBenhNhan) values (?, ?, ?, ?)";
	            PreparedStatement statement = connection.prepareCall(sql);
	            statement.setInt(1, p.getSoBienLai());
	            statement.setString(2, p.getNgayThanhToan());
	            statement.setInt(3, p.getTongTien());
	            statement.setString(4, p.getTenBenhNhan());
				
	            
	            if(statement.executeUpdate()>=1) {
	            	result = true;
	            }
	        } catch (SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return result;
	}
	
	public boolean delete(int id) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
				String sql = "delete from bien_lai where SO_BL=?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setInt(1, id);
	            
	            if(statement.executeUpdate()>=1) {
	            	result = true;
	            }
	        } catch (SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return result;
	}
	
	public List<bienlai> findByName(String Name) {
		List<bienlai> bienlaiList = new ArrayList<bienlai>();
		
		if(openConnection()) {
			try {
	            //query
	            String sql = "select * from bien_lai where tenBenhNhan like ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            statement.setString(1, "%" + Name + "%");
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {                
	            	bienlai std = new bienlai(resultSet.getInt("SO_BL"),resultSet.getString("NGAY_THANH_TOAN"),resultSet.getInt("TONG_TIEN"),resultSet.getString("tenBenhNhan"));
					bienlaiList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return bienlaiList;
	}
	
	public boolean update(bienlai p) {
		boolean result = false;
		if (openConnection()) {
			try {
				// query
				String sql = "UPDATE bien_lai SET NGAY_THANH_TOAN = ?, TONG_TIEN = ?, tenBenhNhan = ? WHERE SO_BL = ?";
				PreparedStatement statement = connection.prepareCall(sql);

				statement.setString(1, p.getNgayThanhToan());
				statement.setInt(2, p.getTongTien());
				statement.setString(3, p.getTenBenhNhan());
				statement.setInt(4, p.getSoBienLai());
				
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
	
	public int getBLMax() {
		int Id = -1;

		if (openConnection()) {
			try {
				// query
				String sql = "select MAX(SO_BL) from bien_lai";
				PreparedStatement statement = connection.prepareCall(sql);

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					Id = resultSet.getInt("MAX(SO_BL)") + 1;
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return Id;
	}
	


	
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
}
