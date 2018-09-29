package com.code200Dev.testes_unitarios.mock;

import java.util.ArrayList;
import java.util.List;

import com.code200Dev.testes_unitarios.Conta;
import com.code200Dev.testes_unitarios.User;

public class ContaBuilder {
	private List<Conta> contas;
	private User usuario;
	
	public ContaBuilder(){
		contas = new ArrayList<Conta>();
	}
	
	public ContaBuilder addConta(Conta conta, User usuario){
		conta.setUsuario(usuario);
		this.contas.add(conta);
		return this;
	}
	
	public List<Conta> constroi() {
		return this.contas;
	}
}
