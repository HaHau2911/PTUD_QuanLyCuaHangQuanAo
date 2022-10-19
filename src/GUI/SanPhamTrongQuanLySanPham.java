package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import entity.SanPham;


public class SanPhamTrongQuanLySanPham extends JPanel implements ActionListener{

	private JPanel pnCC;
	private SanPham sp;
	JButton btnSua;
	private JLabel lblHinhAnh;
	private JLabel lblThongBao;
	public SanPhamTrongQuanLySanPham(SanPham sanpham) {
		setBackground(new Color(230, 230, 230));
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(950,200));
		
		sp = sanpham;
		//Vinh - 22 - 5
		JLabel lblTenSP = new JLabel(sp.getTenSP());
		JPanel pnTenSP = new JPanel();
		pnTenSP.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnTenSP.add(lblTenSP);
		lblTenSP.setFont(new Font("Time New Roman",Font.BOLD,18));
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		JLabel lblGia = new JLabel(String.valueOf(formatter.format(sp.getGia())+" VNĐ"));
		JPanel pnGia = new JPanel();
		pnGia.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnGia.add(new JLabel("Giá:"));
		pnGia.add(lblGia);
		lblThongBao = new JLabel("");
		lblThongBao.setFont(new Font("Time New Roman", Font.ITALIC,13));
		lblThongBao.setForeground(Color.RED);
		pnGia.add(lblThongBao);
		
		
		JPanel pnButton = new JPanel();
		//btnDatTour = new JButton("Đặt tour");
		btnSua = new JButton("Sửa");
		pnButton.add(btnSua);
		pnButton.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnButton.setBackground(new Color(230, 230, 230));
		
		pnCC = new JPanel();
		pnCC.setLayout(new GridLayout(5, 1));
		//pnCC.setBackground(new Color(230, 247, 255));
		pnCC.add(pnTenSP);
		pnCC.add(pnGia);
		pnCC.add(pnButton);

		pnTenSP.setBackground(new Color(230, 230, 230));
		pnGia.setBackground(new Color(230, 230, 230));
		
		lblHinhAnh = new JLabel("");
		JPanel pnHinhAnh = new JPanel();
		pnHinhAnh.setBackground(new Color(230, 230, 230));
		pnHinhAnh.add(lblHinhAnh);
		String path = sp.getHinhAnh();
		if(sp.getHinhAnh().trim().equals("")) {
			JPanel pnKhungHinhAnh = new JPanel();
			pnKhungHinhAnh.setPreferredSize(new Dimension(170,170));
			pnKhungHinhAnh.setLayout(new BoxLayout(pnKhungHinhAnh, BoxLayout.X_AXIS));
			pnKhungHinhAnh.add(Box.createHorizontalStrut(40));
			lblHinhAnh.setText("Chưa có hình ảnh");
			pnKhungHinhAnh.add(lblHinhAnh);
			pnHinhAnh.add(pnKhungHinhAnh);
		}
		else {
		lblHinhAnh.setIcon(ResizeImage(path));
		}
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new GridLayout(1,1));
		pnCenter.add(pnHinhAnh);
		pnCenter.add(pnCC);

		Border borderSP = BorderFactory.createLineBorder(Color.GRAY);
		pnCenter.setBorder(borderSP);
		add(pnCenter, BorderLayout.CENTER);
		
		
		ThietLapThongBao();
		
		btnSua.addActionListener(this);
		//
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//Vinh - 20-5
		Object obj = e.getSource();
		
		if(obj.equals(btnSua)) {
			if(lblThongBao.getText().length()>0) {
				new NhapSuaThongTinSanPham(sp, 2);//2 là mở giao diện để xem thông tin tour
			}
			else
				new NhapSuaThongTinSanPham(sp, 0); //0 là mở giao diện để sửa thông tin tour
		}
	}
	public ImageIcon ResizeImage(String ImagePath)
	 {
		 ImageIcon MyImage = new ImageIcon(ImagePath);
		 Image img = MyImage.getImage();
		 Image newImg = img.getScaledInstance(400, 230, Image.SCALE_SMOOTH);
		 ImageIcon image = new ImageIcon(newImg);
	     return image;
	 }

	private void ThietLapThongBao() {
		
		int soLuong = sp.getSoLuong();
		if(soLuong >0 ) {
			lblThongBao.setText("* sản phẩm còn");
		}
		else {
			lblThongBao.setText("* sản phẩm hết");
		}
	}
		/* LocalDate ngayHT = LocalDate.now();
		LocalDate ngayKH = LocalDate.parse(t.getNgayKhoiHanh().toString());
		LocalDate ngayKT = LocalDate.parse(t.getNgayKetThuc().toString());
		//Date ngayKH = t.getNgayKhoiHanh();
		if(ngayHT.compareTo(ngayKH)>0) {
			lblThongBao.setText("                         *Tour đã bắt đầu");
		}
		if(ngayHT.compareTo(ngayKT)>0)
		{
			lblThongBao.setText("                         *Tour đã kết thúc");
		}
	 */
}
