package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.TaiKhoan_DAO;
import connectDB.ConnectDB;
import entity.TaiKhoan;

public class GUI_DangNhapNV extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane; 
	private JLabel lblAnh;
	private JLabel lbltieuDe;
	private JLabel lbluser,lblbackground;
	private JLabel lblpass;
	private JPanel paneluser;
	private JPanel panelpass;
	private JLabel imageuser;
	private JLabel imagepass;
	public static JButton btndangNhap;
	public static JTextField txtuser;
	private JPasswordField txtpass;
	private JLabel lblxoauser,lblxoapass;
	
	private JLabel lblanh1,lblanh2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DangNhapNV frame = new GUI_DangNhapNV();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
//	
	public GUI_DangNhapNV() throws InterruptedException {
	//	setIconImage(Toolkit.getDefaultToolkit().getImage(DangNhap.class.getResource("/img/secrecy-icon.png")));
		
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		TaiKhoan_DAO dao_tk = new TaiKhoan_DAO();
		getContentPane().setLayout(new BorderLayout());
		setTitle("DN");
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);	
		setSize(500,500);
		setLocationRelativeTo(null);
		JPanel pnNorth = new JPanel();
		lblAnh = new JLabel("");

		lblAnh.setIcon(new ImageIcon("Icon/User-Administrator-Red-icon.png"));
		pnNorth.add(lblAnh);
		getContentPane().add(pnNorth,BorderLayout.NORTH);
		 pnNorth = new JPanel() { };
			
			lblAnh = new JLabel("");

			lblAnh.setIcon(new ImageIcon("Icon/User-Administrator-Red-icon.png"));
			pnNorth.add(lblAnh);
			getContentPane().add(pnNorth,BorderLayout.NORTH);
		
		
			JPanel pnCenter = new JPanel();
			pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
			JPanel pnThongTin = new JPanel();
	
			
			pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
			pnCenter.add(pnThongTin);
			
			getContentPane().add(pnCenter,BorderLayout.CENTER);
			
			JPanel pnAo = new JPanel();
			pnThongTin.add(pnAo);
		
			
			JPanel pnMaNV = new JPanel();
			JLabel lblmaNV = new JLabel("Mã nhân viên");
			lblmaNV.setFont(new Font("Tahoma", Font.BOLD, 25));
			pnMaNV.add(lblmaNV);
			pnThongTin.add(pnMaNV);
			
			JPanel pnUser = new JPanel();
			JLabel imageuser = new JLabel("");
			imageuser.setIcon(new ImageIcon("Icon/user.PNG"));
		
			
			txtuser = new JTextField(17);
			txtuser.setFont(new Font("Tahoma", Font.BOLD, 25));
			pnUser.add(imageuser);
			pnUser.add(txtuser);
			
			pnThongTin.add(pnUser);
		
			
			
			JPanel pnMK = new JPanel();
			JLabel lblMK = new JLabel("Mật khẩu");
			lblMK.setFont(new Font("Tahoma", Font.BOLD, 25));
			pnMK.add(lblMK);
			pnThongTin.add(pnMK);
			
			JPanel pnpass = new JPanel();
			JLabel imagepass = new JLabel("");
			imagepass.setIcon(new ImageIcon("Icon/pass.PNG"));
			
			
			txtpass = new JPasswordField(10);
			txtpass.setFont(new Font("Tahoma", Font.BOLD, 25));
			
			pnpass.add(imagepass);
			pnpass.add(txtpass);
			pnThongTin.add(pnpass);

		
	
		txtuser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(txtuser.getText().length()>0) {
					lblxoauser.setVisible(true);
				}
				else {
					lblxoauser.setVisible(false);
				}
			}
		});
		txtuser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtuser.setBackground(Color.WHITE);
	
		txtuser.setBorder(null);
//		pnUser.add(txtuser);
	
		
		JPanel pnDN = new JPanel();
		btndangNhap = new JButton("Đăng nhập");
		pnDN.add(btndangNhap);
		pnThongTin.add(pnDN);
		btndangNhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username = txtuser.getText();
				@SuppressWarnings("deprecation")
				String password = txtpass.getText();
				TaiKhoan tk = dao_tk.Login(username, password);
				if(tk != null) {
					ChucNang cn = null;
					try {
						cn = new ChucNang(txtuser.getText().trim());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					cn.setVisible(true);
					close();

				}
				else {
					JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ", "Wrong !", JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});
		
		
		btndangNhap.setForeground(SystemColor.inactiveCaptionBorder);
		btndangNhap.setBackground(new Color(0, 153, 255));
		btndangNhap.setFont(new Font("Tahoma", Font.BOLD, 25));
		btndangNhap.setBounds(155, 469, 202, 49);
		
		

		txtpass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
					String username = txtuser.getText();
					@SuppressWarnings("deprecation")
					String password = txtpass.getText();
					TaiKhoan tk = dao_tk.Login(username, password);
					if(tk != null) {
						ChucNang cn = null;
						try {
							cn = new ChucNang(txtuser.getText().trim());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						cn.setVisible(true);
						close();
					}
					else {
						JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ", "Wrong !", JOptionPane.ERROR_MESSAGE, null);
					}
				}
			}
			@SuppressWarnings("deprecation")
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtpass.getText().length()>0) {
					lblxoapass.setVisible(true);
				}
				else {
					lblxoapass.setVisible(false);
				}
			}
		});
		
		txtpass.setBorder(null);
		
		pnpass.add(txtpass);
		
		JPanel pnxoauser = new JPanel();
		lblxoauser = new JLabel("");
		
		lblxoauser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtuser.setText("");
				txtuser.requestFocus();
				lblxoauser.setVisible(false);
			}
		});
	
		lblxoauser.setBounds(372, 315, 17, 16);
		lblxoauser.setVisible(false);
		pnxoauser.add(lblxoauser);
		
		lblxoapass = new JLabel("");
		JPanel pnxoapass = new JPanel();
		lblxoapass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpass.setText("");
				txtpass.requestFocus();
				lblxoapass.setVisible(false);
			}
		});
	
		lblxoapass.setBounds(371, 410, 17, 16);
		lblxoapass.setVisible(false);
		pnxoapass.add(lblxoapass);
		
		
		txtuser.setPreferredSize(txtpass.getPreferredSize());
		lblmaNV.setPreferredSize(txtpass.getPreferredSize());
		lblMK.setPreferredSize(txtpass.getPreferredSize());
//		
		
//		lblbackground = new JLabel("");
//		lblbackground.setBounds(0, 0, 1416, 711);
//		ImageIcon icon = new ImageIcon("Icon/dark.png");
//		Image img = icon.getImage();
//		Image imgScale = img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
//		ImageIcon scaledIcon = new ImageIcon(imgScale);
//		lblbackground.setIcon(scaledIcon);
//		//lblbackground.setIcon(new ImageIcon(Login.class.getResource("/img1/Banner_CB300R-1024x453.jpg")));
//		contentPane.add(lblbackground);
	
	}
	private void close() {
		WindowEvent winClosing = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
	}


}
