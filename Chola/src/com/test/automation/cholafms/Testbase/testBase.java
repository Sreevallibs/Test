package com.test.automation.cholafms.Testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testBase {
public static WebDriver driver;
public Properties OR=new Properties();

public void init() throws IOException
{
	loadData();
	selectBrowser(OR.getProperty("browser"));
	getUrl(OR.getProperty("url"));
}

private void getUrl(String Url) {
	driver.get(Url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
}

private void selectBrowser(String browser) {
	if(browser.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","D:\\java_selenium\\selenium\\WorkSpace_Selenium\\Chola\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else
	{
		System.setProperty("webdriver.gecko.driver", "D:\\java_selenium\\selenium\\WorkSpace_Selenium\\Chola\\Driver\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	
}

private void loadData() throws IOException   {
	File file=new File("D:\\java_selenium\\selenium\\WorkSpace_Selenium\\Chola\\src\\com\\test\\automation\\cholafms\\config\\config.properties");
	FileInputStream f=new FileInputStream(file);
	OR.load(f);
	
}

}
