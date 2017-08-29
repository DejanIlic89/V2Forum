package baseball;

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
import pages.baseball.BaseballPage;
import setup.SetUp;

/**
 *
 * @author Dejan
 */

public class TestBaseball {
    
    private static WebDriver driver;
    private static LogInPage logInPage;
    private static HomePage homePage; 
    private static Logger log = null;
    
    private BaseballPage baseballPage;
    
    @BeforeClass
    public static void setUpClass() {
        driver = SetUp.initializeDriver(driver, log);
        logInPage = SetUp.openLogInPage(driver, log);
        homePage = logInPage.clickOnLogin(driver, log);
        log = Logger.getLogger(TestBaseball.class);
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
        baseballPage = homePage.clickOnBaseball(driver);
        log.info("Baseball Page page is opened");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testNewTopic() {
        baseballPage.createNewTopic(driver);
        baseballPage.editTopic(driver);
        baseballPage.deleteTopic(driver);
    }
    
}
