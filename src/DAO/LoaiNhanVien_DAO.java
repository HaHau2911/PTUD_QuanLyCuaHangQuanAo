package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiNhanVien;

public class LoaiNhanVien_DAO {

	public ArrayList<LoaiNhanVien> layHetLoaiNhanVien() {
		ArrayList<LoaiNhanVien> dsLoaiNhanVien = new ArrayList<LoaiNhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from LoaiNhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maLoaiNV = rs.getString(1);
				String tenLoaiNV = rs.getString(2);
				double mucLuong = rs.getDouble(3);
				LoaiNhanVien loaiNhanVien = new LoaiNhanVien(maLoaiNV, tenLoaiNV, mucLuong);
				dsLoaiNhanVien.add(loaiNhanVien);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLoaiNhanVien;
	}
}
