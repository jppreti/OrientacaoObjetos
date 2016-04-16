package br.edu.ifmt.cba.java.projeto.locadora.gui;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifmt.cba.java.Util;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import br.edu.ifmt.cba.java.projeto.locadora.Cidade;
import br.edu.ifmt.cba.java.projeto.locadora.Cliente;
import br.edu.ifmt.cba.java.projeto.locadora.Endereco;
import br.edu.ifmt.cba.java.projeto.locadora.Estado;
import br.edu.ifmt.cba.java.projeto.locadora.SexoEnum;
import br.edu.ifmt.cba.java.projeto.locadora.database.Database;
import br.edu.ifmt.cba.java.projeto.locadora.exception.CampoObrigatorioException;
import br.edu.ifmt.cba.java.projeto.locadora.exception.MascaraException;
import br.edu.ifmt.cba.java.projeto.locadora.exception.TamanhoException;

public class ClienteGUI3 extends Stage {
	//PAINEL DE BUSCA
	Label lblPalavraChave;
	TextField txtPalavraChave;
	ChoiceBox<String> chbPesquisa;
	Button btnPesquisar;
	
	//PAINEL TABULADO
	TabPane tbpCliente;
	Tab tabBusca, tabEdicao;
	TableView<Cliente> tblCliente;
	
	//GRID DE EDICAO
	GridPane grid;
	Label lblNome, lblDataNascimento, lblSexo, lblCpf, lblTelefone, lblLogradouro,
	      lblNumero, lblBairro, lblCep, lblComplemento, lblEstado, lblCidade, lblPontos;
	TextField txtNome, txtDataNascimento, txtCpf, txtTelefone, txtLogradouro, txtNumero,
	          txtBairro, txtCep, txtComplemento;
	RadioButton rdbMasc, rdbFem;
	ToggleGroup tggSexo;
	ChoiceBox<Estado> chbEstado;
	ChoiceBox<Cidade> chbCidade;
	Text txtPontos, txtMensagem;
	
	//PAINEL DE ACOES DE EDICAO
	Button btnNovo, btnConfirmar, btnAlterar, btnCancelar, btnExcluir;
	Long idcliente = null; //serve apenas para saber se Ž uma inser?‹o ou altera?‹o ao confirmar
	
	public ClienteGUI3() {
		setTitle("Formul‡rio de Manuten?‹o de Cliente");
		
		VBox vbox = new VBox(50);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(getPainelBusca(),getPainelTabulado(),getPainelAcoesEdicao());
		setModoEdicao(false);
		Scene scene = new Scene(vbox, 800, 500);
		scene.getStylesheets().add("jppreti/locadora/gui/estilo.css");
		setScene(scene);
		initModality(Modality.APPLICATION_MODAL);
		show();
	}
	
	private TabPane getPainelTabulado() {
		tbpCliente = new TabPane();
		
		tabBusca = new Tab("Consulta");
		tabBusca.setClosable(false);
		tabBusca.setContent(getTabelaCliente());
		
		tabEdicao = new Tab("Edi?‹o");
		tabEdicao.setClosable(false);
		tabEdicao.setContent(getGridEdicao());
		
		tbpCliente.getTabs().addAll(tabBusca, tabEdicao);
		
		return tbpCliente;
	}
	
	private TableView<Cliente> getTabelaCliente() {
		tblCliente = new TableView<Cliente>();
		
		TableColumn<Cliente, String> tclNome = new TableColumn<Cliente, String>("Nome"); 
		tclNome.setCellValueFactory(new PropertyValueFactory<Cliente,String>("nome"));
		tclNome.setMinWidth(500);
		tclNome.setMaxWidth(600);
		tclNome.setResizable(true);
		
		TableColumn<Cliente, String> tclTelefone = new TableColumn<Cliente, String>("Telefone"); 
		tclTelefone.setCellValueFactory(new PropertyValueFactory<Cliente,String>("telefone"));
		tclTelefone.setMinWidth(150);
		tclTelefone.setMaxWidth(150);
		tclTelefone.setResizable(false);
		
		TableColumn<Cliente, String> tclCpf = new TableColumn<Cliente, String>("CPF"); 
		tclCpf.setCellValueFactory(new PropertyValueFactory<Cliente,String>("cpf"));
		tclCpf.setMinWidth(150);
		tclCpf.setMaxWidth(150);
		tclCpf.setResizable(false);
		
		tblCliente.getColumns().addAll(tclNome, tclTelefone, tclCpf);
		
		return tblCliente;
	}

	private HBox getPainelBusca() {
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.CENTER);
		
		lblPalavraChave = new Label("Palavra-chave:");
		txtPalavraChave = new TextField();
		
		txtPalavraChave.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evt) {
				if (evt.getCode()==KeyCode.ENTER) btnPesquisar.fire();
			}
		});
		
		List<String> opcoes = new ArrayList<String>();
		opcoes.add("Nome"); opcoes.add("CPF");
		
		chbPesquisa = new ChoiceBox<String>(FXCollections.observableArrayList(opcoes));
		chbPesquisa.getSelectionModel().select(0);
		
		btnPesquisar = new Button("Pesquisar");
		btnPesquisar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				tbpCliente.getSelectionModel().select(tabBusca);
				List<Cliente> clientes = new ArrayList<Cliente>();
				if (chbPesquisa.getSelectionModel().getSelectedItem().equalsIgnoreCase("Nome")) {
					try {
						PreparedStatement pstmt = Database.con
								.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ?");
						pstmt.setString(1, "%" + txtPalavraChave.getText() + "%");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) clientes.add(getCliente(rs));
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (chbPesquisa.getSelectionModel().getSelectedItem().equalsIgnoreCase("CPF")) {
					try {
						PreparedStatement pstmt = Database.con
								.prepareStatement("SELECT * FROM cliente WHERE cpf = ?");
						pstmt.setString(1, txtPalavraChave.getText());
						ResultSet rs = pstmt.executeQuery();
						if (rs.next()) clientes.add(getCliente(rs));
					} catch (SQLException e) {
						e.printStackTrace();
					}				
				}
				tblCliente.setItems(FXCollections.observableArrayList(clientes));
			}

			private Cliente getCliente(ResultSet rs) throws SQLException {
				Cliente cliente = new Cliente();
				cliente.setCpf(rs.getString("cpf"));
				cliente.setDataNascimento(rs.getDate("datanascimento"));
				
				Endereco end =new Endereco();
				end.setBairro(rs.getString("bairro"));
				end.setCep(rs.getString("cep"));
				end.setCidade(null);
				end.setComplemento(rs.getString("complemento"));
				end.setLogradouro(rs.getString("logradouro"));
				end.setNumero(rs.getString("numero"));
				
				cliente.setEndereco(end);
				cliente.setIdPessoaFisica(rs.getLong("idcliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setPontosFidelidade(rs.getInt("pontosfidelidade"));
				cliente.setSexo(SexoEnum.valueOf(rs.getString("sexo")));
				cliente.setTelefone(rs.getString("telefone"));
				
				return cliente;
			}
		});
		btnPesquisar.setTooltip(new Tooltip("Consulta clientes pelo Nome ou CPF."));
		hbox.getChildren().addAll(lblPalavraChave,txtPalavraChave,chbPesquisa,btnPesquisar);
		return hbox;
	}
	
	private HBox getPainelAcoesEdicao() {
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.CENTER);
		
		btnNovo = new Button("_Novo");
		btnNovo.setMnemonicParsing(true);
		btnNovo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				idcliente = null;
				setModoEdicao(true);
				tbpCliente.getSelectionModel().select(tabEdicao);
			}
		});
		
		btnConfirmar = new Button("C_onfirmar");
		btnConfirmar.setMnemonicParsing(true);
		btnConfirmar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Cliente cliente = new Cliente();
				cliente.setIdPessoaFisica(idcliente);
				cliente.setCpf(txtCpf.getText());
				cliente.setDataNascimento(Util.getDate(txtDataNascimento.getText()));
				
				Endereco e = new Endereco();
				e.setBairro(txtBairro.getText());
				e.setCep(txtCep.getText());
				e.setCidade(chbCidade.getSelectionModel().getSelectedItem());
				e.setComplemento(txtComplemento.getText());
				e.setLogradouro(txtLogradouro.getText());
				e.setNumero(txtNumero.getText());
				
				cliente.setEndereco(e);
				cliente.setNome(txtNome.getText());
				cliente.setSexo(rdbMasc.isSelected()?SexoEnum.MASCULINO:SexoEnum.FEMININO);
				cliente.setTelefone(txtTelefone.getText());

				try {
					cliente.valida();
					if (idcliente == null) {
						//CODIGO DE INSERCAO
						PreparedStatement pstmt = Database.con.prepareStatement(
							"INSERT INTO cliente (nome,datanascimento,cpf,telefone,sexo," +
							"pontosfidelidade,logradouro,numero,bairro,cep,complemento," +
							"idcidade) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"
						);
						pstmt.setString(1, cliente.getNome());
						pstmt.setDate  (2, new Date(cliente.getDataNascimento().getTime()));
						pstmt.setString(3, cliente.getCpf());
						pstmt.setString(4, cliente.getTelefone());
						pstmt.setString(5, cliente.getSexo().toString());
						pstmt.setLong  (6, cliente.getPontosFidelidade());
						pstmt.setString(7, cliente.getEndereco().getLogradouro());
						pstmt.setString(8, cliente.getEndereco().getNumero());
						pstmt.setString(9, cliente.getEndereco().getBairro());
						pstmt.setString(10, cliente.getEndereco().getCep());
						pstmt.setString(11, cliente.getEndereco().getComplemento());
						pstmt.setLong  (12, cliente.getEndereco().getCidade().getIdCidade());
						pstmt.executeUpdate();
					} else {
						//CODIGO DE ATUALIZACAO
					}
					txtMensagem.setText("Cliente INSERIDO com SUCESSO!");
					setModoEdicao(false);
				} catch (CampoObrigatorioException e1) {
					txtMensagem.setText(e1.getMessage());
				} catch (TamanhoException e1) {
					txtMensagem.setText(e1.getMessage());
				} catch (MascaraException e1) {
					txtMensagem.setText(e1.getMessage());
				} catch (SQLException e1) {
					e1.printStackTrace();
					txtMensagem.setText("Erro de Banco: Contate o administrador do sistema.");
				}					
				
			}
		});
		
		btnAlterar = new Button("_Alterar");
		btnAlterar.setMnemonicParsing(true);
		btnAlterar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				setModoEdicao(true);
				tbpCliente.getSelectionModel().select(tabEdicao);
			}
		});
		
		btnCancelar = new Button("_Cancelar");
		btnCancelar.setMnemonicParsing(true);
		btnCancelar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				setModoEdicao(false);
			}
		});
		
		btnExcluir = new Button("E_xcluir");
		btnExcluir.setMnemonicParsing(true);
		hbox.getChildren().addAll(btnNovo,btnConfirmar,btnAlterar,btnCancelar,btnExcluir);		
		return hbox;
	}
	
	private void setModoEdicao(boolean edicao) {
		btnNovo.setDisable(edicao);
		btnConfirmar.setDisable(!edicao);
		btnAlterar.setDisable(edicao);
		btnCancelar.setDisable(!edicao);
		btnExcluir.setDisable(edicao);
	}

	private GridPane getGridEdicao() {
		grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
		grid.setAlignment(Pos.CENTER);
		
		//LINHA ZERO
		txtMensagem = new Text("");
		txtMensagem.setFill(Color.RED);
		grid.add(txtMensagem, 0, 0, 6, 1);
		
		//PRIMEIRA LINHA
		lblNome = new Label("Nome:");
		grid.add(lblNome, 0, 1);
		
		txtNome = new TextField();
		grid.add(txtNome, 1, 1, 3, 1);
		
		lblSexo = new Label("Sexo:");
		grid.add(lblSexo, 4, 1);
		
		tggSexo = new ToggleGroup();
		rdbMasc = new RadioButton("Masculino");
		rdbMasc.setToggleGroup(tggSexo);
		rdbFem = new RadioButton("Feminino");
		rdbFem.setToggleGroup(tggSexo);
		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(rdbMasc, rdbFem);
		grid.add(hbox, 5, 1);
		
		//SEGUNDA LINHA
		lblDataNascimento = new Label("Data de Nascimento:");
		grid.add(lblDataNascimento, 0, 2);
		
		txtDataNascimento = new TextField() {
			@Override 
			public void replaceText(int start, int end, String text) {
				if (text.matches("[0-9/]") && txtDataNascimento.getText().length()<10) {						
					super.replaceText(start, end, text);
				}
				if (!text.matches("[0-9/]"))
					txtDataNascimento.setText(txtDataNascimento.getText().substring(0, end-1));
				
				if (txtDataNascimento.getText().length()==2 || txtDataNascimento.getText().length()==5) {
					txtDataNascimento.appendText("/");
				}
			}
			
			@Override
			public void replaceSelection(String text) {
				if (text.matches("[0-9]")) {
					super.replaceSelection(text);
				}
			}			
		};
		
		grid.add(txtDataNascimento, 1, 2);

		lblCpf = new Label("CPF:");
		grid.add(lblCpf, 2, 2);
		
		txtCpf = new TextField();
		grid.add(txtCpf, 3, 2);
		
		lblTelefone = new Label("Telefone:");
		grid.add(lblTelefone, 4, 2);
		
		txtTelefone = new TextField();
		grid.add(txtTelefone, 5, 2);
		
		//TERCEIRA LINHA
		lblLogradouro = new Label("Logradouro:");
		grid.add(lblLogradouro, 0, 3);
		
		txtLogradouro = new TextField();
		grid.add(txtLogradouro, 1, 3, 3, 1);
		
		lblNumero = new Label("N.:");
		grid.add(lblNumero, 4, 3);
		
		txtNumero = new TextField();
		grid.add(txtNumero, 5, 3);
		
		//QUARTA LINHA
		lblBairro = new Label("Bairro:");
		grid.add(lblBairro, 0, 4);
		
		txtBairro = new TextField();
		grid.add(txtBairro, 1, 4, 3, 1);
		
		lblCep = new Label("CEP:");
		grid.add(lblCep, 4, 4);
		
		txtCep = new TextField();
		grid.add(txtCep, 5, 4);

		//QUINTA LINHA
		lblComplemento = new Label("Complemento:");
		grid.add(lblComplemento, 0, 5);
		
		txtComplemento = new TextField();
		grid.add(txtComplemento, 1, 5, 5, 1);
		
		//SEXTA LINHA
		lblEstado = new Label("Estado:");
		grid.add(lblEstado, 0, 6);
		
		List<Estado> estados = new ArrayList<Estado>();
		try {
			Statement stmt = Database.con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM estado ORDER BY sigla");
			while (rs.next()) {
				estados.add(new Estado(rs.getLong("idestado"),
						               rs.getString("sigla"),
						               rs.getString("descricao")));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		chbEstado = new ChoiceBox<Estado>(FXCollections.observableArrayList(estados));
		grid.add(chbEstado, 1, 6, 2, 1);
		
		chbEstado.getSelectionModel().selectedIndexProperty()
										.addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number arg1, Number arg2) {
				Estado e = chbEstado.getItems().get((Integer)arg2);
				try {
					ResultSet rs = Database.con.createStatement()
							.executeQuery("SELECT * FROM cidade WHERE idestado = " + e.getIdEstado() + " ORDER BY nome");
					List<Cidade> cidades = new ArrayList<Cidade>();
					while (rs.next()) {
						cidades.add(new Cidade(rs.getLong("idcidade"), rs.getString("nome"), e));
					}
					chbCidade.setItems(FXCollections.observableArrayList(cidades));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		lblCidade = new Label("Cidade:");
		grid.add(lblCidade, 3, 6);
		
		chbCidade = new ChoiceBox<Cidade>();
		grid.add(chbCidade, 4, 6, 2, 1);
		
		//SETIMA LINHA
		lblPontos = new Label("Pontos:");
		grid.add(lblPontos, 0, 7);
		
		txtPontos = new Text();
		grid.add(txtPontos, 1, 7, 5, 1);
		return grid;
	}

}
