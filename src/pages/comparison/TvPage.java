package pages.comparison;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Page;

/**
 *
 * @author Dejan
 */

public class TvPage extends Page {
    
    @FindBy(how = How.ID, using = "search_keywords")
    private WebElement searchBox;
    
    @FindBy(how = How.CSS, using = "#forum-search > fieldset > input.button2")
    private WebElement searchBtn;
    
    @FindBy(how = How.CSS, using = "#main-content > form:nth-child(6) > div > div > ul.topiclist.topics.search > li > dl > dd.posts")
    private WebElement posts;
    
    public int getNumberOfMessages(WebDriver driver, String topicTitle) {
        
        WebElement srchBox = waitForVisibilityOfElement(driver, searchBox);
        srchBox.clear();
        srchBox.sendKeys(topicTitle);
        
        clickOnElement(driver, searchBtn);
        
        WebElement post = waitForVisibilityOfElement(driver, posts);
        String text = post.getText();
        int i = Integer.valueOf(text);
        System.out.println("Number of posts: " + i);
        
        return i;
        
    }
    
}
