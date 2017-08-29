package setup;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import pages.LogInPage;

/**
 *
 * @author Dejan
 */

public class SetUp {
    
    public static WebDriver initializeDriver(WebDriver driver, Logger log) {
        
        log = Logger.getLogger("SetUp");
        PropertyConfigurator.configure("log4j.properties");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("disable-infobars");

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        log.info("Driver is initialized");
        driver.manage().window().maximize();
        log.info("Brows is maximized");
        return driver;
    }
    
    public static LogInPage openLogInPage(WebDriver driver, Logger log) {
        log = Logger.getLogger("SetUp");
        PropertyConfigurator.configure("log4j.properties");
        driver.get("http://www.606v2.com/login");
        log.info("Log In page is opened");
        return PageFactory.initElements(driver, LogInPage.class);
    }
    
}
