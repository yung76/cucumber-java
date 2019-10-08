package hellocucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/Destination/cucumber"})
//"json:target/Destination/cucumber.json"

public class RunCucumberTest {

}

