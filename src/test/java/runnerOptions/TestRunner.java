package runnerOptions;




import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)// when running in junit uncomment it
@CucumberOptions(
		features = "src/test/java/features",
		glue ="stepDefinations")
public class TestRunner extends AbstractTestNGCucumberTests{

}


