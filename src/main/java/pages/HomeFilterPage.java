package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;

import utils.TestBase;

public class HomeFilterPage extends TestBase{
	private By filterBtnXpath = By.xpath("//*[contains(text(),'All Filters')]");
	private By selectchectBoxFilterXpath = By.xpath("//label[contains(text(),'Bestseller')]");
	private By applybtnXpath = By.xpath("//*[contains(text(),'Apply')]");
	private By verifyselectingDisplayXpath =By.xpath("(//*[contains(text(),'Bestseller')])[1]");
	
	public void filterbutton() {
		onclick(filterBtnXpath);
		implicitylyWait(3);
	}
	
	public void selectcheckboxinfilter() {
		onclick(selectchectBoxFilterXpath);
	}
	public void clickonapplybutton() {
		onclick(applybtnXpath);
	}
	public void verifyselectingfilterdisplay() {
		implicitylyWait(2);
		String actualselectingfilter = getText(verifyselectingDisplayXpath);
	    Assert.assertEquals("Bestseller", actualselectingfilter);
	}
}
