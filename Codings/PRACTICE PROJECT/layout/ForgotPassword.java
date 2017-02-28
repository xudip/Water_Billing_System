package layout;

import includes.setGetGlobalVariables;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import actionAndEvents.ForgotPasswordActionAndEvents;

public class ForgotPassword {

	private JFrame frame;
	protected static JTextField txtUsername;
	protected static JTextField txtAnswer;
	protected static JPanel panelQuestionAnswer;
	protected static JLabel lblQuestion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword window = new ForgotPassword();
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
	public ForgotPassword() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		frame.setTitle("WATER BILLING MANAGEMENT SYSTEM");
		frame.setResizable(false);
		frame.setBounds(600, 200, 335, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 153));
		panel.setForeground(new Color(51, 153, 204));

		panel.setBounds(0, 0, 329, 377);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblWaterBillingManagement = new JLabel("WATER BILLING MANAGEMENT SYSTEM");
		lblWaterBillingManagement.setBounds(10, 11, 312, 20);
		lblWaterBillingManagement.setBackground(new Color(0, 51, 102));
		lblWaterBillingManagement.setForeground(new Color(204, 0, 51));
		lblWaterBillingManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblWaterBillingManagement.setVerticalAlignment(SwingConstants.TOP);
		lblWaterBillingManagement.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblWaterBillingManagement);

		JLabel lblAddress = new JLabel("Address: Kathmandu, Nepal");
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 11));
		lblAddress.setBounds(77, 31, 162, 14);
		lblAddress.setForeground(new Color(0, 51, 153));
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAddress);

		JLabel lblContact = new JLabel("Contact: 014444444");
		lblContact.setFont(new Font("Dialog", Font.BOLD, 11));
		lblContact.setBounds(101, 53, 113, 16);
		lblContact.setForeground(new Color(0, 51, 153));
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblContact);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 127, 62, 16);
		panel.add(lblUsername);

		final JButton btnNext = new JButton("Next");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnNext.getText().equals("Submit")){
					if(ForgotPasswordActionAndEvents.checkAnswer()==true){
						frame.dispose();
						ChangePassword cp = new ChangePassword();
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Answer is not correct");
					}
				}

				if(btnNext.getText().equals("Next")){
					//	ForgotPasswordActionAndEvents.setUsername();
					ForgotPasswordActionAndEvents.checkUsername();
					if(ForgotPasswordActionAndEvents.getStatus().equals("ENTRY")){
						ForgotPasswordActionAndEvents.setStatus(null);
						panelQuestionAnswer.setVisible(true);
						btnNext.setText("Submit");
						txtUsername.setEditable(false);
						try {
							lblQuestion.setText(ForgotPasswordActionAndEvents.retrieveSecurityQuestion());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "ERROR");
					}

				}

			}
		});
		btnNext.setBounds(101, 275, 98, 26);
		panel.add(btnNext);

		txtUsername = new JTextField();
		txtUsername.setBounds(77, 125, 114, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);

		panelQuestionAnswer = new JPanel();
		panelQuestionAnswer.setBorder(new TitledBorder(null, "Security Question", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelQuestionAnswer.setBounds(10, 155, 312, 108);
		panel.add(panelQuestionAnswer);
		panelQuestionAnswer.setLayout(null);
		panelQuestionAnswer.setVisible(false);

		lblQuestion = new JLabel("Question");
		lblQuestion.setBounds(5, 18, 295, 16);
		panelQuestionAnswer.add(lblQuestion);


		txtAnswer = new JTextField();
		txtAnswer.setBounds(96, 76, 114, 20);
		panelQuestionAnswer.add(txtAnswer);

		final JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Elephant", Font.PLAIN, 12));
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
		lblLogIn.setBounds(12, 326, 100, 14);
		panel.add(lblLogIn);

		JLabel lblDevelopedByXudip = new JLabel("Developed By: SUDARSHAN ASHIM PHURPA");
		lblDevelopedByXudip.setBounds(34, 352, 258, 14);
		lblDevelopedByXudip.setForeground(new Color(0, 51, 153));
		lblDevelopedByXudip.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblDevelopedByXudip.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblDevelopedByXudip);
	}
}
