package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class pagebase {

	protected WebDriver drivers;
	public pagebase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	protected static void btnclick(WebElement button) {
		button.click();
		
	}
	protected static void keyssent(WebElement txtinput ,String value) {
		txtinput.sendKeys(value);
	}
	
	protected static void selectinreg(WebElement dayn,String daten) {
		Select day1=new Select(dayn);
		day1.selectByValue(daten);

	}
	
	protected static void deletedata(WebElement but) {
		but.sendKeys(Keys.COMMAND + "a");
		but.sendKeys(Keys.BACK_SPACE);
	}
	
	
	}



