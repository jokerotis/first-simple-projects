import java.util.ArrayList;
import javafx.scene.paint.Color;

public class SnakeMovement extends Grid{
	public static ArrayList<Integer> snakePos = new ArrayList<Integer>();
	
	static int num = 0;
	static int number =5;
	public  static void drawSnake( ) {
		
	snakePos.add(200 + num);
	num++;
	Grid.gridBoxes.get(snakePos.get(snakePos.size()-1)).setFill(Color.GREEN);
	}
	
	public  static void moveSnake(int direct ) {
	int grow = 0;	
	int snakeHead =snakePos.get(0);
		number++;
		switch(direct) {
		case +1:
			snakePos.add(0,snakeHead+1);
			break;
		case -1:
			snakePos.add(0,snakeHead-1);
			break;
		case +45:
			snakePos.add(0,snakeHead+45);
			break;
		case -45:
			snakePos.add(0,snakeHead-45);
			break;
		}
		
		
		if(Main.appleLocation == snakeHead) {
			Main.isApple = false;
			AppleGen.appleGen();
			Main.snakeSize++;
			Main.scores++;
			Main.speed = (int) (Main.speed *0.95);
			ScoreBoard.score();
			System.out.println(Main.scores);
			grow =  snakeHead+ Main.direction;
		
		} 
		// is snake on border?
		if(Grid.gridBorder.contains(snakeHead)) {
			 Main.running =false;
			 Main.launch = false;
			return;
		}
		if(gridBoxes.get(snakeHead+Main.direction).getFill() == Color.GREEN) {
			Main.running =false;
			 Main.launch = false;
			return;
		}
			Grid.gridBoxes.get(snakeHead).setFill(Color.GREEN);
			Grid.gridBoxes.get(snakePos.get(Main.snakeSize)).setFill(Color.LAVENDER);
			if(grow != 0) {
				Grid.gridBoxes.get(grow).setFill(Color.GREEN);
			}
		}
}

