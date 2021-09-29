package chat.model;

import java.time.*;
import java.util.*;

public class Chatbot 
{
	private String name;
	private int greetingCount;
	private int farewellCount;
	private ArrayList<String> politicList = new ArrayList<String>();
	
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
	}
	
	public String processText(String text)
	{
		String response = ">";
		if (text.toLowerCase().indexOf ("hi") >= 0 ||text.toLowerCase().indexOf("hello") >= 0)
		{
			response += sayGreeting();
		}
		if (text.toLowerCase().indexOf("bye") >= 0 || text.toLowerCase().indexOf("goodbye") >= 0)
		{
			response += sayFarewell();
		}
		if (text.toLowerCase().indexOf("date") >= 0 )
		{
			response += getDate();
		}
		if (text.toLowerCase().indexOf("time") >= 0)
		{
			response += getTime();
		}
		if (isPolitical(text));
		{
			
		}
		if (isPolite(text))
		{
			
		}
		return response;
	}
	
	//getters
	public String getBotName()
	{
		return this.name;
	}
	
	//setters
	public void setBotName(String name)
	{
		this.name = name;
	}
	
	public String getDate()
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
	
	public String getTime()
	{
		String time = "The time today is ";
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
	
	public String randomTopic() 
	{
		String botRandom = "";
		
		return botRandom;
	}
	
	public boolean isPolite(String polite)
	{
		boolean botPolite = false;
		
		return botPolite;
	}
	
	public boolean isPolitical(String politics)
	{
		boolean botPolitical = false;
		for (int i = 0; i < politicList.size(); i++)
		{
			
		}
		
		return botPolitical;
	}
	
	@Override
	public String toString()
	{
		String description = "I am a chat bot!, my name is " + name + "\n";
		description += "Ask me a question!";
		return description;
	}
}
