package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	
	By userName = By.xpath("//input[@id='loginId']");
	By lastName = By.xpath("//*[@id='lastName']");
	By password = By.cssSelector("input[id='password']");
//	By submit = By.id("button_login");
	By submit = By.cssSelector("button[id='button_login']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement enterUserName() {
		return driver.findElement(userName);
	}
	
	public WebElement enterLastName() {
		return driver.findElement(lastName);
	}
	
	public WebElement enterPassword() {
		return driver.findElement(password);
	}
	public WebElement clickLogin1() {
		return driver.findElement(submit);
	}

	
	
}
