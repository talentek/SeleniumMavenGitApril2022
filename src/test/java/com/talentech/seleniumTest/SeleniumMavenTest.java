package com.talentech.seleniumTest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumMavenTest {

	public static void main(String[] args) throws InterruptedException {

		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			System.out.println("- Testing Started Mac Platform -");
			System.setProperty("webdriver.chrome.driver", "chromedriver");
		} else if (System.getProperty("os.name").toLowerCase().contains("win")) {
			System.out.println("- Testing Started Windows Platform -");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		} else {
			System.out.println("- Invalid Platform! -");
		}
		// WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ups.com/track?loc=en_US&requester=ST/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement trackingInput = driver.findElement(By.id("stApp_trackingNumber"));
		trackingInput.sendKeys("123456789");
		WebElement trackButton = driver.findElement(By.id("stApp_btnTrack"));
		trackButton.click();
		WebElement errorMsg = driver.findElement(By.id("stApp_lblInfoNotice"));
		String error = errorMsg.getText().trim();

		System.out.println(error);
		if (error.equals("Please provide a tracking number.")) {
			System.out.println("PASSED!");
		} else {
			System.out.println("FAILED!");
		}

		Thread.sleep(3000);
		driver.quit();

	}

}
