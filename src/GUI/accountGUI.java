package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.accountBLL;
import BLL.nhanvienBLL;
import Check.Tester;
import DTO.nhanvien;
import DTO.account;
import com.toedter.calendar.JDateChooser;

public class accountGUI extends JFrame {

	private JPanel contentPane;

	List<account> accountList = new ArrayList<>();
	accountBLL accBBL = new accountBLL();

	private JTextField tfAccountName;
	private JTextField tfPassword;
	private JTextField tfId;
	private JTextField tfFind;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JComboBox cbPhanQuyen;

	String producerList[] = { "Quản trị hệ thống", "Bác sĩ", "Nhân viên" };
	private JDateChooser dcngaydk;
	Date dateCurrent = new Date(System.currentTimeMillis());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accountGUI frame = new accountGUI();
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
	public accountGUI() {
		setTitle("Tài khoản");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 100, 1234, 695);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 47, 1220, 47);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("DANH SÁCH TÀI KHOẢN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(420, 0, 334, 32);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(0, 95, 493, 568);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tên tài khoản");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(26, 34, 97, 42);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(26, 97, 108, 42);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("Chức vụ");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(26, 170, 97, 42);
		panel_1.add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_4 = new JLabel("Mã tài khoản");
		lblNewLabel_1_2_4.setForeground(Color.BLACK);
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_4.setBounds(26, 312, 97, 42);
		panel_1.add(lblNewLabel_1_2_4);

		tfAccountName = new JTextField();
		tfAccountName.setBounds(157, 34, 299, 32);
		panel_1.add(tfAccountName);
		tfAccountName.setColumns(10);

		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(157, 104, 299, 32);
		panel_1.add(tfPassword);
		
		cbPhanQuyen = new JComboBox(producerList);
		cbPhanQuyen.setBounds(157, 176, 299, 33);
		panel_1.add(cbPhanQuyen);

		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setColumns(10);
		tfId.setBounds(157, 319, 299, 32);
		panel_1.add(tfId);
		tfId.setText(String.valueOf(accBBL.getAccountCode()));

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReset_actionPerformed(e);
			}
		});
		btnReset.setBounds(26, 391, 85, 42);
		panel_1.add(btnReset);

		JButton btnRemove = new JButton("Xóa");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRemove_actionPerformed(e);
			}
		});
		btnRemove.setBounds(150, 391, 85, 42);
		panel_1.add(btnRemove);

		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnEdit_actionPerformed(e);
			}
		});
		btnEdit.setBounds(261, 391, 85, 42);
		panel_1.add(btnEdit);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		btnAdd.setBounds(356, 391, 100, 42);
		panel_1.add(btnAdd);
		
				tfFind = new JTextField();
				tfFind.setBounds(26, 468, 313, 30);
				panel_1.add(tfFind);
				tfFind.setColumns(10);
				
						JButton btnSearch = new JButton("Tìm kiếm");
						btnSearch.setBounds(349, 467, 107, 31);
						panel_1.add(btnSearch);
						
						JLabel lblNewLabel_1_2_4_1 = new JLabel("Ngày đăng ký");
						lblNewLabel_1_2_4_1.setForeground(Color.BLACK);
						lblNewLabel_1_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
						lblNewLabel_1_2_4_1.setBounds(26, 245, 97, 42);
						panel_1.add(lblNewLabel_1_2_4_1);
						
						dcngaydk = new JDateChooser();
						dcngaydk.setBounds(157, 245, 299, 31);
						panel_1.add(dcngaydk);
						dcngaydk.setDate(dateCurrent);
						
						
						btnSearch.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								do_btnSearch_actionPerformed(e);
							}
						});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(492, 95, 728, 568);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_table_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Mã tài khoản");
		model.addColumn("Tên tài khoản");
		model.addColumn("Mật khẩu");
		model.addColumn("Phân quyền");
		model.addColumn("Ngày đăng ký");
		displayList();

		JButton btnGoBack = new JButton("Trở lại");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnGoBack_actionPerformed(e);
			}
		});
		btnGoBack.setBounds(0, 0, 106, 48);
		contentPane.add(btnGoBack);
	}

	private void displayList() {
		model.setRowCount(0);
		accountList = accBBL.getAllAccount();
		int i = 0;
		while (i < accountList.size()) {
			account p = accountList.get(i);
			model.addRow(new Object[] { model.getRowCount() + 1, p.getId(), p.getAccountName(), p.getPassword(),
					p.getPermission(), p.getCreateday() });
//			if(loginGUI.permission.equals("Quản trị hệ thống") && !p.getPermission().equals("Giám đốc")) { 
//				model.addRow(new Object [] {
//						model.getRowCount()+1, p.getId(), p.getAccountName(), p.getPassword(), p.getPermission()
//				});
//			}
//			if(loginGUI.permission.equals("Giám đốc")) {
//				model.addRow(new Object [] {
//						model.getRowCount()+1, p.getId(), p.getAccountName(), p.getPassword(), p.getPermission()
//				});
//			}
			i++;
		}

	}

	protected void do_btnReset_actionPerformed(ActionEvent e) {
		tfAccountName.setText("");
		tfPassword.setText("");
		tfFind.setText("");
		cbPhanQuyen.setSelectedIndex(0);
		tfId.setText(String.valueOf(accBBL.getAccountCode()));
		dcngaydk.setDate(dateCurrent);
		displayList();
	}

	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		if (!tfAccountName.getText().trim().equals("") && !tfPassword.getText().trim().equals("")) {
			try {
				int id = Integer.parseInt(tfId.getText());
				String name = tfAccountName.getText();
				String password = tfPassword.getText();
				String permission = cbPhanQuyen.getSelectedItem().toString();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String ngaykham = dateFormat.format(dcngaydk.getDate());
				account p = new account(id, name, password, permission, ngaykham);
				
				JOptionPane.showMessageDialog(null, accBBL.addAccount(p));

				displayList();
				do_btnReset_actionPerformed(e);
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Nhập đúng định dạng");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của tài khoản");
		}
	}

	protected void do_btnEdit_actionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if (index >= 0 && !tfAccountName.getText().equals("") && !tfPassword.getText().equals("")) {
				account p = new account();

				p.setId(Integer.parseInt(tfId.getText()));
				p.setAccountName(tfAccountName.getText());
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String ngaydk = dateFormat.format(dcngaydk.getDate());
				p.setCreateday(ngaydk);
				
				p.setPassword(tfPassword.getText());
				p.setPermission(cbPhanQuyen.getSelectedItem().toString());

				JOptionPane.showMessageDialog(null, accBBL.editAccount(p));
				displayList();
				do_btnReset_actionPerformed(e);
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn tài khoản để sửa");
			}

		} catch (InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của tài khoản");
		} 
	}

	protected void do_btnRemove_actionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
		if (selectedIndex >= 0 && !tfAccountName.getText().equals("")) {
			String accountName = (tfAccountName.getText());

			int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa tài khoản này không?", "Question",
					JOptionPane.YES_NO_OPTION);

			if (option == JOptionPane.YES_OPTION) {
				int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa tài khoản này không?",
						"Question", JOptionPane.YES_NO_OPTION);
				if (sure == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, accBBL.deleteAccount(accountName));
					displayList();
					do_btnReset_actionPerformed(e);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn tài khoản để xóa");
		}
	}

	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		String AccountName = tfFind.getText();
		if (AccountName != null && AccountName.length() > 0) {
			accountList = accBBL.searchAccountByName(AccountName);
			if (accountList.size() == 0) {
				JOptionPane.showMessageDialog(null, "Không có tài khoản bạn cần tìm");
				displayList();
			} else {
				model.setRowCount(0);
				int i = 0;
				while (i < accountList.size()) {
					account p = accountList.get(i);
					model.addRow(new Object[] { model.getRowCount() + 1, p.getId(), p.getAccountName(), p.getPassword(),
							p.getPermission(), p.getCreateday() });
//	    			if(loginGUI.permission.equals("Quản trị hệ thống") && !p.getPermission().equals("Giám đốc")) {
//		    			model.addRow(new Object [] {
//		    					model.getRowCount()+1, p.getId(), p.getAccountName(), p.getPassword(), p.getPermission()
//		    			});
//	    			}
//	    			
//	    			if(loginGUI.permission.equals("Giám đốc")) {
//	    				model.addRow(new Object [] {
//	    						model.getRowCount()+1, p.getId(), p.getAccountName(), p.getPassword(), p.getPermission()
//	    				});
//	    			}
					i++;
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập tên của tài khoản để tìm kiếm");
		}
	}

	protected void do_table_mouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
		if (selectedIndex >= 0) {
			tfId.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
			tfAccountName.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
			tfPassword.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
			cbPhanQuyen.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 4)));
			String dd = String.valueOf(model.getValueAt(selectedIndex, 5));
			String pattern = "dd/mm/yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			simpleDateFormat.setLenient(false);
			try {
				java.util.Date date = simpleDateFormat.parse(dd);
				dcngaydk.setDate(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	protected void do_btnGoBack_actionPerformed(ActionEvent e) {
		if (loginGUI.permission.equals("Giám đốc")) {
			adminGUI p = new adminGUI();
			p.setVisible(true);
		} else if (loginGUI.permission.equals("Quản trị hệ thống")) {
			quantriGUI p = new quantriGUI();
			p.setVisible(true);
		} else if (loginGUI.permission.equals("Bác sĩ")) {
			doctorGUI p = new doctorGUI();
			p.setVisible(true);
		} else {
			employeeGUI p = new employeeGUI();
			p.setVisible(true);
			;
		}
		this.setVisible(false);
	}
}
