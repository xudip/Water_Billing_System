package layout;

import java.awt.EventQueue;

import includes.DatabaseConnection;
import includes.Validations;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.time.Year;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

import actionAndEvents.InsertMeterReadingActionAndEvents;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InsertMeterReading {

	private JFrame frame;
	public static  JTextField txtId;
	public static JTextField txtUnits;
	public static JComboBox comboBoxMonth;
	public static JComboBox comboBoxYear;
	public static JComboBox comboBoxPayment;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertMeterReading window = new InsertMeterReading();
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
	public InsertMeterReading() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("INSERT DATA");
		frame.setBounds(450, 300, 450, 200);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtId.setText(null);
				txtUnits.setText(null);
			}
		});
		btnClear.setBounds(209, 99, 73, 34);
		panel.add(btnClear);

		txtId = new JTextField();
		txtId.setBounds(94, 26, 42, 20);
		panel.add(txtId);
		txtId.setColumns(10);

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
		comboBoxYear.setBounds(238, 57, 73, 20);
		panel.add(comboBoxYear);

		final JComboBox comboBoxMonth = new JComboBox();
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"}));
		comboBoxMonth.setBounds(150, 57, 78, 20);
		panel.add(comboBoxMonth);

		txtUnits = new JTextField();
		txtUnits.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				Validations.numberValidate(arg0, c);
			}
		});
		txtUnits.setColumns(10);
		txtUnits.setBounds(94, 57, 42, 20);
		panel.add(txtUnits);

		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setBounds(12, 29, 73, 14);
		panel.add(lblCustomerId);

		JLabel lblUnits = new JLabel("Units");
		lblUnits.setBounds(54, 60, 30, 14);
		panel.add(lblUnits);

		final JComboBox comboBoxPayment = new JComboBox();
		comboBoxPayment.setModel(new DefaultComboBoxModel(new String[] {"NOT PAID", "PAID"}));
		comboBoxPayment.setBounds(320, 55, 90, 22);
		panel.add(comboBoxPayment);

		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(150, 40, 78, 16);
		panel.add(lblMonth);

		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(238, 40, 73, 16);
		panel.add(lblYear);

		JLabel lblPaymentStatus = new JLabel("Payment Status");
		lblPaymentStatus.setBounds(320, 40, 90, 16);
		panel.add(lblPaymentStatus);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertMeterReadingActionAndEvents insert = new InsertMeterReadingActionAndEvents();
				if(!(txtId.getText().isEmpty() && txtUnits.getText().isEmpty() )){
				insert.setData(comboBoxMonth.getSelectedItem().toString(), comboBoxYear.getSelectedItem().toString(), comboBoxPayment.getSelectedItem().toString());
				
					int duplicateStatus = insert.checkDuplicateEntry();
					if(duplicateStatus == 0){
						insert.insertData();	
					}
					else{
						JOptionPane.showMessageDialog(null, "Data Already Exists!");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Customer Id and Units must be filled!", "Warning Incomplete Form", 2);
				}

				//			JOptionPane.showMessageDialog(null,""+ insert.getId() + insert.getMonth());
				//				JOptionPane.showMessageDialog(null, "this is the variable called by object: " + insert.getId() + insert.getMonth());

			}
		});
		btnInsert.setBounds(111, 99, 73, 34);
		panel.add(btnInsert);

	}
}
