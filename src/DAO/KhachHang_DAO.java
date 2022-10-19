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
import entity.KhachHang;

public class KhachHang_DAO {

	private int n;
	private ArrayList<KhachHang> listKhachHang;
	private ArrayList<String> list_MaKH;

	public KhachHang_DAO() {
		// TODO Auto-generated constructor stub
		list_MaKH = new ArrayList<String>();
	}

	public KhachHang LayKhachHangTheoCMND(String cmndNhap) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KhachHang where cmnd = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, cmndNhap);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String email = rs.getString(3);
				String diaChi = rs.getString(4);
				String soDT = rs.getString(5);
				String cmnd = rs.getString(6);
				boolean gioiTinh = rs.getBoolean(7);

				KhachHang kh = new KhachHang(maKH, tenKH, email, diaChi, soDT, cmnd, gioiTinh);
				return kh;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public ArrayList<KhachHang> LayHetKhachHang() {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KhachHang ";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			// preparedStatement.setString(1, "hshs");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String email = rs.getString(3);
				String diaChi = rs.getString(4);
				String soDT = rs.getString(5);
				String cmnd = rs.getString(6);
				boolean gioiTinh = rs.getBoolean(7);

				KhachHang kh = new KhachHang(maKH, tenKH, email, diaChi, soDT, cmnd, gioiTinh);
				dsKH.add(kh);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}

	public int LayMaKHLonNhat() {
		int ma = 0;
		ArrayList<KhachHang> listKH = LayHetKhachHang();
		if (listKH.size() > 0)
			ma = listKH.size();
		return ma;
	}

	public boolean ThemKhachHang(KhachHang khachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into KhachHang values(?,?,?,?,?,?,?) ";
		int k = 0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, khachHang.getMaKH());
			preparedStatement.setString(2, khachHang.getTenKH());
			preparedStatement.setString(3, khachHang.getEmail());
			preparedStatement.setString(4, khachHang.getDiaChi());
			preparedStatement.setString(5, khachHang.getSoDT());
			preparedStatement.setString(6, khachHang.getCmnd());
			preparedStatement.setBoolean(7, khachHang.getGioiTinh());
			k = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k > 0;
	}

	public DefaultTableModel getAllKH() throws SQLException {
		String[] header = { "Mã khách hàng", "Tên khách hàng", "Email", "Địa Chỉ", "Số điện thoại ", "CMND",
				"Giới tính" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		connectDB.ConnectDB.getInstance();
		Connection con = connectDB.ConnectDB.getConnection();
		String sql = "Select *FROM KhachHang";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		KhachHang kh = new KhachHang();
		while (rs.next()) {
			
			if(rs.getBoolean(7) == false) {
				Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),"Nữ"};
				tableModel.addRow(o);
			}
			else {
				Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),"Nam"};
				tableModel.addRow(o);
			}

			
			
		}
		return tableModel;
	}

	public boolean themKH(KhachHang kh) {
		connectDB.ConnectDB.getInstance();
		Connection con = connectDB.ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into KhachHang values(?,?,?,?,?,?,?)");
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getTenKH());
			stmt.setString(6, kh.getEmail());
			stmt.setString(3, kh.getDiaChi());
			stmt.setString(4, kh.getCmnd());
			stmt.setString(5, kh.getSoDT());
			stmt.setBoolean(7, kh.getGioiTinh());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean update(KhachHang kh) {
		connectDB.ConnectDB.getInstance();
		Connection con = connectDB.ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {

			stmt = con.prepareStatement(
					"update KhachHang set tenKH=?,CMND=?,diaChi=?,email=?,soDT=?,gioiTinh=? where maKH=?");
			stmt.setString(7, kh.getMaKH());
			stmt.setString(1, kh.getTenKH());
			stmt.setString(2, kh.getSoDT());
			stmt.setString(3, kh.getEmail());
			stmt.setString(4, kh.getCmnd());
			stmt.setString(5, kh.getDiaChi());
			stmt.setBoolean(6, kh.getGioiTinh());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return n > 0;
	}

	public KhachHang getKhachHangbyHDId(String properties, String ma) {
		Connection con = connectDB.ConnectDB.getConnection();
		String sql = "select * from KhachHang where " + properties + " = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ma);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getBoolean(7));
				return kh;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel timKiem(String cmnd, String ma) throws SQLException {
		String[] header = { "Mã Khách Hàng", "Tên Khách Hàng", "Email", "Địa Chỉ", "Số Điện Thoại", "CMND",
				"Giới Tính" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		connectDB.ConnectDB.getInstance();
		Connection con = connectDB.ConnectDB.getConnection();
		String sql = "SELECT * from KhachHang  where CMND like '" + cmnd + "' or maKH like '" + ma + "'";

		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7) };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public boolean xoaKH(String maKH) throws SQLException {
		Connection a = connectDB.ConnectDB.getConnection();// Tao Ket Noi
		String sql = "delete KhachHang where maKH='" + maKH + "'";
		PreparedStatement pstm = a.prepareStatement(sql);
		if (pstm.executeUpdate() > 0) {
			JOptionPane.showMessageDialog(null, "Xóa thành công khách hàng " + maKH);
			return true;
		}
		return false;
	}
}
