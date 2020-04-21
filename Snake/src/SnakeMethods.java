import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SnakeMethods extends SnakeMain {
	public static int hold = 0;
	public  static void drawBox( ) {
		try{
			hold = 0;
			Rectangle snakey = new Rectangle(snakePos.get(0), snakePos.get(1), 15, 15);
			snakey.setFill(Color.DARKGREEN);
			snake.add(snakey);
			Thread.sleep(1000);
			hold = 1;
		}
		catch (Exception e)
    	{
    	e.printStackTrace();
    	}
	 
	}
	

	
	
	public static void move(String direct) {
		int x = snakePos.get(0);
		int y = snakePos.get(1);
		switch(direct){
			case "left":
				 x = x-15;
				break;
			case "right":
				 x = x+15;
				 break;
			case "up":
				  y = y-15;
				break;
			case "down":
				 y = y+15;
				// break;
			default:
				break;
		}
		snakePos.set(0, x);
		snakePos.set(1, y);
     	SnakeMethods.drawBox();
		Rectangle k = snake.get(snake.size()-1);
		root.getChildren().add(k);
		root.getChildren().remove(0);
	
		
	}
}

