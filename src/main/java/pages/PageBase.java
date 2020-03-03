package pages;


import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TimeoutException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
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
	private Logger logger = Logger.getLogger(PageBase.class);
	
	protected WebDriver driver;
	private WebDriverWait wait;

	protected void Initialize() {
		try {
			parser = new RespositoryParser("application.properties");
		} catch (IOException e) {
			e.printStackTrace();
			LogConfig();
			logger.error("can't load properties file", e);
		}
	}

	protected void initializeData() {
		try {
			dataparser = new DataParser("TestData.properties");
		} catch (IOException e) {
			e.printStackTrace();
			LogConfig();
			logger.error("can't load data file", e);
		}
	}

	protected void waitForElementToAppear(WebDriver driver, By locator) {
		try {
			wait = new WebDriverWait(driver, TIMEOUT, POLLING);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (ElementNotVisibleException NVE) {
			NVE.printStackTrace();
			LogConfig();
			logger.error("Element is not visible", NVE);
		}
	}

	protected void waitForElementToDisappear(WebDriver driver, By locator) {
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	protected void waitForElementToBeInteractable(WebDriver driver, By locator) {
		try {
			wait = new WebDriverWait(driver, TIMEOUT, LONGWAIT);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (ElementNotInteractableException ENIE) {
			ENIE.printStackTrace();
			LogConfig();
			logger.error("Element is not Enteractable", ENIE);
		}
	}

	protected void ClickOnElement(WebDriver driver, By locator) {
		try {
			waitForElementToBeInteractable(driver, locator);
			driver.findElement(locator).click();
		} catch (ElementClickInterceptedException ECIE) {
			ECIE.printStackTrace();
			LogConfig();
			logger.error("Element is not clikable", ECIE);
		}

	}

	protected void clickOnElementByJavaScript(WebDriver driver, WebElement elem) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		} catch (ElementNotInteractableException ENIE) {
			ENIE.printStackTrace();
			LogConfig();
			logger.error("Element is not clikable", ENIE);

		}
	}

	protected void implicitWaitUntilLoad(WebDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(SHORTWAIT, TimeUnit.SECONDS);
		} catch (TimeoutException Te) {
			Te.printStackTrace();
			LogConfig();
			logger.error("Time is out", Te);
		}
	}

	protected void implicitWaitUntilLoadWithLongWait(WebDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(LONGWAIT, TimeUnit.SECONDS);
		} catch (TimeoutException Te) {
			Te.printStackTrace();
			LogConfig();
			logger.error("Time is out", Te);
		}
	}

	protected void SendkeysToElemnent(WebDriver driver, By locator, String key) {
		try {
		driver.findElement(locator).sendKeys(key);
		}catch(ElementNotInteractableException ENIEX) {
			ENIEX.printStackTrace();
			LogConfig();
			logger.error("Element is not Interactable", ENIEX);
		}
	}

	protected void SwitchToNewTab(WebDriver driver) {
		try {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.close();
		driver.switchTo().window(tabs2.get(1));
		}catch(NoSuchWindowException NSWE) {
			LogConfig();
			logger.error("new tab is not found", NSWE);
		}
	}

	protected void LongWait() {

		try {
			Thread.sleep(POLLING);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	protected void LonglongWait() {

		try {
			Thread.sleep(LONGWAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	protected void LogConfig() {
		PropertyConfigurator.configure("Log4j.properties");
	}
}
		
