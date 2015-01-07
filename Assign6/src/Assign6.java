//
//
//

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Assign6 extends JApplet implements ActionListener 
{
	JTextField question, input, response;
	JLabel prompt;
	int answer, guess;
	String questionString;
	
	public void init()
	{
		// set guess to validate value and existence of user input
		guess = -999;
		
		// create test fields and a label
		question = new JTextField( 20 );
		question.setEditable( false );
		
		prompt = new JLabel( "Input your answer: ");
		
		input = new JTextField( 4 );
		input.addActionListener( this );
		
		// add components to applet
		Container container = getContentPane();
		container.setLayout( new FlowLayout() );
		container.add( question );
		container.add( prompt );
		container.add( input );
		
		// generate a question
		generateQuestion();
	}
	
	// show if user input is correct or not 
	public void paint( Graphics g )
	{
		super.paint( g );
		
		// determine whether user input is correct
		// if value is not valid, indicate as such
		if ( guess != -999 )
		{
			if ( guess != answer )
				g.drawString( "No. Please try again.", 20, 70 );
			else
			{
				g.drawString( "Very good!" , 20, 70 );
				generateQuestion();
			}
			
			guess = -999;
				
		}
	}
	
	// verify the user input
	public void actionPerformed( ActionEvent e )
	{
		guess = Integer.parseInt( input.getText() );
		
		// clear the text field
		input.setText( "" );
		
		// display the correct answer
		repaint();
	}
	
	// generate new question and correct answer
	public void generateQuestion()
	{
		// generate new numbers between 1 and 9
		int number1 = ( int ) ( Math.random() * 10 );
		int number2 = ( int ) ( Math.random() * 10 );
		
		answer = number1 * number2;
		questionString = "How much is " + number1 + " times " +
		number2 + "?";
		
		// add to applet
		question.setText( questionString );
	}
	
	
	
}// end class Assign6