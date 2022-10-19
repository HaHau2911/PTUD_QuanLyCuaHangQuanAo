package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.SanPham;

public class DatHang_DAO {

	
	public DefaultTableModel GetAllSanPham(String tenSP,String maHD) throws SQLException {
		DecimalFormat df = new DecimalFormat("###,###,###.#### VND ");
		String column[] = { "SanPham","Số lượng","Đơn giá" };
		DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT        HoaDon.maHD, ChiTietHoaDon.maSP, SanPham.trangThai, KhachHang.tenKH, SanPham.tenSP, ChiTietHoaDon.soLuong, SanPham.gia\r\n"
				+ "FROM           \r\n"
				+ "						ChiTietHoaDon INNER JOIN\r\n"
				+ "                         SanPham ON ChiTietHoaDon.maSP = SanPham.maSP INNER JOIN\r\n"
				+ "                         HoaDon ON ChiTietHoaDon.maHD = HoaDon.maHD INNER JOIN\r\n"
				+ "                         KhachHang ON HoaDon.maKH = KhachHang.maKH INNER JOIN\r\n"
				+ "WHERE SanPham.maSP='"+tenSP+"' and ChiTietHoaDon.maHD='"+maHD+"'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Object[] o = { rs.getString(5), rs.getString(6),df.format(Double.parseDouble(rs.getString(7)))};
			tableModel.addRow(o);
		}
		return tableModel;
	}
	public boolean create(HoaDon hoadon) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = conn.prepareStatement("Insert into" + " ChiTietHoaDon values(?,?,?,?)");
			stmt.setString(1, hoadon.getMaHD());
			stmt.setString(2, hoadon.getChitiethd().getMaSP().getMaSP());
			stmt.setInt(3, hoadon.getChitiethd().getSoLuong());
			
			
			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return n > 0;
	}
	public String SearchSP(String s) throws SQLException {
	
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from SanPham where maSP ='"+s+"' or freetext(tenSP, '"+s+"')";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		String sanpham = null;
		
		while (rs.next()) {
			 sanpham=rs.getString(1);
			
		}
		return sanpham;
	
	}
	public boolean update(String sanpham,int soluong) {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = connection.prepareStatement(
					"Update ChiTietHoaDon set soLuong="+soluong+" where maSP='"+sanpham+"'");
			
		
			
			
			n = statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	public boolean delete(String maSP) {
		int n = 0;
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
					"delete from ChiTietHoaDon where maSP ='" + maSP+"'" );
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean themKhachHang(KhachHang khachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pst = null;
		boolean kiemTra = false;
		try {
			pst = con.prepareStatement(
					"INSERT INTO KhachHang(maKhachHang, tenKhachHang) VALUES(?,?) ");
			pst.setString(1, khachHang.getMaKH());
			pst.setString(2, khachHang.getTenKH());
			
			int n = pst.executeUpdate();
			if (n > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return kiemTra;
	}
	public boolean themHoaDon(HoaDon hoadon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pst = null;
		boolean kiemTra = false;
		try {
			pst = con.prepareStatement(
					"INSERT INTO HoaDon(maHD,maNV,maKH,ngayLap) VALUES(?,?,?,?) \n "
					+"INSERT INTO ChiTietHoaDon(maHD,maSP) VALUES(?,?)");
			pst.setString(1, hoadon.getMaHD());
			pst.setString(2, hoadon.getMaNV().getMaNV());
			pst.setString(3, hoadon.getMaKH().getMaKH());
			pst.setString(4, hoadon.getNgayLap().toString());
			pst.setString(5, hoadon.getMaHD());
			pst.setString(6, hoadon.getChitiethd().getMaSP().getMaSP());
			
			
			int n = pst.executeUpdate();
			if (n > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return kiemTra;
	}
	public boolean updateSanPham(SanPham masanpham) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pst = null;
		boolean kiemTra = false;
		try {
			pst = con.prepareStatement(
					"update Phong set trangThai=? where maSP=?");
			pst.setBoolean(1, masanpham.getTrangThai());
			pst.setString(2, masanpham.getMaSP());
		
			
			int n = pst.executeUpdate();
			if (n > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return kiemTra;
	}
	
	public int getSoluong(String maSP) throws SQLException {
	
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select maSP,soLuong from SanPham where maSP ='"+maSP+"'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		int soluong = 0;
		
		while (rs.next()) {
			 soluong=rs.getInt(2);
			
		}
		return soluong;
	
	}
	public String Kiemtratrangthaisanpham(String tenSP) throws SQLException {
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select trangThai from SanPham where maSP ='"+tenSP+"'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		String tinhtrang = null;
		
		while (rs.next()) {
			 tinhtrang = rs.getString(1).toString();
		}
		return tinhtrang;
	
	}
}
