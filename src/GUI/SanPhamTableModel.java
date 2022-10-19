package GUI;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import entity.SanPham;


public class SanPhamTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private String[] chuoi1 = {"maSP","tenSP","gia","moTa","trangThai","hinhAnh","soLuong"};
	private java.util.List<SanPham> dsSanPham = new LinkedList<>();
	public SanPhamTableModel(String[] chuoi1, java.util.List<SanPham> dsSP) {
		this.chuoi1 = chuoi1;
		this.dsSanPham = dsSP;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dsSanPham.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return chuoi1.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		SanPham sanpham = dsSanPham.get(rowIndex);
		switch (columnIndex) {
		case 0: return sanpham.getMaSP();
		case 1: return sanpham.getTenSP();
		case 2: return sanpham.getGia();
		case 3: return sanpham.getMoTa();
		case 4: return sanpham.getTrangThai();
		case 5: return sanpham.getHinhAnh();
		case 6: return sanpham.getSoLuong();
		}
		return sanpham;
	}
	//Tieu de cột cho Table
		@Override
		public String getColumnName(int column) {
			return chuoi1[column];
		}
}
