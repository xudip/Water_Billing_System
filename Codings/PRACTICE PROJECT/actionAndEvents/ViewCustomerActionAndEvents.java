package actionAndEvents;

import includes.DatabaseConnection;
import includes.setGetGlobalVariables;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import layout.ViewCustomer;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ViewCustomerActionAndEvents {

	static Object[][] data = new Object[100][100];
	static int id;

	public static ResultSet getData() {
		// TODO Auto-generated constructor stub
		try{

			Connection con = (Connection) DatabaseConnection.makeConnetion();
			String sql="SELECT cid, fname, mname, lname, gender, dob, contact, district, municipality, ward_no, email  from customer";
			PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			return (rs);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "NO Data Loaded!");
			return null;
		}


	}

	public static void setId(int id1){
		id= id1;
	}

	public static int getId(){
		return(id);
	}

	public static void view(int id1){
		id = id1;
		try{
			Connection con = (Connection) DatabaseConnection.makeConnetion();
			String sqlView = "SELECT  cid,fname, mname, lname, gender, dob, contact, district, municipality, ward_no, email, username, password, squestion, sanswer, privilege FROM customer WHERE cid=? ";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sqlView);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();

			JOptionPane.showMessageDialog(null,"" + "ID: " +
					rs.getInt("cid") + "\n" + "First Name: " + 
					rs.getString("fname") + "\n" + "Middle Name: " +
					rs.getString("mname") + "\n" + "Last Name: " +
					rs.getString("lname") + "\n" + " Gender: " +
					rs.getString("gender") + "\n" + "DOB: " +
					rs.getString("dob") + "\n" + "Contact: " +
					rs.getString("contact") + "\n" + "District: " +
					rs.getString("district") + "\n" + "Municipality: " +
					rs.getString("municipality") + "\n" + "Ward No.: " +
					rs.getString("ward_no") + "\n" + "Email: " +
					rs.getString("email") + "\n" + "Username: " +
					rs.getString("username") + "\n" +  "Security Question: " +
					rs.getString("squestion") + "\n"  + "Privilege: " +
					rs.getString("privilege") 
					);


			//JOptionPane.showMessageDialog(null, ans);
		}catch(Exception e ){
			System.out.println(e);
		}

	}

	//	public static void update(int id, String ans){
	//		try{
	//			Connection con = (Connection) DatabaseConnection.makeConnetion();
	//			String sqlUpdate = "UPDATE customer SET answer = ? WHERE id = ?";
	//			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sqlUpdate);
	//			ps.setString(1,ans);
	//			ps.setInt(2, id);
	//			if(ps.executeUpdate()==1){
	//				JOptionPane.showMessageDialog(null, "Answer saved");
	//			}
	//			else{
	//				JOptionPane.showMessageDialog(null, "ANswer not saved");
	//			}
	//		}catch(Exception e){
	//			System.out.println(e);
	//		}
	//
	//
	//	}

	public static void delete(int id1){
		id = id1;
		try{
			Connection con = (Connection) DatabaseConnection.makeConnetion();
			String sqlDelete = "DELETE FROM customer WHERE cid = ?";
			PreparedStatement psDelete = (PreparedStatement) con.prepareStatement(sqlDelete);
			psDelete.setInt(1, id);
			//psDelete.executeUpdate();
			if(psDelete.executeUpdate() == 1){
				JOptionPane.showMessageDialog(null, "DELETED! cid = " + id);

			}
			else{
				JOptionPane.showConfirmDialog(null, " NOT DELETED!");
			}

		}
		catch(Exception se){
			System.out.println(se);
		}
	}

	public static void save(Object data[]) {
		int x=100;
		// TODO Auto-generated method stub
		try{
			String sqlUpdate = null;
			Connection con = (Connection) DatabaseConnection.makeConnetion();
			//if(username.getPrivilege().equals("ADMIN"))
			sqlUpdate = "UPDATE  customer SET fname=?,mname=?,lname=?,gender=?,dob=?,contact=?,district=?,municipality=?,ward_no=?,email=?,username=?= WHERE cid=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sqlUpdate);

			ps.setString(1, (String) data[1]);
			ps.setString(2, (String) data[2]);
			ps.setString(3, (String) data[3]);
			ps.setString(4, (String) data[4]);
			ps.setString(5, (String) data[5]);
			ps.setString(6, (String) data[6]);
			ps.setString(7, (String) data[7]);
			ps.setString(8, (String) data[8]);
			ps.setString(9, (String) data[9]);
			ps.setString(10, (String) data[10]);
			ps.setString(11,(String) data[11]);
			ps.setInt(12, (Integer) data[0]);
			ps.executeUpdate();

		}catch(SQLException e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Update Unsuccessful! :(");
		}
	}

	public static ResultSet advancedSearch() {
		// TODO Auto-generated method stub
		try{
			Connection conn = (Connection) DatabaseConnection.makeConnetion();
			String sqlSearch= "SELECT cid, fname, mname, lname, gender, dob, contact, district, municipality, ward_no, email FROM customer WHERE"
					+ " ((fname LIKE ?) "
					+ "AND (district LIKE ?)"
					+ " AND (contact LIKE ?) "
					+ "AND (dob LIKE ?) "
					+ "AND (email LIKE ?) "
					+ "AND (username LIKE ?)"
					+ " AND (privilege LIKE ?) )";
			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sqlSearch);
			ps.setString(1,"%" + ViewCustomer.txtName.getText() + "%");
			ps.setString(2, "%" + ViewCustomer.getTxtAddress().getText() + "%");
			ps.setString(3, "%" + ViewCustomer.getTxtContact().getText() + "%");
			ps.setString(4, "%" + ViewCustomer.getTxtDob().getText() + "%");
			ps.setString(5, "%" + ViewCustomer.getTxtEmail().getText() + "%");
			ps.setString(6, "%" + ViewCustomer.getTxtUsername().getText() + "%");
			ps.setString(7, "%" + ViewCustomer.getTxtPrivilege().getText() + "%");
//			JOptionPane.showMessageDialog(null, ViewCustomer.getTxtAddress().getText() + ViewCustomer.getTxtContact().getText()+ ViewCustomer.getTxtDob().getText());
			ResultSet rs = ps.executeQuery();
			return(rs);
		}catch(java.lang.NullPointerException emptyData){
			JOptionPane.showMessageDialog(null,"No Data Found!");
			return(null);
		}
		catch(SQLException e ){
			//JOptionPane.showMessageDialog(null, "No result Found");
			return(null);
		}
		
		
	}
	
}