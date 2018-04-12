package gui.javafx;

import java.io.*;
import javax.imageio.*;
import javafx.application.*;
import javafx.embed.swing.*;
import javafx.scene.paint.*;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.animation.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import javafx.scene.image.*;

@SuppressWarnings("restriction")
public class AnimacaoControlada extends Application implements Runnable {

	final Rectangle rect = new Rectangle (0, 0, 40, 40);
	RotateTransition rt;
	ScaleTransition stBig;
	KeyCode direction = KeyCode.RIGHT;
	Text pause; 
	Stage stage;
	Pane pane;

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		
		//Remove the title bar
		stage.initStyle(StageStyle.UNDECORATED);
		//Get the current screen resolution
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pane = new Pane();
		
		rt = new RotateTransition(Duration.millis(1000), rect);
	    rt.setByAngle(360);
	    rt.setInterpolator(Interpolator.LINEAR);
	    rt.setCycleCount(Timeline.INDEFINITE);
	    rt.setAutoReverse(false);
	    
	    pause = new Text(screenSize.getWidth()/2, screenSize.getHeight()/2, "Paused");
	    pause.setFill(Color.RED);
	    pause.setVisible(false);
	    stBig = new ScaleTransition(Duration.millis(1000), pause);
	    stBig.setFromX(0);
	    stBig.setFromY(0);
	    stBig.setToX(10);
	    stBig.setToY(20);
	    
		pane.getChildren().addAll(rect,pause);
		//Set the scene as the size of the entire resolution
		Scene scene = new Scene(pane,screenSize.getWidth(),screenSize.getHeight());
		
		scene.setOnKeyPressed(e ->{
			scene_onKeyPressed(e);
		});
		
		stage.setScene(scene);
		stage.show();
		
		Thread t = new Thread(this);
		t.setDaemon(true);
		t.start();
		rt.play();
	}
	
	private void scene_onKeyPressed(KeyEvent e) {
		direction = e.getCode();
		switch(direction) {
		case RIGHT:
			if (pause.isVisible()) pause.setVisible(false);
			rt.stop(); rt.setByAngle(360); rt.play();
			break;
		case LEFT:
			if (pause.isVisible()) pause.setVisible(false);
			rt.stop(); rt.setByAngle(-360); rt.play();
			break;
		case UP:
			if (pause.isVisible()) pause.setVisible(false);
			rt.stop(); rt.setByAngle(-360); rt.play();
			break;
		case DOWN:
			if (pause.isVisible()) pause.setVisible(false);
			rt.stop(); rt.setByAngle(360); rt.play();
			break;
		case ESCAPE:
			//terminates the program
			System.exit(0);
		case P:
			//save an image as game.png
			saveAsPng();
		default:
			//Any other key pressed pauses the animation
			rt.stop();
			pause.setVisible(true);
			stBig.play();				
			break;
		}		
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			switch(direction) {
			case RIGHT:
				if (rect.getTranslateX()>stage.getWidth()+40) rect.setTranslateX(-35);
				rect.setTranslateX(rect.getTranslateX()+5);
				break;
			case LEFT:
				if (rect.getTranslateX()<0-40) rect.setTranslateX(stage.getWidth()+40);
				rect.setTranslateX(rect.getTranslateX()-5);
				break;
			case UP:
				if (rect.getTranslateY()<0-40) rect.setTranslateY(stage.getHeight()+40);
				rect.setTranslateY(rect.getTranslateY()-5);
				break;
			case DOWN:
				if (rect.getTranslateY()>stage.getHeight()+40) rect.setTranslateY(-35);
				rect.setTranslateY(rect.getTranslateY()+5);
				break;
			default:
				break;
			}
		}
	}
	
	public void saveAsPng() {
	    WritableImage image = pane.snapshot(new SnapshotParameters(), null);

	    File file = new File("game.png");

	    try {
	        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}