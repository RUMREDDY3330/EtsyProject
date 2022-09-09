package StepDefinations;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pages.LoginPage;
import pages.ObjectManager;

public class LoginStepDef extends ObjectManager{
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		loginpage.OpenBrowser();


	}
	@When("User entered username {string} and password {string}")
	public void user_entered_username_and_password(String username, String password) throws InterruptedException {
		loginpage.EnterUsernameandpassword(username, password);

	}
	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		loginpage.onClickloginbtn();

	}
	@Then("verify user is on home page")
	public void verify_user_is_on_home_page() {
		loginpage.verifyuseronhomepage();

	}
	@Then("Verify enter valid username and invalid password error message should display")
	public void verify_enter_valid_username_and_invalid_password_error_message_should_display() throws InterruptedException {
	   loginpage.verifyErrorpwd();
	}

	@When("User enters username and password from excel")
	public void user_enters_username_and_password_from_excel() throws IOException {
	    loginpage.EnterUsernameandpasswordFromExcelSheet();
	}
}
