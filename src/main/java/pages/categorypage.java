package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class categorypage extends pagebase{

	public categorypage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css="a.button.ajax_add_to_cart_button.btn.btn-default")
	public WebElement addtocart;
	
	@FindBy(css="span.price.product-price")
	public WebElement price;
	
	@FindBy(css="div.layer_cart_product.col-xs-12.col-md-6")
	public WebElement productaddedmsg;
	
	@FindBy(id="layer_cart_product_price")
	public WebElement total;
	
	@FindBy(css="a.btn.btn-default.button.button-medium")
	WebElement checkoutbtn;
	
	@FindBy (className="product-container")
	WebElement container;
	
	public void addproduct(WebDriver driver3) {
		Actions actions = new Actions(driver3);
		actions.moveToElement(container).build().perform();
		WebDriverWait wait2 = new WebDriverWait(driver3,10);
		wait2.until(ExpectedConditions.visibilityOf(addtocart));
		actions.click(addtocart).build().perform();

	}
	
	public void proceedcheckout() {
		
		btnclick(checkoutbtn);
	}
}
