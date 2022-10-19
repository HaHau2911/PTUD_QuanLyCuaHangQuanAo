package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

public class TaiKhoan_DAO {

	private ArrayList<TaiKhoan> listTaiKhoan;
	TaiKhoan tk;

	public ArrayList<TaiKhoan> docTuBang() {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {

				NhanVien maNV = null;
				String pass;

				pass = rs.getString(2);
				TaiKhoan tk = new TaiKhoan(maNV, pass);
				listTaiKhoan.add(tk);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listTaiKhoan;
	}

	public TaiKhoan Login(String username, String password) {
		Connection con = ConnectDB.getConnection();
		String sql = "select * from TaiKhoan where maNV = ? and pass = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				TaiKhoan tk = new TaiKhoan(new NhanVien(rs.getString(1)), rs.getString(2));
				return tk;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
	}

	public boolean create(TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into TaiKhoan values (?,?)");
			stmt.setString(1, tk.getNhanVien().getMaNV());
			stmt.setString(2, tk.getPass());

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return n > 0;
	}

	public boolean delete(String ID) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from TaiKhoan where maNV = ?");
			stmt.setString(1, ID);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean Update(String maNV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update TaiKhoan set matKhau = '123456' where maNV = ?");
			stmt.setString(1, maNV);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

}
