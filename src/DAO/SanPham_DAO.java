package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;


import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.LoaiSanPham;
import entity.NhaCungCap;
import entity.SanPham;

public class SanPham_DAO {

	public ArrayList<SanPham> getalltbSanPham(){
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from SanPham ";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//preparedStatement.setString(1, maTour1);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSP= rs.getString(2);
				float gia = rs.getFloat(3);
				String moTa = rs.getString(4);
				boolean trangThai = rs.getBoolean(5);
				String hinhAnh = rs.getString(6);
				LoaiSanPham loaiSP = new LoaiSanPham(rs.getString(7));
				int soLuong = rs.getInt(8);
				NhaCungCap nhaCC = new NhaCungCap(rs.getString(9));
				SanPham sanpham = new SanPham(maSP, tenSP, gia, moTa, trangThai, hinhAnh, loaiSP, soLuong, nhaCC);
				dsSP.add(sanpham);

			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsSP;
		
	}
	public SanPham getSPTheoMa(String maSP1){
		SanPham dsSP = new SanPham();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from SanPham where maSP = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maSP1);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSP = rs.getString(2);
				float gia = rs.getFloat(3);
				String moTa = rs.getString(4);
				boolean trangThai = rs.getBoolean(5);
				String hinhAnh = rs.getString(6);
				LoaiSanPham loaiSP = new LoaiSanPham(rs.getString(7));
				int soLuong = rs.getInt(8);
				NhaCungCap nhaCC = new NhaCungCap(rs.getString(9));

				SanPham sanpham = new SanPham(maSP, tenSP, gia, moTa, trangThai, hinhAnh, loaiSP, soLuong, nhaCC);

			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsSP;
		
	}
	public ArrayList<SanPham> getSPTheoMaNhaCungCap(String maNCC){
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from SanPham where maNCC = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maNCC);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSP = rs.getString(2);
				float gia = rs.getFloat(3);
				String moTa = rs.getString(4);
				boolean trangThai = rs.getBoolean(5);
				String hinhAnh = rs.getString(6);
				LoaiSanPham loaiSP = new LoaiSanPham(rs.getString(7));
				int soLuong = rs.getInt(8);
				NhaCungCap nhaCC = new NhaCungCap(rs.getString(9));

				SanPham sanpham = new SanPham(maSP, tenSP, gia, moTa, trangThai, hinhAnh, loaiSP, soLuong, nhaCC);
				dsSP.add(sanpham);

			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsSP;
		
	}
	public ArrayList<SanPham> LayHetSP(){
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		NhaCungCap NCC;
		NCC = new NhaCungCap();
		 
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from SanPham where soLuong >0";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//preparedStatement.setString(1, "hshs");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSP = rs.getString(2);
				float gia = rs.getFloat(3);
				String moTa = rs.getString(4);
				boolean trangThai = rs.getBoolean(5);
				String hinhAnh = rs.getString(6);
				LoaiSanPham loaiSP = new LoaiSanPham(rs.getString(7));
				
				int soLuong = rs.getInt(8);
				NCC = new NhaCungCap(rs.getString(9));

				SanPham sanpham = new SanPham(maSP, tenSP, gia, moTa, trangThai, hinhAnh, loaiSP, soLuong, NCC);
				dsSP.add(sanpham);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsSP;
		
	}
	
	public ArrayList<SanPham> DSTCoTheMua(int SL){ // Hàm này dùng để lấy danh sách sanpham có soLuong > 0
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		NhaCungCap nhacungcap;
		nhacungcap = new NhaCungCap();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from SanPham where soLuong > 0";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//preparedStatement.setInt(1, SL);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSP = rs.getString(2);
				float gia = rs.getFloat(3);
				String moTa = rs.getString(4);
				boolean trangThai = rs.getBoolean(5);
				String hinhAnh = rs.getString(6);
				LoaiSanPham loaiSP = new LoaiSanPham(rs.getString(7));
				int soLuong = rs.getInt(8);
				NhaCungCap nhaCC = new NhaCungCap(rs.getString(9));

				SanPham sanpham = new SanPham(maSP, tenSP, gia, moTa, trangThai, hinhAnh, loaiSP, soLuong, nhaCC);
				dsSP.add(sanpham);

			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsSP;
	}
		//Vinh
	
public boolean ThemSanPham(SanPham sanpham) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into SanPham values(?,?,?,?,?,?,?,?,?) ";
		int k =0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, sanpham.getMaSP());
			preparedStatement.setString(2, sanpham.getTenSP());
			preparedStatement.setFloat(3, sanpham.getGia());
			preparedStatement.setString(4, sanpham.getMoTa());
			preparedStatement.setBoolean(5, sanpham.getTrangThai());
			preparedStatement.setString(6, sanpham.getHinhAnh());
			preparedStatement.setString(7, sanpham.getLoaiSP().getMaLoaiSP());
			preparedStatement.setInt(8, sanpham.getSoLuong());
			preparedStatement.setString(9, sanpham.getMaNCC().getMaNCC());
			k = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k>0;
	}
	public boolean SuaSanPham(SanPham sanpham) {
		ConnectDB.getInstance();
		Connection con =  ConnectDB.getConnection();
		String sql = "update SanPham "
				+ "set tenSP=?, gia=?"
				+ "moTa=?, trangThai=?, hinhAnh=?, maLoaiSP=?, soLuong=?, maNCC=?"
				+ " where maSP = ?";
		int k =0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, sanpham.getMaSP());
			preparedStatement.setString(2, sanpham.getTenSP());
			preparedStatement.setFloat(3, sanpham.getGia());
			preparedStatement.setString(4, sanpham.getMoTa());
			preparedStatement.setBoolean(5, sanpham.getTrangThai());
			preparedStatement.setString(6, sanpham.getHinhAnh());
			preparedStatement.setString(7, sanpham.getLoaiSP().getMaLoaiSP());
			preparedStatement.setInt(8, sanpham.getSoLuong());
			preparedStatement.setString(9, sanpham.getMaNCC().getMaNCC());
			k = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k>0; 
	}
	public int LayMaSPLonNhat() {
		int mtln=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from SanPham";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//preparedStatement.setString(1, "hshs");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maSP = rs.getString(1).substring(3);
				if(mtln<Integer.parseInt(maSP)) {
					mtln=Integer.parseInt(maSP);
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mtln;
	}
	/*public Tour KiemTraCoTheChoHuongDanVien(String maTourMoi,String maHDV, Date ngayKH, Date ngayKT) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Tour where maHuongDanVien = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maHDV);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				//Xét xem đây có bị trùng mã k, nếu có bỏ qua
				if(!maTourMoi.substring(3).equals(rs.getString(1).toString().substring(3))) {
					//Ngày khởi hành (ngày mới tạo) nằm trong khoảng ngày khởi hành và ngày kết thúc
					if(ngayKH.compareTo(rs.getDate(6))<=0&&ngayKH.compareTo(rs.getDate(5))>=0) {
						Tour tour = LayTourTheoMaTour(rs.getString(1));
						return tour;
					}
					//Ngày khởi hành (mới tạo) và ngày kết thúc (mới tạo) bao cả ngày khởi hành và ngày kết thúc cũ
					if(ngayKH.compareTo(rs.getDate(5))<=0&&ngayKT.compareTo(rs.getDate(6))>=0) {
						Tour tour = LayTourTheoMaTour(rs.getString(1));
						return tour;
					}
					//Ngày kết thúc (ngày mới tạo) nằm trong khoảng ngày khởi hành và ngày kết thúc cũ
					if(ngayKT.compareTo(rs.getDate(5))>=0&&ngayKT.compareTo(rs.getDate(6))<=0) {
						Tour tour = LayTourTheoMaTour(rs.getString(1));
						return tour;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}*/
	/*public Tour LayTourTheoMaTour(String mt) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Tour where maTour = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, mt);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				float giaTour = rs.getFloat(3);
				int soLuongNguoi = rs.getInt(4);
				Date ngayKhoiHanh = rs.getDate(5);
				Date ngayKetThuc = rs.getDate(6);
				String moTa = rs.getString(7);
				boolean tinhTrang = rs.getBoolean(8);
				String hinhAnh = rs.getString(9);
				HuongDanVien huongDanVien = new HuongDanVien(rs.getString(10));
				DiaDanh diaDanh = new DiaDanh(rs.getString(11));
				LoaiTour loaiTour = new LoaiTour(rs.getString(12));
				Tour tour = new Tour(maTour,tenTour,giaTour,soLuongNguoi,ngayKhoiHanh,ngayKetThuc,moTa,tinhTrang,hinhAnh,huongDanVien,diaDanh, loaiTour);
				return tour;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}*/
	public boolean XoaSP(String maSP) {
		int k=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from SanPham where maSP = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maSP);
			k = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return k>0;
	}
	private ArrayList<String> tachChuoiTim(String chuoiTim){
		ArrayList<String> chuoiTach = new ArrayList<String>();
		String chuoi = chuoiTim.trim();
		int t=0;
		for(int i =0;i<chuoi.length();i++) {
			if(i==chuoi.length()-1) {
				chuoiTach.add(chuoi.substring(t,i+1));
				break;
			}
			if(chuoi.codePointAt(i)==32) {		
				if(chuoi.substring(t,i).codePointAt(0)!=32)
				{				
					chuoiTach.add(chuoi.substring(t,i));
					t=i+1;
				}	
			}
		}
		
		return chuoiTach;
	}
	public ArrayList<SanPham> TimSP(String nhapSP, boolean loai){
		//nếu loại là true thì tìm kiếm cho quản lý tour, false là tìm kiếm cho quản lý vé
		ArrayList<SanPham> SPTimDuoc = new ArrayList<SanPham>();
		ArrayList<SanPham> danhSachSP; 
		if(loai==true)
			danhSachSP=getalltbSanPham();
		else
			danhSachSP = DSTCoTheMua(0);
		if(nhapSP.trim().length()==0)
			return danhSachSP;
		else {
			//Tìm tour theo tên và trả về danh sách tên thôi
			String nhap = nhapSP;
			ArrayList<String> chuoiTach = new ArrayList<String>();
			chuoiTach = tachChuoiTim(nhap);
			ArrayList<String> danhSach = new ArrayList<String>();
			for (SanPham SP : danhSachSP) {
				danhSach.add(SP.getTenSP());
			}
			
			ArrayList<String> danhSachTam = new ArrayList<String>();
			for(int i=0;i<chuoiTach.size();i++) {
				String pattern = ".*"+chuoiTach.get(i)+".*";

				danhSachTam = new ArrayList<String>();
				for(String a : danhSach) {
					if(a.toLowerCase().matches(pattern.toLowerCase())) {
						danhSachTam.add(a);
					}
				}
				danhSach = danhSachTam;
			}
			
			//Kiểm tra và đưa vào Array list tour tìm được
			for (String tenSP : danhSach) {
				
				 for(SanPham SP : danhSachSP) { 
					 if(SP.getTenSP().toLowerCase().equals(tenSP.toLowerCase())) {
						 SPTimDuoc.add(SP); 
					 }
					 
				 }
			}
			return SPTimDuoc;
		}
	}	
	/*public void GuiEmail(SanPham SP, String NhaCC, String loaiSP) {
		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			Session session = Session.getDefaultInstance(properties,
				new Authenticator() {

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication("lntvinh27122000@gmail.com","vinhhe2011");
					}
				
			});
			Message message = new MimeMessage(session);
			message.setSubject("Một Tour du lịch vừa mới ra mắt !");
			MimeBodyPart imgAttachment = new MimeBodyPart();
			imgAttachment.attachFile(tour.getHinhAnh());
			MimeBodyPart tinNhan = new MimeBodyPart();
			
			tinNhan.setContent("<h1>Thông báo một Tour du lịch sắp ra mắt !</h1><br>","text/html; charset=UTF-8");
			
			MimeBodyPart diaDiem = new MimeBodyPart();
			//String dd= tour.getDiaDanh().getTenDiaDanh();
			diaDiem.setContent("<b>Địa điểm: </b>"+diaDanh+"<br>","text/html; charset=UTF-8");
			MimeBodyPart loaiT = new MimeBodyPart();
			//String lt = tour.getLoaiTour().getTenLoaiTour();
			loaiT.setContent("<b>Loại tour: </b>"+loaiTour+"<br>","text/html; charset=UTF-8");
			MimeBodyPart ngayKhoiHanh = new MimeBodyPart();
			ngayKhoiHanh.setContent("<b>Ngày khởi hành: </b>"+tour.getNgayKhoiHanh().toString()+"<br>","text/html; charset=UTF-8");
			MimeBodyPart ngayKetThuc = new MimeBodyPart();
			ngayKetThuc.setContent("<b>Ngày kết thúc : </b>"+tour.getNgayKetThuc().toString()+"<br>","text/html; charset=UTF-8");
			MimeBodyPart diaChi = new MimeBodyPart();
			diaChi.setContent("<b>Địa chỉ: </b>"+" Số 12 Nguyễn Văn Bảo, Phường 4,Quận Gò Vấp, Thành phố Hồ Chí Minh"+"<br>","text/html; charset=UTF-8");
			MimeBodyPart soDT = new MimeBodyPart();
			soDT.setContent("<b>Điện thoại: </b>"+"0327364753"+"<br>","text/html; charset=UTF-8");
			MimeBodyPart email = new MimeBodyPart();
			email.setContent("<b>Email: </b>"+"lntvinh27122000@gmail.com"+"<br>","text/html; charset=UTF-8");			
			
			DecimalFormat formatter = new DecimalFormat("###,###,###");
			MimeBodyPart giaVe = new MimeBodyPart();
			giaVe.setContent("<b>Giá vé: </b>"+formatter.format(tour.getGiaTour())+" VNĐ"+"<br>","text/html; charset=UTF-8");
			
			
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(tinNhan);
			multipart.addBodyPart(diaDiem);
			multipart.addBodyPart(loaiT);
			multipart.addBodyPart(ngayKhoiHanh);
			multipart.addBodyPart(ngayKetThuc);
			multipart.addBodyPart(giaVe);
			multipart.addBodyPart(diaChi);
			multipart.addBodyPart(soDT);
			multipart.addBodyPart(email);
			multipart.addBodyPart(imgAttachment);
			message.setContent(multipart);
			message.setFrom(new InternetAddress("lntvinh27122000@gmail.com"));
			message.setRecipient(RecipientType.TO, new InternetAddress("vinhmasxibua@gmail.com"));
			message.setSentDate(new java.util.Date());
			
			Transport.send(message);
		} catch (Exception e2) {
			
		}
	}*/
	
	public ArrayList<SanPham> sapXepGia(String tangGiam,String giaTriSapXep){
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from SanPham order by "+ giaTriSapXep +" " + tangGiam;
			PreparedStatement preparedStatement = con.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				String maSP = rs.getString(1);
				String tenSP= rs.getString(2);
				float gia = rs.getFloat(3);
				String moTa = rs.getString(4);
				boolean trangThai = rs.getBoolean(5);
				String hinhAnh = rs.getString(6);
				LoaiSanPham loaiSP = new LoaiSanPham(rs.getString(7));
				int soLuong = rs.getInt(8);
				NhaCungCap nhaCC = new NhaCungCap(rs.getString(9));
				SanPham sanpham = new SanPham(maSP, tenSP, gia, moTa, trangThai, hinhAnh, loaiSP, soLuong, nhaCC);
				dsSP.add(sanpham);
			
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsSP;
	}
	public ArrayList<SanPham> locLoaiSP(String loaisp){
		ArrayList<SanPham> dssp = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from SanPham where maLoaiSP LIKE CONCAT('%', ?, '%') ";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, loaisp);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSP= rs.getString(2);
				float gia = rs.getFloat(3);
				String moTa = rs.getString(4);
				boolean trangThai = rs.getBoolean(5);
				String hinhAnh = rs.getString(6);
				LoaiSanPham loaiSP = new LoaiSanPham(rs.getString(7));
				int soLuong = rs.getInt(8);
				NhaCungCap nhaCC = new NhaCungCap(rs.getString(9));
				SanPham sanpham = new SanPham(maSP, tenSP, gia, moTa, trangThai, hinhAnh, loaiSP, soLuong, nhaCC);
				dssp.add(sanpham);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dssp;	
	}
}
