package br.edu.ifmt.cba.java.projeto.locadora.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MenuGUI extends Application implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem mniCliente;

    @FXML
    private MenuItem mniSair;

    @FXML
    private MenuBar mnuBar;

    @FXML
    private Menu mnuCadastro;

    public MenuGUI() {
    }

    @FXML
    void mniClienteOnAction(ActionEvent event) {
    	try {
			new ClienteGUI().start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void mniSairOnAction(ActionEvent event) {
    	System.exit(0);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Stage stage) throws Exception {
    	BorderPane painel = null;
    	try {
			painel = FXMLLoader.load(MenuGUI.class.getResource("MenuGUI.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	Scene scene = new Scene(painel);
    	stage.setTitle("SISTEMA DE LOCADORA DE VIDEO");
    	stage.setScene(scene);
    	stage.show();		
	}

}
