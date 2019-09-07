package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends TestBase{
	
	WebDriver driver;
  @Test
  public void navigateToGoogleTest() {
	  driver= driverManager.getWebDriver();
	  driver.get("https://www.google.com");
	  Assert.assertEquals(driver.getTitle(), "Google");
  }
}
