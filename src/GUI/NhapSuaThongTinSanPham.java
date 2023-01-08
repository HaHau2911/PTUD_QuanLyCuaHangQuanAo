package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import DAO.HoaDon_DAO;
import DAO.LoaiSanPham_DAO;
import DAO.NhaCungCap_DAO;
import DAO.NhanVien_DAO;
import DAO.SanPham_DAO;
import connectDB.ConnectDB;
import entity.HoaDon;
import entity.LoaiSanPham;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.SanPham;


public class NhapSuaThongTinSanPham extends JFrame implements ActionListener, ItemListener{

	private static final long serialVersionUID = 1L;
	private static SanPham t;
	JLabel lblHinhAnh;
	private HoaDon_DAO hd_dao;
	private NhaCungCap_DAO nhacungcap_dao;
	private LoaiSanPham_DAO loaiSP_dao;
	private SanPham_DAO sp_dao;
	private NhanVien_DAO nv_dao;
	private JButton btnChonAnh;
	private JComboBox cboNCC;
	private JComboBox cboLoaiSP;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtSoLuong;
	private JTextField txtGia;
	private ArrayList<NhaCungCap> lstNhaCungCap;
	private ArrayList<LoaiSanPham> lstLoaiSP;
	private ArrayList<HoaDon> listHoaDon;
	private ArrayList<SanPham> lstSP;
	private ArrayList<NhanVien> lstNhanVien;
	private String hinhAnh="";
	private JButton btnLuu;
	private JComboBox cboNhanVien;
	private int l;//để xét coi mở giao diện nào
	private JRadioButton radTrue;
	private JRadioButton radFalse;
	private JTextArea taMoTa;
	private JLabel lblTB;
	public NhapSuaThongTinSanPham(SanPham sanpham, int loai) { // Nếu 1 thì mở giao diện thêm, 0 thì giao diện sửa
		t = sanpham;
		l=loai;
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		setSize(700,700);
		setLocationRelativeTo(null);
		setVisible(true);
		
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		hd_dao = new HoaDon_DAO();
		nhacungcap_dao = new NhaCungCap_DAO();
		loaiSP_dao = new LoaiSanPham_DAO();
		sp_dao = new SanPham_DAO();
		nv_dao = new NhanVien_DAO();
		lstNhaCungCap = new ArrayList<NhaCungCap>();
		lstLoaiSP = new ArrayList<LoaiSanPham>();
		lstSP = new ArrayList<SanPham>();
		lstNhanVien = new ArrayList<NhanVien>();
		
		JLabel lblTieuDe = new JLabel("THÔNG TIN SẢN PHẨM");
		lblTieuDe.setFont(new Font("Time New Roman",Font.BOLD,20));
		JPanel pnTieuDe = new JPanel();
		pnTieuDe.add(lblTieuDe);
		add(pnTieuDe,BorderLayout.NORTH);
		
		lblHinhAnh = new JLabel("");
		lblHinhAnh.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
		JPanel pnHinhAnh = new JPanel();
		pnHinhAnh.setPreferredSize(new Dimension(320,210));
		pnHinhAnh.setLayout(new WrapLayout());
		btnChonAnh = new JButton("Chọn ảnh");
		btnLuu = new JButton("Lưu");
		pnHinhAnh.add(lblHinhAnh);
		JPanel pnChonAnhVaTB = new JPanel();
		pnChonAnhVaTB.setLayout(new GridLayout(2,1));
		pnHinhAnh.add(pnChonAnhVaTB);
		lblTB = new JLabel("");
		lblTB.setForeground(Color.RED);
		JPanel pnCA = new JPanel();
		pnCA.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnCA.add(btnChonAnh);
		pnChonAnhVaTB.add(pnCA);
		JPanel pnTB = new JPanel();
		pnTB.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnTB.add(lblTB);
		pnChonAnhVaTB.add(pnTB);
		
		lblHinhAnh.setPreferredSize(new Dimension(300,180));
		String path = t.getHinhAnh();
		
		lblHinhAnh.setIcon(DoiKichThuocAnh(path));
		add(pnHinhAnh, BorderLayout.EAST);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BorderLayout());
		add(pnCenter, BorderLayout.CENTER);
		JPanel pnThongTin = new JPanel();
		pnThongTin.setLayout(new GridLayout(10,1));
		pnCenter.add(pnThongTin, BorderLayout.CENTER);
		
		JPanel pnMoTa = new JPanel();
		pnMoTa.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnMT = new JPanel();
		pnMT.setLayout(new BorderLayout());
		JLabel lblTDMoTa = new JLabel("Mô tả sản phẩm:");
		pnMT.add(lblTDMoTa, BorderLayout.NORTH);
		taMoTa = new JTextArea(10,30);
		taMoTa.setLineWrap(true);
		taMoTa.setWrapStyleWord(true);
		JScrollPane scrMoTa = new JScrollPane(taMoTa);
		pnMT.add(scrMoTa, BorderLayout.CENTER);
		pnMoTa.add(pnMT);
		pnCenter.add(pnMoTa, BorderLayout.SOUTH);
		
		JPanel pnNCC = new JPanel();
		pnNCC.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnLoaiSP = new JPanel();
		pnLoaiSP.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnMaSP = new JPanel();
		pnMaSP.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnTenSP = new JPanel();
		pnTenSP.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnSoLuong = new JPanel();
		pnSoLuong.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnGia = new JPanel();
		pnGia.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnTrangThai = new JPanel();
		pnTrangThai.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		JLabel lblTDNCC = new JLabel("Nhà cung cấp:");
		JLabel lblTDLoaiSP = new JLabel("Loại SP:");
		JLabel lblTDMaSP = new JLabel("Mã SP:");
		JLabel lblTDTenSP = new JLabel("Tên SP:");
		JLabel lblTDSoLuong = new JLabel("Số lượng");
		JLabel lblTDGia = new JLabel("Giá ");
		JLabel lblTDTrangThai = new JLabel("trạng thái:");
		
		lblTDLoaiSP.setPreferredSize(lblTDNCC.getPreferredSize());
		lblTDMaSP.setPreferredSize(lblTDNCC.getPreferredSize());
		lblTDTenSP.setPreferredSize(lblTDNCC.getPreferredSize());
		lblTDSoLuong.setPreferredSize(lblTDNCC.getPreferredSize());
		lblTDGia.setPreferredSize(lblTDNCC.getPreferredSize());
		lblTDTrangThai.setPreferredSize(lblTDNCC.getPreferredSize());
		//lblTDMoTa.setPreferredSize(lblTDHuongDanVien.getPreferredSize());
		lblTDMoTa.setBounds(lblTDNCC.getBounds());
		
		cboNCC = new JComboBox();
		cboLoaiSP = new JComboBox();
		txtMaSP = new JTextField(18);
		SanPham_DAO sanphamDao = new SanPham_DAO();
		int maSPLN = sanphamDao.LayMaSPLonNhat();
		txtMaSP.setText("SP0"+maSPLN);
		txtMaSP.setEditable(false);
		txtTenSP = new JTextField(18);
		radTrue = new JRadioButton("Có thể đặt",true); 
		radFalse = new JRadioButton("Không thể đặt");
		ButtonGroup group = new ButtonGroup();
		group.add(radTrue);group.add(radFalse);
		
		cboNCC.setPreferredSize(txtMaSP.getPreferredSize());
		cboLoaiSP.setPreferredSize(txtMaSP.getPreferredSize());
		
		
		txtSoLuong= new JTextField(18);
		txtGia= new JTextField(18);
		
		pnNCC.add(lblTDNCC);
		pnNCC.add(cboNCC);
		pnLoaiSP.add(lblTDLoaiSP);
		pnLoaiSP.add(cboLoaiSP);
		pnMaSP.add(lblTDMaSP);
		pnMaSP.add(txtMaSP);
		pnTenSP.add(lblTDTenSP);
		pnTenSP.add(txtTenSP);
		pnSoLuong.add(lblTDSoLuong);
		pnSoLuong.add(txtSoLuong);
		pnGia.add(lblTDGia);
		pnGia.add(txtGia);
		pnTrangThai.add(lblTDTrangThai);
		pnTrangThai.add(radTrue);
		pnTrangThai.add(radFalse);
				
		pnThongTin.add(pnNCC);
		pnThongTin.add(pnLoaiSP);
		pnThongTin.add(pnMaSP);
		pnThongTin.add(pnTenSP);
		pnThongTin.add(pnSoLuong);
		pnThongTin.add(pnGia);
		pnThongTin.add(pnTrangThai);
		pnThongTin.revalidate();
		pnCenter.revalidate();
		
		JPanel pnChucNang = new JPanel();
		pnChucNang.add(btnLuu);
		add(pnChucNang, BorderLayout.SOUTH);
		
		LayDanhSachNhaCungCap();
		ThemVaoCboNhaCungCap();
		LayDanhSachLoaiSP();
		ThemVaoCboLoaiSP();
		LayDanhSachSanPham();
		
		btnChonAnh.addActionListener(this);
		btnLuu.addActionListener(this);
		cboLoaiSP.addItemListener(this);
		cboNCC.addItemListener(this);
		
		if(l==0)
		{
			DuaThongTinSPVaoComponent();
			btnLuu.setVisible(true);
		}
		else if(l==2)
		{
			DuaThongTinSPVaoComponent();
			btnLuu.setVisible(true);
		}
		else
		{
			btnLuu.setVisible(true);
//			DinhDangMaSanPham();
//			DinhDangTenSP();
		}
			
	}

	public static void main(String[] args) {
		
	}
	public ImageIcon DoiKichThuocAnh(String ImagePath)
	 {
		 ImageIcon MyImage = new ImageIcon(ImagePath);
		 Image img = MyImage.getImage();
		 Image newImg = img.getScaledInstance(290, 150, Image.SCALE_SMOOTH);
		 ImageIcon image = new ImageIcon(newImg);
	     return image;
	 }
	
	private void LayDanhSachNhaCungCap() {
		lstNhaCungCap = nhacungcap_dao.getalltbNCC();
	}
	
	private void ThemVaoCboNhaCungCap()
	{
		for (NhaCungCap ncc : nhacungcap_dao.getalltbNCC()) {
			cboNCC.addItem(ncc.getMaNCC());
		}
	}
	
	private void LayDanhSachLoaiSP() {
		lstLoaiSP = loaiSP_dao.layHetLoaiSanPham();
	}
	private void ThemVaoCboLoaiSP() {
		for (LoaiSanPham loaiSP : lstLoaiSP) {
			cboLoaiSP.addItem(loaiSP.getMaLoaiSP()/*+"-"+loaiSP.getTenLoaiSP()*/);
		}
	}
	
	
	private void LayDanhSachSanPham() {
		// TODO Auto-generated method stub
		lstSP = sp_dao.getalltbSanPham();
	}
	
	 
	private String DinhDanhLaiNguonAnh(String a) {
		 String b= "";
		 for(int i =0;i<a.length();i++)
		 {
			 char c = a.charAt(i);
			 b+=c;
			 if(c=='\\'){
				 b+="\\";
			 }
		 }
		 
		 return b;
	 }
	 
	private String XuLyLayTenAnh(String nguon) {
		 StringBuilder str = new StringBuilder(nguon);
		 str = str.reverse();
		 String tenAnh="";
		 for(int i =0;i<str.length();i++) {
			 if(str.charAt(i)=='\\')
				 break;
			 else
				 tenAnh+=str.charAt(i);
		 }
		 str=new StringBuilder(tenAnh);
		 return str.reverse().toString();
	 }
	 
	private void LuuAnh() {
		 FileInputStream in;
			try {
				in = new FileInputStream(DinhDanhLaiNguonAnh(hinhAnh));
				System.out.println(XuLyLayTenAnh(DinhDanhLaiNguonAnh(hinhAnh)));
				FileOutputStream ou = new FileOutputStream("hinhAnh\\"+XuLyLayTenAnh(DinhDanhLaiNguonAnh(hinhAnh)));
				BufferedInputStream bin = new BufferedInputStream(in);
				BufferedOutputStream bou = new BufferedOutputStream(ou);
				int b= 0;
				while(b!=-1) {
					try {
						b = bin.read();
						bou.write(b);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				try {
					bin.close();
					bou.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("Copy thành công");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	 }
	 
	private void DinhDangMaSanPham() {

		String maSP="";
		maSP+="SP";
		
		maSP+=cboLoaiSP.getSelectedItem().toString().substring(0,2);
		if(String.valueOf(sp_dao.LayMaSPLonNhat()).length()==2)
			maSP+="0";
		maSP+=String.valueOf(sp_dao.LayMaSPLonNhat()+1);
		txtMaSP.setText(maSP);
	}
	private void DinhDangMaSPDeSua() {
		String maSP="";
		maSP+="SP";
		
		maSP+=cboLoaiSP.getSelectedItem().toString().substring(0,2);
		
		maSP+=String.valueOf(t.getMaSP().substring(3));
		txtMaSP.setText(maSP);
	}
	private void DinhDangTenSP() {
		String tenSP="";
		tenSP+="";
		tenSP+=cboLoaiSP.getSelectedItem().toString().substring(3)+" ";
//		tenSP+=cboNCC.getSelectedItem().toString().substring(7)+" ";
		if(String.valueOf(sp_dao.LayMaSPLonNhat()).length()==2)
			tenSP+="0";
		tenSP+=String.valueOf(sp_dao.LayMaSPLonNhat()+1);
		txtTenSP.setText(tenSP);
	}
	private void DinhDangTenSPDeSua() {
		String tenSP="";
		tenSP+="Tour ";
		tenSP+=cboLoaiSP.getSelectedItem().toString().substring(3)+" ";
		tenSP+=cboNCC.getSelectedItem().toString().substring(7)+" ";
		tenSP+=String.valueOf(t.getMaSP().substring(3));
		txtTenSP.setText(tenSP);
	}
	private void DuaThongTinSPVaoComponent() {
		for (NhaCungCap ncc : lstNhaCungCap) {
			if(t.getMaNCC().getMaNCC().equals(ncc.getMaNCC())) {
				cboNCC.setSelectedItem(ncc.getMaNCC()+"-"+ncc.getTenNCC());
			}
		}
		for(LoaiSanPham lsp : lstLoaiSP)
		{
			if(t.getLoaiSP().getMaLoaiSP().equals(lsp.getMaLoaiSP())) {
				cboLoaiSP.setSelectedItem(lsp.getMaLoaiSP()+"-"+lsp.getTenLoaiSP());
			}
		}
		
		txtMaSP.setText(t.getMaSP());
		txtTenSP.setText(t.getTenSP());
		txtSoLuong.setText(String.valueOf(t.getSoLuong()) );
		txtGia.setText(String.valueOf(t.getGia()));
		taMoTa.setText(t.getMoTa());
		hinhAnh = t.getHinhAnh();
	}
	
	private boolean KiemTraNhapSoNguyen(String nhap) {
		try {
			int a = Integer.parseInt(nhap);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	private boolean KiemTraNhapSoThuc(String nhap) {
		try {
			float  a = Float.parseFloat(nhap);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private boolean KiemTraNhapLieu() {
		if(txtTenSP.getText().trim().length()==0) {
			txtTenSP.requestFocus();
			JOptionPane.showMessageDialog(this, "Tên sản phẩm không đc trống");
			return false;
		}
		else if(txtTenSP.getText().length()>50) {
			txtTenSP.requestFocus();
			txtTenSP.selectAll();
			JOptionPane.showMessageDialog(this, "Tên sản phẩm quá dài !");
			return false;
		}
		
		if(txtSoLuong.getText().trim().length()==0) {
			txtSoLuong.requestFocus();
			txtSoLuong.selectAll();
			JOptionPane.showMessageDialog(this,"Số lượng không được để trống !");
			return false;
		}
		else if(!KiemTraNhapSoNguyen(txtSoLuong.getText()) ) {
			txtSoLuong.requestFocus();
			txtSoLuong.selectAll();
			JOptionPane.showMessageDialog(this,"Số lượng phải là số nguyên !");
			return false;
		}
		else if(Integer.parseInt(txtSoLuong.getText())>100&& txtSoLuong.getText().length()>=3)
		{
			txtSoLuong.requestFocus();
			txtSoLuong.selectAll();
			JOptionPane.showMessageDialog(this,"Số lượng quá lớn");
			return false;
		}
		else if(Integer.parseInt(txtSoLuong.getText())<0) {
			txtSoLuong.requestFocus();
			txtSoLuong.selectAll();
			JOptionPane.showMessageDialog(this,"Số lượng phải lớn hơn 0");
			return false;
		}
		
		else if(txtGia.getText().trim().length()==0) {
			txtGia.requestFocus();
			txtGia.selectAll();
			JOptionPane.showMessageDialog(this,"Giá không được để trống");
			return false;
		}
		else if(!KiemTraNhapSoThuc(txtGia.getText())) {
			txtGia.requestFocus();
			txtGia.selectAll();
			JOptionPane.showMessageDialog(this,"Giá phải là số thực");
			return false;
		}
		else if(Float.parseFloat(txtGia.getText())<0) {
			txtGia.requestFocus();
			txtGia.selectAll();
			JOptionPane.showMessageDialog(this,"Giá phải là số thực > 0");
			return false;
		}
		else if(txtGia.getText().length()>9&&Float.parseFloat(txtGia.getText())>999999999) {
			txtGia.requestFocus();
			txtGia.selectAll();
			JOptionPane.showMessageDialog(this,"Giá quá lớn !");
			return false;
		}
		
		if(taMoTa.getText().length()==0)
			taMoTa.setText("Chưa có mô tả !");
		if(hinhAnh.length()==0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn ảnh !");
			return false;
		}
		return true;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnChonAnh)) {
			try {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
				file.addChoosableFileFilter(filter);
				file.setFileFilter(filter);
				int result = file.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					hinhAnh = selectedFile.getAbsolutePath();
					lblHinhAnh.setIcon(DoiKichThuocAnh(hinhAnh));

				}
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn ảnh !");
			}
			
		}
		else if(obj.equals(btnLuu)) {
			if(l==1) { // 1 là thêm
				if(KiemTraNhapLieu()) {
				
					NhaCungCap ncc = new NhaCungCap(cboNCC.getSelectedItem().toString().trim());
					LoaiSanPham lSP = new LoaiSanPham(cboLoaiSP.getSelectedItem().toString().trim());
					SanPham SPThem = null;
					try {
						SPThem = new SanPham(txtMaSP.getText(), txtTenSP.getText(),Float.parseFloat(txtGia.getText()), taMoTa.getText(), true ,
								"hinhAnh\\\\"+XuLyLayTenAnh(DinhDanhLaiNguonAnh(hinhAnh)), lSP,Integer.parseInt(txtSoLuong.getText()), ncc);	
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(this, "Không thể tạo sản phẩm");
					}
					
					try {
						sp_dao.ThemSanPham(SPThem);
						LuuAnh();
						JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công !");
						/*sp_dao.GuiEmail(SPThem,cboNCC.getSelectedItem().toString().substring(7),
								cboLoaiSP.getSelectedItem().toString().substring(3));
						JOptionPane.showMessageDialog(this, "Đã gửi mail !");*/
						QuanLySanPham.qlSP.TaiSPLen();
						this.dispose();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(this, "Lỗi, không thể thêm sản phẩm!");
					}
				}
			}
			else if(l==2) { // Sửa thông tin
				if(KiemTraNhapLieu()) {
					
					NhaCungCap ncc = new NhaCungCap(cboNCC.getSelectedItem().toString().trim());
					LoaiSanPham lSP = new LoaiSanPham(cboLoaiSP.getSelectedItem().toString().trim());
					SanPham SPThem = null;
					try {
						SPThem = new SanPham(txtMaSP.getText(), txtTenSP.getText(),Float.parseFloat(txtGia.getText()), taMoTa.getText(), true ,
								"hinhAnh\\\\"+XuLyLayTenAnh(DinhDanhLaiNguonAnh(hinhAnh)), lSP,Integer.parseInt(txtSoLuong.getText()), ncc);	
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(this, "Không thể tạo sản phẩm");
					}
					
					try {
						sp_dao.SuaSanPham(SPThem);
						LuuAnh();
						JOptionPane.showMessageDialog(this, "Sửa sản phẩm thành công !");
						/*sp_dao.GuiEmail(SPThem,cboNCC.getSelectedItem().toString().substring(7),
								cboLoaiSP.getSelectedItem().toString().substring(3));
						JOptionPane.showMessageDialog(this, "Đã gửi mail !");*/
						QuanLySanPham.qlSP.TaiSPLen();
						this.dispose();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(this, "Lỗi, không thể thêm sản phẩm!");
					}
				}
			}
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(l==1) {//1 là thêm
			if(obj.equals(cboLoaiSP)&&e.getStateChange()==ItemEvent.SELECTED) {
				DinhDangMaSanPham();
				DinhDangTenSP();
			}
			else if(obj.equals(cboNCC)&&e.getStateChange()==ItemEvent.SELECTED) {
				DinhDangTenSP();
			}
		}
		
		else if(l==2) {// 0 là sửa
			if(obj.equals(cboLoaiSP)&&e.getStateChange()==ItemEvent.SELECTED) {
				DinhDangMaSPDeSua();
				DinhDangTenSPDeSua();
			}
			else if(obj.equals(cboNCC)&&e.getStateChange()==ItemEvent.SELECTED) {
				DinhDangTenSPDeSua();
			}
		}
	}
}
