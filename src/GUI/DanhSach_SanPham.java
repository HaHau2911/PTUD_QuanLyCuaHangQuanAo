package GUI;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.synth.Region;
import javax.swing.table.DefaultTableModel;

import DAO.SanPham_DAO;
import entity.GioHang;
import entity.SanPham;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class DanhSach_SanPham extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSoLuong;
	private JTable table;
	private DefaultTableModel model;
	private SanPham_DAO sanPham_DAO;
	private ArrayList<SanPham> lstSanPham = new ArrayList<>();
	private JTextField txtTenSP;
	private ArrayList<GioHang> gioHangs = new ArrayList<GioHang>();
	private String maNhanVien;
	private JTextField txtSoLuongTon;

	public DanhSach_SanPham(String maNV) {
		maNhanVien = maNV;
		sanPham_DAO = new SanPham_DAO();
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 5, 969, 574);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã sản phẩm:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(85, 73, 121, 23);
		panel.add(lblNewLabel);

		JComboBox cboMaSP = new JComboBox();
		lstSanPham = sanPham_DAO.getalltbSanPham();
		lstSanPham.forEach(sp -> cboMaSP.addItem(sp.getMaSP()));
		for (SanPham sp : lstSanPham) {
			cboMaSP.addItem(sp.getMaSP());
		}
		cboMaSP.setBounds(216, 71, 484, 30);

		panel.add(cboMaSP);

		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm:");
		lblTnSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnSnPhm.setBounds(85, 112, 110, 23);
		panel.add(lblTnSnPhm);

		JLabel lblNewLabel_1 = new JLabel("Số lượng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(85, 195, 110, 21);
		panel.add(lblNewLabel_1);

		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(216, 193, 484, 30);
		panel.add(txtSoLuong);
		txtSoLuong.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 329, 954, 235);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		model = new DefaultTableModel(new Object[][] {}, new String[] { "Mã sp", "Tên sản phẩm", "Số lượng" });
		table = new JTable(model);
		table.setEnabled(false);
		table.setBackground(Color.WHITE);

		panel_1.add(new JScrollPane(table), BorderLayout.CENTER);

		JButton btnDatHang = new JButton("Đặt hàng");
		btnDatHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDatHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng thêm sản phẩm");
				} else {
					ArrayList<GioHang> gioHangs = new ArrayList<GioHang>();
					if (model.getRowCount() == 1) {
						for (int i = 0; i < 1; i++) {
							GioHang gioHang = new GioHang(model.getValueAt(i, 0).toString().trim(),
									Integer.parseInt(model.getValueAt(i, 2).toString().trim()));
							gioHangs.add(gioHang);
						}
					} else if (model.getRowCount() == 2) {
						for (int i = 0; i < 2; i++) {
							GioHang gioHang = new GioHang(model.getValueAt(i, 0).toString().trim(),
									Integer.parseInt(model.getValueAt(i, 2).toString().trim()));
							gioHangs.add(gioHang);
						}
					} else if (model.getRowCount() > 2) {
						for (int i = 0; i < model.getRowCount(); i++) {
							GioHang gioHang = new GioHang(model.getValueAt(i, 0).toString().trim(),
									Integer.parseInt(model.getValueAt(i, 2).toString().trim()));
							gioHangs.add(gioHang);
						}
					}

					DatHang datHang = new DatHang(gioHangs, maNhanVien);
					datHang.setVisible(true);
				}

			}
		});
		btnDatHang.setBounds(622, 256, 173, 41);
		panel.add(btnDatHang);

		JButton btnXoaRong = new JButton("Giảm số lượng");
		btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaRong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtSoLuong.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng sản phẩm");
				} else {
					String masp = cboMaSP.getSelectedItem().toString().trim();
					int a = checkTonTai(masp, model);
					if (a == -1) {
						JOptionPane.showMessageDialog(null, "Sản phẩm chưa được thêm vào giỏ hàng");
					} else {
						int sl = (Integer) model.getValueAt(a, 2) - Integer.parseInt(txtSoLuong.getText());
						if(sl==0) {
							model.removeRow(a);
							table.setModel(model);
						}
						else if (checkSoLuong(sl, masp)) {
							model.setValueAt(sl, a, 2);
							table.setModel(model);
						}
						else
							JOptionPane.showMessageDialog(null, "Số lượng giảm phải <= số lượng trong giỏ hàng", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnXoaRong.setBounds(396, 256, 173, 41);
		panel.add(btnXoaRong);

		JButton btnThemSanPham = new JButton("Thêm vào giỏ hàng");
		btnThemSanPham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtSoLuong.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng sản phẩm");
				} else {
					String masp = cboMaSP.getSelectedItem().toString().trim();
					int a = checkTonTai(masp, model);
					if (a == -1) {
						try {
							int sl = Integer.parseInt(txtSoLuong.getText());

							if (checkSoLuong(sl, masp)) {
								model.addRow(new Object[] { masp, txtTenSP.getText(), sl });
								table.setModel(model);
							} else
								JOptionPane.showMessageDialog(null, "Số lượng không thoả", "Thông báo",
										JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception e1) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, "Số lượng is numberic");
						}

					} else {
						int sl = Integer.parseInt(txtSoLuong.getText()) + (Integer) model.getValueAt(a, 2);
						if (checkSoLuong(sl, masp)) {
							model.setValueAt(sl, a, 2);
							table.setModel(model);
						} else
							JOptionPane.showMessageDialog(null, "Số lượng không thoả", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		btnThemSanPham.setBounds(165, 256, 173, 41);
		panel.add(btnThemSanPham);

		txtTenSP = new JTextField();
		txtTenSP.setEnabled(false);
		txtTenSP.setBounds(216, 111, 484, 30);
		panel.add(txtTenSP);
		txtTenSP.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Số lượng tồn:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(85, 157, 121, 23);
		panel.add(lblNewLabel_1_1);

		txtSoLuongTon = new JTextField();
		txtSoLuongTon.setEnabled(false);
		txtSoLuongTon.setColumns(10);
		txtSoLuongTon.setBounds(216, 151, 484, 30);
		panel.add(txtSoLuongTon);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 969, 45);
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_2 = new JLabel("Đặt hàng");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel_2.add(lblNewLabel_2);

		cboMaSP.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String a = sanPham_DAO.getTenSp(e.getItem().toString());
					txtTenSP.setText(a);
					int soLuong = sanPham_DAO.getSoLuongTon(e.getItem().toString());
					txtSoLuongTon.setText(soLuong + "");
				}
			}
		});

	}

	public int checkTonTai(String masp, DefaultTableModel model) {
		for (int i = 0; i < model.getRowCount(); i++) {
			if (masp.equalsIgnoreCase(model.getValueAt(i, 0).toString().trim()))
				return i;
		}
		return -1;
	}

	public boolean checkSoLuong(int sl, String maSP) {
		int soLuongMax = sanPham_DAO.getSoLuong(maSP);
		if (sl > soLuongMax || sl < 0) {
			return false;
		}
		return true;
	}
}
