/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package gui.javafx;

import java.math.BigDecimal;

import javafx.scene.layout.*;
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

public class TabForm extends Application {

	Label lblOption, lblKeyword;
	TextField txtKeyword;
	ChoiceBox<String> chbOption;
	TableView<Product> tbl = null;
	HBox pnlSearch, pnlEdit;
	BorderPane pnlMain;
	
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tab Form");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 400);

        lblKeyword = new Label("Keyword:");
        txtKeyword = new TextField();
        lblOption= new Label("Option:");
        chbOption = new ChoiceBox<String>();
        chbOption.getItems().addAll("Name", "Type");
        chbOption.getSelectionModel().selectFirst();
        
        pnlSearch = new HBox(5); //Espaco de 5 px
        pnlSearch.getChildren().addAll(lblKeyword, txtKeyword, lblOption, chbOption);
        pnlSearch.setPadding(new Insets(5));
        
        final ObservableList<Product> produtos = FXCollections.observableArrayList(
        		new Product("Wine",ProductType.BEVERAGE,new BigDecimal(40)),
        		new Product("Soap",ProductType.CLEAN,new BigDecimal(8)),
        		new Product("Cristal Clean",ProductType.CLEAN,new BigDecimal(5)),
        		new Product("Soda",ProductType.BEVERAGE,new BigDecimal(3))
        );

        TableColumn tbcNome = new TableColumn("Name");
        tbcNome.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
        TableColumn tbcTipo = new TableColumn("Type");
        tbcTipo.setCellValueFactory(new PropertyValueFactory<Product,ProductType>("type"));
        TableColumn tbcValor = new TableColumn("Price");
        tbcValor.setCellValueFactory(new PropertyValueFactory<Product,BigDecimal>("price"));
        //TableColumn tbcNome = TableColumnBuilder.create().text("Nome").cellValueFactory(new PropertyValueFactory("nome")).build();
        
        tbl = new TableView<Product>();
        tbl.setPrefHeight(300);
        tbl.setItems(produtos);
      
        tbl.getColumns().addAll(tbcNome, tbcTipo, tbcValor);
                                
        root.getChildren().add(pnlVertical);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    protected void btnPesquisar_onAction(ActionEvent event) {
    	System.out.println(tbl.getSelectionModel().getSelectedItem());		
	}

	public static class Product {
    	private String name;
    	private ProductType type;
    	private BigDecimal price;
    	
    	public Product(String name, ProductType type, BigDecimal price) {
    		this.name = name;
    		this.type = type;
    		this.price = price;
    	}

    	public String nomeProperty() {	return name;	}
    	public ProductType tipoProperty() {	return type;	}
    	public BigDecimal valorProperty() {	return price;	}
    	
    	public String toString() { return "Produto: " + name; }
    }
	
	public static enum ProductType {
		BEVERAGE, CLEAN, FOOD
	}
}

