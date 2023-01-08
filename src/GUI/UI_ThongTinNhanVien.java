package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;
import connectDB.ConnectDB;
import entity.NhanVien;



public class UI_ThongTinNhanVien extends JPanel implements ActionListener, MouseListener{

	DefaultTableModel modeltable;
	JTable table;
	JTextField txtTim;
	JButton btnTim, btnThem, btnSua, btnLoad, btnThoat, btnXoa;
	protected String[] chuoi;
	UI_NhanVien ui;
	int row;
	NhanVien_DAO nv_dao;
	NhanVien nhanvien;
	ArrayList<NhanVien> listNV;
	DefaultTableCellNhanVien cellNhanVien;
	public UI_ThongTinNhanVien() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		nv_dao = new NhanVien_DAO();

		setLayout(new BorderLayout());
		
		
		JPanel pnNorth = new JPanel();
		JLabel lblTieuDe = new JLabel("Quản Lý Nhân Viên");
		Font font =new Font("Arial",Font.BOLD,25);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		//pnNorth.setBackground(Color.WHITE);
		pnNorth.add(lblTieuDe);
		add(pnNorth,BorderLayout.NORTH);
		
		
		String[] chuoi = {"Mã nhân viên","Tên nhân viên","Email","Địa chỉ","Số điện thoại","CMND","Trạng thái","Giới tính","Loại Nhân viên"};
		modeltable = new DefaultTableModel(chuoi,0);
		table = new JTable(modeltable);
		JScrollPane sc = new JScrollPane(table);
		add(sc,BorderLayout.CENTER);
		
		//SOUTH
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		add(pnSouth,BorderLayout.SOUTH);
	
		JPanel pnLeft = new JPanel();
		JPanel pnRight = new JPanel();
		pnRight.setPreferredSize(new Dimension(400,50));
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		
			//LEFT
		//Nam - 2-6
		JLabel lblTim = new JLabel("Tìm kiếm");
		pnLeft.add(lblTim);
		txtTim = new JTextField(10);
		//btnTim = new JButton("Tìm kiếm");
		pnLeft.add(txtTim);
		//pnLeft.add(btnTim);
			//RIGHT
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("Icon/them.png"));
		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("Icon/repair.png"));
		btnXoa = new JButton("Xoá");
		btnXoa.setIcon(new ImageIcon("Icon/xoarong.png"));
		btnLoad = new JButton("Load");
		btnLoad.setIcon(new ImageIcon("Icon/load.png"));
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Icon/thoat.png"));
		pnRight.add(btnThem);
		pnRight.add(btnSua);
		pnRight.add(btnXoa);
		pnRight.add(btnLoad);
		pnRight.add(btnThoat);
		pnSouth.add(sp);
		
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		btnLoad.addActionListener(this);
		
		nhanvien = new NhanVien();
		table.addMouseListener(this);
		
		modeltable.setRowCount(0);
		listNV	= nv_dao.LayHetNhanVien();
		
		txtTim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtTim.getText().length()==0) {
					try {
						loadNV();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(txtTim.getText().length()>0) {
					try {
						timNV();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		try {
			loadNV();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	public void hienThiThongTin() {
		modeltable.setRowCount(0);
		table.removeAll();
		listNV	= nv_dao.LayHetNhanVien();
		for(NhanVien nv : listNV) {
			modeltable.addRow(new Object[] {
					nv.getMaNV(),nv.getTenNV(),nv.getEmail(),nv.getDiaChi(),nv.getSoDT(),nv.getCmnd(),
					nv.getTrangThai(), nv.getGioiTinh(), nv.getLoaiNV().getMaLoaiNV()
			});	
		}
		JOptionPane.showMessageDialog(this, "Hiển thị thành công");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			btnThem.setBackground(new Color(153, 255, 153));				//ĐÃ SỬA
			btnThem.setForeground(Color.BLACK);
			btnLoad.setBackground(null);				//ĐÃ SỬA
			btnSua.setBackground(null);	
			btnXoa.setBackground(null);	//ĐÃ SỬA
			btnThoat.setBackground(null);
			new UI_NhanVien(nhanvien,true).setVisible(true);
		}
		else if(o.equals(btnThoat)) {
			btnThoat.setBackground(new Color(153, 255, 153));
			int kt = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát không","Thông báo",JOptionPane.YES_NO_OPTION);
			if(kt == JOptionPane.YES_OPTION) {				//ĐÃ SỬA
				System.exit(0);
			}
		}
		else if(o.equals(btnXoa)) {
			btnXoa.setBackground(new Color(153, 255, 153));	
			
			int r =  table.getSelectedRow();
			if (r == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa !!");
				return;
			}
			int result = JOptionPane.showConfirmDialog(this,"Bạn có chắc sẽ xóa dòng này không !!","Cảnh báo",
					JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			if (result ==0) {
				String maNV = modeltable.getValueAt(r, 0).toString();
				ArrayList<NhanVien> listnv = nv_dao.LayHetNhanVien();
				for(NhanVien nv : listnv) {
					if (nv.getMaNV().equalsIgnoreCase(maNV)) {
							modeltable.removeRow(r);
							nv_dao.xoaNV(maNV);
					}
				}
			}
		}
		else if(o.equals(btnSua)) {
			btnSua.setBackground(new Color(153, 255, 153));			//ĐÃ SỬA
			btnLoad.setBackground(null);				//ĐÃ SỬA
			btnThem.setBackground(null);	
			btnXoa.setBackground(null);	//ĐÃ SỬA
			btnThoat.setBackground(null);
			new UI_NhanVien(nhanvien,false).setVisible(true);
		}
		else if(o.equals(btnLoad)) {
			NhanVien_DAO dao_nv = new NhanVien_DAO();
			try {
				modeltable= dao_nv.getAllNV();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			table.setModel(modeltable);
			
		}
		
	}
	private void dispose() {
		// TODO Auto-generated method stub
		
	}
	private void xoahetDLTrongTable() {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.getDataVector().removeAllElements();
	}
	
	private void DocDuLieuDataBaseVaoTable() {
		// TODO Auto-generated method stub
		modeltable.setRowCount(0);
		table.removeAll();
		listNV	= nv_dao.LayHetNhanVien();
		for(NhanVien nv : listNV) {
			modeltable.addRow(new Object[] {
					nv.getMaNV(),nv.getTenNV(),nv.getEmail(),nv.getDiaChi(),nv.getSoDT(),nv.getCmnd(),
					nv.getTrangThai(), nv.getGioiTinh(), nv.getLoaiNV().getMaLoaiNV()
			});	
		}
		
	}
	
	private void loadNV() throws SQLException {
		NhanVien_DAO dao_nv = new NhanVien_DAO();
		modeltable= dao_nv.getAllNV();
		table.setModel(modeltable);
	}
	private void timNV() throws SQLException{
		NhanVien_DAO dao_nv= new NhanVien_DAO();
		modeltable = dao_nv.timKiem("%"+txtTim.getText()+"%", "%"+txtTim.getText()+"%");
		table.setModel(modeltable);
	}
//	private boolean xoaNV() throws SQLException {
//		 DAO_KhachHang  dao_kh= new DAO_KhachHang();
//		if(dao_kh.xoaNV(ui.txtMaNV.getText()));
//			return true;
//	
//	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_ThongTinNhanVien frame = new UI_ThongTinNhanVien();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	protected void setExtendedState(int maximizedBoth) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		row = table.getSelectedRow();
		nhanvien.setMaNV(table.getValueAt(row, 0).toString());
		nhanvien.setTenNV(table.getValueAt(row, 1).toString());
		nhanvien.setEmail(table.getValueAt(row, 2).toString());
		nhanvien.setDiaChi(table.getValueAt(row, 3).toString());
		nhanvien.setSoDT(table.getValueAt(row, 4).toString());
		nhanvien.setCmnd(table.getValueAt(row, 5).toString());
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
