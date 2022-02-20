package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ordersummerypage extends pagebase {

	public ordersummerypage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css="h3.page-subheading")
	public WebElement ordersummerybank;

	@FindBy(css="button.button.btn.btn-default.button-medium")
	WebElement confirmorder;

	@FindBy(css="p.cheque-indent")
	public WebElement ordercomplete;

	@FindBy(css="a.button-exclusive.btn.btn-default")
	WebElement back2order;

	@FindBy(css="td.history_state.footable-last-column")
	public WebElement backorder;

	@FindBy(css="div.box")
	public WebElement box;

	@FindBy(id="order-list")
	public WebElement orderstable; 

	@FindBy(css="td.history_link.bold.footable-first-column")
	public WebElement firstcell;




	public void confirmorderfun() {
		btnclick(confirmorder);
	}

	public void backtoorder() {
		btnclick(back2order);
	}

	public void getorderref() {

		System.out.println(firstcell.getText());

	}}
