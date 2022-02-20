package vodafonetask;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.Authenticatenewuser;
import pages.accountpage;
import pages.homepage;

public class createandauthenticateanewuser extends testbase {
	homepage homeobject;
	accountpage accountpageobject;
	Authenticatenewuser authenticateobject;
	String URL;
	SoftAssert softassert;
	WebDriverWait wait;

	@Test(priority=0,dataProvider="createanewaccount")
	public void createnewuser(String emailaddres) throws InterruptedException   {
		homeobject = new homepage(driver);
		accountpageobject = new accountpage(driver);
		authenticateobject= new Authenticatenewuser(driver);
		homeobject.signinbtnclick();
		accountpageobject.sendanemail(emailaddres);
	    wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.or(
			    ExpectedConditions.visibilityOf(accountpageobject.notbox),
			    ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation")));
	    URL = driver.getCurrentUrl();
		softassert = new SoftAssert();
		if(URL.endsWith("#account-creation")) {
		softassert.assertEquals(URL, "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		System.out.println("test case passed");}
		else {	
			softassert.assertEquals(accountpageobject.notbox.getText(), "Invalid email address.", "You entered preregister email or test passed");
		softassert.assertEquals(accountpageobject.notbox.getText(), "An account using this email address has already been registered. Please enter a valid password or request a new one. ", "You entered invalid email format or test passed");}
		softassert.assertAll();
		
	}

	@Test(dataProvider="authenticate new user",priority=1)
	public void authenticatenewuser(String fname,String lname,String emailaddress,String pass,String myday,String mymonth,String myyear,String myfirstname,String mylastname,String companyname,String addressname,String cityname,String mystate,String postcodenum,String mycountry,String mobile,String aliasn) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		authenticateobject.Authenticate(fname,lname,emailaddress,pass, myday, mymonth, myyear, myfirstname,mylastname,companyname,addressname,cityname,mystate,postcodenum,mycountry,mobile, aliasn);
		wait.until(ExpectedConditions.or(
			    ExpectedConditions.visibilityOf(authenticateobject.erralert),
			    ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=my-account")));
	  URL = driver.getCurrentUrl();
	  if(URL.endsWith("controller=my-account")) {
	 softassert.assertEquals(URL, "http://automationpractice.com/index.php?controller=my-account");
	  } 
	  else {
		
		  System.out.println("Test case failed and reasons are "+authenticateobject.erralert.getText());
		  
	  }

	}
	//Read the Data from the excel sheet
	@DataProvider(name = "createanewaccount")
	public  Object[][] getdata() {
		String projectpath=	System.getProperty("user.dir");
		String excelpath = "/excel/Vodafonetest.xlsx";
		String sheetname = "Sheet1";
		Object data[][]=testdata(excelpath , sheetname);
		return data;
	}
	@DataProvider(name = "authenticate new user")
	public  Object[][] getdata1() {
		String projectpath=	System.getProperty("user.dir");
		String excelpath = "/excel/Vodafonetest.xlsx";
		String sheetname = "Sheet2";
		Object data[][]=testdata(excelpath , sheetname);
		return data;
	}


	//Create an object array with the size of data to read the data from the all rows we added 
	public Object[][] testdata(String excelpath , String sheetname) {

		xsldat dat = new xsldat(excelpath , sheetname);
		int colcount = dat.getcolcount();
		int rowcount=	dat.getrowcount();

		Object data[][] = new Object[rowcount-1][colcount];

		for (int i=1 ; i<rowcount ;i++) {
			for (int j=0 ; j<colcount ; j++) {
				String celldata1 =	dat.getcelldata(i, j);
				data[i-1][j] = celldata1;
			}
		}
		return data;
	}
}