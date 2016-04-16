package br.edu.ifmt.cba.java.projeto.supermercado;

// Exemplo que garante que existir‡ apenas uma œnica inst‰ncia da classe Database
public class Database {

	//Vetor que guarda conex›es de um Banco de Dados
	//Connection con[] = new Connection[100];
	
	static Database db = null;
	
	private Database(){}
	
	public static Database getInstance() {
		if (db == null) db = new Database();
		return db;
	}
}
