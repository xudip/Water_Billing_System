package includes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import actionAndEvents.EditProfileActionAndEvents;
import actionAndEvents.FAQsActionAndEvents;
import layout.AdminHome;
import layout.CustomerHome;
import layout.LogInLayout;
import layout.MeterReaderHome;

public class UserInformation{

	public static void getBtnLogOut(JButton btnLogOut, final JFrame frame){
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserInformation.logOut(frame);
			}
		});
		btnLogOut.setBounds(12, 48, 89, 35);
	}
	
	public static void getBtnHome(JButton btnHome, final JFrame frame){
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserInformation.home(frame);
			}
		});
		btnHome.setBounds(133, 48, 89, 35);
	}
	
	public static void getImagePreview(JLabel lblImagePreview){
		BufferedImage image = null;
		try{
			image = ImageIO.read(new File("userphoto\\" + setGetGlobalVariables.fileName));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		ImageIcon imageIcon = new ImageIcon(setGetGlobalVariables.fitimage(image, lblImagePreview.getWidth(), lblImagePreview.getHeight()));
		lblImagePreview.setIcon(imageIcon);
	}
	
	
	public static void getlblUsername(JLabel lblUsername){
		lblUsername.setText(setGetGlobalVariables.getUsername());
		lblUsername.setBounds(625, 20, 58, 16);
	}
	
	
	public static void getlblImagePreview(JLabel lblImagePreview ){
//		lblImagePreview.setIcon()
//		lblImagePreview.setIcon("" + setGetGlobalVariables.getFileName());
		lblImagePreview.setText(setGetGlobalVariables.getFileName());
		lblImagePreview.setBounds(625, 30, 58, 16);
//		JOptionPane.showMessageDialog(null, setGetGlobalVariables.fileName);
		lblImagePreview.setIcon(new ImageIcon ("userphoto\\" + setGetGlobalVariables.fileName));

		/*BufferedImage image = null;
		try{
			image = ImageIO.read(new File("userphoto\\" + setGetGlobalVariables.fileName));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		ImageIcon imageIcon = new ImageIcon(FAQsActionAndEvents.fitimage(image, lblImagePreview.getWidth(), lblImagePreview.getHeight()));
		lblImagePreview.setIcon(imageIcon);*/
		
	}
	
	public static void logOut(JFrame frame){
		setGetGlobalVariables.setUsername(null, "");
		setGetGlobalVariables.fileName = "";
		EditProfileActionAndEvents.clearData();
		frame.dispose();
		LogInLayout lil = new LogInLayout();
	}
	
	public static void home(JFrame frame){
		String privilege = setGetGlobalVariables.getPrivilege();
		if(privilege.equals("ADMIN")){
			AdminHome ah = new AdminHome();
		}
		else if(privilege.equals("METERREADER")){
			MeterReaderHome mh = new MeterReaderHome();
		}
		else{
			CustomerHome ch = new CustomerHome();
//			JOptionPane.showMessageDialog(null, "CUSTOMER HOME");
		}
		frame.dispose();
	}
}
