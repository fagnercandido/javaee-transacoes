package com.transacoes.componentes;

import javax.ejb.Local;

@Local
public interface TransacoesServiceLocal {

	void teste();

	void edicao() throws MyException;

	void pegaPessoaNovamente() throws MyException;
}
