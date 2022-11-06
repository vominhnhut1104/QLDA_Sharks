package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.benhNhan_DichVuBLL;
import BLL.benhnhanBLL;
import BLL.dichvuBLL;
import BLL.khambenhBLL;
import Check.Tester;
import DTO.benhnhan;
import DTO.benhNhan_DichVu;
import javax.swing.JMenuBar;

public class benhNhan_dichVuGUI extends JFrame {
	List<benhNhan_DichVu> list = new ArrayList<benhNhan_DichVu>();
	benhNhan_DichVuBLL blBLL = new benhNhan_DichVuBLL();
	khambenhBLL kbBLL = new khambenhBLL();
	dichvuBLL dvBLL = new dichvuBLL();
	
	private JPanel contentPane;
	private JTextField tfSophieusd;
	private JTextField tfNgaysd;
	private JTextField tfSoluong;
	private JTextField tfFind;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	private JComboBox cbDichvu;
	private JPanel panel_1;
	
	List<String> benhnhanList = kbBLL.getbenhnhanList();
	List<String> dichvuList = dvBLL.getdichvuList();
	private JComboBox cbBenhnhan;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					benhNhan_dichVuGUI frame = new benhNhan_dichVuGUI();
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
	public benhNhan_dichVuGUI() {
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
		
		JLabel lblNewLabel = new JLabel("BỆNH NHÂN _ DỊCH VỤ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(339, 10, 409, 32);
		panel.add(lblNewLabel);
		
		tfFind = new JTextField();
		tfFind.setBounds(918, 10, 221, 30);
		panel.add(tfFind);
		tfFind.setColumns(10);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSearch_actionPerformed(e);
			}
		});
		btnSearch.setBounds(1135, 10, 85, 31);
		panel.add(btnSearch);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 15, 101, 22);
		panel.add(menuBar);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(0, 95, 493, 568);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Số phiếu sử dụng");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(26, 34, 121, 42);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên bệnh nhân");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(26, 86, 108, 42);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ngày sử dụng");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(26, 138, 97, 42);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Số lượng dịch vụ");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(26, 190, 121, 42);
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Tên dịch vụ");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(26, 242, 97, 42);
		panel_1.add(lblNewLabel_1_2_2);
		
		tfSophieusd = new JTextField();
		tfSophieusd.setEditable(false);
		tfSophieusd.setBounds(157, 34, 299, 32);
		panel_1.add(tfSophieusd);
		tfSophieusd.setColumns(10);
		tfSophieusd.setText(String.valueOf(blBLL.getMaPhieumax()));
		
		tfNgaysd = new JTextField();
		tfNgaysd.setColumns(10);
		tfNgaysd.setBounds(157, 138, 299, 32);
		panel_1.add(tfNgaysd);
		
		tfSoluong = new JTextField();
		tfSoluong.setColumns(10);
		tfSoluong.setBounds(157, 190, 299, 32);
		panel_1.add(tfSoluong);
		
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
		
		cbDichvu = new JComboBox(dichvuList.toArray());
		cbDichvu.setBounds(157, 242, 299, 33);
		panel_1.add(cbDichvu);
		
		cbBenhnhan = new JComboBox(benhnhanList.toArray());
		cbBenhnhan.setBounds(157, 86, 299, 33);
		panel_1.add(cbBenhnhan);
		
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
		model.addColumn("Số phiếu sử dụng");
		model.addColumn("Mã bệnh nhân");
		model.addColumn("Ngày sử dụng");
		model.addColumn("Số lượng dịch vụ");
		model.addColumn("Mã dịch vụ");
		loadData();
		
	}
	
	protected void do_btnReset_actionPerformed(ActionEvent e) {
		tfSophieusd.setText("");
		tfNgaysd.setText("");
		tfSoluong.setText("");
		cbBenhnhan.setSelectedIndex(0);
		cbDichvu.setSelectedIndex(0);
		loadData();
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {            
            tfSophieusd.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tfNgaysd.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
    		tfSoluong.setText(String.valueOf(model.getValueAt(selectedIndex, 4)));
    		
    		String maDv = model.getValueAt(selectedIndex, 5).toString();
    		String tenDv = kbBLL.getData1("dich_vu", "TENDV", maDv, "MADV");
    		cbDichvu.setSelectedItem(tenDv.toString());
    		
    		String maBn = model.getValueAt(selectedIndex, 2).toString();
    		String tenBn = kbBLL.getData1("benh_nhan", "TENBN", maBn, "MABN");
    		cbBenhnhan.setSelectedItem(tenBn.toString());
        }
	}
	protected void do_btnEdit_actionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if(index>=0 && !tfSophieusd.getText().trim().equals("") && !tfNgaysd.getText().trim().equals("") && !tfSoluong.getText().trim().equals("")) {
				int soPhieuSD =  Integer.parseInt(tfSophieusd.getText());
				String ngaySD = tfNgaysd.getText();
				int soluong = Integer.parseInt(tfSoluong.getText());
				
				String tenBenhNhan = String.valueOf(cbBenhnhan.getSelectedItem().toString());
				int maBN = kbBLL.getData("benh_nhan", "MABN", tenBenhNhan, "TENBN");
				
				String tenDichvu = String.valueOf(cbDichvu.getSelectedItem().toString());
				int maDV = kbBLL.getData("dich_vu", "MADV", tenDichvu, "TENDV");
				
				benhNhan_DichVu s = new benhNhan_DichVu(soPhieuSD, maBN, ngaySD, soluong, maDV);		
				if(!Tester.day(s.getNgaySD())) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng của ngày");
					return;
				}
				JOptionPane.showMessageDialog(null, blBLL.editPhieu(s));
				loadData();
				do_btnReset_actionPerformed(e);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn biên lai để sửa");
			}
			
		}catch(InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của biên lai");
		}
	}
	
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		if(!tfSophieusd.getText().trim().equals("") && !tfNgaysd.getText().trim().equals("") && !tfSoluong.getText().trim().equals("")) {
			try {
				int soPhieuSD =  Integer.parseInt(tfSophieusd.getText());
				String ngaySD = String.valueOf(tfNgaysd.getText());
				int soluong = Integer.parseInt(tfSoluong.getText());
			
				String tenBn = String.valueOf(cbBenhnhan.getSelectedItem().toString());
				int maBN = kbBLL.getData("benh_nhan", "MABN", tenBn, "TENBN");
				
				String tenDv = String.valueOf(cbDichvu.getSelectedItem().toString());
				int maDV = kbBLL.getData("dich_vu", "MADV", tenDv, "TENDV");
				
				Tester t = new Tester();
				if(!t.day(ngaySD)) {
					JOptionPane.showMessageDialog(null, "Ngày không hợp lệ");
					return;
				}
				benhNhan_DichVu s = new benhNhan_DichVu(soPhieuSD, maBN, ngaySD, soluong, maDV);				
				JOptionPane.showMessageDialog(null,blBLL.addPhieu(s));
				loadData();
				do_btnReset_actionPerformed(e);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai dữ liệu. Vui lòng thử lại");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của biên lai");
		}
	}
	
	protected void do_btnRemove_actionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0 && !tfSophieusd.getText().equals("")) {
        	int code =  Integer.parseInt(tfSophieusd.getText());
//            Product p = productList.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa phiếu này không?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa phiếu này không?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
            		JOptionPane.showMessageDialog(null,blBLL.deletePhieu(code));
            		loadData();
    				do_btnReset_actionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn phiếu để xóa");
        }
	}
	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		int bienLaiCode = Integer.parseInt(tfFind.getText());
        if(bienLaiCode > 0) {
        	list = blBLL.searchBienLaiByCode(bienLaiCode);
            
            if(list.size()==0) {
            	JOptionPane.showMessageDialog(null, "Không có biên lai bạn cần tìm");
            	loadData();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < list.size()) {
	    			benhNhan_DichVu p = list.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getSphieuSD(), p.getMaBN(), p.getNgaySD(), p.getSoluongDV(), p.getMaDV()
	    			});
	    			i++;
	    		}
            }
        } else {
        	JOptionPane.showMessageDialog(null, "Vui lòng nhập tên biên lai cấp để tìm kiếm");
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
	
	private void loadData() {
		model.setRowCount(0);
		list = blBLL.getAllBill();
    	int i = 0;
		while(i < list.size()) {
			benhNhan_DichVu p = list.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getSphieuSD(), p.getMaBN(), p.getNgaySD(), p.getSoluongDV(), p.getMaDV()
			});
			i++;
		}
		
	}
}
