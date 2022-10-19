package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DAO.NhaCungCap_DAO;
import connectDB.ConnectDB;
import entity.NhaCungCap;


public class ThongTinNhaCungCap extends JFrame implements ActionListener{

	private JLabel lblMaNCC, lblTenNCC, lblNoiSX;
	private JTextField txtMaNCC, txtTenNCC, txtNoiSX ,txtMess;
	private JTextArea txtMoTa;
	private JComboBox cbxNoiSX;
	private JButton btnLamMoi, btnLuu, btnThoat;
	private JPanel pnNorth;
	private NhaCungCap_DAO ncc_dao;
	private QuanLyNhaCungCap qlncc;
	private NhaCungCap nhacungcap;
	boolean flag = true;

	public ThongTinNhaCungCap(NhaCungCap ncc,boolean flag)  {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ncc_dao = new NhaCungCap_DAO();
		nhacungcap = ncc;		  
		qlncc = new QuanLyNhaCungCap();

		setTitle("THÔNG TIN NHÀ CUNG CẤP");
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);	
		setSize(600,400);
		setLocationRelativeTo(null);

		pnNorth = new JPanel() { };
		JLabel lblTieuDe = new JLabel("Thông Tin Nhà Cung Cấp");
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
		JPanel pnMaNCC = new JPanel();
		lblMaNCC = new JLabel("Mã Nhà cung cấp");
		txtMaNCC = new JTextField(40);
		txtMaNCC.setEditable(false);
		pnMaNCC.add(lblMaNCC);
		pnMaNCC.add(txtMaNCC);
		pnThongTin.add(pnMaNCC);
			//Ten
		JPanel pnTenNCC = new JPanel();
		lblTenNCC = new JLabel("Tên Nhà cung cấp");
		txtTenNCC = new JTextField(40);
		pnTenNCC.add(lblTenNCC);
		pnTenNCC.add(txtTenNCC);
		pnThongTin.add(pnTenNCC);				
		
			//TinhThanh
		JPanel pnNoiSX = new JPanel();
		lblNoiSX = new JLabel("Nơi Sản Xuất");
		txtNoiSX = new JTextField(40);
		pnNoiSX.add(lblNoiSX);
		pnNoiSX.add(txtNoiSX);
		pnThongTin.add(pnNoiSX);
		
		JPanel pnMess = new JPanel();
		txtMess = new JTextField(32);
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));
		pnMess.add(txtMess);
		pnThongTin.add(pnMess);
		
			
		lblMaNCC.setPreferredSize(lblTenNCC.getPreferredSize());
		lblNoiSX.setPreferredSize(lblTenNCC.getPreferredSize());
		
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
		
		if (flag == true) {
			dinhDangMaNhaCungCap();
			txtTenNCC.setText("");
			txtNoiSX.setText("");
		}
		else {
			txtMaNCC.setText(nhacungcap.getMaNCC());
			txtTenNCC.setText(nhacungcap.getTenNCC());
			txtNoiSX.setText(nhacungcap.getNoiSX());
		}
		btnLuu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(flag == true) {
					if(validData()) {
						String maNCC = txtMaNCC.getText().trim();
						String tenNCC = txtTenNCC.getText().trim();
						String NoiSX = txtNoiSX.getText().trim();
						nhacungcap = new NhaCungCap(maNCC, tenNCC, NoiSX);
						
						if(ncc_dao.themNCC(nhacungcap))
						{
							JOptionPane.showMessageDialog(null , "Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
							qlncc.modeltable.addRow(new Object[] {
									maNCC, tenNCC, NoiSX
							});
							xoaRong();
							dinhDangMaNhaCungCap();
						}
						
						dispose();
					}			
				}
				else if (flag == false ) {
					if(qlncc.row>=0) {
						String maNCC = txtMaNCC.getText().toString();
						String tenNCC = txtTenNCC.getText().toString();
						String NoiSX = txtNoiSX.getText().toString();
						nhacungcap = new NhaCungCap(maNCC, tenNCC, NoiSX);
						if(ncc_dao.update(nhacungcap)) {
							qlncc.table.setValueAt(txtTenNCC.getText(), qlncc.row, 1);
							qlncc.table.setValueAt(txtNoiSX.getText(),qlncc.row,2);
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
			txtTenNCC.setText("");
			txtNoiSX.setText("");
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
		String tenNCC = txtTenNCC.getText().trim();
		if(!(tenNCC.length() > 0))
		{
			showMessage("Error: Tên địa danh không được rỗng", txtTenNCC);
			return false;
		}
		return true;
		
	}
	
	public void xoaRong() {
    	txtMaNCC.setText("");
		txtTenNCC.setText("");
		txtNoiSX.setText("");
    }
	
	private void dinhDangMaNhaCungCap() {
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
		int maNCC= ncc_dao.layMaNhaCungCapLonNhat()+1;
		txtMaNCC.setText("NCC0"+maNCC);
	}
}
