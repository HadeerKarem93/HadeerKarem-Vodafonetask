package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addresspage extends pagebase {

	public addresspage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="address_invoice")
	public WebElement addressinvoice;
	
	@FindBy(id="address_delivery")
	public WebElement addressdelivery;
	
	@FindBy(css="button.button.btn.btn-default.button-medium")
	WebElement processaddress;
	
	public void processaddressfun() {
		btnclick(processaddress);
	}
}

