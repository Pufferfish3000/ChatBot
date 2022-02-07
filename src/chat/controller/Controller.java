package chat.controller;

import java.util.*;
import chat.model.Chatbot;
import chat.view.*;
import chat.controller.*;

import java.io.*;

public class Controller 
{
	private Scanner scan = new Scanner(System.in);
	private Chatbot myChatbot;
	private Popup view;
	private Frame window;
    private Popup popup;
    public String userInput;
    
	String user;
	String chatName;
	String response;
	
	public Controller()
	{
	this.myChatbot = new Chatbot("default name");
	//this.view = new Popup();
  
    
    this.window = new Frame(this);
	}
	
	public void start()
	{
//		ArrayList<String> input = loadTextToList("user input.txt");
//		myChatbot.setUserInputs(input);
//		input = loadTextToList("chat.txt");
//		myChatbot.setChatbotRespomses(input);
//		
//		
//		
//		displayText("Hi I am a chat bot!");
//		chatName = view.askQuestion("Please enter my name below!");
//		
//		myChatbot.setBotName(chatName);
//		view.displayMessage("My name is " + myChatbot.getName()+ "!");
//		String user = view.askQuestion("ask me a question!");
//		
//		while(!user.equalsIgnoreCase("quit"))
//		{
//			String response = interactWithChatbot(user);
//			user = view.askQuestion(response);
//		}
//		displayText("Killing " + chatName + " please wait.");
//		displayText(chatName+ " has been killed. Thank you!");
//		displayText(myChatbot.getMostCommonWord(myChatbot.getUserInputs()));
//		
//		displayText("LETS SAVE SOME TEXT!");
//		saveListAsText(myChatbot.getUserInputs(), "user input.txt"); 
//		saveListAsText(myChatbot.getChatbotResonses(), "chat output.txt");
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
	
	public void getChatData(String chatInput)
	{
		userInput = chatInput;
	}
	

}
