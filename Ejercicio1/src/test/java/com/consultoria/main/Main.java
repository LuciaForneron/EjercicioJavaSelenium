package com.consultoria.main;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	
	private WebDriver driver;
	private boolean alertaE;
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();  //inicializo el driver
		driver.manage().window().maximize();
		driver.get("https://www.consultoriaglobal.com.ar/cgweb"); //que pagina quiero que abra
	}
	

	@Test
	public void contextLoads() {
		WebElement boton = driver.findElement(By.xpath("//div[@class='col-2-12 push-right']"));
		
		boton.click();
		System.out.println("Clickeo de boton");
		WebElement nombre =  driver.findElement(By.xpath("//span[@class='wpcf7-form-control-wrap your-name']/input[@class='wpcf7-form-control wpcf7-text wpcf7-validates-as-required']"));
		System.out.println("Escribir nombre");
		WebElement email = driver.findElement(By.xpath("//span[@class='wpcf7-form-control-wrap your-email']/input[@class='wpcf7-form-control wpcf7-text wpcf7-email wpcf7-validates-as-required wpcf7-validates-as-email']"));
		System.out.println("Escribir email");
		WebElement asunto =  driver.findElement(By.xpath("//span[@class='wpcf7-form-control-wrap your-subject']/input[@class='wpcf7-form-control wpcf7-text wpcf7-validates-as-required']"));
		System.out.println("Escribir asunto");
		WebElement mensaje =  driver.findElement(By.xpath("//span[@class='wpcf7-form-control-wrap your-message']/textarea[@class='wpcf7-form-control wpcf7-textarea']"));
		System.out.println("Escribir mensaje");
		nombre.sendKeys("Lucía Fornerón");
		email.sendKeys("aaaa");
		asunto.sendKeys("Ejercicio de Java con Selenium");
		mensaje.sendKeys("No fue demasiado complicado, aunque si tuve algunas dificultades al no haber trabajado con Selenium antes.");
		email.submit();
		WebElement enviar =  driver.findElement(By.xpath("//input[@class='wpcf7-form-control wpcf7-submit']"));
		enviar.click();
		System.out.println("Clickeado enviar");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement alertaEmail = driver.findElement(By.xpath("//span[@class='wpcf7-form-control-wrap your-email']/span[@class = 'wpcf7-not-valid-tip']"));
		if(alertaEmail!=null) {
			alertaE = true;
		}
		if(alertaE) {
			System.out.println("Email invalido");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

	
		
	}

//	@After
//	public void terminar() {
//		driver.quit();
//	}
}
