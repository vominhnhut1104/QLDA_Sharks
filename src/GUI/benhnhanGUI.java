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

import BLL.benhnhanBLL;
import DTO.benhnhan;
import Check.Tester;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;

public class benhnhanGUI extends JFrame {
	List<benhnhan> benhnhanList = new ArrayList<benhnhan>();
	benhnhanBLL bnBLL = new benhnhanBLL();
	
	private JPanel contentPane;
	private JTextField tfbenhnhanCode;
	private JTextField tfbenhnhanName;
	private JTextField tfBenhnhanAddress;
	private JTextField tfFind;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	private JComboBox cbGioiTinh;
	private JComboBox cbSogiuong;
	private JPanel panel_1;
	private JComboBox cbSophong;
	
	String[] gioiTinhList = {"Nam", "Nữ", "Khác"};
	String[] sogiuongList = {"1", "2", "3", "4"};
	String[] soPhongList = {"1", "2", "3", "4", "5", "6"};
	private JDateChooser dcNgaysinh;
	Date dateCurrent = new Date(System.currentTimeMillis());
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					benhnhanGUI frame = new benhnhanGUI();
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
	public benhnhanGUI() {
		setTitle("Bệnh  nhân");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1234, 695);
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
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH HỒ SƠ BỆNH NHÂN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(339, 10, 409, 32);
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
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(0, 95, 493, 568);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã bệnh nhân");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(26, 34, 114, 42);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên bệnh nhân");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(26, 86, 108, 42);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ngày sinh");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(26, 138, 97, 42);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("địa chỉ");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(26, 190, 97, 42);
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Giới tính");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(26, 242, 97, 42);
		panel_1.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Số giường");
		lblNewLabel_1_2_3.setForeground(Color.BLACK);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_3.setBounds(26, 303, 97, 42);
		panel_1.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Số phòng");
		lblNewLabel_1_2_4.setForeground(Color.BLACK);
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_4.setBounds(26, 358, 97, 42);
		panel_1.add(lblNewLabel_1_2_4);
		
		tfbenhnhanCode = new JTextField();
		tfbenhnhanCode.setEditable(false);
		tfbenhnhanCode.setBounds(157, 34, 299, 32);
		panel_1.add(tfbenhnhanCode);
		tfbenhnhanCode.setColumns(10);
		tfbenhnhanCode.setText(String.valueOf(bnBLL.getMaBNMax()));
		
		tfbenhnhanName = new JTextField();
		tfbenhnhanName.setColumns(10);
		tfbenhnhanName.setBounds(157, 86, 299, 32);
		panel_1.add(tfbenhnhanName);
		
		tfBenhnhanAddress = new JTextField();
		tfBenhnhanAddress.setColumns(10);
		tfBenhnhanAddress.setBounds(157, 190, 299, 32);
		panel_1.add(tfBenhnhanAddress);
		
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
		
		cbGioiTinh = new JComboBox(gioiTinhList);
		cbGioiTinh.setBounds(157, 242, 299, 33);
		panel_1.add(cbGioiTinh);
		
		cbSogiuong = new JComboBox(sogiuongList);
		cbSogiuong.setBounds(157, 303, 299, 33);
		panel_1.add(cbSogiuong);
		
		cbSophong = new JComboBox(soPhongList);
		cbSophong.setBounds(157, 358, 299, 33);
		panel_1.add(cbSophong);
		
		dcNgaysinh = new JDateChooser();
		dcNgaysinh.setBounds(157, 138, 299, 32);
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
		
		JButton btnGoBack = new JButton("Trở lại");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnGoBack_actionPerformed(e);
			}
		});
		btnGoBack.setBounds(0, 0, 106, 48);
		contentPane.add(btnGoBack);
		
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Mã bệnh nhân");
		model.addColumn("Tên bệnh nhân");
		model.addColumn("Ngày sinh");
		model.addColumn("Địa chỉ");
		model.addColumn("Giới tính");
		model.addColumn("Số giường");
		model.addColumn("Số phòng");
		displayList();
	}
	
	private void displayList() {
		model.setRowCount(0);
		benhnhanList = bnBLL.getAllbenhnhan();
    	int i = 0;
		while(i < benhnhanList.size()) {
			benhnhan p = benhnhanList.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getMabn(), p.getTenbn(), p.getNgaysinh(), p.getDiachi(),p.getGioitinh(), p.getSogiuong() ,p.getSophong()
			});
			i++;
		}
		
	}
	protected void do_btnReset_actionPerformed(ActionEvent e) {
		tfbenhnhanName.setText("");
		tfBenhnhanAddress.setText("");
		cbGioiTinh.setSelectedIndex(0);
		cbSogiuong.setSelectedIndex(0);
		cbSophong.setSelectedIndex(0);
		dcNgaysinh.setDate(dateCurrent);
		tfbenhnhanCode.setText(String.valueOf(bnBLL.getMaBNMax()));
		displayList();
	}
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		if(!tfbenhnhanCode.getText().trim().equals("") && !tfbenhnhanName.getText().trim().equals("") && !tfBenhnhanAddress.getText().trim().equals("")) {
			try {
				int code =  Integer.parseInt(tfbenhnhanCode.getText());
				String name = tfbenhnhanName.getText();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String birth = dateFormat.format(dcNgaysinh.getDate());
				String address = tfBenhnhanAddress.getText();
				String gioitinh = cbGioiTinh.getSelectedItem().toString();
				int sogiuong =  Integer.parseInt(cbSogiuong.getSelectedItem().toString());
				int sophong =  Integer.parseInt(cbSophong.getSelectedItem().toString());
				Tester t = new Tester();
				
				benhnhan s=new benhnhan(code,name,birth,address,gioitinh,sogiuong,sophong);				
				JOptionPane.showMessageDialog(null,bnBLL.addbenhnhan(s));
				displayList();
				do_btnReset_actionPerformed(e);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai dữ liệu. Vui lòng thử lại");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của bệnh nhân");
		}
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {            
            tfbenhnhanCode.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tfbenhnhanName.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		String dd = String.valueOf(model.getValueAt(selectedIndex, 3));
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
    		tfBenhnhanAddress.setText(String.valueOf(model.getValueAt(selectedIndex, 4)));
    		cbGioiTinh.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 5)));
    		cbSogiuong.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 6)));
    		cbSophong.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 7)));
        }
	}
	protected void do_btnEdit_actionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if(index>=0 && !tfbenhnhanCode.getText().trim().equals("") && !tfbenhnhanName.getText().trim().equals("") && !tfBenhnhanAddress.getText().trim().equals("")) {
				benhnhan p = new benhnhan();
				p.setMabn(Integer.parseInt(tfbenhnhanCode.getText()));
				p.setTenbn(tfbenhnhanName.getText());
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String ngaysinh = dateFormat.format(dcNgaysinh.getDate());
				p.setNgaysinh(ngaysinh);
				p.setDiachi(tfBenhnhanAddress.getText());
				p.setGioitinh(cbGioiTinh.getSelectedItem().toString());
				p.setSogiuong(Integer.parseInt(cbSogiuong.getSelectedItem().toString()));
				p.setSophong(Integer.parseInt(cbSophong.getSelectedItem().toString()));
				if(!Tester.day(p.getNgaysinh())) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng của ngày");
					return;
				}
				JOptionPane.showMessageDialog(null, bnBLL.editbenhnhan(p));
				displayList();
				do_btnReset_actionPerformed(e);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân để sửa");
			}
			
		}catch(InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của bệnh nhân");
		}
	}
	protected void do_btnRemove_actionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0 && !tfbenhnhanCode.getText().equals("")) {
        	int code =  Integer.parseInt(tfbenhnhanCode.getText());
//            Product p = productList.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa bệnh nhân này không?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa bệnh nhân này không?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
            		JOptionPane.showMessageDialog(null,bnBLL.deletebenhnhan(code));
	                displayList();
	                do_btnReset_actionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân để xóa");
        }
	}
	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		String benhnhanName = tfFind.getText();
        if(benhnhanName != null && benhnhanName.length() > 0) {
            benhnhanList = bnBLL.searchbenhnhanByName(benhnhanName);
            
            if(benhnhanList.size()==0) {
            	JOptionPane.showMessageDialog(null, "Không có bệnh nhân bạn cần tìm");
            	displayList();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < benhnhanList.size()) {
	    			benhnhan p = benhnhanList.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getMabn(), p.getTenbn(), p.getNgaysinh(), p.getDiachi(),p.getGioitinh(), p.getSogiuong() ,p.getSophong()
	    			});
	    			i++;
	    		}
            }
            
        } else {
        	JOptionPane.showMessageDialog(null, "Vui lòng nhập tên bệnh nhân cấp để tìm kiếm");
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
