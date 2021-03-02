package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import stepDefination.CommonStepDefination;
import testCommon.TestBase;

public class OtherPages extends TestBase {
	public OtherPages() {
		PageFactory.initElements(getDriver(), this);
	}
	CommonStepDefination common = new CommonStepDefination();
	
	@FindBy(xpath=".//*[@class='product_preview_hero_link flex shadow-03 flex-column flex-nowrap']")
	List<WebElement> listOfAttractions;

	@FindBy(id="iterator_1_product_custom_product-name")
	WebElement firstAttractionName;
	
	@FindBy(id="product-title")
	WebElement productTitle;
	
	@FindBy(id="hero-image")
	WebElement heroImage;
	
	@FindBy(id="price-pin_days-num-01")
	WebElement numberOfDays;
	
	@FindBy(id="price-pin_cc_newmarket")
	WebElement price;
	
	@FindBy(id="supplier-phone")
	WebElement supplierPhone;
	
	@FindBy(id="itinerary_title_tab")
	WebElement itinerary_title_tab;
	
	@FindBy(id="itinerary_title")
	WebElement itinerary_title;
	
	@FindBy(id="itin_iter_1_noday-button-nosub")
	WebElement firstDay;
	
	@FindBy(xpath=".//li[contains(@class, 'nbf_tpl_pagesection_vertical_norwd nbf_tpl_it itinerary-day-container')]")
	List<WebElement> listOfDays;
	
	@FindBy(id="book-button-header")
	WebElement bookOnline;
	
	@FindBy(xpath=".//*[@class='nbf_tpl_pms_calendar_day_available nbf_tpl_pms_calendar_box nbf_pms_tpl_calendar_selecteddate']")
	WebElement firstAvailableDate;
	
	@FindBy(xpath=".//*[@class='nbf_tpl_pms_calendar_day_available nbf_tpl_pms_calendar_box nbf_pms_tpl_calendar_selecteddate']/div[2]")
	WebElement priceOnDate;
	
	@FindBy(xpath=".//*[@class='nbf_button nbf_tpl_pms_book_button']")
	WebElement continueBookingButton;
	
	@FindBy(xpath=".//h2[@class='nbf_tpl_pms_bf_transport_title']")
	WebElement transportTab;
	
	@FindBy(xpath=".//h2[contains(text(),'Accommodation')]")
	WebElement accommodationTab;
	
	@FindBy(xpath=".//h2[contains(text(),'Passenger Details')]")
	WebElement passengerTab;
	
	@FindBy(id="room-0-numselect")
	WebElement roomDropbox;
	
	@FindBy(xpath=".//*[@class='nbf_button nbf_tpl_pms_button']")
	WebElement roomContinueButton;
	
	@FindBy(id="pax-a-title-1")
	WebElement p_title;
	@FindBy(id="pax-a-first-1")
	WebElement p_fn;
	@FindBy(id="pax-a-last-1")
	WebElement p_ln;
	@FindBy(id="pax-a-dobd-1")
	WebElement p_day;
	@FindBy(id="pax-a-dobm-1")
	WebElement p_month;
	@FindBy(id="pax-a-doby-1")
	WebElement p_year;
	
	@FindBy(id="pax-a-title-2")
	WebElement p2_title;
	@FindBy(id="pax-a-first-2")
	WebElement p2_fn;
	@FindBy(id="pax-a-last-2")
	WebElement p2_ln;
	@FindBy(id="pax-a-dobd-2")
	WebElement p2_day;
	@FindBy(id="pax-a-dobm-2")
	WebElement p2_month;
	@FindBy(id="pax-a-doby-2")
	WebElement p2_year;
	
	@FindBy(id="contact-mobile")
	WebElement p_mobile;
	@FindBy(id="contact-email")
	WebElement p_email;
	@FindBy(id="contact-address1")
	WebElement p_address1;
	@FindBy(id="contact-address2")
	WebElement p_address2;
	@FindBy(id="contact-city")
	WebElement p_city;
	@FindBy(id="contact-postcode")
	WebElement p_postcode;
	
	@FindBy(xpath=".//button[@class='nbf_button nbf_tpl_pms_button']")
	WebElement p_continue_button;
	
	@FindBy(xpath=".//p[contains(text(),'Payment Details')]")
	WebElement paymentDetailInfo;
	
	public int validateListOFAttractions() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		return listOfAttractions.size();
	}
	
	public boolean isFirstAttractionDisplayed() {
		 return listOfAttractions.get(0).isDisplayed();
	}
	public void clickFirstAttraction() throws Exception {
		common.scrollToView(listOfAttractions.get(0));
		listOfAttractions.get(0).click();
	}
	public String getFirstAttractionName(){
		return firstAttractionName.getText();
	}
	public String getProductTitle() {
		return productTitle.getText();
	}
	
	public boolean isAttractionDetailPageImage(){
		return heroImage.isDisplayed();
	}
	
	public boolean isDaysDisplayed(){
		return numberOfDays.isDisplayed();
	}

	public boolean isPriceDisplayed(){
		return price.isDisplayed();
	}
	
	public boolean isSupplierPhoneDisplayed(){
		return supplierPhone.isDisplayed();
	}
	
	public void clickItinerayTab() throws Exception {
		common.scrollToView(itinerary_title_tab);
		itinerary_title_tab.click();
	}

	public boolean isItineraryTitleDisplayed(){
		return itinerary_title.isDisplayed();
	}
	
	public int validateListOFDays() {
		return listOfDays.size();
	}
	
	public boolean clickAllDaysInList_and_assertTextIsDisplayed() throws Exception {
		boolean flag=true;
		Thread.sleep(2000);
		firstDay.click();
		//getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
		for(WebElement ele: listOfDays) {
			common.scrollToView(ele);		
			ele.click();
			WebElement e =  ele.findElement(By.xpath(".//*[@class='nbf_tpl_text day-text']"));
			String text =e.getText();
			getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Assert.assertTrue("Day of the itinery has no test data", !text.isEmpty());
			if(text.isEmpty())
				flag=false;
		}
		return flag;
	}
	
	public void clickBookOnline() throws Exception {
		common.scrollToView(bookOnline);
		bookOnline.click();
	}
	
	public boolean pickFirstAvailableDate() {
		return firstAvailableDate.isDisplayed();
	}
	
	public String displayPriceOnDate() throws Exception {
		common.scrollToView(priceOnDate);
		return priceOnDate.getText();
	}
	
	public void clickContinueBookingButton() throws Exception {
		Thread.sleep(1000);
		common.scrollToView(continueBookingButton);
		continueBookingButton.click();
	}
	
	public void clickOnTransportTab() {
		transportTab.click();
	}
	
	public boolean isAccommodationTabDisplayed() throws InterruptedException {
		Thread.sleep(2000);
		return accommodationTab.isDisplayed();
	}
	
	public void selectRoomDropBox(int number){
	     Select s=new Select(roomDropbox);
	     s.selectByIndex(number);
	  }
	
	public void clickRoomContinueButton() {
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		roomContinueButton.click();
	}
	
	public boolean isPassengerDetailTabDisplayed() {
		return passengerTab.isDisplayed();
	}

	public void enter_person_adult1_details(String title, String fn, String ln, String day, String month, String year) throws InterruptedException {
		Thread.sleep(3000);
		Select t = new Select(p_title);
		t.selectByValue(title); 
		p_fn.sendKeys(fn);
		p_ln.sendKeys(ln);
		Select d = new Select(p_day);
		d.selectByValue(day); 
		Select m = new Select(p_month);
		m.selectByVisibleText(month); 
		Select y = new Select(p_year);
		y.selectByValue(year); 
	}

	public void enter_person_adult2_details(String title, String fn, String ln, String day, String month, String year) throws InterruptedException {
		Thread.sleep(4000);
		Select t = new Select(p2_title);
		t.selectByValue(title); 
		p2_fn.sendKeys(fn);
		p2_ln.sendKeys(ln);
		Select d = new Select(p2_day);
		d.selectByValue(day); 
		Select m = new Select(p2_month);
		m.selectByVisibleText(month); 
		Select y = new Select(p2_year);
		y.selectByValue(year);
	}

	public void enter_lead_contact_details(String mobilenumber, String email, String address1, String address2,
			String city, String postcode) {
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		p_mobile.sendKeys(mobilenumber);
		p_email.sendKeys(email);
		p_address1.sendKeys(address1);
		p_address2.sendKeys(address2);
		p_city.sendKeys(city);
		p_postcode.sendKeys(postcode);
	}

	public void clickContinue() throws Exception {
		common.scrollToView(p_continue_button);
		p_continue_button.click();
	}
	
	public boolean isPaymentDetailInfoDisplayed() {
		return paymentDetailInfo.isDisplayed();
	}
}
