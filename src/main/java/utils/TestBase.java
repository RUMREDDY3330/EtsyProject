package utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	
	public static WebDriver driver;
	public static String emailId;
	public static String firstName;
	public static String password;
	public static String ProductName;
	public static String ProductPrice;
	public static String productReviewsCount;
	public static String sellerName;
	
	
	/*public static WebDriverWait wait;
	public WebElement IsElementLocated(By loc) {
		WebDriverWait w = new WebDriverWait(driver,20);
		return w.until(ExpectedConditions.visibilityOfElementLocated(loc));*/
	public void SwitchWindow() {
		 String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();

	        // Here we will check if child window has other child windows and will fetch the heading of the child window
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
//	                WebElement text = driver.findElement(By.id("sampleHeading"));
//	                System.out.println("Heading of child window is " + text.getText());
	            }
	        }
		
	}
	public void selectByVisibleText(WebElement ele, String value) {
		Select s = new Select(ele);
		s.selectByVisibleText(value);
		
	}
	public void waitForElementToBeDisplayed(By ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
		
	}
	public void scrollToEleUntilViewed(By ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele1 = driver.findElement(ele);
		js.executeScript("arguments[0].scrollIntoView(true);",ele1);
		
	}
	
	public void moveToElementAndClick(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).click().build().perform();
	}
	public void clickByJs(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
		js.executeScript("arguments[0].click();",ele);
		
	}
}
