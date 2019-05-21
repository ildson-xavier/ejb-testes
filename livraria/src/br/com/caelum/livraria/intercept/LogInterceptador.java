package br.com.caelum.livraria.intercept;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {

	    long millis = System.currentTimeMillis();

	    // chamada do método do dao
	    Object o = context.proceed();
	    
	    String metodo = context.getMethod().getName();
	    String nomeClasse = context.getTarget().getClass().getSimpleName();
	    
	    System.out.println(metodo + " - " + nomeClasse);

	    System.out.println("Tempo gasto: " + (System.currentTimeMillis() - millis));

	    return o;
	}
}
