package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class paymentpage extends pagebase {
	
	public paymentpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="h1.page-heading")
	public WebElement payment;
	
	@FindBy(css="a.bankwire")
	WebElement bankwire;
	
	public void bankwireprocess() {
		btnclick(bankwire);
	}
}
