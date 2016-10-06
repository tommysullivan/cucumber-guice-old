package monet.steps;

import com.google.inject.Inject;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class WebDriverSteps {
	
	private final WebDriver webDriver;

//    public WebDriverSteps() {
//        this(new ChromeDriver());
//    }

	@Inject
	public WebDriverSteps(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	@Given("^I am running Firefox WebDriver$")
	public void I_am_running_Firefox_WebDriver() {
		webDriver.navigate().to("http://example.com");
	}

}