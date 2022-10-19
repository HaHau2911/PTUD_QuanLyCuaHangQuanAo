package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;

import connectDB.ConnectDB;

public class MenuHoaDon extends JPanel{

	public static MenuHoaDon qlHD;
	JPanel pnTab2;
	private DanhSach_SanPham pnTab1;
	
	public MenuHoaDon() {
		qlHD = this;
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//
		Border blackline = BorderFactory.createLineBorder(Color.gray);
		setBorder(blackline);
		setLayout(new BorderLayout());
		setBackground(new Color(230, 247, 255));
		
		JTabbedPane tab = new JTabbedPane();
			
		pnTab1 = new DanhSach_SanPham();
		pnTab2 = new QuanLyHoaDon();
		JScrollPane sp1 = new JScrollPane(pnTab1);
	
		tab.add(sp1,"Đặt hàng");
		tab.add(pnTab2,"Quản lí hàng");
		pnTab2.setBackground(Color.WHITE);	
		add(tab,BorderLayout.CENTER);	

		
		
		
//					
//		


	
		
	}

	public void TaiSPLen() {
		
		
	}
}
