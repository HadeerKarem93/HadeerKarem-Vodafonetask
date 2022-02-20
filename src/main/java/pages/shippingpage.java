package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class shippingpage extends pagebase{

	public shippingpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="h1.page-heading")
	public WebElement shipping;
	
	@FindBy(css="button.button.btn.btn-default.standard-checkout.button-medium")
	WebElement processcarrier;
	
	@FindBy(css="p.fancybox-error")
	public WebElement fancyboxerror;
	
	@FindBy(css="a.fancybox-item.fancybox-close")
	WebElement close;
	
	@FindBy(id="cgv")
	WebElement checkbox;

	public void processcarrierfun() {
		btnclick(processcarrier);
	}
	
	public void closeerror() {
		btnclick(close);
	}
	
	public void termsagree() {
		btnclick(checkbox);
	}
}
