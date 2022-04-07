package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    private static void setDriver(){
        driver = new ChromeDriver(WebDriverConfig.configChrome());
    }

    public static WebDriver getDriver() {
        if (driver == null){
            setDriver();
        }
        return driver;
    }
}
