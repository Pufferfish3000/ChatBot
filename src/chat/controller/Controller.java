package chat.controller;

import java.util.*;

import chat.model.Chatbot;
public class Controller 
{
	private Scanner scan = new Scanner(System.in);
	private Chatbot myChatbot;
	String user;
	public Controller()
	{
	this.myChatbot = new Chatbot("default name");	
	}
	
	public void main()
	{
		System.out.println("Hi I am a chat bot!");
		System.out.println("Please enter my name below!");
		user = scan.nextLine();
		myChatbot.setBotName(user);
		System.out.println(myChatbot);
	}

}
