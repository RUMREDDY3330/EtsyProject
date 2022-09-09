package pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Then;
import junit.framework.Assert;
import utils.NotepadReadWriteData;
import utils.TestBase;

public class NewUserCreationPage extends TestBase {
	
	private By SingInBtnXpath = By.xpath("//button[contains(text(),'Sign in')]");
	private By RegisterBtnXpath = By.xpath("//*[@id=\"join-neu-form\"]/div/div/div/div/h1/following-sibling::button");
	private By EmaiIdXpath = By.xpath("//input[@name='email']");
	private By FirstNameXpath = By.xpath("//input[@name='first_name']");
	private By pwdXpath = By.xpath("//input[@name='password']");
	private By ClickRegisterBtnXpath = By.xpath("//div[@class='wt-validation']/button");
	private By HomepageXpath = By.xpath("//*[@id='content']/div/div[1]/div/div/h1[1]");
	
	
	public void SignBtn() {
		implicitylyWait(2);
		waitForElementToBeDisplayed(SingInBtnXpath);
		WebElement element = driver.findElement(SingInBtnXpath);
		Actions a = new Actions(driver);
		a.moveToElement(element).click().perform();
		
	}
	
	public void RegisterBtn() {
		implicitylyWait(2);
		onclick(RegisterBtnXpath);
	}
	
	public void EmailId () throws InterruptedException {
		Thread.sleep(3000);
		 Date dNow = new Date( );
	      SimpleDateFormat ft = new SimpleDateFormat ("ddMMhhmm");
	      emailId ="mahesh"+ ft.format(dNow).toString()+"@gmail.com";
		driver.findElement(EmaiIdXpath).sendKeys(emailId);
	}
	public void FistName() {
		firstName = "mahesh";
		driver.findElement(FirstNameXpath).sendKeys(firstName);
	}
	public void Password() {
		password = "9581131156";
		writeText(pwdXpath, password);
		implicitylyWait(2);
	}
	public void ClickRegisterBtn() {
		onclick(ClickRegisterBtnXpath);
		
	}
	
	public void HomePage() {
		implicitylyWait(3);
		String name = getText(HomepageXpath);
		Assert.assertEquals("Welcome to Etsy, mahesh!", name);
		
	}
	

	public void writeDataInNotepad() throws IOException {
	
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("ddMMhhmm");
		String emailId = ft.format(dNow).toString();
		String notePadData = TestBase.emailId + " / "+TestBase.password;
		
		NotepadReadWriteData.WriteDataInNotePad("NewUser"+emailId, notePadData);
	}



	
}
