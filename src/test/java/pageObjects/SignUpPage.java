package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testCommon.TestBase;

public class SignUpPage extends TestBase{
	public SignUpPage() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(xpath=".//*[@name='vars[title]']")
	WebElement title_dropdown;
	@FindBy(xpath=".//*[@placeholder='First Name']")
	WebElement firstName;
	@FindBy(xpath=".//*[@placeholder='Last Name']")
	WebElement lastName;
	@FindBy(xpath=".//*[@name='email']")
	WebElement email;
	@FindBy(xpath=".//*[@placeholder='Postcode']")
	WebElement postCode;
	@FindBy(xpath=".//*[@placeholder='Phone Number (optional)']")
	WebElement phoneNumber;
	@FindBy(id="agree")
	WebElement agree_checkbox;
	@FindBy(id="sign-up")
	WebElement signUp_button;
	@FindBy(xpath=".//*[contains(text(),'Thanks for signing up!')]")
	WebElement successMessage;
	
	public void enterSignUpDetails(String title_value, String fn, String ln, String email_value,String postcode, String phoneNum) {
		Select title = new Select(title_dropdown);
		title.selectByValue(title_value); 
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		email.sendKeys(email_value);
		postCode.sendKeys(postcode);
		phoneNumber.sendKeys(phoneNum);
	}
	
	public void clickSignUp() {
		agree_checkbox.click();
		signUp_button.click();
	}
	
	public boolean validateSuccessMessage() {
		return successMessage.isDisplayed();
	}
}
