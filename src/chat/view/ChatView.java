package chat.view;

import javax.swing.JOptionPane;

public class ChatView 
{
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}
	
	public String askQuestion(String question)
	{
		String response = "";
		response = JOptionPane.showInputDialog(null,question);
		
		if (response == null)
		{
			response = "";
		}
		return response;
	}
}
