package monet.guice;

import com.google.inject.Provider;
import org.openqa.selenium.WebDriver;

@ScenarioScoped
public class WebDriverProvider implements Provider<WebDriver> {

    private WebDriver webDriver;

    public WebDriver get() {
        return this.webDriver;
    }

    public void set(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
