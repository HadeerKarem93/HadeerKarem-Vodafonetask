package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homepage extends pagebase {
	public homepage(WebDriver driver) {
		super(driver);
	}
	@FindBy(className = "login")
	 WebElement loginbtn ;
	
	
	
	@FindBy(className="sf-with-ul")
	WebElement women;
	
	@FindBy(xpath="/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/ul/li[1]/ul/li[2]/a")
	WebElement blouses;
	
	@FindBy(css="span.cat-name")
	public WebElement catname;
	
	public void signinbtnclick() {
		btnclick(loginbtn);
		
	}
	
	public void blouseselect(WebDriver driver2)  {
		Actions actions = new Actions(driver2);
		actions.moveToElement(women).build().perform();
		WebDriverWait wait = new WebDriverWait(driver2,10);
		wait.until(ExpectedConditions.visibilityOf(blouses));
		actions.click(blouses).build().perform();
	}
}
