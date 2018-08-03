package Src_Testcase_Java;
import java.io.IOException;
import jxl.read.biff.BiffException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.test.automation.cholafms.Testbase.testBase;
import com.test.automation.cholafms.dataexcel.excelData;
import com.test.automation.cholafms.uiActions.Login;


public class TC_001_VerifyLogin extends testBase{
	Login loginObject;
	excelData excelDataObject;
	int i=0;
	
	@DataProvider (name="TestData")
	public Object[][] excelData() throws BiffException, IOException
	{
		excelDataObject=new excelData();
		Object[][] input=excelDataObject.getExcelData();
		return input;
		
	}
	@BeforeClass
	public void launchBrowser() throws Exception
	{
		init();
		
	}
	
	@Test (dataProvider="TestData")
	public void verifyLogin(String Username,String Password) throws Exception 
	{
		loginObject=new Login(driver);
		loginObject.loginToApplication(Username, Password);
		
		
			if (i==0)
			{
				
				Assert.assertEquals("Username is required.", loginObject.getLoginSuccess());
				
		      }
			
			else if(i==1)
			{
				Assert.assertEquals("Password is required.", loginObject.getLoginSuccess1());
				
			}
			
			else if(i==2)
			{
				Assert.assertEquals("Not a valid login!Unauthorized user", loginObject.getLoginSuccess2());
				
				
			}
			else if(i==3)
			{
				Assert.assertEquals("Password is wrong",loginObject.getLoginSuccess3());
				
				
			}
			
			else if(i==4)
			{
				
				Assert.assertEquals("FMS - Dashboard|General",loginObject.getLoginSuccess4());
				
			}
			i++;
		
	
	}
	
	
@AfterClass
public void closeBrowser()
{
	driver.close();
}
}
