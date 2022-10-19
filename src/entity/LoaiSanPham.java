package entity;

public class LoaiSanPham {

	private String maLoaiSP, tenLoaiSP;

	public LoaiSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiSanPham(String maLoaiSP) {
		super();
		this.maLoaiSP = maLoaiSP;
	}

	
	public LoaiSanPham(String maLoaiSP, String tenLoaiSP) {
		super();
		this.maLoaiSP = maLoaiSP;
		this.tenLoaiSP = tenLoaiSP;
	}

	/**
	 * @return the maLoaiSP
	 */
	public String getMaLoaiSP() {
		return maLoaiSP;
	}

	/**
	 * @param maLoaiSP the maLoaiSP to set
	 */
	public void setMaLoaiSP(String maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}

	/**
	 * @return the tenLoaiSP
	 */
	public String getTenLoaiSP() {
		return tenLoaiSP;
	}

	/**
	 * @param tenLoaiSP the tenLoaiSP to set
	 */
	public void setTenLoaiSP(String tenLoaiSP) {
		this.tenLoaiSP = tenLoaiSP;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoaiSP == null) ? 0 : maLoaiSP.hashCode());
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
		LoaiSanPham other = (LoaiSanPham) obj;
		if (maLoaiSP == null) {
			if (other.maLoaiSP != null)
				return false;
		} else if (!maLoaiSP.equals(other.maLoaiSP))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoaiSanPham [maLoaiSP=" + maLoaiSP + ", tenLoaiSP=" + tenLoaiSP + "]";
	}

}
