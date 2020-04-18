import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gui implements ActionListener {
	
	
	private int count = 0;
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	JButton buttonRock = new JButton("rock");
	JButton buttonPaper = new JButton("paper");
	JButton buttonScissors= new JButton("Scissors");
	JButton buttonNext= new JButton("Next");
	JLabel welcome = new JLabel("Welcome to Rock Paper Scissors");
	JLabel computerGo = new JLabel();
	JLabel userGo = new JLabel();
	JLabel points = new JLabel("User: 0 Computer : 0 ");
	String verdict;
	JLabel result = new JLabel( verdict);
	JLabel testing = new JLabel();
	int roundNumber = 0;
	JLabel round = new JLabel("round : " +roundNumber);
	
	public gui() {
	int userValue;
	String userInput;
		 frame = new JFrame();
		
		
		
		
		buttonRock.addActionListener( this);
		buttonPaper.addActionListener(this);
		buttonScissors.addActionListener(this);
		buttonNext.addActionListener(this);
		
		
		JLabel rockpaperscissors = new JLabel("Rock, paper scissors?");
		
		
		
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(60,60,20,60));
		panel.setLayout(new GridLayout(0 , 1));
		panel.add(welcome);
		panel.add(rockpaperscissors);
		panel.add(round);
		
		panel.add(buttonRock);
		panel.add(buttonPaper);
		panel.add(buttonScissors);
		
		
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Rock, paper scissors");
		frame.pack();
		frame.setVisible(true);
		
		buttonRock.setActionCommand("rock");
		buttonPaper.setActionCommand("paper");
		buttonScissors.setActionCommand("scissors");
		
		
	}

	public static void main(String[] args) {
		new gui();

	
	}

	int computerPoints = 0;
	int userPoints = 0;
	
	@Override
	public  void actionPerformed(ActionEvent event) {
		
		String userInput = event.getActionCommand();
		roundNumber++;
		round.setText("Round: "+ roundNumber);
		
		
			
			//userInput then assigns input a value
			
			
			int userValue = ValueSetter.setValue(userInput.toLowerCase());
			
				 
			// assigns computer a value, then gives it a corresponding name
			int computerValue = ThreadLocalRandom.current().nextInt(1, 3 + 1);
			String computerName = ValueSetter.getValue(computerValue);
			panel.add(computerGo);
			panel.add(userGo);
			panel.add(points);
			computerGo.setText("Computer went "+ computerName );
			userGo.setText("You went " + userInput);
			//panel.add(testing);
			//testing.setText(ValueSetter.getValue(computerValue) + ValueSetter.getValue(userValue));
			// is draw
			panel.add(result);
			result.setText(verdict);
			if (computerValue  == userValue) {
				verdict = "Draw!";
				result.setText(verdict);
			}
			// has computer won?
			else if ((computerValue == 1 && userValue == 3)
					|| computerValue == 2 && userValue == 1
					|| computerValue == 3 && userValue == 2) {
				computerPoints++;
				verdict = "Computer won round";
				if(computerPoints == 3) { 
					verdict = "Computer won game!";
					buttonRock.setVisible(false);
					buttonPaper.setVisible(false);
					buttonScissors.setVisible(false);
					result.setText(verdict);
					points.setText("Userpoints = " + userPoints+ " Computerpoints" + computerPoints);
				
				} else {
					points.setText("Userpoints = " + userPoints+ " Computerpoints" + computerPoints);
				 	panel.add(result);
					result.setText(verdict);
					panel.add(result);
					result.setText(verdict);
					
				}
			}
			// assume user won
			else {
				userPoints++;
				points.setText("Userpoints = " + userPoints+ " Computerpoints" + computerPoints);
				if(userPoints == 3) {
					panel.add(result);
					result.setText(verdict);
					buttonRock.setVisible(false);
					buttonPaper.setVisible(false);
					buttonScissors.setVisible(false);
					
				} else {
					panel.add(result);
					result.setText(verdict);
				}
				
				
			}	
			 	
			
				
			
		
	
		
	}


}

 	