package Project.Makemytrip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	public WebDriver driver;
	private By emailOrNumber = By.id("username");
	private By error = By.xpath("//p[contains(text(),'Please enter a valid Email Id or Mobile Number.')]");
	private By continuebtn = By.cssSelector("[class*='btnContainer'] button");
	private By password = By.id("password");
	private By loginbtn = By.cssSelector("[class*='btnContainer'] button");
	private By enterOtp = By.cssSelector("[placeholder='Enter OTP']");
	private By close = By.cssSelector("[data-cy='modalClose']");
	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public WebElement getUserIdBox()
	{
		return driver.findElement(emailOrNumber);
	}
	public WebElement getErrorMsg()
	{
		return driver.findElement(error);
	}
	public WebElement getContinueButton()
	{
		return driver.findElement(continuebtn);
	}
	public WebElement getLoginButton()
	{
		return driver.findElement(loginbtn);
	}
	public WebElement getPasswordBox()
	{
		return driver.findElement(password);
	}
	public WebElement getOtpBox()
	{
		return driver.findElement(enterOtp);
	}
	public WebElement getCloseBox()
	{
		return driver.findElement(close);
	}
}