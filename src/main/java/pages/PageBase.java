package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	  private static final int TIMEOUT = 5;
	    private static final int POLLING = 100;

	    protected WebDriver driver;
	    private WebDriverWait wait;

	    protected void waitForElementToAppear(By locator) {
	    	wait = new WebDriverWait(driver, TIMEOUT, POLLING);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	    protected void waitForElementToDisappear(By locator) {
	    	wait = new WebDriverWait(driver, TIMEOUT, POLLING);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	    }
	    protected void waitForElementToBeInteractable(WebDriver driver, By locator) {
	    	wait = new WebDriverWait(driver, TIMEOUT, POLLING);
	        wait.until(ExpectedConditions.elementToBeClickable(locator));
	    } 
}
