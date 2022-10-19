package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import DAO.HoaDon_DAO;
import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;
import DAO.SanPham_DAO;
import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

public class DatHang extends JFrame implements KeyListener, ActionListener{

	private LopThietLapViTri frame;
	
	ButtonGroup btnGroup;
	JRadioButton radNam, radNu;
	JButton btnLamMoi, btnLuu, btnThoat;
	JPanel pnNorth;
	JPanel pnMain;
	ImageIcon background;
	JDialog dialog ;
	SanPham t ;
	private JTextField txtTenSP;

	private JTextField txtMaHD;

	private JTextField txtCMND;

	private JTextField txtTenKH;

	private JTextField txtDiaChi;

	private JTextField txtSoDT;

	private JTextField txtEmail;
	
	private SanPham_DAO sp_dao;
	private HoaDon_DAO hd_dao;
	private KhachHang_DAO khachHang_dao;
	private NhanVien_DAO nhanVien_dao;
	
	ArrayList<HoaDon> listhd;
	ArrayList<KhachHang> listKhachHang;
	ArrayList<ChiTietHoaDon> listcthd;

	private String maHD;
	
    public DatHang(SanPham sanpham) {
    	
    	try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sp_dao = new SanPham_DAO();
		hd_dao = new HoaDon_DAO();
    	khachHang_dao = new KhachHang_DAO();
    	nhanVien_dao = new NhanVien_DAO();
    	t=sanpham;
    	listhd = hd_dao.DanhSachHoaDontheoMaSP(t.getMaSP());
    	listKhachHang = khachHang_dao.LayHetKhachHang();
    	dialog = new JDialog();
        dialog.setTitle("Đặt hàng");
        dialog.setSize(new Dimension(400, 600));
      
        //dialog.setModalityType (ModalityType.APPLICATION_MODAL);
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);
        //pnKhachHang.setPreferredSize(new Dimension(400,700));     
        
        
        pnNorth = new JPanel();
		JLabel lblTieuDe = new JLabel("Nhập thông tin khách hàng");
		Font font =new Font("Arial",Font.BOLD,15);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		pnNorth.add(lblTieuDe);
		dialog.add(pnNorth, BorderLayout.NORTH);
		
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setLayout(new GridLayout(8,1));
		JPanel pnChucNang = new JPanel();
		pnChucNang.setLayout(new FlowLayout(FlowLayout.RIGHT));
				
		
		//Tên Tour
		JPanel pnTenSP = new JPanel();
		JLabel lblTenSP = new JLabel("Tên SP");
		txtTenSP = new JTextField(18);
		txtTenSP.setText(t.getTenSP());
		txtTenSP.setEnabled(false);
		pnTenSP.add(lblTenSP);
		pnTenSP.add(txtTenSP);
		pnThongTin.add(pnTenSP);
		
		//Mã vé
		JPanel pnMaHD = new JPanel();
		JLabel lblMaHD = new JLabel("Mã SP");
		txtMaHD = new JTextField(18);
		String soL = (String.valueOf(hd_dao.LayMaHoaDonLonNhat(t.getMaSP())+1) ).toString();
		if(soL.length()==1)
			txtMaHD.setText(t.getMaSP()+"-0"+soL);
		else
			txtMaHD.setText(t.getMaSP()+"-"+soL);
		txtMaHD.setEnabled(false);
		pnMaHD.add(lblMaHD);
		pnMaHD.add(txtMaHD);
		pnThongTin.add(pnMaHD);
		
		//CMND
		JPanel pnCMND = new JPanel();
		JLabel lblCMND = new JLabel("CMND");
		txtCMND = new JTextField(18);
		pnCMND.add(lblCMND);
		pnCMND.add(txtCMND);
		pnThongTin.add(pnCMND);
		
		//Ten
		JPanel pnTenKH = new JPanel();
		JLabel lblTenKH = new JLabel("Họ và tên");
		txtTenKH = new JTextField(18);
		pnTenKH.add(lblTenKH);
		pnTenKH.add(txtTenKH);
		pnThongTin.add(pnTenKH);		
		
		//DiaChi
		JPanel pnDiaChi = new JPanel();
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		txtDiaChi = new JTextField(18);
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(txtDiaChi);
		pnThongTin.add(pnDiaChi);
		
		//SDT
		JPanel pnSDT = new JPanel();
		JLabel lblSDT = new JLabel("Số ĐT");
		txtSoDT = new JTextField(18);
		pnSDT.add(lblSDT);
		pnSDT.add(txtSoDT);
		pnThongTin.add(pnSDT);
		
		//Email
		JPanel pnEmail = new JPanel();
		JLabel lblEmail = new JLabel("Email");
		txtEmail = new JTextField(18);
		pnEmail.add(lblEmail);
		pnEmail.add(txtEmail);
		pnThongTin.add(pnEmail);
		
		//GioiTinh
		JPanel pnGioiTinh = new JPanel();
		radNam = new JRadioButton("Nam");
		radNu = new JRadioButton("Nữ");
		ButtonGroup groupGioitinh = new ButtonGroup();
		
		radNam.setSelected(true);
		groupGioitinh.add(radNam);
		groupGioitinh.add(radNu);
		JLabel lblGioiTinh = new JLabel("Giới tính");
		pnGioiTinh.add(lblGioiTinh);
		pnGioiTinh.add(radNam);pnGioiTinh.add(radNu);
		pnThongTin.add(pnGioiTinh);	

		lblCMND.setPreferredSize(lblTenKH.getPreferredSize());
		lblDiaChi.setPreferredSize(lblTenKH.getPreferredSize());
		lblEmail.setPreferredSize(lblTenKH.getPreferredSize());
		lblMaHD.setPreferredSize(lblTenKH.getPreferredSize());
		lblSDT.setPreferredSize(lblTenKH.getPreferredSize());
		lblTenSP.setPreferredSize(lblTenKH.getPreferredSize());
		lblGioiTinh.setPreferredSize(new Dimension(74,30));
		radNam.setPreferredSize(new Dimension(90,30));
		radNu.setPreferredSize(new Dimension(90,30));
		
		pnThongTin.validate();
		pnThongTin.repaint();
		dialog.add(pnThongTin, BorderLayout.CENTER);
		dialog.add(pnChucNang,BorderLayout.SOUTH);
		
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("Icon/xoarong.png"));
		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("Icon/save.png"));
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Icon/thoat.png"));
		
		pnChucNang.add(btnLamMoi);
		pnChucNang.add(btnLuu);
		pnChucNang.add(btnThoat);
        
		btnThoat.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnLuu.addActionListener(this);
		txtCMND.addKeyListener(this);
        dialog.setVisible(true);

    }
	
	
	private boolean KiemTraNhapLieu() {
		
		if(!txtCMND.getText().matches("[1-9][0-9]{8,11}")) {
			JOptionPane.showMessageDialog(this, "CMND phải từ 9 đến 12 ký tự số, bắt đầu không là số 0!");
			txtCMND.requestFocus();
			txtCMND.selectAll();
			return false;
		}
		else if(txtTenKH.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống !");
			txtTenKH.requestFocus();
			txtTenKH.selectAll();
			return false;
		}
		else if(txtDiaChi.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống !");
			txtDiaChi.requestFocus();
			txtDiaChi.selectAll();
			return false;
		}
		else if(!txtSoDT.getText().matches("[0][0-9]{9}")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 số và bắt đầu là số 0 !");
			txtSoDT.requestFocus();
			txtSoDT.selectAll();
			return false;
		}
		
		return true;
	}
	private void TaoMoiKhachHang() {
		if(KiemTraNhapLieu()) {
			String maKH="";
			if(khachHang_dao.LayMaKHLonNhat()>99) {
				maKH ="KH0"+khachHang_dao.LayMaKHLonNhat()+1;
			}
			else maKH ="KH00"+khachHang_dao.LayMaKHLonNhat()+1;
			String tenKH = txtTenKH.getText();
			String email = txtEmail.getText();
			String diaChi = txtDiaChi.getText();
			String soDT = txtSoDT.getText();
			String cmnd = txtCMND.getText();
			boolean gioiTinh;
			if(radNam.isSelected())
				gioiTinh=true;
			else
				gioiTinh=false;
			KhachHang kh = new KhachHang(maKH, tenKH, email, diaChi, soDT, cmnd, gioiTinh);
			try {
				khachHang_dao.ThemKhachHang(kh);
				JOptionPane.showMessageDialog(this, "Thêm thông tin khách hàng thành công !");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Lỗi ! không thể tạo mới khách hàng !");
			}
		}
	}
	private boolean KiemTraCoThongTinKhachHang() {//Nếu không có thì tạo mới
		if(khachHang_dao.LayKhachHangTheoCMND(txtCMND.getText().trim())==null) {
			txtTenKH.setText("");
			txtDiaChi.setText("");
			txtEmail.setText("");
			txtSoDT.setText("");
			txtTenKH.setEditable(true);
			txtDiaChi.setEditable(true);
			txtEmail.setEditable(true);
			txtSoDT.setEditable(true);
			return false;
		}
		else {
			KhachHang kh = khachHang_dao.LayKhachHangTheoCMND(txtCMND.getText().trim());
			txtTenKH.setText(kh.getTenKH());
			txtDiaChi.setText(kh.getDiaChi());
			txtEmail.setText(kh.getEmail());
			txtSoDT.setText(kh.getSoDT());
			if(kh.getGioiTinh()==true)
				radNam.setSelected(true);
			else
				radNu.setSelected(true);
			txtTenKH.setEditable(false);
			txtDiaChi.setEditable(false);
			txtEmail.setEditable(false);
			txtSoDT.setEditable(false);
			return true;
		}
	}
	private void DatHang() {
		if(KiemTraNhapLieu()) {
			SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
		    String ngayLap = LocalDate.now().toString();
		    Date nht = java.sql.Date.valueOf(ngayLap);
		    int soL = hd_dao.DanhSachHoaDontheoMaSP(t.getMaSP()).size()+1;
		   // String soVe = (String.valueOf(ve_dao.LayMaVeLonNhat(t.getMaTour())+1) ).toString();
			String maHD="";
			if(String.valueOf(soL).length()==1)
			{
				maHD = t.getMaSP()+"-0"+soL;
				txtMaHD.setText(t.getMaSP()+"-0"+soL);
			}
				
			else {
				maHD = t.getMaSP()+"-"+soL;
				txtMaHD.setText(t.getMaSP()+"-"+soL);
			}
				
			KhachHang kh = khachHang_dao.LayKhachHangTheoCMND(txtCMND.getText());
			NhanVien nv = nhanVien_dao.LayNhanVienTheoMa(ChucNang.maNhanVien.toString());
			HoaDon hoadon = new HoaDon(maHD, nv, kh, nht);
			try {
				hd_dao.laydulieuhoadon(maHD);
				QuanLyHoaDon.qlHoaDon.TaiSPLen();
				JOptionPane.showMessageDialog(this, "Đặt hàng thành công!");
				dialog.dispose();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Lỗi! không thể đặt hàng !");
			}
		}
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE||e.getKeyCode()==KeyEvent.VK_DELETE)
        {
           KiemTraCoThongTinKhachHang();
        }
        else
        {   
            String to_check=txtCMND.getText();
            int to_check_len=to_check.length();
            for (KhachHang khachHang : listKhachHang) {
            	 String check_from_data="";
                 for(int i=0;i<to_check_len;i++)
                 {
                     if(to_check_len<=khachHang.getCmnd().length())
                     {
                         check_from_data = check_from_data+khachHang.getCmnd().charAt(i);
                     }
                 }
                 //System.out.print(check_from_data);
                 if(check_from_data.equals(to_check))
                 {
                     //System.out.print("Found");
                     txtCMND.setText(khachHang.getCmnd());
                     txtCMND.setSelectionStart(to_check_len);
                     txtCMND.setSelectionEnd(khachHang.getCmnd().length());
                     KiemTraCoThongTinKhachHang();
                     break;
                 }
                	 
			}
            KiemTraCoThongTinKhachHang();
        }
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnThoat)) {
			dialog.dispose();
		}
		else if(obj.equals(btnLamMoi)) {
			//Vinh 3-6
			txtCMND.setText("");
			txtDiaChi.setText("");
			txtEmail.setText("");
			txtSoDT.setText("");
			txtTenKH.setText("");
		}
		else if(obj.equals(btnLuu)) {
			if(khachHang_dao.LayKhachHangTheoCMND(txtCMND.getText().trim())==null) {
				if(KiemTraNhapLieu()) {
					Object[] options = {"Đồng ý", "Hủy bỏ"};
					 int result = JOptionPane.showOptionDialog(frame,
		                     "Đây là khách hàng mới, hệ thống sẽ lưu mới thông tin khách hàng này !",
		                     "Xác nhận",
		                     JOptionPane.YES_NO_OPTION,
		                     JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		             if(result == JOptionPane.YES_OPTION){
		            	 TaoMoiKhachHang();
		            	 DatHang();
		            	 dialog.dispose();
		             }
		             else if (result == JOptionPane.NO_OPTION){
		            	 
		             }
				}
				
			}
			else
			{
				DatHang();
				dialog.dispose();
			}
				
		}
	} 
	
}
