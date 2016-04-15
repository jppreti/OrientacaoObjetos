package br.edu.ifmt.cba.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Database {

	static ArrayList<Cliente> clientes = new ArrayList<>();
	static LinkedList<Vendedor> vendedores = new LinkedList<>();
	static TreeSet<Produto> produtos = new TreeSet<>();
	static HashMap<Estado,List<Cidade>> estadoCidades = new HashMap<>();
	
	static {
		//popule aqui as estruturas de dados com os respectivos objetos
		try {
			clientes.add(new Cliente("Joao Paulo","123.456.789-00"));
			clientes.add(new Cliente("Maria","122.456.789-00"));
			clientes.add(new Cliente("Ricardo","124.456.789-00"));
			
			List<Cidade> cidades = new ArrayList<>();
			Estado e = new Estado("Mato Grosso", "MT");
			cidades.add(new Cidade("Cuiaba", "65", e));
			cidades.add(new Cidade("Rondonopolis","66", e));
			estadoCidades.put(e, cidades);
			
			cidades = new ArrayList<>();
			e = new Estado("Sao Paulo", "SP");
			cidades.add(new Cidade("Sao Paulo","11",e));
			cidades.add(new Cidade("Sao Carlos","12",e));
			estadoCidades.put(e, cidades);
		} catch (PessoaFisicaException e) {
			e.printStackTrace();
		}
	}
	public static Collection<Cidade> getCidadeByEstado(Estado estado){
		return estadoCidades.get(estado);
	}
	
	public static Collection<Cidade> getCidadeByNome(String nome){
		Collection<Cidade> resultado = new ArrayList<>();
		for (Collection<Cidade> cidades : estadoCidades.values()) {
			for (Cidade cidade : cidades) {
				if (cidade.getNome().toLowerCase().contains(nome.toLowerCase())) {
					resultado.add(cidade);
				}
			}
		}
		return resultado;
	}
	
	public static Collection<Cliente> getClienteByNome(String nome){
		Collection<Cliente> resultado = new ArrayList<>();
		for (Cliente cliente : clientes) {
			if (cliente.getNome().toUpperCase().contains(nome.toUpperCase())) {
				resultado.add(cliente);
			}
		}
		return resultado;
	}
	
	public static Collection<PessoaFisica> getPessoaFisicaByNome(String nome){
		Collection<PessoaFisica> pessoas = new ArrayList<>();
		Collection<PessoaFisica> resultado = new ArrayList<>();
		pessoas.addAll(clientes);
		pessoas.addAll(vendedores);
		
		pessoas.forEach((p) -> {
			if (p.getNome().toLowerCase().contains(nome.toLowerCase()))
				resultado.add(p);
		});
		
		return resultado;
	}
	
	public static Collection<Produto> getProdutoByNome(String nome){
		Collection<Produto> resultado = new ArrayList<>();
		for (Produto produto : produtos) {
			if (produto.getNome().toUpperCase().contains(nome.toUpperCase())) {
				resultado.add(produto);
			}
		}
		return resultado;

	}
	
	public static void main(String[] args) {
		for (Cidade c : Database.getCidadeByEstado(new Estado(null,"MT"))) {
			System.out.println(c.getNome());
		}
		
		for (Produto p: Database.getProdutoByNome("a")) {
			System.out.println(p.getNome());
		}
	}
}
