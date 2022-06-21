package ukrnet;

import malinator.MalinatorCheck;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import malinator.MalinatorPage;
import testdata.User;

public class UkrNetTest {
    private static WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public static void sentEmailToMalinatorTest() {
        User user = new User("yaplotnikova@ukr.net", "113355Qwe");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login(user);

        HomePage homePage = new HomePage(driver);
        homePage.waitUntilLoaded();
        homePage.clickWriteLetter();
        homePage.writeLetter("yaplotnikovatest@mailinator.com", "qwerty", "test body");
        homePage.sendLetter();
        Assert.assertTrue(homePage.getTextLetterIsSend("Ваш лист надіслано"));

        MalinatorPage malinatorPage = new MalinatorPage(driver);
        malinatorPage.openPage();
        malinatorPage.malinatorLogin();
        malinatorPage.waitUntilJsIsReady();
        malinatorPage.waitUntilLettersIsDisplayed();
        malinatorPage.clickLastLetter();

        MalinatorCheck malinatorCheck = new MalinatorCheck(driver);
        Assert.assertEquals(malinatorCheck.checkMalinatorEmail(), "yaplotnikova@ukr.net");
        Assert.assertEquals(malinatorCheck.checkMalinatorSubject(), "qwerty");
        Assert.assertEquals(malinatorCheck.checkMalinatorBody(), "test body");
    }
}
