package layout;

import includes.UserInformation;
import includes.setGetGlobalVariables;

import java.awt.Color;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import actionAndEvents.ViewCustomerActionAndEvents;
import actionAndEvents.ViewMeterreaderActionAndEvents;

import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMeterreader {

	private JFrame frame;
	private JTable table;
	int id;
	public static JTextField txtName;
	public static JTextField txtAddress;
	public static JTextField txtContact;
	public static JTextField txtDob;
	public static JTextField txtEmail;
	public static JTextField txtUsername;
	public static JTextField txtPrivilege;
	int statusAdvancedSearch = 0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMeterreader window = new ViewMeterreader();
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
	public ViewMeterreader() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds( 385, 100, 800, 595);
		frame.setTitle("WATER BILLING MANAGEMENT SYSTEM");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelManageMeterreader = new JPanel();
		panelManageMeterreader.setBorder(new TitledBorder(null, "Manage Users", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelManageMeterreader.setBounds(0, 0, 784, 556);
		panelManageMeterreader.setBackground(new Color(204, 255, 153));
		panelManageMeterreader.setForeground(new Color(51, 153, 204));

		frame.getContentPane().add(panelManageMeterreader);
		panelManageMeterreader.setLayout(null);

		JPanel panelUserInformation = new JPanel();
		panelUserInformation.setBounds(529, 23, 234, 77);
		panelUserInformation.setLayout(null);
		panelUserInformation.setBackground(new Color(204, 255, 153));
		panelManageMeterreader.add(panelUserInformation);

		JButton btnLogOut = new JButton("Log Out");
		UserInformation.getBtnLogOut(btnLogOut, frame);
		panelUserInformation.add(btnLogOut);

		JButton btnHome = new JButton("Home");
		UserInformation.getBtnHome(btnHome, frame);
		panelUserInformation.add(btnHome);

		JLabel lblUsername = new JLabel("Username");
		UserInformation.getlblUsername(lblUsername);
		panelUserInformation.add(lblUsername);

		JLabel lblImagePreview = new JLabel("Image Preview");
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



		//		final Object [][]data = new Object[100][100];
		//		Object []header = {"id" , "First Name", "Middle Name", "Last Name", "Gender", "Dob", "Contact", "District", "Municipality", "Ward NO.", "email"};
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 764, 245);
		panelManageMeterreader.add(scrollPane);

		table = new JTable();
		final ResultSet rs = ViewMeterreaderActionAndEvents.getData();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		table.setBackground(new Color(204, 255, 153));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int column = 0;
				id = (Integer) table.getValueAt(row, column);
				ViewMeterreaderActionAndEvents.setId(id);
				//JOptionPane.showMessageDialog(null, id);
				//txtId.setText(""+id);
			}
		});
		scrollPane.setViewportView(table);

		JButton btnView = new JButton("View");
		btnView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewMeterreaderActionAndEvents.view(ViewMeterreaderActionAndEvents.getId());
				table.repaint();
				table.setFocusable(false);
				table.setRowSelectionAllowed(true);
			}
		});
		btnView.setBounds(668, 368, 89, 23);
		panelManageMeterreader.add(btnView);

		final JButton btnDelete = new JButton("Delete");
		btnDelete.setVisible(false);
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = ViewMeterreaderActionAndEvents.getId();
				JOptionPane.showMessageDialog(null, "READY TO DELETE! id = " + id);
				ViewMeterreaderActionAndEvents.delete(id);
				ResultSet rs = ViewMeterreaderActionAndEvents.getData();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				table.repaint();
				table.clearSelection();
			}
		});
		btnDelete.setBounds(367, 368, 89, 23);
		panelManageMeterreader.add(btnDelete);

		final JButton btnSave = new JButton("Save");
		btnSave.setVisible(false);
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Ready to Save?");
				int row =0;
				int column = 0;
				Object[] data = new Object[13];
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
					ViewMeterreaderActionAndEvents.save(data);

				}

				btnSave.setVisible(false);
				btnDelete.setVisible(false);
				ResultSet rs = ViewMeterreaderActionAndEvents.getData();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				table.repaint();
				table.setBackground((new Color(204, 255, 153)));

			}
		});
		btnSave.setBounds(268, 368, 89, 23);
		panelManageMeterreader.add(btnSave);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDelete.setVisible(true);
				btnSave.setVisible(true);
				table.setBackground(Color.WHITE);
				table.setEnabled(true);
				table.setFocusable(true);
				table.setRowSelectionAllowed(true);
			}
		});
		btnEdit.setBounds(466, 368, 89, 23);
		panelManageMeterreader.add(btnEdit);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.clearSelection();
				table.editingCanceled(null);
				ResultSet rs = ViewMeterreaderActionAndEvents.getData();
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
		btnCancel.setBounds(569, 368, 89, 23);
		panelManageMeterreader.add(btnCancel);		

		final JPanel panelAdvancedSearch = new JPanel();
		panelAdvancedSearch.setBorder(new TitledBorder(null, "Advanced Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAdvancedSearch.setBounds(10, 437, 764, 108);
		panelAdvancedSearch.setVisible(false);
		panelManageMeterreader.add(panelAdvancedSearch);
		panelAdvancedSearch.setLayout(null);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(12, 25, 55, 16);
		panelAdvancedSearch.add(lblName);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(217, 25, 55, 16);
		panelAdvancedSearch.add(lblAddress);

		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(85, 23, 114, 20);
		panelAdvancedSearch.add(txtName);
		txtName.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setText("Address");
		txtAddress.setBounds(290, 23, 114, 20);
		panelAdvancedSearch.add(txtAddress);
		txtAddress.setColumns(10);

		JLabel lblContact = new JLabel("Contact:");
		lblContact.setBounds(422, 25, 55, 16);
		panelAdvancedSearch.add(lblContact);

		txtContact = new JTextField();
		txtContact.setText("Contact");
		txtContact.setBounds(495, 23, 114, 20);
		panelAdvancedSearch.add(txtContact);
		txtContact.setColumns(10);

		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(12, 55, 55, 16);
		panelAdvancedSearch.add(lblDob);

		txtDob = new JTextField();
		txtDob.setText("DOb");
		txtDob.setBounds(85, 53, 114, 20);
		panelAdvancedSearch.add(txtDob);
		txtDob.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(217, 55, 55, 16);
		panelAdvancedSearch.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setBounds(290, 53, 114, 20);
		panelAdvancedSearch.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setBounds(12, 80, 76, 16);
		panelAdvancedSearch.add(lblUsername_1);

		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(106, 78, 114, 20);
		panelAdvancedSearch.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblPrivilege = new JLabel("Privilege");
		lblPrivilege.setBounds(249, 80, 55, 16);
		panelAdvancedSearch.add(lblPrivilege);

		txtPrivilege = new JTextField();
		txtPrivilege.setText("Privilege");
		txtPrivilege.setBounds(322, 75, 114, 20);
		panelAdvancedSearch.add(txtPrivilege);
		txtPrivilege.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = ViewMeterreaderActionAndEvents.advancedSearch();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				table.repaint();
			}
		});
		btnSearch.setBounds(576, 75, 98, 26);
		panelAdvancedSearch.add(btnSearch);

		JButton btnAdvancedSearch = new JButton("Advanced Search");
		btnAdvancedSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnAdvancedSearch.setBounds(10, 399, 139, 26);
		panelManageMeterreader.add(btnAdvancedSearch);

	}
	
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
