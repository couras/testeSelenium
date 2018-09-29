package com.code200Dev.testes_unitarios;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AvaliadorTest {
	
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;
	private Leilao leilao;
	private Avaliador leiloeiro;

	@Before
	public void inti() {
		joao = new Usuario("Joao");
		jose = new Usuario("José");
		maria = new Usuario("Maria");
		leilao = new Leilao("Playstation 3 Novo");
		leiloeiro = new Avaliador();
	}
	
	@Test
	public void avaliaLeilao() {
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 250.0));
		leiloeiro.avalia(leilao);

		Assert.assertEquals(400, leiloeiro.getMaiorLance(), 0.0001);
        Assert.assertEquals(250, leiloeiro.getMenorLance(), 0.0001);
	}
	
	@Test
	public void avaliaLeilaoEmOrdem() {
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leiloeiro.avalia(leilao);

		Assert.assertEquals(400, leiloeiro.getMaiorLance(), 0.0001);
        Assert.assertEquals(250, leiloeiro.getMenorLance(), 0.0001);
	}
	
	@Test
    public void deveEntenderLeilaoComApenasUmLance() {
        leilao.propoe(new Lance(joao,1000.0));
        leiloeiro.avalia(leilao);

        Assert.assertEquals(1000, leiloeiro.getMaiorLance(), 0.0001);
        Assert.assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
    }
	
	@Test
	public void deveRetornarAListaEmOrdemDecrescente() {
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 550.0));
		leilao.propoe(new Lance(jose, 7580.0));
		leilao.propoe(new Lance(maria, 320.0));
		leilao.propoe(new Lance(joao, 421.0));
		leilao.propoe(new Lance(jose, 523.0));
		leiloeiro.avalia(leilao);
		List<Lance> lista = leiloeiro.getTresMaiores();
		
		assertEquals(7580.0, lista.get(0).getValor(), 0.0001);
		assertEquals(550.0, lista.get(1).getValor(), 0.0001);
		assertEquals(523.0, lista.get(2).getValor(), 0.0001);
	}
	
	@Test
	public void avaliaLeilaoVazio() {
		leiloeiro.avalia(leilao);
		assertEquals(0, leiloeiro.getTresMaiores().size(), 0.0001);
	}
}
