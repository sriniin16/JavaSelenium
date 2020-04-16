package automation;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(TestListener.class)
@CucumberOptions(features = "Features", glue = ".automation")
@Test
public class TestRunner extends AbstractTestNGCucumberTests{
	
		
}
