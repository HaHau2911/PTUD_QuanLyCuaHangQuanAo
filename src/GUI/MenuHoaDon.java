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
	String masp;

	public static MenuHoaDon qlHD;
	private DanhSach_SanPham pnTab1;
	private String maNhanVien;
	
	public MenuHoaDon(String maNV) {
		maNhanVien = maNV;
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
		setBackground(new Color(255, 221, 226));
		
		JTabbedPane tab = new JTabbedPane();
			
		pnTab1 = new DanhSach_SanPham(maNhanVien);
		JScrollPane sp1 = new JScrollPane(pnTab1);
	
		tab.add(sp1,"Đặt hàng");
		add(tab,BorderLayout.CENTER);	

		
		
		
//					
//		


	
		
	}

	public void TaiSPLen() {
		
		
	}
}
