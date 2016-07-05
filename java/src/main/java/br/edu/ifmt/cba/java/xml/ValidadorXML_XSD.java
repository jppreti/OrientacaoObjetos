package br.edu.ifmt.cba.java.xml;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class ValidadorXML_XSD {

	public static void main(String[] args) throws SAXException, IOException {
		URL schemaFile = new URL("http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd");
		Source xmlFile = new StreamSource(new File(
				"../../DesenvolvimentoWeb/web/src/main/webapp/WEB-INF/web.xml"));
		SchemaFactory schemaFactory = SchemaFactory
		    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaFile);
		Validator validator = schema.newValidator();
		try {
		  validator.validate(xmlFile);
		  System.out.println(xmlFile.getSystemId() + " is valid");
		} catch (SAXException e) {
		  System.out.println(xmlFile.getSystemId() + " is NOT valid");
		  System.out.println("Reason: " + e.getLocalizedMessage());
		}
	}
	
}
