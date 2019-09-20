package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepo.DataParser;
import objectRepo.RespositoryParser;

public class PageBase {
	private static final int TIMEOUT = 5;
	private static final int POLLING = 1000;
	private static final int LONGWAIT = 10000;
	private static final int SHORTWAIT = 3000;
	protected RespositoryParser parser;
	protected DataParser dataparser;

	protected WebDriver driver;
	private WebDriverWait wait;

	protected void Initialize() {
		try {
			parser = new RespositoryParser("application.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void initializeData() {
		try {
			dataparser = new DataParser("TestData.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void waitForElementToAppear(WebDriver driver, By locator) {
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}

	protected void waitForElementToDisappear(WebDriver driver, By locator) {
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	protected void waitForElementToBeInteractable(WebDriver driver, By locator) {
		wait = new WebDriverWait(driver, TIMEOUT, LONGWAIT);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	protected void ClickOnElement(WebDriver driver, By locator) {
		waitForElementToBeInteractable(driver, locator);
		driver.findElement(locator).click();

	}

	protected void clickOnElementByJavaScript(WebDriver driver, WebElement elem) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
	}

	protected void implicitWaitUntilLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(SHORTWAIT, TimeUnit.SECONDS);
	}

	protected void implicitWaitUntilLoadWithLongWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(LONGWAIT, TimeUnit.SECONDS);
	}

	protected void SendkeysToElemnent(WebDriver driver, By locator, String key) {
		//waitForElementToAppear(driver, locator);
		driver.findElement(locator).sendKeys(key);
	}
	protected void SwitchToNewTab(WebDriver driver) {
		 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.close();
		    driver.switchTo().window(tabs2.get(1));
	}
	protected void LongWait() {
		
			try {
				Thread.sleep(POLLING);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
}
