
package br.edu.ifmt.cba.java.projeto.locadora.exception;

import java.text.MessageFormat;

public class MascaraException extends Exception {

	public static final String MENSAGEM = "A m‡scara do campo {0} deve ser no formato {1}.";
	
	public MascaraException(String campo, String formato) {
		super(MessageFormat.format(MENSAGEM,campo,formato));
	}
	
}