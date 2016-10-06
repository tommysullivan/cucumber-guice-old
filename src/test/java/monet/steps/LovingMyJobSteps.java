package monet.steps;

import com.google.inject.Inject;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class LovingMyJobSteps {

	private final WebDriver webDriver;

	@Inject
	public LovingMyJobSteps(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	@Given("^I love my job$")
	public void I_am_running_Firefox_WebDriver() {
		webDriver.navigate().to("http://cnn.com");
	}

}