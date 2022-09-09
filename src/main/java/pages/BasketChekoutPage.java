package pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.ExcelReadData;
import utils.TestBase;

public class BasketChekoutPage extends TestBase{
	private By BasketiconXpath = By.xpath("(//span[@class='wt-icon'])[4]");
	private By productNameTextXpath = By.xpath("//a[contains(text(),'MagicLinen')]");
	private By contactShopTextXpath = By.xpath("//a[contains(text(),'Contact ')]"); 
	
	public void BasketIconbutton() {
		scrollToEleUntilViewed(BasketiconXpath);
		WebElement ele = driver.findElement(BasketiconXpath);
		//moveToElementAndClick(ele);
		
		clickByJs(ele);
		//driver.findElement(Basketclick).click();	
	}
	public void verifyuserIsOnBasketPage() {
		
		String ActualContactText = getText(contactShopTextXpath);
	    Assert.assertEquals(ActualContactText, "Contact shop");
	}
	public void verifyProductAddedToCart() {
		String actualProductNameAtBasket = driver.findElement(productNameTextXpath).getText();
		System.out.println("actualProductNameAtBasket:- "+ actualProductNameAtBasket );
	    Assert.assertEquals(actualProductNameAtBasket, TestBase.sellerName);
	    
	}
	public void addCartDetailsInExcelSheet() throws IOException {
		System.out.println(TestBase.ProductName+TestBase.ProductPrice+TestBase.productReviewsCount);
		ExcelReadData.writeExcelData();
	}

}
