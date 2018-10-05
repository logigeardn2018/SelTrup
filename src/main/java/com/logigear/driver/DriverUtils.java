package com.logigear.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {

	private static WebDriver driver;

	private static synchronized WebDriver getChromeDriver() {
		if (driver == null) {
			//System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			ChromeOptions ops = new ChromeOptions();
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.191.205:4444/wd/hub"), ops);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return driver;
	}

	public static void openGooglePage() {
		getChromeDriver().navigate().to("https://www.google.com");
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
	
	public static void submit(By by) {
		findElement(by).submit();
	}

	public static String getTitle() {
		return getChromeDriver().getTitle();
	}
}
