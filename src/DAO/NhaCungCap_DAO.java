package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
	public DefaultTableModel getAllNCC() throws SQLException {
		String[] header = { "Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Nơi Sản Xuất"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT *from NhaCungCap\r\n";

		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
				Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3)};
				tableModel.addRow(o);
		}
		return tableModel;
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
		int n = 0;
		try {
			st=con.prepareStatement("update NhaCungCap set tenNCC=?,noiSX=? where maNCC=?");
			st.setString(1, NCC.getTenNCC());
			st.setString(2, NCC.getNoiSX());
			st.setString(3,NCC.getMaNCC());
			n=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	public DefaultTableModel timKiem(String nsx, String ma) throws SQLException {
		String[] header = { "Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Nơi Sản Xuất"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * from NhaCungCap  where noiSX like '" + nsx + "' or maNCC like '" + ma + "'";

		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
				Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3)};
				tableModel.addRow(o);
			
		}
		return tableModel;
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
	
	public boolean xoaNCC(String maNCC) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NhaCungCap where maNCC=?");
			stmt.setString(1, maNCC);
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
