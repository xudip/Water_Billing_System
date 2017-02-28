package layout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTree;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;

public class GetSideBar {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetSideBar window = new GetSideBar();
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
	public GetSideBar() {
		initialize();	
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(12, 100, 385, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPaneGetSideBar = new JScrollPane();
		scrollPaneGetSideBar.setAutoscrolls(true);
		scrollPaneGetSideBar.setBounds(10, 10, 350, 540);
		scrollPaneGetSideBar.setBackground(new Color(204, 255, 153));		
		scrollPaneGetSideBar.setForeground(new Color(51, 153, 204));
		frame.getContentPane().add(scrollPaneGetSideBar);
		
		JTree tree = new JTree();
		tree.setForeground(Color.WHITE);
		tree.setBackground(SystemColor.inactiveCaptionBorder);
		tree.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.BLUE));
		tree.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("HOME") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					node_1 = new DefaultMutableTreeNode("MANAGE USER");
						node_2 = new DefaultMutableTreeNode("MANAGEN CUSTOMER");
							node_2.add(new DefaultMutableTreeNode("ADD CUSTOMER "));
							node_2.add(new DefaultMutableTreeNode("VIEW CUSTOMER"));
							node_2.add(new DefaultMutableTreeNode("UPDATE/DELETE CUSTOMER"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("MANAGE METERREADER");
							node_2.add(new DefaultMutableTreeNode("ADD METERREADER"));
							node_2.add(new DefaultMutableTreeNode("VIEW METERREADER"));
							node_2.add(new DefaultMutableTreeNode("UPDATE/DELETE METERREADER"));
						node_1.add(node_2);
					add(node_1);
					add(new DefaultMutableTreeNode("MANAGE BILLS COMPONENTS"));
					add(new DefaultMutableTreeNode("VIEW BILL"));
					node_1 = new DefaultMutableTreeNode("SETTINGS");
						node_1.add(new DefaultMutableTreeNode("EDIT PROFILE INFORMATION"));
						node_1.add(new DefaultMutableTreeNode("CHANGE PASSWORD "));
					add(node_1);
					add(new DefaultMutableTreeNode("FAQS"));
					add(new DefaultMutableTreeNode("ABOUT US"));
				}
			}
		));
		scrollPaneGetSideBar.setViewportView(tree);
	}
}
