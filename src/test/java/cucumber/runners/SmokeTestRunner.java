package cucumber.runners;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/", glue = {"cucumber/steps/"}, tags = {"@smoke"})

public class SmokeTestRunner {
}
