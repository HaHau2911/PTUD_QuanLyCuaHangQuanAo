package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import DAO.NhaCungCap_DAO;
import DAO.SanPham_DAO;
import connectDB.ConnectDB;
import entity.HoaDon;
import entity.NhaCungCap;
import entity.SanPham;


public class QuanLySanPham extends JPanel implements ActionListener,KeyListener{

	public static QuanLySanPham qlSP;
	private NhaCungCap_DAO ncc_dao;
	private SanPham_DAO sp_dao;
	private HoaDon_DAO hd_dao;
	
	ArrayList<NhaCungCap> listNCC;
	ArrayList<SanPham> listSP;
	ArrayList<HoaDon> listHD;
	JPanel pnCenter;
	private JButton btnThemSP;
	private JTextField txtTim;
	private JButton btnTim;
	private JComboBox cbxtim;
	private JComboBox cbxgia;
 
	
	public QuanLySanPham() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 qlSP = this;

		ncc_dao = new NhaCungCap_DAO();
		sp_dao = new SanPham_DAO();
		hd_dao = new HoaDon_DAO();
		
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
		btnThemSP = new JButton("Thêm");
		cbxtim = new JComboBox<>();
		cbxtim.addItem("Lọc theo loại sản phẩm");
		cbxtim.addItem("Áo Khoác");
		cbxtim.addItem("Áo Thun");
		cbxtim.addItem("Áo Sơ Mi");
		cbxtim.addItem("Quần Jeans");
		cbxtim.addItem("Quần Tây");
		cbxtim.addItem("Quần Short");
		cbxtim.addItem("Váy");
		cbxtim.addItem("Chân Váy");
		cbxtim.addItem("Quần Thun");
		/* cbxgia = new JComboBox<>();
		cbxgia.addItem("Sắp xếp theo giá");
		cbxgia.addItem("Giá cao nhất");
		cbxgia.addItem("Giá thấp nhất"); */
		//pnThem.add(cbxgia);
		pnThem.add(cbxtim);
		pnThem.add(btnThemSP);
		
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
		TaiSPLen();
		
		btnThemSP.addActionListener(this);
		btnTim.addActionListener(this);
		txtTim.addKeyListener(this);
		cbxtim.addActionListener(this);
		//cbxgia.addActionListener(this);
		
		
	}
	
	
	public void TaiSPLen() {
		pnCenter.removeAll();
		pnCenter.revalidate();
		try {  
			listSP = sp_dao.LayHetSP(); 
			for(SanPham sp : listSP) { 
				JPanel pnItem = new SanPhamTrongQuanLySanPham(sp); 
				pnCenter.add(pnItem); 
				

			}
			pnCenter.revalidate();		 
		 } catch (Exception e2) { // TODO: handle exception
		 JOptionPane.showMessageDialog(this, e2); }
	}
	
	//Vinh -28-5
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
		Object obj = e.getSource();
		if(obj.equals(btnThemSP)) {
			new NhapSuaThongTinSanPham(new SanPham(),1);
		}
		else if(obj.equals(btnTim)) {
			ArrayList<SanPham> sanphamTimDuoc = sp_dao.TimSP(txtTim.getText().toString().trim().toLowerCase(),true);
			if(sanphamTimDuoc.size()==0)
			{
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}
			else {
				TaiSPTimKiem(sanphamTimDuoc);
			}
		}
		/* else if(obj.equals(cbxgia)) {
			pnCenter.removeAll();
			pnCenter.revalidate();
			if(cbxgia.getSelectedItem()=="Sắp xếp theo giá")	{
			try {  
				listSP = sp_dao.getalltbSanPham(); 
				for(SanPham sanpham : listSP) { 
					JPanel pnItem = new SanPhamTrongQuanLySanPham(sanpham);
					pnCenter.add(pnItem); 
					

				}
				pnCenter.revalidate();		 
			 } catch (Exception e2) { // TODO: handle exception
			 JOptionPane.showMessageDialog(this, e2); }
			}
			if(cbxgia.getSelectedItem()=="Giá cao nhất")	{
				try {  
					listSP = sp_dao.sapXepGia("desc","giaTour"); 
					for(SanPham sp : listSP) { 
						JPanel pnItem = new SanPhamTrongQuanLySanPham(sp); 
						pnCenter.add(pnItem); 
						

					}
					pnCenter.revalidate();		 
				 } catch (Exception e2) { // TODO: handle exception
				 JOptionPane.showMessageDialog(this, e2); }
				}
			if(cbxgia.getSelectedItem()=="Giá thấp nhất")	{
				try {  
					listSP = sp_dao.sapXepGia("asc","giaTour"); 
					for(SanPham sp : listSP) { 
						JPanel pnItem = new SanPhamTrongQuanLySanPham(sp); 
						pnCenter.add(pnItem); 
						

					}
					pnCenter.revalidate();		 
				 } catch (Exception e2) { // TODO: handle exception
				 JOptionPane.showMessageDialog(this, e2); }
				}
			
		} */
		else if(obj.equals(cbxtim)) {
				listSP = sp_dao.locLoaiSP((String) cbxtim.getSelectedItem());	
				pnCenter.removeAll();
				pnCenter.revalidate();
				if(((String) cbxtim.getSelectedItem() == "Lọc theo loại sản phẩm")) {
					try {  
						listSP = sp_dao.getalltbSanPham(); 
						for(SanPham sp : listSP) { 
							JPanel pnItem = new SanPhamTrongQuanLySanPham(sp); 
							pnCenter.add(pnItem); 
							

						}
						pnCenter.revalidate();		 
					 } catch (Exception e2) { // TODO: handle exception
					 JOptionPane.showMessageDialog(this, e2); }
				}
				if(((String) cbxtim.getSelectedItem() == "Áo Khoác")) {
					try {  
						listSP = sp_dao.locLoaiSP("LSP01"); 
						for(SanPham sanpham : listSP) { 
							JPanel pnItem = new SanPhamTrongQuanLySanPham(sanpham); 
							pnCenter.add(pnItem); 
							
						}
						pnCenter.revalidate();		 
					 } catch (Exception e2) { // TODO: handle exception
					 JOptionPane.showMessageDialog(this, e2); }
				}
				if(((String) cbxtim.getSelectedItem() == "Áo Thun")) {
					try {  
						listSP = sp_dao.locLoaiSP("LSP02"); 
						for(SanPham sanpham : listSP) { 
							JPanel pnItem = new SanPhamTrongQuanLySanPham(sanpham); 
							pnCenter.add(pnItem); 
							
						}
						pnCenter.revalidate();		 
					 } catch (Exception e2) { // TODO: handle exception
					 JOptionPane.showMessageDialog(this, e2); }
				}
				if(((String) cbxtim.getSelectedItem() == "Áo Sơ Mi")) {
					try {  
						listSP = sp_dao.locLoaiSP("LSP03"); 
						for(SanPham sanpham : listSP) { 
							JPanel pnItem = new SanPhamTrongQuanLySanPham(sanpham); 
							pnCenter.add(pnItem); 
							
						}
						pnCenter.revalidate();		 
					 } catch (Exception e2) { // TODO: handle exception
					 JOptionPane.showMessageDialog(this, e2); }
				}
				if(((String) cbxtim.getSelectedItem() == "Quần Jeans")) {
					try {  
						listSP = sp_dao.locLoaiSP("LSP04"); 
						for(SanPham sanpham : listSP) { 
							JPanel pnItem = new SanPhamTrongQuanLySanPham(sanpham); 
							pnCenter.add(pnItem); 
							
						}
						pnCenter.revalidate();		 
					 } catch (Exception e2) { // TODO: handle exception
					 JOptionPane.showMessageDialog(this, e2); }
				}
				if(((String) cbxtim.getSelectedItem() == "Quần Tây")) {
					try {  
						listSP = sp_dao.locLoaiSP("LSP05"); 
						for(SanPham sanpham : listSP) { 
							JPanel pnItem = new SanPhamTrongQuanLySanPham(sanpham); 
							pnCenter.add(pnItem); 
							
						}
						pnCenter.revalidate();		 
					 } catch (Exception e2) { // TODO: handle exception
					 JOptionPane.showMessageDialog(this, e2); }
				}
				if(((String) cbxtim.getSelectedItem() == "Quần Short")) {
					try {  
						listSP = sp_dao.locLoaiSP("LSP06"); 
						for(SanPham sanpham : listSP) { 
							JPanel pnItem = new SanPhamTrongQuanLySanPham(sanpham); 
							pnCenter.add(pnItem); 
							
						}
						pnCenter.revalidate();		 
					 } catch (Exception e2) { // TODO: handle exception
					 JOptionPane.showMessageDialog(this, e2); }
				}
				if(((String) cbxtim.getSelectedItem() == "Váy")) {
					try {  
						listSP = sp_dao.locLoaiSP("LSP07"); 
						for(SanPham sanpham : listSP) { 
							JPanel pnItem = new SanPhamTrongQuanLySanPham(sanpham); 
							pnCenter.add(pnItem); 
							
						}
						pnCenter.revalidate();		 
					 } catch (Exception e2) { // TODO: handle exception
					 JOptionPane.showMessageDialog(this, e2); }
				}
				if(((String) cbxtim.getSelectedItem() == "Chân Váy")) {
					try {  
						listSP = sp_dao.locLoaiSP("LSP08"); 
						for(SanPham sanpham : listSP) { 
							JPanel pnItem = new SanPhamTrongQuanLySanPham(sanpham); 
							pnCenter.add(pnItem); 
							
						}
						pnCenter.revalidate();		 
					 } catch (Exception e2) { // TODO: handle exception
					 JOptionPane.showMessageDialog(this, e2); }
				}
				if(((String) cbxtim.getSelectedItem() == "Quần Thun")) {
					try {  
						listSP = sp_dao.locLoaiSP("LSP09"); 
						for(SanPham sanpham : listSP) { 
							JPanel pnItem = new SanPhamTrongQuanLySanPham(sanpham); 
							pnCenter.add(pnItem); 
							
						}
						pnCenter.revalidate();		 
					 } catch (Exception e2) { // TODO: handle exception
					 JOptionPane.showMessageDialog(this, e2); }
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
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			ArrayList<SanPham> sanphamTimDuoc = sp_dao.TimSP(txtTim.getText().toString().trim().toLowerCase(),true);	
			if(listSP.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy tên tour");
			}
			else {
				TaiSPTimKiem(sanphamTimDuoc);
			}
		}
	}
}
