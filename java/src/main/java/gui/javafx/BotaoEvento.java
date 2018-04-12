package gui.javafx;


import javafx.scene.input.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

@SuppressWarnings("restriction")
public class BotaoEvento extends Application {
	Button btn;
	@Override
	public void start(Stage stage) throws Exception {
        stage.setTitle("Exemplo de Transição HLine");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 375);		
		
        
		btn = new Button("OK");
		
		btn.setOnAction(e->{
			btn_onAction(e);
		});
		
		btn.setOnMouseEntered(e->{
			btn_onMouseEntered(e);
		});
		
		btn.setOnMouseExited(e->{
			btn_onMouseExited(e);
		});
		
		btn.setOnMouseClicked(e->{
			btn_onMouseClicked(e);
		});
		
        scene.setOnKeyPressed(e->{
        	scene_onKeyPressed(e);
        });
		
        root.getChildren().add(btn);
        
        stage.setScene(scene);
        stage.show();
		
	}

	private void scene_onKeyPressed(KeyEvent e) {
		System.out.println(e.getCode());
		if (e.getCode() == KeyCode.ENTER){
			System.out.println("Enter Pressionado!");
		}
	}

	private void btn_onMouseClicked(MouseEvent e) {
		System.out.println(e.getClickCount());
		System.out.println(e.getButton());
	}

	private void btn_onMouseExited(MouseEvent e) {
		btn.setText("Adeus Mouse!");
	}

	private void btn_onMouseEntered(MouseEvent e) {
		btn.setText("Mouse na Área");
	}

	protected void btn_onAction(ActionEvent event) {
		System.out.println("Botao clicado");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}