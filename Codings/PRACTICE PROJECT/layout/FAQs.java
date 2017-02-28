package layout;

import includes.DatabaseConnection;
import includes.UserInformation;
import includes.setGetGlobalVariables;

import java.awt.Color;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import actionAndEvents.FAQsActionAndEvents;

import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;

import net.proteanit.sql.DbUtils;

import com.mysql.jdbc.Connection;
import com.sun.webkit.ContextMenu.ShowContext;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FAQs {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FAQs window = new FAQs();
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
	public FAQs() {
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

		JPanel panelFaqs = new JPanel();
		panelFaqs.setBounds(10, 11, 764, 534);
		panelFaqs.setBorder(new TitledBorder(null, "FAQs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFaqs.setBackground(new Color(204, 255, 153));
		panelFaqs.setForeground(new Color(51, 153, 204));
		frame.getContentPane().add(panelFaqs);
		panelFaqs.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 103, 744, 285);
		panelFaqs.add(scrollPane);

		table = new JTable();
		ResultSet rs = FAQsActionAndEvents.getData();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// System.out.println(table.getRowCount());
				//System.out.println(table.getModel().getValueAt(table.getRowCount(), 0));
				if(table.isEnabled())
				{
					int row = table.getSelectedRow();
					int column = 0;
					int id = (Integer) table.getValueAt(row, column);
					FAQsActionAndEvents.setId(id);
					
				}

			}
		});
		table.setBackground(new Color(204, 255, 153));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(54);
		table.setAlignmentX(12.0f);
		table.setFocusable(false);
		table.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table);

		JPanel panelUserInformation = new JPanel();
		panelUserInformation.setLayout(null);
		panelUserInformation.setBackground(new Color(204, 255, 153));
		panelUserInformation.setBounds(518, 12, 234, 92);
		panelFaqs.add(panelUserInformation);

		JButton btnLogOut = new JButton("Log Out");
		UserInformation.getBtnLogOut(btnLogOut, frame);
		panelUserInformation.add(btnLogOut);

		JButton btnHome = new JButton("Home");
		UserInformation.getBtnHome(btnHome, frame);
		panelUserInformation.add(btnHome);

		JLabel lblUsername = new JLabel("lblUsername");
		UserInformation.getlblUsername(lblUsername);
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

		final JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = FAQsActionAndEvents.getId();
				//JOptionPane.showMessageDialog(null, "READY TO DELETE! id = " + id);
				FAQsActionAndEvents.delete(id);
				ResultSet rs = FAQsActionAndEvents.getData();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				table.repaint();
				table.clearSelection();
			}
		});
		btnDelete.setBounds(432, 419, 89, 23);
		panelFaqs.add(btnDelete);
		
		JButton btnAnswer = new JButton("Answer");
		btnAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FAQsActionAndEvents.view(FAQsActionAndEvents.getId());
				ResultSet rs = FAQsActionAndEvents.getData();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				table.repaint();
				table.setFocusable(false);
				table.setRowSelectionAllowed(true);
			}
		});

		btnAnswer.setBounds(554, 419, 89, 23);
		panelFaqs.add(btnAnswer);
		//table.getColumnModel().getColumn(5).setPreferredWidth(120);
	}
}
