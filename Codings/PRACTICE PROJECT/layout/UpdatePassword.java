package layout;

import includes.*;

import java.awt.Color;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;

import actionAndEvents.UpdatePasswordActionAndEvents;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdatePassword {

	public static JFrame frame;
	private JTextField txtOldPassword;
	private JTextField txtNewPassword;
	private JTextField txtReTypeNewPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePassword window = new UpdatePassword();
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
	public UpdatePassword() {
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

		final JPanel panelUpdatePassword = new JPanel();
		panelUpdatePassword.setBounds(0, 0, 784, 545);
		panelUpdatePassword.setBorder(new TitledBorder(null, "UPDATE PASSWORD", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelUpdatePassword.setBackground(new Color(204, 255, 153));
		panelUpdatePassword.setForeground(new Color(51, 153, 204));
		frame.getContentPane().add(panelUpdatePassword);
		panelUpdatePassword.setLayout(null);

		JLabel lblOldPassword = new JLabel("Old Password:");
		lblOldPassword.setBounds(210, 213, 69, 14);
		panelUpdatePassword.add(lblOldPassword);

		txtOldPassword = new JTextField();
		txtOldPassword.setBounds(289, 210, 86, 20);
		panelUpdatePassword.add(txtOldPassword);
		txtOldPassword.setColumns(10);

		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(210, 241, 70, 14);
		panelUpdatePassword.add(lblNewPassword);

		txtNewPassword = new JTextField();
		txtNewPassword.setBounds(290, 238, 86, 20);
		panelUpdatePassword.add(txtNewPassword);
		txtNewPassword.setColumns(10);

		JLabel lblRetypeNewPassword = new JLabel("ReType New Password");
		lblRetypeNewPassword.setBounds(210, 269, 110, 14);
		panelUpdatePassword.add(lblRetypeNewPassword);

		final JLabel lblTick = new JLabel("");
		lblTick.setIcon(new ImageIcon(UpdatePassword.class.getResource("/images/tick.png")));
		lblTick.setBounds(440, 269, 15, 15);
		lblTick.setVisible(false);
		panelUpdatePassword.add(lblTick);

		final JLabel lblCross = new JLabel("");
		lblCross.setIcon(new ImageIcon(UpdatePassword.class.getResource("/images/cross.png")));
		lblCross.setBounds(426, 269, 15, 15);
		lblCross.setVisible(false);
		panelUpdatePassword.add(lblCross);


		txtReTypeNewPassword = new JTextField();
		txtReTypeNewPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(txtNewPassword.getText().equals(txtReTypeNewPassword.getText())){
					//panelUpdatePassword.add(lblTick);
					lblTick.setVisible(true);
					lblCross.setVisible(false);
				}
				else{
					//panelUpdatePassword.add(lblCross);
					lblTick.setVisible(false);
					lblCross.setVisible(true);
				}
			}
		});
		txtReTypeNewPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(txtNewPassword.getText().equals(txtReTypeNewPassword.getText())){
					//panelUpdatePassword.add(lblTick);
					lblTick.setVisible(true);
					lblCross.setVisible(false);
				}
				else{
					//panelUpdatePassword.add(lblCross);
					lblTick.setVisible(false);
					lblCross.setVisible(true);
				}

			}
		});
		txtReTypeNewPassword.setBounds(330, 266, 86, 20);
		panelUpdatePassword.add(txtReTypeNewPassword);
		txtReTypeNewPassword.setColumns(10);

		JButton btnUpdatePassword = new JButton("Update Password");
		btnUpdatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldPassword = txtOldPassword.getText();
				String newPassword = txtNewPassword.getText();
				String reNewPassword = txtReTypeNewPassword.getText();
				if(lblTick.isVisible()){
					JOptionPane.showMessageDialog(null, "Ready to update in database! :D" +oldPassword +"\n"+ newPassword +"\n" + reNewPassword);
					UpdatePasswordActionAndEvents UpdatePassword = new UpdatePasswordActionAndEvents(oldPassword, newPassword, reNewPassword);
				}
			}
		});
		
		btnUpdatePassword.setBounds(220, 314, 89, 23);
		panelUpdatePassword.add(btnUpdatePassword);

		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtOldPassword.setText("");
				txtNewPassword.setText("");
				txtReTypeNewPassword.setText("");
			}
		});
		btnClear.setBounds(343, 314, 89, 23);
		panelUpdatePassword.add(btnClear);

		JPanel panelImagePreview = new JPanel();
		panelImagePreview.setBorder(new TitledBorder(null, "Profile Picture", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelImagePreview.setBounds(225, 52, 150, 150);
		panelUpdatePassword.add(panelImagePreview);
		panelImagePreview.setLayout(null);
		
		JLabel lblImagePreview = new JLabel("Image Preview");lblImagePreview.setBounds(10, 20, 130, 120);
		BufferedImage image = null;
		try{
			image = ImageIO.read(new File("userphoto\\" + setGetGlobalVariables.fileName));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		ImageIcon imageIcon = new ImageIcon(setGetGlobalVariables.fitimage(image, lblImagePreview.getWidth(), lblImagePreview.getHeight()));
		lblImagePreview.setIcon(imageIcon);
		panelImagePreview.add(lblImagePreview);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204, 255, 153));
		panel.setBounds(520, 11, 234, 77);
		panelUpdatePassword.add(panel);
		
		JButton btnLogOut = new JButton("Log Out");
		UserInformation.getBtnLogOut(btnLogOut, frame);
		panel.add(btnLogOut);
		
		JButton btnHome = new JButton("Home");
		UserInformation.getBtnHome(btnHome, frame);
		panel.add(btnHome);
		
		JLabel lblUsername = new JLabel("Username");
		UserInformation.getlblUsername(lblUsername);
		panel.add(lblUsername);


	}
}
