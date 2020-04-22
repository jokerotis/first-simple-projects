import java.util.TimerTask;
public class TaskTime extends TimerTask {
	public void run() {
		if(Main.running) {
			try
			{
			    Thread.sleep(Main.speed);
			    SnakeMovement.moveSnake(Main.direction);
			}
			catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
			
		}
		
		if(!Main.launch) {
			Main.endGame.setText("GAME OVER, SCORE : " + Main.scores);
		}
		
		  
	}
}