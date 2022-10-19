package entity;

public class LoaiNhanVien {

	private String maLoaiNV;
	private String tenLoaiNV;
	private double mucLuong;

	public LoaiNhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiNhanVien(String maLoaiNV) {
		super();
		this.maLoaiNV = maLoaiNV;
	}

	public LoaiNhanVien(String maLoaiNV, String tenLoaiNV, double mucLuong) {
		super();
		this.maLoaiNV = maLoaiNV;
		this.tenLoaiNV = tenLoaiNV;
		this.mucLuong = mucLuong;
	}

	public String getMaLoaiNV() {
		return maLoaiNV;
	}

	public void setMaLoaiNV(String maLoaiNV) {
		this.maLoaiNV = maLoaiNV;
	}

	public String getTenLoaiNV() {
		return tenLoaiNV;
	}

	public void setTenLoaiNV(String tenLoaiNV) {
		this.tenLoaiNV = tenLoaiNV;
	}

	public double getMucLuong() {
		return mucLuong;
	}

	public void setMucLuong(double mucLuong) {
		this.mucLuong = mucLuong;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoaiNV == null) ? 0 : maLoaiNV.hashCode());
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
		LoaiNhanVien other = (LoaiNhanVien) obj;
		if (maLoaiNV == null) {
			if (other.maLoaiNV != null)
				return false;
		} else if (!maLoaiNV.equals(other.maLoaiNV))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoaiNhanVien [maLoaiNV=" + maLoaiNV + ", tenLoaiNV=" + tenLoaiNV + ", mucLuong=" + mucLuong + "]";
	}

}
