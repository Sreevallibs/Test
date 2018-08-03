package com.test.automation.cholafms.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;

	@FindBy(id="username")
	WebElement loginID;
	
	@FindBy(id="password")
	WebElement loginPassword;
	
	@FindBy(xpath="/html/body/div[2]/form[1]/div[6]/button")
	WebElement loginButton;
	
	@FindBy(xpath="/html/body/div[2]/form[1]/div[4]/span")
	WebElement userErrorMessage;
	
	@FindBy(xpath="/html/body/div[2]/form[1]/div[5]/span")
	WebElement passwordErrorMessage;
	
	@FindBy(xpath="/html/body/div[2]/form[1]/div[2]/span")
	WebElement invalidUserName;
	
	@FindBy(xpath="/html/body/div[2]/form[1]/div[2]/span")
	WebElement invalidPassword;
	
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginToApplication(String username,String password) throws Exception
	{
		loginID.clear();
		loginPassword.clear();
		loginID.sendKeys(username);
		loginPassword.sendKeys(password);
		loginButton.click();
	}



	public String getLoginSuccess() {
		try
		{
			userErrorMessage.isDisplayed();
			String str=userErrorMessage.getText();
			return str;
			}
		catch(Exception e)
		{
			
		return null;	
		}
		
	}


	public String getLoginSuccess1() {
		try
		{
			passwordErrorMessage.isDisplayed();
			String str=passwordErrorMessage.getText();
			return str;
			}
		catch(Exception e)
		{
			
		return null;	
		}
	}
	public String getLoginSuccess2() {
		try
		{
			invalidUserName.isDisplayed();
			String str=invalidUserName.getText();
			return str;
			}
		catch(Exception e)
		{
			
		return null;	
		}
	}
	public String getLoginSuccess3() {
		try
		{
			invalidPassword.isDisplayed();
			String str=invalidPassword.getText();
			return str;
			}
		catch(Exception e)
		{
			
		return null;	
		}
	}


	public String getLoginSuccess4() {
		try
		{
			String str=driver.getTitle();
			return str;
		}
		
		catch(Exception e)
		{
			
		return null;	
		}
		
	}
}
