package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.LoaiNhanVien_DAO;
import DAO.NhanVien_DAO;
import connectDB.ConnectDB;
import entity.LoaiNhanVien;
import entity.NhaCungCap;
import entity.NhanVien;



public class UI_NhanVien extends JFrame implements ActionListener, ItemListener {

	DefaultTableModel modeltable;
	JTable table;
	
	JLabel lblMaNV, lblTenNV, lblEmail, lblDiaChi, lblSDT, lblCMND, lblNVL, lblUser, lblPass, lblGioiTinh, lblTrangThai,lblChuThich1,lblChuThich2;
	JTextField txtMaNV, txtTenNV, txtEmail, txtDiaChi, txtSDT, txtCMND,txtLNV, txtMess;
	ButtonGroup btnGroup;
	JRadioButton radNam, radNu,radDangLam,radNghi;
	JButton btnThem, btnXoa, btnUpdate;
	JPanel pnNorth;
	JPanel pnMain;
	JComboBox<NhanVien> cbxTrangThai,cbGioiTinh;
	private JButton btnLamMoi, btnLuu, btnThoat;
	private javax.swing.JTable tblNhanVien;
	private javax.swing.JScrollPane jScrollPane1;
	ImageIcon background;
	private NhanVien_DAO dao_nv = new NhanVien_DAO();	
	private UI_ThongTinNhanVien ttnv;
	private JComboBox cboLoaiNV;
	private ArrayList<LoaiNhanVien> lstLoaiNV;
	private LoaiNhanVien_DAO loaiNV_dao;
	private NhanVien nhanvien;
	private NhanVien_DAO nv_dao;
	boolean flag = true;
	
	//private JDateChooser dateNgayVaoLam;
	/*
	@Override
	public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(new ImageIcon("Icon/1767.jpg").getImage(), 0, 30, getWidth(), getHeight(), null);
	}
	public void setBackground(ImageIcon img)
	{
		this.background=img;
	}*/
	public UI_NhanVien(NhanVien nv, boolean flag)  {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		nv_dao = new NhanVien_DAO();
		nhanvien = nv;
		ttnv = new UI_ThongTinNhanVien();
		
		setTitle("Thông Tin Nhân Viên");
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);	
		setSize(500,500);
		setLocationRelativeTo(null);
		List<String> list_MaNV = dao_nv.getListMaNV();
		/*
		//Container con = getContentPane();
		//background=null;
		pnMain = new JPanel()
		{
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if(background!=null)
				{
					g.drawImage(background.getImage(),
							0,0,getWidth(),getHeight(),null);
				}
			}
		};
		pnMain.setLayout(new BorderLayout());
		add(pnMain,BorderLayout.CENTER);*/
		
		
		
		
		
		 pnNorth = new JPanel() { };
		JLabel lblTieuDe = new JLabel("Thông Tin Nhân Viên");
		Font font =new Font("Arial",Font.BOLD,15);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		pnNorth.add(lblTieuDe);
		add(pnNorth,BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnThongTin = new JPanel();
		JPanel pnChucNang = new JPanel();
		pnChucNang.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		pnCenter.add(pnThongTin);
		pnCenter.add(pnChucNang);
		add(pnCenter,BorderLayout.CENTER);
			//Ma
		jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        
		JPanel pnMaNV = new JPanel();
		lblMaNV = new JLabel("Mã nhân viên");
		txtMaNV = new JTextField(25);
		txtMaNV.setEnabled(false);
		pnMaNV.add(lblMaNV);
		pnMaNV.add(txtMaNV);
		pnThongTin.add(pnMaNV);
		
			//Ten
		JPanel pnTenNV = new JPanel();
		lblTenNV = new JLabel("Tên nhân viên");
		txtTenNV = new JTextField(25);
		pnTenNV.add(lblTenNV);
		pnTenNV.add(txtTenNV);
		pnThongTin.add(pnTenNV);
		//Email
		JPanel pnEmail = new JPanel();
		lblEmail = new JLabel("Email");
		txtEmail = new JTextField(25);
		pnEmail.add(lblEmail);
		pnEmail.add(txtEmail);
		pnThongTin.add(pnEmail);
		//DiaChi
		JPanel pnDiaCHi = new JPanel();
		lblDiaChi = new JLabel("Địa Chỉ");
		txtDiaChi = new JTextField(25);
		pnDiaCHi.add(lblDiaChi);
		pnDiaCHi.add(txtDiaChi);
		pnThongTin.add(pnDiaCHi);
		
		//SDT
		JPanel pnSDT = new JPanel();
		lblSDT = new JLabel("Số Điện Thoại");
		txtSDT = new JTextField(25);
		pnSDT.add(lblSDT);
		pnSDT.add(txtSDT);
		pnThongTin.add(pnSDT);
		
		//CMND
		JPanel pnCMND = new JPanel();
		lblCMND = new JLabel("CMND");
		txtCMND = new JTextField(25);
		pnCMND.add(lblCMND);
		pnCMND.add(txtCMND);
		pnThongTin.add(pnCMND);

			//TrangThai
		JPanel pnTrangThai = new JPanel();
		lblTrangThai = new JLabel("Trạng Thái:");
		radDangLam = new JRadioButton("Đang Làm");
		radNghi = new JRadioButton("Nghỉ");
		ButtonGroup groupTinhTrang = new ButtonGroup();
		groupTinhTrang.add(radDangLam);
		groupTinhTrang.add(radNghi);
		pnTrangThai.add(lblTrangThai);
		pnTrangThai.add(radDangLam);
		pnTrangThai.add(radNghi);
		pnThongTin.add(pnTrangThai);	
		
//			//GioiTinh
//		String GT[] = {"Nam","Nữ"};
//		JPanel pnGioiTinh = new JPanel();
//		lblGioiTinh = new JLabel("Giới Tính:");
//		cbGioiTinh = new JComboBox(GT);
//
//		pnGioiTinh.add(lblGioiTinh);
//		pnGioiTinh.add(cbGioiTinh);
//		pnThongTin.add(pnGioiTinh);
		//GioiTinh
		
		JPanel pnGioiTinh = new JPanel();
		lblGioiTinh = new JLabel("Giới Tính:");
		radNam = new JRadioButton("Nam");
		radNu = new JRadioButton("Nữ");
		ButtonGroup groupGioitinh = new ButtonGroup();
		groupGioitinh.add(radNam);
		groupGioitinh.add(radNu);
		pnGioiTinh.add(lblGioiTinh);
		pnGioiTinh.add(radNam);pnGioiTinh.add(radNu);
		pnThongTin.add(pnGioiTinh);	
		
		JPanel pnLoaiNV = new JPanel();
		pnLoaiNV.setLayout(new FlowLayout(FlowLayout.LEFT)); //
		JLabel lblLoaiNV = new JLabel("Loại Nhân Viên:");
		LoaiNhanVien_DAO lnvDao = new LoaiNhanVien_DAO();
		ArrayList<LoaiNhanVien> listLNV = lnvDao.layHetLoaiNhanVien();
		cboLoaiNV = new JComboBox();
		for(LoaiNhanVien lnv:listLNV) {
			cboLoaiNV.addItem(lnv.getMaLoaiNV());
		}
		cboLoaiNV.setPreferredSize(txtMaNV.getPreferredSize());
		pnLoaiNV.add(lblLoaiNV);
		pnLoaiNV.add(cboLoaiNV);
		pnThongTin.add(pnLoaiNV);
		
		
//		//TinhTrang
//		String TT[] = {"Đang làm","Nghỉ"};
//		JPanel pnTinhTrang = new JPanel();
//		lblTinhTrang = new JLabel("Tình Trạng:");
//		cbxTinhTrang = new JComboBox(TT);
//		pnTinhTrang.add(lblTinhTrang);
//		pnTinhTrang.add(cbxTinhTrang);
//		pnThongTin.add(pnTinhTrang);

		


		
//		
		lblGioiTinh.setPreferredSize(lblSDT.getPreferredSize());
		radNam.setPreferredSize(lblSDT.getPreferredSize());
		radNu.setPreferredSize(lblSDT.getPreferredSize());
		
		lblMaNV.setPreferredSize(lblSDT.getPreferredSize());
		lblEmail.setPreferredSize(lblSDT.getPreferredSize());
		lblSDT.setPreferredSize(lblSDT.getPreferredSize());
		lblCMND.setPreferredSize(lblSDT.getPreferredSize());
		lblDiaChi.setPreferredSize(lblSDT.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblSDT.getPreferredSize());
		lblLoaiNV.setPreferredSize(lblSDT.getPreferredSize());
		
		lblTrangThai.setPreferredSize(lblSDT.getPreferredSize());
		radDangLam.setPreferredSize(lblSDT.getPreferredSize());
		radNghi.setPreferredSize(lblCMND.getPreferredSize());
		
		
		/* btnThem = new JButton("Them");
		btnThem.setIcon(new ImageIcon("Icon/them.png"));
		btnXoa = new JButton("Xoa Rong");
		btnXoa.setIcon(new ImageIcon("Icon/xoa.png"));
		btnUpdate = new JButton("Sua");
		btnUpdate.setIcon(new ImageIcon("Icon/save.png"));
		btnThoat = new JButton("Thoat");
		btnThoat.setIcon(new ImageIcon("Icon/thoat.png"));
		
		
		pnChucNang.add(btnThem);
		pnChucNang.add(btnXoa);
		pnChucNang.add(btnUpdate);
		pnChucNang.add(btnThoat);
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnThoat.addActionListener(this);
		cboLoaiNV.addItemListener(this); */
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("Icon/load.png"));
		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("Icon/save.png"));
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Icon/thoat.png"));
		
		pnChucNang.add(btnLamMoi);
		pnChucNang.add(btnLuu);
		pnChucNang.add(btnThoat);
		
		btnLuu.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnThoat.addActionListener(this);
		
		if (flag == true) {
			dinhDangMaNhanVien();
			txtTenNV.setText("");
			txtEmail.setText("");
			txtDiaChi.setText("");
			txtSDT.setText("");
			txtCMND.setText("");
		}
		else {
			txtMaNV.setText(nv.getMaNV());
			txtTenNV.setText(nv.getTenNV());
			txtEmail.setText(nv.getEmail());
			txtDiaChi.setText(nv.getDiaChi());
			txtSDT.setText(nv.getSoDT());
			txtCMND.setText(nv.getCmnd());
		}
		btnLuu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(flag == true) {
					if(validData()) {
						String ma= txtMaNV.getText();
						String cmnd = txtCMND.getText();
						String ten=txtTenNV.getText();
						String diachi=txtDiaChi.getText();
						String email= txtEmail.getText();
						String sodt= txtSDT.getText();
						boolean trangthai = false;
						if(radDangLam.isSelected())
							trangthai = true;
						
						boolean gioiTinh = true;
						if(radNu.isSelected())
							gioiTinh = false;
						
						LoaiNhanVien lNV = new LoaiNhanVien(cboLoaiNV.getSelectedItem().toString().trim());
						
						nhanvien = new NhanVien(ma, ten, email, diachi, sodt, cmnd, trangthai, gioiTinh, lNV);
						
						
						if(nv_dao.themNV(nhanvien))
						{
							JOptionPane.showMessageDialog(null , "Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
							ttnv.modeltable.addRow(new Object[] {
									ma, ten, email, diachi, sodt, cmnd, trangthai, gioiTinh, lNV
							});
							xoaRong();
							dinhDangMaNhanVien();
						}
						
						dispose();
					}			
				}
				else if (flag == false ) {
					if(ttnv.row>=0) {
						String ma= txtMaNV.getText();
						String cmnd = txtCMND.getText();
						String ten=txtTenNV.getText();
						String diachi=txtDiaChi.getText();
						String email= txtEmail.getText();
						String sodt= txtSDT.getText();
						boolean trangthai =false;
						if(radDangLam.isSelected())
							trangthai =true;
						
						boolean gioiTinh = true;
						if(radNu.isSelected())
							gioiTinh = false;
						
						LoaiNhanVien lNV = new LoaiNhanVien(cboLoaiNV.getSelectedItem().toString().trim());
						
						nhanvien = new NhanVien(ma, ten, email, diachi, sodt, cmnd, trangthai, gioiTinh, lNV);
						
						if(nv_dao.update(nhanvien)) {
							ttnv.table.setValueAt(txtTenNV.getText(), ttnv.row, 1);
							ttnv.table.setValueAt(txtEmail.getText(),ttnv.row,2);
							ttnv.table.setValueAt(txtDiaChi.getText(),ttnv.row,3);
							ttnv.table.setValueAt(txtSDT.getText(),ttnv.row,4);
							ttnv.table.setValueAt(txtCMND.getText(),ttnv.row,5);
						}
					}
					JOptionPane.showMessageDialog(null , "Sửa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}	
			}
		});

		
		/* txtMaNV.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				

		        
			NhanVien nv = dao_nv.getNhanVienbyHDId("maNV", txtMaNV.getText());
			if(nv!=null) {
			
				txtTenNV.setText(nv.getTenNV());
				txtEmail.setText(nv.getEmail());
				txtDiaChi.setText(nv.getDiaChi());
				txtSDT.setText(nv.getSoDT());
				txtCMND.setText(nv.getCmnd());
				
			
			}
			else {
		
				txtTenNV.setText("");
				txtEmail.setText("");
				txtDiaChi.setText("");
				txtSDT.setText("");
				txtCMND.setText("");
				
			}
			
			}
		}); */
	


	}

	public static void main(String[] args) {

	}

	private void LayDanhSachLoaiNhanVien() {
		lstLoaiNV = loaiNV_dao.layHetLoaiNhanVien();
	}
	private void ThemVaoCboLoaiNhanVien() {
		for (LoaiNhanVien loaiNV : lstLoaiNV) {
			cboLoaiNV.addItem(loaiNV.getMaLoaiNV()+"-"+loaiNV.getTenLoaiNV());
		}
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/* Object o = e.getSource();
		if(o.equals(btnThem)) {
			if(validData()) {
			int row = ttnv.table.getSelectedRow();
			String maNV= txtMaNV.getText();
			String tenNV= txtTenNV.getText();
			String email = txtEmail.getText();
			String diaChi = txtDiaChi.getText();
			String soDT = txtSDT.getText();
			String cmnd = txtCMND.getText();
			boolean trangThai =false;
			if(radDangLam.isSelected())
				trangThai =true;
			
			boolean gioiTinh = false;
			if(radNu.isSelected())
				gioiTinh = true;
			
			LoaiNhanVien lNV = new LoaiNhanVien(cboLoaiNV.getSelectedItem().toString().substring(0,2));
			
			NhanVien nv = new NhanVien(maNV, tenNV, email, diaChi, soDT, cmnd, trangThai, gioiTinh, lNV);
	
			dao_nv.themNV(nv);
			ttnv.modeltable.addRow(new Object [] {nv.getMaNV(),nv.getTenNV(),nv.getEmail(),nv.getDiaChi(),nv.getSoDT(),nv.getCmnd(),nv.getTrangThai(), nv.getGioiTinh(), nv.getLoaiNV().getMaLoaiNV()});
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			}		
		
		//	}		
		}
		else if(o.equals(btnUpdate)) {
			
			try {
				
			
				if(validData()) {
					JFrame f= new JFrame();
					int hoi=JOptionPane.showConfirmDialog(f, "Nhân viên này sẽ được cập nhật","Chú ý",JOptionPane.YES_NO_OPTION);
					if(hoi==JOptionPane.YES_OPTION) {
						String ma= txtMaNV.getText();
						String cmnd = txtCMND.getText();
						String ten=txtTenNV.getText();
						String diachi=txtDiaChi.getText();
						String email= txtEmail.getText();
						String sodt= txtSDT.getText();
						Date ngayVaoLam = Date.valueOf(txtNVL.getText());
						boolean trangthai =false;
						if(radDangLam.isSelected())
							trangthai =true;
						
						boolean gioiTinh = false;
						if(radNu.isSelected())
							gioiTinh = true;
						
						LoaiNhanVien lNV = new LoaiNhanVien(cboLoaiNV.getSelectedItem().toString().substring(0,2));
						
						NhanVien nv = new NhanVien(ma, ten, email, diachi, sodt, cmnd, trangthai, gioiTinh, lNV);
						dao_nv.update(nv);
						JOptionPane.showMessageDialog(null, "Cập nhật nhân viên thành công");
					}
				}
			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		else if(o.equals(btnXoa)) {
			txtMaNV.setText("");
			txtTenNV.setText("");
			txtEmail.setText("");
			txtCMND.setText("");
			txtDiaChi.setText("");
			txtSDT.setText("");
			radNam.setSelected(true);
			
			
		}
		else if(o.equals(btnThoat)) {
			setVisible(false);
			dispose();
		}*/
		Object o = e.getSource();
		if (o.equals(btnLamMoi)) {
			txtMaNV.setText("");
			txtTenNV.setText("");
			txtEmail.setText("");
			txtCMND.setText("");
			txtDiaChi.setText("");
			txtSDT.setText("");
			radNam.setSelected(true);
		}
		else if (o.equals(btnThoat)) {
			int kt = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát không","Thông báo",JOptionPane.YES_NO_OPTION);
			if(kt == JOptionPane.YES_OPTION) {
				dispose();
			}
		}
		
		
		
	}
	
	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);
	}
	
	private boolean validData() {
		String tenNV = txtTenNV.getText();
		String cmnd = txtCMND.getText();
		String diaChi = txtDiaChi.getText();
		String email = txtEmail.getText();
		String sdt = txtSDT.getText();
		if(!(tenNV.length()>0)){

			JOptionPane.showMessageDialog(null, "Tên nhân viên không trống " );
		
			return false;
		}
//		}
		if(!(cmnd.length()>0 && cmnd.matches("\\d{9}"))) {
			JOptionPane.showMessageDialog(null, "Chứng minh nhân dân gồm  9 số");
			return false;
		}
		if(!(diaChi.length()>0)) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống " );
			return false;
		}
		if(! diaChi.matches("^[0-9a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n" + 
				"	            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n" + 
				"	            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s/\\\\.,]+$")){
			JOptionPane.showMessageDialog(null, "Địa chỉ không hợp lệ " );
			return false;
	            }
		if(!(email.length()>0 )) {
			JOptionPane.showMessageDialog(null, "Email không được để trống");
			return false;
		}
		if( !email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			JOptionPane.showMessageDialog(null, "Email sai cú pháp");
			return false;
		}
		if(!(sdt.length()>0 )) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được bỏ trống");
			return false;
		}
		if(!(sdt.matches("^[0][1-9][0-9]{8}$"))) {
			JOptionPane.showMessageDialog(null, "Số điện thoại gồm 10 kí tự số và bắt đầu từ kí tự 0");
			return false;
		}
		return rootPaneCheckingEnabled;
		
	}

	
		

	
	public void xoaRong() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtEmail.setText("");
		txtCMND.setText("");
		txtDiaChi.setText("");
		txtSDT.setText("");
		radNam.setSelected(true);
    }
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	private void dinhDangMaNhanVien() {
		/* String maNCC = "";
		maNCC += "NCC";
		if(String.valueOf(ncc_dao.layMaNhaCungCapLonNhat()).length() == 2) {
			maNCC += "00";
		}
		else if(String.valueOf(ncc_dao.layMaNhaCungCapLonNhat()).length() == 3) {
			maNCC += "0";
		}
		else if(String.valueOf(ncc_dao.layMaNhaCungCapLonNhat()).length() == 1) {
			maNCC += "";
		}
		maNCC += String.valueOf(ncc_dao.layMaNhaCungCapLonNhat()+1);
		txtMaNCC.setText(maNCC); */
		int maNV= nv_dao.LayMaNVLonNhat()+1;
		txtMaNV.setText("NV0"+maNV);
	}
}
