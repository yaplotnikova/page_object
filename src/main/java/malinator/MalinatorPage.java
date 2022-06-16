package malinator;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.NoSuchElementException;

public class MalinatorPage extends BasePage {
    @FindBy(css = "[name='search']")
    private WebElement enterEmailField;
    @FindBy(xpath = "//div[1]/div/div/div/div/button")
    private WebElement searchButton;
    @FindBy(xpath = "//td[contains(text(), 'qwerty')]")
    private WebElement lastLetter;


    public MalinatorPage(WebDriver driver) {
        super(driver);
        pageURL = "https://www.mailinator.com/";
        PageFactory.initElements(driver, this);
    }


    public void openPage() {
        driver.get(pageURL);
    }

    public void malinatorLogin() {
        enterEmailField.sendKeys("yaplotnikovatest@mailinator.com");
        searchButton.click();
    }

    public void clickLastLetter() {
        webDriverWait.until(ExpectedConditions.visibilityOf(lastLetter));
        lastLetter.click();
    }

    public void waitUntilLettersIsDisplayed() {
        for (int i = 0; i < 8; i++) {
            System.out.println(i);
            try {
                if (lastLetter.isDisplayed()) {
                    return;
                }
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        throw new TimeoutException();
    }
}