package chat.model;

public class Chatbot 
{
	private String name;
	
	public Chatbot()
	{
		this.name = "placeholder";
	}
	
	@Override
	public String toString()
	{
		String description = "I am a chat bot!";
		description += "Ask me a question!";
		return description;
	}
}
