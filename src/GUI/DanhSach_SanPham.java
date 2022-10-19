package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import DAO.HoaDon_DAO;
import DAO.LoaiSanPham_DAO;
import DAO.NhaCungCap_DAO;
import DAO.SanPham_DAO;
import connectDB.ConnectDB;
import entity.HoaDon;
import entity.LoaiSanPham;
import entity.NhaCungCap;
import entity.SanPham;


public class DanhSach_SanPham extends JPanel implements ActionListener,KeyListener{

	public static DanhSach_SanPham qlSP;
	private NhaCungCap_DAO ncc_dao;
	private SanPham_DAO sp_dao;
	private HoaDon_DAO hd_dao;
	
	ArrayList<NhaCungCap> listNCC;
	ArrayList<SanPham> listSP;
	ArrayList<HoaDon> listHD;
	JPanel pnCenter;
	private JButton btnLoc;
	private JTextField txtTim;
	private JButton btnTim;
	private JComboBox cbxtim;
	private JComboBox cbxgia;
	private JComboBox cbxNCC;
	private LoaiSanPham_DAO loaisp_dao;
 
	
	public DanhSach_SanPham() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 qlSP = this;

		ncc_dao = new NhaCungCap_DAO();
		sp_dao = new SanPham_DAO();
		hd_dao = new HoaDon_DAO();
		loaisp_dao= new LoaiSanPham_DAO();
		
		setLayout(new BorderLayout());
		JTextField txtNhap = new JTextField(15);
		pnCenter = new JPanel();
		pnCenter.setLayout(new WrapLayout());
		pnCenter.setBackground(Color.white);
		JPanel pnTab1 = new JPanel();
		pnTab1.setLayout(new BorderLayout());
		JPanel pnTim = new JPanel();
		pnTim.setBackground(Color.white);
		JLabel lblTim = new JLabel("Tìm kiếm");
		lblTim.setIcon(new ImageIcon("Icon/find1.png"));
		txtTim = new JTextField(25);
		btnTim = new JButton("Tìm kiếm");
		pnTim.add(lblTim);
		pnTim.add(txtTim);
		pnTim.add(btnTim);
		//Vinh - 2-6
		JPanel pnThem = new JPanel();
		pnThem.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnThem.setBackground(Color.white);
		btnLoc = new JButton("Lọc");
		cbxtim = new JComboBox<>();
		
		cbxtim.addItem("Lọc theo loại sản phẩm");
		for(LoaiSanPham lsp: loaisp_dao.layHetLoaiSanPham()) {
			cbxtim.addItem(lsp.getTenLoaiSP());
		}
		
		cbxgia = new JComboBox<>();
		cbxgia.addItem("Sắp xếp theo giá");
		cbxgia.addItem("Giá cao nhất");
		cbxgia.addItem("Giá thấp nhất");
		
		cbxNCC = new JComboBox<>();
		cbxNCC.addItem("Lọc theo địa danh");
		for(NhaCungCap ncc: ncc_dao.getalltbNCC()) {
			cbxNCC.addItem(ncc.getTenNCC());
		}
		//pnThem.add(cbxgia);
		pnThem.add(cbxNCC);
		//pnThem.add(cbxtim);
		pnThem.add(btnLoc);
		
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BorderLayout());
		pnNorth.add(pnTim,BorderLayout.CENTER);
		pnNorth.add(pnThem,BorderLayout.EAST);
		pnTab1.add(pnNorth,BorderLayout.NORTH);
		JScrollPane jsc1 = new JScrollPane(pnTab1);
		pnTab1.add(pnCenter,BorderLayout.CENTER);
		Border borderSP = BorderFactory.createLineBorder(Color.GRAY);
		pnTab1.setBorder(borderSP);
		add(jsc1,BorderLayout.CENTER);
		//
		TaiTourLen();
		
		btnLoc.addActionListener(this);
		btnTim.addActionListener(this);
		txtTim.addKeyListener(this);
		cbxtim.addActionListener(this);
		cbxgia.addActionListener(this);
		
		
	}
	
	
	public void TaiTourLen() {
		pnCenter.removeAll();
		pnCenter.revalidate();
		try {  
			listSP = sp_dao.DSTCoTheMua(ABORT); 
			for(SanPham sanpham : listSP) { 
				JPanel pnItem = new SanPhamTrongQuanLyHoaDon(sanpham); 
				pnCenter.add(pnItem); 
			}
			pnCenter.revalidate();		 
		 } catch (Exception e2) { // TODO: handle exception
		 JOptionPane.showMessageDialog(this, e2); }
	}
	
	
		private void TaiSPTimKiem(ArrayList<SanPham> sanphamTimDuoc) {
			pnCenter.removeAll();
			 pnCenter.revalidate();
			for (SanPham sanpham : sanphamTimDuoc) {
				JPanel pnItem = new SanPhamTrongQuanLyHoaDon(sanpham); 
				pnCenter.add(pnItem);  
				pnCenter.revalidate();
			}
			
		}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o= e.getSource();
		if(o.equals(btnTim)) {
			ArrayList<SanPham> sanphamTimDuoc = sp_dao.TimSP(txtTim.getText().toString().trim().toLowerCase(),false);
			if(sanphamTimDuoc.size()==0)
			{
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}
			else {
				TaiSPTimKiem(sanphamTimDuoc);
			}	
			
		}else if(o.equals(btnLoc)) {
			String mancc=cbxNCC.getSelectedItem().toString();
			String malsp=cbxtim.getSelectedItem().toString();
			ArrayList<SanPham> tourTimDuoc = sp_dao.TimSP(mancc,false);
			
			if(tourTimDuoc.size()==0)
			{
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}
			else {
				TaiSPTimKiem(tourTimDuoc);
			}	
		}
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
