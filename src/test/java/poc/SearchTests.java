package poc;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchTests {
	
	
	String url;
	RemoteWebDriver driver;
	@Before
	public void readParameters() {
		
		DesiredCapabilities dc;
		
		String browser = System.getProperty("browser");
		if(browser.equals("firefox")) {
			 dc = new DesiredCapabilities().firefox();
		} else if (browser.equals("chrome")) {
			dc = new DesiredCapabilities().chrome();
		} else {
			dc = new DesiredCapabilities().internetExplorer();
		}	
		
		url = System.getProperty("url");
		
		try {
			driver = new RemoteWebDriver(new URL("http://10.11.12.13:4444/wd/hub"), dc);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void searchTest() {
		driver.get(url);
		WebElement campoPesquisa = driver.findElement(By.name("q"));
		campoPesquisa.sendKeys("Teste");
		WebElement botaoPesquisar = driver.findElement(By.name("btnK"));
		botaoPesquisar.click();
		WebElement speedTestLink = driver.findElement(By.partialLinkText("www.speedtest.net/pt"));
		assertTrue(speedTestLink.isDisplayed());

	}
	@Test
	public void searchItau() {
		
		driver.get(url);
		WebElement campoPesquisa = driver.findElement(By.name("q"));
		campoPesquisa.sendKeys("itau");
		WebElement botaoPesquisar = driver.findElement(By.name("btnK"));
		botaoPesquisar.click();
		WebElement speedTestLink = driver.findElement(By.partialLinkText("www.itau.com.br/"));
		assertTrue(speedTestLink.isDisplayed());
	
	}
	
	@Test
	public void searchRede() {
		driver.get(url);
		WebElement campoPesquisa = driver.findElement(By.name("q"));
		campoPesquisa.sendKeys("rede");
		WebElement botaoPesquisar = driver.findElement(By.name("btnK"));
		botaoPesquisar.click();
		WebElement speedTestLink = driver.findElement(By.partialLinkText("www.userede.com.br/"));
		assertTrue(speedTestLink.isDisplayed());

	}
	
	@After
	public void closeBrowser() {
		driver.close();
	}

}
