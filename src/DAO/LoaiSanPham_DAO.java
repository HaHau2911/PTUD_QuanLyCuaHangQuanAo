package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiSanPham;

public class LoaiSanPham_DAO {

	public ArrayList<LoaiSanPham> layHetLoaiSanPham() {
		ArrayList<LoaiSanPham> dsLoaiSanPham = new ArrayList<LoaiSanPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from LoaiSanPham";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maLoaiSP = rs.getString(1);
				String tenLoaiSP = rs.getString(2);
				LoaiSanPham loaiSanPham = new LoaiSanPham(maLoaiSP, tenLoaiSP);
				dsLoaiSanPham.add(loaiSanPham);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLoaiSanPham;
	}

}
