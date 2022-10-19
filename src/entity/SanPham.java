package entity;

public class SanPham {

	private String maSP, tenSP, moTa, hinhAnh;
	private boolean trangThai;
	private float gia;
	private LoaiSanPham loaiSP;
	private int soLuong;
	private NhaCungCap maNCC;

	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanPham(String maSP) {
		super();
		this.maSP = maSP;
	}

	
	
	public SanPham(String tenSP, float gia) {
		super();
		this.tenSP = tenSP;
		this.gia = gia;
	}

	
	
	public SanPham(LoaiSanPham loaiSP) {
		super();
		this.loaiSP = loaiSP;
	}

	public SanPham(float gia) {
		super();
		this.gia = gia;
	}

	public SanPham(float gia, LoaiSanPham loaiSP) {
		super();
		this.gia = gia;
		this.loaiSP = loaiSP;
	}

	public SanPham(String maSP, String tenSP, float gia) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.gia = gia;
	}

	public SanPham(String maSP, String tenSP,float gia, String moTa, boolean trangThai, String hinhAnh,
			LoaiSanPham loaiSP, int soLuong, NhaCungCap maNCC) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.gia = gia;
		this.moTa = moTa;
		this.trangThai = trangThai;
		this.hinhAnh = hinhAnh;
		this.loaiSP = loaiSP;
		this.soLuong = soLuong;
		this.maNCC = maNCC;
	}

	/**
	 * @return the maSP
	 */
	public String getMaSP() {
		return maSP;
	}

	/**
	 * @param maSP the maSP to set
	 */
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	/**
	 * @return the tenSP
	 */
	public String getTenSP() {
		return tenSP;
	}

	/**
	 * @param tenSP the tenSP to set
	 */
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	/**
	 * @return the moTa
	 */
	public String getMoTa() {
		return moTa;
	}

	/**
	 * @param moTa the moTa to set
	 */
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	/**
	 * @return the trangThai
	 */
	public boolean getTrangThai() {
		return trangThai;
	}

	/**
	 * @param trangThai the trangThai to set
	 */
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	/**
	 * @return the hinhAnh
	 */
	public String getHinhAnh() {
		return hinhAnh;
	}

	/**
	 * @param hinhAnh the hinhAnh to set
	 */
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	/**
	 * @return the gia
	 */
	public float getGia() {
		return gia;
	}

	/**
	 * @param gia the gia to set
	 */
	public void setGia(float gia) {
		this.gia = gia;
	}

	/**
	 * @return the loaiSP
	 */
	public LoaiSanPham getLoaiSP() {
		return loaiSP;
	}

	/**
	 * @param loaiSP the loaiSP to set
	 */
	public void setLoaiSP(LoaiSanPham loaiSP) {
		this.loaiSP = loaiSP;
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

	/**
	 * @return the maNCC
	 */
	public NhaCungCap getMaNCC() {
		return maNCC;
	}

	/**
	 * @param maNCC the maNCC to set
	 */
	public void setMaNCC(NhaCungCap maNCC) {
		this.maNCC = maNCC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSP == null) ? 0 : maSP.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		if (maSP == null) {
			if (other.maSP != null)
				return false;
		} else if (!maSP.equals(other.maSP))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", moTa=" + moTa + ", trangThai=" + trangThai
				+ ", hinhAnh=" + hinhAnh + ", gia=" + gia + ", loaiSP=" + loaiSP + ", soLuong=" + soLuong + ", maNCC="
				+ maNCC + "]";
	}

}
