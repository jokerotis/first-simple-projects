import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ScoreBoard {
	static Text score = new Text("Score = " + Main.scores);
	public static void score() {
		    score.setText("Score = " + Main.scores);
		    score.setX(620);
		    score.setY(30);
		    score.setFont(Font.font("Abyssinica SIL", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 18));
		    
	}
}
