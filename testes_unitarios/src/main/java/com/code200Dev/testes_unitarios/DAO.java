package com.code200Dev.testes_unitarios;

import java.util.List;

import javax.management.RuntimeErrorException;

public interface DAO {

	List<Conta> getContas();

	void atualizaConta(Conta conta) throws RuntimeErrorException;

	void salvaConta(Conta conta);

}