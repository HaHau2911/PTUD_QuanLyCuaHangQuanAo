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
import entity.LoaiNhanVien;
import entity.NhanVien;

public class NhanVien_DAO {

	private int n;
	private ArrayList<NhanVien> listNhanVien;
	private ArrayList<String> list_MaNV;

	public NhanVien_DAO() {
		// TODO Auto-generated constructor stub
		list_MaNV = new ArrayList<String>();
	}

	public NhanVien LayNhanVienTheoMa(String mnv) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhanVien where maNV = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, mnv);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maNhanVien = rs.getString(1);
				String tenNhanVien = rs.getString(2);
				String email = rs.getString(3);
				String diaChi = rs.getString(4);
				String soDT = rs.getString(5);
				String cmnd = rs.getString(6);
				boolean trangThai = rs.getBoolean(7);
				boolean gioiTinh = rs.getBoolean(8);
				LoaiNhanVien loaiNhanVien = new LoaiNhanVien(rs.getString(9));

				NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, email, diaChi, soDT, cmnd, trangThai, gioiTinh,
						loaiNhanVien);

				return nv;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public DefaultTableModel getAllNV() throws SQLException {
		String[] header = { "Mã Nhân Viên", "Tên Nhân Viên", "Email", "Địa Chỉ", "Số Điện Thoại", "CMND", "trangThai",
				"GioiTinh", "Loai NhanVien" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT *from NhanVien\r\n";

		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			
			if(rs.getBoolean(8) == false) {
				Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),"Nữ","Đang làm",rs.getString(9)};
				tableModel.addRow(o);
			}
			else {
				Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),"Nam","Đang làm",rs.getString(9)};
				tableModel.addRow(o);
			}
		}
		return tableModel;
	}

	public boolean themNV(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setString(3, nv.getEmail());
			stmt.setString(4, nv.getDiaChi());
			stmt.setString(5, nv.getSoDT());
			stmt.setString(6, nv.getCmnd());
			stmt.setBoolean(7, nv.getTrangThai());
			stmt.setBoolean(8, nv.getGioiTinh());
			stmt.setString(9, nv.getLoaiNV().getMaLoaiNV());

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

	public boolean update(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {

			stmt = con.prepareStatement("update NhanVien set tenNV=?,email=?,diaChi=?,soDT=?"
					+ ",cmnd=?,trangThai=?,gioiTinh=?,maLoaiNV=? where maNV=?");

			stmt.setString(1, nv.getTenNV());
			stmt.setString(2, nv.getEmail());
			stmt.setString(3, nv.getDiaChi());
			stmt.setString(4, nv.getSoDT());
			stmt.setString(5, nv.getCmnd());
			stmt.setBoolean(6, nv.getTrangThai());
			stmt.setBoolean(7, nv.getGioiTinh());
			stmt.setString(8, nv.getLoaiNV().getMaLoaiNV());
			stmt.setString(9, nv.getMaNV());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return n > 0;
	}

	public ArrayList<String> getListMaNV() {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select maNV from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String CMND;
				CMND = rs.getString(1);
				list_MaNV.add(CMND);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list_MaNV;
	}

	public NhanVien getNhanVienbyHDId(String properties, String ma) {
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhanVien where " + properties + " = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ma);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				
				NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getBoolean(8));
				return nv;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
	}

	public NhanVien getNhanVienById(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<NhanVien> LayHetNhanVien() {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhanVien ";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			// preparedStatement.setString(1, "hshs");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String email = rs.getString(3);
				String diaChi = rs.getString(4);
				String soDT = rs.getString(5);
				String cmnd = rs.getString(6);
				boolean gioiTinh = rs.getBoolean(8);
				
				boolean trangThai = rs.getBoolean(7);
				
				LoaiNhanVien lnv = new LoaiNhanVien(rs.getString(9));
				NhanVien nv = new NhanVien(maNV, tenNV, email, diaChi, soDT, cmnd, trangThai, gioiTinh, lnv);
				dsNV.add(nv);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}
	
	public int LayMaNVLonNhat() {
		int ma = 0;
		ArrayList<NhanVien> listNV = LayHetNhanVien();
		if (listNV.size() > 0)
			ma = listNV.size();
		return ma;
	}
	
	public DefaultTableModel timKiem(String cmnd, String ma) throws SQLException {
		String[] header = { "Mã Nhân Viên", "Tên Nhân Viên", "Email", "Địa Chỉ", "Số Điện Thoại", "CMND", "Trang Thai",
				"Giới Tính", "Ma Loai NV" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * from NhanVien  where CMND like '" + cmnd + "' or maNV like '" + ma + "'";

		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) };
			tableModel.addRow(o);
		}
		return tableModel;
	}
}
