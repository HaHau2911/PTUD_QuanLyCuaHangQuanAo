package entity;

public class KhachHang {

	private String maKH, tenKH, email, diaChi, soDT, cmnd;
	private boolean gioiTinh;
	
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}

	
	public KhachHang(String maKH, String tenKH) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
	}
	
	

	public KhachHang(String maKH, String tenKH, String diaChi, String soDT) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.soDT = soDT;
	}

	public KhachHang(String maKH, String tenKH, String email, String diaChi, String soDT, String cmnd,
			boolean gioiTinh) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.email = email;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.cmnd = cmnd;
		this.gioiTinh = gioiTinh;
	}

	/**
	 * @return the maKH
	 */
	public String getMaKH() {
		return maKH;
	}

	/**
	 * @param maKH the maKH to set
	 */
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	/**
	 * @return the tenKH
	 */
	public String getTenKH() {
		return tenKH;
	}

	/**
	 * @param tenKH the tenKH to set
	 */
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}

	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	/**
	 * @return the soDT
	 */
	public String getSoDT() {
		return soDT;
	}

	/**
	 * @param soDT the soDT to set
	 */
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	/**
	 * @return the cmnd
	 */
	public String getCmnd() {
		return cmnd;
	}

	/**
	 * @param cmnd the cmnd to set
	 */
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	/**
	 * @return the gioiTinh
	 */
	public boolean getGioiTinh() {
		return gioiTinh;
	}

	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKH == null) ? 0 : maKH.hashCode());
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
		KhachHang other = (KhachHang) obj;
		if (maKH == null) {
			if (other.maKH != null)
				return false;
		} else if (!maKH.equals(other.maKH))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", email=" + email + ", diaChi=" + diaChi + ", soDT="
				+ soDT + ", cmnd=" + cmnd + ", gioiTinh=" + gioiTinh + "]";
	}

}
