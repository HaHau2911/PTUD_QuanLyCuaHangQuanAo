package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SanPham_Panel extends JPanel{

	private JPanel pnCC;

	public SanPham_Panel() {
		setBackground(Color.BLUE);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300,200));
		
		JLabel lblTenTour = new JLabel("Tên Sản Phẩm");
		JLabel lblMoTa = new JLabel("Đây là phần mô tả");
		JLabel lblGia = new JLabel("5.000.000 VND");
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton btnDatTour = new JButton("Đặt sản phẩm");
		JButton btnXem = new JButton("Xem Chi tiết sản phẩm");
		pnButton.add(btnDatTour);pnButton.add(btnXem);
		//btnSua.setPreferredSize(new Dimension(20,20));
		pnCC = new JPanel();
		pnCC.setLayout(new GridLayout(3, 1));
		pnCC.add(lblTenTour);
		pnCC.add(lblMoTa);
		pnCC.add(lblGia);
		
		add(pnCC, BorderLayout.CENTER);
		add(pnButton,BorderLayout.SOUTH);
		/*
		pnCC = new JPanel();
		pnCC.setLayout(new FlowLayout());
		
		JPanel pnTTTour = new JPanel();
		pnTTTour.setLayout(new BorderLayout());
		
		JPanel pnNorth = new JPanel();
		JLabel lblTenTour = new JLabel("Tên TOUR");
		pnNorth.add(lblTenTour);
		pnTTTour.add(pnNorth,BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		JLabel lblMoTa = new JLabel("Đây là phần mô tả");
		JLabel lblGia = new JLabel("5.000.000 VND");
		pnCenter.add(lblMoTa);
		pnNorth.add(lblGia);
		pnTTTour.add(pnCenter,BorderLayout.CENTER);
		
		JPanel pnSouth = new JPanel();
		JButton btnSua = new JButton("Đặt tour");
		JButton btnXem = new JButton("Xem Chi tiết tour");
		pnSouth.add(btnSua);
		pnSouth.add(btnXem);
		pnTTTour.add(pnSouth,BorderLayout.SOUTH);
		
		pnCC.add(pnTTTour);
		add(pnCC, BorderLayout.CENTER);*/
	}
	public static void main(String[] args) {
		SanPham_Panel sp = new SanPham_Panel();
		//ttnv.setBackground(new ImageIcon("Icon/1767.jpg"));
		sp.setVisible(true);

	}
	
}
