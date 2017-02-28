package layout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class ViewReport {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewReport window = new ViewReport();
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
	public ViewReport() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds( 385, 100, 800, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 153));
		panel.setBorder(new TitledBorder(null, "View Report", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 784, 544);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(127, 94, 46, 14);
		panel.add(lblFrom);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(127, 135, 46, 14);
		panel.add(lblTo);
		
		JComboBox comboBoxFromMonth = new JComboBox();
		comboBoxFromMonth.setModel(new DefaultComboBoxModel(new String[] {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"}));
		comboBoxFromMonth.setBounds(183, 91, 80, 20);
		panel.add(comboBoxFromMonth);
		
		JComboBox comboBoxToMonth = new JComboBox();
		comboBoxToMonth.setModel(new DefaultComboBoxModel(new String[] {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"}));
		comboBoxToMonth.setBounds(183, 132, 80, 20);
		panel.add(comboBoxToMonth);
		
		JComboBox comboBoxFromYear = new JComboBox();
		comboBoxFromYear.setBounds(293, 91, 80, 20);
		panel.add(comboBoxFromYear);
		
		JComboBox comboBoxToYear = new JComboBox();
		comboBoxToYear.setBounds(293, 132, 80, 20);
		panel.add(comboBoxToYear);
		
		JButton btnViewReport = new JButton("View Report");
		btnViewReport.setBounds(418, 105, 109, 30);
		panel.add(btnViewReport);
		
		JPanel panelReport = new JPanel();
		panelReport.setBorder(new TitledBorder(null, "Report", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelReport.setBackground(new Color(204, 255, 204));
		panelReport.setBounds(10, 198, 764, 335);
		panel.add(panelReport);
		panelReport.setLayout(null);
	}
}
