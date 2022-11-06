package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import BLL.accountBLL;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class loginGUI extends JFrame {
	accountBLL accBLL = new accountBLL();
	
	private JPanel contentPane;
	private JTextField tfAccountName;
	private JLabel lblMtKhu;
	private JPasswordField tfPass;

	static String code = null;
	static String permission = null;
	private JButton btnDangKy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginGUI frame = new loginGUI();
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
	public loginGUI() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 752, 456);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAcountName = new JLabel("T\u00EAn \u0110\u0103ng Nh\u1EADp");
		lblAcountName.setForeground(Color.WHITE);
		lblAcountName.setBackground(Color.WHITE);
		lblAcountName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAcountName.setBounds(462, 45, 139, 38);
		contentPane.add(lblAcountName);
		
		tfAccountName = new JTextField();
		tfAccountName.setBounds(459, 93, 235, 38);
		contentPane.add(tfAccountName);
		tfAccountName.setColumns(10);
		
		lblMtKhu = new JLabel("M\u1EADt Kh\u1EA9u");
		lblMtKhu.setForeground(Color.WHITE);
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMtKhu.setBackground(Color.WHITE);
		lblMtKhu.setBounds(462, 152, 139, 38);
		contentPane.add(lblMtKhu);
		
		tfPass = new JPasswordField();
		tfPass.setBounds(459, 200, 235, 38);
		contentPane.add(tfPass);
		
		JButton btnDangNhap = new JButton("\u0110\u0103ng Nh\u1EADp");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDangNhap_actionPerformed(e);
			}
		});
		btnDangNhap.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDangNhap.setBounds(462, 275, 232, 45);
		contentPane.add(btnDangNhap);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setIcon(new ImageIcon("Image\\unnamed.jpg"));
		lblNewLabel.setBounds(0, 0, 413, 419);
		contentPane.add(lblNewLabel);
		
		btnDangKy = new JButton("Đăng ký");
		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDangKy_actionPerformed(e);
			}
		});
		btnDangKy.setForeground(Color.RED);
		btnDangKy.setBorder(null);
		btnDangKy.setBackground(Color.CYAN);
		btnDangKy.setBounds(609, 358, 85, 21);
		contentPane.add(btnDangKy);
		
		JLabel lblNewLabel_1 = new JLabel("Bạn chưa có tài khoản ?");
		lblNewLabel_1.setBounds(462, 360, 139, 17);
		contentPane.add(lblNewLabel_1);
	}
	protected void do_btnDangNhap_actionPerformed(ActionEvent e) {
		if(tfAccountName.getText().equals("") || String.valueOf(tfPass.getPassword()).equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin đăng nhập"); 
		}
		else {
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
				
				String sql = "SELECT * FROM account WHERE ACCOUNT_NAME = ? AND PASS = ?";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, tfAccountName.getText());
				ps.setString(2, String.valueOf(tfPass.getPassword()));
				
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
					code = String.valueOf(accBLL.getId(tfAccountName.getText().toString()));
					permission = accBLL.getPermission(Integer.parseInt(code));
					if(permission.equals("Giám đốc")) {
						adminGUI index = new adminGUI();
						index.setVisible(true);
					}
					else if(permission.equals("Quản trị hệ thống")) {
						quantriGUI quantri = new quantriGUI();
						quantri.setVisible(true);
					}
					else if(permission.equals("Bác sĩ")) {
						doctorGUI bacsi = new doctorGUI();
						bacsi.setVisible(true);
					}
					else {
						employeeGUI nhanvien = new employeeGUI();
						nhanvien.setVisible(true);
					}
					this.setVisible(false);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	protected void do_btnDangKy_actionPerformed(ActionEvent e) {
		dangKyGUI dangKyGUI = new dangKyGUI();
		dangKyGUI.setVisible(true);
		this.setVisible(false);
	}
}
