package chat.model;

public class Chatbot 
{
	private String name;
	
	public Chatbot(String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		String description = "I am a chat bot!, my name is " + name + "\n";
		description += "Ask me a question!";
		return description;
	}
}
