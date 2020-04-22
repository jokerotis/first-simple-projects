import java.util.ArrayList;
import java.util.Timer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	
	public static ArrayList<Rectangle> snake = new ArrayList<Rectangle>();
	public static ArrayList<Integer> snakePos = new ArrayList<Integer>();
    public static Group root = new Group();
    public static int direction = -1;
    public static boolean running = false;
    public static boolean launch = true;
    public static boolean isApple = false;
    public static int snakeSize;
    public static int appleLocation;
    static int speed = 150;
    static Timer timer = new Timer();
    static int scores =0;
    public static Text endGame = new Text("");
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		
	    timer.schedule(new TaskTime(), 0, 10);
		// basic window stuffs
	    Text label = new Text("Welcome to snake");
	    Text start = new Text("Press enter to start, \nuse wasd to move around.");
	    label.setX(320);
	    label.setY(30);
	    label.setFont(Font.font("Abyssinica SIL", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 18));
	    start.setX(320);
	    start.setY(400);
	    start.setFont(Font.font("Abyssinica SIL", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 25));
	    Scene scene = new Scene(root, 800, 800,Color.GREY);
	    endGame.setX(320);
	    endGame.setY(400);
	    endGame.setFont(Font.font("Abyssinica SIL", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 25));
	    root.getChildren().add(label);
	        
	    primaryStage.setScene(scene);
	    primaryStage.show();
	    primaryStage.setTitle("Snake");
	    Grid.createGrid();
	    root.getChildren().addAll( start, endGame);
	    ScoreBoard.score();
	    for(int i= 0; i < 5; i++) {
	    	
	    	SnakeMovement.drawSnake();
	    }
	    snakeSize = 5;
	    AppleGen.appleGen();
	    
	    scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
	    	Main.root.getChildren().remove(ScoreBoard.score);
	    	ScoreBoard.score();
	    	Main.root.getChildren().add(ScoreBoard.score);
	    	if(launch) {
	    	if(key.getCode()==KeyCode.ENTER) {
	        	   running = true;
	        	   root.getChildren().remove( start);
	        }}
	    	if(direction !=+1) {
	        if(key.getCode()==KeyCode.A) {
	        	   direction = -1;
	        	   
	        }}
	    	if(direction !=-1) {
	        if(key.getCode()==KeyCode.D) {	
	        		direction=+1;
	       }}
	    	if(direction !=+45) {
	 	   if(key.getCode()==KeyCode.W) {
	        		direction=-45;
	 	   }}
	    	if(direction != -45) {
	        if(key.getCode()==KeyCode.S) {
	        	direction=+45;
	        }} 
	  });	
    } 
	    public void handle(ActionEvent event) {
	    }
	    
	public static void main(String[] args) {	
		 Application.launch(args);

	}	
}