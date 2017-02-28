package actionAndEvents;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import layout.UpdatePassword;
import includes.DatabaseConnection;
import includes.UserInformation;
import includes.setGetGlobalVariables;

public class UpdatePasswordActionAndEvents extends setGetGlobalVariables{

	String oldPassword, NewPassword,ReNewPassword;

	public UpdatePasswordActionAndEvents(String oldPassword, String NewPassword, String ReNewPassword){
		this.oldPassword = oldPassword;
		this.NewPassword = NewPassword;
		this.ReNewPassword = ReNewPassword;
		if(NewPassword.equals("") || ReNewPassword.equals("")){
			JOptionPane.showMessageDialog(null, "Password cannot be empty");
		}
		else{
			try{
				String sqlUpdate = null;
				Connection con = DatabaseConnection.makeConnetion();
				if(setGetGlobalVariables.getPrivilege().equals("ADMIN")){
					sqlUpdate = "UPDATE  admin SET password = ? WHERE username = ? and password = ?";
				}
				if(setGetGlobalVariables.getPrivilege().equals("CUSTOMER")){
					sqlUpdate = "UPDATE  customer SET password = ? WHERE username = ? and password = ?";
				}
				if(setGetGlobalVariables.getPrivilege().equals("METERREADER")){
					sqlUpdate = "UPDATE  customer SET password = ? WHERE username = ? and password = ?";
				}
				PreparedStatement ps = con.prepareStatement(sqlUpdate);
				//setGetGlobalVariables username = new setGetGlobalVariables();
				ps.setString(1,NewPassword);
				ps.setString(2, setGetGlobalVariables.getUsername());
				ps.setString(3, oldPassword);
				System.out.println(setGetGlobalVariables.getUsername());
//				JOptionPane.showMessageDialog(null, setGetGlobalVariables.getUsername());

				if(ps.executeUpdate()==1){
					JOptionPane.showMessageDialog(null, "Password Change Successful! :D");
					UserInformation.logOut(UpdatePassword.frame);
				}		

				else
				{
					JOptionPane.showMessageDialog(null, "Please Enter Correct Passwords");
				}
				//rs.next();
				//System.out.println(rs);
				//tblUsername = rs.getString("username");
			}

			catch(Exception e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Cannot Update the password! :D Please Try Again.");
			}
		}
	}
}
