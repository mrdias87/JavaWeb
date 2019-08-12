package br.mr.dias.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;

import br.mr.dias.pages.Page;

public class TesteDiscover extends Page {

	private WebDriver driver;
	
	@Before
	public void inicializa()
	{
		System.setProperty("webdriver.gecko.driver", "D:/drivers/java/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200,765));
		driver.get("https://gamersclub.com.br/discover#/jogadores");
	}
	
	@After
	public void finaliza()
	{
		driver.quit();
	}
	
	@Test
	public void PesquisarPalavraChaveExsitente()
	{
		setPalavraChave("mrdias87");
		driver.findElement(By.xpath("//input[@placeholder='Procure por nick, nome ou ID']")).sendKeys(Keys.RETURN);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='card-base-content']")).isDisplayed());
	}
	
	public void PesquisarPalavraChaveNaoExsitente()
	{
		setPalavraChave("adjajdlajdajdlajdlajdal");
		driver.findElement(By.xpath("//input[@placeholder='Procure por nick, nome ou ID']")).sendKeys(Keys.RETURN);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='no-results-container']")).isDisplayed());
	}
	
	 
}
