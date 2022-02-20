package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkoutpage extends pagebase {

	public Checkoutpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="cart_title")
	public WebElement carttitle;
	
	@FindBy(css="a.button.btn.btn-default.standard-checkout.button-medium")
	WebElement proceedtocheckout;
	
	public void proceedtocheckoutfun() {
		btnclick(proceedtocheckout);
	}
	

}
