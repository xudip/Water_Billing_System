package layout;

import includes.UserInformation;
import includes.setGetGlobalVariables;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import layout.*;

import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

import java.awt.Cursor;

import javax.swing.border.LineBorder;

import actionAndEvents.InsertMeterReadingActionAndEvents;

import com.sun.javafx.scene.control.skin.CustomColorDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class AdminHome{

	private JFrame frame;
	private JPanel panel;
	
	private JComboBox comboBoxMonth;
	private JComboBox comboBoxYear;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome window = new AdminHome();
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
	public AdminHome() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(204, 255, 153));
		frame.setTitle("WATER BILLING MANAGEMENT SYSTEM");
		frame.setResizable(false);
		frame.setBounds( 385, 100, 800, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JPanel panelAdminHome = new JPanel();
		panelAdminHome.setBackground(new Color(204, 255, 153));
		panelAdminHome.setLayout(null);
		panelAdminHome.setBorder(new TitledBorder(null, "ADMIN HOME", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAdminHome.setForeground(new Color(51, 153, 204));
		panelAdminHome.setBounds(0, 0, 784, 544);
		frame.getContentPane().add(panelAdminHome);
		
		JButton btnViewBill = new JButton("");
		btnViewBill.setBorder(new LineBorder(null, 1, true));
		btnViewBill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnViewBill.setIcon(new ImageIcon(AdminHome.class.getResource("/images/Bills.png")));
		btnViewBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				ViewBill mu = new ViewBill();
			}
		});
		btnViewBill.setBackground(new Color(0, 191, 255));
		btnViewBill.setForeground(new Color(0, 0, 255));
		btnViewBill.setFont(new Font("Dialog", Font.BOLD, 16));
		btnViewBill.setBounds(592, 154, 150, 150);
		panelAdminHome.add(btnViewBill);
		
		JButton btnSettings = new JButton("");
		btnSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		btnSettings.setBorder(new LineBorder(null, 1, true));
		btnSettings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSettings.setIcon(new ImageIcon(AdminHome.class.getResource("/images/settings.png")));
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Settings s = new Settings();
			}
		});
		btnSettings.setBackground(new Color(0, 191, 255));
		btnSettings.setForeground(new Color(0, 0, 255));
		btnSettings.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSettings.setBounds(415, 364, 150, 150);
		panelAdminHome.add(btnSettings);
		
		JButton btnAboutUs = new JButton("");
		btnAboutUs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		btnAboutUs.setBorder(new LineBorder(null, 1, true));
		btnAboutUs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAboutUs.setIcon(new ImageIcon(AdminHome.class.getResource("/images/aboutus.png")));
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				AboutUs au = new AboutUs();
				//JOptionPane.showMessageDialog(null, "ABOUT US! ");
			}
		});
		btnAboutUs.setBackground(new Color(0, 191, 255));
		btnAboutUs.setForeground(new Color(0, 0, 255));
		btnAboutUs.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAboutUs.setBounds(230, 364, 150, 150);
		panelAdminHome.add(btnAboutUs);
		
		JButton btnFaqs = new JButton("");
		btnFaqs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		btnFaqs.setBorder(new LineBorder(null, 1, true));
		btnFaqs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFaqs.setIcon(new ImageIcon(AdminHome.class.getResource("/images/faqs.png")));
		btnFaqs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				FAQs f = new FAQs();
				//JOptionPane.showMessageDialog(null, "FAQs! ");
			}
		});
		btnFaqs.setBackground(new Color(0, 191, 255));
		btnFaqs.setForeground(new Color(0, 0, 255));
		btnFaqs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFaqs.setFont(new Font("Dialog", Font.BOLD, 16));
		btnFaqs.setBounds(55, 364, 150, 150);
		panelAdminHome.add(btnFaqs);
		
		final JPanel panelUserInformation = new JPanel();
		panelUserInformation.setBackground(new Color(204, 255, 153));
		panelUserInformation.setBounds(538, 12, 234, 94);
		panelAdminHome.add(panelUserInformation);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(12, 47, 89, 35);
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserInformation.logOut(frame);
			}
		});
		panelUserInformation.setLayout(null);
		panelUserInformation.add(btnLogOut);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(133, 47, 89, 35);
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserInformation.home(frame);
			}
		});
		panelUserInformation.add(btnHome);
		panelUserInformation.add(btnHome);
		
		JLabel lblUsername = new JLabel(setGetGlobalVariables.getUsername());
		lblUsername.setBounds(99, 19, 58, 16);
		panelUserInformation.add(lblUsername);
		
		JLabel lblImagePreview = new JLabel("");
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
		
		JLabel lblViewBills = new JLabel("View Bills");
		lblViewBills.setForeground(new Color(0, 51, 255));
		lblViewBills.setFont(new Font("Dialog", Font.BOLD, 14));
		lblViewBills.setBounds(585, 137, 157, 19);
		panelAdminHome.add(lblViewBills);
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setForeground(new Color(0, 51, 255));
		lblSettings.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSettings.setBounds(405, 347, 157, 19);
		panelAdminHome.add(lblSettings);
		
		JLabel lblFaq = new JLabel("Faq");
		lblFaq.setForeground(new Color(0, 51, 255));
		lblFaq.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFaq.setBounds(55, 344, 157, 19);
		panelAdminHome.add(lblFaq);
		
		JLabel lblAboutUs = new JLabel("About Us");
		lblAboutUs.setForeground(new Color(0, 51, 255));
		lblAboutUs.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAboutUs.setBounds(223, 346, 157, 19);
		panelAdminHome.add(lblAboutUs);
		
		JLabel lblManageMeterreader = new JLabel("Manage Meterreader");
		lblManageMeterreader.setForeground(new Color(0, 51, 255));
		lblManageMeterreader.setFont(new Font("Dialog", Font.BOLD, 14));
		lblManageMeterreader.setBounds(405, 137, 157, 19);
		panelAdminHome.add(lblManageMeterreader);
		
		JLabel lblManageCustomer = new JLabel("Manage Customer");
		lblManageCustomer.setForeground(new Color(0, 51, 255));
		lblManageCustomer.setFont(new Font("Dialog", Font.BOLD, 14));
		lblManageCustomer.setBounds(223, 136, 145, 19);
		panelAdminHome.add(lblManageCustomer);
		
		JLabel lblAddUser = new JLabel("Add Users");
		lblAddUser.setForeground(new Color(0, 51, 255));
		lblAddUser.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAddUser.setBounds(55, 136, 113, 19);
		panelAdminHome.add(lblAddUser);
		
		JButton btnAddUser = new JButton("");
		btnAddUser.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 frame.dispose();
				 SignUp ad = new SignUp();
				 
			}
		});
		btnAddUser.setIcon(new ImageIcon(AdminHome.class.getResource("/images/addUser.png")));
		btnAddUser.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAddUser.setBounds(55, 154, 150, 150);
		panelAdminHome.add(btnAddUser);
		
		JButton btnManageCustomer = new JButton("");
		btnManageCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ViewCustomer c = new ViewCustomer();
			}
		});
		btnManageCustomer.setIcon(new ImageIcon(AdminHome.class.getResource("/images/manageusers.png")));
		btnManageCustomer.setFont(new Font("Dialog", Font.BOLD, 16));
		btnManageCustomer.setBounds(230, 154, 150, 150);
		panelAdminHome.add(btnManageCustomer);
		
		JButton btnManageMeterreader = new JButton("");
		btnManageMeterreader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewMeterreader vm = new ViewMeterreader();
				frame.dispose();
			}
		});
		btnManageMeterreader.setIcon(new ImageIcon(AdminHome.class.getResource("/images/viewMeterReader.png")));
		btnManageMeterreader.setFont(new Font("Dialog", Font.BOLD, 16));
		btnManageMeterreader.setBounds(415, 154, 150, 150);
		panelAdminHome.add(btnManageMeterreader);
		
		JButton btnInsertMeterReadings = new JButton("");
		btnInsertMeterReadings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InsertMeterReading insert1  = new InsertMeterReading();
			}
		});
		btnInsertMeterReadings.setForeground(Color.BLUE);
		btnInsertMeterReadings.setFont(new Font("Dialog", Font.BOLD, 16));
		btnInsertMeterReadings.setBorder(new LineBorder(null, 1, true));
		btnInsertMeterReadings.setBackground(new Color(0, 191, 255));
		btnInsertMeterReadings.setBounds(599, 364, 150, 150);
		panelAdminHome.add(btnInsertMeterReadings);
		
		JLabel lblInsertMeterReadings = new JLabel("Insert Meter Readings");
		lblInsertMeterReadings.setForeground(new Color(0, 51, 255));
		lblInsertMeterReadings.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInsertMeterReadings.setBounds(592, 346, 157, 19);
		panelAdminHome.add(lblInsertMeterReadings);
	}
}
