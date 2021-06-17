package stepDefinations;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Project.Makemytrip.browserInitialisation;
import Project.Makemytrip.gmailOtp;
import Project.Makemytrip.homePage;
import Project.Makemytrip.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


    

    @RunWith(Cucumber.class)
    public class LoginstepDefination extends browserInitialisation{
    	private loginPage lp; 
    	private homePage hp;
    	private Actions mouseActions;
    	private String email ="";
        @Given("^User is on MakeMyTrip homepage$")
        public void user_is_on_makemytrip_homepage() throws Throwable 
        {
        	driver = intializedriver();
        	driver.get("https://www.makemytrip.com/");
        }

        @When("^User tries to login with entering Email id \"([^\"]*)\" and Clicks on continue$")
        public void user_tries_to_login_with_entering_email_id_something_and_clicks_on_continue(String strArg1) throws Throwable 
        {
        	lp = new loginPage(driver);
        	lp.getUserIdBox().sendKeys(strArg1);
        	email=strArg1;
        	mouseActions = new Actions(driver);
        	mouseActions.moveToElement(lp.getContinueButton()).click().build().perform();
        	Thread.sleep(5000);
        }

        @Then("^Message is displayed \"([^\"]*)\"$")
        public void message_is_displayed_something(String strArg1) throws Throwable 
        {
        	WebDriverWait wait = new WebDriverWait(driver,30);
        	wait.until(ExpectedConditions.visibilityOf(lp.getErrorMsg()));
        	if(lp.getErrorMsg().getText().equalsIgnoreCase(strArg1))
        	{
        		Assert.assertTrue(true);
        		driver.close();
        	}
        	else
        	{
        		Assert.assertTrue(false);
        	}
        }

        @Then("^User lands on MakeMyTrip HomePage and Login Validated$")
        public void user_lands_on_makemytrip_homepage_and_login_validated() throws Throwable 
        {
        	 Thread.sleep(2000);
             hp.getLoginorCreateAccount().click();
             if(hp.getLoginText().getText().contains(email))
            	 System.out.println("Login verified");
        }

        @And("^Clicks on Login or Create account$")
        public void clicks_on_login_or_create_account() throws Throwable 
        {
        	hp= new homePage(driver);
            hp.getBlankClick().click();
            Thread.sleep(2000);
            hp.getLoginorCreateAccount().click();
        }



        @And("^User enters Password \"([^\"]*)\" and clicks on Login$")
        public void user_enters_password_something_and_clicks_on_login(String strArg1) throws Throwable 
        {
        	lp.getPasswordBox().sendKeys(strArg1);
        	mouseActions.moveToElement(lp.getLoginButton()).click().build().perform();
        	//messageOtp message= new messageOtp();
        	//gmailOtp otp = new gmailOtp();
        	String otpno = gmailOtp.messageOtp();
        	Thread.sleep(25000);
        	lp.getOtpBox().sendKeys(otpno);
        	mouseActions.moveToElement(lp.getLoginButton()).click().build().perform();
        	lp.getCloseBox().click();
        }
    }

    

    
    


