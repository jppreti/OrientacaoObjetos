package br.edu.ifmt.cba.java.arquivo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ProdutoGUI {
	private static Scanner scan = new Scanner(System.in);
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) {
		byte opcao = -1;
		do {
			mostraOpcoes();
			opcao = Byte.parseByte(scan.next());
			scan.nextLine();
			switch (opcao) {
			case 0:
				ProdutoArquivo.getInstance().finalize();
				System.exit(0);
				break;
			case 1:
				cadastrar();
				break;
			case 2:
				consultar();
				break;
			case 3:
				modificar();
				break;
			case 4:
				excluir();
				break;
			case 5:
				exibirTodos();
				break;

			default:
				System.out.println("Opção digitada inválida!");
				break;
			}
		} while (true);
	}
	
	private static void exibirTodos() {
		for (Produto p : ProdutoArquivo.getInstance().getAll())
			System.out.println(p);
	}

	private static void mostraOpcoes() {
		System.out.println("=================================");
		System.out.println("SISTEMA DE MANUTENÇÃO DE PRODUTOS");
		System.out.println("=================================");
		System.out.println("[1] Cadastrar");
		System.out.println("[2] Consultar");
		System.out.println("[3] Modificar");
		System.out.println("[4] Excluir");
		System.out.println("[5] Exibir Todos os Produtos");
		System.out.println("[0] Sair");
		System.out.println("=================================");
		System.out.print("Digite a opção desejada: ");
	}
	
	private static void cadastrar() {
		Produto p = new Produto();
		boolean erro = false;
		do {
			System.out.print("Nome do produto: ");
			try {
				p.setNome(scan.nextLine());
				erro=false;
			} catch (ProdutoException e) {
				erro=true;
				System.out.println(e.getMessage());
			}
		} while (erro==true);
		
		do {
			System.out.print("Qtde: ");
			try {
				p.setQtde(Integer.parseInt(scan.next()));
				erro=false;
			} catch (ProdutoException | NumberFormatException e) {
				erro=true;
				System.out.println(e.getMessage());
			}
		} while (erro==true);

		do {
			System.out.print("Valor Unitário: ");
			try {
				p.setValorUnitario(Float.parseFloat(scan.next()));
				erro=false;
			} catch (ProdutoException | NumberFormatException e) {
				erro=true;
				System.out.println(e.getMessage());
			}
		} while (erro==true);

		do {
			System.out.print("Data de Validade: ");
			try {
				p.setDataValidade(sdf.parse(scan.next()));
				erro=false;
			} catch (ParseException e) {
				erro=true;
				System.out.println("Formato de data inválido!");
			}
		} while (erro==true);
		
		ProdutoArquivo.getInstance().cadastrar(p);
	}

	private static void consultar() {
		System.out.print("Digite o nome do produto a ser localizado: ");
		Produto p = ProdutoArquivo.getInstance().consultar(scan.nextLine());
		if (p==null)
			System.out.println("Produto não localizado!");
		else
			System.out.println(p);
	}

	private static void modificar() {
		System.out.print("Digite o nome do produto a ser modificado: ");
		String nomeProduto = scan.nextLine();
		Produto produto = ProdutoArquivo.getInstance().consultar(nomeProduto);
		if (produto==null) {
			System.out.println("Produto não localizado!");
			
		} else {
			boolean erro = false;
			do {
				System.out.print("Nome do produto ("+produto.getNome()+"): ");
				try {
					String valor = scan.nextLine();
					produto.setNome(valor.equals("")?produto.getNome():valor);
					erro=false;
				} catch (ProdutoException e) {
					erro=true;
					System.out.print(e.getMessage());
				}
			} while (erro==true);
			
			do {
				System.out.print("Qtde ("+produto.getQtde()+"): ");
				try {
					String valor = scan.nextLine();
					produto.setQtde(valor.equals("")?produto.getQtde():Integer.parseInt(valor));
					erro=false;
				} catch (ProdutoException | NumberFormatException e) {
					erro=true;
					System.out.println(e.getMessage());
				}
			} while (erro==true);
	
			do {
				System.out.print("Valor Unitário ("+produto.getValorUnitario()+"): ");
				try {
					String valor = scan.nextLine();
					produto.setValorUnitario(valor.equals("")?produto.getValorUnitario():Float.parseFloat(valor));
					erro=false;
				} catch (ProdutoException | NumberFormatException e) {
					erro=true;
					System.out.println(e.getMessage());
				}
			} while (erro==true);
	
			do {
				System.out.print("Data de Validade ("+produto.getDataValidade()+"): ");
				try {
					String valor = scan.nextLine();
					produto.setDataValidade(valor.equals("")?produto.getDataValidade():sdf.parse(valor));
					erro=false;
				} catch (ParseException e) {
					erro=true;
					System.out.println("Formato de data inválido!");
				}
			} while (erro==true);	
		}
	}

	private static void excluir() {
		System.out.print("Digite o nome do produto a ser excluído: ");
		Produto p = ProdutoArquivo.getInstance().consultar(scan.nextLine());
		if (p==null) {
			System.out.println("Produto não localizado!");
		} else {
			ProdutoArquivo.getInstance().excluir(p);
			System.out.println("O produto abaixo foi EXCLUIDO com SUCESSO!");
			System.out.println(p);
		}
	}

}
