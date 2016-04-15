package br.edu.ifmt.cba.java;
import java.util.ArrayList;

class Arena {
	ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	
	public Jogador logar (String alias, String cor) {
		Jogador j = new Jogador();
		j.alias = alias;
		j.cor = cor;
		jogadores.add(j);
		//j.qtdeJogadoresOnline=jogadores.size(); VERSAO1
		//for (Jogador jog : jogadores) jog.qtdeJogadoresOnline=jogadores.size(); VERSAO2
		Jogador.qtdeJogadoresOnline = jogadores.size();
		return j;
	}
}

public class Jogador {
	
	public String alias;
	public String cor;
	public static int qtdeJogadoresOnline;
	
	public static void main(String[] args) {
		Arena arena = new Arena();
		arena.logar("JP", "Azul");
		arena.logar("Maria", "Preto");
		arena.logar("Pedro", "Amarelo");
		
		for (Jogador j : arena.jogadores) System.out.println(j.qtdeJogadoresOnline);
	}

}
