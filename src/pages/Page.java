package pages;

import data.FillData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Dejan
 */

public class Page {
    
    public WebElement waitForElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        return targetElement;
    }
    
    public WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOf(element));
        return targetElement;
    }
    
    public void clickOnElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        targetElement.click();
    }
    
    public String selectCombo(WebDriver driver, WebElement element, String attribute) {
        WebElement targetCombo = waitForElement(driver, element);
        Select comboSelect = new Select(targetCombo);
        List<WebElement> elements = comboSelect.getOptions();
        int i = FillData.getRandomNumber(comboSelect.getOptions().size());
        WebElement elem = elements.get(i);
        String text = elem.getAttribute(attribute);
        comboSelect.selectByIndex(i);
        return text;
    }
    
    public String sendText(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOf(element));
        targetElement.clear();
        String text = FillData.getRandomText();
        targetElement.sendKeys(text);
        return text;
    }
    
    public String sendYear(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOf(element));
        targetElement.clear();
        int numb = FillData.getRandomYear(50);
        String text = String.valueOf(numb);
        targetElement.sendKeys(text);
        return text;
    }
    
    public int checkboxSelect(WebDriver driver, WebElement parent, By optionLocator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOf(parent));
        WebElement gend = targetElement.findElement(optionLocator);
        gend.click();
        String text = gend.getAttribute("value");
        int j = Integer.valueOf(text);
        return j;
    } 
    
    public static void logOut(WebDriver driver) {
        WebElement exit = driver.findElement(By.id("logout"));
        exit.click();
    }
    
    public void chooseFile(WebDriver driver, WebElement element, String filePath) {
        WebElement upload = waitForElement(driver, element);
        upload.sendKeys(filePath);
    }
    
    public static int getNumberOfDays(String inputDate) {
        
        int i = 0;
        
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        Date date = new Date();
        
        String inputDate1 = inputDate;
        System.out.println("date1: " + inputDate1);
        String inputDate2 = myFormat.format(date);
        System.out.println("date2: " + inputDate2);
        
        try {
            Date date1 = myFormat.parse(inputDate1);
            Date date2 = myFormat.parse(inputDate2);
            long diff = date2.getTime() - date1.getTime();
            i = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            System.out.println("Days: " + i);
        } catch (ParseException ex) {
            Logger.getLogger(Page.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return i;
        
    }
    
    public static void compare(int Messages, int Days, String topicTitle) {
        
        if(Messages > Days) {
            System.out.println("Number of messages in topic "+ topicTitle +
                    " is greater than number of Days from the begining of the year 2017!");
        } else {
            System.out.println("Number of days is greater than number of messages!");
        }
        
    }
    
}
