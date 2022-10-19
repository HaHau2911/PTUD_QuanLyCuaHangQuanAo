package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;


public class ChucNang extends JFrame implements ActionListener, MouseListener {

	private JPanel pnWest;
	private JButton btnQLKH;
	private JButton btnQLNV;
	private JButton btnThongKe;
	private JButton btnQLSanPham;
	private JButton btnQLHoaDon;
	private JButton btnQLNhaCungCap;
	private JButton btnChucNang;
	private JButton btnDangXuat;
	JLabel nButton1,nButton2,nButton3,nButton4, nButton5, nButton6,nButton7,nButton8, nButton9;
	JPanel pnCenter;
	JPanel pnCC;
	JPanel pnQLKH;
	JPanel pnQLSanPham;
	JPanel pnQLNV;
	JPanel pnQLThongKe;
	JPanel pnQLHoaDon;
	JPanel pnQLNhaCungCap;
	JPanel pnDangXuat;
	boolean flag = true;
	ThongTinNhaCungCap ttncc;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	NhanVien_DAO nhanVien_dao;
	UI_ThongTinNhanVien nv = new UI_ThongTinNhanVien();
	UI_ThongTinKhachHang kh = new UI_ThongTinKhachHang();
	private JPanel pnTrangChu;
	private JLabel lblLogo;
	private JButton btnTrangChu;
	
	public static String maNhanVien;
	
	public ChucNang(String maNV) throws Exception {
	//public ChucNang() {
		setTitle("Chức năng");
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		setSize(1200,700);
		setLocationRelativeTo(null);
		
		maNhanVien = maNV;
		nhanVien_dao = new NhanVien_DAO();
		pnQLKH= new JPanel();
		pnQLKH = new UI_ThongTinKhachHang();
		pnQLSanPham = new JPanel();
		pnQLSanPham = new QuanLySanPham();
		pnQLNV = new JPanel();
		pnQLNV = new UI_ThongTinNhanVien();
		pnQLThongKe = new JPanel();
		pnQLThongKe = new QuanLyThongKe();
		pnQLHoaDon = new JPanel();
		pnQLHoaDon = new MenuHoaDon();
		pnQLNhaCungCap = new JPanel();
		pnQLNhaCungCap = new QuanLyNhaCungCap();
		pnTrangChu = new JPanel();
		pnTrangChu = new TrangChu();
		
		//North
		JPanel pnNorth = new JPanel();
		
		pnNorth.setLayout(new BorderLayout());
		pnNorth.setBackground(Color.cyan);
		
		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBackground(new Color(204, 255, 255));
		pnTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblTieuDe = new JLabel("Quản Lý Cửa Hàng Quần Áo");
		Font font =new Font("Arial",Font.BOLD,25);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		pnTieuDe.add(lblTieuDe);
		
		JPanel pnTTNhanVien = new JPanel();
		pnTTNhanVien.setBackground(new Color(204, 255, 255));
		pnTTNhanVien.setLayout(new GridLayout(2,1));
		JPanel pnMaNV = new JPanel();
		pnMaNV.setBackground(new Color(204, 255, 255));
		JLabel lblMaNV = new JLabel("Mã nhân viên: ");
		txtMaNV = new JTextField(10);
		txtMaNV.setText(maNhanVien);
		txtMaNV.setEditable(false);
		txtMaNV.setOpaque(false);
		pnMaNV.add(lblMaNV);
		pnMaNV.add(txtMaNV);
		JPanel pnTenNV = new JPanel();
		pnTenNV.setBackground(new Color(204, 255, 255));
		JLabel lblTenNV = new JLabel("Tên nhân viên: ");
		txtTenNV = new JTextField(10);
		txtTenNV.setText(nhanVien_dao.LayNhanVienTheoMa(maNhanVien).getTenNV().toString());
		txtTenNV.setOpaque(false);
		txtTenNV.setEditable(false);
		pnTenNV.add(lblTenNV);
		pnTenNV.add(txtTenNV);
		
		lblMaNV.setPreferredSize(lblTenNV.getPreferredSize());
		pnTTNhanVien.add(pnMaNV);
		pnTTNhanVien.add(pnTenNV);
		pnTTNhanVien.setBackground(Color.CYAN);
		pnNorth.add(pnTTNhanVien,BorderLayout.EAST);
		pnNorth.add(pnTieuDe,BorderLayout.CENTER);
		pnNorth.add(pnTieuDe,BorderLayout.CENTER);
		add(pnNorth,BorderLayout.NORTH);
	
		
		//Center
		pnCenter = new JPanel();
		pnCenter.setLayout(new BorderLayout());
		pnCC = new JPanel();
		pnCenter.add(pnTrangChu);
		add(pnCenter, BorderLayout.CENTER);
		
		//WEST
		pnWest = new JPanel();
		pnWest.setBackground(new Color(204, 255, 255));
		pnWest.setLayout(new BorderLayout());
		JLabel iconLabel = new JLabel(new ImageIcon("Icon/menu.png"));
		btnChucNang = new JButton("");
		btnChucNang.setLayout(new BorderLayout());
		btnChucNang.add(iconLabel,BorderLayout.CENTER);//Vinh 29-5
		btnChucNang.setPreferredSize(new Dimension(50,50));
		btnChucNang.setBackground(new Color(204, 255, 255));
		btnChucNang.setBorderPainted(false);
		btnChucNang.setFocusPainted(false);
		btnChucNang.setContentAreaFilled(false);
		btnChucNang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblLogo = new JLabel(ResizeImage("Icon/sun.png"));
		lblLogo.setPreferredSize(new Dimension(140,50));
		JPanel pnChucNang = new JPanel();
		pnChucNang.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnChucNang.setPreferredSize(pnTTNhanVien.getPreferredSize());
		pnChucNang.add(btnChucNang);
		pnChucNang.add(lblLogo);
		pnChucNang.setBackground(new Color(204, 255, 255));
		pnNorth.add(pnChucNang,BorderLayout.WEST);
		
		JLabel iconLabel1 = new JLabel(new ImageIcon("Icon/qlkh.png"));
		nButton1 = new JLabel("Quản lý khách hàng", SwingConstants.CENTER);
		btnQLKH = new JButton("");
		btnQLKH.setLayout(new BorderLayout());
		btnQLKH.add(iconLabel1,BorderLayout.WEST);
		btnQLKH.add(nButton1,BorderLayout.CENTER);
		
		JLabel iconLabel2 = new JLabel(new ImageIcon("Icon/qlnv2.png"));
		nButton2 = new JLabel("Quản lý nhân viên", SwingConstants.CENTER);
		btnQLNV = new JButton("");
		btnQLNV.setLayout(new BorderLayout());
		btnQLNV.add(iconLabel2,BorderLayout.WEST);
		btnQLNV.add(nButton2,BorderLayout.CENTER);
		
		JLabel iconLabel3 = new JLabel(new ImageIcon("Icon/thongke.png"));
		nButton3 = new JLabel("Quản lý thống kê", SwingConstants.CENTER);
		btnThongKe = new JButton("");
		btnThongKe.setLayout(new BorderLayout());
		btnThongKe.add(iconLabel3,BorderLayout.WEST);
		btnThongKe.add(nButton3,BorderLayout.CENTER);
		
		
		JLabel iconLabel4 = new JLabel(new ImageIcon("Icon/qltour.png"));
		nButton4 = new JLabel("Quản lý sản phẩm", SwingConstants.CENTER);
		btnQLSanPham = new JButton("");
		btnQLSanPham.setLayout(new BorderLayout());
		btnQLSanPham.add(iconLabel4,BorderLayout.WEST);
		btnQLSanPham.add(nButton4,BorderLayout.CENTER);
		
		JLabel iconLabel5 = new JLabel(new ImageIcon("Icon/ticket1.png"));
		nButton5 = new JLabel("Đặt hàng", SwingConstants.CENTER);
		btnQLHoaDon = new JButton("");
		btnQLHoaDon.setLayout(new BorderLayout());
		btnQLHoaDon.add(iconLabel5,BorderLayout.WEST);
		btnQLHoaDon.add(nButton5,BorderLayout.CENTER);
		
		JLabel iconLabel6 = new JLabel(new ImageIcon("Icon/QLDD5.png"));
		nButton6 = new JLabel("Quản lý nhà cung cấp", SwingConstants.CENTER);
		btnQLNhaCungCap = new JButton("");
		btnQLNhaCungCap.setLayout(new BorderLayout());
		btnQLNhaCungCap.add(iconLabel6,BorderLayout.WEST);
		btnQLNhaCungCap.add(nButton6,BorderLayout.CENTER);
		
		
		//Na
		
		//Nam
		JLabel iconLabel8 = new JLabel(new ImageIcon("Icon/log-out.png"));
		nButton8 = new JLabel("Đăng xuất", SwingConstants.CENTER);
		nButton8.setForeground(Color.WHITE);
		btnDangXuat = new JButton("");
		btnDangXuat.setLayout(new BorderLayout());
		btnDangXuat.add(iconLabel8,BorderLayout.WEST);
		btnDangXuat.add(nButton8,BorderLayout.CENTER);
		//Thái
		JLabel iconLabel9 = new JLabel(new ImageIcon("Icon/house.png"));
		nButton9 = new JLabel("Trang Chủ", SwingConstants.CENTER);
		btnTrangChu = new JButton("");
		btnTrangChu.setLayout(new BorderLayout());
		btnTrangChu.add(iconLabel9,BorderLayout.WEST);
		btnTrangChu.add(nButton9,BorderLayout.CENTER);
		
		
		
		btnChucNang.setBackground(Color.WHITE);
		btnQLKH.setBackground(Color.WHITE);
		btnQLNV.setBackground(Color.WHITE);
		btnQLSanPham.setBackground(Color.WHITE);
		btnThongKe.setBackground(Color.WHITE);
		btnQLHoaDon.setBackground(Color.WHITE);
		btnQLSanPham.setBackground(Color.WHITE);
		//Thái
		btnTrangChu.setBackground(Color.WHITE);
		//Nam
		btnDangXuat.setBackground(new Color(255, 51, 0));
		JPanel pnCN = new JPanel();
		pnCN.setBackground(new Color(204, 255, 255));
		pnCN.add(btnTrangChu);
		pnCN.add(btnQLHoaDon);
		pnCN.add(btnQLSanPham);
		pnCN.add(btnQLKH);
		pnCN.add(btnQLNV);
		//Nam
		pnCN.add(btnQLNhaCungCap);
		pnCN.add(btnThongKe);
		//Nam
		JPanel pnDX = new JPanel();
		pnDX.add(btnDangXuat);
		pnDX.setBackground(new Color(204, 255, 255));
		pnWest.add(pnCN, BorderLayout.CENTER);
		pnWest.add(pnDX,BorderLayout.SOUTH);
		pnWest.setPreferredSize(new Dimension(200,400));
		btnQLKH.setPreferredSize(new Dimension(180,50));
		btnQLNV.setPreferredSize(btnQLKH.getPreferredSize());
		btnThongKe.setPreferredSize(btnQLKH.getPreferredSize());
		btnQLSanPham.setPreferredSize(btnQLKH.getPreferredSize());
		btnQLHoaDon.setPreferredSize(btnQLKH.getPreferredSize());
		btnTrangChu.setPreferredSize(btnQLKH.getPreferredSize());
		btnQLNhaCungCap.setPreferredSize(btnQLKH.getPreferredSize());
		//Nam
		btnDangXuat.setPreferredSize(btnQLKH.getPreferredSize());
		add(pnWest,BorderLayout.WEST);
		
		btnChucNang.addActionListener(this);
		btnQLKH.addActionListener(this);
		btnQLSanPham.addActionListener(this);
		btnQLNV.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnQLHoaDon.addActionListener(this);
		btnQLNhaCungCap.addActionListener(this);
		btnTrangChu.addActionListener(this);
		//Nam
		
		btnDangXuat.addActionListener(this);
		
		
		//btnChucNang.addMouseListener(this);
		btnQLKH.addMouseListener(this);
		btnQLSanPham.addMouseListener(this);
		btnQLNV.addMouseListener(this);
		btnThongKe.addMouseListener(this);
		btnQLHoaDon.addMouseListener(this);
		btnQLNhaCungCap.addMouseListener(this);
		btnTrangChu.addMouseListener(this);
		lblLogo.addMouseListener(this);
		//Nam
	}

	public static void main(String[] args) throws Exception {
		new ChucNang(maNhanVien).setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		//Nam
		if(object.equals(btnQLKH)) {
			try {
				loadKH();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//Vinh
			btnQLKH.setBackground(new Color(153, 255, 153));
			btnQLNhaCungCap.setBackground(Color.WHITE);
			btnThongKe.setBackground(Color.WHITE);
			btnQLNV.setBackground(Color.WHITE);
			btnQLSanPham.setBackground(Color.WHITE);
			btnQLHoaDon.setBackground(Color.WHITE);
			btnQLHoaDon.setBackground(Color.WHITE);
			btnTrangChu.setBackground(Color.WHITE);
			
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnQLKH,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
			
		}
		
		else if(object.equals(btnQLSanPham)) {
			//Vinh
			btnQLSanPham.setBackground(new Color(153, 255, 153));
			btnQLKH.setBackground(Color.WHITE);
			btnQLNhaCungCap.setBackground(Color.WHITE);
			btnThongKe.setBackground(Color.WHITE);
			btnQLNV.setBackground(Color.WHITE);
			btnQLHoaDon.setBackground(Color.WHITE);
			btnTrangChu.setBackground(Color.WHITE);
			
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnQLSanPham,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}
		//Nam
		else if(object.equals(btnQLNV)) {
			try {
				loadNV();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//Vinh
			btnQLNV.setBackground(new Color(153, 255, 153));
			btnQLSanPham.setBackground(Color.WHITE);
			btnThongKe.setBackground(Color.WHITE);
			btnQLNhaCungCap.setBackground(Color.WHITE);
			btnQLKH.setBackground(Color.WHITE);
			btnQLHoaDon.setBackground(Color.WHITE);
			btnTrangChu.setBackground(Color.WHITE);
			
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnQLNV,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}
		else if(object.equals(btnChucNang)) {
			if (flag == true) {
				pnWest.setPreferredSize(new Dimension(68,400));
				btnQLKH.remove(nButton1);
				btnQLNV.remove(nButton2);
				btnThongKe.remove(nButton3);
				btnQLSanPham.remove(nButton4);
				btnQLHoaDon.remove(nButton5);
				btnQLNhaCungCap.remove(nButton6);
				btnDangXuat.remove(nButton8);
				btnTrangChu.remove(nButton9);
				btnQLKH.setPreferredSize(new Dimension(60,50));
				btnQLSanPham.setPreferredSize(new Dimension(60,50));
				btnQLNV.setPreferredSize(new Dimension(60,50));
				btnThongKe.setPreferredSize(new Dimension(60,50));
				btnQLHoaDon.setPreferredSize(new Dimension(60,50));
				btnQLNhaCungCap.setPreferredSize(new Dimension(60,50));
				btnDangXuat.setPreferredSize(new Dimension(60,50));
				btnTrangChu.setPreferredSize(new Dimension(60,50));
				pnWest.revalidate();
				flag = false; 
			}
			else if(flag == false){
				pnWest.setPreferredSize(new Dimension(200,400));
				btnQLKH.add(nButton1, BorderLayout.CENTER);
				btnQLNV.add(nButton2,BorderLayout.CENTER);
				btnThongKe.add(nButton3,BorderLayout.CENTER);
				btnQLSanPham.add(nButton4,BorderLayout.CENTER);
				btnQLHoaDon.add(nButton5,BorderLayout.CENTER);
				btnQLNhaCungCap.add(nButton6,BorderLayout.CENTER); // Vinh -29-5
				btnDangXuat.add(nButton8, BorderLayout.CENTER);
				btnTrangChu.add(nButton9,BorderLayout.CENTER);
				btnQLKH.setPreferredSize(new Dimension(180,50));
				btnQLSanPham.setPreferredSize(new Dimension(180,50));
				btnQLNV.setPreferredSize(new Dimension(180,50));
				btnThongKe.setPreferredSize(new Dimension(180,50));
				btnQLHoaDon.setPreferredSize(new Dimension(180,50));
				btnQLNhaCungCap.setPreferredSize(new Dimension(180,50));
				btnDangXuat.setPreferredSize(new Dimension(180,50));
				btnTrangChu.setPreferredSize(new Dimension(180,50));
				pnWest.revalidate();
				flag = true;
			}
		}
		else if(object.equals(btnThongKe)) {
			//Vinh
			btnThongKe.setBackground(new Color(153, 255, 153));
			btnQLNV.setBackground(Color.WHITE);
			btnQLSanPham.setBackground(Color.WHITE);
			btnQLNhaCungCap.setBackground(Color.WHITE);
			btnQLKH.setBackground(Color.WHITE);
			btnQLHoaDon.setBackground(Color.WHITE);
			btnTrangChu.setBackground(Color.WHITE);
			
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnQLThongKe,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}
		else if(object.equals(btnQLHoaDon)) {
			//Vinh
			btnQLHoaDon.setBackground(new Color(153, 255, 153));
			btnQLNV.setBackground(Color.WHITE);
			btnQLSanPham.setBackground(Color.WHITE);
			btnThongKe.setBackground(Color.WHITE);
			btnQLNhaCungCap.setBackground(Color.WHITE);
			btnQLKH.setBackground(Color.WHITE);
			btnTrangChu.setBackground(Color.WHITE);
			
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnQLHoaDon,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}
		else if(object.equals(btnQLNhaCungCap)) {
			//Vinh
			btnQLNhaCungCap.setBackground(new Color(153, 255, 153));
			btnQLNV.setBackground(Color.WHITE);
			btnQLSanPham.setBackground(Color.WHITE);
			btnThongKe.setBackground(Color.WHITE);
			btnQLKH.setBackground(Color.WHITE);
			btnQLHoaDon.setBackground(Color.WHITE);
			btnTrangChu.setBackground(Color.WHITE);
			
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnQLNhaCungCap,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}
		//Vinh
		else if(object.equals(btnTrangChu)) {
			btnTrangChu.setBackground(new Color(153, 255, 153));
			btnQLNV.setBackground(Color.WHITE);
			btnQLSanPham.setBackground(Color.WHITE);
			btnThongKe.setBackground(Color.WHITE);
			btnQLKH.setBackground(Color.WHITE);
			btnQLHoaDon.setBackground(Color.WHITE);
			btnQLNhaCungCap.setBackground(Color.WHITE);
			
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnTrangChu,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}
		//Nam
		
		//Nam
		else if(object.equals(btnDangXuat)) {
			
			JFrame f= new JFrame();
			int hoi=JOptionPane.showConfirmDialog(f, "Bạn có chắc muốn đăng xuất?","Chú ý",JOptionPane.YES_NO_OPTION);
			if(hoi==JOptionPane.YES_OPTION) {
				try {
					GUI_DangNhapNV dn = new GUI_DangNhapNV();
					dn.setVisible(true);
					dispose();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//Vinh
		Object obj = e.getSource();
		 if(obj.equals(lblLogo)) {
			 btnTrangChu.setBackground(Color.CYAN);
				btnQLNV.setBackground(Color.WHITE);
				btnQLSanPham.setBackground(Color.WHITE);
				btnThongKe.setBackground(Color.WHITE);
				btnQLKH.setBackground(Color.WHITE);
				btnQLHoaDon.setBackground(Color.WHITE);
				btnQLNhaCungCap.setBackground(Color.WHITE);
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnTrangChu,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}
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
		Object obj = e.getSource();
		if(flag==true)
		{
			if(obj.equals(btnQLKH)) {
				btnQLKH.setPreferredSize(new Dimension(200,70));
				btnQLKH.revalidate();
			}
			else if(obj.equals(btnQLSanPham)) {
				btnQLSanPham.setPreferredSize(new Dimension(200,70));
				btnQLSanPham.revalidate();
			}
			else if(obj.equals(btnThongKe)) {
				btnThongKe.setPreferredSize(new Dimension(200,70));
				btnThongKe.revalidate();
			}
			else if(obj.equals(btnQLNV)) {
				btnQLNV.setPreferredSize(new Dimension(200,70));
				btnQLNV.revalidate();
			}
			else if(obj.equals(btnQLHoaDon)) {
				btnQLHoaDon.setPreferredSize(new Dimension(200,70));
				btnQLHoaDon.revalidate();
			}
			else if(obj.equals(btnQLNhaCungCap)) {
				btnQLNhaCungCap.setPreferredSize(new Dimension(200,70));
				btnQLNhaCungCap.revalidate();
			}
			//Vinh
			else if(obj.equals(btnTrangChu)) {
				btnTrangChu.setPreferredSize(new Dimension(200,70));
				btnTrangChu.revalidate();
			}
			
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(flag==true) {
			if(obj.equals(btnQLKH)) {
				btnQLKH.setPreferredSize(new Dimension(180,50));
				btnQLKH.revalidate();
			}
			else if(obj.equals(btnQLSanPham)) {
				btnQLSanPham.setPreferredSize(new Dimension(180,50));
				btnQLSanPham.revalidate();
			}
			else if(obj.equals(btnThongKe)) {
				btnThongKe.setPreferredSize(new Dimension(180,50));
				btnThongKe.revalidate();
			}
			else if(obj.equals(btnQLNV)) {
				btnQLNV.setPreferredSize(new Dimension(180,50));
				btnQLNV.revalidate();
			}
			else if(obj.equals(btnQLHoaDon)) {
				btnQLHoaDon.setPreferredSize(new Dimension(180,50));
				btnQLHoaDon.revalidate();
			}
			else if(obj.equals(btnQLNhaCungCap)) {
				btnQLNhaCungCap.setPreferredSize(new Dimension(180,50));
				btnQLNhaCungCap.revalidate();
			}
			//Vinh
			else if(obj.equals(btnTrangChu)) {
				btnTrangChu.setPreferredSize(new Dimension(180,50));
				btnTrangChu.revalidate();
			}
			//Nam
			
		}
		
	}
	//Nam
	private void loadNV() throws SQLException {
		NhanVien_DAO dao_nv = new NhanVien_DAO();
		nv.modeltable= dao_nv.getAllNV();
		nv.table.setModel(nv.modeltable);
	}
	private void loadKH() throws SQLException {
		KhachHang_DAO dao_kh = new KhachHang_DAO();
		kh.modeltable= dao_kh.getAllKH();
		kh.table.setModel(kh.modeltable);
	}
	
	public ImageIcon ResizeImage(String ImagePath)
	 {
		 ImageIcon MyImage = new ImageIcon(ImagePath);
		 Image img = MyImage.getImage();
		 Image newImg = img.getScaledInstance(140, 120, Image.SCALE_SMOOTH);
		 ImageIcon image = new ImageIcon(newImg);
	     return image;
	 }

}
