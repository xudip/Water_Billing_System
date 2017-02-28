package layout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class TitleBar {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TitleBar window = new TitleBar();
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
	public TitleBar() {
		initialize();
		
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(10,10, 1190, 195);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelTitleBar = new JPanel();
		panelTitleBar.setBounds(10, 11, 1154, 134);
		panelTitleBar.setBackground(new Color(204, 255, 153));
		panelTitleBar.setForeground(new Color(51, 153, 204));
		frame.getContentPane().add(panelTitleBar);
		panelTitleBar.setLayout(null);
		
		JLabel lblWaterBillingManagement = new JLabel("WATER BILLING MANAGEMENT SYSTEM");
		lblWaterBillingManagement.setForeground(new Color(0, 0, 128));
		lblWaterBillingManagement.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblWaterBillingManagement.setBounds(162, 11, 811, 49);
		panelTitleBar.add(lblWaterBillingManagement);
		
		JLabel lblKathmandu = new JLabel("ADDRESS: KATHMANDU. NEPAL");
		lblKathmandu.setForeground(SystemColor.textHighlight);
		lblKathmandu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblKathmandu.setBounds(363, 54, 287, 22);
		panelTitleBar.add(lblKathmandu);
		
		JLabel lblContact = new JLabel("CONTACT: 014444444");
		lblContact.setForeground(SystemColor.textHighlight);
		lblContact.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblContact.setBounds(391, 71, 197, 22);
		panelTitleBar.add(lblContact);
		
		JLabel lblEmail = new JLabel("Email: ktmkhanepani@gmail.com\r\n");
		lblEmail.setForeground(SystemColor.textHighlight);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblEmail.setBounds(351, 87, 302, 22);
		panelTitleBar.add(lblEmail);
	}
}
