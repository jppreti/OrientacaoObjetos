package br.edu.ifmt.cba.java.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validacao {
	boolean requerido() default false;
	int min() default 0;
	int max() default 999999;
	String pattern() default "";
}
