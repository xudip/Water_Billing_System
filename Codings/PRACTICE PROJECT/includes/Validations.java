package includes;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
public class Validations{

	public static void numberValidate(KeyEvent e, char c1){
		char c = c1;
		if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))){
			{
				e.consume();
			}
		}
	}

	public static void alphabetValidate(KeyEvent e , char c){
		if( !((c>=97 && c<=122) || (c>=65 && c<=90) || (c==KeyEvent.VK_BACK_SPACE ) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SPACE))){
			e.consume();
		}

	}

	public static boolean emailValidate( String email1){
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Boolean b = email1.matches(EMAIL_REGEX);
		return(b);	
	};


}
