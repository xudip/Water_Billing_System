package layout;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JScrollPane;

import actionAndEvents.ViewBillActionAndEvents;
import actionAndEvents.ViewCustomerActionAndEvents;
import includes.*;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.io.File;
import java.sql.ResultSet;
public class ViewCustomer {

	private JFrame frame;
	//private JTable table;
	private JScrollPane scrollPaneViewUsers;
	private Object tblPassword;
	private JPanel panelUserInformation;
	private JButton btnLogOut;
	private JButton btnHome;
	private JLabel lblUsername;
	private JButton btnViewBill;
	protected static JComboBox comboBoxMonth;
	protected static JComboBox comboBoxYear;
	protected static JTable table;

	int id;
	private JTextField txtId;
	private JButton btnAdvancedSearch;
	public static JTextField txtName;
	private static JTextField txtAddress;
	private static JTextField txtDob;
	private static JTextField txtEmail;
	private static JTextField txtContact;
	private static JTextField txtUsername;
	private static JTextField txtPrivilege;
	private JButton btnSearch;
	
	int statusAdvancedSearch = 0;
	private JLabel lblImagePreview;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCustomer window = new ViewCustomer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewCustomer() {
		initialize();	
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 255, 153));
		frame.setBounds( 385, 100, 800, 595);
		frame.setResizable(false);
		frame.setTitle("WATER BILLING MANAGEMENT SYSTEM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		scrollPaneViewUsers = new JScrollPane();
		scrollPaneViewUsers.setBounds(10, 106, 764, 276);
		scrollPaneViewUsers.setAutoscrolls(true);
		scrollPaneViewUsers.setBorder(new TitledBorder(null, "VIEW USER", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPaneViewUsers.setBackground(new Color(204, 255, 153));
		scrollPaneViewUsers.setForeground(new Color(51, 153, 204));
		frame.getContentPane().add(scrollPaneViewUsers);

		
//		Object []header = {"id" , "First Name", "Middle Name", "Last Name", "Gender", "Dob", "Contact", "District", "Municipality", "Ward NO.", "email"};
		final ViewCustomerActionAndEvents setData = new ViewCustomerActionAndEvents();
		table = new JTable();
		final ResultSet rs = setData.getData();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		table.setBackground(new Color(204, 255, 153));
		//table.setEnabled(false);
		table.setFocusable(false);
		table.setRowSelectionAllowed(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.isEnabled())
				{
					int row = table.getSelectedRow();
					int column = 0;
					id = (Integer) table.getValueAt(row, column);
					ViewCustomerActionAndEvents.setId(id);
					txtId.setText(""+id);
				}
			}
		});
		scrollPaneViewUsers.setViewportView(table);
		table.setForeground(SystemColor.textHighlight);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE));

		panelUserInformation = new JPanel();
		panelUserInformation.setBounds(540, 11, 234, 77);
		panelUserInformation.setLayout(null);
		panelUserInformation.setBackground(new Color(204, 255, 153));
		frame.getContentPane().add(panelUserInformation);

		btnLogOut = new JButton("Log Out");
		UserInformation.getBtnLogOut(btnLogOut, frame);
		panelUserInformation.add(btnLogOut);

		btnHome = new JButton("Home");
		UserInformation.getBtnHome(btnHome, frame);
		panelUserInformation.add(btnHome);

		lblUsername = new JLabel("Username");
		UserInformation.getlblUsername(lblUsername);
		panelUserInformation.add(lblUsername);
		
		lblImagePreview = new JLabel("");

		lblImagePreview.setBounds(37, 0, 50, 41);
		BufferedImage image = null;
		try{
			image = ImageIO.read(new File("userphoto\\" + setGetGlobalVariables.fileName));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		ImageIcon imageIcon = new ImageIcon(setGetGlobalVariables.fitimage(image, lblImagePreview.getWidth(), lblImagePreview.getHeight()));
		lblImagePreview.setIcon(imageIcon);
		panelUserInformation.add(lblImagePreview);

		final JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(285, 393, 89, 23);
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = ViewCustomerActionAndEvents.getId();
				//JOptionPane.showMessageDialog(null, "READY TO DELETE! id = " + id);
				ViewCustomerActionAndEvents.delete(id);
//				ViewCustomerActionAndEvents setData = new ViewCustomerActionAndEvents();
				ViewCustomerActionAndEvents getData = new ViewCustomerActionAndEvents();
				ResultSet rs = getData.getData();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				table.repaint();
//				table.clearSelection();
			}
		});
		btnDelete.setVisible(false);
		frame.getContentPane().add(btnDelete);
		final JButton btnSave = new JButton("Save");
		final JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(404, 393, 89, 23);
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDelete.setVisible(true);
				btnSave.setVisible(true);
				btnEdit.setVisible(false);
				table.setBackground(Color.WHITE);
				table.setEnabled(true);
				table.setFocusable(true);
				table.setRowSelectionAllowed(true);

			}
		});
		frame.getContentPane().add(btnEdit);

		
		 
		btnSave.setBounds(167, 393, 89, 23);
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Ready to Save!");
				int row =0;
				int column = 0;
				Object[] data = new Object[12];
				for(row=0;row<table.getRowCount();row++){
					
					data[0] = (Integer) table.getValueAt(row, 0);
					data[1]= table.getValueAt(row, 1);
					data[2] = table.getValueAt(row, 2);
					data[3] = table.getValueAt(row, 3);
					data[4] = table.getValueAt(row, 4);
					data[5] = table.getValueAt(row, 5);
					data[6] = table.getValueAt(row, 6);
					data[7] = table.getValueAt(row, 7);
					data[8] = table.getValueAt(row, 8);
					data[9] = table.getValueAt(row, 9);
					data[10] = table.getValueAt(row, 10);
					data[11] = table.getValueAt(row,11);
					ViewCustomerActionAndEvents.save(data);
				}
				//id = (Integer) table.getValueAt(row, column);
				//JOptionPane.showMessageDialog(null, "row: " + row + "\nColumn: " + column);
				
				table.repaint();
				btnSave.setVisible(false);
				btnDelete.setVisible(false);
				btnEdit.setVisible(true);
				table.setBackground((new Color(204, 255, 153)));

			}
		});
		btnSave.setVisible(false);
		frame.getContentPane().add(btnSave);

		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(522, 393, 89, 23);
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.clearSelection();
				table.editingCanceled(null);
				btnEdit.setVisible(true);
				ResultSet rs = setData.getData();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				table.repaint();
				table.setBackground((new Color(204, 255, 153)));
				btnDelete.setVisible(false);
				btnSave.setVisible(false);
				table.setFocusable(false);
				table.setRowSelectionAllowed(true);
				JOptionPane.showMessageDialog(null, "Cancelled");
			}
		});
		frame.getContentPane().add(btnCancel);

		JButton btnView = new JButton("View");
		btnView.setBounds(643, 393, 89, 23);
		btnView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewCustomerActionAndEvents.view(ViewCustomerActionAndEvents.getId());
				ViewCustomerActionAndEvents setData = new ViewCustomerActionAndEvents();
				table.repaint();
				table.setFocusable(false);
				table.setRowSelectionAllowed(true);
			}
		});
		frame.getContentPane().add(btnView);

		btnViewBill = new JButton("View Bill");
		btnViewBill.setBounds(406, 65, 99, 36);

		btnViewBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewBill vb = new ViewBill();
				vb.frame.setVisible(false);
				id = Integer.parseInt( txtId.getText());
				String month = String.valueOf(comboBoxMonth.getSelectedItem());
				int year = Integer.valueOf( (String) comboBoxYear.getSelectedItem());
				//JOptionPane.showMessageDialog(null, "id: " + id + "\nMonth: " + month + "\nYear: " + year );
				if(ViewBillActionAndEvents.getBill(id, month, year) == true){
					vb.frame.setVisible(true);
					frame.dispose();
				}
				else{
					vb.frame.dispose();
				}
			}
		});
		frame.getContentPane().add(btnViewBill);

		txtId = new JTextField();
		txtId.setBounds(118, 76, 86, 20);
		txtId.setText("id");
		txtId.setColumns(10);
		frame.getContentPane().add(txtId);

		comboBoxMonth = new JComboBox();
		comboBoxMonth.setBounds(214, 76, 89, 20);
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"}));
		frame.getContentPane().add(comboBoxMonth);

		comboBoxYear = new JComboBox();
		comboBoxYear.setBounds(313, 76, 89, 20);
		comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"2015", "2016"}));
		frame.getContentPane().add(comboBoxYear);

		final JPanel panelAdvancedSearch = new JPanel();
		panelAdvancedSearch.setBorder(new TitledBorder(null, "Advanced Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAdvancedSearch.setBounds(10, 437, 764, 108);
		panelAdvancedSearch.setLayout(null);
		panelAdvancedSearch.setVisible(false);
		frame.getContentPane().add(panelAdvancedSearch);


		txtName = new JTextField();
		txtName.setBounds(55, 17, 86, 20);
		panelAdvancedSearch.add(txtName);
		txtName.setColumns(10);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 20, 46, 14);
		panelAdvancedSearch.add(lblName);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(151, 20, 46, 14);
		panelAdvancedSearch.add(lblAddress);

		setTxtAddress(new JTextField());
		getTxtAddress().setText("");
		getTxtAddress().setBounds(207, 17, 86, 20);
		panelAdvancedSearch.add(getTxtAddress());
		getTxtAddress().setColumns(10);

		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(10, 48, 46, 14);
		panelAdvancedSearch.add(lblDob);

		setTxtDob(new JTextField());
		getTxtDob().setText("");
		getTxtDob().setBounds(55, 45, 86, 20);
		panelAdvancedSearch.add(getTxtDob());
		getTxtDob().setColumns(10);

		JLabel lblEmail = new JLabel("email:");
		lblEmail.setBounds(151, 48, 46, 14);
		panelAdvancedSearch.add(lblEmail);

		setTxtEmail(new JTextField());
		getTxtEmail().setText("");
		getTxtEmail().setBounds(207, 45, 86, 20);
		panelAdvancedSearch.add(getTxtEmail());
		getTxtEmail().setColumns(10);

		JLabel lblContact = new JLabel("Contact:");
		lblContact.setBounds(303, 20, 46, 14);
		panelAdvancedSearch.add(lblContact);

		setTxtContact(new JTextField());
		getTxtContact().setText("");
		getTxtContact().setBounds(351, 17, 86, 20);
		panelAdvancedSearch.add(getTxtContact());
		getTxtContact().setColumns(10);

		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setBounds(10, 79, 52, 14);
		panelAdvancedSearch.add(lblUsername_1);

		setTxtUsername(new JTextField());
		getTxtUsername().setText("");
		getTxtUsername().setBounds(72, 77, 86, 20);
		panelAdvancedSearch.add(getTxtUsername());
		getTxtUsername().setColumns(10);

		JLabel lblPrivilege = new JLabel("Privilege:");
		lblPrivilege.setBounds(168, 83, 46, 14);
		panelAdvancedSearch.add(lblPrivilege);

		setTxtPrivilege(new JTextField());
		getTxtPrivilege().setText("");
		getTxtPrivilege().setBounds(224, 77, 86, 20);
		panelAdvancedSearch.add(getTxtPrivilege());
		getTxtPrivilege().setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultSet rs = ViewCustomerActionAndEvents.advancedSearch();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				table.repaint();
			}
		});
		btnSearch.setBounds(566, 75, 89, 23);
		panelAdvancedSearch.add(btnSearch);

		btnAdvancedSearch = new JButton("Advanced Search");
		

		btnAdvancedSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(statusAdvancedSearch ==0){
					panelAdvancedSearch.setVisible(true);
					statusAdvancedSearch = 1;
//					JOptionPane.showMessageDialog(null, "hidden");
				}
				else{
					statusAdvancedSearch=0;
					panelAdvancedSearch.setVisible(false);

//					JOptionPane.showMessageDialog(null, "Not hidden");
				}
				
			}

		});
		btnAdvancedSearch.setBounds(10, 403, 147, 23);
		frame.getContentPane().add(btnAdvancedSearch);

	}

	/**
	 * @return the txtContact
	 */
	public static JTextField getTxtContact() {
		return txtContact;
	}

	/**
	 * @param txtContact the txtContact to set
	 */
	public void setTxtContact(JTextField txtContact) {
		this.txtContact = txtContact;
	}

	/**
	 * @return the txtAddress
	 */
	public static JTextField getTxtAddress() {
		return txtAddress;
	}

	/**
	 * @param txtAddress the txtAddress to set
	 */
	public void setTxtAddress(JTextField txtAddress) {
		this.txtAddress = txtAddress;
	}

	/**
	 * @return the txtDob
	 */
	public static JTextField getTxtDob() {
		return txtDob;
	}

	/**
	 * @param txtDob the txtDob to set
	 */
	public void setTxtDob(JTextField txtDob) {
		this.txtDob = txtDob;
	}

	/**
	 * @return the txtEmail
	 */
	public static JTextField getTxtEmail() {
		return txtEmail;
	}

	/**
	 * @param txtEmail the txtEmail to set
	 */
	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	/**
	 * @return the txtUsername
	 */
	public static JTextField getTxtUsername() {
		return txtUsername;
	}

	/**
	 * @param txtUsername the txtUsername to set
	 */
	public void setTxtUsername(JTextField txtUsername) {
		this.txtUsername = txtUsername;
	}

	/**
	 * @return the txtPrivilege
	 */
	public static JTextField getTxtPrivilege() {
		return txtPrivilege;
	}

	/**
	 * @param txtPrivilege the txtPrivilege to set
	 */
	public void setTxtPrivilege(JTextField txtPrivilege) {
		this.txtPrivilege = txtPrivilege;
	}
}

