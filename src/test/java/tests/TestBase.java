package tests;

import org.testng.annotations.Test;

import Config.DriverManager;
import Config.DriverManagerFactory;
import Config.DriverType;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TestBase {
	DriverManager driverManager;
	WebDriver driver;
  @BeforeClass
  public void beforeClass() {
	  driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
  }

  @AfterTest
  public void afterTest() {
	  driver= driverManager.getWebDriver();
	  driver.quit();
	  
  }

}
