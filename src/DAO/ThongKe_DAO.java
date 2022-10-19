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
			String sql =  "SELECT  HoaDon.maHD, ChiTietHoaDon.maHD AS Expr1, HoaDon.ngayLap, \r\n"
					+ "                         HoaDon.ngayLap\r\n"
					+ "  FROM ChiTietHoaDon INNER JOIN\r\n"
					+ "  HoaDon ON ChiTietHoaDon.maHD = HoaDon.maHD INNER JOIN\r\n"
					+ "  KhachHang ON HoaDon.maKH= KhachHang.maKH INNER JOIN\r\n"
					+ "  SanPham ON ChiTietHoaDon.maSP = SanPham.maSP INNER JOIN\r\n"
					+ "where ngayLap > ? and ngayLap < ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, tuNgay); 
			preparedStatement.setString(2, denNgay);	
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				Date ngay = rs.getDate(4);
				Float gia = rs.getFloat(7);
				HoaDon hd = new HoaDon(maHoaDon, new NhanVien(rs.getString(2)), new KhachHang(rs.getString(3)), (java.sql.Date) ngay, 
						new ChiTietHoaDon(new SanPham(rs.getString(5), rs.getString(6),gia)));
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
			String sql = "Select SUM(gia)"
					+ "  FROM ChiTietHoaDon INNER JOIN\r\n"
					+ "  HoaDon ON ChiTietHoaDon.maHD = HoaDon.maHD INNER JOIN\r\n"
					+ "  SanPham ON ChiTietHoaDon.maSP = SanPham.maSP INNER JOIN\r\n"
					+ "where ngayLap > ? and ngayLap < ?";
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
}
