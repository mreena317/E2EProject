package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;

//	By login = By.xpath("//a[@id='log-in-button']");
	By login = By.id("log-in-button");
	By title = By.xpath("//div[@id='coachmarkContent']/div[1]");
	By navbar = By.id("menu");

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement selectText() {
		return driver.findElement(title);
	}

	public WebElement clickLogin() {
		return driver.findElement(login);
	}
	
	public WebElement collectNavbarItem() {
		return driver.findElement(navbar);
	}
	

}
