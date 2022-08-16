package Academy.E2EProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
public WebDriver driver;
public Properties prop ;
	
//	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\atrin\\eclipse-workspace\\E2EProject\\data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
//		String Timeout = prop.getProperty("Timeout");
		
		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Users/atrin/chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:/Users/atrin/geckodriver.exe");
			driver = new FirefoxDriver();
			
		} else if(browserName.equals("IE")) {
//			driver = new InternetExploerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot TS = (TakesScreenshot) driver;
		File source = TS.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+ testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

} 
