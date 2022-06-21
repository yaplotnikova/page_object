package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Pattern;

public class HomePage extends BasePage {

    @FindBy(css = ".primary.compose")
    private WebElement writeLetterButton;
    @FindBy(name = "toFieldInput")
    private WebElement toInput;
    @FindBy(name = "subject")
    private WebElement subjectInput;
    @FindBy(id = "tinymce")
    private WebElement letterBody;
    @FindBy(css = ".screen__head .send.button")
    private WebElement sendButton;
    @FindBy(css = "#mce_0_ifr")
    private WebElement bodyIFrame;
    private By letterIsSend = By.cssSelector(".sendmsg__ads-ready");


    public HomePage(WebDriver driver) {
        super(driver);
        pageURL = "https://mail.ukr.net/desktop";
        PageFactory.initElements(driver, this);
    }

    public void clickWriteLetter() {
        writeLetterButton.click();
    }

    public void writeLetter(String to, String subject, String body) {
        toInput.sendKeys(to);
        subjectInput.sendKeys(subject);
        try {
            driver.switchTo().frame(bodyIFrame);
            letterBody.sendKeys(body);
        } finally {
            driver.switchTo().parentFrame();
        }
    }

    public void sendLetter() {

        sendButton.click();
    }


    public boolean getTextLetterIsSend(String expectedText) {
        return webDriverWait.until(ExpectedConditions.textMatches(letterIsSend,
                Pattern.compile("^" + expectedText + "\n.*")));
    }
}