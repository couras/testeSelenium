package com.code200Dev.testes_unitarios.mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.code200Dev.testes_unitarios.Banco;
import com.code200Dev.testes_unitarios.Conta;
import com.code200Dev.testes_unitarios.ContaDAO;
import com.code200Dev.testes_unitarios.ContaDAOFake;
import com.code200Dev.testes_unitarios.DAO;
import com.code200Dev.testes_unitarios.User;

public class BancoTest {
	private Conta c1;
	private Conta c2;
	private Conta c6;
	private Conta c7;
	private User joao;
	private User manoel;
	private User joaquim;
	private User maria;

	@Before
	public void criarAmbiente() {
		c1 = new Conta(100.0, "Basica");
		c2 = new Conta(200.0, "Prime");
		c6 = new Conta(50.0, "Estudante");
		c7 = new Conta(0.0, "Estudante");

		joao = new User("Joao da Silva", "111111111", "joaosilva@mailinator.com");
		manoel = new User("Manoel da Silva", "22222222", "manoelsilva@mailinator.com");
		joaquim = new User("Joaquim", "111111111", "joaosilva@mailinator.com");
		maria = new User("maria da Silva", "22222222", "manoelsilva@mailinator.com");
	}

	@Test
	public void deveSomarTodasAsContasTrazendoOSaldoDoBanco() {

		List<Conta> contas = new ContaBuilder().addConta(c1, joao).addConta(c2, manoel).addConta(c6, joaquim)
				.addConta(c7, maria).constroi();

		DAO dao = mock(ContaDAOFake.class); // new ContaDAOFake();
		when(dao.getContas()).thenReturn(contas);
		doThrow(new RuntimeException()).when(dao).atualizaConta(c6);
		doThrow(new RuntimeException()).when(dao).atualizaConta(c7);

//		dao.salvaConta(contas.get(0));
//		dao.salvaConta(contas.get(1));

		Banco banco = new Banco(dao);

		banco.atualizaJuros(5);

		// verificando que o metodo atualizaConta foi realmente invocado!
		verify(dao).atualizaConta(contas.get(0));

		// verificando que o metodo atualizaConta foi realmente invocado!
		verify(dao, times(1)).atualizaConta(contas.get(0));

		assertEquals(4, banco.getContas().size(), 0.00001);
		// assertEquals(500, banco.totalSaldo(), 0.00001);
	}
}
