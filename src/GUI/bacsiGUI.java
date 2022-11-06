package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.accountBLL;
import BLL.bacsiBLL;
import DTO.bacsi;
import Check.Tester;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;

public class bacsiGUI extends JFrame {
	List<bacsi> bacsiList = new ArrayList<bacsi>();
	bacsiBLL bsBLL = new bacsiBLL();
	accountBLL aBLL = new accountBLL();
	
	private JPanel contentPane;
	private JTextField tfbacsiCode;
	private JTextField tfbacsiName;
	private JTextField tfDienthoai;
	private JTextField tfbacsiAddress;
	private JTextField tfFind;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	private JComboBox cbGioiTinh;
	Date dateCurrent = new Date(System.currentTimeMillis());
	private JDateChooser DCNGAYSINH;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bacsiGUI frame = new bacsiGUI();
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
	public bacsiGUI() {
		setTitle("Bác sĩ");
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
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH BÁC SĨ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(406, 8, 221, 32);
		panel.add(lblNewLabel);
		
		tfFind = new JTextField();
		tfFind.setBounds(875, 10, 221, 30);
		panel.add(tfFind);
		tfFind.setColumns(10);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSearch_actionPerformed(e);
			}
		});
		btnSearch.setBounds(1125, 9, 85, 31);
		panel.add(btnSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(0, 95, 493, 568);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã bác sĩ ");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(26, 34, 97, 42);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên bác sĩ");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(26, 86, 108, 42);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(26, 138, 97, 42);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(26, 190, 97, 42);
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Giới tính");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(26, 242, 97, 42);
		panel_1.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Ngày sinh");
		lblNewLabel_1_2_3.setForeground(Color.BLACK);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_3.setBounds(26, 303, 97, 42);
		panel_1.add(lblNewLabel_1_2_3);
		
		tfbacsiCode = new JTextField();
		tfbacsiCode.setEditable(false);
		tfbacsiCode.setBounds(157, 34, 299, 32);
		panel_1.add(tfbacsiCode);
		tfbacsiCode.setColumns(10);
		tfbacsiCode.setText(String.valueOf(bsBLL.getMaBSMax()));
		
		tfbacsiName = new JTextField();
		tfbacsiName.setColumns(10);
		tfbacsiName.setBounds(157, 86, 299, 32);
		panel_1.add(tfbacsiName);
		
		tfDienthoai = new JTextField();
		tfDienthoai.setColumns(10);
		tfDienthoai.setBounds(157, 138, 299, 32);
		panel_1.add(tfDienthoai);
		
		tfbacsiAddress = new JTextField();
		tfbacsiAddress.setColumns(10);
		tfbacsiAddress.setBounds(157, 190, 299, 32);
		panel_1.add(tfbacsiAddress);
		
		cbGioiTinh = new JComboBox();
		cbGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbGioiTinh.setBounds(157, 242, 299, 33);
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
		
		JButton btnEdit = new JButton("Sửa ");
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
		
		DCNGAYSINH = new JDateChooser();
		DCNGAYSINH.setBounds(157, 314, 281, 32);
		panel_1.add(DCNGAYSINH);
		DCNGAYSINH.setDate(dateCurrent);
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
		
		JButton btnGoBack = new JButton("Trở lại");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnGoBack_actionPerformed(e);
			}
		});
		btnGoBack.setBounds(0, 0, 106, 48);
		contentPane.add(btnGoBack);
		model.addColumn("STT");
		model.addColumn("Mã bác sĩ");
		model.addColumn("Tên bác sĩ");
		model.addColumn("Số điện thoại");
		model.addColumn("Địa chỉ");
		model.addColumn("Giới tính");
		model.addColumn("Ngày sinh");
		
		displayList();
	}
	
	private void displayList() {
		model.setRowCount(0);
		bacsiList = bsBLL.getAllbacsi();
		
    	int i = 0;
		while(i < bacsiList.size()) {
			bacsi p = bacsiList.get(i);
//			System.out.print(p.getMabs());
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getMabs(), p.getTenbs(), p.getDienthoai(), p.getDiachi(),p.getGioitinh(),p.getNgaysinh()
			});
			i++;
		}
		
	}
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		if(!tfbacsiCode.getText().trim().equals("") && !tfbacsiName.getText().trim().equals("") && !tfbacsiAddress.getText().trim().equals("")&& !tfDienthoai.getText().trim().equals("")) {
			try {
				int code =  Integer.parseInt(tfbacsiCode.getText());
				String name = tfbacsiName.getText();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String birth = dateFormat.format(DCNGAYSINH.getDate());				
				Tester t = new Tester();
				if(!t.day(birth)) {
					JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ");
					return ;
				}
				String address = tfbacsiAddress.getText();
				String gioitinh = cbGioiTinh.getSelectedItem().toString();
				String dienthoai = tfDienthoai.getText();
				if(!t.numberPhone(dienthoai)) {
					JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
					return ;
				}
				bacsi s=new bacsi(code,name,dienthoai,address,gioitinh,birth);				
				JOptionPane.showMessageDialog(null,bsBLL.addbacsi(s));
				displayList();
				do_btnReset_actionPerformed(e);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai dữ liệu. Vui lòng thử lại");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của bác sĩ");
		}
	}
	protected void do_btnReset_actionPerformed(ActionEvent e) {
		tfbacsiCode.setText("");
		tfbacsiName.setText("");
		tfDienthoai.setText("");
		tfbacsiAddress.setText("");
		cbGioiTinh.setSelectedIndex(0);
		DCNGAYSINH.setDate(dateCurrent);
		tfbacsiCode.setText(String.valueOf(bsBLL.getMaBSMax()));
		displayList();
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {            
            tfbacsiCode.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tfbacsiName.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		tfDienthoai.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
    		tfbacsiAddress.setText(String.valueOf(model.getValueAt(selectedIndex, 4)));
            cbGioiTinh.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 5)));
            String dd = String.valueOf(model.getValueAt(selectedIndex, 6));
			String pattern = "dd/mm/yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			simpleDateFormat.setLenient(false);
			try {
				java.util.Date date = simpleDateFormat.parse(dd);
				DCNGAYSINH.setDate(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
	}
	protected void do_btnEdit_actionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if(index>=0 && !tfbacsiCode.getText().trim().equals("") && !tfbacsiName.getText().trim().equals("") &&  !tfbacsiAddress.getText().trim().equals("")&& !tfDienthoai.getText().trim().equals("")) {
				bacsi p = new bacsi();
				p.setMabs(Integer.parseInt(tfbacsiCode.getText()));
				p.setTenbs(tfbacsiName.getText());
				p.setDienthoai(tfDienthoai.getText());
				p.setDiachi(tfbacsiAddress.getText());
				p.setGioitinh(cbGioiTinh.getSelectedItem().toString());
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String ngaykham = dateFormat.format(DCNGAYSINH.getDate());
				p.setNgaysinh(ngaykham);
				Tester t = new Tester();
				
				if(!t.numberPhone(tfDienthoai.getText())) {
					JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
					return ;
				}
				JOptionPane.showMessageDialog(null, bsBLL.editbacsi(p));
				displayList();
				do_btnReset_actionPerformed(e);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn bác sĩ để sửa");
			}
			
		}catch(InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của bác sĩ");
		}
	}
	protected void do_btnRemove_actionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0 && !tfbacsiCode.getText().equals("")) {
        	int code =  Integer.parseInt(tfbacsiCode.getText());
//            Product p = productList.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa bác sĩ này không?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa bác sĩ này không?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
            		JOptionPane.showMessageDialog(null,bsBLL.deletebacsi(code));
	                displayList();
	                do_btnReset_actionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn bác sĩ để xóa");
        }
	}
	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		String bacsiName = tfFind.getText();
        if(bacsiName != null && bacsiName.length() > 0) {
            bacsiList = bsBLL.searchbacsiByName(bacsiName);
            
            if(bacsiList.size()==0) {
            	JOptionPane.showMessageDialog(null, "Không có bác sĩ bạn cần tìm");
            	displayList();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < bacsiList.size()) {
	    			bacsi p = bacsiList.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getMabs(), p.getTenbs(), p.getDienthoai(), p.getDiachi(),p.getGioitinh(), p.getNgaysinh()
	    			});
	    			i++;
	    		}
            }
            
        } else {
        	JOptionPane.showMessageDialog(null, "Vui lòng nhập tên bác sĩ cấp để tìm kiếm");
        }
	}
	protected void do_btnGoBack_actionPerformed(ActionEvent e) {
		if(loginGUI.permission.equals("Giám đốc")) {
			adminGUI p = new adminGUI();
			p.setVisible(true);
		}
		else if(loginGUI.permission.equals("Quản trị hệ thống")) {
			quantriGUI p = new quantriGUI();
			p.setVisible(true);
		}
		else if(loginGUI.permission.equals("Bác sĩ")) {
			doctorGUI p = new doctorGUI();
			p.setVisible(true);
		}
		else {
			employeeGUI p = new employeeGUI();
			p.setVisible(true);;
		}
		this.setVisible(false);
	}
}
