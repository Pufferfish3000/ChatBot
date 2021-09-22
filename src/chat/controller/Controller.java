package chat.controller;

import java.util.*;

import chat.model.Chatbot;
public class Controller 
{
	private Scanner scan = new Scanner(System.in);
	private Chatbot myChatbot;
	public Controller()
	{
	this.myChatbot = new Chatbot("default name");	
	}
	
	public void main()
	{
		System.out.print(myChatbot);
	}

}
