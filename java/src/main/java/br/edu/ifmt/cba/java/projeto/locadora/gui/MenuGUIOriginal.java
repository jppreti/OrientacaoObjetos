package br.edu.ifmt.cba.java.projeto.locadora.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuGUIOriginal extends Stage {

	private MenuBar mnb;
	private Menu mnuManutencao;
	private MenuItem mniCliente, mniSair;
	
	public MenuGUIOriginal() {
		setTitle("Sistema de Locadora de V’deo");
		
		mnb = new MenuBar();
		
		mnuManutencao = new Menu("_Manuten?‹o");
		mnuManutencao.setMnemonicParsing(true);
		
		mniCliente = new MenuItem("Cliente");
		mniCliente.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				new ClienteGUI3();
			}
		});
				
		mniSair = new MenuItem("Sair");
		mniSair.setMnemonicParsing(true);
		mniSair.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
		mniSair.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent evt) {
				System.exit(0);
			}
		});

		mnuManutencao.getItems().addAll(mniCliente, new SeparatorMenuItem(), mniSair);

		mnb.getMenus().add(mnuManutencao);
		
		BorderPane layout = new BorderPane();
		
		layout.setTop(mnb);
		
		Scene scene = new Scene(layout, 1280,800);
		
		this.setScene(scene);
	}
}
