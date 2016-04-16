package br.edu.ifmt.cba.java.projeto.supermercado.relatorio;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

import br.edu.ifmt.cba.java.projeto.supermercado.BancoDeDados;
import br.edu.ifmt.cba.java.projeto.supermercado.Cliente;
import br.edu.ifmt.cba.java.projeto.supermercado.Util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class RelatorioCliente {
	
	public static void main(String[] args) {
		try {
			Document documento = new Document();
			PdfWriter.getInstance(documento,new FileOutputStream(new File("RelatorioCliente.pdf")));
			documento.open();
			
			String cpf = Util.getInput("Digite o CPF do Cliente:");
			
			Cliente c = BancoDeDados.getClienteByCpf(cpf);
			
			Paragraph p = new Paragraph(c.toString());
			
			documento.add(p);
			
			documento.close();
			Desktop.getDesktop().open(new File("RelatorioCliente.pdf"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
