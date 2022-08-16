package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;

public class ValidateTitleTest extends Base {
	public WebDriver driver; 
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Title displayed");
	}
	@Test
	public void basePageNavigation() throws IOException {
		
		LandingPage lp = new LandingPage(driver);
//		Compare the text from the browser with actual text
		System.out.println(lp.selectText().getText());
		Assert.assertEquals(lp.selectText().getText(), "Have a AAdvantage® account?");		
		log.info("Successfully validated Text Message");
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
