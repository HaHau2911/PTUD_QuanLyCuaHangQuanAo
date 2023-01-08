package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DAO.HoaDon_DAO;
import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;
import DAO.SanPham_DAO;
import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.GioHang;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

public class DatHang extends JFrame implements KeyListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LopThietLapViTri frame;

	ButtonGroup btnGroup;
	JButton btnLamMoi, btnLuu, btnThoat;
	JPanel pnNorth;
	JPanel pnMain;
	ImageIcon background;
	SanPham t;

	private JTextField txtMaHD;

	private JTextField txtCMND;

	private JTextField txtTenKH;

	private JTextField txtMaKH;

	private JTextField txtSoDT;

	private JTextField txtSoLuong;

	private SanPham_DAO sp_dao;
	private HoaDon_DAO hd_dao;
	private KhachHang_DAO khachHang_dao;
	private NhanVien_DAO nhanVien_dao;

	ArrayList<HoaDon> listhd;
	ArrayList<KhachHang> listKhachHang;
	ArrayList<ChiTietHoaDon> listcthd;

	private String maHD;
	private ArrayList<GioHang> gioHangs = new ArrayList<>();
	private String maNhanVien;

	
	public DatHang(ArrayList<GioHang> hangs, String maNV) {
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		maNhanVien = maNV;
		System.out.println(maNhanVien);
		gioHangs = hangs;
		gioHangs.forEach(gioHang -> System.out.println(gioHang.getMaSanPham() + "--" + gioHang.getSoLuong()));
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sp_dao = new SanPham_DAO();
		hd_dao = new HoaDon_DAO();
		khachHang_dao = new KhachHang_DAO();
		nhanVien_dao = new NhanVien_DAO();
//    	listhd = hd_dao.DanhSachHoaDontheoMaSP(t.getMaSP());
		listKhachHang = khachHang_dao.LayHetKhachHang();
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("Đặt hàng");
		this.setSize(new Dimension(400, 475));

		// dialog.setModalityType (ModalityType.APPLICATION_MODAL);
		this.setLocationRelativeTo(null);
//		this.setModal(true);
		// pnKhachHang.setPreferredSize(new Dimension(400,700));

		pnNorth = new JPanel();
		JLabel lblTieuDe = new JLabel("Nhập thông tin khách hàng");
		Font font = new Font("Arial", Font.BOLD, 15);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		pnNorth.add(lblTieuDe);
		this.getContentPane().add(pnNorth, BorderLayout.NORTH);

		JPanel pnThongTin = new JPanel();
		JPanel pnChucNang = new JPanel();

		// Mã vé
		JPanel pnMaHD = new JPanel();
		pnMaHD.setBounds(0, 0, 386, 63);
		JLabel lblMaSP = new JLabel("Mã HD");
		lblMaSP.setBounds(93, 8, 44, 13);
		txtMaHD = new JTextField(18);
		txtMaHD.setBounds(144, 5, 150, 19);
		int hdMax = hd_dao.getHDLonNHat();
		txtMaHD.setText("HD0" + hdMax);
		JLabel lblSoLuong = new JLabel("Số lượng");
		txtSoLuong = new JTextField(18);
		pnThongTin.setLayout(null);

		txtMaHD.setEnabled(false);
		pnMaHD.setLayout(null);
		pnMaHD.add(lblMaSP);
		pnMaHD.add(txtMaHD);
		pnThongTin.add(pnMaHD);

		// CMND
		JPanel pnCMND = new JPanel();
		pnCMND.setBounds(0, 63, 386, 63);
		JLabel lblCMND = new JLabel("CMND");
		lblCMND.setBounds(95, 14, 44, 13);
		txtCMND = new JTextField(18);
		txtCMND.setBounds(144, 11, 150, 19);
		pnCMND.setLayout(null);
		pnCMND.add(lblCMND);
		pnCMND.add(txtCMND);
		pnThongTin.add(pnCMND);

		// Ten
		JPanel pnTenKH = new JPanel();
		pnTenKH.setBounds(0, 199, 386, 63);
		JLabel lblTenKH = new JLabel("Họ và tên");
		lblTenKH.setBounds(94, 8, 43, 13);
		txtTenKH = new JTextField(18);
		txtTenKH.setBounds(144, 5, 150, 19);
		pnTenKH.setLayout(null);
		pnTenKH.add(lblTenKH);
		pnTenKH.add(txtTenKH);
		pnThongTin.add(pnTenKH);

		// DiaChi
		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setBounds(0, 129, 386, 63);
		JLabel lblMaKH = new JLabel("Mã khách hàng");
		lblMaKH.setBounds(57, 8, 77, 13);
		txtMaKH = new JTextField(18);
		txtMaKH.setBounds(144, 5, 150, 19);
		pnDiaChi.setLayout(null);
		pnDiaChi.add(lblMaKH);
		pnDiaChi.add(txtMaKH);
		pnThongTin.add(pnDiaChi);

		// SDT
		JPanel pnSDT = new JPanel();
		pnSDT.setBounds(0, 270, 386, 63);
		JLabel lblSDT = new JLabel("Số ĐT");
		lblSDT.setBounds(93, 8, 44, 13);
		txtSoDT = new JTextField(18);
		txtSoDT.setBounds(144, 5, 150, 19);
		pnSDT.setLayout(null);
		pnSDT.add(lblSDT);
		pnSDT.add(txtSoDT);
		pnThongTin.add(pnSDT);
		ButtonGroup groupGioitinh = new ButtonGroup();

		lblCMND.setPreferredSize(lblTenKH.getPreferredSize());

		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThongTinKhachHang frm = new ThongTinKhachHang(new KhachHang(), true);
				frm.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(299, 10, 49, 21);
		pnCMND.add(btnNewButton);
		lblTenKH.setPreferredSize(lblMaKH.getPreferredSize());
		lblMaSP.setPreferredSize(lblMaKH.getPreferredSize());
		lblSDT.setPreferredSize(lblMaKH.getPreferredSize());

		pnThongTin.validate();
		pnThongTin.repaint();
		this.getContentPane().add(pnThongTin, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBounds(10, 343, 366, 54);
		pnThongTin.add(panel);

		JButton btnDatHang = new JButton("Đặt hàng");
		btnDatHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(KiemTraNhapLieu()) {
					long millis = System.currentTimeMillis();
					java.sql.Date date = new java.sql.Date(millis);
					HoaDon hoaDon = new HoaDon(txtMaHD.getText().trim(), new NhanVien(maNhanVien),
							new KhachHang(txtMaKH.getText().trim()), date);
					if (hd_dao.taoHoaDon(hoaDon)) {
						System.out.println("Create hd");
					} else
						System.out.println("Fail create hd");
					gioHangs.forEach(hang -> sp_dao.updateSoLuong(hang.getSoLuong(), hang.getMaSanPham()));
					gioHangs.forEach(hang -> hd_dao.taoCTHoaDon(txtMaHD.getText().trim(), hang.getMaSanPham(),
							hang.getSoLuong()));
					JOptionPane.showMessageDialog(null, "Đặt hàng thành công");
					setVisible(false);
				}
			}
		});
		panel.add(btnDatHang);

		JButton btnXoaTrang = new JButton("Xoá trắng");
		panel.add(btnXoaTrang);

		JButton btnExits = new JButton("Thoát");
		btnExits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel.add(btnExits);
		this.getContentPane().add(pnChucNang, BorderLayout.SOUTH);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(192, 5, 71, 21);
		btnLamMoi.setIcon(new ImageIcon("Icon/xoarong.png"));
		btnLuu = new JButton("Lưu");
		btnLuu.setBounds(268, 5, 49, 21);
		btnLuu.setIcon(new ImageIcon("Icon/save.png"));
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(322, 5, 59, 21);
		btnThoat.setIcon(new ImageIcon("Icon/thoat.png"));
		pnChucNang.setLayout(null);

		pnChucNang.add(btnLamMoi);
		pnChucNang.add(btnLuu);
		pnChucNang.add(btnThoat);

		btnThoat.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnLuu.addActionListener(this);
		txtCMND.addKeyListener(this);
		this.setVisible(true);

	}

	private boolean KiemTraNhapLieu() {

		if (!txtCMND.getText().matches("[1-9][0-9]{8,11}")) {
			JOptionPane.showMessageDialog(this, "CMND phải từ 9 đến 12 ký tự số, bắt đầu không là số 0!");
			txtCMND.requestFocus();
			txtCMND.selectAll();
			return false;
		} else if (txtTenKH.getText().length() == 0) {
			JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống !");
			txtTenKH.requestFocus();
			txtTenKH.selectAll();
			return false;
		} else if (txtMaKH.getText().length() == 0) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống !");
			txtMaKH.requestFocus();
			txtMaKH.selectAll();
			return false;
		} else if (!txtSoDT.getText().matches("[0][0-9]{9}")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 số và bắt đầu là số 0 !");
			txtSoDT.requestFocus();
			txtSoDT.selectAll();
			return false;
		}

		return true;
	}

	private boolean KiemTraCoThongTinKhachHang() {// Nếu không có thì tạo mới
		if (khachHang_dao.LayKhachHangTheoCMND(txtCMND.getText().trim()) == null) {
			txtTenKH.setText("");
			txtMaKH.setText("");
			txtSoDT.setText("");
			txtTenKH.setEditable(true);
			txtMaKH.setEditable(true);
			txtSoDT.setEditable(true);
			return false;
		} else {
			KhachHang kh = khachHang_dao.LayKhachHangTheoCMND(txtCMND.getText().trim());
			txtTenKH.setText(kh.getTenKH());
			txtMaKH.setText(kh.getMaKH());
			txtSoDT.setText(kh.getSoDT());
			txtTenKH.setEditable(false);
			txtMaKH.setEditable(false);
			txtSoDT.setEditable(false);
			return true;
		}
	}

	private void DatHang() {
		if (KiemTraNhapLieu()) {
			SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
			String ngayLap = LocalDate.now().toString();
			Date nht = java.sql.Date.valueOf(ngayLap);
			int soL = hd_dao.DanhSachHoaDontheoMaSP(t.getMaSP()).size() + 1;
			// String soVe = (String.valueOf(ve_dao.LayMaVeLonNhat(t.getMaTour())+1)
			// ).toString();
			String maHD = "";
			if (String.valueOf(soL).length() == 1) {
				maHD = t.getMaSP() + "-0" + soL;
				txtMaHD.setText(t.getMaSP() + "-0" + soL);
			}

			else {
				maHD = t.getMaSP() + "-" + soL;
				txtMaHD.setText(t.getMaSP());
			}

			KhachHang kh = khachHang_dao.LayKhachHangTheoCMND(txtCMND.getText());
			NhanVien nv = nhanVien_dao.LayNhanVienTheoMa(ChucNang.maNhanVien.toString());
			HoaDon hoadon = new HoaDon(maHD, nv, kh, nht);
			try {
				hd_dao.laydulieuhoadon(maHD);
				QuanLyHoaDon.qlHoaDon.TaiSPLen();
				JOptionPane.showMessageDialog(this, "Đặt hàng thành công!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Lỗi! không thể đặt hàng !");
			}
			this.setVisible(false);
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
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
			KiemTraCoThongTinKhachHang();
		} else {
			String to_check = txtCMND.getText();
			int to_check_len = to_check.length();
			for (KhachHang khachHang : listKhachHang) {
				String check_from_data = "";
				for (int i = 0; i < to_check_len; i++) {
					if (to_check_len <= khachHang.getCmnd().length()) {
						check_from_data = check_from_data + khachHang.getCmnd().charAt(i);
					}
				}
				// System.out.print(check_from_data);
				if (check_from_data.equals(to_check)) {
					// System.out.print("Found");
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
	public boolean checkNull() {
		if(txtCMND.getText().trim().length()==0
			||	txtMaKH.getText().trim().length()==0
			||	txtTenKH.getText().trim().length()==0
			||	txtSoDT.getText().trim().length()==0
		) {
			return true;
		}
		return false;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnThoat)) {
			dispose();
		} else if (obj.equals(btnLamMoi)) {
			// Vinh 3-6
			txtCMND.setText("");
			txtMaKH.setText("");
			txtSoDT.setText("");
			txtTenKH.setText("");
		}else if (obj.equals(btnLuu)) {
			if (khachHang_dao.LayKhachHangTheoCMND(txtCMND.getText().trim()) == null) {
				if (KiemTraNhapLieu()) {
					Object[] options = { "Đồng ý", "Hủy bỏ" };
					int result = JOptionPane.showOptionDialog(frame,
							"Đây là khách hàng mới, hệ thống sẽ lưu mới thông tin khách hàng này !", "Xác nhận",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (result == JOptionPane.YES_OPTION) {
						DatHang();
						dispose();
					} else if (result == JOptionPane.NO_OPTION) {

					}
				}

			} else {
				DatHang();
				dispose();
			}

		}
	}
}