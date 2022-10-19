package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.NhaCungCap_DAO;
import connectDB.ConnectDB;
import entity.NhaCungCap;


public class QuanLyNhaCungCap extends JPanel  implements ActionListener,MouseListener{

	DefaultTableModel modeltable;
	JTable table;
	JButton  btnThem, btnSua, btnLoad, btnThoat;
	JComboBox cbxTimKiem;
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
		pnNorth.setBackground(new Color(230, 247, 255));
		JLabel lblTieuDe = new JLabel("Quản Lý Nhà Cung Cấp");
		Font font =new Font("Arial",Font.BOLD,25);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		pnNorth.add(lblTieuDe);
		add(pnNorth,BorderLayout.NORTH);
		
		Font font2 =new Font("Arial",Font.PLAIN,17);
		JPanel pnBorderThongTin = new JPanel();
		pnBorderThongTin.setBackground(new Color(230, 247, 255));
		pnBorderThongTin.setLayout(new BoxLayout(pnBorderThongTin, BoxLayout.Y_AXIS)); 
		Border borderThongtin = BorderFactory.createLineBorder(new Color(51, 51, 0));
		TitledBorder borderTitleThongtin = new TitledBorder(borderThongtin, "Thông tin: ");
		borderTitleThongtin.setTitleColor(new Color(0, 102, 255));
		borderTitleThongtin.setTitleFont(font2);
		Font font3 =new Font("Arial",Font.PLAIN,15);
		String[] chuoi = {"Mã nhà cung cấp ","Tên nhà cung cấp","Nơi Sản Xuất"};
		modeltable = new DefaultTableModel(chuoi,0);
		table = new JTable(modeltable);
		
		table.getTableHeader().setBackground(new Color(230, 247, 255));
		table.setFillsViewportHeight(true);
        table.setBackground(new Color(255, 255, 255));
		
		JScrollPane sc = new JScrollPane(table);
		sc.setBackground(new Color(230, 247, 255));
		table.getTableHeader().setFont(font3);
		sc.setBorder(borderTitleThongtin);
		add(sc,BorderLayout.CENTER);

			//SOUTH
		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(new Color(230, 247, 255));
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		pnSouth.setPreferredSize(new Dimension(200,70));
		add(pnSouth,BorderLayout.SOUTH);
	
		JPanel pnBorderTacVu = new JPanel();
		pnBorderTacVu.setBackground(new Color(230, 247, 255));
		pnBorderTacVu.setLayout(new BoxLayout(pnBorderTacVu, BoxLayout.Y_AXIS)); 
		Border borderTacVu = BorderFactory.createLineBorder(new Color(51, 51, 0));
		TitledBorder titleborderTacVu = new TitledBorder(borderTacVu, "Chọn tác vụ: ");
		titleborderTacVu.setTitleColor(new Color(0, 102, 255));
		titleborderTacVu.setTitleFont(font2);
		pnBorderTacVu.setBorder(titleborderTacVu);
		pnSouth.add(pnBorderTacVu);
	       
		JPanel pnLeft = new JPanel();
		pnLeft.setBackground(new Color(230, 247, 255));
		JPanel pnRight = new JPanel();
		pnRight.setBackground(new Color(230, 247, 255));
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
			
			//LEFT
		JLabel lblTimKiem = new JLabel("Tìm kiếm theo nơi sản xuất ");
		lblTimKiem.setForeground(Color.BLACK);
		lblTimKiem.setIcon(new ImageIcon("Icon/search2.png"));		//ĐÃ SỬA
		cbxTimKiem = new JComboBox();
		cbxTimKiem.setForeground(Color.BLACK);
		//cbxTimKiem.setBackground(Color.cyan);				//ĐÃ SỬA
		cbxTimKiem.addItem("Pháp ");
		cbxTimKiem.addItem("Việt Nam");
		cbxTimKiem.addItem("Ý");
		cbxTimKiem.addItem("USA");
		cbxTimKiem.setPreferredSize(new Dimension(150, 25));
		cbxTimKiem.setBackground(new Color(230, 247, 255));
		pnLeft.add(lblTimKiem);
		pnLeft.add(cbxTimKiem);
			//RIGHT
		Font font1 =new Font("Arial",Font.PLAIN,17);
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("Icon/them1.png"));
		btnThem.setForeground(Color.BLACK);
		btnThem.setBackground(new Color(230, 247, 255));
		btnThem.setPreferredSize(new Dimension(120,32));
		btnThem.setFont(font1);
		//btnThem.setBackground(Color.cyan);				//ĐÃ SỬA
		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("Icon/sua.png"));
		btnSua.setForeground(Color.BLACK);
		btnSua.setBackground(new Color(230, 247, 255));
		btnSua.setPreferredSize(new Dimension(120,32));
		btnSua.setFont(font1);
		//btnSua.setBackground(Color.cyan);					//ĐÃ SỬA
		btnLoad = new JButton("Hiển thị lại thông tin");
		btnLoad.setIcon(new ImageIcon("Icon/load.png"));
		btnLoad.setForeground(Color.BLACK);
		btnLoad.setBackground(new Color(230, 247, 255));
		btnLoad.setPreferredSize(new Dimension(210,32));
		btnLoad.setFont(font1);
		//btnLoad.setBackground(Color.cyan);				//ĐÃ SỬA
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Icon/thoat1.png"));
		btnThoat.setBackground(new Color(230, 247, 255));
		btnThoat.setForeground(Color.BLACK);
		btnThoat.setPreferredSize(new Dimension(120,32));
		//btnThoat.setBackground(Color.cyan);				//ĐÃ SỬA
		pnRight.add(btnThem);
		pnRight.add(btnSua);
		pnRight.add(btnLoad);
		pnRight.add(btnThoat);
		pnBorderTacVu.add(sp);
		
		//JSplitPane sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,sc,pnSouth);
		//add(sp1,BorderLayout.CENTER);
		
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		cbxTimKiem.addActionListener(this);
		btnLoad.addActionListener(this);
		btnThoat.addActionListener(this);
		
		
		
		nhacungcap = new NhaCungCap();
		table.addMouseListener(this);
		
		modeltable.setRowCount(0);
		listNCC	= ncc_dao.getalltbNCC();
		for(NhaCungCap ncc : listNCC) {
			modeltable.addRow(new Object[] {
					ncc.getMaNCC(), ncc.getTenNCC(), ncc.getNoiSX()
			});
		}
		cellNhaCungCap = new DefaultTableCellNhaCungCap();
		//cellDiaDanh.getTableCellRendererComponent(table, "", true, true, 1, 5);
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
			btnSua.setBackground(null);					//ĐÃ SỬA
			btnThoat.setBackground(null);
			new ThongTinNhaCungCap(nhacungcap,true).setVisible(true);
			
		}
		else if(o.equals(btnSua)) {
			btnSua.setBackground(new Color(153, 255, 153));			//ĐÃ SỬA
			btnLoad.setBackground(null);				//ĐÃ SỬA
			btnThem.setBackground(null);				//ĐÃ SỬA
			btnThoat.setBackground(null);
			new ThongTinNhaCungCap(nhacungcap,false).setVisible(true);
			
		}
		else if(o.equals(btnLoad)) {
			btnLoad.setBackground(new Color(153, 255, 153));				//ĐÃ SỬA
			btnSua.setBackground(null);					//ĐÃ SỬA
			btnThem.setBackground(null);				//ĐÃ SỬA
			btnThoat.setBackground(null);
			hienThiThongTin();		
			btnLoad.setBackground(null);				//ĐÃ SỬA
			btnSua.setBackground(null);					//ĐÃ SỬA
			btnThem.setBackground(null);				//ĐÃ SỬA
			btnThoat.setBackground(null);
		}
		else if(o.equals(btnThoat)) {
			btnThoat.setBackground(new Color(153, 255, 153));
			int kt = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát không","Thông báo",JOptionPane.YES_NO_OPTION);
			if(kt == JOptionPane.YES_OPTION) {				//ĐÃ SỬA
				System.exit(0);
			}
		}
		else if(o.equals(cbxTimKiem)) {
			listNCC	= ncc_dao.timKiem((String) cbxTimKiem.getSelectedItem());	
			if(listNCC.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy");
				modeltable.setRowCount(0);
				listNCC	= ncc_dao.getalltbNCC();
				for(NhaCungCap ncc : listNCC) {
					modeltable.addRow(new Object[] {
							ncc.getMaNCC(), ncc.getTenNCC(), ncc.getNoiSX()
					});
				}
			}
			else {
				modeltable.setRowCount(0);
				for(NhaCungCap ncc : listNCC) {
					modeltable.addRow(new Object[] {
							ncc.getMaNCC(), ncc.getTenNCC(), ncc.getNoiSX()
					});	
				}
			}
		}
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
