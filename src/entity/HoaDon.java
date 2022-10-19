package entity;

import java.util.Date;

public class HoaDon {

	private String maHD;
	private NhanVien maNV;
	private KhachHang maKH;
	private Date ngayLap;
	private ChiTietHoaDon chitiethd;
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HoaDon(String maHD) {
		super();
		this.maHD = maHD;
	}

	public HoaDon(String maHD, ChiTietHoaDon chitiethd) {
		super();
		this.maHD = maHD;
		this.chitiethd = chitiethd;
	}
	public HoaDon(String maHD, NhanVien maNV, KhachHang maKH, Date ngayLap, ChiTietHoaDon chitiethd) {
		super();
		this.maHD = maHD;
		this.maNV = maNV;
		this.maKH = maKH;
		this.ngayLap = ngayLap;
		this.chitiethd = chitiethd;
	}
	
	
	public HoaDon(String maHD, NhanVien maNV, KhachHang maKH, Date ngayLap) {
		super();
		this.maHD = maHD;
		this.maNV = maNV;
		this.maKH = maKH;
		this.ngayLap = ngayLap;
	}

	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public NhanVien getMaNV() {
		return maNV;
	}
	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}
	public KhachHang getMaKH() {
		return maKH;
	}
	public void setMaKH(KhachHang maKH) {
		this.maKH = maKH;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public ChiTietHoaDon getChitiethd() {
		return chitiethd;
	}
	public void setChitiethd(ChiTietHoaDon chitiethd) {
		this.chitiethd = chitiethd;
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", maNV=" + maNV + ", maKH=" + maKH + ", ngayLap=" + ngayLap + ", chitiethd="
				+ chitiethd + "]";
	}

	
}
