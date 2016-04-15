package br.edu.ifmt.cba.java;
import java.util.Date;


public abstract class Pessoa {

	private String nome;
	private Date dataNascimento;
	private Endereco endereco;
	
	public Pessoa(){
		endereco = new Endereco();
	}
	
	public Pessoa (String nome) {
		this.nome = nome;
		endereco = new Endereco();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws PessoaException{
		if (nome==null || nome.trim().length()==0)
			throw new PessoaException(PessoaException.NOME_OBRIGATORIO);
		if (nome.trim().length()<8||nome.trim().length()>80)
			throw new PessoaException(PessoaException.NOME_TAMANHO);
		if (!nome.matches(PessoaException.EXP_NOME_CARAC_VALIDOS))
			throw new PessoaException(PessoaException.NOME_CARACTERES_INVALIDOS);
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
		
	public String getRua() {
		return endereco.getRua();
	}
	public String getBairro() {
		return endereco.getBairro();
	}
	public String getCep() {
		return endereco.getCep();
	}
	public String getComplemento() {
		return endereco.getComplemento();
	}
	public Cidade getCidade() {
		return endereco.getCidade();
	}
	
	public void setRua(String rua) {
		this.endereco.setRua(rua);
	}
	public void setBairro(String bairro) {
		this.endereco.setBairro(bairro);
	}
	public void setCep(String cep) {
		this.endereco.setCep(cep);
	}
	public void setComplemento(String complemento) {
		this.endereco.setComplemento(complemento);
	}
	public void setCidade(Cidade cidade) {
		this.endereco.setCidade(cidade);
	}
	
	@Override
	public String toString() {
		return "Nome: " + getNome() + "\n" +
			   "Dta. Nasc.: " + getDataNascimento() + "\n"+
				endereco;
	}
	
	public void finalize() {
		System.out.println(
				"Objeto: " + super.toString() + " foi excluído!");
	}
	
}

