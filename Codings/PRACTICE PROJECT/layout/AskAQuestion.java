package layout;

import includes.UserInformation;
import includes.setGetGlobalVariables;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import actionAndEvents.AskAQuestionActionAndEvents;
import actionAndEvents.ViewCustomerActionAndEvents;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.UIManager;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.io.File;
import java.sql.ResultSet;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class AskAQuestion {

	protected JFrame frame;
	protected static JTextField txtFieldFrom;
	protected static JTextField txtFieldSubject;
	protected static JTextArea txtAreaQuestion;
	protected static JTextField txtSubjectAdvancedSearch;
	protected static JTable table;
	protected static JTextField txtQuestionAdvancedSearch;
	protected static JTextField txtAnswerdvancedSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AskAQuestion window = new AskAQuestion();
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
	public AskAQuestion() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 255, 153));
		frame.setResizable(false);
		frame.setTitle("WATER BILLING MANAGEMENT SYSTEM");
		frame.setBounds( 385, 100, 800, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Ask A Question", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(204, 255, 153));
		panel.setBounds(0, 0, 784, 556);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Send A Question", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(23, 113, 348, 431);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblFrom = new JLabel("FROM:");
		lblFrom.setBounds(24, 34, 69, 25);
		panel_1.add(lblFrom);

		txtFieldFrom = new JTextField(setGetGlobalVariables.getUsername());
		txtFieldFrom.setForeground(Color.DARK_GRAY);
		txtFieldFrom.setEnabled(false);
		txtFieldFrom.setBounds(103, 36, 235, 34);
		panel_1.add(txtFieldFrom);
		txtFieldFrom.setColumns(10);

		JLabel lblQuestion = new JLabel("QUESTION:");
		lblQuestion.setBounds(24, 131, 69, 14);
		panel_1.add(lblQuestion);

		txtFieldSubject = new JTextField();
		txtFieldSubject.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtFieldSubject.setForeground(Color.DARK_GRAY);
		txtFieldSubject.setColumns(10);
		txtFieldSubject.setBounds(103, 81, 235, 34);
		panel_1.add(txtFieldSubject);

		JLabel lblSubject = new JLabel("SUBJECT");
		lblSubject.setBounds(24, 91, 69, 14);
		panel_1.add(lblSubject);

		txtAreaQuestion = new JTextArea();
		txtAreaQuestion.setBounds(103, 126, 235, 258);
		panel_1.add(txtAreaQuestion);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFieldSubject.setText(null);
				txtAreaQuestion.setText(null);
			}
		});
		btnClear.setBounds(247, 396, 89, 23);
		panel_1.add(btnClear);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AskAQuestionActionAndEvents.setData();
				int error = AskAQuestionActionAndEvents.checkError();
				if(error == 0){
					AskAQuestionActionAndEvents.insertData();
				}
				else{
					JOptionPane.showMessageDialog(null,"Question not sent.", "Question Status", 2, null);
				}
			}
		});
		btnSend.setBounds(138, 396, 89, 23);
		panel_1.add(btnSend);
		
		JPanel faqReplies = new JPanel();
		faqReplies.setLayout(null);
		faqReplies.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "FAQs Replies", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		faqReplies.setBounds(383, 113, 374, 431);
		panel.add(faqReplies);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AskAQuestionActionAndEvents.view(AskAQuestionActionAndEvents.getId());
//				AskAQuestionActionAndEvents setData = new ViewCustomerActionAndEvents();
				table.repaint();
			}
		});
		btnView.setBounds(173, 22, 89, 23);
		faqReplies.add(btnView);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultSet rs = AskAQuestionActionAndEvents.getTableData();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				table.repaint();
			}
		});
		btnRefresh.setBounds(64, 22, 89, 23);
		faqReplies.add(btnRefresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 328, 232);
		faqReplies.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.isEnabled())
				{
					int row = table.getSelectedRow();
					int column = 0;
					int id = (Integer) table.getValueAt(row, column);
					AskAQuestionActionAndEvents.setId(id);
//					txtId.setText(""+id);
				}
			}
		});
//		ResultSet rs = AskAQuestionActionAndEvents.getTableData();
//		table.setModel(DbUtils.resultSetToTableModel(rs));
		scrollPane.setViewportView(table);
		
		txtSubjectAdvancedSearch = new JTextField();
		txtSubjectAdvancedSearch.setBounds(64, 322, 198, 20);
		faqReplies.add(txtSubjectAdvancedSearch);
		txtSubjectAdvancedSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = AskAQuestionActionAndEvents.advancedSearch();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				table.repaint();
			}
		});
		btnSearch.setBounds(273, 360, 89, 23);
		faqReplies.add(btnSearch);
		
		txtQuestionAdvancedSearch = new JTextField();
		txtQuestionAdvancedSearch.setColumns(10);
		txtQuestionAdvancedSearch.setBounds(64, 354, 198, 20);
		faqReplies.add(txtQuestionAdvancedSearch);
		
		txtAnswerdvancedSearch = new JTextField();
		txtAnswerdvancedSearch.setColumns(10);
		txtAnswerdvancedSearch.setBounds(64, 388, 198, 20);
		faqReplies.add(txtAnswerdvancedSearch);
		
		JLabel lblSubject_1 = new JLabel("Subject:");
		lblSubject_1.setBounds(10, 324, 55, 16);
		faqReplies.add(lblSubject_1);
		
		JLabel lblQuestion_1 = new JLabel("Question");
		lblQuestion_1.setBounds(10, 356, 55, 16);
		faqReplies.add(lblQuestion_1);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(10, 390, 55, 16);
		faqReplies.add(lblAnswer);
		
		JPanel panelUserInformation = new JPanel();
		panelUserInformation.setBackground(new Color(204, 255, 153));
		panelUserInformation.setBounds(517, 11, 257, 87);
		panel.add(panelUserInformation);
		panelUserInformation.setLayout(null);
		
		JLabel lblImagepreview = new JLabel("");
		lblImagepreview.setBounds(37, 0, 50, 41);
		BufferedImage image = null;
		try{
			image = ImageIO.read(new File("userphoto\\" + setGetGlobalVariables.fileName));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		ImageIcon imageIcon = new ImageIcon(setGetGlobalVariables.fitimage(image, lblImagepreview.getWidth(), lblImagepreview.getHeight()));
		lblImagepreview.setIcon(imageIcon);
		panelUserInformation.add(lblImagepreview);
		
		JLabel lblUsername = new JLabel(setGetGlobalVariables.getUsername());
		lblUsername.setBounds(111, 21, 46, 14);
		panelUserInformation.add(lblUsername);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInformation.logOut(frame);
			}
		});
		btnLogOut.setBounds(10, 53, 89, 23);
		panelUserInformation.add(btnLogOut);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInformation.home(frame);
			}
		});
		btnHome.setBounds(158, 53, 89, 23);
		panelUserInformation.add(btnHome);
	}
}
