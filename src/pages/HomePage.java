package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.baseball.BaseballPage;
import pages.comparison.TvPage;
import pages.profile.ProfilePage;

/**
 *
 * @author Dejan
 */

public class HomePage extends Page {
    
    @FindBy(how = How.CSS, using = "a[href='/profile?mode=editprofile']")
    private WebElement profile;
    
    @FindBy(how = How.CSS, using = "a[href='/f36-baseball']")
    private WebElement baseball;
    
    @FindBy(how = How.CSS, using = "a[href='/f18-tv']")
    private WebElement tv;
    
    public ProfilePage clickOnProfile(WebDriver driver) {
        clickOnElement(driver, profile);
        return PageFactory.initElements(driver, ProfilePage.class);
    }
    
    public BaseballPage clickOnBaseball(WebDriver driver) {
        clickOnElement(driver, baseball);
        return PageFactory.initElements(driver, BaseballPage.class);
    }
    
    public TvPage clickOnTv(WebDriver driver) {
        clickOnElement(driver, tv);
        return PageFactory.initElements(driver, TvPage.class);
    }
    
}
