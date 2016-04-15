package br.edu.ifmt.cba.java;
import java.util.Date;

import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {
		Cliente c=null;
		try {
			c = new Cliente(null, null);
		} catch (PessoaFisicaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			c.setNome("asd");
			c.setCpf("");
			
		}catch (PessoaFisicaException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}catch (PessoaException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch(Exception e){
			//Faço outra coisa se for uma exceção não planejada
			e.printStackTrace();
		}
		catch(Throwable e){
			//Faço outra coisa se for um erro
			e.printStackTrace();
		} finally {
			c.setDataNascimento(new Date());
		}
		System.out.println(c);
	}
	
}
