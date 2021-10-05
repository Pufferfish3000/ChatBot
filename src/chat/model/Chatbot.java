package chat.model;

import java.time.*;
import java.util.*;

public class Chatbot 
{
	private String name;
	private int greetingCount;
	private int farewellCount;
	private ArrayList<String> politicList = new ArrayList<String>();
	private ArrayList <String> randList = new ArrayList<String>();
	
	public Chatbot(String name)
	{
		this.name = name;
		this.greetingCount = 0;
		this.farewellCount = 4;
		
		this.politicList.add("politics");
		this.politicList.add("republican");
		this.politicList.add("democrat");
		this.politicList.add("election");
		this.politicList.add("biden");
		
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
	
	private String getRandomTopic() 
	{
		String botRandom = "";
		int randomIndex = (int) (Math.random() * randList.size());
		
		botRandom = randList.get(randomIndex);
		
		return botRandom;
	}
	
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
	
	public boolean containsQuestion(String question)
	{
		question = "";
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
		
		return answer;
	}
	
	@Override
	public String toString()
	{
		String description = "I am a chat bot!, my name is " + name + "\n";
		description += "Ask me a question!";
		return description;
	}
}