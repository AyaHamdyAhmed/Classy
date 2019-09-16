package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepo.RespositoryParser;

public class PageBase {
	private static final int TIMEOUT = 5;
	private static final int POLLING = 100;
	private static final int LONGWAIT = 10000;
	private static final int SHORTWAIT = 3000;
	protected RespositoryParser parser;

	protected WebDriver driver;
	private WebDriverWait wait;

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
		driver.manage().timeouts().implicitlyWait(SHORTWAIT,TimeUnit.SECONDS) ;
	}
}
