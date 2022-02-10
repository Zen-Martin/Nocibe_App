package runners;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/reports/html/htmlreport",
                "json:target/reports/jsonreports/index.json",
                "junit:target/reports/xmlreport.xml"
        },
        features = {"src/test/resources/features"},
        glue = {"steps", "pageObjects"}
)
public class TestRunner extends BaseRunner{
}
