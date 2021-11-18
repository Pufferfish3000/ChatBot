package chat.controller;

import java.util.*;
import chat.model.Chatbot;
import chat.view.Popup;
import java.io.*;

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
	
	public void start()
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
		view.displayMessage(myChatbot.getMostCommonWord(myChatbot.getUserInputs()));
		
		
	}
	
	public void handleError(Exception error)
	{
		String details = "your error is " + error.getMessage();
		view.displayMessage(details);
	}
	
	public String interactWithChatbot(String text)
	{
		response = "";
		response += myChatbot.processText(text);
		
		return response;
	}
	
	private void saveListAsText(ArrayList <String> responses, String filename)
	{
		File saveFile = new File(filename);
		
		try (PrintWriter saveText = new PrintWriter(saveFile))
		{
			for (String content : responses)
			{
				saveText.println(content);
			}
		}
		catch(IOException errorFromIO)
		{
			handleError(errorFromIO);
		}
		catch(Exception genericError) 
		{
			handleError(genericError);
		}
	}
	
	private ArrayList<String> loadTextToList(String filename)
	{
		ArrayList<String> fileContents = new ArrayList<String>();
		
		File source = new File(filename);
		
		try(Scanner fileScanner = new Scanner(source))
		{
			while (fileScanner.hasNextLine())
			{
				fileContents.add(fileScanner.nextLine());
			}
		}
		catch(IOException fileError)
		{
			handleError(fileError);
		}
		catch(Exception error)
		{
			handleError(error);
		}
		
		return fileContents;
	}

}
