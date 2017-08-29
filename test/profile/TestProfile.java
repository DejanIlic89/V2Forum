package profile;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LogInPage;
import pages.Page;
import pages.profile.ProfilePage;
import setup.SetUp;

/**
 *
 * @author Dejan
 */

public class TestProfile {
    
    private static WebDriver driver;
    private static LogInPage logInPage;
    private static HomePage homePage;
    private static Logger log = null;
    
    private ProfilePage profilePage;
    
    @BeforeClass
    public static void setUpClass() {
        driver = SetUp.initializeDriver(driver, log);
        logInPage = SetUp.openLogInPage(driver, log);
        homePage = logInPage.clickOnLogin(driver, log);
        log = Logger.getLogger(TestProfile.class);
        PropertyConfigurator.configure("log4j.properties");
        log.info("Home page is opened");
    }
    
    @AfterClass
    public static void tearDownClass() {
        Page.logOut(driver);
        log.info("Logging out");
        driver.quit();
    }
    
    @Before
    public void setUp() {
        profilePage = homePage.clickOnProfile(driver);
        log.info("Profile Page page is opened");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testSetupProfile() {
        profilePage.setupProfile(driver);
    }
    
    @Test
    public void testEditProfile() {
        profilePage.editProfile(driver);
    }
}
