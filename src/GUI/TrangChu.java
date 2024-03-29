package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class TrangChu extends JPanel{

	ImageIcon background;
	JPanel pnMain = new JPanel();
	 JLabel lblBackground;
	 ClockThread clockThread;
	 
	 JLabel lblNV;
	private JLabel lblLogo;
	public TrangChu() {
		setSize(1400,800);
		setLayout(new BorderLayout());
		
		ImageIcon img = new ImageIcon("Icon/1767.jpg");
		Image img1 = img.getImage();
		Image temp_img = img1.getScaledInstance(1400,1000, Image.SCALE_SMOOTH);
		img = new ImageIcon(temp_img);
		lblBackground = new JLabel("",img,JLabel.CENTER);
		lblBackground.setBounds(0,0,1400,800);
		lblBackground.setLayout(new BoxLayout(lblBackground, BoxLayout.Y_AXIS));
		//lblBackground.setLayout(new BorderLayout());

		Font fontGio =new Font("Arial",Font.BOLD,22);
		Font fontTen =new Font("Arial",Font.BOLD,55);
		Font fontND =new Font("Arial",Font.BOLD | Font.ITALIC,15);
		JLabel lblGio  = new JLabel("");
		lblGio.setFont(fontGio);
		lblGio.setForeground(Color.RED);
		lblLogo = new JLabel(ResizeImage("Icon/sun.png"));
		lblLogo.setPreferredSize(new Dimension(140,50));
		JLabel lblTen  = new JLabel("Quản Lý Cửa Hàng Quần Áo");
		lblTen.setForeground(Color.RED);
		lblTen.setFont(fontTen);
		
		JLabel lblNoiDung = new JLabel("<html></html>",JLabel.CENTER);
		lblNoiDung.setFont(fontND);
		lblNoiDung.setForeground(Color.BLACK);
		
		lblGio.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTen.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNoiDung.setAlignmentX(Component.CENTER_ALIGNMENT);
		//lblNgay.setAlignmentX(Component.CENTER_ALIGNMENT);
		//lblNoiDung.setHorizontalTextPosition(SwingConstants.CENTER);
		//lblNoiDung.setAlignmentX((float) 1.9);
		//lblGio1.setHorizontalAlignment(JLabel.RIGHT);
		
		/*
		ImageIcon img22 = new ImageIcon("Icon/sun.png");
		Image img2 = img22.getImage();
		Image temp_img2 = img2.getScaledInstance(200,150, Image.SCALE_SMOOTH);
		img22 = new ImageIcon(temp_img2);
		JLabel lblLogo = new JLabel("",img22,JLabel.CENTER);
		lblLogo.setBounds(0,0,200,150);*/
		
		
		clockThread = new ClockThread(lblGio);
		clockThread.start();
	
		lblBackground.add(Box.createVerticalStrut(20));
		lblBackground.add(lblGio);
		lblBackground.add(Box.createVerticalStrut(0));
		lblBackground.add(lblLogo);
		lblBackground.add(Box.createVerticalStrut(0));
		lblBackground.add(lblTen);
		lblBackground.add(Box.createVerticalStrut(3));
		lblBackground.add(lblNoiDung);
		
	
		
		
		add(lblBackground,BorderLayout.CENTER);			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrangChu trangchu = new TrangChu();
		trangchu.setVisible(true);
	}
	public ImageIcon ResizeImage(String ImagePath)
	 {
		 ImageIcon MyImage = new ImageIcon(ImagePath);
		 Image img = MyImage.getImage();
		 Image newImg = img.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
		 ImageIcon image = new ImageIcon(newImg);
	     return image;
	 }
	/*
	@Override
	public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(new ImageIcon("Icon/1767.jpg").getImage(), 0, 0, getWidth(), getHeight(), null);
        
	}*/
}
