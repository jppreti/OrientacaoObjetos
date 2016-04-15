package br.edu.ifmt.cba.java.anotacao;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.regex.Pattern;

import com.sun.xml.internal.ws.wsdl.writer.document.Types;

public class ValidacaoUtil {

	public static Exception valida (Object obj) {
		StringBuffer msg = new StringBuffer();
		Field atributos[] = obj.getClass().getDeclaredFields();
		for (Field f : atributos) {
			f.setAccessible(true);
			Validacao val = f.getAnnotation(Validacao.class);
			
			try {
				if (val != null && val.requerido()) {
					if (f.get(obj)==null) {
						msg.append(f.getName() + ": é obrigatório.\n");
					}
				}
			
				if (val != null && f.get(obj)!=null && f.getType()==String.class) {
					if (f.get(obj).toString().length()<val.min()) {
						msg.append(f.getName() + ": deve ter pelo menos " + val.min() + " caracteres.\n");
					}
					if (f.get(obj).toString().length()>val.max()) {
						msg.append(f.getName() + ": deve ter menos de " + val.max() + " caracteres.\n");
					}
					if (val.pattern().length()>0) {
						if (!Pattern.matches(val.pattern(), f.get(obj).toString()))
							msg.append(f.getName() + ": não está dentro do formato adequado: " + val.pattern() + " .\n");
					}
				}
			
				if (val != null && f.get(obj)!=null && (f.getType().toString().equals("int") || f.getType()==Integer.class)) {
					if ((Integer)f.get(obj)<val.min()) {
						msg.append(f.getName() + ": não pode ser menor do que " + val.min() + ".\n");
					}
					if ((Integer)f.get(obj)>val.max()) {
						msg.append(f.getName() + ": não pode ser maior do que " + val.max() + ".\n");
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return msg.length()>0?new Exception(msg.toString()):null;
	}
	
}
