package StepDefinations;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pages.ObjectManager;

public class NewUserCreationStepDef extends ObjectManager{
	@Then("User click on the signin button")
	public void user_click_on_the_signin_button() throws InterruptedException {
		NewUser.SignBtn();

	}
	@Then("User click on the register button")
	public void user_click_on_the_register_button() {
		NewUser.RegisterBtn();

	}
	@Then("User enter the Email address")
	public void user_enter_the_email_address() throws InterruptedException {
		NewUser.EmailId();


	}
	@Then("User enter the first name")
	public void user_enter_the_first_name() {
		NewUser.FistName();

	}
	@Then("User enter the password")
	public void user_enter_the_password() {
		NewUser.Password();

	}
	@Then("User click on the register button and")
	public void user_click_on_the_register_button_and() {
		NewUser.ClickRegisterBtn();

	}
	@Then("Verify user is on home page")
	public void verify_user_is_on_home_page() throws InterruptedException {
		NewUser.HomePage();

	}
	@Then("Add the user details in notepad")
	public void add_the_user_details_in_notepad() throws IOException {
	    NewUser.writeDataInNotepad();
	}


}
