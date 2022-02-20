package vodafonetask;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.Checkoutpage;
import pages.addresspage;
import pages.categorypage;
import pages.homepage;
import pages.ordersummerypage;
import pages.paymentpage;
import pages.shippingpage;
import pages.signinpage;

public class selectblousesandcheckout extends testbase {
	
	homepage homeobject;
	categorypage categorypageobject;
	Checkoutpage checkoutpageobject;
	addresspage addresspageobject;
	shippingpage shippingpageobject;
	paymentpage paymentpageobject;
	ordersummerypage ordersummerypagobject;
	WebDriverWait wait;
	SoftAssert softassert;
	signinpage signinpageobject;
	String boxcontent;
	
	@Test(priority=2)
public void blousesubcategory() {
	homeobject = new homepage(driver);
	categorypageobject = new categorypage(driver);
    homeobject.blouseselect(driver);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    Assert.assertEquals(homeobject.catname.getText().strip(), "BLOUSES" );

    
    
}
	@Test(priority=3)
	public void add2cart() {

		categorypageobject.addproduct(driver);
		softassert = new SoftAssert();
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(categorypageobject.productaddedmsg));
		Assert.assertTrue(categorypageobject.productaddedmsg.getText().contains("Product successfully added to your shopping cart"));
		softassert.assertEquals(categorypageobject.price.getText().strip(), categorypageobject.total.getText().strip());
	} 
	@Test(priority=4)
	public void checkoutprocrss() {
		checkoutpageobject = new Checkoutpage(driver);
		categorypageobject.proceedcheckout();
		wait.until(ExpectedConditions.visibilityOf(checkoutpageobject.carttitle));
		Assert.assertTrue(checkoutpageobject.carttitle.getText().contains("SHOPPING-CART SUMMARY"));
		checkoutpageobject.proceedtocheckoutfun();
	}
	
	//enable it only if we run this class without the first one 
/*	@Test(priority=3)
	public void signinfromcart() {
		signinpageobject = new signinpage(driver);
		signinpageobject.sidninfun();
	}*/
	
	@Test(priority=5)
	public void processaddressfunction() {
		addresspageobject = new addresspage(driver);
		wait.until(ExpectedConditions.visibilityOf(addresspageobject.addressdelivery));
		Assert.assertTrue(addresspageobject.addressinvoice.isDisplayed());
		addresspageobject.processaddressfun();
	}
	
	
	
	@Test(priority=6)
	public void processonshipping() {
		shippingpageobject = new shippingpage(driver);
		wait.until(ExpectedConditions.visibilityOf(shippingpageobject.shipping));
		Assert.assertTrue(shippingpageobject.shipping.getText().contains("SHIPPING"));
		shippingpageobject.processcarrierfun();
		wait.until(ExpectedConditions.visibilityOf(shippingpageobject.fancyboxerror));
			Assert.assertTrue(shippingpageobject.fancyboxerror.getText().contains("You must agree to the terms of service before continuing."));
		shippingpageobject.closeerror();
		shippingpageobject.termsagree();
		shippingpageobject.processcarrierfun();
	}
	
	@Test(priority=7)
	public void processbybankwire() {
		paymentpageobject = new paymentpage(driver);
		wait.until(ExpectedConditions.visibilityOf(paymentpageobject.payment));
		Assert.assertTrue(paymentpageobject.payment.getText().contains("PLEASE CHOOSE YOUR PAYMENT METHOD"));
		paymentpageobject.bankwireprocess();
	}
	@Test(priority=8)
	public void confirmmyorder() {
		ordersummerypagobject = new ordersummerypage(driver);
		wait.until(ExpectedConditions.visibilityOf(ordersummerypagobject.ordersummerybank));
		Assert.assertTrue(ordersummerypagobject.ordersummerybank.getText().contains("BANK-WIRE PAYMENT."));
		ordersummerypagobject.confirmorderfun();
		wait.until(ExpectedConditions.visibilityOf(ordersummerypagobject.ordercomplete));
		Assert.assertTrue(ordersummerypagobject.ordercomplete.getText().contains("Your order on My Store is complete."));
		 boxcontent = ordersummerypagobject.box.getText();
	}
	@Test(priority=9)
	public void validateorder() {
		ordersummerypagobject.backtoorder();
		wait.until(ExpectedConditions.visibilityOf(ordersummerypagobject.firstcell));
		ordersummerypagobject.getorderref();
		Assert.assertTrue(boxcontent.contains(ordersummerypagobject.firstcell.getText()));
	}
	

}
