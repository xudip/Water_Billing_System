package layout;

import includes.UserInformation;
import includes.setGetGlobalVariables;

import java.awt.Color;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

//import com.sun.java.util.jar.pack.Instruction.Switch;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import jdk.management.resource.internal.TotalResourceContext;

public class AboutUs {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUs window = new AboutUs();
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
	public AboutUs() {
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

		JPanel panelAboutUs = new JPanel();
		panelAboutUs.setBounds(10, 11, 764, 534);
		panelAboutUs.setBorder(new TitledBorder(null, "ABOUT US", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAboutUs.setBackground(new Color(204, 255, 153));
		panelAboutUs.setForeground(new Color(51, 153, 204));
		frame.getContentPane().add(panelAboutUs);
		panelAboutUs.setLayout(null);

		JPanel panelAboutUs1 = new JPanel();
		panelAboutUs1.setBounds(12, 151, 234, 271);
		panelAboutUs1.setBackground(new Color(204, 255, 102));
		panelAboutUs1.setForeground(new Color(51, 153, 204));
		panelAboutUs.add(panelAboutUs1);
		panelAboutUs1.setLayout(null);

		JLabel lblXudipGora = new JLabel("Sudarshan Gora");
		lblXudipGora.setForeground(new Color(128, 0, 0));
		lblXudipGora.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblXudipGora.setBounds(12, 11, 212, 36);
		panelAboutUs1.add(lblXudipGora);

		JLabel lblDevelopedBy = new JLabel("DEVELOPED BY:");
		lblDevelopedBy.setForeground(new Color(0, 0, 255));
		lblDevelopedBy.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDevelopedBy.setBounds(12, 87, 143, 22);
		panelAboutUs1.add(lblDevelopedBy);

		JLabel lblSudarshanGora = new JLabel("SUDARSHAN GORA");
		lblSudarshanGora.setForeground(new Color(0, 0, 255));
		lblSudarshanGora.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSudarshanGora.setBounds(12, 120, 150, 19);
		panelAboutUs1.add(lblSudarshanGora);

		JLabel lblBhaktapurNepal = new JLabel("BHAKTAPUR, NEPAL");
		lblBhaktapurNepal.setForeground(new Color(0, 0, 255));
		lblBhaktapurNepal.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblBhaktapurNepal.setBounds(12, 150, 159, 19);
		panelAboutUs1.add(lblBhaktapurNepal);

		JLabel lblContact = new JLabel("CONTACT: 9849423493");
		lblContact.setForeground(new Color(0, 0, 255));
		lblContact.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblContact.setBounds(12, 180, 166, 19);
		panelAboutUs1.add(lblContact);

		JLabel lblEmailGorasudipgmailcom = new JLabel("EMAIL: gorasudip@gmail.com");
		lblEmailGorasudipgmailcom.setForeground(new Color(0, 0, 255));
		lblEmailGorasudipgmailcom.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmailGorasudipgmailcom.setBounds(12, 210, 209, 19);
		panelAboutUs1.add(lblEmailGorasudipgmailcom);

		JLabel lblDegreeBitVi = new JLabel("DEGREE: BIT VI ");
		lblDegreeBitVi.setForeground(new Color(0, 0, 255));
		lblDegreeBitVi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDegreeBitVi.setBounds(12, 240, 127, 19);
		panelAboutUs1.add(lblDegreeBitVi);

		JPanel panelUserInformation = new JPanel();
		panelUserInformation.setBackground(new Color(204, 255, 153));
		panelUserInformation.setBounds(540, 11, 234, 90);
		panelAboutUs.add(panelUserInformation);
		panelUserInformation.setLayout(null);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserInformation.logOut(frame);
			}
		});
		btnLogOut.setBounds(12, 48, 89, 35);
		panelUserInformation.add(btnLogOut);

		JButton btnHome = new JButton("Home");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserInformation.home(frame);
			}
		});
		btnHome.setBounds(133, 48, 89, 35);
		panelUserInformation.add(btnHome);

		JLabel lblUsername = new JLabel(setGetGlobalVariables.getUsername());
		lblUsername.setBounds(99, 12, 58, 16);
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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(51, 153, 204));
		panel.setBackground(new Color(204, 255, 102));
		panel.setBounds(258, 151, 234, 271);
		panelAboutUs.add(panel);
		
		JLabel lblAshimKc = new JLabel("Ashim KC");
		lblAshimKc.setForeground(new Color(128, 0, 0));
		lblAshimKc.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblAshimKc.setBounds(12, 11, 212, 36);
		panel.add(lblAshimKc);
		
		JLabel label_1 = new JLabel("DEVELOPED BY:");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_1.setBounds(12, 87, 143, 22);
		panel.add(label_1);
		
		JLabel lblAshimKc_1 = new JLabel("ASHIM KC");
		lblAshimKc_1.setForeground(Color.BLUE);
		lblAshimKc_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAshimKc_1.setBounds(12, 120, 150, 19);
		panel.add(lblAshimKc_1);
		
		JLabel lblKathmanduNepal = new JLabel("KATHMANDU, NEPAL");
		lblKathmanduNepal.setForeground(Color.BLUE);
		lblKathmanduNepal.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblKathmanduNepal.setBounds(12, 150, 212, 19);
		panel.add(lblKathmanduNepal);
		
		JLabel lblContact_1 = new JLabel("CONTACT: 9849638063");
		lblContact_1.setForeground(Color.BLUE);
		lblContact_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblContact_1.setBounds(12, 180, 166, 19);
		panel.add(lblContact_1);
		
		JLabel lblEmailArcikcgmailcom = new JLabel("EMAIL: arcikc@gmail.com");
		lblEmailArcikcgmailcom.setForeground(Color.BLUE);
		lblEmailArcikcgmailcom.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmailArcikcgmailcom.setBounds(12, 210, 209, 19);
		panel.add(lblEmailArcikcgmailcom);
		
		JLabel label_6 = new JLabel("DEGREE: BIT VI ");
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_6.setBounds(12, 240, 127, 19);
		panel.add(label_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(new Color(51, 153, 204));
		panel_1.setBackground(new Color(204, 255, 102));
		panel_1.setBounds(504, 151, 270, 271);
		panelAboutUs.add(panel_1);
		
		JLabel lblPhurpaSherpa = new JLabel("Phurpa Sherpa");
		lblPhurpaSherpa.setForeground(new Color(128, 0, 0));
		lblPhurpaSherpa.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPhurpaSherpa.setBounds(12, 11, 212, 36);
		panel_1.add(lblPhurpaSherpa);
		
		JLabel label_8 = new JLabel("DEVELOPED BY:");
		label_8.setForeground(Color.BLUE);
		label_8.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_8.setBounds(12, 87, 143, 22);
		panel_1.add(label_8);
		
		JLabel lblPhurpaSherpa_1 = new JLabel("PHURPA SHERPA");
		lblPhurpaSherpa_1.setForeground(Color.BLUE);
		lblPhurpaSherpa_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPhurpaSherpa_1.setBounds(12, 120, 150, 19);
		panel_1.add(lblPhurpaSherpa_1);
		
		JLabel lblKathmanduNepal_1 = new JLabel("KATHMANDU, NEPAL");
		lblKathmanduNepal_1.setForeground(Color.BLUE);
		lblKathmanduNepal_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblKathmanduNepal_1.setBounds(12, 150, 212, 19);
		panel_1.add(lblKathmanduNepal_1);
		
		JLabel lblContact_2 = new JLabel("CONTACT: 9860648544");
		lblContact_2.setForeground(Color.BLUE);
		lblContact_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblContact_2.setBounds(12, 180, 166, 19);
		panel_1.add(lblContact_2);
		
		JLabel lblEmailPhurpacrsherpagmailcom = new JLabel("EMAIL: phurpacr7sherpa@gmail.com");
		lblEmailPhurpacrsherpagmailcom.setForeground(Color.BLUE);
		lblEmailPhurpacrsherpagmailcom.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmailPhurpacrsherpagmailcom.setBounds(12, 210, 258, 19);
		panel_1.add(lblEmailPhurpacrsherpagmailcom);
		
		JLabel label_13 = new JLabel("DEGREE: BIT VI ");
		label_13.setForeground(Color.BLUE);
		label_13.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_13.setBounds(12, 240, 127, 19);
		panel_1.add(label_13);
	}
}
