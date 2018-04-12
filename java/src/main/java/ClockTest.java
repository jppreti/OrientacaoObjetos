import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.*;

@SuppressWarnings("restriction")
public class ClockTest extends Application {
	Clock pane = new Clock();
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Scene scene = new Scene(pane, 250,250);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}