package monet.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.GuiceObjectFactory;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test",
        format = { "pretty" },
        glue = { "monet.steps", "monet.cucumber" }
)
public class RunCukesTest {
    static {
        GuiceObjectFactory.load();
    }
}