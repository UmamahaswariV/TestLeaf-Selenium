package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features/SL001_LoginFunction.feature"}, glue = {"steps"}, dryRun = false,publish=true)
public class TC001_SaleforceAccount extends AbstractTestNGCucumberTests{

}
