package br.edu.ifmt.cba.java.arquivo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class ProdutoArquivo2 {
/*
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private static ProdutoArquivo2 singleton = null;
	private File arquivo = new File("Produto.dat");
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	
	private ProdutoArquivo2() {
		try {
			if (!arquivo.exists()) arquivo.createNewFile();
			in = new ObjectInputStream(new FileInputStream(arquivo));
			try {
				produtos = (ArrayList<Produto>) in.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			in.close();
			out = new ObjectOutputStream(new FileOutputStream(arquivo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ProdutoArquivo2 getInstance() {
		if (singleton == null)
			singleton = new ProdutoArquivo2();
		
		return singleton;
	}
	
	public void cadastrar(Produto p) {
		try {
			randomFile.seek(randomFile.length());
			randomFile.write(serialize(p));
		} catch (IOException  e) {
			e.printStackTrace();
		}
	}
	
	public Produto consultar(String nome) {
		try {
			 
			randomFile.seek(0);
			
			while (true) {
				Produto p = null;
				try {
					p = (Produto) in.readObject();
					if (!p.isExcluido() && p.getNome().equalsIgnoreCase(nome)) {
						in.close();
						fin.close();
						return p;
					}
				} catch(Exception e){
					in.close();
					fin.close();
					return null;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int consultarPosicao(String nome) {
		try {
			fin = new FileInputStream(arquivo); 
			in = new ObjectInputStream(fin);
			int posicao = 0;
			while (true) {
				Produto p = null;
				try {
					p = (Produto) in.readObject();
					if (p.getNome().equalsIgnoreCase(nome)) {
						in.close();
						fin.close();
						return posicao;
					}
					posicao+=serialize(p).length;
				} catch(Exception e){
					e.printStackTrace();
					in.close();
					fin.close();
					return -1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;		
	}
	
	public void atualizar(Produto p, String nomeAntigo) {
		try {
			randomFile.seek(consultarPosicao(nomeAntigo));
			p.setExcluido(true);
			randomFile.write(serialize(p));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Produto p) {
		try {
			p.setExcluido(true);
			randomFile.seek(consultarPosicao(p.getNome()));
			randomFile.write(serialize(p));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public List<Produto> getAll() {
		List<Produto> produtos = new ArrayList<Produto>();
		try { 
			while (true) {
				Produto p = null;
				try {
					p = (Produto) in.readObject();
					if (!p.isExcluido()) {
						produtos.add(p);
					}
				} catch(Exception e){
					in.close();
					fin.close();
					return produtos;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return produtos;		
	}
		
	public static byte[] serialize(Object obj) throws IOException {
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ObjectOutputStream os = new ObjectOutputStream(out);
	    os.writeObject(obj);
	    return out.toByteArray();
	}
	
	public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
	    ByteArrayInputStream in = new ByteArrayInputStream(data);
	    ObjectInputStream is = new ObjectInputStream(in);
	    return is.readObject();
	}
	
	@Override
	public void finalize() {
		try {
			out.close();
			fout.close();
			randomFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
}
