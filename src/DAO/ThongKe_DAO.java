package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import GUI.XemChiTietSanPham;
import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;



public class ThongKe_DAO {

	public ArrayList<HoaDon> getallHoaDon(){
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();	
			String sql = "select * from HoaDon";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//preparedStatement.setString(1, tuNgay); 
			//preparedStatement.setString(2, denNgay);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString("maHD");
				String maNV = rs.getString("maNV");
				String maKH = rs.getString("maKH");
				Date ngayLap = rs.getDate("ngayLap");
				HoaDon hd = new HoaDon(maHoaDon, new NhanVien(maNV), new KhachHang(maKH), ngayLap);
				dsHoaDon.add(hd);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsHoaDon;	
	}     
	
	public int getGiaHD(String maHD) {
		int gia = 0;
		try {
			
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();	
			String sql = "SELECT tonggia = SanPham.gia*ChiTietHoaDon.soLuong\r\n"
					+ "FROM     ChiTietHoaDon INNER JOIN\r\n"
					+ "                  SanPham ON ChiTietHoaDon.maSP = SanPham.maSP\r\n"
					+ "Where ChiTietHoaDon.maHD = '"+ maHD +"'\r\n"
					+ "group by ChiTietHoaDon.soLuong, SanPham.gia, ChiTietHoaDon.maSP";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//preparedStatement.setString(1, tuNgay); 
			//preparedStatement.setString(2, denNgay);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				gia+=rs.getInt("tonggia");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
		return gia;
	}
	
	
	public ArrayList<HoaDon> thongKeTheoNgay(String tuNgay,String denNgay){
		ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();	
			String sql =  "SELECT * \r\n"
					+ "FROM     HoaDon\r\n"
					+ "WHERE  (ngayLap > ?) AND (ngayLap < ?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, tuNgay); 
			preparedStatement.setString(2, denNgay);	
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString("maHD");
				String maNV = rs.getString("maNV");
				String maKH = rs.getString("maKH");
				Date ngayLap = rs.getDate("ngayLap");
				HoaDon hd = new HoaDon(maHoaDon, new NhanVien(maNV), new KhachHang(maKH), ngayLap);
				dshd.add(hd);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dshd;	
	}
	//Thống kê số lượng vé
	public int SoLuongTheoNgay(String tuNgay, String denNgay) {
		int count = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select count(maHD) from HoaDon where ngayLap > ? and ngayLap < ? ";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,tuNgay);
			pst.setString(2, denNgay);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				count=Integer.valueOf(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	// Thống kê doanh thu
	public int TongDTtheoNgayChon(String tuNgay, String denNgay) {
		int sum = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection(); 
			String sql = "SELECT SUM(SanPham.gia) AS Expr1\r\n"
					+ "FROM     ChiTietHoaDon INNER JOIN\r\n"
					+ "                  HoaDon ON ChiTietHoaDon.maHD = HoaDon.maHD INNER JOIN\r\n"
					+ "                  SanPham ON ChiTietHoaDon.maSP = SanPham.maSP\r\n"
					+ "WHERE  (HoaDon.ngayLap > ?) AND (HoaDon.ngayLap < ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,tuNgay);
			pst.setString(2,denNgay);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				sum = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sum;
	}
	
	public boolean xoaHD(String maHD) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE FROM ChiTietHoaDon INNER JOIN\r\n"
					+ "HoaDon ON ChiTietHoaDon.maHD = HoaDon.maHD\r\n"
					+ "WHERE HoaDon.maHD=?");
			stmt.setString(1, maHD);
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
