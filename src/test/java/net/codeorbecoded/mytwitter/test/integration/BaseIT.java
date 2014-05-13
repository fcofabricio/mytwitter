package net.codeorbecoded.mytwitter.test.integration;

import java.net.URISyntaxException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public abstract class BaseIT {
	
	protected static String siteBase;
	protected static WebDriver drv;

	@BeforeClass
	public static void setUpClass() throws URISyntaxException {
		siteBase = "http://localhost:8080/mytwitter/";
		drv = new PhantomJSDriver();
	}

	@AfterClass
	public static void tearDownClass() {
		drv.quit();
	}
	
	public void goToPage(String page) {
		drv.get(page);
	}

	public String getTitle() {
		return drv.getTitle();
	}

	public String getBodyText() {
		return drv.findElement(By.tagName("body")).getText();
	}

	public String getTextByTag(String tagName) {
		return drv.findElement(By.tagName(tagName)).getText();
	}

}
