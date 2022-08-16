package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

//Adding logs
//Generating html reports
//Screenshiots on failure
//Jenkin integration

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;

public class ValidateNavbarTest extends Base {
	public WebDriver driver; 
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() throws IOException {
//		System.out.println(browser)
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.collectNavbarItem().isDisplayed());
		log.info("Navigation bar is displayed");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
