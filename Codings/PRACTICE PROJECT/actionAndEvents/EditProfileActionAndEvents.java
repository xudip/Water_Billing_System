package actionAndEvents;

import includes.DatabaseConnection;
import includes.Validations;
import includes.setGetGlobalVariables;

import java.awt.Color;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import layout.EditProfile;

public class EditProfileActionAndEvents extends EditProfile {
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

	public static void getData(int id) {

		try{
			String sql = null;
			Connection con = (Connection) DatabaseConnection.makeConnetion();
			if(setGetGlobalVariables.getPrivilege().equals("CUSTOMER")){
				sql="SELECT * from customer where cid =?";
			}
			if(setGetGlobalVariables.getPrivilege().equals("ADMIN")){
				sql = "SELECT * FROM admin where aid = ?";
			}

			if(setGetGlobalVariables.getPrivilege().equals("METERREADER")){
				sql =  "SELECT * FROM meterreader WHERE rid =?";
			}

			PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			rs.next();
			setFirstName(rs.getString("fname"));
			setMiddleName(rs.getString("mname"));
			setLastName(rs.getString("lname"));
			setDOB(rs.getString("dob"));
			setGender(rs.getString("gender"));
			setContact(rs.getString("contact"));
			setDistric(rs.getString("district"));
			setMunicipality(rs.getString("municipality"));
			setWardNo(rs.getString("ward_no"));
			setEmail(rs.getString("email"));
			setUsername(rs.getString("username"));
			setPassword(rs.getString("password"));
			setQuestion(rs.getString("squestion"));
			setAnswer(rs.getString("sanswer"));
			setPic_Path(rs.getString("pic_path"));
			setPic_FileName(rs.getString("pic_filename"));


		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error Loading Data!");
			e.printStackTrace();
		}


	}

	public static void clearData(){
		firstName = "";
		middleName = "";
		lastName = "";
		dob = "";
		gender = "";
		contact = "";
		district = "";
		municipality = "";
		wardNo = "";
		email = "";
		username = "";
		password = "";
		reTypePassword = "";
		question = "";
		answer = "";
		privilege = "";
		pic_path = "";
		pic_filename = "";
	}

	private static void setUsername(String string) {
		// TODO Auto-generated method stub
		username = string;
	}

	private static void setPic_FileName(String string) {
		// TODO Auto-generated method stub
		pic_filename = string;
	}

	private static void setPic_Path(String string) {
		// -TODO Auto-generated method stub

		pic_path=string;

	}

	private static void setAnswer(String string) {
		// TODO Auto-generated method stub

		answer=string;
	}

	private static void setQuestion(String string) {
		// TODO Auto-generated method stub

		question=string;
	}

	private static void setPassword(String string) {
		// TODO Auto-generated method stub

		password=string;
	}

	private static void setEmail(String string) {
		// TODO Auto-generated method stub

		email=string;

	}

	private static void setWardNo(String string) {
		// TODO Auto-generated method stub

		wardNo=string;

	}

	private static void setMunicipality(String string) {
		// TODO Auto-generated method stub

		municipality=string;

	}

	private static void setDistric(String string) {
		// TODO Auto-generated method stub

		district=string;

	}

	private static void setGender(String string) {
		// TODO Auto-generated method stub

		gender=string;

	}

	private static void setContact(String string) {
		// TODO Auto-generated method stub

		contact=string;

	}

	private static void setDOB(String string) {
		// TODO Auto-generated method stub

		dob=string;

	}

	private static void setLastName(String string) {
		// TODO Auto-generated method stub

		lastName=string;

	}

	private static void setMiddleName(String string) {
		// TODO Auto-generated method stub

		middleName=string;

	}

	public static  void setData() {
		firstName = txtFirstName.getText().trim();
		middleName = txtMiddleName.getText().trim();
		lastName = txtLastName.getText().trim();
		contact = txtContact.getText().trim();
		district = txtDistrict.getText().trim();
		municipality = txtMunicipality.getText().trim();
		wardNo = txtWardNo.getText().trim();
		email = txtEmail.getText().trim();
		//		username = txtUsername.getText();
		password =txtPassword.getText();
		question = txtSecurityQuestion.getText().trim();
		answer = txtAnswer.getText().trim();
		//		privilege =String.valueOf(comboBoxPrivilege.getSelectedItem());
		pic_path="userphoto\\";
		pic_filename=fileName;
	}
	public static Boolean checkError(){

		if(getFirstName().equals("") || 
				lastName.equals("") ||  
				contact.equals("") || 
				district.equals("") || 
				municipality.equals("") || 
				wardNo.equals("") || 
				email.equals("") ||
				(Validations.emailValidate(email)==false) ||
				question.equals("") || 
				answer.equals("") 
				){


			if(getFirstName().equals("")){
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

		if(error==true){
			return (true);
		}
		else{

			return(false);
		}


	}



	public static boolean updateData(){
		try{
			String sqlUpdate= "";
			Connection conn=DatabaseConnection.makeConnetion();
			if(setGetGlobalVariables.getPrivilege().equals("CUSTOMER")){
				sqlUpdate="UPDATE  customer SET fname=?,mname = ?, lname = ?, contact=?,district=?,municipality=?,ward_no=?,email=?,username=?,password=?,squestion=?,sanswer=?, pic_filename =? WHERE cid=?";
			}
			if(setGetGlobalVariables.getPrivilege().equals("ADMIN")){
				sqlUpdate="UPDATE  admin SET fname=?,mname = ?, lname = ?, contact=?,district=?,municipality=?,ward_no=?,email=?,username=?,password=?,squestion=?,sanswer=?, pic_filename =? WHERE aid=?";
			}
			if(setGetGlobalVariables.getPrivilege().equals("METERREADER")){
				sqlUpdate="UPDATE  meterreader SET fname=?,mname = ?, lname = ?, contact=?,district=?,municipality=?,ward_no=?,email=?,username=?,password=?,squestion=?,sanswer=?, pic_filename =? WHERE rid=?";
			}


			PreparedStatement pst=conn.prepareStatement(sqlUpdate);
			pst.setString(1, getFirstName());
			pst.setString(2, middleName);
			pst.setString(3, lastName);
			pst.setString(4, contact);
			pst.setString(5, district);
			pst.setString(6, municipality);
			pst.setString(7,wardNo);
			pst.setString(8, email);
			pst.setString(9, username);
			pst.setString(10, password);
			pst.setString(11, question);
			pst.setString(12, answer);
			pst.setString(13, fileName);
			pst.setInt(14,EditProfile.id);
//			JOptionPane.showMessageDialog(null, middleName+ username + id);
			if(pst.executeUpdate()==1){
				JOptionPane.showMessageDialog(null, "sucessfully updated");
				return(true);

			}
		}
		catch(SQLException e){
			e.printStackTrace();
			return(false);
		}
		return true;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the firstName
	 */
	public static String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public static void setFirstName(String firstName) {
		EditProfileActionAndEvents.firstName = firstName;
	}

	public static String getDistrict() {
		// TODO Auto-generated method stub
		return district;
	}

	public static String getAnswer() {
		// TODO Auto-generated method stub
		return answer;
	}

	public static String getSecurityQuestion() {
		// TODO Auto-generated method stub
		return question;
	}

	public static String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public static String getUserName() {
		// TODO Auto-generated method stub
		return username;
	}

	public static String getWardNo() {
		// TODO Auto-generated method stub
		return wardNo;
	}

	public static String getMunicipality() {
		// TODO Auto-generated method stub
		return municipality;
	}

	public static String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public static String getContact() {
		// TODO Auto-generated method stub
		return contact;
	}

	public static String getDob() {
		// TODO Auto-generated method stub
		return dob;
	}

	public static String getGender() {
		// TODO Auto-generated method stub
		return gender;
	}

	public static String getMiddleName() {
		// TODO Auto-generated method stub
		return middleName;
	}

	public static String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	public static void enableUpdate() {
		txtFirstName.setEditable(true);
		txtMiddleName.setEditable(true);
		txtLastName.setEditable(true);
		txtContact.setEditable(true);
		txtDistrict.setEditable(true);
		txtMunicipality.setEditable(true);
		txtWardNo.setEditable(true);
		txtEmail.setEditable(true);
		//		txtUsername.setEditable(true);;
		txtPassword.setEditable(true);
		txtSecurityQuestion.setEditable(true);
		txtAnswer.setEditable(true);
		btnChoosePicture.setEnabled(true);

	}

	public static void disableUpdate() {
		// TODO Auto-generated method stub
		txtFirstName.setEditable(false);
		txtMiddleName.setEditable(false);
		txtLastName.setEditable(false);
		txtContact.setEditable(false);
		txtDistrict.setEditable(false);
		txtMunicipality.setEditable(false);
		txtWardNo.setEditable(false);
		txtEmail.setEditable(false);
		//		txtUsername.setEditable(false);;
		txtPassword.setEditable(false);
		txtSecurityQuestion.setEditable(false);
		txtAnswer.setEditable(false);
		btnChoosePicture.setEnabled(false);
	}

	public static void getFileChooser() {
		// TODO Auto-generated method stub


	}





}
