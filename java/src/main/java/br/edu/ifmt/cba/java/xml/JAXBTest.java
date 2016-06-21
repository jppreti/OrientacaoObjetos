package br.edu.ifmt.cba.java.xml;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBTest {
	public static void main(String[] args) {
		try {
			AlunoPOJO aluno = new AlunoPOJO(1, "JOAO", "2016A2", 27);
			JAXBContext context = JAXBContext.newInstance(AlunoPOJO.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(aluno, new FileOutputStream("aluno.xml"));
			
			System.out.println("java object converted to xml successfully.");
			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			aluno = null;
			aluno = (AlunoPOJO) unmarshaller.unmarshal(new File("aluno.xml"));

			System.out.println("Nome do Aluno: " + aluno.getNome());
			System.out.println("Matrícula: " + aluno.getMatricula());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
