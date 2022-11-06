package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.accountBLL;
import DTO.account;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class dangKyGUI extends JFrame {
	List<account> accountList = new ArrayList<>();
	accountBLL accBBL = new accountBLL();

	private JPanel contentPane;
	private JTextField tfTaiKhoan;
	private JLabel lblMtKhu;
	private JLabel lblNhpLiMt;
	private JButton btnDangKY;
	private JPasswordField tfMatKhau;
	private JPasswordField tfNhapLaiMK;
	private JTextField tfID;
	private JTextField tfPhanQuyen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangKyGUI frame = new dangKyGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dangKyGUI() {
		setTitle("Đăng ký");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(470, 150, 647, 487);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tài Khoản");
		lblNewLabel.setBounds(193, 84, 91, 29);
		contentPane.add(lblNewLabel);
		
		tfTaiKhoan = new JTextField();
		tfTaiKhoan.setBounds(193, 123, 304, 32);
		contentPane.add(tfTaiKhoan);
		tfTaiKhoan.setColumns(10);
		
		lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setBounds(193, 165, 91, 29);
		contentPane.add(lblMtKhu);
		
		lblNhpLiMt = new JLabel("Nhập lại mật khẩu");
		lblNhpLiMt.setBounds(188, 238, 139, 29);
		contentPane.add(lblNhpLiMt);
		
		btnDangKY = new JButton("Đăng Ký");
		btnDangKY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDangKY_actionPerformed(e);
			}
		});
		btnDangKY.setBounds(271, 350, 118, 29);
		contentPane.add(btnDangKY);
		
		tfMatKhau = new JPasswordField();
		tfMatKhau.setBounds(188, 204, 304, 29);
		contentPane.add(tfMatKhau);
		
		tfNhapLaiMK = new JPasswordField();
		tfNhapLaiMK.setBounds(188, 277, 304, 29);
		contentPane.add(tfNhapLaiMK);
		
		JLabel lblNewLabel_1 = new JLabel("Mã tài khoản");
		lblNewLabel_1.setBounds(132, 34, 80, 23);
		contentPane.add(lblNewLabel_1);
		
		tfID = new JTextField();
		tfID.setEditable(false);
		tfID.setBounds(211, 35, 96, 21);
		contentPane.add(tfID);
		tfID.setColumns(10);
		tfID.setText(String.valueOf(accBBL.getAccountCode()));
		
		JLabel lblNewLabel_1_1 = new JLabel("Chức vụ");
		lblNewLabel_1_1.setBounds(363, 34, 55, 23);
		contentPane.add(lblNewLabel_1_1);
		
		tfPhanQuyen = new JTextField();
		tfPhanQuyen.setText("Nhân viên");
		tfPhanQuyen.setEditable(false);
		tfPhanQuyen.setColumns(10);
		tfPhanQuyen.setBounds(424, 35, 96, 21);
		contentPane.add(tfPhanQuyen);
		
		JButton btnNewButton = new JButton("Trở lại");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(0, 0, 96, 29);
		contentPane.add(btnNewButton);
	}
	protected void do_btnDangKY_actionPerformed(ActionEvent e) {
		if(tfTaiKhoan.getText().equals("") || String.valueOf(tfMatKhau.getPassword()).equals("") || String.valueOf(tfNhapLaiMK.getPassword()).equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin cần nhập !!!"); 
		}
		else if(String.valueOf(tfMatKhau.getPassword()).equals("") != String.valueOf(tfNhapLaiMK.getPassword()).equals("")){
			JOptionPane.showMessageDialog(null, "Mật khẩu không trùng nhau !!!");
		}
		else {
			try {
				int id = Integer.parseInt(tfID.getText());
				String name = tfTaiKhoan.getText();
				String password = String.valueOf(tfMatKhau.getPassword());
				String permission = tfPhanQuyen.getText();

				Date dateCurrent = new Date(System.currentTimeMillis());
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String ngaydk = dateFormat.format(dateCurrent);
				account p = new account(id, name, password, permission, ngaydk );

				
				JOptionPane.showMessageDialog(null, accBBL.addAccount(p));
				
				loginGUI loginGUI = new loginGUI();
				loginGUI.setVisible(true);
				this.setVisible(false);
				
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Nhập đúng định dạng");
			}
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		loginGUI loginGUI = new loginGUI();
		loginGUI.setVisible(true);
		this.setVisible(false);
	}
}
