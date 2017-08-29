package pages.profile;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Page;

/**
 *
 * @author Dejan
 */

public class ProfilePage extends Page {
    
    @FindBy(how = How.ID, using = "profile_field_13_2")
    private WebElement favourPlayer;
    
    @FindBy(how = How.ID, using = "profile_field_13_1")
    private WebElement teamSports;
    
    @FindBy(how = How.CLASS_NAME, using = "profile_field_list")
    private WebElement parent;
    
    @FindBy(how = How.ID, using = "profile_field_4_-12_2")
    private WebElement day;
    
    @FindBy(how = How.ID, using = "profile_field_4_-12_1")
    private WebElement month;
    
    @FindBy(how = How.ID, using = "profile_field_4_-12_0")
    private WebElement year;
    
    @FindBy(how = How.ID, using = "profile_field_13_-11")
    private WebElement location;
    
    @FindBy(how = How.ID, using = "profile_field_13_-9")
    private WebElement jobHobbies;
    
    @FindBy(how = How.ID, using = "profile_field_13_-8")
    private WebElement humor;
    
    @FindBy(how = How.NAME, using = "submit")
    private WebElement save;
    
    @FindBy(how = How.XPATH, using = "//*[@id='main-content']/div[4]/div/p/a[2]")
    private WebElement viewProfile;
    
    @FindBy(how = How.CSS, using = "a[href='/profile?mode=editprofile&page_profil=avatars']")
    private WebElement avatar;
    
    @FindBy(how = How.NAME, using = "avatarurl")
    private WebElement avatarURL;
    
    @FindBy(how = How.NAME, using = "avatar")
    private WebElement image;
    
    public void setupProfile(WebDriver driver) {
        
        String favPlayer = sendText(driver, favourPlayer);
        System.out.println("Favourite Player is: " + favPlayer);
        
        String team = sendText(driver, teamSports);
        System.out.println("Team/Sports Followed is: " + team);
        
        int gender = checkboxSelect(driver, parent, By.name("profile_field_16_-7"));
        System.out.println("Gender is: " + gender);
        
        String day_ = selectCombo(driver, day, "value");
        System.out.println("Day is: " + day_);
        
        String month_ = selectCombo(driver, month, "value");
        System.out.println("Month is: " + month_);
        
        String year_ = sendYear(driver, year);
        System.out.println("Year is: " + year_);
        
        String locat = sendText(driver, location);
        System.out.println("Location is: " + locat);
        
        String job = sendText(driver, jobHobbies);
        System.out.println("Job/hibbies is: " + job);
        
        String hum = sendText(driver, humor);
        System.out.println("Humor is: " + hum);
        
        clickOnElement(driver, avatar);
        
        WebElement avURL = waitForVisibilityOfElement(driver, avatarURL);
        avURL.sendKeys("http://i.picasion.com/av/86/2D2S.jpg");
        
        clickOnElement(driver, save);
        
        String homePage = driver.getWindowHandle();
        System.out.println(homePage);
        
        clickOnElement(driver, viewProfile);
        
//        switching to another window/popup
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows.size());
        
        Iterator it = windows.iterator();
        while(it.hasNext()) {
            String currentWindowId = it.next().toString();
            System.out.println(currentWindowId);
            if(!currentWindowId.equals(homePage)) {
                driver.switchTo().window(currentWindowId);
                driver.close();
            }
        }
        
        driver.switchTo().window(homePage);
        
    }
    
    public void editProfile(WebDriver driver) {
        
        String favPlayer = sendText(driver, favourPlayer);
        System.out.println("Favourite Player is: " + favPlayer);
        
        String team = sendText(driver, teamSports);
        System.out.println("Team/Sports Followed is: " + team);
        
        int gender = checkboxSelect(driver, parent, By.xpath("//*[@id='profile_field_16_-7']/li[2]/label/input"));
        System.out.println("Gender is: " + gender);
        
        String day_ = selectCombo(driver, day, "value");
        System.out.println("Day is: " + day_);
        
        String month_ = selectCombo(driver, month, "value");
        System.out.println("Month is: " + month_);
        
        String year_ = sendYear(driver, year);
        System.out.println("Year is: " + year_);
        
        clickOnElement(driver, avatar);
        
//        upload picture from a URL
//        WebElement avURL = waitForVisibilityOfElement(driver, avatarURL);
//        avURL.sendKeys("http://i.picasion.com/av/86/2D2T.png");

//        upload picture from your computer
        File file = new File("pics\\2D2T.png");
        chooseFile(driver, image, file.getAbsolutePath());

        clickOnElement(driver, save);
        
        clickOnElement(driver, viewProfile);
        
    }
    
}
