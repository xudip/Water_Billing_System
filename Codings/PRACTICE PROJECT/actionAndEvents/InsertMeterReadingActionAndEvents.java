package actionAndEvents;

import includes.DatabaseConnection;
import includes.setGetGlobalVariables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;

import javax.swing.JOptionPane;

import layout.InsertMeterReading;

public class InsertMeterReadingActionAndEvents {
	int id ;
	int units;
	String year = "";
	String month = "", paymentStatus = "";


	public void setData(String month, String year, String paymentStatus){
		id = Integer.parseInt( InsertMeterReading.txtId.getText());
		units = Integer.parseInt(InsertMeterReading.txtUnits.getText());
		this.month =month;
		this.year = year;
		this.paymentStatus = paymentStatus;

	}

	public int getId(){
		return(id);

	}

	public  int getUnits(){
		return(units);
	}

	public String getMonth(){
		return(month);
	}

	public  String getYear(){
		return(year);
	}

	public String getPayment(){
		return(paymentStatus);
	}

	public void insertData() {
		// TODO Auto-generated method stub
		try{
			Connection con = DatabaseConnection.makeConnetion();
			String sqlInsert="INSERT INTO  meterreading (cid, unit, month, year, payment) VALUES (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setInt(1,id);
			ps.setInt(2,units );
			ps.setString(3, month);
			ps.setString(4, year);
			ps.setString(5,paymentStatus);

			if(ps.executeUpdate() == 1){
				JOptionPane.showMessageDialog(null,"SUCCESSFULL! :D");
			}

		}catch(SQLException se){
			JOptionPane.showMessageDialog(null, "Customer ID not found");
		}
	}

	public int checkDuplicateEntry() {
		int duplicateStatus=1;
		try{
			Connection con = DatabaseConnection.makeConnetion();
			String sqlSelect = "SELECT * FROM meterreading WHERE (cid=? AND month = ? AND year = ?)";
			PreparedStatement ps = con.prepareStatement(sqlSelect);
			ps.setInt(1,id);
			ps.setString(2,month );
			ps.setString(3, year);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String duplicateMonth = rs.getString("month");
			if(duplicateMonth.isEmpty()){
				duplicateStatus = 0;
			}
			else{
				duplicateStatus = 1;
			}

		}
		catch(SQLException se){
			duplicateStatus = 0;
		}
		return (duplicateStatus);

	}

}
