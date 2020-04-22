import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.paint.Color;

public class AppleGen extends Main {
	public static void appleGen() {
		while(!isApple ) {
			isApple = true;
			int randomNum = ThreadLocalRandom.current().nextInt(46, Grid.gridBoxes.size()-45);
			int randomPlace = randomNum;
			if (randomPlace == SnakeMovement.snakePos.get(SnakeMovement.snakePos.size()-1) || Grid.gridBorder.contains(randomPlace)) {
				isApple = false;
			} else {
				Grid.gridBoxes.get(randomPlace).setFill(Color.DARKRED);
				appleLocation = randomPlace;
			}
		}
	}
}
	