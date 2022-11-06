package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class adminGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnBienLai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminGUI frame = new adminGUI();
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
	public adminGUI() {
		setTitle("Trang chủ");
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

		JButton btnDanhSchBc = new JButton("Danh s\u00E1ch b\u00E1c s\u0129");
		btnDanhSchBc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDanhSchBc_actionPerformed(e);
			}
		});
		btnDanhSchBc.setIcon(new ImageIcon("Image\\bill-12-32.png"));
		btnDanhSchBc.setHorizontalAlignment(SwingConstants.LEFT);
		btnDanhSchBc.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDanhSchBc.setBounds(0, 147, 214, 58);
		contentPane.add(btnDanhSchBc);

		JButton btnDanhSchNhn = new JButton("Danh s\u00E1ch nh\u00E2n vi\u00EAn");
		btnDanhSchNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDanhSchNhn_actionPerformed(e);
			}
		});
		btnDanhSchNhn.setIcon(new ImageIcon("Image\\bill-12-32.png"));
		btnDanhSchNhn.setHorizontalAlignment(SwingConstants.LEFT);
		btnDanhSchNhn.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDanhSchNhn.setBounds(0, 203, 214, 65);
		contentPane.add(btnDanhSchNhn);

		JButton btnDanhSchTi = new JButton("Danh s\u00E1ch t\u00E0i kho\u1EA3n");
		btnDanhSchTi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDanhSchTi_actionPerformed(e);
			}
		});
		btnDanhSchTi.setIcon(new ImageIcon("Image\\bill-12-32.png"));
		btnDanhSchTi.setHorizontalAlignment(SwingConstants.LEFT);
		btnDanhSchTi.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDanhSchTi.setBounds(0, 262, 214, 58);
		contentPane.add(btnDanhSchTi);

		JButton btnToPhiuKhm = new JButton("T\u1EA1o phi\u1EBFu kh\u00E1m b\u1EC7nh");
		btnToPhiuKhm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnToPhiuKhm_actionPerformed(e);
			}
		});
		btnToPhiuKhm.setIcon(new ImageIcon("Image\\create-1-32.png"));
		btnToPhiuKhm.setHorizontalAlignment(SwingConstants.LEFT);
		btnToPhiuKhm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnToPhiuKhm.setBounds(0, 318, 214, 58);
		contentPane.add(btnToPhiuKhm);

		JButton btniuTrBnh = new JButton("\u0110i\u1EC1u tr\u1ECB b\u1EC7nh");
		btniuTrBnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btniuTrBnh_actionPerformed(e);
			}
		});
		btniuTrBnh.setIcon(new ImageIcon("Image\\sick-2-32.png"));
		btniuTrBnh.setHorizontalAlignment(SwingConstants.LEFT);
		btniuTrBnh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btniuTrBnh.setBounds(0, 375, 214, 58);
		contentPane.add(btniuTrBnh);

		JButton btnNewButton_6 = new JButton("Thanh to\u00E1n");
		btnNewButton_6.setIcon(new ImageIcon("Image\\money-48-32.png"));
		btnNewButton_6.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_6.setBounds(0, 432, 214, 58);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnThanhtoan(e);
				
			}
		});
		contentPane.add(btnNewButton_6);

		btnBienLai = new JButton("Biên lai");
		btnBienLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBienLai_actionPerformed(e);
			}
		});
		btnBienLai.setIcon(new ImageIcon("Image\\statistic-2-32.png"));
		btnBienLai.setHorizontalAlignment(SwingConstants.LEFT);
		btnBienLai.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBienLai.setBounds(0, 489, 214, 58);
		contentPane.add(btnBienLai);

		JButton btnNewButton_8 = new JButton("H\u1ED3 s\u01A1 b\u1EC7nh \u00E1n");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_8_actionPerformed(e);
			}
		});
		btnNewButton_8.setIcon(new ImageIcon("Image\\paper-6-32.png"));
		btnNewButton_8.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_8.setBounds(0, 540, 214, 58);
		contentPane.add(btnNewButton_8);

		JLabel lblNewLabel_1 = new JLabel("Xin ch\u00E0o gi\u00E1m \u0111\u1ED1c");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(498, 132, 205, 52);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("Image\\model-employee-256.png"));
		lblNewLabel_2.setBounds(477, 234, 248, 255);
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
	protected void do_btnThanhtoan (ActionEvent e) {
		khamBenhGUI khamBenhGUI = new khamBenhGUI();
		khamBenhGUI.setVisible(true);
		this.setVisible(false);
	}
	protected void do_btnNewButton_8_actionPerformed(ActionEvent e) {
		hsbaGUI hsbaGUI = new hsbaGUI();
		hsbaGUI.setVisible(true);
		this.setVisible(false);
	}

	protected void do_btnDanhSchBc_actionPerformed(ActionEvent e) {
		bacsiGUI bacsiGUI = new bacsiGUI();
		bacsiGUI.setVisible(true);
		this.setVisible(false);
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		benhnhanGUI benhnhanGUI = new benhnhanGUI();
		benhnhanGUI.setVisible(true);
		this.setVisible(false);
	}

	protected void do_btnDanhSchNhn_actionPerformed(ActionEvent e) {
		nhanvienGUI nhanvienGUI = new nhanvienGUI();
		nhanvienGUI.setVisible(true);
		this.setVisible(false);
	}

	protected void do_btnDanhSchTi_actionPerformed(ActionEvent e) {
		accountGUI accountGUI = new accountGUI();
		accountGUI.setVisible(true);
		this.setVisible(false);
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

	protected void do_btnToPhiuKhm_actionPerformed(ActionEvent e) {
		khamBenhGUI khambenhGUI = new khamBenhGUI();
		khambenhGUI.setVisible(true);
		this.setVisible(false);
	}

	protected void do_btniuTrBnh_actionPerformed(ActionEvent e) {
		benhNhan_dichVuGUI benhNhan_dichVuGUI = new benhNhan_dichVuGUI();
		benhNhan_dichVuGUI.setVisible(true);
		this.setVisible(false);
	}
	protected void do_btnBienLai_actionPerformed(ActionEvent e) {
		bienlaiGUI bienlaiGUI = new bienlaiGUI();
		bienlaiGUI.setVisible(true);
		this.setVisible(false);
	}
}
