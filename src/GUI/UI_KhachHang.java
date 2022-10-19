package GUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

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
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.KhachHang_DAO;
import entity.KhachHang;


public class UI_KhachHang  extends JFrame  implements ActionListener,MouseListener {

	DefaultTableModel modeltable;
	JTable table;
	JTextField txtTim,txtTenKH,txtMaKH,txtDiaChi,txtEmail,txtSoDT,txtCMND;
	JButton btnTim, btnThem, btnLuu, btnXoa, btnCapNhat;
	JLabel lblMaKH,lblTenKH,lblDiaChi,lblEmail,lblSoDT,lblCMND,lblGioiTinh;
	JRadioButton radNam, radNu;
	JComboBox<KhachHang>cbGioiTinh;
	private javax.swing.JTable tblKhachHang;
	private javax.swing.JScrollPane jScrollPane1;
	private KhachHang_DAO dao_kh = new KhachHang_DAO();	
	private UI_ThongTinKhachHang ttkh = new UI_ThongTinKhachHang();
	public UI_KhachHang() {
		//setBackground(Color.YELLOW);
		setLayout(new BorderLayout());
		setTitle("THÔNG TIN KHÁCH HÀNG");
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);	
		setSize(550,600);
		setLocationRelativeTo(null);
		
		JPanel pnNorth = new JPanel();
		JLabel lblTieuDe = new JLabel("Quản Lý Khách Hàng");
		Font font =new Font("Arial",Font.BOLD,25);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		pnNorth.add(lblTieuDe);
		add(pnNorth,BorderLayout.NORTH);
		 pnNorth = new JPanel() { };
			JLabel lblTieuDeJLabel = new JLabel("Thông Tin Khách Hàng");
			Font font2 =new Font("Arial",Font.BOLD,15);
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
			
			jScrollPane1 = new javax.swing.JScrollPane();
	        tblKhachHang = new javax.swing.JTable();
				//Ma
			JPanel pnMaKH = new JPanel();
			lblMaKH = new JLabel("Mã khách hàng");
			txtMaKH = new JTextField(18);
			pnMaKH.add(lblMaKH);
			pnMaKH.add(txtMaKH);
			pnThongTin.add(pnMaKH);
			
				//Ten
			JPanel pnTenKH = new JPanel();
			lblTenKH = new JLabel("Tên khách hàng");
			txtTenKH = new JTextField(18);
			pnTenKH.add(lblTenKH);
			pnTenKH.add(txtTenKH);
			pnThongTin.add(pnTenKH);	
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
			lblSoDT = new JLabel("Số Điện Thoại");
			txtSoDT = new JTextField(18);
			pnSDT.add(lblSoDT);
			pnSDT.add(txtSoDT);
			pnThongTin.add(pnSDT);
				//CMND
			JPanel pnCMND = new JPanel();
			lblCMND = new JLabel("CMND");
			txtCMND = new JTextField(18);
			pnCMND.add(lblCMND);
			pnCMND.add(txtCMND);
			pnThongTin.add(pnCMND);
				
				
				//NgayVaoLam

				//User
//			JPanel pnUser = new JPanel();
//			lblUser = new JLabel("Tài khoản");
//			txtUser = new JTextField(18);
//			pnUser.add(lblUser);
//			pnUser.add(txtUser);
//			pnThongTin.add(pnUser);	
//				//User
//			JPanel pnPass = new JPanel();
//			lblPass = new JLabel("Mật khẩu");
//			txtPass = new JTextField(18);
//			pnPass.add(lblPass);
//			pnPass.add(txtPass);
//			pnThongTin.add(pnPass);	

				// Giới tính
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

			
			lblGioiTinh.setPreferredSize(lblTenKH.getPreferredSize());
			radNam.setPreferredSize(lblTenKH.getPreferredSize());
			radNu.setPreferredSize(lblTenKH.getPreferredSize());
			lblMaKH.setPreferredSize(lblTenKH.getPreferredSize());
			lblEmail.setPreferredSize(lblTenKH.getPreferredSize());
			lblSoDT.setPreferredSize(lblTenKH.getPreferredSize());
			lblCMND.setPreferredSize(lblTenKH.getPreferredSize());
			lblDiaChi.setPreferredSize(lblTenKH.getPreferredSize());
		//	cbGioiTinh.setPreferredSize(txtCMND.getPreferredSize());
		
		
//		
//		String[] chuoi = {"Mã khách hàng","Tên khách hàng","Số điện thoại","Email","CMND","Địa chỉ","Giới tính"};
//		modeltable = new DefaultTableModel(chuoi,0);
//		table = new JTable(modeltable);
//		JScrollPane sc = new JScrollPane(table);
//		add(sc,BorderLayout.CENTER);
		
			
		String[] header= {"Mã khách hàng","Tên khách hàng","Email","Địa chỉ","Số ĐT","số CMND","Giới tính"};
	    modeltable =new DefaultTableModel(header,0);
	    tblKhachHang=new JTable(modeltable);
	    jScrollPane1.setViewportView(tblKhachHang);
	    DocLenTblKhachHang();
	    
		//SOUTH
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		add(pnSouth,BorderLayout.SOUTH);
	
		JPanel pnLeft = new JPanel();
		JPanel pnRight = new JPanel();
		pnRight.setPreferredSize(new Dimension(400,80));
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		
		//	LEFT
		/* txtTim = new JTextField(10);
		btnTim = new JButton("Tìm kiếm");
		pnLeft.add(txtTim);
		pnLeft.add(btnTim); */
			//RIGHT
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("Icon/them.png"));
		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("Icon/sua.png"));
		btnXoa = new JButton("Xóa Rỗng");
		btnXoa.setIcon(new ImageIcon("Icon/remove.png"));
		btnCapNhat = new JButton("Thoát");
		btnCapNhat.setIcon(new ImageIcon("Icon/thoat.png"));
		pnRight.add(btnThem);
		pnRight.add(btnLuu);
		pnRight.add(btnXoa);
		pnRight.add(btnCapNhat);
		pnSouth.add(sp);
		
		tblKhachHang.addMouseListener(this);
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnXoa.addActionListener(this);
		btnCapNhat.addActionListener(this);
		
		
	}
	public static void main(String[] args) {
		UI_KhachHang ttkh = new UI_KhachHang();
		//ttnv.setBackground(new ImageIcon("Icon/1767.jpg"));
		ttkh.setVisible(true);

	}
	
	public void DocLenTblKhachHang() {
    	ArrayList<KhachHang> listkh=dao_kh.LayHetKhachHang();
    	String gioitinh;
    	for(KhachHang kh: listkh) {
    		if(kh.getGioiTinh()) {
    			gioitinh="Nam";
    		}
    		else
    			gioitinh="Nữ";
    		
    		Object[] ob= {kh.getMaKH(),kh.getTenKH(),kh.getEmail(),kh.getDiaChi(),kh.getSoDT(),kh.getCmnd(),gioitinh};
    		modeltable.addRow(ob);
    	}
    }
	
	public void xoaRong() {
    	txtMaKH.setText("");
		txtTenKH.setText("");
		txtEmail.setText("");
		txtDiaChi.setText("");
		txtSoDT.setText("");
		txtCMND.setText("");
		radNam.setSelected(false);
		radNu.setSelected(false);
    }
    public void dongCN(boolean b) {
    	btnThem.setEnabled(b);
    	btnCapNhat.setEnabled(b);
    	btnLuu.setEnabled(b);
    	btnXoa.setEnabled(b);
    }
    public void dongText(boolean b) {
		txtTenKH.setEditable(b);
		txtEmail.setEditable(b);
		txtDiaChi.setEditable(b);
		txtSoDT.setEditable(b);
		txtCMND.setEditable(b);
    }
    public void deleteTblKH() {
    	DefaultTableModel df=(DefaultTableModel) tblKhachHang.getModel();
    	df.getDataVector().removeAllElements();
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			if(btnThem.getText().equalsIgnoreCase("Thêm")) {
				//dongText(true);
				xoaRong();
				//dongCN(false);
				int makh= dao_kh.LayMaKHLonNhat()+1;
				txtMaKH.setText("KH000"+makh);
				btnLuu.setEnabled(true);
				btnThem.setEnabled(true);
				btnThem.setText("Hủy");
			}
			else if(btnThem.getText().equalsIgnoreCase("Hủy")) {
				//dongCN(true);
				//dongText(false);
				btnThem.setText("Thêm");
				btnLuu.setEnabled(false);
			}
			
		}
		else if(o.equals(btnCapNhat)) {
			if(btnCapNhat.getText().equalsIgnoreCase("Sửa")) {
				//dongCN(false);
				//dongText(true);
				btnLuu.setEnabled(true);
				btnCapNhat.setEnabled(true);
				btnCapNhat.setText("Hủy");
			}
			else if(btnCapNhat.getText().equalsIgnoreCase("Hủy")) {
				//dongText(false);
				//dongCN(true);
				btnCapNhat.setText("Sửa");
				btnLuu.setEnabled(false);
			}	
		}
		else if(o.equals(btnLuu)) {
			if(btnThem.isEnabled()) {
				if(validData()) {
					String ma=txtMaKH.getText();
					String ten=txtTenKH.getText();
					String email=txtEmail.getText();
					String diachi=txtDiaChi.getText();
					String sdt=txtSoDT.getText();
					String cmnd=txtCMND.getText();
					String gioitinh;
					if(radNam.isSelected())
						gioitinh="Nam";
					else 
						gioitinh="Nữ";
					
					KhachHang kh=new KhachHang(ma,ten,email,diachi,sdt,cmnd,radNam.isSelected());
					if(dao_kh.themKH(kh)) {
						JOptionPane.showMessageDialog(this,"Thêm thành công");
					}
					else
						JOptionPane.showMessageDialog(this,"Thêm không thành công");
					
					Object[] ob= {kh.getMaKH(),kh.getTenKH(),kh.getEmail(),kh.getDiaChi(),kh.getSoDT(),kh.getCmnd(),gioitinh};
		    		modeltable.addRow(ob);
		    		xoaRong();
		    		int makh=dao_kh.LayMaKHLonNhat()+1;
					txtMaKH.setText("KH000"+makh);
				}	
	    		
			}
			else if(btnCapNhat.isEnabled()) {
				if(validData()) {
					String ma=txtMaKH.getText();
					String ten=txtTenKH.getText();
					String email=txtEmail.getText();
					String diachi=txtDiaChi.getText();
					String sdt=txtSoDT.getText();
					String cmnd=txtCMND.getText();
					boolean gioitinh;
					if(radNam.isSelected())
						gioitinh=true;
					else 
						gioitinh=false;
					
					KhachHang kh=new KhachHang(ma,ten,email,diachi,sdt,cmnd,gioitinh);
					if(dao_kh.update(kh)) {
						JOptionPane.showMessageDialog(this,"Cập nhật thành công");
					}
					else
						JOptionPane.showMessageDialog(this,"Cập nhật không thành công");
						
					deleteTblKH();
					DocLenTblKhachHang();
				}
				
			}	
		}
		/* else if(o.equals(btnTim)) {
			String ma=txtTim.getText();
			try {
				modeltable=dao_kh.timKiem("%"+ma+"%", "%"+ma+"%");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			tblKhachHang.setModel(modeltable);
			
		}*/
		else if(o.equals(btnXoa)) {
			/* int row = tblKhachHang.getSelectedRow();
			String ma= modeltable.getValueAt(row, 0).toString();
			try {
				dao_kh.xoaKH(ma);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			deleteTblKH();
			DocLenTblKhachHang(); */
			txtTenKH.setText("");
			txtEmail.setText("");
			txtCMND.setText("");
			txtDiaChi.setText("");
			txtSoDT.setText("");
			radNam.setSelected(true);
			
		}
	}
	private boolean validData() {
		String tenNV = txtTenKH.getText();
		String cmnd = txtCMND.getText();
		String diaChi = txtDiaChi.getText();
		String email = txtEmail.getText();
		String sdt = txtSoDT.getText();
		if(!(tenNV.length()>0)){

			JOptionPane.showMessageDialog(null, "Tên khách hàng không trống " );
		
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
	@Override
	public void mouseClicked(MouseEvent e) {
		int row=tblKhachHang.getSelectedRow();
		txtMaKH.setText(modeltable.getValueAt(row, 0).toString());
		txtTenKH.setText(modeltable.getValueAt(row, 1).toString());
		txtEmail.setText(modeltable.getValueAt(row, 2).toString());
		txtDiaChi.setText(modeltable.getValueAt(row, 3).toString());
		txtSoDT.setText(modeltable.getValueAt(row, 4).toString());
		txtCMND.setText(modeltable.getValueAt(row, 5).toString());
		
		if(modeltable.getValueAt(row, 6).toString()=="Nam")
			radNam.setSelected(true);
		else
			radNu.setSelected(true);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
