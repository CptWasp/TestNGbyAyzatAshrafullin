package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public abstract class AbstractPage {

    protected final WebDriver driver;
    protected final long timeInSeconds = 10;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Явное ожидание
     * @param timeInSeconds время ожидания прогрузки элементов на странице
     * @return класс
     */
    public WebDriverWait getWaiter(long timeInSeconds){
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeInSeconds);
        webDriverWait.ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
        return webDriverWait;
    }

    public By waitForElementVisible(By findStrategy, long timeInSeconds){
        getWaiter(timeInSeconds).until(visibilityOfElementLocated(findStrategy));
        return findStrategy;
    }

    public WebElement findByXpath(String xpath, Duration duration){
        return driver.findElement(waitForElementVisible(By.xpath(xpath), duration.getSeconds()));
    }

}
