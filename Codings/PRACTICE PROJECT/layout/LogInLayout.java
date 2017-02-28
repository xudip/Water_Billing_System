package layout;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Cursor;

import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import actionAndEvents.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInLayout {

	private JFrame frmLogIn;
	public static JTextField txtUsername;
	protected static JPasswordField txtPassword;
	private JCheckBox chkbxRememberMe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInLayout window = new LogInLayout();
					window.frmLogIn.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogInLayout() {
		initialize();	
		LogInActionAndEvents.getRememberMeUsername();
		frmLogIn.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogIn = new JFrame();
		frmLogIn.setForeground(new Color(0, 0, 0));
		frmLogIn.setVisible(true);
		frmLogIn.setTitle("Log In ");
		frmLogIn.setResizable(false);
		frmLogIn.setBounds(600, 200, 335, 406);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelLogIn = new JPanel();
		panelLogIn.setBackground(new Color(204, 255, 153));
		panelLogIn.setForeground(new Color(51, 153, 204));
		frmLogIn.getContentPane().add(panelLogIn, BorderLayout.CENTER);

		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String username = txtUsername.getText().trim();
				String password = txtPassword.getText();

				//use of different class
				// import actionAndEvents.*;
				// String errorVariable = LogInActionAndEvents.checkError(username,password);
				
				if( LogInActionAndEvents.checkUsername(username)== false && LogInActionAndEvents.checkPassword(password) == false){
					String privilege =LogInActionAndEvents.logInAuthentication(username,password);
					if(privilege !="" && chkbxRememberMe.isSelected()){
						LogInActionAndEvents.setRememberMe();
					}
					else{
						LogInActionAndEvents.removeRemeberMe();
					}
					

					if(privilege.equals("ADMIN")){
						frmLogIn.dispose();
						AdminHome ah = new AdminHome();
					}
					else if(privilege.equals("CUSTOMER")){
//						JOptionPane.showMessageDialog(null,"CUSTOMER");
						frmLogIn.dispose();
						CustomerHome ch = new CustomerHome();
					}
					else if(privilege.equals("METERREADER")){
						frmLogIn.dispose();
						MeterReaderHome mh = new MeterReaderHome();
					}
				}
			}
		});

		btnLogIn.setFont(new Font("Baskerville Old Face", Font.BOLD, 14));
		btnLogIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogIn.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 51, 204), new Color(255, 255, 255)));
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setBackground(new Color(153, 0, 51));
		btnLogIn.setBounds(118, 248, 75, 30);

		panelLogIn.setLayout(null);

		JButton btnEyeIcon = new JButton("");
		btnEyeIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Code to show the text in password field
				txtPassword.setEchoChar((char)0);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				txtPassword.setEchoChar('*');
			}
		});

		btnEyeIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEyeIcon.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), new Color(192, 192, 192), new Color(128, 128, 128), new Color(192, 192, 192)));

		ImageIcon eyeIcon = new ImageIcon("Y:\\XUDIP\\BIT 6TH\\PRACTICE PROJECT\\images\\eyeicon.png");
		eyeIcon.getIconHeight();
		eyeIcon.getIconWidth();
		btnEyeIcon.setIcon(new ImageIcon(LogInLayout.class.getResource("/images/eye.png")));
		btnEyeIcon.setBounds(284, 189, 33, 33);
		panelLogIn.add(btnEyeIcon);
		panelLogIn.add(btnLogIn);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("DialogInput", Font.BOLD, 14));
		txtUsername.setCaretColor(new Color(255, 0, 0));
		txtUsername.setBackground(new Color(255, 255, 255));
		txtUsername.setBorder(new BevelBorder(BevelBorder.LOWERED, null, new Color(192, 192, 192), null, new Color(192, 192, 192)));
		txtUsername.setBounds(10, 125, 309, 36);
		panelLogIn.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("DialogInput", Font.BOLD, 14));
		txtPassword.setCaretColor(new Color(255, 0, 0));
		txtPassword.setBackground(new Color(255, 255, 255));
		txtPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, new Color(192, 192, 192), null, new Color(192, 192, 192)));
		txtPassword.setEchoChar('*');
		txtPassword.setBounds(10, 189, 275, 33);
		panelLogIn.add(txtPassword);
		txtPassword.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(0, 51, 153));
		lblUsername.setBounds(10, 98, 75, 20);
		panelLogIn.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 51, 153));
		lblPassword.setBounds(10, 172, 75, 20);
		panelLogIn.add(lblPassword);

		final JLabel lblForgotPassword = new JLabel("Forgot Password");
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblForgotPassword.setForeground(Color.BLUE);
			}
			public void mouseExited(MouseEvent e) {
				lblForgotPassword.setForeground(new Color(0, 51, 153));

			}
			@Override
			public void mouseClicked(MouseEvent e) {

				frmLogIn.dispose();
				ForgotPassword fp = new ForgotPassword();
			}
		});
		lblForgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblForgotPassword.setForeground(new Color(0, 51, 153));
		lblForgotPassword.setBounds(10, 317, 100, 14);
		panelLogIn.add(lblForgotPassword);

		chkbxRememberMe = new JCheckBox("Remember Me");
		chkbxRememberMe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		chkbxRememberMe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chkbxRememberMe.setForeground(new Color(0, 51, 153));
		chkbxRememberMe.setBackground(new Color(204, 255, 153));
		chkbxRememberMe.setBounds(199, 229, 120, 23);
		panelLogIn.add(chkbxRememberMe);

		/*
		JLabel lblErrorUsername = new JLabel("Username Empty");
		lblErrorUsername.setForeground(Color.RED);
		lblErrorUsername.setBounds(93, 104, 100, 14);
		panelLogIn.add(lblErrorUsername);

		JLabel lblErrorPassword = new JLabel("Password Empty");
		lblErrorPassword.setForeground(Color.RED);
		lblErrorPassword.setBounds(97, 173, 100, 14);
		panelLogIn.add(lblErrorPassword);

		 */
		/*
		JLabel lblTime = new JLabel("Time:");
		lblTime.setForeground(new Color(0, 51, 153));
		lblTime.setBounds(199, 317, 46, 14);
		panelLogIn.add(lblTime);


		 Time time = new Time(System.currentTimeMillis());
		JLabel lblCurrentTime = new JLabel(time.toString());
		lblCurrentTime.setForeground(new Color(0, 51, 153));
		lblCurrentTime.setBounds(241, 317, 75, 14);
		panelLogIn.add(lblCurrentTime);
		 */
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(new Color(0, 51, 153));
		lblDate.setBounds(199, 326, 46, 14);
		panelLogIn.add(lblDate);


		Date date = new Date(System.currentTimeMillis());
		JLabel lblCurrentDate = new JLabel(date.toString());
		lblCurrentDate.setForeground(new Color(0, 51, 153));
		lblCurrentDate.setBounds(241, 326, 75, 14);
		panelLogIn.add(lblCurrentDate);

		JLabel lblWaterBillingManagement = new JLabel("WATER BILLING MANAGEMENT");
		lblWaterBillingManagement.setBackground(new Color(0, 51, 102));
		lblWaterBillingManagement.setBounds(10, 11, 298, 20);
		lblWaterBillingManagement.setForeground(new Color(204, 0, 51));
		lblWaterBillingManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblWaterBillingManagement.setVerticalAlignment(SwingConstants.TOP);
		lblWaterBillingManagement.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panelLogIn.add(lblWaterBillingManagement);

		JLabel lblAddress = new JLabel("Address: Kathmandu, Nepal");
		lblAddress.setForeground(new Color(0, 51, 153));
		lblAddress.setBounds(77, 42, 162, 14);
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		panelLogIn.add(lblAddress);

		JLabel lblContact = new JLabel("Contact: 014444444");
		lblContact.setForeground(new Color(0, 51, 153));
		lblContact.setBounds(97, 67, 120, 14);
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		panelLogIn.add(lblContact);

		JLabel lblDevelopedByXudip = new JLabel("Developed By: SUDARSHAN ASHIM PHURPA");
		lblDevelopedByXudip.setBounds(10, 352, 306, 14);
		lblDevelopedByXudip.setForeground(new Color(0, 51, 153));
		lblDevelopedByXudip.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblDevelopedByXudip.setHorizontalAlignment(SwingConstants.CENTER);
		panelLogIn.add(lblDevelopedByXudip);
	}
}
