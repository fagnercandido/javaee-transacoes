package com.transacoes;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.transacoes.componentes.TransacoesServiceLocal;

@Path("transacoes")
public class TransacoesRest {

	@Inject
	private TransacoesServiceLocal transacaoService;
	
    @GET
    public String teste() {
    	transacaoService.teste();
        return "Teste";
    }
}
