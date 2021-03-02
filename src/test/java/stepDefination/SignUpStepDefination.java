package stepDefination;

import java.util.List;

import org.junit.Assert;

//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.SignUpPage;
import testCommon.TestBase;

public class SignUpStepDefination extends TestBase{

	HomePage homePage;
	SignUpPage signUpPage;
	@Given("^User is on homepage$")
	public void user_is_on_homepage() throws Throwable {
		homePage = new HomePage();
		Assert.assertTrue("User is not on HomePage",homePage.validateLogo());
	}

	@When("^User clicks on SignToNewsLetter$")
	public void user_clicks_on_SignToNewsLetter() throws Throwable {
		homePage.clickSignUpLink();
	}


	@When("^User enters all the details$")
	public void user_enters_all_the_details(DataTable args) throws Throwable {
		List<List<String>> data = args.asLists(String.class);
		signUpPage = new SignUpPage();
		signUpPage.enterSignUpDetails(data.get(1).get(1), data.get(2).get(1), data.get(3).get(1),
				data.get(4).get(1), data.get(5).get(1), data.get(6).get(1));

	}

	@When("^User clicks Signup$")
	public void user_clicks_Signup() throws Throwable {
		signUpPage.clickSignUp();
	}


	@Then("^User is Signed up successfully$")
	public void user_is_Signed_up_successfully() throws Throwable {
		Assert.assertTrue("User is not Signed up", signUpPage.validateSuccessMessage());
	}



}

