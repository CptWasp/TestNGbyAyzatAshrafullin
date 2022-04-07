package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

public class WebDriverConfig {

    public static ChromeOptions configChrome(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        return chromeOptions;
    }
}
