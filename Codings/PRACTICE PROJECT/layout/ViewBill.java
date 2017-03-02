package layout;

import includes.UserInformation;
import includes.Validations;
import includes.setGetGlobalVariables;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PrintJob;

import javafx.scene.control.ComboBox;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JSlider;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JSplitPane;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.TitledBorder;

import actionAndEvents.ViewBillActionAndEvents;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.MessageFormat;
import java.time.Year;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.SwingConstants;

import com.sun.javafx.tk.Toolkit;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class ViewBill {

	protected static JFrame frame;
	protected static JTextField txtEmail;
	protected static JTextField txtBillId;
	protected static JTextField txtName;
	protected static JTextField txtAreaNo;
	protected static JTextField txtMonth;
	protected static JTextField txtRate;
	protected static JTextField txtUnits;
	protected static JTextField txtFine;
	protected static JTextField txtDiscount;
	protected static JTextField txtTotalAmount;
	protected static JTextField txtTotalAmountIn;

	protected static JLabel lblPaid;
	protected static JButton btnPay;
	private JTextField txtId;
	protected static JTextField txtYear;

	protected static int id;
	private static JPanel panelBill;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBill window = new ViewBill();
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
	public ViewBill() {
		initialize();	

		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds( 385, 100, 800, 595);
		frame.setTitle("WATER BILLING MANAGEMENT SYSTEM");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelViewBill = new JPanel();
		panelViewBill.setBorder(new TitledBorder(null, "VIEW BILL", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelViewBill.setBackground(new Color(204, 255, 153));
		panelViewBill.setForeground(new Color(51, 153, 204));
		panelViewBill.setBounds(4, 11, 776, 534);
		frame.getContentPane().add(panelViewBill);
		panelViewBill.setLayout(null);

		panelBill =new JPanel();
		panelBill.setBounds(10, 99, 764, 272);
		panelViewBill.add(panelBill);
		panelBill.setBorder(new LineBorder(new Color(0, 0, 255)));

		panelBill.setForeground(new Color(0, 0, 255));
		panelBill.setBackground(new Color(255, 105, 180));
		panelBill.setLayout(null);

		JPanel panelTitle = new JPanel();
		panelTitle.setBorder(new LineBorder(new Color(0, 0, 255)));
		panelTitle.setForeground(new Color(0, 0, 255));
		panelTitle.setBackground(new Color(255, 105, 180));
		panelTitle.setBounds(10, 11, 347, 88);
		panelBill.add(panelTitle);
		panelTitle.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(169, 87, 1, 1);
		panelTitle.add(layeredPane);

		JLabel lblKtmKhanepaniLimited = new JLabel("KTM Khanepani  Limited");
		lblKtmKhanepaniLimited.setForeground(new Color(0, 0, 255));
		lblKtmKhanepaniLimited.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblKtmKhanepaniLimited.setBounds(65, 11, 203, 22);
		panelTitle.add(lblKtmKhanepaniLimited);

		JLabel lblTripureshworMargaKathmandu = new JLabel("Tripureshwor Marga, Kathmandu");
		lblTripureshworMargaKathmandu.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblTripureshworMargaKathmandu.setForeground(new Color(0, 0, 255));
		lblTripureshworMargaKathmandu.setBounds(90, 29, 157, 14);
		panelTitle.add(lblTripureshworMargaKathmandu);

		Date date = new Date(System.currentTimeMillis());

		JLabel lblCurrentDate = new JLabel(date.toString());
		lblCurrentDate.setForeground(new Color(0, 0, 255));
		lblCurrentDate.setBounds(263, 63, 74, 14);
		panelTitle.add(lblCurrentDate);

		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(0, 0, 255));
		lblDate.setBounds(207, 61, 46, 14);
		panelTitle.add(lblDate);

		JLabel lblId = new JLabel("ID: ");
		lblId.setBounds(12, 63, 46, 14);
		panelTitle.add(lblId);
		lblId.setForeground(new Color(0, 0, 255));

		txtBillId = new JTextField();
		txtBillId.setHorizontalAlignment(SwingConstants.CENTER);
		txtBillId.setBounds(64, 60, 74, 20);
		panelTitle.add(txtBillId);
		txtBillId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				int id =Integer.parseInt(txtBillId.getText());
				//				String month = valueAt(combobox.getSelectedItem())
				ViewBillActionAndEvents.setId(id);
				//				ViewBillActionAndEvents.getBill(id, month, year);
			}
		});
		txtBillId.setBorder(new LineBorder(new Color(0, 0, 255)));
		txtBillId.setForeground(new Color(0, 0, 0));
		txtBillId.setBackground(new Color(255, 105, 180));
		txtBillId.setSelectedTextColor(Color.CYAN);
		txtBillId.setText("Bill Id");
		txtBillId.setColumns(10);

		JPanel panelForm = new JPanel();
		panelForm.setBorder(new LineBorder(new Color(0, 0, 255)));
		panelForm.setForeground(new Color(0, 0, 255));
		panelForm.setBackground(new Color(255, 105, 180));
		panelForm.setBounds(10, 97, 347, 164);
		panelBill.add(panelForm);
		panelForm.setLayout(null);

		JLabel lblName = new JLabel("Name: ");
		lblName.setForeground(new Color(0, 0, 255));
		lblName.setBounds(10, 11, 46, 14);
		panelForm.add(lblName);

		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.alphabetValidate(e, c);
			}
		});
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setBorder(new LineBorder(new Color(0, 0, 255)));
		txtName.setBackground(new Color(255, 105, 180));
		txtName.setForeground(new Color(0, 0, 0));
		txtName.setText("Name");
		txtName.setBounds(66, 8, 177, 20);
		panelForm.add(txtName);
		txtName.setColumns(10);

		txtAreaNo = new JTextField();
		txtAreaNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtAreaNo.setBorder(new LineBorder(new Color(0, 0, 255)));
		txtAreaNo.setBackground(new Color(255, 105, 180));
		txtAreaNo.setForeground(new Color(0, 0, 0));
		txtAreaNo.setText("Area No.");
		txtAreaNo.setBounds(66, 40, 177, 20);
		panelForm.add(txtAreaNo);
		txtAreaNo.setColumns(10);

		JLabel lblAreaNo = new JLabel("Area No.: ");
		lblAreaNo.setForeground(new Color(0, 0, 255));
		lblAreaNo.setBounds(10, 43, 46, 14);
		panelForm.add(lblAreaNo);

		txtMonth = new JTextField();
		txtMonth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.alphabetValidate(e, c);
			}
		});
		txtMonth.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonth.setBorder(new LineBorder(new Color(0, 0, 255)));
		txtMonth.setBackground(new Color(255, 105, 180));
		txtMonth.setForeground(new Color(0, 0, 0));
		txtMonth.setText("Month");
		txtMonth.setBounds(66, 72, 119, 20);
		panelForm.add(txtMonth);
		txtMonth.setColumns(10);

		JLabel lblMonth = new JLabel("Month: ");
		lblMonth.setForeground(new Color(0, 0, 255));
		lblMonth.setBounds(10, 75, 46, 14);
		panelForm.add(lblMonth);

		lblPaid = new JLabel("PAID");
		lblPaid.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPaid.setForeground(Color.RED);
		lblPaid.setFont(new Font("Dialog", Font.BOLD, 50));
		lblPaid.setBounds(76, 104, 144, 36);
		lblPaid.setVisible(false);
		panelForm.add(lblPaid);

		txtYear = new JTextField();
		txtYear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.numberValidate(e, c);
			}
		});
		txtYear.setBorder(new LineBorder(new Color(0, 0, 255)));
		txtYear.setBackground(new Color(255, 105, 180));
		txtYear.setText("Year");
		txtYear.setBounds(255, 72, 64, 20);
		panelForm.add(txtYear);
		txtYear.setColumns(10);

		JLabel lblYear = new JLabel("Year:");
		lblYear.setForeground(new Color(0, 0, 255));
		lblYear.setBounds(217, 72, 34, 16);
		panelForm.add(lblYear);

		JPanel panelWaterConsumption = new JPanel();
		panelWaterConsumption.setBorder(new LineBorder(new Color(0, 0, 255)));
		panelWaterConsumption.setForeground(new Color(0, 0, 255));
		panelWaterConsumption.setBackground(new Color(255, 105, 180));
		panelWaterConsumption.setBounds(356, 11, 104, 177);
		panelBill.add(panelWaterConsumption);
		panelWaterConsumption.setLayout(null);

		JLabel lblWaterConsumption = new JLabel("Water Consumption in Units ");
		lblWaterConsumption.setForeground(new Color(0, 0, 255));
		lblWaterConsumption.setBounds(10, 11, 84, 14);
		panelWaterConsumption.add(lblWaterConsumption);

		JPanel panelRate = new JPanel();
		panelRate.setBackground(new Color(255, 105, 180));
		panelRate.setBorder(new LineBorder(new Color(0, 0, 255)));
		panelRate.setBounds(0, 30, 52, 147);
		panelWaterConsumption.add(panelRate);
		panelRate.setLayout(null);

		JLabel lblRate = new JLabel("Rate");
		lblRate.setForeground(new Color(0, 0, 255));
		lblRate.setBounds(10, 11, 32, 14);
		panelRate.add(lblRate);

		txtRate = new JTextField();
		txtRate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				ViewBillActionAndEvents.calculateTotalAmount();

			}
		});
		txtRate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.numberValidate(e, c);
			}
		});
		txtRate.setHorizontalAlignment(SwingConstants.CENTER);
		txtRate.setBorder(new LineBorder(new Color(0, 0, 255)));
		txtRate.setBackground(new Color(255, 105, 180));
		txtRate.setForeground(new Color(0, 0, 0));
		txtRate.setText("0");
		txtRate.setBounds(0, 25, 52, 122);
		panelRate.add(txtRate);
		txtRate.setColumns(10);

		JPanel panelUnits = new JPanel();
		panelUnits.setBackground(new Color(255, 105, 180));
		panelUnits.setBorder(new LineBorder(new Color(0, 0, 255)));
		panelUnits.setBounds(52, 30, 51, 147);
		panelWaterConsumption.add(panelUnits);
		panelUnits.setLayout(null);

		JLabel lblUnits = new JLabel("Units");
		lblUnits.setForeground(new Color(0, 0, 255));
		lblUnits.setBounds(10, 11, 31, 14);
		panelUnits.add(lblUnits);

		txtUnits = new JTextField();
		txtUnits.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ViewBillActionAndEvents.calculateTotalAmount();
			}
		});
		txtUnits.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.numberValidate(e, c);
			}
		});
		txtUnits.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnits.setBorder(new LineBorder(new Color(0, 0, 255)));
		txtUnits.setBackground(new Color(255, 105, 180));
		txtUnits.setForeground(new Color(0, 0, 0));
		txtUnits.setText("0");
		txtUnits.setColumns(10);
		txtUnits.setBounds(0, 25, 50, 121);
		panelUnits.add(txtUnits);

		JPanel panelFine = new JPanel();
		panelFine.setBorder(new LineBorder(new Color(0, 0, 255)));
		panelFine.setForeground(new Color(0, 0, 255));
		panelFine.setBackground(new Color(255, 105, 180));
		panelFine.setLayout(null);
		panelFine.setBounds(458, 11, 104, 177);
		panelBill.add(panelFine);

		JLabel lblFine = new JLabel("FIne in Rs.");
		lblFine.setForeground(new Color(0, 0, 255));
		lblFine.setBounds(10, 11, 84, 14);
		panelFine.add(lblFine);

		txtFine = new JTextField();
		txtFine.setText("0");
		txtFine.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ViewBillActionAndEvents.calculateTotalAmount();
			}
		});
		txtFine.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.numberValidate(e, c);
			}
		});
		txtFine.setHorizontalAlignment(SwingConstants.CENTER);
		txtFine.setBorder(new LineBorder(new Color(0, 0, 255)));
		txtFine.setBackground(new Color(255, 105, 180));
		txtFine.setForeground(new Color(0, 0, 0));
		txtFine.setBounds(0, 56, 104, 121);
		panelFine.add(txtFine);
		txtFine.setColumns(10);

		JPanel panelDiscount = new JPanel();
		panelDiscount.setBorder(new LineBorder(new Color(0, 0, 255)));
		panelDiscount.setForeground(new Color(0, 0, 255));
		panelDiscount.setBackground(new Color(255, 105, 180));
		panelDiscount.setLayout(null);
		panelDiscount.setBounds(560, 11, 106, 177);
		panelBill.add(panelDiscount);

		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setForeground(new Color(0, 0, 255));
		lblDiscount.setBounds(10, 11, 84, 14);
		panelDiscount.add(lblDiscount);

		txtDiscount = new JTextField();
		txtDiscount.setText("0");
		txtDiscount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ViewBillActionAndEvents.calculateTotalAmount();
			}
		});
		txtDiscount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.numberValidate(e, c);
			}
		});
		txtDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiscount.setBorder(new LineBorder(new Color(0, 0, 255)));
		txtDiscount.setBackground(new Color(255, 105, 180));
		txtDiscount.setForeground(new Color(0, 0, 0));
		txtDiscount.setColumns(10);
		txtDiscount.setBounds(0, 56, 104, 121);
		panelDiscount.add(txtDiscount);

		JPanel panelTotalAmount = new JPanel();
		panelTotalAmount.setBorder(new LineBorder(new Color(0, 0, 255)));
		panelTotalAmount.setForeground(new Color(0, 0, 255));
		panelTotalAmount.setBackground(new Color(255, 105, 180));
		panelTotalAmount.setLayout(null);
		panelTotalAmount.setBounds(662, 11, 92, 177);
		panelBill.add(panelTotalAmount);

		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setForeground(new Color(0, 0, 255));
		lblTotalAmount.setBounds(10, 11, 72, 14);
		panelTotalAmount.add(lblTotalAmount);

		txtTotalAmount = new JTextField();
		txtTotalAmount.setText("0");
		txtTotalAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.numberValidate(e, c);
			}
		});
		txtTotalAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalAmount.setBorder(new LineBorder(new Color(0, 0, 255)));
		txtTotalAmount.setBackground(new Color(255, 105, 180));
		txtTotalAmount.setForeground(new Color(0, 0, 0));
		txtTotalAmount.setColumns(10);
		txtTotalAmount.setBounds(0, 56, 92, 121);
		panelTotalAmount.add(txtTotalAmount);

		JPanel panelTotalAmountInWords = new JPanel();
		panelTotalAmountInWords.setBorder(new LineBorder(new Color(0, 0, 255)));
		panelTotalAmountInWords.setForeground(new Color(0, 0, 255));
		panelTotalAmountInWords.setBackground(new Color(255, 105, 180));
		panelTotalAmountInWords.setLayout(null);
		panelTotalAmountInWords.setBounds(356, 187, 398, 74);
		panelBill.add(panelTotalAmountInWords);

		JLabel lblTotalAmountIn = new JLabel("Total Amount in Words: ");
		lblTotalAmountIn.setForeground(new Color(0, 0, 255));
		lblTotalAmountIn.setBounds(10, 30, 116, 14);
		panelTotalAmountInWords.add(lblTotalAmountIn);

		txtTotalAmountIn = new JTextField();
		txtTotalAmountIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				Validations.alphabetValidate(e, c);
			}
		});
		txtTotalAmountIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalAmountIn.setBorder(new LineBorder(new Color(0, 0, 255)));
		txtTotalAmountIn.setBackground(new Color(255, 105, 180));
		txtTotalAmountIn.setForeground(new Color(0, 0, 0));
		txtTotalAmountIn.setText("Total Amount In Words");
		txtTotalAmountIn.setBounds(136, 27, 252, 20);
		panelTotalAmountInWords.add(txtTotalAmountIn);
		txtTotalAmountIn.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setBounds(420, 399, 144, 28);
		panelViewBill.add(txtEmail);
		txtEmail.setBorder(new LineBorder(new Color(0, 0, 255)));
		txtEmail.setBackground(new Color(255, 255, 255));
		txtEmail.setForeground(new Color(0, 0, 0));
		txtEmail.setText("Email");
		txtEmail.setColumns(10);

		JButton btnForwardViaMail = new JButton("Forward Via Mail");
		btnForwardViaMail.setBounds(319, 402, 89, 23);
		panelViewBill.add(btnForwardViaMail);

		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "READY TO PRINT");
				printComponenet();
			}
		});

		btnPrint.setBounds(208, 402, 89, 23);
		panelViewBill.add(btnPrint);

		JPanel panelUserInformation = new JPanel();
		panelUserInformation.setLayout(null);
		panelUserInformation.setBackground(new Color(204, 255, 153));
		panelUserInformation.setBounds(532, 11, 234, 83);
		panelViewBill.add(panelUserInformation);

		JButton btnLogOut = new JButton("Log Out");
		UserInformation.getBtnLogOut(btnLogOut, frame);
		panelUserInformation.add(btnLogOut);

		JButton btnHome = new JButton("Home");
		UserInformation.getBtnHome(btnHome, frame);
		panelUserInformation.add(btnHome);

		JLabel lblUsername = new JLabel(setGetGlobalVariables.getUsername());
		lblUsername.setBounds(99, 19, 58, 16);
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
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewBillActionAndEvents.clearData();
			}
		});
		btnClear.setBounds(613, 402, 89, 23);
		panelViewBill.add(btnClear);

		txtId = new JTextField();
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setColumns(10);
		txtId.setBounds(47, 62, 86, 20);
		if(setGetGlobalVariables.getPrivilege().equals("CUSTOMER")){
			txtId.setVisible(false);
		}
		panelViewBill.add(txtId);

		final JComboBox comboBoxMonth = new JComboBox();
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"}));
		comboBoxMonth.setBounds(143, 62, 89, 20);
		panelViewBill.add(comboBoxMonth);

		final JComboBox comboBoxYear = new JComboBox();
		Vector<Integer> year;
		year = new Vector <Integer>(10);
		int finalYear;
		finalYear = Year.now().getValue();
		int i;	
		for( i = finalYear ; i >= 1990 ; i-- ){
			year.add(i);

		}
		comboBoxYear.setModel(new DefaultComboBoxModel(year));
		comboBoxYear.setBounds(242, 62, 89, 20);
		panelViewBill.add(comboBoxYear);

		if(setGetGlobalVariables.getPrivilege().equals("ADMIN")){

			JLabel lblAcceptedBy = new JLabel("Accepted By: ");
			lblAcceptedBy.setForeground(new Color(0, 0, 255));
			lblAcceptedBy.setBounds(178, 139, 77, 16);
			panelForm.add(lblAcceptedBy);

			btnPay = new JButton("Pay");
			//btnPay.setEnabled(false);
			btnPay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int billId = Integer.parseInt( txtBillId.getText());
					String billMonth = String.valueOf(txtMonth.getText());
					int billYear =  Integer.parseInt(txtYear.getText());
					ViewBillActionAndEvents.pay(billId, billMonth, billYear );
					boolean flag = ViewBillActionAndEvents.getBill(billId, billMonth, billYear);
				}
			});
			btnPay.setBounds(96, 402, 89, 23);
			panelViewBill.add(btnPay);
		}


		JButton btnViewBill = new JButton("View Bill");
		btnViewBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(setGetGlobalVariables.getPrivilege().equals("CUSTOMER")){
					id = ViewBillActionAndEvents.getId();
					//					JOptionPane.showMessageDialog(null, id);
				}
				else{
					id = Integer.parseInt( txtId.getText());
				}
				String month = String.valueOf(comboBoxMonth.getSelectedItem());
				int year = Integer.valueOf((Integer) comboBoxYear.getSelectedItem());

				if(ViewBillActionAndEvents.getBill(id, month, year) == false){	
					JOptionPane.showMessageDialog(null,"View Bill Fail");
					ViewBillActionAndEvents.clearData();
				}

			}
		});
		btnViewBill.setBounds(335, 51, 99, 36);
		panelViewBill.add(btnViewBill);
	}

	private void PritnActionPerformed(java.awt.event.ActionEvent evt) {
	    // TODO add your handling code here:
	    java.awt.Toolkit tkp = panelBill.getToolkit();
	    PrintJob pjp = tkp.getPrintJob(frame, null, null);
	    Graphics g = pjp.getGraphics();
	    panelBill.print(g);
	    g.dispose();
	    pjp.end();
	}
//	adding the print function
	public void printComponenet(){

		  PrinterJob pj = PrinterJob.getPrinterJob();
		  pj.setJobName(" Print Component ");

		  pj.setPrintable (new Printable() {    
		    public int print(Graphics pg, PageFormat pf, int pageNum){
		      if (pageNum > 0){
		      return Printable.NO_SUCH_PAGE;
		      }

		      Graphics2D g2 = (Graphics2D) pg;
		      g2.translate(pf.getImageableX(), pf.getImageableY());
		      panelBill.paint(g2);
		      return Printable.PAGE_EXISTS;
		    }
		  });
		  if (pj.printDialog() == false)
		  return;

		  try {
		        pj.print();
		  } catch (PrinterException ex) {
		        // handle exception
		  }
		}
	
	

}
