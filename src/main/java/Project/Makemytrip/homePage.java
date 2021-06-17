package Project.Makemytrip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {
	public WebDriver driver;
	private By blankclick = By.xpath("//body");
	private By login = By.xpath("//li[@data-cy='account']");
	private By logintext = By.xpath("//p[contains(text(),'You are viewing your personal profile')]");
	public homePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public WebElement getLoginorCreateAccount()
	{
		return driver.findElement(login);
	}
	public WebElement getLoginText()
	{
		return driver.findElement(logintext);
	}
	public WebElement getBlankClick()
	{
		return driver.findElement(blankclick);
	}
}
