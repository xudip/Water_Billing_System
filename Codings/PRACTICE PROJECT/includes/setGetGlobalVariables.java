package includes;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class setGetGlobalVariables {
	public static  String username;
	public static String privilege;
	public static String fileName;

	public static  void setUsername(String username, String privilege){
		setGetGlobalVariables.username = username;
		setGetGlobalVariables.privilege = privilege;
		setFileName();

	}


	public static String getUsername(){
		return(username);
	}

	public static String getPrivilege(){
		return(privilege);
	}

	public static void setFileName(){
		try{
			String sql = "";
			Connection con = DatabaseConnection.makeConnetion();
			if(privilege.equals("ADMIN")){
				 sql = "SELECT pic_filename FROM admin WHERE username = ? ";
			}
			if(privilege.equals("METERREADER")){
				 sql = "SELECT pic_filename FROM meterreader WHERE username = ? ";
			}
			if(privilege.equals("CUSTOMER")){
				 sql = "SELECT pic_filename FROM customer WHERE username = ? ";
			}


			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, getUsername());
			ResultSet rs = ps.executeQuery();
			rs.next();
			fileName = rs.getString("pic_filename");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public static String getFileName(){
		return(fileName);
	}

	public static Image fitimage(Image img, int width, int height) {
		// TODO Auto-generated method stub
		BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = resizedImage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img, 0, 0, width, height,null);
		g2.dispose();
		return (resizedImage);
	}



}
