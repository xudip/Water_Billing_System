package actionAndEvents;

import java.sql.*;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import layout.*;
import includes.*;

public class LogInActionAndEvents extends LogInLayout{

//	String checkError(String username, String password){
//		if( username.equals(null)){
//			//JOptionPane.showMessageDialog(null, "Username is Empty!");
//			return("username");
//		}
//		else
//			JOptionPane.showMessageDialog(null, "OK!");
//		return("ok");
//	}

	public static boolean checkUsername(String errorVariable){
		if(errorVariable.isEmpty()){
			JOptionPane.showMessageDialog(null, "Username is Empty!");
			txtUsername.setBackground(Color.RED);
			return (true);
		}
		else{
			txtUsername.setBackground(Color.WHITE);
			return(false);
		}
		
	}
	public static boolean checkPassword(String errorVariable){
		if(errorVariable.isEmpty()){
			JOptionPane.showMessageDialog(null, "Password is Empty!");
			txtPassword.setBackground(Color.RED);
			return (true);
		}
		else{
			txtPassword.setBackground(Color.WHITE);
			return(false);
		}
		
	}

	public static String logInAuthentication(String username, String password){
		String tblPrivilege = "";
		try{
			Connection con = DatabaseConnection.makeConnetion();
			String sql = "SELECT * FROM users WHERE username = ? AND password = ? ";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setNString(2, password);
			ResultSet rs = ps.executeQuery();	
			rs.next();
			setGetGlobalVariables.setUsername(rs.getString("username"), rs.getString("privilege") );
			System.out.println(setGetGlobalVariables.getUsername());
			rs.getString("password");
			tblPrivilege = rs.getString("privilege");

		}
		catch(Exception se){
			System.out.println(se);
			JOptionPane.showMessageDialog(null," LOGIN UnSUCCESSFULL!!");
		}
		return(tblPrivilege);

	}

	public static void setRememberMe(){

		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream("xudip.dat");

			StringBuffer sb = new StringBuffer();
			sb.append(txtUsername.getText());
			
			sb.append('\n');
			sb.append(txtPassword.getText());
			

			fos.write(sb.toString().getBytes());
			JOptionPane.showMessageDialog(null, "Remembered! :D");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void removeRemeberMe(){

		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream("xudip.dat");

			StringBuffer sb = new StringBuffer();
			sb.append("");
			
			sb.append('\n');
			sb.append("");
			

			fos.write(sb.toString().getBytes());
			JOptionPane.showMessageDialog(null, "Not Remembered! :D");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	public static void getRememberMeUsername(){
		FileInputStream fis=null;
		try{
			fis = new FileInputStream("xudip.dat");
			int s,x=1;
			String rememberedUsername = "", rememberedPassword = "";
			while((s=fis.read())!=-1){
				//JOptionPane.showMessageDialog(null,((char)s));
				if((char) s == '\n'){
					x++;
					continue;
				}
				if(x==1){
					rememberedUsername = rememberedUsername +((char) s);
				}
				if(x==2){
					rememberedPassword = rememberedPassword + ((char) s);
				}
			}
			//JOptionPane.showMessageDialog(null,"Username:" + rememberedUsername + "\n password:" + rememberedPassword );
			txtUsername.setText(rememberedUsername);
			txtPassword.setText(rememberedPassword);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
