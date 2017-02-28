package layout;

import includes.UserInformation;
import includes.setGetGlobalVariables;

import java.awt.Color;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JLabel;

public class Settings {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					Settings window = new Settings();
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
	public Settings() {
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
		frame.setTitle("WATER BILLING MANAGEMENT SYSTEM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelSettings = new JPanel();
		panelSettings.setLayout(null);
		panelSettings.setBorder(new TitledBorder(null, "SETTINGS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSettings.setBackground(new Color(204, 255, 153));
		panelSettings.setForeground(new Color(51, 153, 204));
		panelSettings.setBounds(10, 11, 755, 509);
		frame.getContentPane().add(panelSettings);
		
		JButton btnEditProfileInformation = new JButton("");
		btnEditProfileInformation.setIcon(new ImageIcon(Settings.class.getResource("/images/updateUser.png")));
		btnEditProfileInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditProfile edit = new EditProfile();
				frame.dispose();
			}
		});
		btnEditProfileInformation.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEditProfileInformation.setBounds(179, 208, 150, 150);
		panelSettings.add(btnEditProfileInformation);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setIcon(new ImageIcon(Settings.class.getResource("/images/update.jpg")));
		btnChangePassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				UpdatePassword changepassword = new UpdatePassword();
			}
		});
		btnChangePassword.setFont(new Font("Dialog", Font.BOLD, 16));
		btnChangePassword.setBounds(376, 208, 150, 150);
		panelSettings.add(btnChangePassword);
		
		JLabel lblEditProfileInformation = new JLabel("View Profile And Update");
		lblEditProfileInformation.setForeground(new Color(0, 51, 255));
		lblEditProfileInformation.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEditProfileInformation.setBounds(173, 192, 198, 19);
		panelSettings.add(lblEditProfileInformation);
		
		JLabel lblChangePassword = new JLabel("CHANGE PASSWORD");
		lblChangePassword.setForeground(new Color(0, 51, 255));
		lblChangePassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblChangePassword.setBounds(379, 192, 157, 19);
		panelSettings.add(lblChangePassword);
		
		JPanel panelUserInformation = new JPanel();
		panelUserInformation.setLayout(null);
		panelUserInformation.setBackground(new Color(204, 255, 153));
		panelUserInformation.setBounds(509, 12, 234, 94);
		panelSettings.add(panelUserInformation);
		
		JButton btnLogOut = new JButton("Log Out");
		UserInformation.getBtnLogOut(btnLogOut, frame);
		panelUserInformation.add(btnLogOut);
		
		JButton btnHome = new JButton("Home");
		UserInformation.getBtnHome(btnHome, frame);
		panelUserInformation.add(btnHome);
		
		JLabel lblUsername = new JLabel("Username");
		UserInformation.getlblUsername(lblUsername);
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
	}
}
