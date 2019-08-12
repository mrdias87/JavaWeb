package br.mr.dias.pages;
import org.openqa.selenium.By;

import br.mr.dias.core.BasePage;

public class Page extends BasePage {


	public void setPalavraChave(String nome)
	{
		dsl.escrever(By.xpath("//input[@placeholder='Procure por nick, nome ou ID']"), nome);
	}
	
	public String obterResultadoPalavraChave()
	{
		return dsl.obterTexto(By.xpath("//input[@placeholder='Procure por nick, nome ou ID']"));
	}
	
}
