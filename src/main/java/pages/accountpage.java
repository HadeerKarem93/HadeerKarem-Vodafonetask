package pages;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class accountpage extends pagebase {
	public accountpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "email_create")
	WebElement emailtextbox ;

	@FindBy(id="SubmitCreate")
	WebElement createbtn ;

	@FindBy(id="create_account_error")
	public WebElement notbox;

	public void sendanemail(String emailaddress) throws InterruptedException {
		btnclick(emailtextbox);
		keyssent(emailtextbox , emailaddress);
		btnclick(createbtn);
		Thread.sleep(3000);

	}
	
	
		
	}
	