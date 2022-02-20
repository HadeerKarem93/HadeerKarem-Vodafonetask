package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class signinpage extends pagebase{

	public signinpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="email")
	WebElement emailcreate;
	
	@FindBy(id="passwd")
	WebElement pass;
	
	@FindBy(id="SubmitLogin")
	WebElement sumbitlogin;
	
	public void sidninfun() {
		keyssent(emailcreate,"hadeer@test3.com");
		keyssent(pass,"hadeerdody");
		btnclick(sumbitlogin);
	}

}
