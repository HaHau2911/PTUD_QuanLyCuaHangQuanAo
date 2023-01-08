package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ThemSpVaoGioHang extends JFrame {
	public ThemSpVaoGioHang() {
		setTitle("Đặt hàng");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 10, 416, 168);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã sản phẩm:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 109, 44);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(129, 24, 277, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 53, 115, 44);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(129, 67, 277, 19);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số lượng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 96, 115, 44);
		panel.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(129, 110, 277, 19);
		panel.add(textField_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(15, 188, 416, 58);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Thêm vào giỏ hàng");
		btnNewButton.setBounds(142, 10, 132, 43);
		panel_1.add(btnNewButton);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
}
