package br.edu.ifmt.cba.java.projeto.locadora.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import br.edu.ifmt.cba.java.projeto.locadora.Cidade;
import br.edu.ifmt.cba.java.projeto.locadora.Estado;

public class GUICliente extends Application {
	
	GridPane gridEdicao;
	Label lblNome, lblSexo, lblDataNascimento, lblCpf, lblTelefone, lblLogradouro, lblNumero, lblBairro, lblCep, lblComplemento, lblEstado, lblCidade, lblPontosFidelidade; 
	TextField txtNome, txtDataNascimento, txtCpf, txtTelefone, txtLogradouro, txtNumero, txtBairro, txtCep, txtComplemento;
	ChoiceBox<Estado> chbEstado;
	ChoiceBox<Cidade> chbCidade;
	RadioButton rdbMasc, rdbFem;
	Text txtPontosFidelidade;

	@Override
	public void start(Stage janela) throws Exception {
		gridEdicao = new GridPane();
		gridEdicao.setHgap(10);
		gridEdicao.setVgap(10);
		gridEdicao.setPadding(new Insets(25,25,25,25));
		
		lblNome = new Label("Nome:");
		gridEdicao.add(lblNome, 0,0);
		
		txtNome = new TextField();
		gridEdicao.add(txtNome, 1,0,3,1);
		
		HBox boxSexo = new HBox(10);
		
		lblSexo = new Label("Sexo:");		
		rdbMasc = new RadioButton("Masculino");
		rdbFem = new RadioButton("Feminino");
		
		boxSexo.getChildren().add(lblSexo);
		boxSexo.getChildren().add(rdbMasc);
		boxSexo.getChildren().add(rdbFem);
		
		gridEdicao.add(boxSexo, 4,0,2,1);
		
		lblDataNascimento = new Label("Data de Nascimento:");
		gridEdicao.add(lblDataNascimento, 0,1);
		
		txtDataNascimento = new TextField();
		gridEdicao.add(txtDataNascimento, 1,1);
		
		lblCpf = new Label("CPF:");
		gridEdicao.add(lblCpf, 2,1);
		
		txtCpf = new TextField();
		gridEdicao.add(txtCpf, 3,1);
		
		lblTelefone = new Label("Telefone:");
		gridEdicao.add(lblTelefone, 4,1);
		
		txtTelefone = new TextField();
		gridEdicao.add(txtTelefone, 5,1);
		
		lblLogradouro = new Label("Logradouro:");
		gridEdicao.add(lblLogradouro, 0,2);
		
		txtLogradouro = new TextField();
		gridEdicao.add(txtLogradouro, 1,2,3,1);
		
		lblNumero = new Label("N.:");
		gridEdicao.add(lblNumero, 4,2);
		
		txtNumero = new TextField();
		gridEdicao.add(txtNumero, 5,2);
		
		lblBairro = new Label("Bairro:");
		gridEdicao.add(lblBairro, 0,3);
		
		txtBairro = new TextField();
		gridEdicao.add(txtBairro, 1,3,3,1);
		
		lblCep = new Label("CEP:");
		gridEdicao.add(lblCep, 4,3);
		
		txtCep = new TextField();
		gridEdicao.add(txtCep, 5,3);
		
		lblComplemento = new Label("Complemento:");
		gridEdicao.add(lblComplemento, 0,4);
		
		txtComplemento = new TextField();
		gridEdicao.add(txtComplemento, 1,4,5,1);

		lblEstado = new Label("Estado:");
		gridEdicao.add(lblEstado, 0,5);
		
		chbEstado = new ChoiceBox<Estado>();
		gridEdicao.add(chbEstado, 1,5,2,1);	
		
		lblCidade = new Label("Cidade:");
		gridEdicao.add(lblCidade, 2,5);
		
		chbCidade = new ChoiceBox<Cidade>();
		gridEdicao.add(chbCidade, 3,5,2,1);
				
		lblPontosFidelidade = new Label("Pontos (Fidelidade):");
		gridEdicao.add(lblPontosFidelidade, 0,6);
		
		txtPontosFidelidade = new Text();
		gridEdicao.add(txtPontosFidelidade, 1,6,5,1);
		
		Scene scene = new Scene(gridEdicao,800,250);
		janela.setScene(scene);
		janela.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
