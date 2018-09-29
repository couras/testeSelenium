package com.code200Dev.testes_unitarios;

import java.util.ArrayList;
import java.util.List;

public class ContaDAOFake implements DAO {
private static List<Conta> leiloes = new ArrayList<Conta>();
	
	public void salvaConta(Conta conta) {
		leiloes.add(conta);
	}

	public List<Conta> getContas(){
		return leiloes;
	}
	
	
	public void atualizaConta(Conta conta) { 
		System.out.println("atualizando");
	}
}
