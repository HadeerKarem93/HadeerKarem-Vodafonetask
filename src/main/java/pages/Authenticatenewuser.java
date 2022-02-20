package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Authenticatenewuser extends pagebase{

	public Authenticatenewuser(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="id_gender2")
	public WebElement title;
	
	@FindBy(id="customer_firstname")
	WebElement firstname;
	
	@FindBy(id="customer_lastname")
	WebElement lastname;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="days")
	WebElement day;
	
	@FindBy(id="months")
	WebElement month;
	
	@FindBy(id="years")
	WebElement year;
	
	@FindBy(id="firstname")
	WebElement firstname1;
	
	@FindBy(id="lastname")
	WebElement lastname1;
	
	@FindBy(id="company")
	WebElement company;
	
	@FindBy(id="address1")
	WebElement address;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement state;
	
	@FindBy(id="postcode")
	WebElement postcode;
	
	@FindBy(id="id_country")
	WebElement country;
	
	@FindBy(id="phone_mobile")
	WebElement phone;
	
	@FindBy(id="alias")
	WebElement alias;
	
	@FindBy(id="submitAccount")
	public WebElement register;
	
	@FindBy(css="div.alert.alert-danger")
	public WebElement erralert;
	
	public void Authenticate(String fname,String lname,String emailaddress,String pass,String myday,String mymonth,String myyear,String myfirstname,String mylastname,String companyname,String addressname,String cityname,String mystate,String postcodenum,String mycountry,String mobile,String aliasn) {
		btnclick(title);
		deletedata(firstname);
		keyssent(firstname,fname);
		deletedata(lastname);
		keyssent(lastname,lname);
		deletedata(email);
		keyssent(email,emailaddress);
		deletedata(password);
		keyssent(password,pass);
		selectinreg(day,myday);
		selectinreg(month,mymonth);
		selectinreg(year,myyear);
		deletedata(firstname1);
		keyssent(firstname1,myfirstname);
		deletedata(lastname1);
		keyssent(lastname1,mylastname);
		deletedata(company);
		keyssent(company,companyname);
		deletedata(address);
		keyssent(address,addressname);
		deletedata(city);
		keyssent(city,cityname);
		selectinreg(state,mystate);
		deletedata(postcode);
		keyssent(postcode,postcodenum);
		selectinreg(country,mycountry);
		deletedata(phone);
		keyssent(phone,mobile);
		deletedata(alias);
		keyssent(alias,aliasn);
		btnclick(register);

		
	}

}
