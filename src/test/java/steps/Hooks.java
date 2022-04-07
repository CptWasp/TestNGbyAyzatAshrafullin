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


//    @BeforeTest
//    /**
//     * Код, который будет выполняться до каждого сценария.
//     * Настраиваем профиль и поведение нового экземпляра WebDriver.
//     * Чистим все, что можем очистить чтобы избежать общего состояния между выполнением тестов.
//     */
//    public void beforeTest() throws UnknownHostException {
//
//    }

    @AfterTest
    /**
     * Код, который будет выполняться после каждого сценария.
     * Встраиваем скриншот в тестовый отчет, если тест завершен аварийно.
     */
    public void afterTest() throws Exception {
        // Получаем скриншот страницы где произошла остановка
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(".\\screenshot.png"));

        driver.close();
        driver.quit();
    }
}
