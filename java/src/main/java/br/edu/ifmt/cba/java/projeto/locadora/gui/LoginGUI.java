package br.edu.ifmt.cba.java.projeto.locadora.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginGUI extends Application implements Initializable {
	
	private Stage stage = null;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEntrar;

    @FXML
    private Label lblLogin;

    @FXML
    private Label lblSenha;

    @FXML
    private PasswordField pswSenha;

    @FXML
    private Text texMensagem;

    @FXML
    private TextField txtLogin;

    @FXML
    void btnEntrarOnAction(ActionEvent event) {
    	if (txtLogin.getText().equals("admin") && 
    		pswSenha.getText().equals("admin")) {
    		try {
				new MenuGUI().start(new Stage());
				stage.hide();
			} catch (Exception e) {
				e.printStackTrace();
			}
    	} else {
    		texMensagem.setText("Login ou Senha inválido!");
    	}
    }

    @FXML
    void pswSenhaOnKeyPressed(KeyEvent event) {
    	if (event.getCode() == KeyCode.ENTER)
    		btnEntrar.fire();
    }

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane painel = null;
		painel = FXMLLoader.load(LoginGUI.class.getResource("LoginGUI.fxml"));
		Scene scene = new Scene(painel);
		stage.setTitle("AUTENTICAÇÃO");
		stage.setScene(scene);
		stage.show();
		this.stage = stage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
