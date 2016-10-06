package cucumber;

import com.google.inject.Inject;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import guice.WebDriverProvider;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;

public class Hooks {

    private final WebDriverProvider webDriverProvider;
//    private boolean sauceLabRun;

    public Hooks() {
        this(new WebDriverProvider());
    }

    @Inject
    public Hooks(WebDriverProvider webDriverProvider) {
        this.webDriverProvider = webDriverProvider;
    }

    @After()
    public void after(){
        this.webDriverProvider.get().quit();
    }

    @Before()
	public void before(Scenario scenario) throws MalformedURLException {

//        DesiredCapabilities caps = new DesiredCapabilities();
//        String jenkinsBuildNumber = null;
//
//
//        if ((jenkinsBuildNumber = System.getenv("BUILD_NUMBER")) != null) {
//            caps.setCapability("build", jenkinsBuildNumber);
//            sauceLabRun = true;
//        }
//
//        String tb = System.getenv("testbed");
//        if (String.valueOf(tb).equals("saucelabs")) {
//            String build = String.valueOf(System.getProperty("buildname"));
//            if ( build == "null") {  build = System.getenv("USER"); }
//            caps.setCapability("build", build);
//            sauceLabRun = true;
//        }

//        if (sauceLabRun) {
//            caps.setCapability("platform", System.getenv("platform"));
//            caps.setCapability("browserName", System.getenv("browserName"));
//            caps.setCapability("version", System.getenv("version"));
//            caps.setCapability("screenResolution", "1920x1200");
//            caps.setCapability("name", scenario.getName());
//
//            SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication();
//            String username =  authentication.getUsername();
//            String accesskey = authentication.getAccessKey();
//            this.webDriverProvider.set(new RemoteWebDriver(
//                    new URL("http://" + username+ ":" + accesskey + "@ondemand.saucelabs.com:80/wd/hub"),caps));
//            String sessionId = (((RemoteWebDriver) webDriverProvider.get()).getSessionId()).toString();
//
//        } else {
//            String browserName = System.getenv("browserName");
//            switch (String.valueOf(browserName)) {
//                case "phantomjs":
//                    caps = DesiredCapabilities.phantomjs();
//                    caps.setCapability("takesScreenshot", true);
//                    caps.setJavascriptEnabled(true);
//                    String binary = System.getProperty("phantomjs.binary");
//                    caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, binary);
//                    this.webDriverProvider.set(new PhantomJSDriver(caps));
//                    break;
//                case "firefox":
//                    this.webDriverProvider.set(new FirefoxDriver());
//                    break;
//                case "ie":
//                    this.webDriverProvider.set(new InternetExplorerDriver());;
//                    break;
//                case "safari":
//                    this.webDriverProvider.set(new SafariDriver());
//                    break;
//                default:
////                    //String pathToChromeDriverBinary = getBrowserVariables("pathToChromeDriverBinary");
////                    String pathToChromeDriverBinary = "/Users/vsummers/Downloads/chromedriver";
////                    caps = DesiredCapabilities.chrome();
////                    System.setProperty("webdriver.chrome.driver", pathToChromeDriverBinary);
////                    caps.setBrowserName(browserName);
////                    caps.setPlatform(Platform.MAC);
////                    caps.setVersion("53.0");
//                    this.webDriverProvider.set(new FirefoxDriver());
//                    webDriverProvider.get().manage().window().setSize(new Dimension(1400,1400));
//
//            }
//        }

		this.webDriverProvider.set(new ChromeDriver());
	}

}
