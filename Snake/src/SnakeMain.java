import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;  
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;  
import javafx.stage.Stage;
import javafx.util.Duration;  



public class SnakeMain extends Application {
	
	public static ArrayList<Rectangle> snake = new ArrayList<Rectangle>();
	public static ArrayList<Integer> snakePos = new ArrayList<Integer>();
    static Group root = new Group();
    private String direction = "no";
   
  
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		snakePos.add(0);
		snakePos.add(0);
		for(int i = 0; i < 5; i++) {
			snakePos.set(0, 400 + 15 *i);
			snakePos.set(1, 400);
			SnakeMethods.drawBox();
			Rectangle k = snake.get(snake.size()-1);
			root.getChildren().add(k);
		}
		
			

		// basic window stuffs
	    Text label = new Text("Welcome to snake");
	    label.setX(320);
	    label.setY(30);
	    label.setFont(Font.font("Abyssinica SIL", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 18));
	    Scene scene = new Scene(root, 800, 800,Color.GREY);
	    root.getChildren().add(label);
	        
	    primaryStage.setScene(scene);
	    primaryStage.show();
	    primaryStage.setTitle("Snake");
	   
	    scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
	    	direction = "unactive";
	    	SnakeMethods.hold =1;
	        if(key.getCode()==KeyCode.A) {
	        	   direction = "left";
	        	   while(direction != "unactive") {
	        		   if (SnakeMethods.hold ==1) {
	        		   SnakeMethods.move(direction);
	        		   }
	        		   
	        	   }
	        }
	        	
	        
	        if(key.getCode()==KeyCode.D) {
	        		
	        		direction="right";
	        		SnakeMethods.move(direction);
	 	       	
	       }
	        
	 	   if(key.getCode()==KeyCode.W) {
	        
	        		direction="up";
	        		SnakeMethods.move(direction);
	 	   }
	 	   
	        if(key.getCode()==KeyCode.S) {
	        	
	        	direction="down";
	        	SnakeMethods.move(direction);
	        } 
	  });
    } 
	     	
	  
	    public void handle(ActionEvent event) {
	    }
	    
	public static void main(String[] args) {	
		 Application.launch(args);

	}	
}
