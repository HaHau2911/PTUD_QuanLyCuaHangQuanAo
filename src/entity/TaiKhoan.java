package entity;

public class TaiKhoan {

	private NhanVien maNV;
	private String pass;

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(NhanVien maNV, String pass) {
		super();
		this.maNV = maNV;
		this.pass = pass;
	}

	/**
	 * @return the maNV
	 */
	public NhanVien getMaNV() {
		return maNV;
	}

	/**
	 * @param maNV the maNV to set
	 */
	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
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
		TaiKhoan other = (TaiKhoan) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaiKhoan [maNV=" + maNV + ", pass=" + pass + "]";
	}

	public NhanVien getNhanVien() {
		// TODO Auto-generated method stub
		return null;
	}

}
