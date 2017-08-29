package comparison;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LogInPage;
import pages.Page;
import pages.comparison.TvPage;
import setup.SetUp;

/**
 *
 * @author Dejan
 */

public class TestTv {
    
    private static WebDriver driver;
    private static LogInPage logInPage;
    private static HomePage homePage;
    private static Logger log = null;
    
    private TvPage tvPage;
    
    @BeforeClass
    public static void setUpClass() {
        driver = SetUp.initializeDriver(driver, log);
        logInPage = SetUp.openLogInPage(driver, log);
        homePage = logInPage.clickOnLogin(driver, log);
        log = Logger.getLogger(TestTv.class);
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
        tvPage = homePage.clickOnTv(driver);
        log.info("TV page is opened");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testNumberOfMessagesAndDays() {
        int numberOfMsg = tvPage.getNumberOfMessages(driver, "Thrones");
        int numberOfDays = Page.getNumberOfDays("01 01 2017");
        Page.compare(numberOfMsg, numberOfDays, "Thrones");
        Assert.assertNotEquals(String.valueOf(numberOfMsg), String.valueOf(numberOfDays));
    }
}
