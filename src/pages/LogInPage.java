package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Dejan
 */

public class LogInPage {
    
    @FindBy(how = How.ID, using = "username")
    private WebElement username;
    
    @FindBy(how = How.ID, using = "password")
    private WebElement password;
    
    @FindBy(how = How.NAME, using = "login")
    private WebElement logIn;
    
    public HomePage clickOnLogin(WebDriver driver, Logger log) {
        log = Logger.getLogger(LogInPage.class);
        PropertyConfigurator.configure("log4j.properties");
        username.sendKeys("tester");
        log.info("username is entered");
        password.sendKeys("Tester123");
        log.info("password is entered");
        logIn.click();
        log.info("Log In is performed");
        return PageFactory.initElements(driver, HomePage.class);
    }
    
}
