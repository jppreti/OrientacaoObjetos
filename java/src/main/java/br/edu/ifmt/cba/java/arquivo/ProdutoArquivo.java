package br.edu.ifmt.cba.java.arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ProdutoArquivo {

	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private static ProdutoArquivo singleton = null;
	private File arquivo = new File("Produto.dat");
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	
	private ProdutoArquivo() {
		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			} else {
				in = new ObjectInputStream(new FileInputStream(arquivo));
				produtos = (ArrayList<Produto>) in.readObject();
				in.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ProdutoArquivo getInstance() {
		if (singleton == null)
			singleton = new ProdutoArquivo();
		
		return singleton;
	}
	
	public void cadastrar(Produto p) {
		produtos.add(p);
	}
	
	public Produto consultar(String nome) {
		for (Produto p : produtos)
			if (p.getNome().equalsIgnoreCase(nome))
				return p;
		return null;
	}
		
	public void excluir(Produto p) {
		produtos.remove(p);
	}	
	
	public List<Produto> getAll() {
		return produtos;
	}
	
	@Override
	public void finalize() {
		singleton = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(arquivo));
			out.writeObject(produtos);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
