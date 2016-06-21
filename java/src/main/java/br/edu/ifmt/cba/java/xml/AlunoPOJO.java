package br.edu.ifmt.cba.java.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class AlunoPOJO {
	
	private int id;
	private String nome;
	private String matricula;
	private int idade;
	
	public AlunoPOJO() {}
	
	public AlunoPOJO(int id, String nome, String matricula, int idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.idade = idade;
	}
	
	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	@XmlElement
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	@XmlElement
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getIdade() {
		return idade;
	}
	@XmlTransient
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}
