package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void parentSetUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 4;
        Configuration.browserSize = "1920x1080";
        Selenide.open("https://google.com");
    }
}