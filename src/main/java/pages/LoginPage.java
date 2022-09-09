package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
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
		driver.findElement(UsernamesXpath).sendKeys(username);
		driver.findElement(userPasswordXpath).sendKeys(password);
		
	}
	
	public void onClickloginbtn() {
		driver.findElement(LoginBtnXpath).click();
		
	}
	public void verifyuseronhomepage() {
		waitForElementToBeDisplayed(HomePageXpath);
		String expectename = driver.findElement(HomePageXpath).getText();
		System.out.println("expectename"+expectename);
		boolean flag = false;
		if(expectename.contains("R Umamaheswara Reddy")) {
			flag = true;
			
		}
		Assert.assertTrue(flag);
		Assert.assertEquals("Welcome back, R Umamaheswara Reddy!", expectename);
		
	}
	
	public void verifyErrorpwd() throws InterruptedException {
		Thread.sleep(2000);
		String errorPwd = driver.findElement(ErrorMsg).getText();
		System.out.println("ErrorMessage" + errorPwd);
		   Assert.assertEquals("Password was incorrect", errorPwd);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	public void EnterUsernameandpasswordFromExcelSheet() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String username = ExcelReadData.readExcelData(1, 0);
		String password = ExcelReadData.readExcelData(1, 1);
		driver.findElement(UsernamesXpath).sendKeys(username);
		driver.findElement(userPasswordXpath).sendKeys(password);
		
	}

}
