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

	private static synchronized WebDriver getChromeDriver() {
		if (driver == null) {
			ChromeOptions ops = new ChromeOptions();
			try {
				driver = new RemoteWebDriver(URI.create("http://192.168.191.116:4444/wd/hub").toURL(), ops);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return driver;
	}
	
	public static String captureScreenshot(String filename, String filepath) {
		String path = "";
		try {
			// Taking the screen using TakesScreenshot Class
			File objScreenCaptureFile = ((TakesScreenshot) getChromeDriver()).getScreenshotAs(OutputType.FILE);

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

	public static void openGooglePage() {
		getChromeDriver().navigate().to("https://www.google.com");
	}

	public static void quitBrowser() {
		getChromeDriver().quit();
		driver = null;
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
