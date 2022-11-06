package DAL;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.*;

import javax.swing.JOptionPane;

import DTO.*;

public class hsbaDAL {

	private Connection connection;

	public hsbaDAL() {

	}

//	List<ho_so_benh_an> ho_so_benh_anList = new ArrayList<ho_so_benh_an>();
	// lấy tất cả oke
	public List<hsba> findAll() {
		List<hsba> ho_so_benh_anList = new ArrayList<hsba>();

		if (openConnection()) {
			try {
				String sql = "select * from ho_so_benh_an";
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					hsba std = new hsba(resultSet.getInt("MAHS"), resultSet.getString("NGAYBD"),
							resultSet.getString("NGAYKT"), resultSet.getString("KETQUA"), resultSet.getInt("MABS"),
							resultSet.getInt("MABN"));
					ho_so_benh_anList.add(std);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return ho_so_benh_anList;
	}

	public boolean insert(hsba p) {
		boolean result = false;
		if (openConnection()) {
			try {
				// query
				String sql = "insert into ho_so_benh_an(MAHS, NGAYBD, NGAYKT, KETQUA, MABS, MABN) values (?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = connection.prepareCall(sql);

				statement.setInt(1, p.getMahs());
				statement.setString(2, p.getNgaybd());
				statement.setString(3, p.getNgaykt());
				statement.setString(4, p.getKetqua());
				statement.setInt(5, p.getMabs());
				statement.setInt(6, p.getMabn());
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

	// sữa okei
	public boolean update(hsba p) {
		boolean result = false;
		if (openConnection()) {
			try {
				// query
				String sql = "update ho_so_benh_an set NGAYBD = ? , NGAYKT = ? , KETQUA = ? , MABS = ? , MABN = ? where MAHS = ?";
				PreparedStatement statement = connection.prepareCall(sql);

				statement.setString(1, p.getNgaybd());
				statement.setString(2, p.getNgaykt());
				statement.setString(3, p.getKetqua());
				statement.setInt(4, p.getMabs());
				statement.setInt(5, p.getMabn());
				statement.setInt(6, p.getMahs());

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
				String sql = "delete from ho_so_benh_an where MAHS = ?";
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

	public List<hsba> findByFullName(int id) {
		List<hsba> ho_so_benh_anList = new ArrayList<hsba>();

		if (openConnection()) {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root",
						"");

				// query
				String sql = "select * from ho_so_benh_an where MAHS = ? ";
				PreparedStatement statement = connection.prepareCall(sql);
				statement.setInt(1, id);

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					hsba std = new hsba(resultSet.getInt("MAHS"), resultSet.getString("NGAYBD"),
							resultSet.getString("NGAYKT"), resultSet.getString("KETQUA"), resultSet.getInt("MABS"),
							resultSet.getInt("MABN"));
					ho_so_benh_anList.add(std);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return ho_so_benh_anList;
	}

	public List<String> getho_so_benh_anList() {
		List<String> ho_so_benh_anList = new ArrayList<String>();

		if (openConnection()) {
			try {
				// query
				String sql = "select * from ho_so_benh_an";
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					String std = resultSet.getString("KETQUA");
					ho_so_benh_anList.add(std);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return ho_so_benh_anList;
	}

	// check trùng mã
	public boolean hasho_so_benh_anCode(int ho_so_benh_anCode) {
		boolean result = false;

		if (openConnection()) {
			try {
				// query
				String sql = "select * from ho_so_benh_an where MAHS=" + ho_so_benh_anCode;
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

	public int getMaHSMax() {
		int Id = -1;

		if (openConnection()) {
			try {
				// query
				String sql = "select MAX(MAHS) from ho_so_benh_an";
				PreparedStatement statement = connection.prepareCall(sql);

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					Id = resultSet.getInt("MAX(MAHS)") + 1;
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return Id;
	}

	// hàm kết nối và đóng csdl
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

	public hsba gethsba(int id) {
		hsba std = null;
		if (openConnection()) {
			try {
			// query
				String sql = "select * from ho_so_benh_an where MAHS = ?";
				PreparedStatement statement = connection.prepareCall(sql);
				statement.setInt(1, id);

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					std = new hsba(resultSet.getInt("MAHS"), resultSet.getString("NGAYBD"),
							resultSet.getString("NGAYKT"), resultSet.getString("KETQUA"), resultSet.getInt("MABS"),
							resultSet.getInt("MABN"));
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return std;
	}

//	 public List<hsba> baoCao1() throws ParseException {
//			List<hsba> list = new ArrayList<hsba>();
//			
//			if(openConnection()) {
//				try {
//		            //query 
//		            String sql = "select * from ho_so_benh_an";
//		            PreparedStatement statement = connection.prepareCall(sql);
//		            
//		            ResultSet resultSet = statement.executeQuery();
//		            
//		            while (resultSet.next()) {                
//		            	hsba std = new hsba(resultSet.getInt("MAHS"), 
//		                        resultSet.getString("NGAYBD"), resultSet.getString("NGAYKT"), 
//		                        resultSet.getString("KETQUA"),resultSet.getInt("MABS"),resultSet.getInt("MABN"));
//		            	// ngÃ y hiá»‡n táº¡i
//		            	Date now = new Date();
//		            	String ft = new SimpleDateFormat("MM/yyyy").format(now);
//		            	String date = ft.formatted(now);
//		            	// ngÃ y cá»§a ngÃ y káº¿t thÃºc hsba
//		            	String date1 = std.getNgaykt();
//		            	// chuyá»ƒn String vá»� ngÃ y
//		            	Date format = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
//		            	String ft1 = new SimpleDateFormat("MM/yyyy").format(format);
//		            	String dateNgaykt = ft1.formatted(format);
//		            	if(date.equals(dateNgaykt)) {
//		            		list.add(std);
//		            	}
//		            }
//		        } catch(SQLException e) {
//		        	System.out.println(e);
//		        }
//				finally {
//					closeConnection();
//				}
//			}
//			return list;
//		}
}
