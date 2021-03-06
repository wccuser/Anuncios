package br.com.analise.handler;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import br.com.analise.data.AnaliseRepository;
import br.com.analise.handler.services.Query;

public class QueryNativeHandler {

	@Inject
	@AnaliseRepository
	EntityManager em;

    @AroundInvoke
    public Object handle(InvocationContext ctx) {

       return em.createNativeQuery(ctx.getMethod().getAnnotation(Query.class).value()).getResultList();

    }
    
}
