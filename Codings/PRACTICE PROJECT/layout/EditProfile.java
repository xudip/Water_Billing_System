package layout;

import includes.UserInformation;
import includes.Validations;
import includes.setGetGlobalVariables;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;

import java.awt.SystemColor;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import actionAndEvents.EditProfileActionAndEvents;
import actionAndEvents.SignUpActionAndEvents;
import actionAndEvents.ViewBillActionAndEvents;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditProfile {

	private JFrame frame;
	protected static JTextField txtFirstName;
	protected static JTextField txtDistrict;
	protected static JTextField txtMunicipality;
	protected static JTextField txtWardNo;
	protected static JTextField txtDob;
	protected static JTextField txtGender;
	protected static JTextField txtContact;
	protected static JTextField txtEmail;
	protected static JTextField txtUsername;
	protected static JPasswordField txtPassword;
	protected static JTextField txtSecurityQuestion;
	protected static JPasswordField txtAnswer;
	protected static JTextField txtMiddleName;
	protected static JTextField txtLastName;
	protected static JLabel lblProfilePicture;

	protected static JButton btnChoosePicture;

	protected static int id;
	protected static String fileName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProfile window = new EditProfile();
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
	public EditProfile() {
		id = ViewBillActionAndEvents.getId();
		EditProfileActionAndEvents.getData(id);
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

		final JPanel panelEditProfile = new JPanel();
		panelEditProfile.setBorder(new TitledBorder(null, "Edit Profile", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEditProfile.setBackground(new Color(204, 255, 153));
		panelEditProfile.setBounds(0, 0, 784, 556);
		frame.getContentPane().add(panelEditProfile);
		panelEditProfile.setLayout(null);

		final JPanel panelImagePreview = new JPanel();
		panelImagePreview.setBorder(new TitledBorder(null, "Image Preview", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelImagePreview.setBackground(SystemColor.inactiveCaption);
		panelImagePreview.setBounds(601, 139, 171, 141);
		panelEditProfile.add(panelImagePreview);
		panelImagePreview.setLayout(null);

		lblProfilePicture = new JLabel("");
		lblProfilePicture.setBounds(12, 22, 147, 107);
		BufferedImage image1 = null;
		try{
			image1 = ImageIO.read(new File("userphoto\\" + setGetGlobalVariables.fileName));
		}catch(Exception e){
			e.printStackTrace();
		}

		ImageIcon imageIcon1 = new ImageIcon(setGetGlobalVariables.fitimage(image1, lblProfilePicture.getWidth(), lblProfilePicture.getHeight()));
		lblProfilePicture.setIcon(imageIcon1);
		panelImagePreview.add(lblProfilePicture);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblName.setBounds(149, 145, 46, 14);
		panelEditProfile.add(lblName);

		JLabel lblDistrict = new JLabel("District:");
		lblDistrict.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDistrict.setBounds(149, 312, 46, 14);
		panelEditProfile.add(lblDistrict);

		txtFirstName = new JTextField();
		txtFirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				Validations.alphabetValidate(arg0, c);
			}
		});
		txtFirstName.setEditable(false);
		txtFirstName.setText(EditProfileActionAndEvents.getFirstName());
		txtFirstName.setBounds(228, 145, 86, 20);
		panelEditProfile.add(txtFirstName);
		txtFirstName.setColumns(10);

		txtDistrict = new JTextField();
		txtDistrict.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.alphabetValidate(e, c);
			}
		});
		txtDistrict.setEditable(false);
		txtDistrict.setText(EditProfileActionAndEvents.getDistrict());
		txtDistrict.setBounds(228, 312, 86, 20);
		panelEditProfile.add(txtDistrict);
		txtDistrict.setColumns(10);

		JLabel lblMunicipality = new JLabel("Municipality:");
		lblMunicipality.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMunicipality.setBounds(324, 315, 72, 14);
		panelEditProfile.add(lblMunicipality);

		txtMunicipality = new JTextField();
		txtMunicipality.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.alphabetValidate(e, c);
			}
		});
		txtMunicipality.setEditable(false);
		txtMunicipality.setText(EditProfileActionAndEvents.getMunicipality());
		txtMunicipality.setBounds(421, 312, 86, 20);
		panelEditProfile.add(txtMunicipality);
		txtMunicipality.setColumns(10);

		JLabel lblWardNo = new JLabel("Ward No.:");
		lblWardNo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblWardNo.setBounds(521, 315, 72, 14);
		panelEditProfile.add(lblWardNo);

		txtWardNo = new JTextField();
		txtWardNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.alphabetValidate(e, c);
			}
		});
		txtWardNo.setEditable(false);
		txtWardNo.setText(EditProfileActionAndEvents.getWardNo());
		txtWardNo.setBounds(601, 310, 61, 20);
		panelEditProfile.add(txtWardNo);
		txtWardNo.setColumns(10);

		JLabel lblDob = new JLabel("DOB:");
		lblDob.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDob.setBounds(149, 176, 46, 14);
		panelEditProfile.add(lblDob);

		txtDob = new JTextField();
		txtDob.setEditable(false);
		txtDob.setText(EditProfileActionAndEvents.getDob());
		txtDob.setBounds(228, 176, 86, 20);
		panelEditProfile.add(txtDob);
		txtDob.setColumns(10);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGender.setBounds(339, 178, 46, 14);
		panelEditProfile.add(lblGender);

		txtGender = new JTextField();
		txtGender.setEditable(false);
		txtGender.setText(EditProfileActionAndEvents.getGender());
		txtGender.setBounds(395, 176, 86, 20);
		panelEditProfile.add(txtGender);
		txtGender.setColumns(10);

		JLabel lblContact = new JLabel("Contact:");
		lblContact.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblContact.setBounds(149, 227, 69, 14);
		panelEditProfile.add(lblContact);

		txtContact = new JTextField();
		txtContact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.numberValidate(e, c);
			}
		});
		txtContact.setEditable(false);
		txtContact.setText(EditProfileActionAndEvents.getContact());
		txtContact.setBounds(228, 224, 86, 20);
		panelEditProfile.add(txtContact);
		txtContact.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmail.setBounds(149, 266, 46, 14);
		panelEditProfile.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setText(EditProfileActionAndEvents.getEmail());
		txtEmail.setBounds(228, 266, 86, 20);
		panelEditProfile.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUsername.setBounds(149, 351, 69, 14);
		panelEditProfile.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setEditable(false);
		txtUsername.setText(EditProfileActionAndEvents.getUserName());
		txtUsername.setBounds(228, 351, 86, 20);
		panelEditProfile.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPassword.setBounds(149, 392, 69, 14);
		panelEditProfile.add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setEditable(false);
		txtPassword.setEchoChar('*');
		txtPassword.setText(EditProfileActionAndEvents.getPassword());
		txtPassword.setBounds(228, 392, 86, 20);
		panelEditProfile.add(txtPassword);
		txtPassword.setColumns(10);

		JLabel lblSecurityQuestion = new JLabel("Security Question:");
		lblSecurityQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSecurityQuestion.setBounds(149, 436, 117, 14);
		panelEditProfile.add(lblSecurityQuestion);

		txtSecurityQuestion = new JTextField();
		txtSecurityQuestion.setEditable(false);
		txtSecurityQuestion.setText(EditProfileActionAndEvents.getSecurityQuestion());
		txtSecurityQuestion.setBounds(260, 434, 99, 20);
		panelEditProfile.add(txtSecurityQuestion);
		txtSecurityQuestion.setColumns(10);

		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAnswer.setBounds(149, 468, 46, 14);
		panelEditProfile.add(lblAnswer);

		txtAnswer = new JPasswordField();
		txtAnswer.setEditable(false);
		txtAnswer.setText(EditProfileActionAndEvents.getAnswer());
		txtAnswer.setBounds(228, 465, 86, 20);
		panelEditProfile.add(txtAnswer);
		txtAnswer.setColumns(10);

		JPanel panelUserInformation = new JPanel();
		panelUserInformation.setBounds(521, 11, 253, 103);
		panelEditProfile.add(panelUserInformation);
		panelUserInformation.setLayout(null);

		JLabel lblUsernameLoggedIn = new JLabel(setGetGlobalVariables.getUsername());
		lblUsernameLoggedIn.setBounds(99, 12, 74, 14);
		panelUserInformation.add(lblUsernameLoggedIn);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserInformation.logOut(frame);
			}
		});
		btnLogOut.setBounds(10, 60, 89, 30);
		panelUserInformation.add(btnLogOut);

		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInformation.home(frame);
			}
		});
		btnHome.setBounds(154, 60, 89, 30);
		panelUserInformation.add(btnHome);

		final JLabel lblImagePreview = new JLabel("ImagePreview");
		lblImagePreview.setBounds(32, 0, 55, 53);
		BufferedImage image = null;
		try{
			image = ImageIO.read(new File("userphoto\\" + setGetGlobalVariables.fileName));
		}catch(Exception e){
			e.printStackTrace();
		}

		ImageIcon imageIcon = new ImageIcon(setGetGlobalVariables.fitimage(image, lblImagePreview.getWidth(), lblImagePreview.getHeight()));
		lblImagePreview.setIcon(imageIcon);
		panelUserInformation.add(lblImagePreview);

		btnChoosePicture = new JButton("Choose Picture");
		btnChoosePicture.setEnabled(false);
		btnChoosePicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "*.IMAGE", "jpg", "gif", "png");
				fileChooser.addChoosableFileFilter(filter);
				int result = fileChooser.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION){
					File selectedFile = fileChooser.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					fileName = selectedFile.getName();
					try{
						FileInputStream fin = new FileInputStream(selectedFile);
						FileOutputStream fout = new FileOutputStream("userphoto/"+fileName);
//						JOptionPane.showMessageDialog(null, fileName);
						int a = 0;
						try{
							while((a=fin.read())!=-1){
								fout.write(a);
							}
						}catch(IOException e1){
							JOptionPane.showMessageDialog(null, e1.toString());
						}
					}catch(FileNotFoundException fe ){
						JOptionPane.showMessageDialog(null, "File Not Found");
					}
					JOptionPane.showMessageDialog(null, "Profile Picture uploading SuccessfuL!");

					BufferedImage image = null;
					try{
						image = ImageIO.read(new File("userphoto\\" + fileName));
					}catch(Exception e2){
						e2.printStackTrace();
					}

					ImageIcon imageIcon = new ImageIcon(setGetGlobalVariables.fitimage(image, lblProfilePicture.getWidth(), lblProfilePicture.getHeight()));
					lblProfilePicture.setIcon(imageIcon);
					panelImagePreview.repaint();
				}

			}
		});
		btnChoosePicture.setBounds(474, 257, 117, 23);
		panelEditProfile.add(btnChoosePicture);

		txtMiddleName = new JTextField();
		txtMiddleName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.alphabetValidate(e, c);
			}
		});
		txtMiddleName.setEditable(false);
		txtMiddleName.setText(EditProfileActionAndEvents.getMiddleName());
		txtMiddleName.setBounds(339, 145, 86, 20);
		panelEditProfile.add(txtMiddleName);
		txtMiddleName.setColumns(10);

		txtLastName = new JTextField();
		txtLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.alphabetValidate(e, c);
			}
		});
		txtLastName.setEditable(false);
		txtLastName.setText(EditProfileActionAndEvents.getLastName());
		txtLastName.setBounds(447, 145, 86, 20);
		panelEditProfile.add(txtLastName);
		txtLastName.setColumns(10);

		final JButton btnUpadte = new JButton("CHANGE");
		btnUpadte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditProfileActionAndEvents.enableUpdate();
				panelEditProfile.repaint();
				if(btnUpadte.getText().equals("SAVE")){
					EditProfileActionAndEvents.setData();
					if(EditProfileActionAndEvents.checkError() == false){
						if(EditProfileActionAndEvents.updateData() == true){
							btnUpadte.setText("CHANGE");
							EditProfileActionAndEvents.disableUpdate();

						}
					}
				}
				else{
					btnUpadte.setText("SAVE");
				}
			}
		});
		btnUpadte.setBounds(301, 507, 95, 36);
		panelEditProfile.add(btnUpadte);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnUpadte.setText("UPDATE");
				EditProfileActionAndEvents.disableUpdate();
				new EditProfile();
				frame.dispose();
			}
		});
		btnCancel.setBounds(447, 507, 99, 36);
		panelEditProfile.add(btnCancel);
	}
}
