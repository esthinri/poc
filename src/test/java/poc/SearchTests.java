package poc;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SearchTests {
	
	WebDriver browser;
	String url;
	
	@Before
	public void readParameters() {
		String pBrowser = System.getProperty("browser");
		if(pBrowser.equals("firefox")) {
			 browser = new FirefoxDriver();
		} else if (pBrowser.equals("chrome")) {
			browser = new ChromeDriver();
		} else {
			browser = new SafariDriver();
		}	
		
		url = System.getProperty("url");
		 
	}
	
	@Test
	public void searchTest() {
		browser.get(url);
		WebElement campoPesquisa = browser.findElement(By.name("q"));
		campoPesquisa.sendKeys("Teste");
		WebElement botaoPesquisar = browser.findElement(By.name("btnK"));
		botaoPesquisar.click();
		WebElement speedTestLink = browser.findElement(By.partialLinkText("www.speedtest.net/pt"));
		assertTrue(speedTestLink.isDisplayed());

	}
	@Test
	public void searchItau() {
		
		browser.get(url);
		WebElement campoPesquisa = browser.findElement(By.name("q"));
		campoPesquisa.sendKeys("itau");
		WebElement botaoPesquisar = browser.findElement(By.name("btnK"));
		botaoPesquisar.click();
		WebElement speedTestLink = browser.findElement(By.partialLinkText("www.itau.com.br/"));
		assertTrue(speedTestLink.isDisplayed());
	
	}
	
	@Test
	public void searchRede() {
		WebDriver browser = new FirefoxDriver();
		
		browser.get(url);
		WebElement campoPesquisa = browser.findElement(By.name("q"));
		campoPesquisa.sendKeys("rede");
		WebElement botaoPesquisar = browser.findElement(By.name("btnK"));
		botaoPesquisar.click();
		WebElement speedTestLink = browser.findElement(By.partialLinkText("www.userede.com.br/"));
		assertTrue(speedTestLink.isDisplayed());

	}
	
	@After
	public void closeBrowser() {
		browser.close();
	}

}
