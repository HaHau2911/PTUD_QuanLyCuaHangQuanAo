package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DAO.HoaDon_DAO;
import DAO.SanPham_DAO;
import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.GioHang;
import entity.HoaDon;
import entity.SanPham;

public class SanPhamTrongQuanLyHoaDon extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnCC;
	private SanPham_DAO sp_dao;
	private HoaDon_DAO hd_dao;
	private SanPham sp;
	ArrayList<HoaDon> listHD;
	ArrayList<ChiTietHoaDon> listcthd;
	JButton btnDatSP, btnXem, btnTest;
	private JLabel lblHinhAnh;
	private JLabel lblSoLCon;
	GioHang gioHang;
	public SanPhamTrongQuanLyHoaDon() {
	}

	public SanPhamTrongQuanLyHoaDon(SanPham sanpham) {
		new ArrayList<GioHang>();
		setBackground(Color.BLUE);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 370));

		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sp = sanpham;
		hd_dao = new HoaDon_DAO();
		listHD = hd_dao.DanhSachHoaDontheoMaSP(sp.getMaSP());
		// Vinh - 22 - 5
		JLabel lblTenTour = new JLabel(sp.getTenSP());
		JPanel pnTenTour = new JPanel();
		pnTenTour.add(lblTenTour);
		pnTenTour.setLayout(new FlowLayout(FlowLayout.LEFT));
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		JLabel lblGia = new JLabel(String.valueOf(formatter.format(sp.getGia()) + " VNĐ"));
		JPanel pnGiaTour = new JPanel();
		pnGiaTour.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnGiaTour.add(new JLabel("Giá: "));
		pnGiaTour.add(lblGia);
		lblSoLCon = new JLabel("    Số sản phẩm còn: " + (sp.getSoLuong() - listHD.size()) + " sản phẩm");

		lblSoLCon.setForeground(Color.RED);
		pnGiaTour.add(lblSoLCon);

		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnButton.setBackground(new Color(230, 247, 255));
		btnDatSP = new JButton("Đặt hàng");
		btnTest = new JButton("1");
		btnXem = new JButton("Xem Chi tiết sản phẩm");
		pnButton.add(btnDatSP);
		pnButton.add(btnXem);
//		pnButton.add(btnTest);
		pnCC = new JPanel();
		pnCC.setLayout(new GridLayout(4, 1));
		pnCC.add(pnTenTour);
		pnCC.add(pnGiaTour);
		pnTenTour.setBackground(new Color(230, 247, 255));
		pnGiaTour.setBackground(new Color(230, 247, 255));

		lblHinhAnh = new JLabel("");
		JPanel pnHinhAnh = new JPanel();
		pnHinhAnh.setBackground(new Color(230, 247, 255));
		pnHinhAnh.add(lblHinhAnh);
		String path = sp.getHinhAnh();

		if (sp.getHinhAnh().trim().equals("")) {
			JPanel pnKhungHinhAnh = new JPanel();
			pnKhungHinhAnh.setPreferredSize(new Dimension(200, 200));
			pnKhungHinhAnh.setLayout(new BoxLayout(pnKhungHinhAnh, BoxLayout.X_AXIS));
			pnKhungHinhAnh.add(Box.createHorizontalStrut(40));
			lblHinhAnh.setText("Chưa có hình ảnh");
			pnKhungHinhAnh.add(lblHinhAnh);
			pnHinhAnh.add(pnKhungHinhAnh);
		} else {
			lblHinhAnh.setIcon(ResizeImage(path));
		}

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new GridLayout(2, 1));
		pnCenter.add(pnHinhAnh);
		pnCenter.add(pnCC);

		add(pnCenter, BorderLayout.CENTER);
		add(pnButton, BorderLayout.SOUTH);

		btnDatSP.addActionListener(this);
		btnXem.addActionListener(this);
		btnTest.addActionListener(this);
		//
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Vinh - 20-5
		Object obj = e.getSource();
		if (obj.equals(btnDatSP)) {
			String input = JOptionPane.showInputDialog("Enter number: ");
			Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
			Matcher m = p.matcher(input);
			if (m.find()) {
				JOptionPane.showMessageDialog(null, "Please enter only numbers");
			}
			int soLuong = Integer.parseInt(input);
			gioHang = new GioHang(sp.getMaSP(), soLuong);
		}

		else if (obj.equals(btnXem)) {
			new XemChiTietSanPham(sp);
		}

	}

	public ImageIcon ResizeImage(String ImagePath) {
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(290, 150, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}


	
	
	//

}
