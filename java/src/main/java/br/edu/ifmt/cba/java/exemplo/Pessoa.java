package br.edu.ifmt.cba.java.exemplo;

public abstract class Pessoa {
	
	private String nome;
	private String email;
	private String telefone;
	private Endereco endereco;
	public SexoEnum sexo;
	
	public Pessoa() {
		nome = "";
		email="";
		telefone="";
		endereco = new Endereco();
	}
	
	public Pessoa(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = new Endereco();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws PessoaException {
		if (nome==null || nome.trim().length()==0)
			throw new PessoaException(PessoaException.NOME_OBRIGATORIO);
		if (nome.trim().length()<5 || nome.trim().length()>80)
			throw new PessoaException(PessoaException.NOME_TAMANHO);
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws PessoaException {
		if (email!=null && !email.contains("@"))
			throw new PessoaException(PessoaException.EMAIL_INVALIDO);
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getRua() {
		return endereco.getRua();
	}
	public void setRua(String rua) {
		endereco.setRua(rua);
	}
	public String getNumero() {
		return endereco.getNumero();
	}
	public void setNumero(String numero) {
		endereco.setNumero(numero);
	}
	public String getBairro() {
		return endereco.getBairro();
	}
	public void setBairro(String bairro) {
		endereco.setBairro(bairro);
	}
	public String getComplemento() {
		return endereco.getComplemento();
	}
	public void setComplemento(String complemento) {
		endereco.setComplemento(complemento);
	}
	public Cidade getCidade() {
		return endereco.getCidade();
	}
	public void setCidade(Cidade cidade) {
		endereco.setCidade(cidade);
	}	
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\n" +
			   "e-mail: " + email + "\n" +
			   "Telefone: " + telefone + "\n" +
			   endereco+"\n";
	}
}
