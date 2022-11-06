package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.accountBLL;
import BLL.nhanvienBLL;
import DTO.nhanvien;
import Check.Tester;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Choice;
import com.toedter.calendar.JDateChooser;

public class nhanvienGUI extends JFrame {

	List<nhanvien> nhanvienList = new ArrayList<nhanvien>();
	nhanvienBLL nvBLL = new nhanvienBLL();
	accountBLL aBLL = new accountBLL();

	private JTextField tfnhanvienCode;
	private JTextField tfnhanvienName;
	private JTextField tfnhanvienAddress;
	private JTextField tfFind;
	DefaultTableModel model = new DefaultTableModel();
	private JPanel contentPane;
	private JTable table;
	private JComboBox cbGioiTinh;
	Date dateCurrent = new Date(System.currentTimeMillis());
	private JDateChooser dcNgaysinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nhanvienGUI frame = new nhanvienGUI();
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
	public nhanvienGUI() {
		setTitle("Nhân viên");
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

		JLabel lblNewLabel = new JLabel("DANH SÁCH NHÂN VIÊN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(339, 10, 334, 32);
		panel.add(lblNewLabel);

		tfFind = new JTextField();
		tfFind.setBounds(813, 10, 221, 30);
		panel.add(tfFind);
		tfFind.setColumns(10);

		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSearch_actionPerformed(e);
			}
		});
		btnSearch.setBounds(1033, 10, 85, 31);
		panel.add(btnSearch);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(0, 95, 493, 568);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(26, 34, 97, 42);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(26, 97, 108, 42);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Địa chỉ");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(26, 157, 97, 42);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_2 = new JLabel("Giới tính");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(26, 223, 97, 42);
		panel_1.add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_3 = new JLabel("Ngày sinh");
		lblNewLabel_1_2_3.setForeground(Color.BLACK);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_3.setBounds(26, 294, 97, 42);
		panel_1.add(lblNewLabel_1_2_3);

		tfnhanvienCode = new JTextField();
		tfnhanvienCode.setEditable(false);
		tfnhanvienCode.setBounds(157, 34, 299, 32);
		panel_1.add(tfnhanvienCode);
		tfnhanvienCode.setColumns(10);
		tfnhanvienCode.setText(String.valueOf(nvBLL.getMaNV()));

		tfnhanvienName = new JTextField();
		tfnhanvienName.setColumns(10);
		tfnhanvienName.setBounds(157, 104, 299, 32);
		panel_1.add(tfnhanvienName);

		tfnhanvienAddress = new JTextField();
		tfnhanvienAddress.setColumns(10);
		tfnhanvienAddress.setBounds(157, 164, 299, 32);
		panel_1.add(tfnhanvienAddress);

		cbGioiTinh = new JComboBox();
		cbGioiTinh.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nữ ", "Khác" }));
		cbGioiTinh.setBounds(157, 229, 299, 33);
		panel_1.add(cbGioiTinh);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReset_actionPerformed(e);
			}
		});
		btnReset.setBounds(26, 464, 85, 42);
		panel_1.add(btnReset);

		JButton btnRemove = new JButton("Xóa");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRemove_actionPerformed(e);
			}
		});
		btnRemove.setBounds(140, 464, 85, 42);
		panel_1.add(btnRemove);

		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnEdit_actionPerformed(e);
			}
		});
		btnEdit.setBounds(254, 464, 85, 42);
		panel_1.add(btnEdit);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		btnAdd.setBounds(371, 464, 85, 42);
		panel_1.add(btnAdd);
		
		dcNgaysinh = new JDateChooser();
		dcNgaysinh.setBounds(157, 304, 299, 32);
		panel_1.add(dcNgaysinh);
		dcNgaysinh.setDate(dateCurrent);

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
		model.addColumn("Mã nhân viên");
		model.addColumn("Tên nhân viên");
		model.addColumn("Địa chỉ");
		model.addColumn("Giới tính");
		model.addColumn("Ngày sinh");
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
		nhanvienList = nvBLL.getAllnhanvien();
		int i = 0;
		while (i < nhanvienList.size()) {
			nhanvien p = nhanvienList.get(i);
			model.addRow(new Object[] { model.getRowCount() + 1, p.getManv(), p.getTennv(), p.getDiachi(),
					p.getGioitinh(), p.getNgaysinh() });
			i++;
		}

	}

	protected void do_btnReset_actionPerformed(ActionEvent e) {
		tfnhanvienCode.setText(String.valueOf(nvBLL.getMaNV()));
		tfnhanvienName.setText("");
		tfnhanvienAddress.setText("");
		cbGioiTinh.setSelectedIndex(0);
		dcNgaysinh.setDate(dateCurrent);
		tfFind.setText("");
		displayList();
	}

	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		if (!tfnhanvienCode.getText().trim().equals("") && !tfnhanvienName.getText().trim().equals("")
		 && !tfnhanvienAddress.getText().trim().equals("")) {
			try {

				int code = Integer.parseInt(tfnhanvienCode.getText());
				String name = tfnhanvienName.getText();
				Tester t = new Tester();
				String address = tfnhanvienAddress.getText();
				String gioitinh = cbGioiTinh.getSelectedItem().toString();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String ngaysinh = dateFormat.format(dcNgaysinh.getDate());
				nhanvien s = new nhanvien(code, name, address, gioitinh, ngaysinh);
				JOptionPane.showMessageDialog(null, nvBLL.addnhanvien(s));
				displayList();
				do_btnReset_actionPerformed(e);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai dữ liệu. Vui lòng thử lại");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của nhân viên");
		}
	}

	protected void do_btnEdit_actionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if (index >= 0 && !tfnhanvienCode.getText().trim().equals("") && !tfnhanvienName.getText().trim().equals("")
					&& !tfnhanvienAddress.getText().trim().equals("")) {
				nhanvien p = new nhanvien();
				p.setManv(Integer.parseInt(tfnhanvienCode.getText()));
				p.setTennv(tfnhanvienName.getText());
				p.setDiachi(tfnhanvienAddress.getText());
				p.setGioitinh(cbGioiTinh.getSelectedItem().toString());
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String ngaysinh = dateFormat.format(dcNgaysinh.getDate());
				p.setNgaysinh(ngaysinh);
				JOptionPane.showMessageDialog(null, nvBLL.editnhanvien(p));
				displayList();
				do_btnReset_actionPerformed(e);
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên để sửa");
			}

		} catch (InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của nhân viên");
		}
	}

	protected void do_btnRemove_actionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
		if (selectedIndex >= 0 && !tfnhanvienCode.getText().equals("")) {
			int code = Integer.parseInt(tfnhanvienCode.getText());
//            Product p = productList.get(selectedIndex);

			int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa nhân viên này không?", "Question",
					JOptionPane.YES_NO_OPTION);

			if (option == JOptionPane.YES_OPTION) {
				int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên này không?",
						"Question", JOptionPane.YES_NO_OPTION);
				if (sure == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, nvBLL.deletenhanvien(code));
					displayList();
					do_btnReset_actionPerformed(e);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên để xóa");
		}
	}

	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		String nhanvienName = tfFind.getText();
		if (nhanvienName != null && nhanvienName.length() > 0) {
			nhanvienList = nvBLL.searchnhanvienByName(nhanvienName);

			if (nhanvienList.size() == 0) {
				JOptionPane.showMessageDialog(null, "Không có nhân viên bạn cần tìm");
				displayList();
			}

			else {
				model.setRowCount(0);
				int i = 0;
				while (i < nhanvienList.size()) {
					nhanvien p = nhanvienList.get(i);
					model.addRow(new Object[] { model.getRowCount() + 1, p.getManv(), p.getTennv(), p.getDiachi(),
							p.getGioitinh(), p.getNgaysinh() });
					i++;
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập tên nhân viên cấp để tìm kiếm");
		}
	}

	protected void do_table_mouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
		if (selectedIndex >= 0) {
			tfnhanvienCode.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
			tfnhanvienName.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
			tfnhanvienAddress.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
			cbGioiTinh.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 4)));
			 String dd = String.valueOf(model.getValueAt(selectedIndex, 5));
				String pattern = "dd/mm/yyyy";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				simpleDateFormat.setLenient(false);
				try {
					java.util.Date date = simpleDateFormat.parse(dd);
					dcNgaysinh.setDate(date);
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
