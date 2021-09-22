package chat.controller;

import java.util.*;
import chat.model.Chatbot;

public class Controller 
{
	private Scanner scan = new Scanner(System.in);
	private Chatbot myChatbot;
	String user;
	String ChatName;
	String response;
	
	public Controller()
	{
	this.myChatbot = new Chatbot("default name");	
	}
	
	public void main()
	{
		System.out.println("Hi I am a chat bot!");
		System.out.println("Please enter my name below!");
		ChatName = scan.nextLine();
		myChatbot.setBotName(ChatName);
		System.out.println(myChatbot);
		
		user = scan.nextLine();
		while(!user.contentEquals("quit"))
		{
			String response = interactWithChatbot(user);
			System.out.println(response);
			user = scan.nextLine();
		}
		System.out.println("Killing " + ChatName + ".....");
	}
	
	public String interactWithChatbot(String text)
	{
		response = "";
		response += myChatbot.processText(text);
		
		return response;
		
	}

}
