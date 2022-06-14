package malinator;


import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MalinatorCheck {
    private WebDriver driver;
    private By checkEmailLocator = By.xpath("//*[@id=\"email_pane\"]/div/div[2]/div[1]/div[2]/div[2]");
    private By checkSubjectLocator = By.xpath("//*[@id=\"email_pane\"]/div/div[1]/div[1]/div[2]");
    private By checkBodyLocator = By.xpath("//html/body/span/div/span");
    private By checkBodyIFrame = By.id("html_msg_body");

    public MalinatorCheck(WebDriver driver) {

        this.driver = driver;
    }

    public String checkMalinatorEmail() {
        return driver.findElement(checkEmailLocator).getText();
    }

    public String checkMalinatorSubject() {
        return driver.findElement(checkSubjectLocator).getText();
    }

    public String checkMalinatorBody() {
        try {
            driver.switchTo().frame(driver.findElement(checkBodyIFrame));
            return driver.findElement(checkBodyLocator).getText();
        } finally {
            driver.switchTo().parentFrame();
        }
    }
}