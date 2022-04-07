package pageObjects;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected final WebDriver driver;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

}
