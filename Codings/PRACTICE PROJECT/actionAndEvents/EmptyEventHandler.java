package actionAndEvents;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JOptionPane;

import layout.*;

public class EmptyEventHandler{
	String username, password;
	 public EmptyEventHandler(String username, String password){
		this.username = username;
		this.password = password;
		
		if(username.equals(null)){
			LogInLayout.txtUsername.setBackground(new Color(153, 0, 51));
		}
		
		if(password == null){
			LogInLayout.txtUsername.setText("Cannot Be Empty!");
//			JOptionPane.showMessageDialog(null, "DSFLKJ");
		}
	
	}
}
