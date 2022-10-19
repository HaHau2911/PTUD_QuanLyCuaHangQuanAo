package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

public class HoaDon_DAO {

	Connection connect;
	PreparedStatement pst;
	ResultSet rs;
	public ArrayList<HoaDon> laydulieuhoadon(String manv) {
		ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		connect=ConnectDB.getConnection();
		pst=null;
		try {
			
			pst=connect.prepareStatement("select * from HoaDon where maKH=?");
			pst.setString(1, manv);
			rs=pst.executeQuery();
			while (rs.next()) {
				
				HoaDon hoadon = new HoaDon();
				hoadon.setMaHD(rs.getString("maHD"));
				
				NhanVien nhanvien = new NhanVien(rs.getString("maNV"));
				hoadon.setMaNV(nhanvien);
				
				KhachHang khachhang = new KhachHang(rs.getString("maKH"));
				hoadon.setMaKH(khachhang);
				
				hoadon.setNgayLap(rs.getDate("ngayLapHD"));
				
				dshd.add(hoadon);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dshd;
	}
	
	
	public ArrayList<SanPham> layDuLieuSanPham(){
		ArrayList<SanPham> dsSP=new ArrayList<>();
		
		
		return dsSP;
	}
	
	
	public void laydulieu(String hoadon) throws SQLException {
		String maSP = "";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT        HoaDon.maHD, KhachHang.tenKH, ChiTietHoaDon.maHD AS Expr1, SanPham.trangThai, SanPham.tenSP, SanPham.gia, ChiTietHoaDon.soLuong, HoaDon.ngayLap, \r\n"
				+ "                         HoaDon.ngayLap\r\n"
				+ "FROM            ChiTietHoaDon INNER JOIN\r\n"
				+ "                         HoaDon ON ChiTietHoaDon.maHD = HoaDon.maHD INNER JOIN\r\n"
				+ "                         KhachHang ON HoaDon.maKH= KhachHang.maKH INNER JOIN\r\n"
				+ "                         SanPham ON ChiTietHoaDon.maSP = SanPham.maSP INNER JOIN\r\n"
				+ "WHERE HoaDon.maHD='"+hoadon+"'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {

		}
	}
	
	public boolean CAPNHATmahoadonmoichokhachhangcu(String makhachhang,String makhdaydu) throws SQLException {
		connect = ConnectDB.getConnection(); 
		String sql = "select * FROM HoaDon WHERE maKH='"+makhachhang+"'";
		Statement statement = connect.createStatement();
		rs = statement.executeQuery(sql);
		pst=null;
		boolean check=false;
		while(rs.next()) {
			try {
				 if(rs!=null) {
					 	String mahd=rs.getString("maHD");
				
						pst=connect.prepareStatement("UPDATE HoaDon SET maKH=? WHERE maHD=?");
						pst.setString(1, makhdaydu);
						pst.setString(2, mahd);
						int n=pst.executeUpdate();
						if(n>0) check=true;
					 }
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					pst.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}
		return check;
	}
	/**
	 * xóa khách hàng bị dư
	 */
	
public DefaultTableModel GetHoaDon(String key) throws SQLException {
		
		String column[] = { "Mã hóa đơn", "Tên khách hàng", "Ngày Lập" };
		DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT        HoaDon.maHD, KhachHang.tenKH, HoaDon.ngayLap\r\n"
				+ "FROM            HoaDon INNER JOIN\r\n"
				+ "                         KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "where HoaDon.maHD='"+key+"' or KhachHang.tenKH LIKE N'%"+key+"%'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3)};
			tableModel.addRow(o);
		}
		return tableModel;
	}
public DefaultTableModel GetSanPham(String key) throws SQLException {
	 DecimalFormat df = new DecimalFormat("###,###,###.#### VND ");
		String column[] = { "San Pham", "Số lượng", "Đơn giá" };
		DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT        SanPham.tenSanPham, ChiTietHoaDon.soLuong, SanPham.gia\r\n"
				+ "FROM            ChiTietHoaDon INNER JOIN\r\n"
				+ "                         MatHang ON ChiTietHoaDon.maSP = SanPham.maSP\r\n"
				+ "Where ChiTietHoaDon.maHD='"+key+"'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), df.format(Double.parseDouble(rs.getString(3)))};
			tableModel.addRow(o);
		}
		return tableModel;
	}
public boolean capnhatongtien(String maHD,Double tongtien) {
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	PreparedStatement pst = null;
	boolean kiemTra = false;
	try {
		pst = con.prepareStatement(
				"update HoaDon set tongTien='"+tongtien+"' where maHD='"+maHD+"'");
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

public ArrayList<HoaDon> getalltbHoaDon(){
	ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
	try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT HoaDon.*, SanPham.maSP\r\n"
				+ "FROM     ChiTietHoaDon INNER JOIN\r\n"
				+ "                  HoaDon ON ChiTietHoaDon.maHD = HoaDon.maHD INNER JOIN\r\n"
				+ "                  SanPham ON ChiTietHoaDon.maSP = SanPham.maSP";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		//preparedStatement.setString(1, maTour);
		ResultSet rs = preparedStatement.executeQuery();
		// Duyệt trên kết quả trả về ResultSet
		while (rs.next()) {
			String maHD = rs.getString(1);
			Date ngayLap = rs.getDate(4);
			
			HoaDon hd = new HoaDon(maHD, new NhanVien(rs.getString(2)),new KhachHang(rs.getString(3)),ngayLap, 
					new ChiTietHoaDon(new SanPham(rs.getString(5))));
			dshd.add(hd);
	}
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return dshd;
}

public int LayMaHoaDonLonNhat(String maSP) {
	int ma =0;
	ArrayList<HoaDon> listHoaDon = DanhSachHoaDontheoMaSP(maSP);
	if(listHoaDon.size()>0)
		ma = listHoaDon.size();
	return ma;
}

public ArrayList<HoaDon> getHoaDonTheoMaSP(String maSP){
	ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
	ArrayList<ChiTietHoaDon> cthd = new ArrayList<ChiTietHoaDon>();
	try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from HoaDon v join SanPham t join Chitiethoadon d on d.maSP = t.maSP join KhachHang kh on v.maKH=kh.maKH join NhanVien nv on nv.maNV = v.maNV    where v.maSP = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, maSP);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			String maHD = rs.getString(1);
			Date ngayDat = rs.getDate(2);
			//Tour  tour = new Tour(rs.getString(5));
			HoaDon hd = new HoaDon(maHD, new NhanVien(rs.getString(0)),new KhachHang(rs.getString(7)), ngayDat);
			dshd.add(hd);

		}
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return dshd;
	
}

public ArrayList<HoaDon> DanhSachHoaDontheoMaSP(String maSP){
	ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
	try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT SanPham.maSP, ChiTietHoaDon.maSP AS Expr1\r\n"
				+ "FROM     ChiTietHoaDon INNER JOIN\r\n"
				+ "HoaDon ON ChiTietHoaDon.maHD = HoaDon.maHD INNER JOIN\r\n"
				+ "SanPham ON ChiTietHoaDon.maSP = SanPham.maSP\r\n"
				+ "WHERE ChiTietHoaDon.maSP = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, new ChiTietHoaDon(new SanPham(maSP)).toString());
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			String maHD = rs.getString(1);
			NhanVien nv = new NhanVien(rs.getString(2));
			KhachHang kh = new KhachHang(rs.getString(3));
			Date ngayLap = rs.getDate(4);
			ChiTietHoaDon cthd = new ChiTietHoaDon(new SanPham(rs.getString(5)));
			HoaDon hoadon = new HoaDon(maHD, nv, kh, ngayLap, cthd);
			dshd.add(hoadon);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	
	}
	return dshd;
}

public boolean taoHoaDon(HoaDon hd) {
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	PreparedStatement stmt = null;
	try {
		stmt = con.prepareStatement("insert into HoaDon values(?,?,?)");
		stmt.setString(1, hd.getMaHD());
		// stmt.setDouble(9, hd.getThanhtien());
		return stmt.executeUpdate() > 0;
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return false;
}

public boolean xoaHoaDon(String maHD) {
	Connection con = ConnectDB.getConnection();
	PreparedStatement stmt = null;
	int n = 0;
	try {
		stmt = con.prepareStatement("delete from HoaDon where maHD =? ");
		stmt.setString(1, maHD);
		n = stmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return n > 0;
}

public HoaDon timHoaDonTheoMa(String mahd) {
	Connection con = ConnectDB.getConnection();
	PreparedStatement stmt = null;

	try {
		String sql = "Select * from HoaDon where maHD  like'%" + mahd + "%'";
		ResultSet rs = stmt.executeQuery(sql);
		String maSP = rs.getString("Ma San Pham");
		SanPham ma = new SanPham(maSP);
		String tenSP = rs.getString("Ten San Pham");
		SanPham ten = new SanPham(tenSP);
		String loaiSP = rs.getString("Loai San Pham");
		Double donGia = rs.getDouble("Don Gia");
		String tenKH = rs.getString("Ten Khach Hang");
		KhachHang tenKh = new KhachHang(tenKH);
		String sdtKH = rs.getString("So Dien Thoai");
		KhachHang sdtKh = new KhachHang(sdtKH);

		if (rs.next()) {
//			HoaDon hd = new HoaDon();
//			hd.setMaHD(rs.getString("Ma Hoa Don"));
//			hd.setMaMH(ma);
//			hd.setTenMH(ten);
//			hd.setLoaiMH(loai);
//			hd.setSoLuong(rs.getInt("So Luong"));
//			hd.setMaMH(ma.getDonGia());
//			hd.setTenKH(rs.getString("Ten Khach Hang"));
//			hd.setSdt(rs.getString("So Dien Thoai"));
//			hd.setThanhtien(rs.getDouble("Thanh Tien"));
//			return hd;
//			return hd;
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

}
