package chat.view;

import chat.controller.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.GridLayout;

public class Panel extends JPanel
{
	private Controller controller;
	private JButton runButton;
	private JTextField objectName;
	public JSpinner spinner;
	public JScrollPane scrollLol;
	public JTextArea textAreaScroll;
	
	Panel(Controller controller)
	{
		super();
		//JSCROLL PANE
		this.textAreaScroll = new JTextArea(5, 30);
		this.scrollLol = new JScrollPane(textAreaScroll);
		this.controller = controller;
		this.runButton = new JButton("Chat With ChatBot!");
		this.objectName = new JTextField ("Type Text!", 10);
		
		setupPanel();
		setUpListeners();
	}
	
	public void setupPanel()
	{	
		this.setBackground(Color.DARK_GRAY);
		this.setSize(800, 600);
		this.add(textAreaScroll);
		this.add(objectName);
		this.add(runButton);
		
	}
	
	private void setUpListeners()
	{
		runButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click) 
			{
				controller.getChatData(getTextField());
				getTextField();
				textAreaScroll.append("TESSSSSSSTTSTSTSTSTT");
				
			}
		});
	}
	
	
	public String getTextField()
	{
		String textFieldValue = objectName.getText();
		return textFieldValue;
	}
	
	public String getChatIDKlol()
	{
		String stringy = "";
		
		return stringy;
	}
}
