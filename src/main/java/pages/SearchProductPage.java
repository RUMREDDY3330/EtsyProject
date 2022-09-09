package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.TestBase;

public class SearchProductPage extends TestBase {
	private By SearchClkXpath = By.xpath("//div[@data-id= 'search-bar']/div/input");
	private By SearchInput = By.xpath("//div[@data-id= 'search-bar']/div/input");
	private By SearchBtn = By.xpath("(//button[@type='submit'])[1]");
	private By SelectProduct = By.xpath("//*[@id='content']/div/div[1]/div/div[4]/div[5]/div[3]/div[10]/div[1]/div/div/ul/li[1]");
	private By SizeXpath = By.xpath("//select[@id='variation-selector-0']");
	private By ColorXpath = By.xpath("(//div[@class='wt-select'])[2]/select");
	private By ClickonAddToCart = By.xpath("(//button[@type='submit'])[3]");
	private By productNameAtBasketpopUpPageText = By.xpath("//*[contains(text(),'Linen shirt for men NEVADA. Long sleeve,...')]");
	//private By reviewsText = By.xpath("//div[@id='listing-right-column']/div/div[1]/div[4]/div/div/div/div[1]/div[1]/div[1]/div[1]/div/h2");
	private By reviewsText = By.xpath("//h2[contains(text(),'reviews')]");
	private By gProductPriceText = By.xpath("//*[@id='listing-page-cart']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/p");
	private By closeIconBtnXpath =By.xpath("(//span[@class='wt-icon'])[16]");
	
	
	public void SearchProduct() {
		implicitylyWait(3);
		onclick(SearchClkXpath);
		//writeText(SelectProduct, "shirt for men");
		driver.findElement(SearchInput).sendKeys("shirt for men");
		
	}
	
	public void SearchButoonClick() {
		onclick(SearchBtn);
		
	}
	
	public void SelectProduct() {
		try {
			onclick(SelectProduct);
			implicitylyWait(2);
			SwitchWindow();
		} catch(Exception e){
			driver.navigate().refresh();
			onclick(SelectProduct);
			implicitylyWait(2);
			SwitchWindow();
		}
		
	}
	public void addToCart() throws InterruptedException {
	
		
		WebElement sizeEle = driver.findElement(SizeXpath);
		selectByVisibleText(sizeEle,"L");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		sellerName = driver.findElement(By.xpath("//div[@id='listing-page-cart']/div[1]/div/div/p/a/span")).getText();
		ProductName = driver.findElement(By.xpath("//*[@id='listing-page-cart']/div[2]/h1")).getText();
		ProductPrice= driver.findElement(gProductPriceText).getText();
		scrollToEleUntilViewed(reviewsText);
		productReviewsCount = driver.findElement(reviewsText).getText();
		WebElement colorEle = driver.findElement(ColorXpath);
		selectByVisibleText(colorEle,"Ocean blue");
		System.out.println("sellerName"+sellerName+ProductName+ProductPrice+productReviewsCount);
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(4000);
		WebElement AddToCart = driver.findElement(ClickonAddToCart);
		Actions a = new Actions(driver);
		a.moveToElement(AddToCart).click();
		a.build().perform();
		Thread.sleep(4000);
		implicitylyWait(3);
	}
	
	public void verifyProductIsAdded() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.switchTo().activeElement();
	    String actualProductname = driver.findElement(productNameAtBasketpopUpPageText).getText();
	    System.out.println("actualProductname:-" + actualProductname);
	    System.out.println("ProductName:-" + ProductName);
	    Assert.assertEquals(actualProductname, ProductName);
	  
	   
	}
	public void onClickCloseIcon() throws InterruptedException {
		waitForElementToBeDisplayed(closeIconBtnXpath);
		onclick(closeIconBtnXpath);
	}
	
}
