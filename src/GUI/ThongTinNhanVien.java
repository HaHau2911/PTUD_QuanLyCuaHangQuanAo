package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class ThongTinNhanVien extends JFrame implements ActionListener{

	JLabel lblMaNV, lblTenNV, lblEmail, lblDiaChi, lblSDT, lblCMND, lblNVL, lblUser, lblPass, lblGioiTinh, lblTinhTrang;
	JTextField txtMaNV, txtTenNV, txtEmail, txtDiaChi, txtSDT, txtCMND,txtNVL, txtUser, txtPass;
	ButtonGroup btnGroup;
	JRadioButton radNam, radNu;
	JButton btnLamMoi, btnLuu, btnThoat;
	JPanel pnNorth;
	JPanel pnMain;
	JComboBox cbxTinhTrang;
	ImageIcon background;
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
	public ThongTinNhanVien()  {
		setTitle("THONG TIN NHAN VIEN");
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);	
		setSize(500,500);
		setLocationRelativeTo(null);
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
		JPanel pnMaNV = new JPanel();
		lblMaNV = new JLabel("Mã nhân viên");
		txtMaNV = new JTextField(18);
		pnMaNV.add(lblMaNV);
		pnMaNV.add(txtMaNV);
		pnThongTin.add(pnMaNV);
		
			//Ten
		JPanel pnTenNV = new JPanel();
		lblTenNV = new JLabel("Tên nhân viên");
		txtTenNV = new JTextField(18);
		pnTenNV.add(lblTenNV);
		pnTenNV.add(txtTenNV);
		pnThongTin.add(pnTenNV);	
			//Email
		JPanel pnEmail = new JPanel();
		lblEmail = new JLabel("Email");
		txtEmail = new JTextField(18);
		pnEmail.add(lblEmail);
		pnEmail.add(txtEmail);
		pnThongTin.add(pnEmail);
			//DiaChi
		JPanel pnDiaCHi = new JPanel();
		lblDiaChi = new JLabel("Địa Chỉ");
		txtDiaChi = new JTextField(18);
		pnDiaCHi.add(lblDiaChi);
		pnDiaCHi.add(txtDiaChi);
		pnThongTin.add(pnDiaCHi);
			//SDT
		JPanel pnSDT = new JPanel();
		lblSDT = new JLabel("Số Điện Thoại");
		txtSDT = new JTextField(18);
		pnSDT.add(lblSDT);
		pnSDT.add(txtSDT);
		pnThongTin.add(pnSDT);
			//CMND
		JPanel pnCMND = new JPanel();
		lblCMND = new JLabel("CMND");
		txtCMND = new JTextField(18);
		pnCMND.add(lblCMND);
		pnCMND.add(txtCMND);
		pnThongTin.add(pnCMND);

			//User
		JPanel pnUser = new JPanel();
		lblUser = new JLabel("Tài khoản");
		txtUser = new JTextField(18);
		pnUser.add(lblUser);
		pnUser.add(txtUser);
		pnThongTin.add(pnUser);	
			//User
		JPanel pnPass = new JPanel();
		lblPass = new JLabel("Mật khẩu");
		txtPass = new JTextField(18);
		pnPass.add(lblPass);
		pnPass.add(txtPass);
		pnThongTin.add(pnPass);	

			//TinhTrang
		JPanel pnTinhTrang = new JPanel();
		lblTinhTrang = new JLabel("Trạng Thái");
		cbxTinhTrang = new JComboBox();
		cbxTinhTrang.addItem("Vắng");
		cbxTinhTrang.addItem("Nghỉ");
		cbxTinhTrang.setPreferredSize(new Dimension(190, 25));
		pnTinhTrang.add(lblTinhTrang);
		pnTinhTrang.add(cbxTinhTrang);
		pnThongTin.add(pnTinhTrang);	
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

		
		lblTinhTrang.setPreferredSize(lblSDT.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblSDT.getPreferredSize());
		radNam.setPreferredSize(lblSDT.getPreferredSize());
		radNu.setPreferredSize(lblSDT.getPreferredSize());
		lblMaNV.setPreferredSize(lblSDT.getPreferredSize());
		lblEmail.setPreferredSize(lblSDT.getPreferredSize());
		lblSDT.setPreferredSize(lblSDT.getPreferredSize());
		lblCMND.setPreferredSize(lblSDT.getPreferredSize());
		lblDiaChi.setPreferredSize(lblSDT.getPreferredSize());
		lblUser.setPreferredSize(lblSDT.getPreferredSize());
		lblPass.setPreferredSize(lblSDT.getPreferredSize());
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("Icon/xoarong.png"));
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
		
	}
	
	public static void main(String[] args) {
		ThongTinNhanVien ttnv = new ThongTinNhanVien();
		//ttnv.setBackground(new ImageIcon("Icon/1767.jpg"));
		ttnv.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
