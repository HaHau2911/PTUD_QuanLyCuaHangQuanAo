package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAO.HoaDon_DAO;
import DAO.SanPham_DAO;
import DAO.ThongKe_DAO;
import connectDB.ConnectDB;
import entity.HoaDon;
import entity.NhaCungCap;



public class QuanLyThongKe extends JPanel implements ActionListener{

	private JDateChooser jdcKH;
	private JDateChooser jdcKT;
	
	private DefaultTableModel modeltable;
	private JTable table;
	JLabel lblKH, lblKT, lblThongKeHoaDon, lblThongKeDT;
	JButton btnThongKe;
	private SanPham_DAO sp_Dao;
	private ThongKe_DAO tk_dao;
	ArrayList<HoaDon> listHoadon;
	HoaDon_DAO hd_dao;
	SanPham_DAO sanpham;
	LocalDate tn;
	String ngayLap;
	String tuNgay;
	String denNgay;
	private JLabel lblNL;
	private JDateChooser jdcNL;
	private JButton btnLoad;
	public QuanLyThongKe() throws Exception {

		tk_dao = new ThongKe_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		setLayout(new BorderLayout());
//		JPanel pnNorth = new JPanel();
		Box b = Box.createVerticalBox();
		Box b1,b2,b3;
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		JPanel pnNorth1 = new JPanel();
		JLabel lblTieuDe = new JLabel("Quản Lý Thống kê");
		Font font = new Font("Arial", Font.BOLD, 25);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		b3.add(lblTieuDe);
//		add(pnNorth, BorderLayout.NORTH);

//		JTabbedPane tab = new JTabbedPane();
//		JPanel pnTab2 = new JPanel();
//		JPanel pnTab3 = new JPanel();
//		add(tab, BorderLayout.CENTER);

		
		
		JPanel pnKH = new JPanel();
		JPanel pnKT = new JPanel();
		JPanel pnSouth = new JPanel();
		JPanel pnVe = new JPanel();
		JPanel pnDT = new JPanel();
		jdcKH = new JDateChooser();
		jdcKH.setDateFormatString("dd-MM-yyyy");
		// add(pnTab1,BorderLayout.NORTH);
		//tab.add(pnTab2, "Thống kê địa danh có nhiều tham quan nhất");
		//pnTab2.setBackground(Color.BLUE);

		//tab.add(pnTab3, "Thống kê Tour theo địa danh");
		//pnTab3.setBackground(Color.RED);
		
		pnVe.add(lblThongKeHoaDon = new JLabel("Tổng hoá đơn là: "));
		lblThongKeHoaDon.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblThongKeHoaDon.setForeground(Color.RED);
		pnDT.add(lblThongKeDT = new JLabel("Tổng doanh thu là:"));
		lblThongKeDT.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblThongKeDT.setForeground(Color.RED);
		lblThongKeHoaDon.setPreferredSize(lblThongKeDT.getPreferredSize());
		Box bb = Box.createVerticalBox();
		bb.add(pnVe);
		bb.add(pnDT);
		pnNorth1.add(bb);
//		add(pnNorth1, BorderLayout.NORTH);
		// Phần North
		pnKH.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnKH.add(lblKH = new JLabel("Từ ngày:"));
		lblKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKH.setForeground(Color.BLUE);
		pnKH.add(jdcKH = new JDateChooser());
		
		jdcKH.setPreferredSize(new Dimension(150, 20));
		pnKH.add(lblKT = new JLabel("Đến ngày:"));
		lblKT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKT.setForeground(Color.BLUE);
		pnKH.add(jdcKT = new JDateChooser());
		jdcKT.setPreferredSize(new Dimension(150, 20));
//		pnKH.add(btnThongKe = new JButton("Thống kê"));
//		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 15));
//		btnThongKe.setForeground(Color.BLUE);
//		btnThongKe.setIcon(new ImageIcon("Icon/IconThongKe.jpg"));
//		btnThongKe.setPreferredSize(new Dimension(150,32));
//		
		pnKT.add(btnThongKe = new JButton("Thống kê"));
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThongKe.setForeground(Color.BLUE);
		btnThongKe.setIcon(new ImageIcon("Icon/IconThongKe.jpg"));
		btnThongKe.setPreferredSize(new Dimension(150,32));
		
		
//		pnKT.setLayout(new FlowLayout(FlowLayout.LEFT));
//		pnKT.add(lblKT = new JLabel("Đến ngày:"));
//		lblKT.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblKT.setForeground(Color.BLUE);
//		pnKT.add(jdcKT = new JDateChooser());
//		jdcKT.setPreferredSize(new Dimension(150, 20));
		pnKT.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnKT.add(btnLoad = new JButton("Hiện thị lại thông tin"));
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLoad.setForeground(Color.BLUE);
		btnLoad.setIcon(new ImageIcon("Icon/Load.png"));
		btnLoad.setPreferredSize(new Dimension(220,32));
		lblKH.setPreferredSize(lblKT.getPreferredSize());
		

		b1.add(pnKH);
		b2.add(pnKT);
		b.add(b3);
		b.add(b1);
		b.add(b2);
		b.add(bb);
		pnNorth1.add(b);
		add(pnNorth1, BorderLayout.NORTH);
		
		// Phần South
//		pnVe.add(lblThongKeVe = new JLabel("Tổng số vé là: "));
//		lblThongKeVe.setFont(new Font("Tahoma", Font.BOLD, 17));
//		lblThongKeVe.setForeground(Color.RED);
//		pnDT.add(lblThongKeDT = new JLabel("Tổng doanh thu là:"));
//		lblThongKeDT.setFont(new Font("Tahoma", Font.BOLD, 17));
//		lblThongKeDT.setForeground(Color.RED);
//		lblThongKeVe.setPreferredSize(lblThongKeDT.getPreferredSize());
//		Box bb = Box.createVerticalBox();
//		bb.add(pnVe);
//		bb.add(pnDT);
//		pnSouth.add(bb);
//		add(pnSouth, BorderLayout.SOUTH);
		
		// Phần Center
		String[] cols = {"Mã hoá đơn", "mã nhân viên","mã khách hàng","ngày lập","giá"};
		modeltable = new DefaultTableModel(cols, 0);
		table = new JTable(modeltable);
		JScrollPane sc = new JScrollPane(table);
		add(sc, BorderLayout.CENTER);
		
		btnThongKe.addActionListener(this);
		btnLoad.addActionListener(this);
		
		loadHoaDon();
	}
	public void loadHoaDon(){
		listHoadon	= tk_dao.getallHoaDon();
		for(HoaDon hd : listHoadon) {
			modeltable.addRow(new Object[] {hd.getMaHD(), hd.getMaNV().getMaNV(),hd.getMaKH().getMaKH(),hd.getNgayLap(),tk_dao.getGiaHD(hd.getMaHD())					
			});		
		}

	}
	public void loadTK() throws SQLException {
		modeltable.setRowCount(0);
		table.removeAll();
		listHoadon	= tk_dao.thongKeTheoNgay(tuNgay, denNgay);
		for(HoaDon hd : listHoadon) {
			modeltable.addRow(new Object[] {hd.getMaHD(), hd.getMaNV().getMaNV(),hd.getMaKH().getMaKH(),hd.getNgayLap(),tk_dao.getGiaHD(hd.getMaHD())
					 // sá»­a hÃ ng nÃ y
			});
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThongKe)) {
			
			SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
			tuNgay = "";
			denNgay = "";
			tuNgay = dcn.format(jdcKH.getDate());
			denNgay= dcn.format(jdcKT.getDate());
			lblThongKeHoaDon.setText("Số hoá đơn: " + String.valueOf(tk_dao.SoLuongTheoNgay(tuNgay,denNgay)) );
			lblThongKeDT.setText("Tổng doanh thu là: " + String.valueOf(tk_dao.TongDTtheoNgayChon(tuNgay,denNgay)) + " VND");
			try {
				loadTK();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		else if(o.equals(btnLoad)) {
			

			loadHoaDon();
			lblThongKeHoaDon.setText("Tống hoá đơn là: " + 0 );
			lblThongKeDT.setText("Tổng doanh thu là: " + 0);
		}
		

		
	}
}
