package TestRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= {"src\\test\\java\\Features\\UserCreation.feature"},
        glue={"StepDefinations"},
        tags="@NewUserCreation", 
        dryRun=false,
        monochrome=true,
        plugin= {"pretty" , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class RunnerEtsy {
	

}
