package test.java.guice;

import com.google.inject.Provider;
import com.google.inject.Singleton;
import org.openqa.selenium.WebDriver;

@Singleton
public class WebDriverProvider implements Provider<WebDriver> {

    private WebDriver webDriver;

    public WebDriver get() {
        return this.webDriver;
    }

    public void set(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
