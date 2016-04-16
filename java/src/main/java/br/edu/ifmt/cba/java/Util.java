package br.edu.ifmt.cba.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static Date getDate(String data) {
		try {
			return sdf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
