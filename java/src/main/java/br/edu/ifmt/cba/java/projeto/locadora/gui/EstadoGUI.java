package br.edu.ifmt.cba.java.projeto.locadora.gui;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import br.edu.ifmt.cba.java.projeto.locadora.Cliente;
import br.edu.ifmt.cba.java.projeto.locadora.Estado;
import br.edu.ifmt.cba.java.projeto.locadora.database.Database;
import br.edu.ifmt.cba.java.projeto.locadora.exception.CampoObrigatorioException;
import br.edu.ifmt.cba.java.projeto.locadora.exception.MascaraException;
import br.edu.ifmt.cba.java.projeto.locadora.exception.TamanhoException;


public class EstadoGUI extends Application implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdd;

    @FXML
    private ContextMenu ctmTblEstado;

    @FXML
    private Label lblDescricao;

    @FXML
    private Label lblSigla;

    @FXML
    private MenuItem mniExcluir;

    @FXML
    private TableColumn<Estado, String> tbcDescricao;

    @FXML
    private TableColumn<Estado, String> tbcSigla;

    @FXML
    private TableView<Estado> tblEstado;

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtSigla;


    @FXML
    void btnAddOnAction(ActionEvent event) {
    	Estado e = new Estado(null, txtSigla.getText().toUpperCase(), txtDescricao.getText());
    	try {
			e.valida();
			PreparedStatement pstmt = Database.con.prepareStatement("INSERT INTO estado (sigla, descricao) VALUES (?,?)");
			pstmt.setString(1, e.getSigla());
			pstmt.setString(2, e.getDescricao());
			pstmt.executeUpdate();
			tblEstado.getItems().add(e);
			txtSigla.setText("");
			txtDescricao.setText("");
			txtSigla.requestFocus();
			
		} catch (CampoObrigatorioException e1) {
			e1.printStackTrace();
		} catch (TamanhoException e1) {
			e1.printStackTrace();
		} catch (MascaraException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    }

    @FXML
    void txtDescricaoOnKeyPressed(KeyEvent event) {
    	if (event.getCode() == KeyCode.ENTER)
    		btnAdd.fire();
    }
    
    @FXML
    void mniExcluirOnAction(ActionEvent event) {
    	Estado e = tblEstado.getSelectionModel().getSelectedItem();
    	try {
			PreparedStatement pstmt = Database.con.prepareStatement("DELETE FROM estado WHERE sigla = ?");
			pstmt.setString(1, e.getSigla());
			pstmt.executeUpdate();
			tblEstado.getItems().remove(e);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tbcSigla.setCellValueFactory(new PropertyValueFactory<Estado,String>("sigla"));
		tbcDescricao.setCellValueFactory(new PropertyValueFactory<Estado,String>("descricao"));
		
		List<Estado> estados = new ArrayList<Estado>();
		ResultSet rs;
		try {
			rs = Database.con.createStatement().executeQuery("SELECT * FROM estado ORDER BY sigla");
			// TODO Auto-generated catch block
			while (rs.next())
			estados.add(new Estado(rs.getLong("idestado"),rs.getString("sigla"),rs.getString("descricao")));		
			tblEstado.setItems(FXCollections.observableArrayList(estados));
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane painel = FXMLLoader.load(EstadoGUI.class.getResource("EstadoGUI.fxml"));		
		Scene scene = new Scene(painel);
		stage.setTitle("Cadastro de Estados");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
