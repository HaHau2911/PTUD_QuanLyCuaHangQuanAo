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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.NhaCungCap_DAO;
import DAO.NhanVien_DAO;
import connectDB.ConnectDB;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.SanPham;


public class QuanLyNhaCungCap extends JPanel  implements ActionListener,MouseListener{

	DefaultTableModel modeltable;
	JTable table;
	JButton  btnThem, btnSua, btnLoad, btnThoat, btnXoa;
	JTextField txtTim;
	NhaCungCap_DAO ncc_dao;
	ArrayList<NhaCungCap> listNCC;
	NhaCungCap nhacungcap;
	JPanel pnCenter;
	boolean flag;
	int row;
	DefaultTableCellNhaCungCap cellNhaCungCap;
	public QuanLyNhaCungCap() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ncc_dao = new NhaCungCap_DAO();
		
		Border backline = BorderFactory.createLineBorder(Color.BLACK);
		setBorder(backline);
		setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		pnNorth.setBackground(new Color(255, 216, 223));
		JLabel lblTieuDe = new JLabel("Quản Lý Nhà Cung Cấp");
		Font font =new Font("Arial",Font.BOLD,25);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		pnNorth.add(lblTieuDe);
		add(pnNorth,BorderLayout.NORTH);
		
		Font font2 =new Font("Arial",Font.PLAIN,17);
		JPanel pnBorderThongTin = new JPanel();
		pnBorderThongTin.setBackground(new Color(255, 216, 223));
		pnBorderThongTin.setLayout(new BoxLayout(pnBorderThongTin, BoxLayout.Y_AXIS)); 
		Border borderThongtin = BorderFactory.createLineBorder(new Color(51, 51, 0));
		TitledBorder borderTitleThongtin = new TitledBorder(borderThongtin, "Thông tin: ");
		borderTitleThongtin.setTitleColor(new Color(0, 102, 255));
		borderTitleThongtin.setTitleFont(font2);
		Font font3 =new Font("Arial",Font.PLAIN,15);
		String[] chuoi = {"Mã nhà cung cấp ","Tên nhà cung cấp","Nơi Sản Xuất"};
		modeltable = new DefaultTableModel(chuoi,0);
		table = new JTable(modeltable);
		
		table.getTableHeader().setBackground(new Color(255, 216, 223));
		table.setFillsViewportHeight(true);
        table.setBackground(new Color(255, 255, 255));
		
		JScrollPane sc = new JScrollPane(table);
		sc.setBackground(new Color(255, 216, 223));
		table.getTableHeader().setFont(font3);
		sc.setBorder(borderTitleThongtin);
		add(sc,BorderLayout.CENTER);

			//SOUTH
		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(new Color(255, 216, 223));
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		pnSouth.setPreferredSize(new Dimension(200,70));
		add(pnSouth,BorderLayout.SOUTH);
	
		JPanel pnBorderTacVu = new JPanel();
		pnBorderTacVu.setBackground(new Color(255, 216, 223));
		pnBorderTacVu.setLayout(new BoxLayout(pnBorderTacVu, BoxLayout.Y_AXIS)); 
		Border borderTacVu = BorderFactory.createLineBorder(new Color(51, 51, 0));
		TitledBorder titleborderTacVu = new TitledBorder(borderTacVu, "Chọn tác vụ: ");
		titleborderTacVu.setTitleColor(new Color(0, 102, 255));
		titleborderTacVu.setTitleFont(font2);
		pnBorderTacVu.setBorder(titleborderTacVu);
		pnSouth.add(pnBorderTacVu);
	       
		JPanel pnLeft = new JPanel();
		pnLeft.setBackground(new Color(255, 216, 223));
		JPanel pnRight = new JPanel();
		pnRight.setBackground(new Color(255, 216, 223));
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
			
			//LEFT
		JLabel lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setForeground(Color.BLACK);
		lblTimKiem.setIcon(new ImageIcon("Icon/search2.png"));		//ĐÃ SỬA
		
		pnLeft.add(lblTimKiem);
		txtTim = new JTextField(10);
		pnLeft.add(txtTim);
			//RIGHT
		Font font1 =new Font("Arial",Font.PLAIN,17);
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("Icon/them.png"));
		btnThem.setForeground(Color.BLACK);
		btnThem.setBackground(new Color(255, 216, 223));
		btnThem.setPreferredSize(new Dimension(120,32));
		btnThem.setFont(font1);
		//btnThem.setBackground(Color.cyan);				//ĐÃ SỬA
		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("Icon/repair.png"));
		btnSua.setForeground(Color.BLACK);
		btnSua.setBackground(new Color(255, 216, 223));
		btnSua.setPreferredSize(new Dimension(120,32));
		btnSua.setFont(font1);
		
		btnXoa = new JButton("Xoá");
		btnXoa.setIcon(new ImageIcon("Icon/xoarong.png"));
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setBackground(new Color(255, 216, 223));
		btnXoa.setPreferredSize(new Dimension(120,32));
		btnXoa.setFont(font1);
		
		//btnSua.setBackground(Color.cyan);					//ĐÃ SỬA
		btnLoad = new JButton("Hiển thị lại thông tin");
		btnLoad.setIcon(new ImageIcon("Icon/load.png"));
		btnLoad.setForeground(Color.BLACK);
		btnLoad.setBackground(new Color(255, 216, 223));
		btnLoad.setPreferredSize(new Dimension(210,32));
		btnLoad.setFont(font1);
		//btnLoad.setBackground(Color.cyan);				//ĐÃ SỬA
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Icon/thoat.png"));
		btnThoat.setBackground(new Color(255, 216, 223));
		btnThoat.setForeground(Color.BLACK);
		btnThoat.setPreferredSize(new Dimension(120,32));
		//btnThoat.setBackground(Color.cyan);				//ĐÃ SỬA
		pnRight.add(btnThem);
		pnRight.add(btnSua);
		pnRight.add(btnXoa);
		pnRight.add(btnLoad);
		pnRight.add(btnThoat);
		pnBorderTacVu.add(sp);
		
		//JSplitPane sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,sc,pnSouth);
		//add(sp1,BorderLayout.CENTER);
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLoad.addActionListener(this);
		btnThoat.addActionListener(this);
		
		nhacungcap = new NhaCungCap();
		table.addMouseListener(this);
		
		modeltable.setRowCount(0);
		listNCC	= ncc_dao.getalltbNCC();
		
		txtTim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtTim.getText().length()==0) {
					try {
						load();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(txtTim.getText().length()>0) {
					try {
						tim();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		try {
			load();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/* nhacungcap = new NhaCungCap();
		table.addMouseListener(this);
		
		modeltable.setRowCount(0);
		listNCC	= ncc_dao.getalltbNCC();
		for(NhaCungCap ncc : listNCC) {
			modeltable.addRow(new Object[] {
					ncc.getMaNCC(), ncc.getTenNCC(), ncc.getNoiSX()
			});
		}
		cellNhaCungCap = new DefaultTableCellNhaCungCap();
		//cellDiaDanh.getTableCellRendererComponent(table, "", true, true, 1, 5); */
	}

	private void load() throws SQLException {
		NhaCungCap_DAO dao_ncc = new NhaCungCap_DAO();
		modeltable= dao_ncc.getAllNCC();
		table.setModel(modeltable);
	}
	private void tim() throws SQLException{
		NhaCungCap_DAO dao_ncc= new NhaCungCap_DAO();
		modeltable = dao_ncc.timKiem("%"+txtTim.getText()+"%", "%"+txtTim.getText()+"%");
		table.setModel(modeltable);
	}

	public void hienThiThongTin() {
		modeltable.setRowCount(0);
		table.removeAll();
		listNCC	= ncc_dao.getalltbNCC();
		for(NhaCungCap ncc : listNCC) {
			modeltable.addRow(new Object[] {
					ncc.getMaNCC(), ncc.getTenNCC(), ncc.getNoiSX()
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
			new ThongTinNhaCungCap(nhacungcap,true).setVisible(true);
			
		}
		else if(o.equals(btnSua)) {
			btnSua.setBackground(new Color(153, 255, 153));			//ĐÃ SỬA
			btnLoad.setBackground(null);				//ĐÃ SỬA
			btnThem.setBackground(null);	
			btnXoa.setBackground(null);	//ĐÃ SỬA
			btnThoat.setBackground(null);
			new ThongTinNhaCungCap(nhacungcap,false).setVisible(true);
			
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
				String maNCC = modeltable.getValueAt(r, 0).toString();
				ArrayList<NhaCungCap> listncc = ncc_dao.getalltbNCC();
				for(NhaCungCap ncc : listncc) {
					if (ncc.getMaNCC().equalsIgnoreCase(maNCC)) {
							modeltable.removeRow(r);
							ncc_dao.xoaNCC(maNCC);
					}
				}
			}
			xoahetDLTrongTable();
			DocDuLieuDataBaseVaoTable();
		}
		else if(o.equals(btnLoad)) {
			NhaCungCap_DAO dao_ncc = new NhaCungCap_DAO();
			try {
				modeltable= dao_ncc.getAllNCC();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			table.setModel(modeltable);
			
		}
		else if(o.equals(btnThoat)) {
			btnThoat.setBackground(new Color(153, 255, 153));
			int kt = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát không","Thông báo",JOptionPane.YES_NO_OPTION);
			if(kt == JOptionPane.YES_OPTION) {				//ĐÃ SỬA
				System.exit(0);
			}
		
		}
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
		listNCC	= ncc_dao.getalltbNCC();
		for(NhaCungCap ncc : listNCC) {
			modeltable.addRow(new Object[] {
					ncc.getMaNCC(), ncc.getTenNCC(), ncc.getNoiSX()
			});	
		}
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyNhaCungCap frame = new QuanLyNhaCungCap();
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
		nhacungcap.setMaNCC(table.getValueAt(row, 0).toString());
		nhacungcap.setTenNCC(table.getValueAt(row, 1).toString());
		nhacungcap.setNoiSX(table.getValueAt(row, 2).toString());
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
