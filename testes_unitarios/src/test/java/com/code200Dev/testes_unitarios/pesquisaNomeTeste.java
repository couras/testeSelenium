package com.code200Dev.testes_unitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pesquisaNomeTeste {

	@Test
	public void testarNomeCadastrado() {
		
		final String _url = "http://192.168.4.103:8080/correntista/novo";
		
		System.setProperty("webdriver.chrome.driver", "/Users/fibbauru/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		
		for(int i = 0; i < 1; i++) {
			driver.get(_url);
			WebElement text = driver.findElement(By.name("nome"));
			
			text.sendKeys("Denis Couras");
			
			text = driver.findElement(By.name("email"));
			text.sendKeys("deniscouras@gmail.com");
			
			WebElement butao = driver.findElement(By.id("button1"));
			butao.click();
		}
		
		boolean content = driver.getPageSource().contains(".com.br");
		
		assertTrue(content);
		
	}
	
}
