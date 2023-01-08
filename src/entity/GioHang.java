package entity;

public class GioHang {
	private String maSanPham;
	private int soLuong;
	public GioHang() {
		super();
	}
	public GioHang(String maSanPham, int soLuong) {
		super();
		this.maSanPham = maSanPham;
		this.soLuong = soLuong;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	

}
