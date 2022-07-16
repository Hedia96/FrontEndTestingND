package org.example.testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/main/resources/features",
        glue =    {"org.example.stepDefs"},
        plugin = {          "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"},

        tags = "@smoke"

)



/**Notes
        1- as you see, @CucumberOptions is written above the class not inside it
2- easy way to get this path "src/main/resources/features"  >> Right click on "stepDefs" package > select "Copy Path/Reference" > select "Path From Content Root"
        3- tags value could be anything else instead of "@smoke", it's not a must to give it this name */
public class Runners  extends AbstractTestNGCucumberTests{

}
