package layout;

import includes.UserInformation;
import includes.setGetGlobalVariables;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class MeterReaderHome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MeterReaderHome window = new MeterReaderHome();
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
	public MeterReaderHome() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(385, 100, 800, 595);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelMeterReaderHome = new JPanel();
		panelMeterReaderHome.setBorder(new TitledBorder(null, "Meter Reader Home", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMeterReaderHome.setBackground(new Color(204, 255, 153));
		panelMeterReaderHome.setBounds(0, 0, 784, 556);
		frame.getContentPane().add(panelMeterReaderHome);
		panelMeterReaderHome.setLayout(null);
		
		JPanel panelUserInformation = new JPanel();
		panelUserInformation.setLayout(null);
		panelUserInformation.setBackground(new Color(204, 255, 153));
		panelUserInformation.setBounds(533, 11, 241, 98);
		panelMeterReaderHome.add(panelUserInformation);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserInformation.logOut(frame);
			}
		});
		btnLogOut.setBounds(10, 52, 89, 35);
		panelUserInformation.add(btnLogOut);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInformation.home(frame);
			}
		});
		btnHome.setBounds(142, 52, 89, 35);
		panelUserInformation.add(btnHome);
		
		JLabel lblUsername = new JLabel(setGetGlobalVariables.getUsername());
		lblUsername.setBounds(113, 11, 80, 30);
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
		
		JButton btnViewProfile = new JButton("");
		btnViewProfile.setIcon(new ImageIcon(MeterReaderHome.class.getResource("/images/update.jpg")));
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditProfile view = new EditProfile();
				frame.dispose();
			}
		});
		btnViewProfile.setBounds(70, 210, 176, 165);
		panelMeterReaderHome.add(btnViewProfile);
		
		JButton btnInsertMeterReading = new JButton("");
		btnInsertMeterReading.setIcon(new ImageIcon(MeterReaderHome.class.getResource("/images/add.jpg")));
		btnInsertMeterReading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertMeterReading insert = new InsertMeterReading();
			}
		});
		btnInsertMeterReading.setBounds(276, 215, 154, 160);
		panelMeterReaderHome.add(btnInsertMeterReading);
		
		JLabel lblViewProfile = new JLabel("View Profile");
		lblViewProfile.setBounds(81, 185, 85, 14);
		panelMeterReaderHome.add(lblViewProfile);
		
		JLabel lblInsertMeterReading = new JLabel("Insert Meter Reading");
		lblInsertMeterReading.setBounds(276, 185, 114, 14);
		panelMeterReaderHome.add(lblInsertMeterReading);
	}
}
