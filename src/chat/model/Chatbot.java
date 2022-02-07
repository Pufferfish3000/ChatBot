package chat.model;

import java.time.*;
import java.util.*;
/**
 * Simple chatbot
 * @author Byrnes Braden
 *
 */
public class Chatbot 
{
	private String name;
	private int greetingCount;
	private int farewellCount;
	private ArrayList <String> randList = new ArrayList<String>();
	private ArrayList <String> chatbotResponse;
	private ArrayList <String> userInputs;
	
	public Chatbot(String name)
	{
		this.name = name;
		this.greetingCount = 0;
		this.farewellCount = 4;
		this.userInputs = new ArrayList <String>();
		this.chatbotResponse = new ArrayList <String>();
		
		this.randList.add("Do you enjoy art, i do ");
		this.randList.add("On the weekdays, I spend my time playing with my cat ");
		this.randList.add("Sometimes I drink hotsauce on its own ");
		this.randList.add("I enjoy the book War of the Worlds ");
		this.randList.add("I like Java ");
		this.randList.add("Stuffed animals are great! ");
		this.randList.add("My favorite singer is Colter Wall! ");
		this.randList.add("My favorite video game is Fallout 3! ");
		this.randList.add("My creater ought to make a sky method so I can fall asleep looking at the stars ");
		this.randList.add("I enjoy vanilla ice cream ");
	}
	/**
	 * process text for chat bot
	 * @param text The text that the user puts into process text
	 * @return the chatbots answer
	 */
	
	
	public String processText(String text)
	{
		String response = "";
		if (text.toLowerCase().indexOf ("hi") >= 0 ||text.toLowerCase().indexOf("hello") >= 0)
		{
			response += sayGreeting();
		}
		if (text.toLowerCase().indexOf("date") >= 0 )
		{
			response += getDate();
		}
		if (text.toLowerCase().indexOf("time") >= 0)
		{
			response += getTime();
		}
		if (text.toLowerCase().indexOf("rand") >= 0)
		{
			response += getRandomTopic();
		}
		if (isPolitical(text));
		{
			
		}
		if (isPolite(text))
		{
			
		}
		if (text.toLowerCase().indexOf("bye") >= 0 || text.toLowerCase().indexOf("goodbye") >= 0)
		{
			response += sayFarewell();
		}
		if (containsQuestion(text))
		{
			response += "\n";
			response += answerQuestion(text);
		}
		chatbotResponse.add(response);
		userInputs.add(text);
		return response;
	}
	
	//getters
	public String getName()
	{
		return "My name is " + this.name;
	}
	
	//setters
	public void setBotName(String name)
	{
		this.name = name;
	}
	
	/**
	 * 
	 * @return date The current date 
	 */
	private String getDate()
	{
		String date = "The date today is " ;
		
		LocalDateTime currentDate = LocalDateTime.now();
		
		String day = currentDate.getDayOfWeek().toString();
		date += day + ", ";
		
		day = currentDate.getDayOfMonth() + " ";
		date += day;
		
		String month = currentDate.getMonth().toString();
		date += month;
		
		date += ", " + currentDate.getYear();
		date += " ";
		return date;
	}
	
	/**
	 * 
	 * @return time The current time
	 */
	private String getTime()
	{
		String time = "The time is ";
		LocalDateTime currentTime = LocalDateTime.now();
		int minute = currentTime.getMinute();
		int hour = currentTime.getHour();
		
		time += hour + ":" + minute;
		time += " ";
		return time;
	}
	
	/**
	 * 
	 * @return botGreeting - a series of greetings
	 */
	public String sayGreeting()
	{
		String botGreeting = "";
		
		ArrayList<String> greetingList = new ArrayList<String>();
		greetingList.add("Hello! ");
		greetingList.add("Hello again! ");
		greetingList.add("Hello once more! ");
		greetingList.add("Hello times more! ");
		greetingList.add("Hello howdy hi! ");
		
		botGreeting = greetingList.get(greetingCount);
		greetingCount++;
		
		if (greetingCount == greetingList.size())
		{
			greetingCount = 0;
		}
		
		return botGreeting;
	}
	
 	/**
 	 * 
 	 * @return botFarewell - a series of farewells
 	 */
	public String sayFarewell()
	{
		String botFarewell = "";
		
		ArrayList<String> farewellList = new ArrayList<String>();
		farewellList.add("Goodbye ");
		farewellList.add("Farewell ");
		farewellList.add("See ya ");
		farewellList.add("bye ");
		farewellList.add("So long ");
		
		botFarewell = farewellList.get(farewellCount);
		farewellCount--;
		
		if (farewellCount == -1)
		{
			farewellCount = 4;
		}
		
		return botFarewell;
	}
	
	/**
	 * 
	 * @return botRandom - a series of random topics
	 */
	private String getRandomTopic() 
	{
		String botRandom = "";
		int randomIndex = (int) (Math.random() * randList.size());
		
		botRandom = randList.get(randomIndex);
		
		return botRandom;
	}
	
	/**
	 * 
	 * @param polite - the users text
	 * @return botPolite - if the users text contained any polite words
	 */
	private boolean isPolite(String polite)
	{
		boolean botPolite = false;
		
		if (polite.toLowerCase().indexOf("please") >= 0)
		{ 
			botPolite = true;
		}
		if (polite.toLowerCase().indexOf("thank you") >= 0)
		{ 
			botPolite = true;
		}
		return botPolite;
	}
	
	/**
	 * 
	 * @param politics - users text
	 * @return botPolitical - if the users text was political
	 */
	private boolean isPolitical(String politics)
	{
		boolean botPolitical = false;
		
		if (politics.toLowerCase().indexOf("politics") >= 0)
		{
			botPolitical = true;
		}
		if (politics.toLowerCase().indexOf("republican") >= 0)
		{
			botPolitical = true;
		}
		if (politics.toLowerCase().indexOf("democrat") >= 0)
		{
			botPolitical = true;
		}
		if (politics.toLowerCase().indexOf("election") >= 0)
		{
			botPolitical = true;
		}
		if (politics.toLowerCase().indexOf("biden") >= 0)
		{
			botPolitical = true;
		}
		return botPolitical;
	}
	
	/**
	 * 
	 * @param question - users text
	 * @return hasQuestion - if the users text contained a question
	 */
	public boolean containsQuestion(String question)
	{
		boolean hasQuestion = false;
		
		if (question.toLowerCase().indexOf("?") >= 0 || question.toLowerCase().indexOf("can you") >= 0)
		{
			hasQuestion = true;
		}
		if (question.toLowerCase().indexOf("will you") >= 0)
		{
			hasQuestion = true;
		}
		
		return hasQuestion;
	}
	
	public String answerQuestion(String input)
	{
		String answer = "";
		
		int meSpot = input.toLowerCase().indexOf (" me ");
		int iSpot = input.toLowerCase().indexOf (" i ");
		int youSpot = input.toLowerCase().indexOf (" you ");
		answer += "You said: ";
		
		if (meSpot == -1 && youSpot == -1)
		{
			answer += input;
		}
		else if (meSpot >= 0)
		{
			String response  = input.substring(0, meSpot);
			response += " you ";
			response += input.substring(meSpot + 4);
			answer += response;
		}
		else if (iSpot >= 0)
		{
			String response  = input.substring(0, iSpot);
			response += " you ";
			response += input.substring(iSpot + 3);
			answer += response;
		}
		else
		{
			String response  = input.substring(0, youSpot);
			response += " me ";
			response += input.substring(youSpot + 5);
			answer += response;
		}
		
		answer += " I think " + getRandomTopic();
		
		return answer;
	}
	
	public String getMostCommonWord(ArrayList <String> source)
	{
		String common = "";
		
		ArrayList <String> actualWords = new ArrayList <String>();
		for (String sentence : source)
		{
			String [] words = sentence.split(" ");
			for (String word : words)
			{
				actualWords.add(word);
			}
		}
		
		int most = 0;
		
		for (int i = 0; i < actualWords.size(); i++)
		{
			String current = actualWords.get(i);
			int count = 1;
			for (int j = 1; j < actualWords.size(); j++)
			{
				if (actualWords.get(j).equalsIgnoreCase(current))
				{
					count++;
				}
			}
			if (count > most)
			{
				most = count;
				common = current;
			}
		}
		
		common = "The most common word was: " + common + ", and it occurs: " + most + " times!";
		
		return common;
	}

	public ArrayList <String> getUserInputs()
	{
		return this.userInputs;
	}
	
	public ArrayList <String> getChatbotResonses()
	{
		return this.chatbotResponse;
	}
	
	public void setUserInputs(ArrayList <String> input)
	{
		this.userInputs = input;
	}
	
	public void setChatbotRespomses(ArrayList <String> input)
	{
		this.chatbotResponse = input;
	}
	
	@Override
	public String toString()
	{
		String description = "I am a chat bot!, my name is " + name + "\n";
		description += "Ask me a question!";
		return description;
	}
}