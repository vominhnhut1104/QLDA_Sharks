package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.dichvu;

public class dichVuDAL {
	Connection connection;
    public dichVuDAL() {
        
    }
    public ArrayList<dichvu> findAll() {
		ArrayList<dichvu> dichvuList = new ArrayList<>();
		
		if(openConnection()) {
			try {        
	            //query
	            String sql = "select * from dich_vu";
	            Statement statement = connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	dichvu dichvu = new dichvu();
                        dichvu.setMaDV(resultSet.getInt("MADV"));
                        dichvu.setTenDV(resultSet.getString("TENDV"));
                        dichvu.setDonGia(resultSet.getFloat("GIA"));
	                      
	            	dichvuList.add(dichvu);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return dichvuList;
	}
    public boolean insert(dichvu dv) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
	            String sql = "insert into dich_vu(MADV, TENDV, GIA) values (?, ?, ?)";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setInt(1, dv.getMaDV());
	            statement.setString(2, dv.getTenDV());
	            statement.setDouble(3, dv.getDonGia());
	            
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
    public boolean update(dichvu dv) {
		
		if(openConnection()) {
			try {
	            //query
	            String sql = "UPDATE dich_vu "
                            + "set TENDV = " +"'"  + dv.getTenDV()+  "' ,GIA = "+"'" + dv.getDonGia()+"'"
                            + "where MADV = " + "'" + dv.getMaDV() + "' ";
	            PreparedStatement statement = connection.prepareCall(sql);
                    statement.execute();
	        } catch (SQLException e) {
                    System.out.println("Fail");
                    return false;
	        }
			finally {
				closeConnection();
			}
		}
                return true;
	}
    public boolean delete(int maDV) {
		
		if(openConnection()) {
			try {
	            //query
	            String sql = "DELETE  FROM dich_vu " +
                                "  WHERE MADV ='" + maDV + "'";
	            PreparedStatement statement = connection.prepareCall(sql);
                    statement.execute();
	        } catch (SQLException e) {
                    System.out.println("Fail");
                    return false;
	        }
			finally {
				closeConnection();
			}
		}
                return true;
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
			 if(connection!=null) {
				 connection.close();
			 } 
		 } catch(SQLException e) {
			 System.out.println(e);
		 }
	 }
    public List<String> getdichVuList() {
		List<String> dichvuList = new ArrayList<String>();
		
		if(openConnection()) {
			try {
	            
	            //query
	            String sql = "select * from dich_vu";
	            Statement statement = connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	String std = resultSet.getString("TENDV");
	            	dichvuList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return dichvuList;
	}
}
