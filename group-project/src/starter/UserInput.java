package starter;

import javax.swing.JOptionPane;


public class UserInput {
	public static void main(String[] args) {
		String input = "";
		input = JOptionPane.showInputDialog("Enter your username: ");
		
		if (input != null && ValidateInput(input) == true) {
			JOptionPane.showMessageDialog(null, "Valid name.");
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid name.");
		}
	}
	
	public static boolean ValidateInput(String input) {
		return input.length() > 5;
	}
}
