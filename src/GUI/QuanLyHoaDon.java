package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import DAO.HoaDon_DAO;
import DAO.KhachHang_DAO;
import DAO.NhaCungCap_DAO;
import DAO.NhanVien_DAO;
import DAO.SanPham_DAO;
import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.SanPham;


public class QuanLyHoaDon extends JPanel implements ActionListener,MouseListener{

	public static QuanLyHoaDon qlHoaDon;
	JTextField txtTim;
	JButton btnTim;
	JPanel pnCenter;
	JTree tree;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;

	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JButton btnHuy;
	private javax.swing.JButton btnLamMoi;
	private javax.swing.JLabel lblTieuDe;
	private javax.swing.JTable tblHoaDon;
	DefaultMutableTreeNode nodeSanPham;
	DefaultTableModel modeltable;
	DefaultTableModel modeltable1;
	public JTable table;
	JTable table1;
	JPanel pnTree;
	JPanel pnTab2;
	private SanPham_DAO sp_dao;
	private HoaDon_DAO hd_dao;
	private NhaCungCap_DAO ncc_dao;
	private DefaultMutableTreeNode rootNCC;
	private DefaultMutableTreeNode nodeNCC;
	private DefaultMutableTreeNode nodeSP;
	private ArrayList<NhaCungCap> dsNCC;
	private NhaCungCap ncc1=null;
	private ArrayList<SanPham> listSP;
	private ArrayList<HoaDon> listHD;
	private KhachHang kh;
	private KhachHang_DAO khachhang;
	private NhanVien nv;
	private NhanVien_DAO nhanvien;
	private ArrayList<SanPham> listSPKhaDung; //Danh sách tour có thể đặt
	private SanPham sanpham;
	JScrollPane sc;
	private DefaultMutableTreeNode rootTongHD;
	public QuanLyHoaDon() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ncc_dao = new NhaCungCap_DAO();
		sp_dao =new SanPham_DAO();
		hd_dao =new HoaDon_DAO();
		khachhang=new KhachHang_DAO();
		nhanvien=new NhanVien_DAO();
		
        initComponents();

	
		
	}
	public void DoclenCay() {
		rootNCC=new DefaultMutableTreeNode("Các Nhà Cung Cấp");
		tree=new JTree(rootNCC);
		
		ImageIcon tourIcon= new ImageIcon("Icon/Tour.jpg");
		ImageIcon IconMo=new ImageIcon("Icon/moThuMuc.png");
		ImageIcon IconDong=new ImageIcon("Icon/dongThuMuc.png");
		if(tourIcon !=null) {
			DefaultTreeCellRenderer rd= new DefaultTreeCellRenderer();
			rd.setClosedIcon(IconDong);
			rd.setOpenIcon(IconMo);
			rd.setLeafIcon(tourIcon);
			tree.setCellRenderer(rd);
		}
		
		nodeNCC= new DefaultMutableTreeNode("Nhà cung cấp");
		dsNCC= ncc_dao.getalltbNCC();
		
		
		rootTongHD=new DefaultMutableTreeNode("Tất cả các hoá đơn");
		rootNCC.add(rootTongHD);
		for(NhaCungCap ncc: dsNCC) {
			nodeNCC=new DefaultMutableTreeNode(ncc.getTenNCC());
			rootNCC.add(nodeNCC);
			
//			ncc1 =  (NhaCungCap) nodeNCC.getUserObject();
//			listSP = sp_dao.getSPTheoMaNhaCungCap(ncc1.getMaNCC());
//			for(SanPham sanpham: listSP) {
//				nodeSP= new DefaultMutableTreeNode(sanpham);
//				nodeNCC.add(nodeSP);
//			}
		}
		tree.expandRow(0);	
	}
	
	public void DoclenTable() {
		listHD = hd_dao.getalltbHoaDon();
		for(HoaDon hd: listHD) {
			kh = khachhang.getKhachHangbyHDId("maKH",hd.getMaKH().getMaKH());
			nv = nhanvien.getNhanVienbyHDId("maNV",hd.getMaNV().getMaNV());
			sanpham = sp_dao.getSPTheoMa(hd.getChitiethd().getMaSP().getMaSP());
			
			Object[] ob= {hd.getMaHD(), nv.getTenNV(),kh.getTenKH(), 
					hd.getNgayLap(), hd.getChitiethd().getMaSP().getMaSP()
			};
			
			modeltable.addRow(ob);
		}
	}
	public void deleteTblVe() {
		DefaultTableModel df= (DefaultTableModel) tblHoaDon.getModel();
		df.getDataVector().removeAllElements();
	}
    
	 @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        DoclenCay();
        jScrollPane2 = new JScrollPane();
        tblHoaDon = new JTable();
        lblTieuDe = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(tree);

//        tblVe.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {
//                {null, null, null, null, null, null},
//                {null, null, null, null, null, null},
//                {null, null, null, null, null, null},
//                {null, null, null, null, null, null}
//            },
//            new String [] {
//                "Ma vé", "Ngày dat", "Tên khach hang", "Tên nhân viên", "Ðia danh", "Giá"
//            }
//        ));
        String[] hearder= {"Mã hoá đơn","Tên nhân viên ","Tên khách hàng","Ngày lập","Mã Sản Phẩm"};
        modeltable=new DefaultTableModel(hearder,0);
        tblHoaDon=new JTable(modeltable);
        jScrollPane2.setViewportView(tblHoaDon);
        DoclenTable();
        lblTieuDe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTieuDe.setText("Quản lý hoá đơn");

        jLabel1.setText("Tìm kiếm");

        btnTim.setText("Tìm");

        btnLamMoi.setText("Làm Mới");

        btnHuy.setText("Hủy");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setText("Chức năng");
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTim)
                                .addGap(43, 43, 43))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLamMoi)
                                .addGap(43, 43, 43)
                                .addComponent(btnHuy)))
                        .addGap(44, 44, 44)))
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addGap(701, 701, 701))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(32, 32, 32))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        btnHuy.addActionListener(this);
        btnLamMoi.addActionListener(this);
        btnTim.addActionListener(this);
        tblHoaDon.addMouseListener(this);
        tree.addMouseListener(this);
    }// </editor-fold>                        

	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnTim)) {
			ArrayList<SanPham> spTimDuoc = sp_dao.TimSP(txtTim.getText().toString().trim().toLowerCase(),false);
			if(spTimDuoc.size()==0)
			{
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}
			else {
				TaiSPTimKiem(spTimDuoc);
			}	
		}
		
	}

	//Vinh - 26-5
		public void TaiSPLen() {
			try {
				 pnCenter.removeAll();
				 pnCenter.revalidate();
				 listSPKhaDung = sp_dao.DSTCoTheMua(ABORT);
				 for(SanPham sanpham : listSPKhaDung) { 
					 JPanel pnItem = new SanPhamTrongQuanLyHoaDon(sanpham) ;
					 pnCenter.add(pnItem); 
				 } 
				 pnCenter.revalidate();
				 //JOptionPane.showMessageDialog(this, listTourKhaDung.size());
			 } 
			 catch (Exception e2) {
				 JOptionPane.showMessageDialog(this, e2); 
			 }
		}
		
		
		//Vinh -28-5
		private void TaiSPTimKiem(ArrayList<SanPham> spTimDuoc) {
			pnCenter.removeAll();
			 pnCenter.revalidate();
			for (SanPham sanpham : spTimDuoc) {
				JPanel pnItem = new SanPhamTrongQuanLyHoaDon(sanpham); 
				pnCenter.add(pnItem);  
				pnCenter.revalidate();
			}
		}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodeSelected  = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if( nodeSelected!= null && nodeSelected.getLevel() == 1)
		{
			pnTree.removeAll();
			pnTree.revalidate();
			String[] chuoi1 = {"Mã sản phẩm","Tên sản phẩm","Giá","Ngày Lập"};
			modeltable1 = new DefaultTableModel(chuoi1,0);
			table1 = new JTable(modeltable1);
			table1.getColumnModel().getColumn(1).setPreferredWidth(300);;
			
			
			JScrollPane sc2 = new JScrollPane(table1);
			//sc.setPreferredSize(new Dimension(200, 0));
			pnTree.add(sc2,BorderLayout.CENTER);
			pnTree.add(sc,BorderLayout.WEST);
			JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,sc,sc2);
			pnTree.add(split,BorderLayout.CENTER);
			pnTree.revalidate();
			pnTree.repaint();

		
		}
		if( nodeSelected!= null && nodeSelected.getLevel() == 2)
		{
			pnTree.removeAll();
			pnTree.revalidate();
			String[] chuoi = {"Mã sản phẩm","Ngày Lập","Tên sản phẩm","Tên khách hàng","Tên nhân viên"};
			modeltable = new DefaultTableModel(chuoi,0);		
			table = new JTable(modeltable);	
			table.getColumnModel().getColumn(2).setPreferredWidth(160);
			DefaultTableCellSanPham cellsanpham = new DefaultTableCellSanPham();
			//celltour.getTableCellRendererComponent(table, table.getColumnModel().getColumn(1), true, true, 10, 15);
			//table.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellTour());
			table.getColumnModel().getColumn(1).setCellRenderer(cellsanpham.tableCellRenderer);
			table.setAutoCreateRowSorter(true);
			
			JScrollPane sc1 = new JScrollPane(table);
			pnTree.add(sc1,BorderLayout.CENTER);
			pnTree.add(sc,BorderLayout.WEST);
			//sc.setPreferredSize(new Dimension(200, 0));
			JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,sc,sc1);
			pnTree.add(split,BorderLayout.CENTER);
			pnTree.revalidate();
			pnTree.repaint();
			
			sanpham =  (SanPham) nodeSelected.getUserObject();
			modeltable.setRowCount(0);
			listHD	=  hd_dao.getHoaDonTheoMaSP(sanpham.getMaSP());
			
			for(HoaDon hd : listHD) {
				modeltable.addRow(new Object[] {hd.getMaHD(),hd.getNgayLap(),hd.getChitiethd().getMaSP(),hd.getMaNV(),hd.getMaKH(), hd.getChitiethd().getSoLuong()
				});	
			}
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
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
