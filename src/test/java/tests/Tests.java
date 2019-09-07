package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Config.DriverManager;
import Config.DriverManagerFactory;
import Config.DriverType;

public class Tests {
	DriverManager driverManager;
	WebDriver driver;
  @Test
  public void navigateToGoogleTest() {
	  driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
	  driver= driverManager.getWebDriver();
	  driver.get("https://www.google.com");
	  Assert.assertEquals(driver.getTitle(), "Google");
  }
}
