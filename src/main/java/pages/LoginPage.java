package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.User;

public class LoginPage extends BasePage {
    private By loginField = By.name("login");
    private By passwordField = By.cssSelector("[name='password']");
    private By buttonSubmit = By.cssSelector("[type='submit']");

    public void navigate(){
        driver.get(pageURL);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        pageURL = "https://mail.ukr.net";
    }

    public void login(User user) {
    driver.findElement(loginField).sendKeys(user.getLogin());
    driver.findElement(passwordField).sendKeys(user.getPassword());
    driver.findElement(buttonSubmit).click();
    }

}
