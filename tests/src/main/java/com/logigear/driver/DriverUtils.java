package com.logigear.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {

	private static WebDriver driver;

	public static WebDriver openChrome() {
		ChromeOptions ops = new ChromeOptions();
		try {
			String hub = System.getenv("HUB");
			if (hub == null || hub.isEmpty()) {
				hub = "http://192.168.191.116:4444/wd/hub";
				//hub = "http://localhost:4444/wd/hub";
			}
			driver = new RemoteWebDriver(URI.create(hub).toURL(), ops);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static String captureScreenshot(String filename, String filepath) {
		String path = "";
		try {
			// Taking the screen using TakesScreenshot Class
			File objScreenCaptureFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Storing the image in the local system.
			File dest = new File(
					System.getProperty("user.dir") + File.separator + filepath + File.separator + filename + ".png");
			FileUtils.copyFile(objScreenCaptureFile, dest);
			path = dest.getAbsolutePath();
		} catch (Exception e) {
			System.out.println("An error occurred when capturing screen shot: " + e.getMessage());
		}
		return path;
	}

	public static void openLoginScrumBoard() {
		openChrome();
		String url = System.getenv("AUT");
		if (url == null || url.isEmpty()) {
			url = "http://192.168.191.116/login.html";
		}
		driver.navigate().to(url);
	}

	public static void openLoginPage() {
		String url = System.getenv("AUT");
		if (url == null || url.isEmpty()) {
			url = "http://192.168.191.116/login.html";
		}
		driver.navigate().to(url);
	}

	public static void quitBrowser() {
		driver.quit();
	}

	public static WebElement findElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static void enter(By by, String value) {
		WebElement el = findElement(by);
		el.clear();
		el.sendKeys(value);
	}

	public static void click(By by) {
		findElement(by).click();
	}

	public static void submit(By by) {
		findElement(by).submit();
	}

	public static boolean isElementDisplayed(By by) {
		try {
			return driver.findElement(by).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static String getTitle() {
		return driver.getTitle();
	}

	public static String getText(By by) {
		return findElement(by).getText();
	}
}
