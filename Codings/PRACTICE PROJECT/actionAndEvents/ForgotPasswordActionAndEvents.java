package actionAndEvents;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.Connection;

import includes.*;
import layout.ForgotPassword;

public class ForgotPasswordActionAndEvents extends ForgotPassword {
	private static String status;
	private static String username;
	private static String privilege;
	public static  void checkUsername() {
		// TODO Auto-generated method stub
		Connection con;
		String sqlCheckUsername;
		try{
			con = (Connection) DatabaseConnection.makeConnetion();
			sqlCheckUsername = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = con.prepareStatement(sqlCheckUsername);
			ps.setString(1, txtUsername.getText());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				setStatus("ENTRY");
				username = txtUsername.getText();
				setPrivilege(rs.getString("privilege"));
//				JOptionPane.showMessageDialog(null, getPrivilege());

			}
			//			setGetGlobalVariables uname = new setGetGlobalVariables();
			//			uname.setUsername(rs.getString("username"), rs.getString("privilege"));

		}
		catch(SQLException se){
			System.out.println(se);
			JOptionPane.showMessageDialog(null, "Error in DataBase.");
			setStatus("NO ENTRY");
		}
	}

	public static void setUsername() {

		// TODO Auto-generated method stub
		String username = txtUsername.getText();

	}


	public static String retrieveSecurityQuestion() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		try{
			String sqlCheckUsername = null;
			Connection con = (Connection) DatabaseConnection.makeConnetion();
			if(ForgotPasswordActionAndEvents.getPrivilege().equals("ADMIN")){
				sqlCheckUsername = "SELECT * FROM admin  WHERE username = ?";
			}
			if(ForgotPasswordActionAndEvents.getPrivilege().equals("CUSTOMER")){
				sqlCheckUsername = "SELECT * FROM customer  WHERE username = ?";
			}
			if(ForgotPasswordActionAndEvents.getPrivilege().equals("METERREADER")){
				sqlCheckUsername = "SELECT * FROM meterreader  WHERE username = ?";
			}
			PreparedStatement ps = con.prepareStatement(sqlCheckUsername);
			//setGetGlobalVariables username = new setGetGlobalVariables();
			ps.setString(1, txtUsername.getText());
			//ps.executeQuery();
			rs = ps.executeQuery();
			rs.next();
			return (rs.getString("squestion"));

			//System.out.println(rs.getString("squestion"));
		}
		catch(SQLException se){
			System.out.println(se);
			return(null);
		}
	}

	static String getPrivilege() {
		// TODO Auto-generated method stub
		return privilege;
	}
	
	private static void setPrivilege(String privilege){
		ForgotPasswordActionAndEvents.privilege = privilege;
	}

	public static boolean checkAnswer() {
		// TODO Auto-generated method stub

		try{
			Connection con = (Connection) DatabaseConnection.makeConnetion();
			String sqlCheckUsername = null;
			if(ForgotPasswordActionAndEvents.getPrivilege().equals("ADMIN")){
				sqlCheckUsername = "SELECT sanswer FROM admin  WHERE username = ?";
			}
			if(ForgotPasswordActionAndEvents.getPrivilege().equals("CUSTOMER")){
				sqlCheckUsername = "SELECT sanswer FROM customer  WHERE username = ?";
			}
			if(ForgotPasswordActionAndEvents.getPrivilege().equals("METERREADER")){
				sqlCheckUsername = "SELECT sanswer FROM meterreader  WHERE username = ?";
			}
			PreparedStatement ps = con.prepareStatement(sqlCheckUsername);
			//setGetGlobalVariables username = new setGetGlobalVariables();
			ps.setString(1, txtUsername.getText());
			//ps.executeQuery();
			ResultSet rs= ps.executeQuery();
			rs.next();
			if(rs.getString("sanswer").equals(txtAnswer.getText())){
				return(true);
			}
			System.out.println(rs.getString("sanswer"));
		}
		catch(SQLException se){
			se.printStackTrace();
			return(false);
		}
		return false;
	}

	/**
	 * @return the status
	 */
	public static String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public static void setStatus(String status) {
		ForgotPasswordActionAndEvents.status = status;
	}

	public static String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

}
