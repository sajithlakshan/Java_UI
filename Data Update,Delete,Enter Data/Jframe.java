package Addjava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Jframe extends JFrame {

	private JPanel contentPane;
	private JTextField t_ID;
	private JTextField F_name;
	private JTextField L_name;
	private JTextField Age;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jframe frame = new Jframe();
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
	public Jframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1234, 732);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		t_ID = new JTextField();
		t_ID.setBounds(110, 49, 152, 20);
		contentPane.add(t_ID);
		t_ID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(36, 51, 64, 17);
		contentPane.add(lblNewLabel);
		
		F_name = new JTextField();
		F_name.setBounds(110, 116, 152, 20);
		contentPane.add(F_name);
		F_name.setColumns(10);
		
		L_name = new JTextField();
		L_name.setBounds(110, 181, 152, 20);
		contentPane.add(L_name);
		L_name.setColumns(10);
		
		Age = new JTextField();
		Age.setBounds(110, 251, 152, 20);
		contentPane.add(Age);
		Age.setColumns(10);
		
		JLabel lblFnameName = new JLabel("Fname Name:");
		lblFnameName.setBounds(36, 118, 64, 17);
		contentPane.add(lblFnameName);
		
		JLabel lblLastNamre = new JLabel("Last Namre :");
		lblLastNamre.setBounds(36, 184, 64, 17);
		contentPane.add(lblLastNamre);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(36, 253, 64, 17);
		contentPane.add(lblAge);
		
		JButton btnNewButton = new JButton("NEnter Data");
		Object[] row = new Object[4];
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 model = (DefaultTableModel)table.getModel();
				row[0] = t_ID.getText();
				row[1] = F_name.getText();
				row[2] = L_name.getText();
				row[3] = Integer.parseInt(Age.getText());
				model.addRow(row);
			}
		});
		btnNewButton.setBounds(90, 294, 131, 52);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 49, 829, 522);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowsCount = table.getRowCount();
				
				System.out.println( rowsCount);
				int i = table.getSelectedRow();
				t_ID.setText(model.getValueAt(i, 0).toString());
				F_name.setText(model.getValueAt(i, 1).toString());
				L_name.setText(model.getValueAt(i, 2).toString());
				Age.setText(model.getValueAt(i, 3).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "F.name", "L.Name", "AGE"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton BTN_DELETE = new JButton("DELETE ");
		BTN_DELETE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					model.removeRow(i);
					
				}else {
					System.out.println("Delete Error");
				}
		
				
				
			}
		});
		BTN_DELETE.setBounds(90, 377, 131, 48);
		contentPane.add(BTN_DELETE);
		
		JButton btn_Update = new JButton("Update");
		btn_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					model.setValueAt(t_ID.getText(), i, 0);
					model.setValueAt(F_name.getText(), i, 1);
					model.setValueAt(L_name.getText(), i, 2);
					model.setValueAt(Age.getText(), i, 3);
				}
			}
		});
		btn_Update.setBounds(84, 465, 137, 52);
		contentPane.add(btn_Update);
	}
}
