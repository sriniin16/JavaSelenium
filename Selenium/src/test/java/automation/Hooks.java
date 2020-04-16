package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks extends BaseStep {

    private BaseStep base;        

    public Hooks(BaseStep base)
    {
        this.base = base;
        
    }

    @Before
    public void Initialize()
    {    	    	
        System.out.println("Initializing webdriver...");
        String currentDir = System.getProperty("user.dir");                
        System.setProperty("webdriver.chrome.driver",currentDir+"\\Drivers\\chromedriver.exe");
        base.driver = new ChromeDriver();
        base.driver.get("http://www.automationpractice.com");
        base.driver.manage().window().maximize();
        base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void Teardown()
    {
        base.driver.quit();
        System.out.println("cleanup completed");
    }
}
