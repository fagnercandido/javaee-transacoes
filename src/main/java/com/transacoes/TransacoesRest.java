package com.transacoes;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.transacoes.componentes.MyException;
import com.transacoes.componentes.TransacoesServiceLocal;

@Path("transacoes2")
public class TransacoesRest {

	@Inject
	private TransacoesServiceLocal transacaoService;

    @GET
    public String teste() {
        try {
            transacaoService.teste();
        } catch (MinhaException exception) {
            System.out.println(exception);
        }

        return "Teste com BMT";
    }

    @GET()
    @Path("edicao")
    public String edicao() throws MyException {
        long start = System.nanoTime();
        transacaoService.edicao();
        long end = System.nanoTime();
        System.out.println("Time "+(end - start));
        return "Teste";
    }
}
