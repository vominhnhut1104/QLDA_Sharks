package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class employeeGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeeGUI frame = new employeeGUI();
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
	public employeeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 900, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 886, 93);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("H\u1EC7 th\u1ED1ng qu\u1EA3n l\u00FD b\u1EC7nh vi\u1EC7n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(272, 23, 509, 51);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Danh s\u00E1ch b\u1EC7nh nh\u00E2n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("Image\\bill-12-32.png"));
		btnNewButton.setBounds(0, 92, 214, 58);
		contentPane.add(btnNewButton);
		
		JButton btnToPhiuKhm = new JButton("T\u1EA1o phi\u1EBFu kh\u00E1m b\u1EC7nh");
		btnToPhiuKhm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnToPhiuKhm_actionPerformed(e);
			}
		});
		btnToPhiuKhm.setIcon(new ImageIcon("Image\\create-1-32.png"));
		btnToPhiuKhm.setHorizontalAlignment(SwingConstants.LEFT);
		btnToPhiuKhm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnToPhiuKhm.setBounds(0, 147, 214, 58);
		contentPane.add(btnToPhiuKhm);
		
		JButton btnNewButton_6 = new JButton("Thanh to\u00E1n");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_6_actionPerformed(e);
			}
		});
		btnNewButton_6.setIcon(new ImageIcon("Image\\money-48-32.png"));
		btnNewButton_6.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_6.setBounds(0, 200, 214, 58);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_1 = new JLabel("Xin ch\u00E0o nh\u00E2n vi\u00EAn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(498, 132, 227, 52);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("Image\\worker-3-256.png"));
		lblNewLabel_2.setBounds(477, 220, 248, 255);
		contentPane.add(lblNewLabel_2);
		
		JButton btnlogout = new JButton("Đăng xuất");
		btnlogout.setIcon(new ImageIcon("Image\\logout-7-32.png"));
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnlogout_actionPerformed(e);
			}
		});
		btnlogout.setBounds(746, 92, 140, 30);
		contentPane.add(btnlogout);
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		benhnhanGUI benhnhanGUI = new benhnhanGUI();
		benhnhanGUI.setVisible(true);
		this.setVisible(false);
	}
	protected void do_btnToPhiuKhm_actionPerformed(ActionEvent e) {
		khamBenhGUI khambenhGUI = new khamBenhGUI();
		khambenhGUI.setVisible(true);
		this.setVisible(false);
	}
	protected void do_btnNewButton_6_actionPerformed(ActionEvent e) {
	}
	protected void do_btnlogout_actionPerformed(ActionEvent e) {
		int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất ko?", "Question",
				JOptionPane.YES_NO_OPTION);

		if (option == JOptionPane.YES_OPTION) {
			loginGUI loginGUI = new loginGUI();
			loginGUI.setVisible(true);
			this.setVisible(false);
		}
	}
}
