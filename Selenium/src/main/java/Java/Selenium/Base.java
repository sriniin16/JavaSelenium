package Java.Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Base {
	
	String FilePath ="C:\\BackUp-Srini\\Projects\\JavaSelenium\\Selenium\\TestVariables.properties";
	
	public void initDriver() throws FileNotFoundException
	{
		Properties properties = new Properties();
		FileInputStream fs = new FileInputStream(FilePath);
	}

}
