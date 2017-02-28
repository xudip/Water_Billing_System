package layout;

import includes.UserInformation;
import includes.setGetGlobalVariables;

import java.awt.Color;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

import java.awt.Cursor;
import java.io.File;

import javax.swing.ImageIcon;

public class ManageUsers {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageUsers window = new ManageUsers();
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
	public ManageUsers() {
		initialize();	
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds( 385, 100, 800, 595);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelManageUsers = new JPanel();
		panelManageUsers.setLayout(null);
		panelManageUsers.setBorder(new TitledBorder(null, "Manage Users", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelManageUsers.setBounds(10, 11, 762, 533);
		panelManageUsers.setBackground(new Color(204, 255, 153));
		panelManageUsers.setForeground(new Color(51, 153, 204));
		
		frame.getContentPane().add(panelManageUsers);
		
		JPanel panelUserInformation = new JPanel();
		panelUserInformation.setLayout(null);
		panelUserInformation.setBackground(new Color(204, 255, 153));
		panelUserInformation.setBounds(509, 18, 234, 96);
		panelManageUsers.add(panelUserInformation);
		
		JButton btnLogOut = new JButton("Log Out");
		UserInformation.getBtnLogOut(btnLogOut, frame);
		panelUserInformation.add(btnLogOut);
		
		JButton btnHome = new JButton("Home");
		UserInformation.getBtnHome(btnHome, frame);
		panelUserInformation.add(btnHome);
		
		JLabel lblUsername = new JLabel("Username");
		panelUserInformation.add(lblUsername);
		
		JLabel lblImagePreview = new JLabel("");lblImagePreview.setBounds(37, 0, 50, 41);
		BufferedImage image = null;
		try{
			image = ImageIO.read(new File("userphoto\\" + setGetGlobalVariables.fileName));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		ImageIcon imageIcon = new ImageIcon(setGetGlobalVariables.fitimage(image, lblImagePreview.getWidth(), lblImagePreview.getHeight()));
		lblImagePreview.setIcon(imageIcon);
		panelUserInformation.add(lblImagePreview);
		
		JButton btnManageMeterreader = new JButton("");
		btnManageMeterreader.setIcon(new ImageIcon(ManageUsers.class.getResource("/images/updateMeterReader.png")));
		btnManageMeterreader.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				ViewMeterreader vm = new ViewMeterreader();
			}
		});
		btnManageMeterreader.setFont(new Font("Dialog", Font.BOLD, 16));
		btnManageMeterreader.setBounds(412, 164, 150, 150);
		panelManageUsers.add(btnManageMeterreader);
		
		JButton btnManageCustomer = new JButton("");
		btnManageCustomer.setIcon(new ImageIcon(ManageUsers.class.getResource("/images/viewCustomer.png")));
		btnManageCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				ViewCustomer viewCustomer = new ViewCustomer();
			}
		});
		btnManageCustomer.setFont(new Font("Dialog", Font.BOLD, 16));
		btnManageCustomer.setBounds(237, 164, 150, 150);
		panelManageUsers.add(btnManageCustomer);
		
		JButton btnAddUser = new JButton("");
		btnAddUser.setIcon(new ImageIcon(ManageUsers.class.getResource("/images/addUser.png")));
		btnAddUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SignUp su = new SignUp();
				frame.dispose();
			}
		});
		btnAddUser.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAddUser.setBounds(62, 164, 150, 150);
		panelManageUsers.add(btnAddUser);
		
		JLabel lblAddUser = new JLabel("ADD USER");
		lblAddUser.setForeground(new Color(0, 51, 255));
		lblAddUser.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAddUser.setBounds(62, 146, 113, 19);
		panelManageUsers.add(lblAddUser);
		
		JLabel lblManageCustomer = new JLabel("MANAGE CUSTOMER");
		lblManageCustomer.setForeground(new Color(0, 51, 255));
		lblManageCustomer.setFont(new Font("Dialog", Font.BOLD, 14));
		lblManageCustomer.setBounds(230, 146, 145, 19);
		panelManageUsers.add(lblManageCustomer);
		
		JLabel lblManageMeterreader = new JLabel("MANAGE METERREADER");
		lblManageMeterreader.setForeground(new Color(0, 51, 255));
		lblManageMeterreader.setFont(new Font("Dialog", Font.BOLD, 14));
		lblManageMeterreader.setBounds(405, 148, 157, 19);
		panelManageUsers.add(lblManageMeterreader);
	}
}
