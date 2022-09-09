package StepDefinations;

import io.cucumber.java.After;
import utils.TestBase;

public class Hooks extends TestBase{
	
	@After
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		
	}

}
