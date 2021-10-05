package chat.controller;

import java.util.*;
import chat.model.Chatbot;
import chat.view.Popup;

public class Controller 
{
	private Scanner scan = new Scanner(System.in);
	private Chatbot myChatbot;
	private Popup view;
	
	String user;
	String chatName;
	String response;
	
	public Controller()
	{
	this.myChatbot = new Chatbot("default name");
	this.view = new Popup();
	}
	
	public void main()
	{
		view.displayMessage("Hi I am a chat bot!");
		chatName = view.askQuestion("Please enter my name below!");
		
		myChatbot.setBotName(chatName);
		view.displayMessage("My name is " + myChatbot.getName()+ "!");
		String user = view.askQuestion("ask me a question!");
		
		while(!user.equalsIgnoreCase("quit"))
		{
			String response = interactWithChatbot(user);
			user = view.askQuestion(response);
		}
		view.displayMessage("Killing " + chatName + " please wait.");
		
		view.displayMessage(chatName+ " has been killed. Thank you!");
	}
	
	public String interactWithChatbot(String text)
	{
		response = "";
		response += myChatbot.processText(text);
		
		return response;
		
	}

}
