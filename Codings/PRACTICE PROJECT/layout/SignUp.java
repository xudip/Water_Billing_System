package layout;

import includes.UserInformation;
import includes.setGetGlobalVariables;
import includes.Validations;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import actionAndEvents.FAQsActionAndEvents;
import actionAndEvents.SignUpActionAndEvents;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;
import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator.Fitness;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.Format;
import java.time.Year;
import java.util.Vector;

public class SignUp {

	private JFrame frame;
	private JPanel panelSignUp;
	protected static JPanel panelLogIn;


	public static JTextField txtFirstName;
	public static JTextField txtMiddleName;
	public static JTextField txtLastName;
	public static JTextField txtContact;
	public static JTextField txtDistrict;
	public static JTextField txtMunicipality;
	public static JTextField txtUsername;
	public static JTextField txtEmail;
	public static JTextField txtSecurityQuestion;
	public static JPasswordField txtAnswer;
	public static JTextField txtWardNo;

	public static JPasswordField pwdPassword;
	public static JPasswordField pwdReTypePassword;

	private JLabel lblDob;
	private JLabel lblGender;
	private JLabel lblEmail;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblRetypePassword;
	private JLabel lblSecurityQuestion;
	private JLabel lblAnswer;
	private JLabel lblPrivilege;
	protected static JLabel lblTick;
	protected static JLabel lblCross;

	public static JRadioButton rdbtnMale;
	public static JRadioButton rdbtnFemale;
	public static JRadioButton rdbtnOther;

	public static ButtonGroup btngrpgender;

	private JButton btnSignUp;
	private JButton btnClear;
	private JButton btnChooseProfilePicture;
	private JPanel panel;
	private JButton btnLogOut;
	private JButton btnHome;
	private JLabel lblUsername_1;

	protected static JComboBox comboBoxPrivilege;
	protected static JComboBox comboBoxDay;
	protected static JComboBox comboBoxMonth;
	protected static JComboBox comboBoxYear;
	protected static JLabel lblUsernameAlreadyExists;
	public static JLabel lblImagePreview;

	public static String fileName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
	public SignUp() {
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

		panelSignUp = new JPanel();
		panelSignUp.setBorder(new TitledBorder(null, "SIGN UP", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSignUp.setBackground(new Color(204, 255, 153));
		panelSignUp.setForeground(new Color(51, 153, 204));
		panelSignUp.setBounds(12, 12, 764, 542);
		frame.getContentPane().add(panelSignUp);
		panelSignUp.setLayout(null);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(74, 114, 64, 16);
		lblFirstName.setForeground(SystemColor.desktop);
		lblFirstName.setFont(new Font("Dialog", Font.BOLD, 12));
		panelSignUp.add(lblFirstName);

		txtFirstName = new JTextField();
		txtFirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				Validations.alphabetValidate(arg0, c);

			}
		});
		txtFirstName.setBounds(149, 114, 86, 20);
		panelSignUp.add(txtFirstName);
		txtFirstName.setText("First Name");
		txtFirstName.setColumns(10);

		JLabel lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setBounds(295, 114, 76, 16);
		lblMiddleName.setForeground(SystemColor.desktop);
		lblMiddleName.setFont(new Font("Dialog", Font.BOLD, 12));
		panelSignUp.add(lblMiddleName);

		txtMiddleName = new JTextField();
		txtMiddleName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.alphabetValidate(e, c);
				
			}
		});
		txtMiddleName.setBounds(381, 113, 86, 20);
		panelSignUp.add(txtMiddleName);
		txtMiddleName.setText("Middle Name");
		txtMiddleName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(522, 114, 64, 16);
		lblLastName.setForeground(SystemColor.desktop);
		lblLastName.setFont(new Font("Dialog", Font.BOLD, 12));
		panelSignUp.add(lblLastName);

		txtLastName = new JTextField();
		txtLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.alphabetValidate(e, c);
			}
		});
		txtLastName.setBounds(596, 113, 86, 20);
		panelSignUp.add(txtLastName);
		txtLastName.setText("Last Name");
		txtLastName.setColumns(10);

		final JPanel panelImagePreview = new JPanel();
		panelImagePreview.setBounds(408, 145, 125, 127);
		panelImagePreview.setBorder(new TitledBorder(null, "Image Preview", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, SystemColor.textHighlight));
		panelSignUp.add(panelImagePreview);
		panelImagePreview.setLayout(null);
		
		lblImagePreview = new JLabel("");
		lblImagePreview.setBackground(Color.WHITE);
		lblImagePreview.setBounds(12, 24, 101, 91);
		panelImagePreview.add(lblImagePreview);

		btnChooseProfilePicture = new JButton("Choose Profile Picture");
		btnChooseProfilePicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
						}catch(IOException e){
							JOptionPane.showMessageDialog(null, e.toString());
						}
					}catch(FileNotFoundException fe ){
						JOptionPane.showMessageDialog(null, "File Not Found");
					}
					JOptionPane.showMessageDialog(null, "Profile Picture uploading SuccessfuL!");
					
					BufferedImage image = null;
					try{
						image = ImageIO.read(new File("userphoto\\" + fileName));
					}catch(Exception e){
						e.printStackTrace();
					}
					
					ImageIcon imageIcon = new ImageIcon(setGetGlobalVariables.fitimage(image, lblImagePreview.getWidth(), lblImagePreview.getHeight()));
					lblImagePreview.setIcon(imageIcon);
					panelImagePreview.repaint();
				}
				
				
				
			}
		});
		btnChooseProfilePicture.setBounds(545, 209, 149, 23);
		panelSignUp.add(btnChooseProfilePicture);

		lblDob = new JLabel("DOB:");
		lblDob.setBounds(74, 149, 29, 16);
		lblDob.setForeground(SystemColor.desktop);
		lblDob.setFont(new Font("Dialog", Font.BOLD, 12));
		panelSignUp.add(lblDob);

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

		lblGender = new JLabel("Gender:");
		lblGender.setBounds(74, 189, 44, 16);
		lblGender.setForeground(SystemColor.desktop);
		lblGender.setFont(new Font("Dialog", Font.BOLD, 12));
		panelSignUp.add(lblGender);

		btngrpgender = new ButtonGroup();


		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(139, 185, 62, 23);
		rdbtnMale.setSelected(true);
		panelSignUp.add(rdbtnMale);
		btngrpgender.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(203, 185, 70, 23);
		panelSignUp.add(rdbtnFemale);
		btngrpgender.add(rdbtnFemale);

		rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setBounds(275, 185, 67, 23);
		panelSignUp.add(rdbtnOther);
		btngrpgender.add(rdbtnOther);

		JLabel lblContact = new JLabel("Contact: ");
		lblContact.setBounds(74, 216, 50, 16);
		lblContact.setForeground(SystemColor.desktop);
		lblContact.setFont(new Font("Dialog", Font.BOLD, 12));
		panelSignUp.add(lblContact);

		txtContact = new JTextField();
		txtContact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((txtContact.getText().length()>=10)){
					e.consume();
				}
				else{
					Validations.numberValidate(e, c);
				}

				//				if (!((c >= '0') && (c <= '9') || 
				//						(c == KeyEvent.VK_BACK_SPACE) || 
				//						(c == KeyEvent.VK_DELETE)) ||
				//						(txtContact.getText().length()>=10)){
				//					{
				//						e.consume();
				//					}
				//				}
			}
		});
		txtContact.setBounds(149, 215, 86, 20);
		panelSignUp.add(txtContact);
		txtContact.setText("1234567890");


		JLabel lblDistrict = new JLabel("District");
		lblDistrict.setBounds(74, 248, 41, 16);
		lblDistrict.setForeground(SystemColor.desktop);
		lblDistrict.setFont(new Font("Dialog", Font.BOLD, 12));
		panelSignUp.add(lblDistrict);

		txtDistrict = new JTextField();
		txtDistrict.setBounds(149, 246, 86, 20);
		panelSignUp.add(txtDistrict);
		txtDistrict.setText("District");
		txtDistrict.setColumns(10);

		JLabel lblMunicipality = new JLabel("Municipality");
		lblMunicipality.setBounds(295, 290, 76, 16);
		lblMunicipality.setForeground(SystemColor.desktop);
		lblMunicipality.setFont(new Font("Dialog", Font.BOLD, 12));
		panelSignUp.add(lblMunicipality);

		txtMunicipality = new JTextField();
		txtMunicipality.setBounds(381, 289, 86, 20);
		panelSignUp.add(txtMunicipality);
		txtMunicipality.setText("Municipality");
		txtMunicipality.setColumns(10);

		JLabel lblWardNo = new JLabel("Ward No.:");
		lblWardNo.setBounds(514, 290, 86, 16);
		lblWardNo.setForeground(SystemColor.desktop);
		lblWardNo.setFont(new Font("Dialog", Font.BOLD, 12));
		panelSignUp.add(lblWardNo);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(74, 278, 35, 16);
		lblEmail.setForeground(SystemColor.desktop);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 12));
		panelSignUp.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(149, 277, 86, 20);
		panelSignUp.add(txtEmail);
		txtEmail.setText("Email");
		txtEmail.setColumns(10);

		lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(74, 309, 65, 16);
		lblUsername.setForeground(SystemColor.desktop);
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 12));
		panelSignUp.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				SignUpActionAndEvents.chekUsernameAvailability(txtUsername.getText());
			} 
		});
		txtUsername.setBounds(149, 308, 86, 20);
		panelSignUp.add(txtUsername);
		txtUsername.setText("Username");
		txtUsername.setColumns(10);

		lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(74, 340, 64, 16);
		lblPassword.setForeground(SystemColor.desktop);
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 12));
		panelSignUp.add(lblPassword);

		lblRetypePassword = new JLabel("ReType Password");
		lblRetypePassword.setBounds(74, 367, 103, 16);
		lblRetypePassword.setForeground(SystemColor.desktop);
		lblRetypePassword.setFont(new Font("Dialog", Font.BOLD, 12));
		panelSignUp.add(lblRetypePassword);

		lblSecurityQuestion = new JLabel("Security Question: ");
		lblSecurityQuestion.setBounds(74, 402, 107, 16);
		lblSecurityQuestion.setForeground(SystemColor.desktop);
		lblSecurityQuestion.setFont(new Font("Dialog", Font.BOLD, 12));
		panelSignUp.add(lblSecurityQuestion);

		txtSecurityQuestion = new JTextField();
		txtSecurityQuestion.setBounds(187, 401, 86, 20);
		panelSignUp.add(txtSecurityQuestion);
		txtSecurityQuestion.setText("Security Question");
		txtSecurityQuestion.setColumns(10);

		lblAnswer = new JLabel("Answer: ");
		lblAnswer.setBounds(321, 402, 50, 16);
		lblAnswer.setForeground(SystemColor.desktop);
		lblAnswer.setFont(new Font("Dialog", Font.BOLD, 12));
		panelSignUp.add(lblAnswer);

		txtAnswer = new JPasswordField();
		txtAnswer.setBounds(381, 399, 86, 20);
		panelSignUp.add(txtAnswer);
		txtAnswer.setText("Answer");
		txtAnswer.setColumns(10);

		btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(299, 477, 89, 23);
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SignUpActionAndEvents.setData();
				SignUpActionAndEvents.checkError();
				SignUpActionAndEvents.chekUsernameAvailability(txtUsername.getText());
				if(pwdPassword.getText().equals(pwdReTypePassword.getText())){
					lblTick.setVisible(true);
					lblCross.setVisible(false);
				}
				else{
					lblTick.setVisible(false);
					lblCross.setVisible(true);
				}

				if(SignUpActionAndEvents.error==false && lblTick.isVisible()){
					SignUpActionAndEvents.insertData();
				}
				else{
					JOptionPane.showMessageDialog(null, "Insert Unsuccessful");
				}
			}
		});
		panelSignUp.add(btnSignUp);


		btnClear = new JButton("Clear");
		btnClear.setBounds(421, 477, 89, 23);
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SignUpActionAndEvents.clearData();
				//clearData.clearData();
			}
		});
		panelSignUp.add(btnClear);

		txtWardNo = new JTextField();
		txtWardNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.numberValidate(e, c);
			}
		});
		txtWardNo.setBounds(608, 288, 86, 20);
		txtWardNo.setText("12");
		txtWardNo.setColumns(10);
		panelSignUp.add(txtWardNo);

		lblPrivilege = new JLabel("Privilege: ");
		lblPrivilege.setBounds(74, 432, 55, 16);
		panelSignUp.add(lblPrivilege);

		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(149, 340, 86, 20);
		pwdPassword.setText("Password");
		pwdPassword.setEchoChar('*');
		panelSignUp.add(pwdPassword);

		pwdReTypePassword = new JPasswordField();
		pwdReTypePassword.setBounds(187, 365, 86, 20);
		pwdReTypePassword.setText("Password");
		pwdReTypePassword.setEchoChar('*');
		panelSignUp.add(pwdReTypePassword);

		comboBoxPrivilege = new JComboBox();
		comboBoxPrivilege.setBounds(149, 429, 101, 20);


		lblUsernameAlreadyExists = new JLabel("Username Already Exists");
		lblUsernameAlreadyExists.setForeground(Color.RED);
		lblUsernameAlreadyExists.setBounds(242, 309, 143, 16);
		lblUsernameAlreadyExists.setVisible(false);
		panelSignUp.add(lblUsernameAlreadyExists);

		JButton btneye = new JButton("");
		btneye.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				pwdPassword.setEchoChar((char) 0);
				pwdReTypePassword.setEchoChar((char) 0);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				pwdPassword.setEchoChar('*');
				pwdReTypePassword.setEchoChar('*');
			}
		});
		btneye.setIcon(new ImageIcon(SignUp.class.getResource("/images/eye.png")));
		btneye.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), new Color(192, 192, 192), new Color(128, 128, 128), new Color(192, 192, 192)));
		btneye.setBounds(240, 340, 21, 20);
		panelSignUp.add(btneye);

		lblTick = new JLabel("");
		lblTick.setIcon(new ImageIcon(SignUp.class.getResource("/images/tick.png")));
		lblTick.setBounds(275, 367, 14, 16);
		lblTick.setVisible(false);
		panelSignUp.add(lblTick);

		lblCross = new JLabel("");
		lblCross.setIcon(new ImageIcon(SignUp.class.getResource("/images/cross.png")));
		lblCross.setBounds(295, 367, 14, 16);
		lblCross.setVisible(false);
		panelSignUp.add(lblCross);

		comboBoxDay = new JComboBox();
		comboBoxDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxDay.setBounds(149, 146, 38, 25);
		panelSignUp.add(comboBoxDay);

		comboBoxMonth = new JComboBox();
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBoxMonth.setBounds(198, 145, 91, 25);
		panelSignUp.add(comboBoxMonth);

		comboBoxYear = new JComboBox();
		Vector<Integer> year;
		year = new Vector <Integer>(10);
		int finalYear;
		finalYear = Year.now().getValue() - 16 ;
		int i;	
		for( i = 1900 ; i <= finalYear ; i++ ){
			year.add(i);

		}
		comboBoxYear.setModel(new DefaultComboBoxModel(year));
		comboBoxYear.setBounds(305, 145, 70, 25);
		panelSignUp.add(comboBoxYear);

		panelLogIn = new JPanel();
		panelLogIn.setBackground(new Color(204, 255, 153));
		panelLogIn.setBounds(6, 475, 152, 56);
		try{
			if(setGetGlobalVariables.getUsername()==null){
				panelSignUp.add(panelLogIn);
				panelLogIn.setVisible(true);
				panelLogIn.setLayout(null);
				comboBoxPrivilege.setModel(new DefaultComboBoxModel(new String[] {"CUSTOMER"}));
				panelSignUp.add(comboBoxPrivilege);

			}
			else{
				comboBoxPrivilege.setModel(new DefaultComboBoxModel(new String[] {"CUSTOMER", "METERREADER", "ADMIN"}));
				panelSignUp.add(comboBoxPrivilege);
				panel = new JPanel();
				panel.setLayout(null);
				panel.setBackground(new Color(204, 255, 153));
				panel.setBounds(518, 12, 234, 77);
				panelSignUp.add(panel);

				btnLogOut = new JButton("Log Out");
				UserInformation.getBtnLogOut(btnLogOut, frame);
				panel.add(btnLogOut);

				btnHome = new JButton("Home");
				UserInformation.getBtnHome(btnHome, frame);
				panel.add(btnHome);

//				lblUsername_1 = new JLabel("Username");
//				UserInformation.getlblUsername(lblWardNo);
//				panel.add(lblUsername_1);
			}

		}
		catch(Exception e){
			System.out.println(e);
		}



		final JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setBounds(10, 11, 34, 16);
		lblLogIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//lblSignUp.setBackground(Color.GRAY);
		lblLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogIn.setForeground(Color.BLUE);


			}
			public void mouseExited(MouseEvent e) {
				lblLogIn.setForeground(new Color(0, 51, 153));

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				frame.dispose();
				LogInLayout su = new LogInLayout();

			}
		});
		lblLogIn.setForeground(new Color(0, 51, 153));
		panelLogIn.add(lblLogIn);

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

				frame.dispose();
				ForgotPassword fp = new ForgotPassword();
			}
		});
		lblForgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblForgotPassword.setForeground(new Color(0, 51, 153));
		lblForgotPassword.setBounds(10, 36, 97, 16);
		panelLogIn.add(lblForgotPassword);
	}
}
