package pages.baseball;

import data.FillData;
import domen.Helper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import pages.Page;

/**
 *
 * @author Dejan
 */

public class BaseballPage extends Page {
    
    @FindBy(how = How.CSS, using = "a[href='/post?f=36&mode=newtopic']")
    private WebElement newTopic;
    
    @FindBy(how = How.NAME, using = "subject")
    private WebElement title;
    
    @FindBy(how = How.CSS, using = "#textarea_content > div > textarea")
    private WebElement textarea;
    
    @FindBy(how = How.XPATH, using = "//*[@id='main-content']/form[1]/div[2]/div/fieldset/input[7]")
    private WebElement send;
    
    @FindBy(how = How.NAME, using = "selected_id")
    private WebElement jumpTo;
    
    @FindBy(how = How.CSS, using = "#main-content > form:nth-child(33) > fieldset > input.button2")
    private WebElement goBtn;
    
    @FindBy(how = How.ID, using = "search_keywords")
    private WebElement searchField;
    
    @FindBy(how = How.CSS, using = "#forum-search > fieldset > input.button2")
    private WebElement searchBtn;
    
    @FindBy(how = How.CLASS_NAME, using = "topictitle")
    private WebElement titleName;
    
    @FindBy(how = How.CLASS_NAME, using = "i_icon_edit  ")
    private WebElement edit;
    
    @FindBy(how = How.CLASS_NAME, using = "i_icon_delete   ")
    private WebElement delete;
    
    @FindBy(how = How.NAME, using = "confirm")
    private WebElement confirm;
    
    Helper help = new Helper();
    
    public void createNewTopic(WebDriver driver) {
        
        clickOnElement(driver, newTopic);
        
        String title_ = sendText(driver, title);
        help.setTitle(title_);
        System.out.println("New Topic Title: " + title_);
        
        WebElement targetElement = waitForVisibilityOfElement(driver, textarea);
        targetElement.clear();
        String text = FillData.getRandomText();
        targetElement.sendKeys(text);
        System.out.println("Textarea text: " + text);
                
        clickOnElement(driver, send);
                
        Select select = new Select(waitForVisibilityOfElement(driver, jumpTo));
        select.selectByValue("f36");
        clickOnElement(driver, goBtn);
                        
    }
    
    public void editTopic(WebDriver driver) {
        
//        We must wait 15s after creating new topic because of the:
//        Flood control is active on this forum, 
//        please wait 15 second(s) before replying or posting.
//        Make users wait before posting again.
//        Flood control is defined by the admin.
        
        try {
            Thread.sleep(15000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BaseballPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        WebElement searchBox = waitForVisibilityOfElement(driver, searchField);
        searchBox.clear();
        searchBox.sendKeys(help.getTitle());
        WebElement search = waitForElement(driver, searchBtn);
        search.click();
        
        WebElement titleName_ = waitForVisibilityOfElement(driver, titleName);
        titleName_.click();
        
        WebElement editBtn = waitForElement(driver, edit);
        editBtn.click();
        
        WebElement tit = waitForVisibilityOfElement(driver, title);
        tit.clear();
        String text = sendText(driver, tit);
        help.setTitle(text);
        System.out.println("New Topic Title: " + text);

        WebElement textArea = waitForVisibilityOfElement(driver, textarea);
        textArea.clear();
        String txt = FillData.getRandomText();
        textArea.sendKeys(txt);
        System.out.println("New Textarea text: " + txt);
        
        clickOnElement(driver, send);
                
        Select select = new Select(waitForVisibilityOfElement(driver, jumpTo));
        select.selectByValue("f36");
        clickOnElement(driver, goBtn);
        
    }
    
    public void deleteTopic(WebDriver driver) {
                
        WebElement searchBox = waitForVisibilityOfElement(driver, searchField);
        searchBox.clear();
        searchBox.sendKeys(help.getTitle());
        WebElement search = waitForElement(driver, searchBtn);
        search.click();
        
        WebElement titleName_ = waitForVisibilityOfElement(driver, titleName);
        titleName_.click();
        
        WebElement deleteBtn = waitForElement(driver, delete);
        deleteBtn.click();
        
        WebElement yes = waitForElement(driver, confirm);
        yes.click();
        
    }
    
}
