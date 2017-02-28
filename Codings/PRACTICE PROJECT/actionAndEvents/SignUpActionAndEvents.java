package actionAndEvents;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import includes.DatabaseConnection;
import includes.Validations;
import includes.setGetGlobalVariables;
import javafx.scene.control.ComboBox;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import layout.SignUp;

public class SignUpActionAndEvents extends SignUp {
	static String firstName;
	static String middleName;
	static String lastName;
	static String dob;
	static String gender;
	static String contact;
	static String district;
	static String municipality;
	static String wardNo;
	static String email;
	static String username;
	static String password;
	static String reTypePassword;
	static String question;
	static String answer;
	static String privilege;
	static String pic_path;
	static String pic_filename;
	public static boolean error;



	public static  void setData(){
		firstName = txtFirstName.getText().trim();
		middleName = txtMiddleName.getText().trim();
		lastName = txtLastName.getText().trim();
		StringBuffer dobsf = new StringBuffer();
		dobsf.append(String.valueOf(comboBoxDay.getSelectedItem()) + " ");
		dobsf.append(String.valueOf(comboBoxMonth.getSelectedItem())+ " ");
		dobsf.append(String.valueOf(comboBoxYear.getSelectedItem()) + " ");
		dob=dobsf.toString();
		//JOptionPane.showMessageDialog(null, dob);
		if(rdbtnMale.isSelected()){
			gender="Male";
		}
		else if(rdbtnFemale.isSelected()){
			gender="Female";
		}
		else{
			gender="Other";
		}
		contact = txtContact.getText().trim();
		district = txtDistrict.getText().trim();
		municipality = txtMunicipality.getText().trim();
		wardNo = txtWardNo.getText().trim();
		email = txtEmail.getText().trim();
		username = txtUsername.getText();
		password = pwdPassword.getText();
		reTypePassword = pwdReTypePassword.getText().trim();
		question = txtSecurityQuestion.getText().trim();
		answer = txtAnswer.getText().trim();
		privilege =String.valueOf(comboBoxPrivilege.getSelectedItem());
		pic_path="userphoto\\";
		pic_filename=fileName;
	}


	public static void clearData(){
		txtFirstName.setText("");
		txtMiddleName.setText("");
		txtLastName.setText("");
		//btngrpgender.clearSelection();;
		txtContact.setText("");
		txtDistrict.setText("");
		txtMunicipality.setText("");
		txtWardNo.setText("");
		txtEmail.setText("");
		txtUsername.setText("");
		pwdPassword.setText("");
		pwdReTypePassword.setText("");
		txtSecurityQuestion.setText("");
		txtAnswer.setText("");
		fileName = "";
		lblImagePreview.setIcon(null);
	}


	public static Boolean checkError(){


		//panelUpdatePassword.add(lblCross);
		//return(true);

		if(firstName.equals("") || 
				lastName.equals("") || 
				//				middleName.equals("") || 
				lastName.equals("") || 
				dob.equals("") || 
				//				gender.equals("") || 
				contact.equals("") || 
				district.equals("") || 
				municipality.equals("") || 
				wardNo.equals("") || 
				email.equals("") || 
				(Validations.emailValidate(email)==false) ||
				username.equals("") || 
				password.equals("") || 
				reTypePassword.equals("") || 
				question.equals("") || 
				answer.equals("") ||
				privilege.equals("") ||
				lblCross.isVisible() ||
				lblUsernameAlreadyExists.isVisible()
				/*
				|| 
				privilege.equals("") ||  
				pic_path.equals("") || 
				pic_filename.equals("")
				 */
				){


			if(firstName.equals("")){
				txtFirstName.setBorder(new LineBorder(Color.RED, 2));

			}
			else
				txtFirstName.setBorder(new LineBorder(Color.BLACK, 1));

			if(lastName.equals("")){
				txtLastName.setBorder(new LineBorder(Color.RED, 2));

			}

			else{

				txtLastName.setBorder(new LineBorder(Color.BLACK, 1));
			}
			if(dob.equals("")){
				comboBoxDay.setBorder(new LineBorder(Color.RED, 2));

			}

			else{

				comboBoxDay.setBorder(new LineBorder(Color.BLACK, 1));
			}
			if(contact.equals("")){
				txtContact.setBorder(new LineBorder(Color.RED, 2));

			}

			else{

				txtContact.setBorder(new LineBorder(Color.BLACK, 1));
			}
			if(district.equals("")){
				txtDistrict.setBorder(new LineBorder(Color.RED, 2));

			}

			else{

				txtDistrict.setBorder(new LineBorder(Color.BLACK, 1));
			}
			if(municipality.equals("")){
				txtMunicipality.setBorder(new LineBorder(Color.RED, 2));

			}

			else{

				txtMunicipality.setBorder(new LineBorder(Color.BLACK, 1));
			}
			if(wardNo.equals("")){
				txtWardNo.setBorder(new LineBorder(Color.RED, 2));

			}

			else{

				txtWardNo.setBorder(new LineBorder(Color.BLACK, 1));
			}

			if(email.equals("") || (Validations.emailValidate(email)==false)){
				txtEmail.setBorder(new LineBorder(Color.RED, 2));

			}

			else{

				txtEmail.setBorder(new LineBorder(Color.BLACK, 1));
			}
			if(username.equals("")){
				txtUsername.setBorder(new LineBorder(Color.RED, 2));

			}

			else{

				txtUsername.setBorder(new LineBorder(Color.BLACK, 1));
			}
			if(password.equals("")){
				pwdPassword.setBorder(new LineBorder(Color.RED, 2));

			}
			else{

				pwdPassword.setBorder(new LineBorder(Color.BLACK, 1));
			}
			if(reTypePassword.equals("")){
				pwdReTypePassword.setBorder(new LineBorder(Color.RED, 2));

			}

			else{

				pwdReTypePassword.setBorder(new LineBorder(Color.BLACK, 1));
			}
			if(question.equals("")){
				txtSecurityQuestion.setBorder(new LineBorder(Color.RED, 2));

			}

			else{

				txtSecurityQuestion.setBorder(new LineBorder(Color.BLACK, 1));
			}
			if(answer.equals("")){
				txtAnswer.setBorder(new LineBorder(Color.RED, 2));

			}

			else{

				txtAnswer.setBorder(new LineBorder(Color.BLACK, 1));
			}
			error = true;
		}

		else{
			error =false;
		}



		/*
		if(privilege.equals("")){

		}
		else{

			}

		if(pic_filename.equals("")){

		}
		else{

			}

		if(pic_path.equals("")){

		}
	else{

			}
		 */
		if(error==true){
			return (true);
		}
		else{

			return(false);
		}


	}


	public static void insertData(){

		if(checkError() == false)
		{

			//			JOptionPane.showMessageDialog(null, firstName + middleName + lastName + dob +  contact + district + municipality + wardNo + email + username + password + reTypePassword + question + answer);


			//insertion of data with sql codes
			try{

				Connection con = (Connection) DatabaseConnection.makeConnetion();
				String sqlInsert = null;
				if(privilege.equals("CUSTOMER")){
					sqlInsert="INSERT INTO  customer ( fname ,  mname ,  lname ,  pic_path ,  pic_filename , dob , gender, contact ,  district ,  municipality ,  ward_no , email ,  username ,  password , squestion ,  sanswer ,  privilege ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				}
				if(privilege.equals("METERREADER")){
					sqlInsert="INSERT INTO  meterreader ( fname ,  mname ,  lname ,  pic_path ,  pic_filename , dob , gender, contact ,  district ,  municipality ,  ward_no , email ,  username ,  password , squestion ,  sanswer ,  privilege ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				}
				if(privilege.equals("ADMIN")){
					sqlInsert="INSERT INTO  admin ( fname ,  mname ,  lname ,  pic_path ,  pic_filename , dob , gender, contact ,  district ,  municipality ,  ward_no , email ,  username ,  password , squestion ,  sanswer ,  privilege ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				}

				PreparedStatement pst=(PreparedStatement) con.prepareStatement(sqlInsert);
				pst.setString(1,firstName);
				pst.setString(2,middleName );
				pst.setString(3, lastName);
				pst.setString(4, pic_path);
				if(pic_filename == ""){
					pst.setString(5, "NO IMAGE");
				}
				else{
					pst.setString(5, pic_filename);
				}
				pst.setString(6, dob);
				pst.setString(7, gender);
				pst.setString(8, contact);
				pst.setString(9, district);
				pst.setString(10, municipality);
				pst.setString(11, wardNo);
				pst.setString(12, email);
				pst.setString(13, username);
				pst.setString(14, password);
				pst.setString(15, question);
				pst.setString(16, answer);
				pst.setString(17, privilege);

				if(pst.executeUpdate() == 1){
					JOptionPane.showMessageDialog(null,"SUCCESSFULL! :D");
					clearData();
				}

				else{
					JOptionPane.showMessageDialog(null,"UNSUCCESSFULL! :D");

				}


			}
			catch(java.lang.NullPointerException nu){
				JOptionPane.showMessageDialog(null, "Please Enter Gender!");
			}

			catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				System.out.println(e);
//				JOptionPane.showMessageDialog(null, "DUPLICATE USERNAME");
				lblImagePreview.setBorder(new LineBorder(Color.RED, 2));

			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "ERROR IS TRUE");
		}
	}

	public static void chekUsernameAvailability(String text) {
		// TODO Auto-generated method stub
		try{
			Connection con = (Connection) DatabaseConnection.makeConnetion();
			String sql = "SELECT * FROM users WHERE username=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,txtUsername.getText());
			ResultSet rs = ps.executeQuery();
			rs.next();
			if(rs.getString("username").isEmpty()){
				lblUsernameAlreadyExists.setVisible(false);
				error=false;
			}
			else{
				lblUsernameAlreadyExists.setVisible(true);	
				error=true;
			}

		}catch(java.sql.SQLException e){
			error=false;
			lblUsernameAlreadyExists.setVisible(false);
		}
		catch(Exception se){
			System.out.println(se);
		}
	}

	public static void numberValidate(KeyEvent e, char c1){
		char c = c1;
		if (!((c >= '0') && (c <= '9') || 
				(c == KeyEvent.VK_BACK_SPACE) || 
				(c == KeyEvent.VK_DELETE)) ||
				(txtContact.getText().length()>=10)){
			{
				e.consume();
			}
		}

	}

}


