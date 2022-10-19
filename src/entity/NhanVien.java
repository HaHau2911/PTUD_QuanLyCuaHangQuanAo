package entity;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private String email;
	private String diaChi;
	private String soDT;
	private String cmnd;
	private boolean trangThai;
	private boolean gioiTinh;
	private LoaiNhanVien loaiNV;

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}
	

	public NhanVien(String maNV, String tenNV) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
	}

	public NhanVien(String maNV, String tenNV, String email, String diaChi, String soDT, String cmnd, boolean trangThai,
			boolean gioiTinh) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.email = email;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.cmnd = cmnd;
		this.trangThai = trangThai;
		this.gioiTinh = gioiTinh;
	}

	public NhanVien(String maNV, String tenNV, String email, String diaChi, String soDT, String cmnd, boolean trangThai,
			boolean gioiTinh, LoaiNhanVien loaiNV) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.email = email;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.cmnd = cmnd;
		this.trangThai = trangThai;
		this.gioiTinh = gioiTinh;
		this.loaiNV = loaiNV;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public LoaiNhanVien getLoaiNV() {
		return loaiNV;
	}

	public void setLoaiNV(LoaiNhanVien loaiNV) {
		this.loaiNV = loaiNV;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", email=" + email + ", diaChi=" + diaChi + ", soDT="
				+ soDT + ", cmnd=" + cmnd + ", trangThai=" + trangThai + ", gioiTinh=" + gioiTinh + ", loaiNV=" + loaiNV
				+ "]";
	}

}
