package pages;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelReadData;
import utils.TestBase;

public class LoginPage extends TestBase{
	
	private By AccountOpenXpath = By.xpath("//li/button"); 
	private By UsernamesXpath = By.xpath("//input[@id='join_neu_email_field']");
	private By userPasswordXpath= By.xpath("//input[@id='join_neu_password_field']");
	private By LoginBtnXpath = By.name("submit_attempt");
	private By HomePageXpath = By.xpath("//*[@id='content']/div/div[1]/div[2]/div/div/h1[1]");
	//private By HomePageXpath = By.xpath("//a[contains(text(),'R Umamaheswara Reddy')])[2]");//(//a[@class='wt-text-link'])[2]
	private By ErrorMsg = By.xpath("//input[@name='password']/following-sibling::div");
	   
	  
	public void OpenBrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.etsy.com/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(AccountOpenXpath).click();
	}
	
	public void EnterUsernameandpassword(String username, String password) {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		waitForElementToBeDisplayed(UsernamesXpath);
		writeText(UsernamesXpath, username);
		writeText(userPasswordXpath, password);
//		driver.findElement(UsernamesXpath).sendKeys(username);
//		driver.findElement(userPasswordXpath).sendKeys(password);
		
	}
	
	public void onClickloginbtn() {
		driver.findElement(LoginBtnXpath).click();
		
	}
	public void verifyuseronhomepage() {
		waitForElementToBeDisplayed(HomePageXpath);
		String expectename = getText(HomePageXpath);
		System.out.println("expectename"+expectename);
		boolean flag = false;
		if(expectename.contains("R Umamaheswara Reddy")) {
			flag = true;
			
		}
		Assert.assertTrue(flag);
		Assert.assertEquals("Welcome back, R Umamaheswara Reddy!", expectename);
		
	}
	
	public void verifyErrorpwd() throws InterruptedException {

		waitForElementToBeDisplayed(ErrorMsg);
		String errorPwd = getText(ErrorMsg);
		System.out.println("ErrorMessage" + errorPwd);
		   Assert.assertEquals("Password was incorrect", errorPwd);
		   
	}
	
	public void EnterUsernameandpasswordFromExcelSheet() throws IOException {
		implicitylyWait(2);
		waitForElementToBeDisplayed(UsernamesXpath);
		String username = ExcelReadData.readExcelData(1, 0);
		String password = ExcelReadData.readExcelData(1, 1);
		writeText(UsernamesXpath, username);
		writeText(userPasswordXpath,password);
//		driver.findElement(UsernamesXpath).sendKeys(username);
//		driver.findElement(userPasswordXpath).sendKeys(password);
		
	}

}
