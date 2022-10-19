package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.NhaCungCap;

public class NhaCungCap_DAO {

	public ArrayList<NhaCungCap> getalltbNCC(){
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhaCungCap";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNCC = rs.getString(1);
				String tenNCC = rs.getString(2);
				String noiSX = rs.getString(3);
				NhaCungCap NCC = new NhaCungCap(maNCC, tenNCC, noiSX);
				dsNCC.add(NCC);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsNCC;
		
	}
	public int layMaNhaCungCapLonNhat() {
		int mnccln = 0;
		try {
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql = "select * from NhaCungCap";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				mnccln++;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mnccln;
	}
	
	public boolean themNCC(NhaCungCap NCC){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "insert into NhaCungCap values(?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, NCC.getMaNCC());
			preparedStatement.setString(2, NCC.getTenNCC());
			preparedStatement.setString(3, NCC.getNoiSX());
			int n= preparedStatement.executeUpdate();
			if(n> 0)
				return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(NhaCungCap NCC) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement st=null;
		try {
			st=con.prepareStatement("update NhaCungCap set tenNCC=?,noiSX=? where maNCC=?");
			st.setString(1, NCC.getTenNCC());
			st.setString(2, NCC.getNoiSX());
			st.setString(3,NCC.getMaNCC());
			int n=st.executeUpdate();
			if(n> 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<NhaCungCap> timKiem(String maNhaCC){
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhaCungCap where maNCC = ?";
			//String sql = "select * from NhaCungCap where tinhThanh LIKE CONCAT('%', ?, '%')";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maNhaCC);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String maNCC = rs.getString(1);
				String tenNCC = rs.getString(2);
				String noiSX = rs.getString(3);
				NhaCungCap NCC = new NhaCungCap(maNCC, tenNCC, noiSX);
				dsNCC.add(NCC);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsNCC;	
	}
	
	/* public boolean xoaNCC(String maNCC) throws SQLException {
		Connection a = connectDB.ConnectDB.getConnection();// Tao Ket Noi
		String sql = "delete NhaCungCap where maNCC='" + maNCC + "'";
		PreparedStatement pstm = a.prepareStatement(sql);
		if (pstm.executeUpdate() > 0) {
			JOptionPane.showMessageDialog(null, "Xóa thành công khách hàng " + maNCC);
			return true;
		}
		return false;
	} */
	
	public boolean xoaNCC(String tenNCC) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NhaCungCap where tenNCC=?");
			stmt.setString(1, tenNCC);
			n = stmt.executeUpdate();
			if(n==0) {
				return true;
			}
			else
				return false;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) { e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
}
