package br.edu.ifmt.cba.java.exemplo;

public class Aluno extends PessoaFisica {
	
	public String numMatricula;
		
	public Aluno() {
		super();
		numMatricula = "";
	}
	
	public Aluno(String nome, String email, String telefone, String cpf, String numMatricula) {
		super (nome, email, telefone, cpf);
		this.numMatricula = numMatricula;
	}

	
	public String getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(String numMatricula) {
		this.numMatricula = numMatricula;
	}
	
	@Override
	public String toString() {
		return super.toString() + 
				"Matricula: " + numMatricula + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((numMatricula == null) ? 0 : numMatricula.hashCode());
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
		Aluno other = (Aluno) obj;
		if (numMatricula == null) {
			if (other.numMatricula != null)
				return false;
		} else if (!numMatricula.equals(other.numMatricula))
			return false;
		return true;
	}
	
}
