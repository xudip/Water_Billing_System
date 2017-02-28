package actionAndEvents;

import includes.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import layout.ViewCustomer;
import layout.ViewMeterreader;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ViewMeterreaderActionAndEvents {
//	Object[][] data = new Object[100][100];
	static int id;

	public static ResultSet getData() {
		// TODO Auto-generated constructor stub
		try{

			Connection con = (Connection) DatabaseConnection.makeConnetion();
			String sql="SELECT rid, fname, mname, lname, gender, dob, contact, district, municipality, ward_no, email, username  from meterreader";
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
			String sqlView = "SELECT  rid,fname, mname, lname, gender, dob, contact, district, municipality, ward_no, email, username, password, squestion, sanswer, privilege FROM meterreader WHERE rid=? ";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sqlView);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();

			JOptionPane.showMessageDialog(null,"" + "ID: " +
					rs.getInt("rid") + "\n" + "First Name: " + 
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
					rs.getString("username") + "\n" + "Password: " +
					rs.getString("password") + "\n" + "Security Question: " +
					rs.getString("squestion") + "\n" + "Answer: " +
					rs.getString("sanswer") + "\n" + "Privilege: " +
					rs.getString("privilege") 
					);


			//JOptionPane.showMessageDialog(null, id);
		}catch(Exception e ){
			System.out.println(e);
		}

	}


	public static void delete(int id1){
		id = id1;
		try{
			Connection con = (Connection) DatabaseConnection.makeConnetion();
			String sqlDelete = "DELETE FROM meterreader WHERE rid = ?";
			PreparedStatement psDelete = (PreparedStatement) con.prepareStatement(sqlDelete);
			psDelete.setInt(1, id);
			//psDelete.executeUpdate();
			if(psDelete.executeUpdate() == 1){
				JOptionPane.showMessageDialog(null, "DELETED! rid = " + id);

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
		
			try{
			
				Connection con = (Connection) DatabaseConnection.makeConnetion();
				//if(username.getPrivilege().equals("ADMIN"))
				String sqlUpdate = "UPDATE  meterreader SET fname=?,mname=?,lname=?,gender=?,dob=?,contact=?,district=?,municipality=?,ward_no=?,email=?,username=? WHERE rid=?";
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
			String sqlSearch= "SELECT rid, fname, mname, lname, gender, dob, contact, district, municipality, ward_no, email FROM meterreader WHERE"
					+ " ((fname LIKE ?) "
					+ "AND (district LIKE ?)"
					+ " AND (contact LIKE ?) "
					+ "AND (dob LIKE ?) "
					+ "AND (email LIKE ?) "
					+ "AND (username LIKE ?)"
					+ " AND (privilege LIKE ?) )";
			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sqlSearch);
			ps.setString(1,"%" + ViewMeterreader.txtName.getText() + "%");
			ps.setString(2, "%" + ViewMeterreader.getTxtAddress().getText() + "%");
			ps.setString(3, "%" + ViewMeterreader.getTxtContact().getText() + "%");
			ps.setString(4, "%" + ViewMeterreader.getTxtDob().getText() + "%");
			ps.setString(5, "%" + ViewMeterreader.getTxtEmail().getText() + "%");
			ps.setString(6, "%" + ViewMeterreader.getTxtUsername().getText() + "%");
			ps.setString(7, "%" + ViewMeterreader.getTxtPrivilege().getText() + "%");
//			JOptionPane.showMessageDialog(null, ViewMeterreader.getTxtAddress().getText() + ViewMeterreader.getTxtContact().getText()+ ViewMeterreader.getTxtDob().getText());
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
