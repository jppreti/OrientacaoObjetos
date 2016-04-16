package br.edu.ifmt.cba.java.projeto.supermercado.relatorio;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.edu.ifmt.cba.java.projeto.supermercado.BancoDeDados;
import br.edu.ifmt.cba.java.projeto.supermercado.NotaFiscal;
import br.edu.ifmt.cba.java.projeto.supermercado.Util;

public class RelatorioFaturamentoAnual {

	public static void main(String[] args) {
		try {
			Document documento = new Document();
			PdfWriter.getInstance(documento, new FileOutputStream(new File("RelatorioFaturamentoAnual.pdf")));

			documento.open();
						
			int ano = Integer.parseInt(Util.getInput("Informe o Ano para C‡lculo do Faturamento."));

			documento.add(new Paragraph("Faturamento de " + ano));
			
			PdfPTable tabela = new PdfPTable(new float[]{0.7f,0.3f});
			PdfPCell coluna = new PdfPCell(new Phrase("M?s"));
			tabela.addCell(coluna);
			coluna = new PdfPCell(new Phrase("Total (R$)"));
			tabela.addCell(coluna);
			
			float totalAno = 0;
			for (int mes = Calendar.JANUARY; mes <= Calendar.DECEMBER; mes++) {
				float totalMes = 0;
				for (NotaFiscal nf : BancoDeDados.getNotaFiscalByMonth(mes, ano)) {
					totalMes += nf.getValorTotal();
				}
				tabela.addCell((mes+1)+"");
				tabela.addCell(totalMes+"");
				totalAno += totalMes;
			}
			
			documento.add(tabela);
			documento.add(new Paragraph("Total: " + totalAno));
			documento.close();
			Desktop.getDesktop().open(new File("RelatorioFaturamentoAnual.pdf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
