   package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.*;
import Check.Tester;
import DAL.*;
import DTO.*;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class hsbaGUI extends JFrame {
	List<hsba> hsbaList = new ArrayList<hsba>();
	hsbaBLL hsbaBLL = new hsbaBLL();
	khambenhBLL kbBLL = new khambenhBLL();
	
	private JPanel contentPane;
	private JTextField tfhsbaCode;
	private JTextField tfngaybd;
	private JTextField tfngaykt;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JComboBox cbBenhnhan;
	List<String> benhnhanList = hsbaBLL.getbenhnhanList();
	private JComboBox cbBacsi;
	List<String> bacsiList = hsbaBLL.getbacsiList();
	private JComboBox cbKetqua;
	String kq[] = {"Chữa khỏi","Không chữa khỏi"};
	private JTextField tfFind;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hsbaGUI frame = new hsbaGUI();
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
	public hsbaGUI() {
		setResizable(false);
		setTitle("hồ sơ bệnh án");
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
		
		JLabel lblNewLabel = new JLabel("DANH S\u00C1CH H\u1ED2 S\u01A0 B\u1EC6NH \u00C1N");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(339, 10, 334, 32);
		panel.add(lblNewLabel);
		
		tfFind = new JTextField();
		tfFind.setBounds(880, 9, 247, 27);
		panel.add(tfFind);
		tfFind.setColumns(10);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setBounds(1126, 9, 94, 28);
		panel.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSearch_actionPerformed(e);
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(0, 95, 493, 568);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hồ sơ:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 34, 63, 42);
		panel_1.add(lblNewLabel_1);
		
		tfhsbaCode = new JTextField();
		tfhsbaCode.setEditable(false);
		tfhsbaCode.setBounds(176, 36, 286, 42);
		panel_1.add(tfhsbaCode);
		tfhsbaCode.setColumns(10);
		tfhsbaCode.setText(String.valueOf(hsbaBLL.getMaHSMax()));
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày bắt đầu:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 107, 108, 42);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ngày kết thúc:");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(10, 180, 97, 42);
		panel_1.add(lblNewLabel_1_2);
		
		tfngaybd = new JTextField();
		tfngaybd.setColumns(10);
		tfngaybd.setBounds(175, 109, 287, 42);
		panel_1.add(tfngaybd);
		
		tfngaykt = new JTextField();
		tfngaykt.setColumns(10);
		tfngaykt.setBounds(176, 182, 286, 42);
		panel_1.add(tfngaykt);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Kết quả:");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(10, 255, 108, 42);
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Tên bác sĩ:");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(10, 324, 108, 42);
		panel_1.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Tên bệnh nhân:");
		lblNewLabel_1_2_3.setForeground(Color.BLACK);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_3.setBounds(10, 393, 108, 42);
		panel_1.add(lblNewLabel_1_2_3);
		
		cbKetqua = new JComboBox(kq);
		cbKetqua.setBounds(176, 256, 286, 42);
		panel_1.add(cbKetqua);
		
		cbBacsi = new JComboBox(bacsiList.toArray());
		cbBacsi.setBounds(176, 325, 286, 42);
		panel_1.add(cbBacsi);
		
		cbBenhnhan = new JComboBox(benhnhanList.toArray());
		cbBenhnhan.setBounds(176, 394, 286, 42);
		panel_1.add(cbBenhnhan);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReset_actionPerformed(e);
			}
		});
		btnReset.setBounds(33, 479, 85, 42);
		panel_1.add(btnReset);
		
		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnEdit_actionPerformed(e);
			}
		});
		btnEdit.setBounds(262, 479, 85, 42);
		panel_1.add(btnEdit);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		btnAdd.setBounds(377, 479, 85, 42);
		panel_1.add(btnAdd);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDelete_actionPerformed(e);
			}
		});
		btnDelete.setBounds(147, 479, 85, 42);
		panel_1.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(493, 95, 727, 568);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_table_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		loadDataColum();
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
	private void loadDataColum() {
		
		model.addColumn("STT");
		model.addColumn("Mã hồ sơ");
		model.addColumn("Ngày bắt đầu");
		model.addColumn("Ngày kết thúc");
		model.addColumn("Kết quả");
		model.addColumn("Mã bác sĩ điều trị");
		model.addColumn("Mã bệnh nhân");
		table.setModel(model);
	}
	private void displayList() {
		model.setRowCount(0);
		hsbaList = hsbaBLL.getAllhsba();
    	int i = 0;
		while(i < hsbaList.size()) {
			hsba p = hsbaList.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getMahs() , p.getNgaybd(),p.getNgaykt(),p.getKetqua(),p.getMabs(),p.getMabn()
			});
			i++;
		}
	}
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		if(!tfhsbaCode.getText().trim().equals("") && !tfngaybd.getText().trim().equals("")  && !tfngaykt.getText().trim().equals("")) {
			try {
				int code =  Integer.parseInt(tfhsbaCode.getText());
				String ngaybd = tfngaybd.getText();
				String ngaykt =tfngaykt.getText();
				String ketqua = (String) cbKetqua.getSelectedItem();
				
				String tenBn = String.valueOf(cbBenhnhan.getSelectedItem().toString());
				int mabn = kbBLL.getData("benh_nhan", "MABN", tenBn, "TENBN");
				
				String tenBs = String.valueOf(cbBacsi.getSelectedItem().toString());
				int mabs = kbBLL.getData("bac_si", "MABS", tenBs, "TENBS");
				Tester t = new Tester();
				if(!t.day(ngaybd) || !t.day(ngaykt)) {
					JOptionPane.showMessageDialog(null, "Ngày không hợp lệ");
					return ;
				}
				hsba s=new hsba(code,ngaybd,ngaykt,ketqua,mabs,mabn);
				JOptionPane.showMessageDialog(null,hsbaBLL.addhsba(s));
				displayList();
//				btnResetActionPerformed(e);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai dữ liệu. Vui lòng thử lại");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của hồ sơ");
		}
	}
	protected void do_btnReset_actionPerformed(ActionEvent e) {
		tfhsbaCode.setText(String.valueOf(hsbaBLL.getMaHSMax()));
		tfngaybd.setText("");
		tfngaykt.setText("");
		cbKetqua.setSelectedIndex(0);
		cbBacsi.setSelectedIndex(0);
		cbBenhnhan.setSelectedIndex(0);
		displayList();
	}
	protected void do_btnEdit_actionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if(index>=0 && !tfhsbaCode.getText().trim().equals("") && !tfngaybd.getText().trim().equals("") && !tfngaykt.getText().trim().equals("")) {
				hsba p = new hsba();
				p.setMahs(Integer.parseInt(tfhsbaCode.getText()));
				p.setNgaybd(tfngaybd.getText());
				p.setNgaykt(tfngaykt.getText());
				p.setKetqua(cbKetqua.getSelectedItem().toString());
				
				String tenBenhNhan = String.valueOf(cbBenhnhan.getSelectedItem().toString());
				int mabn = kbBLL.getData("benh_nhan", "MABN", tenBenhNhan, "TENBN");
				p.setMabn(mabn);
				
				String tenBs = String.valueOf(cbBacsi.getSelectedItem().toString());
				int mabs = kbBLL.getData("bac_si", "MABS", tenBs, "TENBS");
				p.setMabs(mabs);
				Tester t = new Tester();
				if(!t.day(tfngaybd.getText()) || !t.day(tfngaykt.getText())) {
					JOptionPane.showMessageDialog(null, "Ngày không hợp lệ");
					return ;
				}
				JOptionPane.showMessageDialog(null, hsbaBLL.edithsba(p));
				displayList();
				do_btnReset_actionPerformed(e);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn hồ sơ để sửa");
			}
			
		}catch(InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của hồ sơ");
		}
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {            
            tfhsbaCode.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tfngaybd.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		tfngaykt.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
    		cbKetqua.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 4)));
    		
    		String maBs = model.getValueAt(selectedIndex, 5).toString();
    		String tenBs = kbBLL.getData1("bac_si", "TENBS", maBs, "MABS");
    		cbBacsi.setSelectedItem(tenBs.toString());
    		
    		String maBn = model.getValueAt(selectedIndex, 6).toString();
    		String tenBn = kbBLL.getData1("benh_nhan", "TENBN", maBn, "MABN");
    		cbBenhnhan.setSelectedItem(tenBn.toString());
        }
	}
	protected void do_btnDelete_actionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0 && !tfhsbaCode.getText().equals("")) {
        	int code =  Integer.parseInt(tfhsbaCode.getText());
//            Product p = productList.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa hồ sơ này không?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa hồ sơ này không?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
            		JOptionPane.showMessageDialog(null,hsbaBLL.deletehsba(code));
	                displayList();
	                do_btnReset_actionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn hồ sơ để xóa");
        }
	}  
	protected void do_btnSearch_actionPerformed(ActionEvent e) {
//		int id =  Integer.parseInt(tfFind.getText());
//		System.out.print(id);
		System.out.print(tfFind.getText());
        if(!tfFind.getText().equals("")) {
        	int id =  Integer.parseInt(tfFind.getText());
            hsbaList = hsbaBLL.searchhsbaByName(id);
            
            if(hsbaList.size()==0) {
            	JOptionPane.showMessageDialog(null, "Không có hồ sơ bạn cần tìm");
            	displayList();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < hsbaList.size()) {
	    			hsba p = hsbaList.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getMahs() , p.getNgaybd(),p.getNgaykt(),p.getKetqua(),p.getMabs(),p.getMabn()
	    			});
	    			i++;
	    		}
            }
            
        } else {
        	JOptionPane.showMessageDialog(null, "Vui lòng nhập tên hồ sơ cấp để tìm kiếm");
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
