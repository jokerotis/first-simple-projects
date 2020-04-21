import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class AppleGenerator {
	public static Rectangle apple() {
		
		Rectangle apples = new Rectangle(600,600,15,15);
		apples.setFill(Color.RED);
		return apples;
	}
}
