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
import connectDB.ConnectDB;
import entity.KhachHang;


public class UI_ThongTinKhachHang extends JPanel  implements ActionListener, MouseListener{

	DefaultTableModel modeltable;
	JTable table;
	JTextField txtTim;
	JButton btnTim, btnThem, btnSua, btnLoad, btnThoat,btnXoa;
	KhachHang kh;
	int row;
	ArrayList<KhachHang> listKH;
	KhachHang khachhang;
	KhachHang_DAO kh_dao;
	
	public UI_ThongTinKhachHang() {
		
		
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		kh_dao = new KhachHang_DAO();
		
		//setBackground(Color.YELLOW);
		setLayout(new BorderLayout());
		
		
		JPanel pnNorth = new JPanel();
		JLabel lblTieuDe = new JLabel("Quản Lý Khách Hàng");
		Font font =new Font("Arial",Font.BOLD,25);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		pnNorth.add(lblTieuDe);
		add(pnNorth,BorderLayout.NORTH);
		
		
		String[] chuoi = {"Mã khách hàng","Tên khách hàng","Email","Địa Chỉ","Số điện thoại ","CMND","Giới tính"};
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
	//	btnTim = new JButton("Tìm kiếm");
		pnLeft.add(txtTim);
	//	pnLeft.add(btnTim);
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
		btnLoad.addActionListener(this);
		btnThoat.addActionListener(this);
		
		table.addMouseListener(this);
		modeltable.setRowCount(0);
		
	
	txtTim.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(txtTim.getText().length()==0) {
				try {
					loadKH();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(txtTim.getText().length()>0) {
				try {
					timKH();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
	});
	try {
		loadKH();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_ThongTinKhachHang frame = new UI_ThongTinKhachHang();
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
			new ThongTinKhachHang(kh, true).setVisible(true);
		}
		else if(o.equals(btnSua)) {
			btnSua.setBackground(new Color(153, 255, 153));			//ĐÃ SỬA
			btnLoad.setBackground(null);				//ĐÃ SỬA
			btnThem.setBackground(null);	
			btnXoa.setBackground(null);	//ĐÃ SỬA
			btnThoat.setBackground(null);
			new ThongTinKhachHang(kh, false).setVisible(true);
			
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
				String maKH = modeltable.getValueAt(r, 0).toString();
				ArrayList<KhachHang> listkh = kh_dao.LayHetKhachHang();
				for(KhachHang kh : listkh) {
					if (kh.getMaKH().equalsIgnoreCase(maKH)) {
							modeltable.removeRow(r);
							try {
								kh_dao.xoaKH(maKH);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
				}
			}
			
		}
		
		else if(o.equals(btnThoat)) {
			btnThoat.setBackground(new Color(153, 255, 153));
			int kt = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát không","Thông báo",JOptionPane.YES_NO_OPTION);
			if(kt == JOptionPane.YES_OPTION) {				//ĐÃ SỬA
				System.exit(0);
			}
		}
		else if(o.equals(btnLoad)) {
			KhachHang_DAO dao_kh = new KhachHang_DAO();
			try {
				modeltable= dao_kh.getAllKH();
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
		listKH	= kh_dao.LayHetKhachHang();
		for(KhachHang kh : listKH) {
			modeltable.addRow(new Object[] {
					kh.getMaKH(), kh.getTenKH(), kh.getEmail(), kh.getDiaChi(), kh.getSoDT(), kh.getCmnd(), kh.getGioiTinh()
			});	
		}
		
	}
	
	
	private void timKH() throws SQLException{
		KhachHang_DAO dao_kh= new KhachHang_DAO();
		modeltable = dao_kh.timKiem("%"+txtTim.getText()+"%", "%"+txtTim.getText()+"%");
		table.setModel(modeltable);
	}
	private void loadKH() throws SQLException {
		KhachHang_DAO dao_kh = new KhachHang_DAO();
		modeltable= dao_kh.getAllKH();
		table.setModel(modeltable);
	}
//	private boolean xoaKH() throws SQLException {
//		 DAO_KhachHang  dao_kh= new DAO_KhachHang();
//		 if(dao_kh.xoaNV(ui.txtMaKH.getText()));
//			return true;
//	
//	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		row = table.getSelectedRow();
		kh = new KhachHang();
		kh.setMaKH(table.getValueAt(row, 0).toString());
		kh.setTenKH(table.getValueAt(row, 1).toString());
		kh.setEmail(table.getValueAt(row, 2).toString());
		kh.setDiaChi(table.getValueAt(row, 3).toString());
		kh.setSoDT(table.getValueAt(row, 4).toString());
		kh.setCmnd(table.getValueAt(row, 5).toString());
		
		
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
