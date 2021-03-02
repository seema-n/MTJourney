package stepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.OtherPages;
import testCommon.TestBase;

public class EndToEndStepDefination extends TestBase{

	HomePage homePage;
	OtherPages otherPages;
	String firstName;
	
	@Given("^user is on mail travel homepage$")
	public void user_is_on_mail_travel_homepage() throws Throwable {
		homePage = new HomePage();
		Assert.assertTrue("User is not on HomePage",homePage.validateLogo());
	}

	@When("^user searches for \"([^\"]*)\" as holiday destination$")
	public void user_searches_for_as_holiday_destination(String country) throws Throwable {
		homePage.enter_value_in_SerachTexField(country);
	}

	@When("^clicks on search button")
	public void clicks_on_search_button() throws Throwable {
		homePage.clickSerachButton();
	}

	@Then("^list of attractions are displayed$")
	public void list_of_attractions_are_displayed() throws Throwable {
		otherPages = new OtherPages();
		Assert.assertTrue("No List of Attraction present",otherPages.validateListOFAttractions() > 0);
	}

	@When("^user clicks on first attraction$")
	public void user_clicks_on_first_attraction() throws Throwable {
		firstName = otherPages.getFirstAttractionName();
		otherPages.clickFirstAttraction();	
	}

	@Then("^user is navigated to attraction detail page$")
	public void user_is_navigated_to_attraction_detail_page() throws Throwable {
		String titleName = otherPages.getProductTitle();
		Assert.assertEquals("Title of the attraction is not same as expected title",titleName, firstName);
	}
	
	@Then("^number of days, price and telephone number is displayed$")
	public void number_of_days_price_and_telephone_number_is_displayed() throws Throwable {
		Assert.assertTrue("Days are not displayed",otherPages.isDaysDisplayed());
		Assert.assertTrue("Price is not displayed",otherPages.isPriceDisplayed());
		Assert.assertTrue("Supplier Phone is not displayed", otherPages.isSupplierPhoneDisplayed());
	}
	
	@Given("^user is on attraction detail page$")
	public void user_is_on_attraction_detail_page() throws Throwable {
		otherPages = new OtherPages();
		Assert.assertTrue("User is not on attraction details page",otherPages.isAttractionDetailPageImage());
	}
	
	@When("^user clicks on Itinerary$")
	public void user_clicks_on_Itinerary() throws Throwable {
	    otherPages.clickItinerayTab();
	}

	@Then("^list of itinerary is displayed$")
	public void list_of_itinerary_is_displayed() throws Throwable {
		Assert.assertTrue("Itinerary Title is not displayed", otherPages.isItineraryTitleDisplayed());
		Assert.assertTrue("List of days in Iternary is not displayed",otherPages.validateListOFDays()>0);
		System.out.println("list of itinerary is displayed");
	}

	@Then("^each day in itinerary has a some valid content$")
	public void each_day_in_itinerary_has_a_some_valid_content() throws Throwable {
		boolean result = otherPages.clickAllDaysInList_and_assertTextIsDisplayed();
		Assert.assertTrue("Itinerary is not displaying text data",result);
	}
	
	@When("^user clicks on book online$")
	public void user_clicks_on_book_online() throws Throwable {
		otherPages.clickBookOnline();
	}

	@Then("^the first available date is selected with default price and user clicks continue$")
	public void the_first_available_date_is_selected_with_default_price_and_user_clicks_continue() throws Throwable {
		otherPages = new OtherPages();
		Assert.assertTrue("First valid date on Calender is not displayed",otherPages.pickFirstAvailableDate());
		String price = otherPages.displayPriceOnDate();
		Assert.assertTrue("Price on date is not present",!price.isEmpty());
		
		otherPages.clickContinueBookingButton();
	}

	@Then("^user is verifies start and end date on transport tab$")
	public void user_is_verifies_start_and_end_date_on_transport_tab() throws Throwable {
		//TODO: start day and end date	
	}

	@Given("^user is on Accommodation section$")
	public void user_is_on_Accommodation_section() throws Throwable {
		otherPages = new OtherPages();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertTrue("Accommodation section is not displayed",otherPages.isAccommodationTabDisplayed());;
	}

	@When("^user makes a room selection$")
	public void user_makes_a_room_selection() throws Throwable {
		otherPages.selectRoomDropBox(1);
		otherPages.clickRoomContinueButton();
	}

	@When("^selects default value under Extras section$")
	public void selects_default_value_under_Extras_section() throws Throwable {
		otherPages.clickRoomContinueButton();
	}

	@Given("^passendgers detail secion is displayed$")
	public void passendgers_detail_secion_is_displayed() throws Throwable {
		otherPages = new OtherPages();
		Assert.assertTrue("PassengerDetail section is not displayed",otherPages.isPassengerDetailTabDisplayed());;
	}

	@When("^user enters adult_one details$")
	public void user_enters_adult_one_details(DataTable arg1) throws Throwable {
//		List<List<String>> data = arg1.raw();	 
		
		List<List<String>> data = arg1.asLists(String.class);
	    
//	    for (List<String> columns : rows) {
//	        store.addBook(new Book(columns.get(0), columns.get(1)));
//	    }
		otherPages.enter_person_adult1_details(data.get(0).get(0),data.get(0).get(1),
				data.get(0).get(2),data.get(0).get(3),data.get(0).get(4),data.get(0).get(5));
	}
	
	@When("^user enters adult_two details$")
	public void user_enters_adult_two_details(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.asLists(String.class);
		otherPages.enter_person_adult2_details(data.get(0).get(0),data.get(0).get(1),
				data.get(0).get(2),data.get(0).get(3),data.get(0).get(4),data.get(0).get(5));
	}

	@When("^user enters lead contact details$")
	public void user_enters_lead_contact_details(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.asLists(String.class);
		Thread.sleep(3000);
		otherPages.enter_lead_contact_details(data.get(0).get(0),data.get(0).get(1),
				data.get(0).get(2),data.get(0).get(3),data.get(0).get(4),data.get(0).get(5));
		otherPages.clickContinue();
	}

	@Then("^payment detail page is displayed$")
	public void payment_detail_page_is_displayed() {
		Assert.assertTrue("User is not on Payment detail page",otherPages.isPaymentDetailInfoDisplayed());
	}

}
