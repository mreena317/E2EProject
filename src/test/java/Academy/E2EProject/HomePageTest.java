package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LoginPage;

public class HomePageTest extends Base{
	public WebDriver driver; 
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String Lastname) throws IOException{
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		LoginPage login = new LoginPage(driver);
		System.out.println(lp.clickLogin().getText());
//		lp.selectText().getText();
		lp.clickLogin().click();
		
		login.enterUserName().sendKeys(Username);	
		login.enterLastName().sendKeys(Lastname);
		login.enterPassword().sendKeys(Password);
		System.out.println(login.clickLogin1().getText());
		login.clickLogin1().click();
		
	}
	
	@DataProvider
	public Object[][] getData() {
//		Row stands for how many different data types test should run
//		Coloumn stands for how many values per each test
		
		Object[][] data = new Object[2][3];
//		0th row
		data[0][0]="nonRestricteduser";
		data[0][1]="12343";
		data[0][2]= "Non restricted User";
		data[1][0] = "Restricteduser";
		data[1][1]= "23432";
		data[1][2]="Restricted User";
		
		return data;
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
