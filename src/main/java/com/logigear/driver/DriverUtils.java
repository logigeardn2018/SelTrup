package com.logigear.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {

	private static WebDriver driver;

	private static synchronized WebDriver getChromeDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}

	public static void openScrumBoard() {
		String url = System.getProperty("user.dir") + "\\aut\\ScrumBoard\\login.html";
		System.out.println("openScrumBoard: " + url);
		getChromeDriver().navigate().to(url);
	}

	public static void quitBrowser() {
		getChromeDriver().quit();
	}

	public static WebElement findElement(By by) {
		WebDriverWait wait = new WebDriverWait(getChromeDriver(), 10);
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static void enter(By by, String value) {
		findElement(by).sendKeys(value);
	}

	public static void click(By by) {
		findElement(by).click();
	}
	
	public static String getTitle() {
		return getChromeDriver().getTitle();
	}
}
