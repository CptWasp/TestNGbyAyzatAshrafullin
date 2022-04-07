package steps;


import driverManager.DriverManager;
import driverManager.WebDriverConfig;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.UnknownHostException;

public class Hooks {

    protected WebDriver driver = DriverManager.getDriver();

    @AfterTest
    /**
     * Код, который будет выполняться после каждого сценария.
     * Делаем скриншот страницы.
     */
    public void afterTest() throws Exception {
        // Получаем скриншот страницы где произошла остановка
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(".\\screenshot.png"));

        DriverManager.closeWebDriver();
    }
}
