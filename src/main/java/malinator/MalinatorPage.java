package malinator;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.NoSuchElementException;

public class MalinatorPage extends BasePage {
    private By enterEmailField = By.cssSelector("[name='search']");
    private By searchButton = By.xpath("//div[1]/div/div/div/div/button");
    private By lastLetter = By.xpath("//td[contains(text(), 'qwerty')]");


    public MalinatorPage(WebDriver driver) {
        super(driver);
        pageURL = "https://www.mailinator.com/";
    }


    public void openPage() {
        driver.get(pageURL);
    }

    public void malinatorLogin() {
        driver.findElement(enterEmailField).sendKeys("yaplotnikovatest@mailinator.com");
        driver.findElement(searchButton).click();
    }

    public void clickLastLetter() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(lastLetter));
        driver.findElement(lastLetter).click();
    }

    public void waitUntilLettersIsDisplayed() {
        for (int i = 0; i < 8; i++) {
            System.out.println(i);
            try {
                if (driver.findElement(lastLetter).isDisplayed()) {
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