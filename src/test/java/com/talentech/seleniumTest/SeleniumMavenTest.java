package com.talentech.seleniumTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumMavenTest {

	public static void main(String[] args) throws InterruptedException  {

		WebDriver driver = new ChromeDriver();

		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			System.out.println("- Testing Started Mac Platform -");
			System.setProperty("webdriver.chrome.driver", "chromedrivere");
		} else if (System.getProperty("os.name").toLowerCase().contains("win")) {
			System.out.println("- Testing Started Windows Platform -");
			System.setProperty("webdriver.chrome.driver", "chromedrivere.exe");
		} else {
			System.out.println("- Invalid Platform! -");
		}

		driver.get("https://www.etsy.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement signIn = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
		signIn.click();
		WebElement email = driver.findElement(By.cssSelector("#join_neu_email_field"));
		WebElement password = driver.findElement(By.xpath("//input[@id='join_neu_password_field']"));
		WebElement submitButton = driver.findElement(By.xpath("//button[@name='submit_attempt']"));
		email.sendKeys("email@email.com");
		password.sendKeys("password");
		submitButton.click();
		WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(),'Password was incorrect')]"));
		String error = errorMsg.getText().trim();

		if (error.equals("Password was incorrect")) {
			System.out.println("PASSED!");
		} else {
			System.out.println("FAILED!");
		}

		Thread.sleep(3000);
		driver.quit();

	}


}
