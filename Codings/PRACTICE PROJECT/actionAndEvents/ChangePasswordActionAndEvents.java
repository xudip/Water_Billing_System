package actionAndEvents;

import includes.DatabaseConnection;
import includes.setGetGlobalVariables;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import layout.ChangePassword;
import layout.LogInLayout;

public class ChangePasswordActionAndEvents extends ChangePassword {

	public static void clearData(){
		txtNewPassword.setText("");
		txtReTypeNewPassword.setText("");
	}

	public static void changePassword() {
		String newPassword = txtNewPassword.getText().trim();
		String reTypePassword = txtReTypeNewPassword.getText().trim();
		// TODO Auto-generated method stub
		if(newPassword.equals("") || reTypePassword.equals("")){
			JOptionPane.showMessageDialog(null, "Password cannot be empty!");
			lblTick.setVisible(false);
			lblCross.setVisible(true);
		}
		else{
			try{
				Connection con = DatabaseConnection.makeConnetion();
				String sqlUpdate = null;
				if(ForgotPasswordActionAndEvents.getPrivilege().equals("ADMIN")){
					sqlUpdate = "UPDATE  admin SET password = ? WHERE username = ?";
				}
				if(ForgotPasswordActionAndEvents.getPrivilege().equals("CUSTOMER")){
					sqlUpdate = "UPDATE  customer SET password = ? WHERE username = ?";
				}
				if(ForgotPasswordActionAndEvents.getPrivilege().equals("METERREADER")){
					sqlUpdate = "UPDATE  meterreader SET password = ? WHERE username = ?";
				}
				PreparedStatement ps = con.prepareStatement(sqlUpdate);
				//setGetGlobalVariables username = new setGetGlobalVariables();
				ps.setString(1,newPassword);
				ps.setString(2, ForgotPasswordActionAndEvents.getUsername());
				System.out.println(setGetGlobalVariables.getUsername());
				//JOptionPane.showMessageDialog(null, setGetGlobalVariables.getUsername());

				if(ps.executeUpdate()==1){
					JOptionPane.showMessageDialog(null, "Password Change Successful! :D");
					frame.dispose();
					LogInLayout lil = new LogInLayout();
				}		

				else
				{
					JOptionPane.showMessageDialog(null, "Please Enter Correct Passwords");
				}
			}
			//rs.next();
			//System.out.println(rs);
			//tblUsername = rs.getString("username");

			catch(Exception e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Cannot Update the password! :D Please Try Again.");
			}
		}
	}


	public static void checkError() {
		// TODO Auto-generated method stub
		if(txtNewPassword.getText().equals(txtReTypeNewPassword.getText())){
			//panelUpdatePassword.add(lblTick);
			lblTick.setVisible(true);
			lblCross.setVisible(false);
		}
		else{
			//panelUpdatePassword.add(lblCross);
			lblTick.setVisible(false);
			lblCross.setVisible(true);
		}

	}
}
