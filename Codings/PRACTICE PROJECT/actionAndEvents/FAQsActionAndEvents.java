package actionAndEvents;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.*;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import includes.*;



public class FAQsActionAndEvents {
	Object[][] data = new Object[100][100];
	static int id;


	public static ResultSet getData(){
		try{

			Connection con = (Connection) DatabaseConnection.makeConnetion();
			String sql="SELECT * from faqs";
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
			String sqlView = "SELECT subject, question, answer FROM faqs WHERE id=? ";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sqlView);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String ans = JOptionPane.showInputDialog(rs.getString("subject") + "\n" + rs.getString("question"));
			if(ans != ""){
				update(id,ans);
			}
			else{
				JOptionPane.showMessageDialog(null,"Answer is empty");
			}
			//JOptionPane.showMessageDialog(null, ans);
		}catch(Exception e ){
			System.out.println(e);
		}

	}

	public static void update(int id, String ans){
		try{
			Connection con = (Connection) DatabaseConnection.makeConnetion();
			String sqlUpdate = "UPDATE faqs SET answer = ? WHERE id = ?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sqlUpdate);
			ps.setString(1,ans);
			ps.setInt(2, id);
			if(ps.executeUpdate()==1){
				JOptionPane.showMessageDialog(null, "Answer saved");
			}
			else{
				JOptionPane.showMessageDialog(null, "ANswer not saved");
			}
		}catch(Exception e){
			System.out.println(e);
		}


	}

	public static void delete(int id1){
		id = id1;
		try{
			Connection con = (Connection) DatabaseConnection.makeConnetion();
			String sqlDelete = "DELETE FROM faqs WHERE id = ?";
			PreparedStatement psDelete = (PreparedStatement) con.prepareStatement(sqlDelete);
			psDelete.setInt(1, id);
			//psDelete.executeUpdate();

			if(psDelete.executeUpdate() == 1){
				JOptionPane.showMessageDialog(null, "DELETED! id = " + id);
			}


		}
		catch(Exception se){
			//			System.out.println(se);
			JOptionPane.showMessageDialog(null, "Delete Unsuccessfull!");
		}
	}

	
}
