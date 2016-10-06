package test.java.guice;

import com.google.inject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MonetGuiceModule implements Module {

	public void configure(Binder binder) {
		binder.bind(WebDriver.class)
				.toProvider(WebDriverProvider.class);
	}

	@Provides
	WebDriverWait getWebDriverWait(WebDriver driver) {
		return new WebDriverWait(driver, 15);
	}

}
