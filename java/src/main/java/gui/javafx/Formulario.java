/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package gui.javafx;

import gui.javafx.Formulario.Produto;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Formulario extends Application {

	Label lblOpcao, lblPalavraChave;
	TextField txtPalavraChave;
	ChoiceBox<String> chbOpcao;
	Button btnPesquisar;
	TableView<Produto> tbl = null;
	HBox pnlHorizontal;
	VBox pnlVertical;
	FadeTransition animacaoFade;
	ScaleTransition animacaoScale;
	
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Formulario");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 400);

        lblPalavraChave = new Label("Palavra-chave:");
        txtPalavraChave = new TextField();
        lblOpcao= new Label("Opcao:");
        chbOpcao = new ChoiceBox<String>();
        chbOpcao.getItems().addAll("Nome", "Tipo");
        chbOpcao.getSelectionModel().selectFirst();

        btnPesquisar = new Button();
        btnPesquisar.setPadding(new Insets(1));
        Image img = new Image(getClass().getResourceAsStream("search.png"));
        btnPesquisar.setGraphic(new ImageView(img));
        
        pnlHorizontal = new HBox(5); //Espaco de 5 px
        pnlHorizontal.getChildren().addAll(lblPalavraChave, txtPalavraChave, lblOpcao, chbOpcao, btnPesquisar);
        pnlHorizontal.setPadding(new Insets(5));
        
        final ObservableList<Produto> produtos = FXCollections.observableArrayList(
        		new Produto("Vinho","Bebida",40),
        		new Produto("Sabao em Po","Limpeza",8),
        		new Produto("Detergente","Limpeza",5),
        		new Produto("Refrigerante","Bebida",3)
        );

        TableColumn tbcNome = new TableColumn("Nome");
        tbcNome.setCellValueFactory(new PropertyValueFactory<Produto,String>("nome"));
        TableColumn tbcTipo = new TableColumn("Tipo");
        tbcTipo.setCellValueFactory(new PropertyValueFactory<Produto,String>("tipo"));
        TableColumn tbcValor = new TableColumn("Valor");
        tbcValor.setCellValueFactory(new PropertyValueFactory<Produto,Float>("valor"));
        //TableColumn tbcNome = TableColumnBuilder.create().text("Nome").cellValueFactory(new PropertyValueFactory("nome")).build();
        
        tbl = new TableView<Produto>();
        tbl.setPrefHeight(300);
        tbl.setItems(produtos);
      
        tbl.getColumns().addAll(tbcNome, tbcTipo, tbcValor);
        
        //final TranslateTransition animacao = TranslateTransitionBuilder.create().duration(new Duration(24000)).node(text).fromY(0).toY(-330).interpolator(Interpolator.EASE_OUT).build();

        //animacaoFade = FadeTransitionBuilder.create().duration(new Duration(1000)).node(tbl).fromValue(1).toValue(0).autoReverse(true).cycleCount(2).build();
        animacaoFade = new FadeTransition(Duration.millis(1000),tbl);
        animacaoFade.setFromValue(1);
        animacaoFade.setToValue(0);
        animacaoFade.setAutoReverse(true);
        animacaoFade.setCycleCount(2);

        animacaoScale = new ScaleTransition(new Duration(1000),tbl);
        animacaoScale.setToX(0);
        animacaoScale.setToY(0);
        animacaoScale.setAutoReverse(true);
        animacaoScale.setCycleCount(2);
        
        btnPesquisar.setOnAction(e->{
        	btnPesquisar_onAction(e);
        });
        
        pnlVertical = new VBox(5);
        pnlVertical.setPadding(new Insets(5));
        pnlVertical.getChildren().addAll(pnlHorizontal,tbl);
        
        root.getChildren().add(pnlVertical);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    protected void btnPesquisar_onAction(ActionEvent event) {
    	animacaoFade.play();
    	animacaoScale.play();
    	System.out.println(tbl.getSelectionModel().getSelectedItem());		
	}

	public static class Produto {
    	private StringProperty nome;
    	private StringProperty tipo;
    	private FloatProperty valor;
    	
    	public Produto(String nome, String tipo, float valor) {
    		this.nome = new SimpleStringProperty(nome);
    		this.tipo = new SimpleStringProperty(tipo);
    		this.valor = new SimpleFloatProperty(valor);
    	}

    	public StringProperty nomeProperty() {	return nome;	}
    	public StringProperty tipoProperty() {	return tipo;	}
    	public FloatProperty valorProperty() {	return valor;	}
    	
    	public String toString() { return "Produto: " + nome.getValue(); }
    }
}