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

public class quantriGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quantriGUI frame = new quantriGUI();
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
	public quantriGUI() {
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
		
		JButton btnBenhNhan = new JButton("Danh s\u00E1ch b\u1EC7nh nh\u00E2n");
		btnBenhNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBenhNhan_actionPerformed(e);
			}
		});
		btnBenhNhan.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBenhNhan.setHorizontalAlignment(SwingConstants.LEFT);
		btnBenhNhan.setIcon(new ImageIcon("Image\\bill-12-32.png"));
		btnBenhNhan.setBounds(0, 92, 214, 58);
		contentPane.add(btnBenhNhan);
		
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
		
		JButton btnBaoCao = new JButton("B\u00E1o c\u00E1o");
		btnBaoCao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_7_actionPerformed(e);
			}
		});
		btnBaoCao.setIcon(new ImageIcon("Image\\statistic-2-32.png"));
		btnBaoCao.setHorizontalAlignment(SwingConstants.LEFT);
		btnBaoCao.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBaoCao.setBounds(0, 318, 214, 58);
		contentPane.add(btnBaoCao);
		
		JLabel lblNewLabel_1 = new JLabel("Xin ch\u00E0o qu\u1EA3n tr\u1ECB vi\u00EAn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(498, 132, 256, 52);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("Image\\customer-service-78-256.png"));
		lblNewLabel_2.setBounds(498, 232, 248, 255);
		contentPane.add(lblNewLabel_2);
		
		JButton btnlogout = new JButton("Đăng xuất");
		btnlogout.setIcon(new ImageIcon("Image\\logout-7-32.png"));
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnlogout_actionPerformed(e);
			}
		});
		btnlogout.setBounds(755, 92, 131, 30);
		contentPane.add(btnlogout);
	}

	protected void do_btnBenhNhan_actionPerformed(ActionEvent e) {
		benhnhanGUI benhnhanGUI = new benhnhanGUI();
		benhnhanGUI.setVisible(true);
		this.setVisible(false);
	}
	
	protected void do_btnDanhSchBc_actionPerformed(ActionEvent e) {
		bacsiGUI bacsiGUI = new bacsiGUI();
		bacsiGUI.setVisible(true);
		this.setVisible(false);
	}
	
	protected void do_btnDanhSchNhn_actionPerformed(ActionEvent e) {
		nhanvienGUI nhanvienGUI = new nhanvienGUI();
		nhanvienGUI.setVisible(true);
		this.setVisible(false);
	}
	protected void do_btnDanhSchTi_actionPerformed(ActionEvent e) {
		accountGUI accountGUI  = new accountGUI();
		accountGUI.setVisible(true);
		this.setVisible(false);
	}
	protected void do_btnNewButton_7_actionPerformed(ActionEvent e) {
		
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
