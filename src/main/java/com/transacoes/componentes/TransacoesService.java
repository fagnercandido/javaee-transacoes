package com.transacoes.componentes;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.Transactional;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TransacoesService implements TransacoesServiceLocal {

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void teste() {
		System.out.println("EJB Method");
	}

}
