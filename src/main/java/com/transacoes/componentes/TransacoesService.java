package com.transacoes.componentes;

import com.transacoes.MinhaException;
import com.transacoes.entidades.Pessoa;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Random;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TransacoesService implements TransacoesServiceLocal {

	@PersistenceContext(unitName = "myUnit")
	EntityManager entityManager;

	@Resource
	SessionContext ctx;

	@Inject
	private Requestizinho requestizinho;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void teste() {
		requestizinho.putMapinha(generateRandomKey(10), "teste"+generateRandomKey(5));
		System.out.println("Mapinha size: " + requestizinho.getSizeMapinha());
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void edicao() throws MyException {
		Pessoa pessoa = new Pessoa();
		pessoa.name = "Pedro Leandro";
		pessoa.age = 44;
		entityManager.persist(pessoa);
		entityManager.flush();
		try {
			pegaPessoaNovamente();
		} catch (Throwable ex) {
			ctx.setRollbackOnly();
			System.out.println("nao passa nada.");
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void pegaPessoaNovamente() throws MyException {
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		throw new MyException();
	}

	public static String generateRandomKey(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		StringBuilder key = new StringBuilder();

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			key.append(characters.charAt(index));
		}

		return key.toString();
	}

	@PostConstruct
	public void init() {
		System.out.println("Nasceu TransacoesService");
	}

	@PreDestroy
	public void finish() {
		System.out.println("Morreu TransacoesService");
	}

}

