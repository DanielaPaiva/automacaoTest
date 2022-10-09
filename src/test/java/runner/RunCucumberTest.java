package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class) /* O tipo de classe que ele vai utilizar */
@CucumberOptions(
        plugin = {},
        features = "src/test/features/web", /* Pasta onde as features estão*/
        glue = {"stepdefinition"}
)
public class RunCucumberTest {
//    public static WebDriver driver;

//    @BeforeClass
//    public static void start(){
//        driver = new ChromeDriver();
//    }
//
//    @AfterClass
//    public static void close(){
//        driver.quit();
//    }
}
