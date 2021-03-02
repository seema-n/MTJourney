package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCommon.TestBase;

public class HomePage extends TestBase{

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(id="reassurance-bar-iter_4_top-bar-text")
	WebElement signUpLink;
	@FindBy(id="site-logo")
	WebElement logo;
	@FindBy(id="searchtext_freetext_search_form")
	WebElement serachTexField;
	@FindBy(xpath=".//*[@id='freetext_search_form']//button")
	WebElement serachButton;
	
	public void clickSignUpLink() {
		signUpLink.click();
	}
	
	public boolean validateLogo() {
		System.out.println(logo.isDisplayed());
		return logo.isDisplayed();
	}
	
	public void enter_value_in_SerachTexField(String value) {
		serachTexField.sendKeys(value);
	}
	public void clickSerachButton() {
		
		serachButton.click();
	}
	
	
	
	
}
