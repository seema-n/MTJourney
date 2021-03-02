package stepDefination;


import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import testCommon.TestBase;

public class CommonStepDefination extends TestBase{

	public void scrollToView(WebElement locatorKey) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", locatorKey);
			js.executeScript("window.scrollBy(0,-250)", "");
		} catch (AssertionError e) {
			Assert.fail(e.getMessage());
		}
	} 
	
	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
}
