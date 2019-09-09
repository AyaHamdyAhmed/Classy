package tests;

import Config.DriverManager;
import Config.DriverManagerFactory;
import Config.DriverType;
import objectRepo.RespositoryParser;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestBase {
	DriverManager driverManager;
	WebDriver driver;
	protected RespositoryParser parser;
  @BeforeClass
  public void setup() {
	  driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
	  try {
		parser = new RespositoryParser("ObjectRepo.properties");
	} catch (IOException e) {
		e.printStackTrace();
	}
  }

  @AfterClass
  public void tearDown() {
	  driver= driverManager.getWebDriver();
	  driver.quit();
	  
  }

}
