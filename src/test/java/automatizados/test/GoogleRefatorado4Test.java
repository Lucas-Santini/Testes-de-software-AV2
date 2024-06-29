package automatizados.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;

import automatizados.pageObject.GooglePO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Anotação para fixara ordem dos testes
public class GoogleRefatorado4Test extends BaseTest {
	
	private static GooglePO googlePage;
	
	@BeforeClass
	public static void prepararTestes() {
		driver.get("https://google.com");
		googlePage = new GooglePO(driver);
		
	}
	
	@Test
	public void TC001_DeveSerPossivelPesquisarNoGoogleReceitaDeBoloDeBanana() {
		googlePage.inputPesquisa.sendKeys("receita de bolo de banana" + Keys.ENTER);
		
		String resultado = googlePage.divPesq.getText();
		
		assertTrue(resultado, resultado.contains("relacionadas"));
		
	}
	
	@Test
	public void TC002_DeveSerPossivelPesquisarNoGoogleReceitaDeBoloDeLaranja() {
//		googlePage.inputPesquisa.sendKeys("receita de bolo de banana" + Keys.ENTER);
		googlePage.pesquisar("receita de bolo de banana");
		
//		String resultado = googlePage.divPesq.getText();
		String resultado = googlePage.obterResultadoDaPesquisa();
		
		assertTrue(resultado, resultado.contains("relacionadas"));
		
	}

}

