package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DAO.KhachHang_DAO;
import DAO.NhaCungCap_DAO;
import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhaCungCap;




public class ThongTinKhachHang extends JFrame implements ActionListener{

	JLabel lblMaKH, lblTenKH, lblEmail, lblDiaChi, lblSDT, lblCMND, lblGioiTinh;
	JTextField txtMaKH, txtTenKH, txtEmail, txtDiaChi, txtSDT, txtCMND, txtMess;
	ButtonGroup btnGroup;
	JRadioButton radNam, radNu;
	JPanel pnMain;
	
	private JButton btnLamMoi, btnLuu, btnThoat;
	private JPanel pnNorth;
	private KhachHang_DAO kh_dao;
	private UI_ThongTinKhachHang qlkh;
	private KhachHang khachhang;
	boolean flag = true;

	public ThongTinKhachHang(KhachHang kh,boolean flag)  {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		kh_dao = new KhachHang_DAO();
		khachhang = kh;		  
		qlkh = new UI_ThongTinKhachHang();

		setTitle("THÔNG TIN KHÁCH HÀNG");
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);	
		setSize(600,400);
		setLocationRelativeTo(null);

		pnNorth = new JPanel() { };
		JLabel lblTieuDe = new JLabel("Thông Tin Khách Hàng");
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
		JPanel pnMaKH = new JPanel();
		lblMaKH = new JLabel("Mã khách hàng");
		txtMaKH = new JTextField(40);
		txtMaKH.setEditable(false);
		pnMaKH.add(lblMaKH);
		pnMaKH.add(txtMaKH);
		pnThongTin.add(pnMaKH);
			//Ten
		JPanel pnTenKH = new JPanel();
		lblTenKH = new JLabel("Tên khách hàng");
		txtTenKH = new JTextField(40);
		pnTenKH.add(lblTenKH);
		pnTenKH.add(txtTenKH);
		pnThongTin.add(pnTenKH);				
		
		JPanel pnEmail = new JPanel();
		lblEmail = new JLabel("Email");
		txtEmail = new JTextField(40);
		pnEmail.add(lblEmail);
		pnEmail.add(txtEmail);
		pnThongTin.add(pnEmail);
			//DiaChi
		JPanel pnDiaCHi = new JPanel();
		lblDiaChi = new JLabel("Địa Chỉ");
		txtDiaChi = new JTextField(40);
		pnDiaCHi.add(lblDiaChi);
		pnDiaCHi.add(txtDiaChi);
		pnThongTin.add(pnDiaCHi);
			//SDT
		JPanel pnSDT = new JPanel();
		lblSDT = new JLabel("Số Điện Thoại");
		txtSDT = new JTextField(40);
		pnSDT.add(lblSDT);
		pnSDT.add(txtSDT);
		pnThongTin.add(pnSDT);
			//CMND
		JPanel pnCMND = new JPanel();
		lblCMND = new JLabel("CMND");
		txtCMND = new JTextField(40);
		pnCMND.add(lblCMND);
		pnCMND.add(txtCMND);
		pnThongTin.add(pnCMND);
		
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
		
		JPanel pnMess = new JPanel();
		txtMess = new JTextField(40);
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));
		pnMess.add(txtMess);
		pnThongTin.add(pnMess);
		
		lblGioiTinh.setPreferredSize(lblTenKH.getPreferredSize());
		radNam.setPreferredSize(lblTenKH.getPreferredSize());
		radNu.setPreferredSize(lblTenKH.getPreferredSize());
		lblMaKH.setPreferredSize(lblTenKH.getPreferredSize());
		lblTenKH.setPreferredSize(lblTenKH.getPreferredSize());
		lblEmail.setPreferredSize(lblTenKH.getPreferredSize());
		lblSDT.setPreferredSize(lblTenKH.getPreferredSize());
		lblCMND.setPreferredSize(lblTenKH.getPreferredSize());
		lblDiaChi.setPreferredSize(lblTenKH.getPreferredSize());
		
		
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
		
		/* if (flag == true) {
			dinhDangMaNhaCungCap();
			txtTenKH.setText("");
			txtEmail.setText("");
			txtDiaChi.setText("");
			txtSDT.setText("");
			txtCMND.setText("");
		}
		else {
			txtMaKH.setText(khachhang.getMaKH());
			txtTenKH.setText(khachhang.getTenKH());
			txtEmail.setText(khachhang.getEmail());
			txtDiaChi.setText(khachhang.getDiaChi());
			txtSDT.setText(khachhang.getSoDT());
			txtCMND.setText(khachhang.getCmnd());
		} */
		btnLuu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(flag == true) {
					if(validData()) {
						String maKH = txtMaKH.getText().trim();
						String tenKH = txtTenKH.getText().trim();
						String email = txtEmail.getText().trim();
						String DiaChi = txtDiaChi.getText().trim();
						String SDT = txtSDT.getText().trim();
						String cmnd = txtCMND.getText().trim();
						khachhang = new KhachHang(maKH, tenKH, email, DiaChi, SDT, cmnd, rootPaneCheckingEnabled);
						if(kh_dao.themKH(khachhang))
						{
							JOptionPane.showMessageDialog(null , "Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
							qlkh.modeltable.addRow(new Object[] {
									maKH, tenKH, email, DiaChi, SDT, cmnd, rootPaneCheckingEnabled
							});
						}
						dispose();
					}			
				}
				else if (flag == false ) {
					if(qlkh.row>=0) {
						String maKH = txtMaKH.getText().toString();
						String tenKH = txtTenKH.getText().toString();
						String email = txtEmail.getText().toString();
						String DiaChi = txtDiaChi.getText().toString();
						String SDT = txtSDT.getText().toString();
						String cmnd = txtCMND.getText().toString();
						khachhang = new KhachHang(maKH, tenKH, email, DiaChi, SDT, cmnd, rootPaneCheckingEnabled);
						
						if(kh_dao.update(khachhang)) {
							qlkh.table.setValueAt(txtTenKH.getText(), qlkh.row, 1);
							qlkh.table.setValueAt(txtEmail.getText(),qlkh.row,2);
							qlkh.table.setValueAt(txtDiaChi.getText(),qlkh.row,3);
							qlkh.table.setValueAt(txtSDT.getText(),qlkh.row,4);
							qlkh.table.setValueAt(txtCMND.getText(),qlkh.row,5);
						}
					}
					JOptionPane.showMessageDialog(null , "Sửa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}	
			}
		});
	}
	
	public static void main(String[] args) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnLamMoi)) {
			txtMaKH.setText("");
			txtTenKH.setText("");
			txtEmail.setText("");
			txtDiaChi.setText("");
			txtSDT.setText("");
			txtCMND.setText("");
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
		String tenNCC = txtTenKH.getText().trim();
		if(!(tenNCC.length() > 0))
		{
			showMessage("Error: Tên khách hàng không được rỗng", txtTenKH);
			return false;
		}
		return true;
	}
	private void dinhDangMaNhaCungCap() {
		int makh= kh_dao.LayMaKHLonNhat()+1;
		txtMaKH.setText("KH000"+makh);
	}

}
