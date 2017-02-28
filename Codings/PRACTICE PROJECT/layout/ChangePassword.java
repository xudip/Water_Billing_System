package layout;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import actionAndEvents.ChangePasswordActionAndEvents;
import actionAndEvents.UpdatePasswordActionAndEvents;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ChangePassword {

	protected static JFrame frame;
	protected static JPasswordField txtNewPassword;
	protected static JPasswordField txtReTypeNewPassword;
	protected static JLabel lblTick;
	protected static JLabel lblCross;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword window = new ChangePassword();
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
	public ChangePassword() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("WATER BILLING MANAGEMENT SYSTEM");
		frame.setResizable(false);
		frame.setResizable(false);
		frame.setBounds(600, 200, 335, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 153));
		panel.setForeground(new Color(51, 153, 204));
		panel.setBounds(0, 0, 329, 377);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblWaterBillingManagement = new JLabel("Water Billing Management System");
		lblWaterBillingManagement.setBounds(10, 11, 298, 20);
		lblWaterBillingManagement.setBackground(new Color(0, 51, 102));
		lblWaterBillingManagement.setForeground(new Color(204, 0, 51));
		lblWaterBillingManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblWaterBillingManagement.setVerticalAlignment(SwingConstants.TOP);
		lblWaterBillingManagement.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel.add(lblWaterBillingManagement);

		JLabel lblAddress = new JLabel("Address: Kathmandu, Nepal");
		lblAddress.setBounds(77, 42, 162, 14);
		lblAddress.setForeground(new Color(0, 51, 153));
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAddress);

		JLabel lblContact = new JLabel("Contact: 014444444");
		lblContact.setBounds(101, 67, 113, 16);
		lblContact.setForeground(new Color(0, 51, 153));
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblContact);

		/*
		final JLabel lblSignUp = new JLabel("Don't have an account yet? Sign Up Now!");
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSignUp.setForeground(Color.BLUE);


			}
			public void mouseExited(MouseEvent e) {
				lblSignUp.setForeground(new Color(0, 51, 153));

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				SignUp su = new SignUp();

			}
		});
		lblSignUp.setForeground(new Color(0, 51, 153));
		lblSignUp.setBounds(10, 313, 229, 16);
		panel.add(lblSignUp);

		final JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogIn.setForeground(Color.BLUE);
			}
			public void mouseExited(MouseEvent e) {
				lblLogIn.setForeground(new Color(0, 51, 153));

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				LogInLayout fp = new LogInLayout();
			}
		});
		lblLogIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblLogIn.setForeground(new Color(0, 51, 153));
		lblLogIn.setBounds(10, 341, 100, 14);

		panel.add(lblLogIn);
		 */

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(77, 229, 89, 23);
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtNewPassword != null) && (lblTick.isVisible())){
					
					ChangePasswordActionAndEvents.checkError();

					ChangePasswordActionAndEvents.changePassword();
				}
				else
					JOptionPane.showMessageDialog(null,"Enter Valid Passwords.");

			}
		});
		panel.add(btnSubmit);

		txtNewPassword = new JPasswordField();
		txtNewPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				ChangePasswordActionAndEvents.checkError();
			}
		});
		txtNewPassword.setBounds(162, 131, 86, 20);
		txtNewPassword.setEchoChar('*');
		panel.add(txtNewPassword);
		txtNewPassword.setColumns(10);

		txtReTypeNewPassword = new JPasswordField();
		txtReTypeNewPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				ChangePasswordActionAndEvents.checkError();


			}
		});
		txtReTypeNewPassword.setBounds(163, 165, 86, 20);
		txtReTypeNewPassword.setEchoChar('*');
		panel.add(txtReTypeNewPassword);
		txtReTypeNewPassword.setColumns(10);

		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(58, 133, 86, 16);
		panel.add(lblNewPassword);

		JLabel lblReTypeNew = new JLabel("Re Type New Password");
		lblReTypeNew.setBounds(10, 167, 134, 16);
		panel.add(lblReTypeNew);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(203, 229, 89, 23);
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePasswordActionAndEvents.clearData();
			}
		});
		panel.add(btnClear);

		lblTick = new JLabel("Tick");
		lblTick.setIcon(new ImageIcon(ChangePassword.class.getResource("/images/tick.png")));
		lblTick.setBounds(277, 168, 15, 15);
		lblTick.setVisible(false);

		panel.add(lblTick);

		lblCross = new JLabel("Cross");
		lblCross.setIcon(new ImageIcon(ChangePassword.class.getResource("/images/cross.png")));
		lblCross.setBounds(259, 168, 15, 15);
		lblCross.setVisible(false);
		panel.add(lblCross);
		
		JLabel lblDevelopedByXudip = new JLabel("Developed By: SUDARSHAN ASHIM PHURPA");
		lblDevelopedByXudip.setBounds(12, 352, 296, 14);
		lblDevelopedByXudip.setForeground(new Color(0, 51, 153));
		lblDevelopedByXudip.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblDevelopedByXudip.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblDevelopedByXudip);
	}
}
