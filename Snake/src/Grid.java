import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Grid {
	public static ArrayList<Integer> gridPos = new ArrayList<Integer>();
	public static ArrayList<Rectangle> gridBoxes = new ArrayList<Rectangle>();
	public static ArrayList<Integer> gridBorder = new ArrayList<Integer>();
	
	public  static void createGrid( ) {
	gridPos.add(45);
	gridPos.add(45);
		int j = 0;
		for(int i = 0; i < 45; i++) {
			for(int k= 0; k < 45; k++) {
				j++;
				gridPos.set(0, gridPos.get(0) + 15);
			
		Rectangle gridBox = new Rectangle(gridPos.get(0), gridPos.get(1), 15, 15);
		gridBoxes.add(gridBox);
		if(i ==0 || k==0 || k == 44 || i == 44) {
			gridBox.setFill(Color.BLACK);
			gridBorder.add(j-1);
		} else {
			gridBox.setFill(Color.LAVENDER);
		}
		Main.root.getChildren().add(gridBox);
			}
			gridPos.set(1, gridPos.get(1) + 15);
			gridPos.set(0, 45);
		
		}
	}
}
