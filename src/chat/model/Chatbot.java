package chat.model;

import java.time.*;

public class Chatbot 
{
	private String name;
	
	public Chatbot(String name)
	{
		this.name = name;
	}
	
	public String processText(String text)
	{
		
		String response = ">";
		if (text.equalsIgnoreCase("date") )
		{
			response += getDate();
		}
		else if (text.equalsIgnoreCase("time"))
		{
			response += getTime();
		}
//		switch (text)
//		{
//		case : text = "date";
//		}
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
		return date;
	}
	
	public String getTime()
	{
		String time = "The time today is ";
		LocalDateTime currentTime = LocalDateTime.now();
		int minute = currentTime.getMinute();
		int hour = currentTime.getHour();
		
		time += hour + ":" + minute;
		return time;
	}
	
	public String sayGreeting()
	{
		String botGreeting = "";
		
		return botGreeting;
	}
	
	public String sayFarewell()
	{
		String botFarewell = "";
		
		return botFarewell;
	}
	
	public String randomTopic() 
	{
		String botRandom = "";
		
		return botRandom;
	}
	
	public boolean isPolite()
	{
		boolean botPolite = false;
		
		return botPolite;
	}
	
	public boolean isPolitical()
	{
		boolean botPolitical = false;
		
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
