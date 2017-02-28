package actionAndEvents;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.fabric.xmlrpc.base.Data;
import com.mysql.jdbc.PreparedStatement;

import includes.DatabaseConnection;
import includes.setGetGlobalVariables;
import layout.SignUp;
import layout.ViewBill;

public class ViewBillActionAndEvents extends ViewBill {
	static int id;
	static StringBuffer totalAmountInWords = new StringBuffer();

	public static void clearData(){
		txtEmail.setText("email");
		txtBillId.setText("bill id");
		txtName.setText("name");
		//txtId.setText("");
		txtAreaNo.setText("area no.");
		txtMonth.setText("month");
		txtRate.setText("rate");
		txtUnits.setText("units");
		txtDiscount.setText("discount");
		txtFine.setText("fine");
		txtTotalAmount.setText("total amount");
		txtTotalAmountIn.setText("total amount inword");
		txtYear.setText("year");
		lblPaid.setVisible(false);
	}

	public static void disableEdit(){
		txtEmail.setEnabled(false);
		txtBillId.setEnabled(false);
		txtName.setEnabled(false);
		//txtId.setEnabled(false);
		txtAreaNo.setEnabled(false);
		txtMonth.setEnabled(false);
		txtRate.setEnabled(false);
		txtUnits.setEnabled(false);
		//		txtFine.setEnabled(false);
		//		txtDiscount.setEnabled(false);
		txtTotalAmount.setEnabled(false);
		txtTotalAmountIn.setEnabled(false);
	}

	public static int getId(){
		try{
			Connection conn = (Connection) DatabaseConnection.makeConnetion();
			String sqlSelect = null;
			if(setGetGlobalVariables.getPrivilege().equals("CUSTOMER")){
				 sqlSelect = "SELECT cid FROM customer WHERE username = ?";
			}
			if(setGetGlobalVariables.getPrivilege().equals("ADMIN")){
				 sqlSelect = "SELECT aid FROM admin WHERE username = ?";
			}
			if(setGetGlobalVariables.getPrivilege().equals("METERREADER")){
				 sqlSelect = "SELECT rid FROM meterreader WHERE username = ?";
			}
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sqlSelect);
			ps.setString(1, setGetGlobalVariables.getUsername());
			ResultSet rs = ps.executeQuery();
			rs.next();
			if(setGetGlobalVariables.getPrivilege().equals("CUSTOMER")){
				return(rs.getInt("cid"));
			}
			if(setGetGlobalVariables.getPrivilege().equals("ADMIN")){
				return(rs.getInt("aid"));
			}
			if(setGetGlobalVariables.getPrivilege().equals("METERREADER")){
				return(rs.getInt("rid"));
			}
		}
		catch(SQLException e1){
			e1.printStackTrace();
			return(0);
		}
		return 0;
	}
	public static void setId(int id1){
		id = id1;
	}

	public static boolean getBill(int id1, String month1, int year1) {
		id=id1;
		// TODO Auto-generated method stub
		try{
			Connection conn = (Connection) DatabaseConnection.makeConnetion();
			String sqlSelect = "SELECT * FROM meterreading WHERE cid = ? && month = ? && year =?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sqlSelect);
			ps.setInt(1, id1);
			ps.setString(2, month1);
			ps.setInt(3, year1);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int unit = rs.getInt("unit");
			String month = rs.getString("month");
			int year = (rs.getInt("year"));
			String payment = rs.getString("payment");
			if(payment.equals("PAID"))
			{
				lblPaid.setVisible(true);
				if(setGetGlobalVariables.getPrivilege().equals("ADMIN")){
					btnPay.setVisible(false);	
				}

				//				JOptionPane.showMessageDialog(null, "PAID");
			}
			else{
				lblPaid.setVisible(false);
				if(setGetGlobalVariables.getPrivilege().equals("ADMIN")){
					btnPay.setVisible(true);	
				}
				//				JOptionPane.showMessageDialog(null, "NOT PAID");

			}


			JOptionPane.showMessageDialog(null, "id: " + id + "\nMonth: " + month + "\nYear: " + year + "\nUnit: " + unit + "\nPayment: " + payment);

			Connection conn1 = (Connection) DatabaseConnection.makeConnetion();
			String sqlUserInformation = "SELECT fname, mname, lname, district, ward_no, municipality, email FROM customer WHERE cid = ?";
			PreparedStatement ps1 = (PreparedStatement) conn1.prepareStatement(sqlUserInformation);
			ps1.setInt(1, id);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			String mname;
			if(rs1.getString("mname").isEmpty()){
				mname = "";	
			}
			else{
				mname = rs1.getString("mname");
			}


			String name = rs1.getString("fname") + " " + mname + " " + rs1.getString("lname");
			String address = rs1.getString("district") + " " + rs1.getString("ward_no") + "," + " " + rs1.getString("municipality");
			String sid =Integer.toString( id);
			String email = rs1.getString("email");
			txtBillId.setText(sid);
			txtName.setText(name);
			txtAreaNo.setText(address);
			txtMonth.setText(month);
			txtYear.setText(""+year);
			txtRate.setText("15");
			txtUnits.setText(rs.getString("unit"));
			txtFine.setText("0");
			txtDiscount.setText("0");
			txtEmail.setText(email);
			int totalAmount = Integer.parseInt(txtUnits.getText()) * Integer.parseInt(txtRate.getText()) - Integer.parseInt(txtDiscount.getText()) + Integer.parseInt(txtFine.getText());

			String ta =Integer.toString( totalAmount);
			txtTotalAmount.setText(ta);

			//JOptionPane.showMessageDialog(null, "total amount set");

			//JOptionPane.showMessageDialog(null, "unit: " + unit + "\n" + "month: " + month + "\n" + "payment: " + payment);
			//JOptionPane.showMessageDialog(null, "id:" + id + "\n Month: " + month1 +"\n Year: "+ year1);

		}catch(java.sql.SQLException se){
			System.out.println(se);
			JOptionPane.showMessageDialog(null, "No id match in our Database. Thank You!");
			return (false);

		}


		return (true);
	}

	public static void pay(int id , String month, int year) {

		//JOptionPane.showMessageDialog(null, id);
		// TODO Auto-generated method stub
		try{
			Connection con = DatabaseConnection.makeConnetion();
			String sqlpay = "UPDATE meterreading SET payment = ? WHERE cid = ? && month =? && year =?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sqlpay);
			ps.setString(1, "PAID");
			ps.setInt(2, id);
			ps.setString(3, month);
			ps.setInt(4, year);
			if(ps.executeUpdate()==1){
				JOptionPane.showMessageDialog(null, "PAYMENT SUCCESSFUL!");
				lblPaid.setVisible(true);
				btnPay.setVisible(false);

			}
			else{
				JOptionPane.showMessageDialog(null,"Payement Unsuccessfull!");
				lblPaid.setVisible(false);
				btnPay.setVisible(true);
			}

		}catch(Exception e){
			System.out.println(e);
		}
	}

	public static void calculateTotalAmount() {
		// TODO Auto-generated method stub
		int totalAmount = (Integer.parseInt(txtUnits.getText()) * Integer.parseInt(txtRate.getText()) + Integer.parseInt(txtFine.getText()) )- Integer.parseInt(txtDiscount.getText());
		String ta =Integer.toString( totalAmount);
		txtTotalAmount.setText(ta);
	}

}
