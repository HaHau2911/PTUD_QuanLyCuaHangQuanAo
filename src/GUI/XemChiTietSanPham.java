package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import DAO.HoaDon_DAO;
import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.SanPham;

public class XemChiTietSanPham extends JFrame{

	private static SanPham sp;
	JLabel lblHinhAnh;
	private HoaDon_DAO hd_dao;
	private ArrayList<HoaDon> listHD;
	public XemChiTietSanPham(SanPham sanpham) {
		setTitle("Chi tiết Sản Phẩm");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		setSize(700,700);
		setLocationRelativeTo(null);
		setVisible(true);
		
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sp = sanpham;
		hd_dao = new HoaDon_DAO();
		listHD = hd_dao.DanhSachHoaDontheoMaSP(sp.getMaSP());
		
		lblHinhAnh = new JLabel("");
		JPanel pnHinhAnh = new JPanel();
		pnHinhAnh.add(lblHinhAnh);
		lblHinhAnh.setPreferredSize(new Dimension(700,280));
		//lblHinhAnh.setBackground(Color.BLACK);
		String path = sp.getHinhAnh();
		lblHinhAnh.setIcon(ResizeImage(path));
		add(pnHinhAnh, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new GridLayout(2,1));
		
		JLabel lblTenSP = new JLabel(sp.getTenSP());
		
		lblTenSP.setFont(new Font("Time New Roman",Font.BOLD+Font.ITALIC, 32));
		lblTenSP.setForeground(Color.BLUE);
		JPanel pnTenSP = new JPanel();
		pnTenSP.add(lblTenSP);
		
		JLabel lblGia = new JLabel("Giá:");
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		JLabel lblGiaTour = new JLabel(String.valueOf(formatter.format(sp.getGia())+" VNĐ"));
		JPanel pnGia = new JPanel();
		pnGia.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnGia.add(lblGia);
		pnGia.add(lblGiaTour);
		JPanel pnGiaGrid = new JPanel();
		pnGiaGrid.setLayout(new GridLayout(1,2));
		pnGiaGrid.add(pnGia);
		//pnGiaGrid.add(lblGiaTour);

		JLabel lblSoLuongToiDa = new JLabel("Số lượng tối đa:");
		JLabel lblSoLuongTD = new JLabel(String.valueOf(sp.getSoLuong()));//Khai báo để hiển thị số
		JPanel pnSoLuongToiDa = new JPanel();
		pnSoLuongToiDa.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnSoLuongToiDa.add(lblSoLuongToiDa);
		pnSoLuongToiDa.add(lblSoLuongTD);
		
		JLabel lblSoLuong = new JLabel("Số lượng đã mua:"); //Khai báo để hiển thị chữ
		JLabel lblSoLuongDaDat = new JLabel(String.valueOf(listHD.size()) );// khai báo để hiển thị số
		JPanel pnSoLuongDaDat = new JPanel();
		pnSoLuongDaDat.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnSoLuongDaDat.add(lblSoLuong);
		pnSoLuongDaDat.add(lblSoLuongDaDat);
		JPanel pnSoLuong = new JPanel();
		pnSoLuong.setLayout(new GridLayout(1,2));
		pnSoLuong.add(pnSoLuongDaDat);
		pnSoLuong.add(pnSoLuongToiDa);
		
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setLayout(new GridLayout(3,1));
		pnCenter.add(pnTenSP);
		pnThongTin.add(pnGiaGrid);
		pnThongTin.add(pnSoLuong);
		
		JTextArea taMoTa = new JTextArea();
		//taMoTa.setPreferredSize(new Dimension(600,200));
		//taMoTa.setBackground(Color.BLUE);	
		//taMoTa.setTabSize(300);
		taMoTa.setEditable(false);
		taMoTa.setLineWrap(true);
		taMoTa.setText(sp.getMoTa());
		//taMoTa.setBackground(Color.MAGENTA);
		taMoTa.setWrapStyleWord(true);
		JScrollPane scrMoTa = new JScrollPane(taMoTa);
		taMoTa.setFont(new Font("Time New Roman", Font.PLAIN, 22));
		JPanel pnMoTa = new JPanel();
		pnMoTa.setLayout(new BorderLayout());
		pnMoTa.add(scrMoTa, BorderLayout.CENTER);
		pnMoTa.setPreferredSize(new Dimension(700,200));
		
		pnCenter.add(pnThongTin);
		
		add(pnCenter, BorderLayout.CENTER);
		add(pnMoTa, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		

	}
	public ImageIcon ResizeImage(String ImagePath)
	 {
		 ImageIcon MyImage = new ImageIcon(ImagePath);
		 Image img = MyImage.getImage();
		 Image newImg = img.getScaledInstance(700, 280, Image.SCALE_SMOOTH);
		 ImageIcon image = new ImageIcon(newImg);
	     return image;
	 }
}
