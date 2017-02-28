package layout;

import includes.UserInformation;
import includes.setGetGlobalVariables;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.UIManager;

import com.sun.xml.internal.ws.api.pipe.Tube;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class CustomerHome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerHome window = new CustomerHome();
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
	public CustomerHome() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(385, 100, 800, 595);
		frame.setTitle("WATER BILLING MANAGEMENT SYSTEM");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelCustomerHome = new JPanel();
		panelCustomerHome.setForeground(new Color(51, 153, 204));
		panelCustomerHome.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "CUSTOMER HOME", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCustomerHome.setBackground(new Color(204, 255, 153));
		panelCustomerHome.setBounds(0, 0, 784, 544);
		frame.getContentPane().add(panelCustomerHome);
		panelCustomerHome.setLayout(null);
		
		JPanel panelUserInformation = new JPanel();
		panelUserInformation.setBounds(538, 12, 234, 94);
		panelUserInformation.setLayout(null);
		panelUserInformation.setBackground(new Color(204, 255, 153));
		panelCustomerHome.add(panelUserInformation);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInformation.logOut(frame);
			}
		});
		btnLogOut.setBounds(12, 47, 89, 35);
		panelUserInformation.add(btnLogOut);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInformation.home(frame);

			}
		});
		btnHome.setBounds(133, 47, 89, 35);
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
		
		JLabel lblAskAQuestion = new JLabel("Ask A Question");
		lblAskAQuestion.setBounds(403, 219, 157, 19);
		lblAskAQuestion.setForeground(new Color(0, 51, 255));
		lblAskAQuestion.setFont(new Font("Dialog", Font.BOLD, 14));
		panelCustomerHome.add(lblAskAQuestion);
		
		JLabel lblViewProfile = new JLabel("Settings");
		lblViewProfile.setBounds(221, 218, 145, 19);
		lblViewProfile.setForeground(new Color(0, 51, 255));
		lblViewProfile.setFont(new Font("Dialog", Font.BOLD, 14));
		panelCustomerHome.add(lblViewProfile);
		
		JLabel lblViewBIll = new JLabel("View Bill");
		lblViewBIll.setBounds(53, 218, 113, 19);
		lblViewBIll.setForeground(new Color(0, 51, 255));
		lblViewBIll.setFont(new Font("Dialog", Font.BOLD, 14));
		panelCustomerHome.add(lblViewBIll);
		
		JButton btnViewBill = new JButton("");
		btnViewBill.setIcon(new ImageIcon(CustomerHome.class.getResource("/images/Bills.png")));
		btnViewBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewBill bill = new ViewBill();
				frame.dispose();
			}
		});
		btnViewBill.setBounds(53, 236, 150, 150);
		btnViewBill.setFont(new Font("Dialog", Font.BOLD, 16));
		panelCustomerHome.add(btnViewBill);
		
		JButton btnViewProfile = new JButton("");
		btnViewProfile.setIcon(new ImageIcon(CustomerHome.class.getResource("/images/settings.png")));
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Settings s = new Settings();
				
			}
		});
		btnViewProfile.setBounds(228, 236, 150, 150);
		btnViewProfile.setFont(new Font("Dialog", Font.BOLD, 16));
		panelCustomerHome.add(btnViewProfile);
		
		JButton btnAskAQuestion = new JButton("");
		btnAskAQuestion.setIcon(new ImageIcon(CustomerHome.class.getResource("/images/faqs.png")));
		btnAskAQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AskAQuestion ask = new AskAQuestion();
				frame.dispose();
			}
		});
		btnAskAQuestion.setBounds(413, 236, 150, 150);
		btnAskAQuestion.setFont(new Font("Dialog", Font.BOLD, 16));
		panelCustomerHome.add(btnAskAQuestion);
	}
}
