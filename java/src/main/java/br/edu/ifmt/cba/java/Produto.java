package br.edu.ifmt.cba.java;
import java.io.Serializable;


public class Produto implements Comparable<Produto> {	
	
	String nome;
	String x;
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	String unidadeMedida;
	float preco;
	
	public Produto() {}
	
	public Produto(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	float totalizar(float qtde) {
		return preco*qtde;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((unidadeMedida == null) ? 0 : unidadeMedida.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (unidadeMedida == null) {
			if (other.unidadeMedida != null)
				return false;
		} else if (!unidadeMedida.equals(other.unidadeMedida))
			return false;
		return true;
	}

	public static void main(String[] args) {
		Produto p1 = new Produto("Kg");
		p1.nome="Pao";
		Produto p2 = new Produto("Kg");
		p2.nome="Pao Frances";
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
	}

	@Override
	public int compareTo(Produto p) {
		int r = this.nome.compareTo(p.getNome());
		if (r==0) {
			return (int) (this.getPreco()-p.getPreco());
		}
		return r;
	}
}


