package StepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pages.HomeFilterPage;
import pages.ObjectManager;
import utils.TestBase;

public class HomeFilterStepDef extends ObjectManager{

	@Then("click on filter button")
	public void click_on_filter_button() {
		homepage.filterbutton();
		
	    
	}
	@Then("select the bestseller box")
	public void select_the_bestseller_box() {
		homepage.selectcheckboxinfilter();
}
	@Then("click on applybutton")
	public void click_on_applybutton() {
		homepage.clickonapplybutton();
	    
	}
	@Then("filter selection should be display")
	public void filter_selection_should_be_display() {
	    
		
	}

}
