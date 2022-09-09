package pages;

import java.time.Duration;

import org.openqa.selenium.By;

import junit.framework.Assert;
import utils.TestBase;

public class HomeFilterPage extends TestBase{
	private By filterBtnXpath = By.xpath("//*[contains(text(),'All Filters')]");
	private By selectchectBoxFilterXpath = By.xpath("//label[contains(text(),'Bestseller')]");
	private By applybtnXpath = By.xpath("//*[contains(text(),'Apply')]");
	private By verifyselectingDisplayXpath =By.xpath("(//*[contains(text(),'Bestseller')])[1]");
	
	public void filterbutton() {
		driver.findElement(filterBtnXpath).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
	}
	
	public void selectcheckboxinfilter() {
		driver.findElement(selectchectBoxFilterXpath).click();
		
	}
	
	public void clickonapplybutton() {
		driver.findElement(applybtnXpath).click();
	}
	
	public void verifyselectingfilterdisplay() {
		String actualselectingfilter = driver.findElement(verifyselectingDisplayXpath).getText();
	    Assert.assertEquals("Bestseller", actualselectingfilter);
	}
}
