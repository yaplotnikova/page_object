package malinator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MalinatorCheck {
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"email_pane\"]/div/div[2]/div[1]/div[2]/div[2]")
    private WebElement checkEmailLocator;
    @FindBy(xpath = "//*[@id=\"email_pane\"]/div/div[1]/div[1]/div[2]")
    private WebElement checkSubjectLocator;
    @FindBy(xpath = "//html/body/span/div/span")
    private WebElement checkBodyLocator;
    @FindBy(id = "html_msg_body")
    private WebElement checkBodyIFrame;

    public MalinatorCheck(WebDriver driver) {
        this.driver = driver;
        String pageURL = "https://www.mailinator.com/v4/public/inboxes.jsp?msgid=yaplotnikovatest-1655377790-145760440";
        PageFactory.initElements(driver, this);
    }


    public String checkMalinatorEmail() {
        return checkEmailLocator.getText();
    }

    public String checkMalinatorSubject() {
        return checkSubjectLocator.getText();
    }

    public String checkMalinatorBody() {
        try {
            driver.switchTo().frame(checkBodyIFrame);
            return checkBodyLocator.getText();
        } finally {
            driver.switchTo().parentFrame();
        }
    }
}