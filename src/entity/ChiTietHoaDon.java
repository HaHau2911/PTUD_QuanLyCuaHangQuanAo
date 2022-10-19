package entity;

public class ChiTietHoaDon {

	private SanPham maSP;
	private int soLuong;

	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon( SanPham maSP, int soLuong) {
		super();
		this.maSP = maSP;
		this.soLuong = soLuong;
	}

	
	public ChiTietHoaDon(SanPham maSP) {
		super();
		this.maSP = maSP;
	}
	/**
	 * @return the maSP
	 */
	public SanPham getMaSP() {
		return maSP;
	}

	/**
	 * @param maSP the maSP to set
	 */
	public void setMaSP(SanPham maSP) {
		this.maSP = maSP;
	}

	/**
	 * @return the soLuong
	 */
	public int getSoLuong() {
		return soLuong;
	}

	/**
	 * @param soLuong the soLuong to set
	 */
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}



	@Override
	public String toString() {
		return "ChiTietHoaDon [maSP=" + maSP + ", soLuong=" + soLuong 
				+ "]";
	}

}
