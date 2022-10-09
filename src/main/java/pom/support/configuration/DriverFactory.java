package pom.support.configuration;

import lombok.NoArgsConstructor;
import org.junit.AfterClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@NoArgsConstructor
public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(1366, 868));
        }
        return driver;
    }

    @AfterClass
    public static void killDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
