import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game implements ActionListener {	
	private JFrame frame;
	private JPanel panel;
	public static JButton buttonRock = new JButton("Rock");
	public static JButton buttonPaper = new JButton("Paper");
	public static JButton buttonScissors= new JButton("Scissors");
	
	int computerPoints = 0;
	int userPoints = 0;
	int roundNumber = 0;
	String verdict;
	
	JLabel welcome = new JLabel("Welcome to Rock Paper Scissors");
	JLabel computerGo = new JLabel();
	JLabel userGo = new JLabel();
	JLabel points = new JLabel("User: 0 Computer : 0 ");
	JLabel result = new JLabel( verdict);
	JLabel round = new JLabel("Round : " +roundNumber);
	
	public Game() {
		frame = new JFrame();
		buttonRock.addActionListener( this);
		buttonPaper.addActionListener(this);
		buttonScissors.addActionListener(this);
		
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
		panel.add(computerGo);
		panel.add(userGo);
		panel.add(points);
		
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
		new Game();
	}
	
	@Override
	public  void actionPerformed(ActionEvent event) {
		roundNumber++;
		String userInput = event.getActionCommand();
		round.setText("Round: "+ roundNumber);	
		
		int userValue = ValueSetter.setValue(userInput.toLowerCase());	 
		int computerValue = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		String computerName = ValueSetter.getValue(computerValue);

		computerGo.setText("Computer went "+ computerName );
		userGo.setText("You went " + userInput);
			
		if (computerValue  == userValue) {
			verdict = "Round was draw!";
		} else if ((computerValue == 1 && userValue == 3)
				|| computerValue == 2 && userValue == 1
				|| computerValue == 3 && userValue == 2) {
			computerPoints++;
			verdict = "Computer won round.";	
			} else {
			userPoints++;
			verdict = "Player won round.";
			}
			
		boolean isGameOver = false;
		if ((computerPoints == 3) ||( userPoints == 3)) {
		 if (computerPoints == 3) {
				verdict = "Computer won the game!";
		} else if( userPoints == 3) {
				verdict = "User won the game!";
		}
				
		isGameOver = true;
		}
			
		points.setText("Users points = " + userPoints+ " Computers points = " + computerPoints);
		panel.add(result);
		result.setText(verdict);
		ButtonAdder.toggleButtons(!isGameOver);
	}
}