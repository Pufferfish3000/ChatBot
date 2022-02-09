package chat.view;

import chat.controller.*;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private Controller controller;
	private ChatPanel panel;
	
	public ChatFrame(Controller controller)
	{
		super();
		this.controller = controller;
		this.panel = new ChatPanel(controller);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(panel);
		this.setSize(700,300);
		this.setTitle("ChatBot");
		this.setResizable(true);
		this.setVisible(true);
	}
}
