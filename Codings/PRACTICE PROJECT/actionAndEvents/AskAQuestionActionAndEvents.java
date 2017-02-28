package actionAndEvents;

import includes.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import com.sun.prism.paint.Color;

import layout.AskAQuestion;
import layout.ViewCustomer;

public class AskAQuestionActionAndEvents extends AskAQuestion {
	protected static String sender;
	protected static String subject;
	protected static String question;
	private static int id;

	public static void setData() {
		// TODO Auto-generated method stub
		sender = txtFieldFrom.getText();
		subject = txtFieldSubject.getText();
		question = txtAreaQuestion.getText();

	}

	public static int checkError() {
		// TODO Auto-generated method stub
		int error;
		if(sender.isEmpty() || subject.isEmpty() || question.isEmpty() ){

			error = 1;
		}
		else{
			error = 0;
		}
		return(error);
	}

	public static void insertData(){
		try{
			Connection con = DatabaseConnection.makeConnetion();
			String sqlInsert="INSERT INTO  faqs (sender, subject, question, answer) VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1,sender);
			ps.setString(2,subject );
			ps.setString(3, question);
			ps.setString(4,"");
			//			JOptionPane.showMessageDialog(null, sender+subject+question);
			//			ps.execute();
			if(ps.executeUpdate() == 1){
				JOptionPane.showMessageDialog(null,"Question sent SUCCESSFULL! :D");
			}
			else{
				JOptionPane.showMessageDialog(null, "Question not sent!");
			}

		}catch(SQLException se){
			JOptionPane.showMessageDialog(null, "SQL Error");
			se.printStackTrace();
		}
	}

	public static ResultSet getTableData() {
		// TODO Auto-generated method stub
		try{
			Connection conn = DatabaseConnection.makeConnetion();
			String sqlSelect = "SELECT id, subject, question, answer FROM faqs";
			PreparedStatement ps = conn.prepareStatement(sqlSelect);
			ResultSet rs = ps.executeQuery();
			return (rs);
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error Loading FAQs Replies");
			return(null);
		}
	}

	public static void setId(int id) {
		// TODO Auto-generated method stub
		AskAQuestionActionAndEvents.id = id;
	}

	public static int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public static void view(int id) {
		// TODO Auto-generated method stub
		AskAQuestionActionAndEvents.id = id;
		try{
			Connection con = (Connection) DatabaseConnection.makeConnetion();
			String sqlView= "SELECT id, subject, question, answer FROM faqs WHERE id =?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sqlView);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();

			JOptionPane.showMessageDialog(null,"" + "ID: " +
					rs.getInt("id") + "\n" + "Subject: " +
					rs.getString("subject") + "\n" + "Question: " +
					rs.getString("question") + "\n" + "Answer: " +
					rs.getString("answer")					 
					);

		}catch(SQLException e){
			e.printStackTrace();
		}


	}

	public static ResultSet advancedSearch() {
		// TODO Auto-generated method stub
		try{
			Connection conn = (Connection) DatabaseConnection.makeConnetion();
			String sqlSearch= "SELECT id, subject, question, answer FROM faqs WHERE "
					+ " (subject LIKE ?) "
					+ "AND (question LIKE ?)"
					+ " AND (answer LIKE ?) ";
			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sqlSearch);
			ps.setString(1,"%" + AskAQuestionActionAndEvents.txtSubjectAdvancedSearch.getText() + "%");
			ps.setString(2, "%" + AskAQuestionActionAndEvents.txtQuestionAdvancedSearch.getText() + "%");
			ps.setString(3, "%" + AskAQuestionActionAndEvents.txtAnswerdvancedSearch.getText() + "%");
			ResultSet rs = ps.executeQuery();
			return(rs);
		}catch(java.lang.NullPointerException emptyData){
			emptyData.printStackTrace();
			JOptionPane.showMessageDialog(null,"No Data Found!");
			return(null);
		}
		catch(SQLException e ){
			//JOptionPane.showMessageDialog(null, "No result Found");
			e.printStackTrace();
			return(null);
		}
		
	}
}
