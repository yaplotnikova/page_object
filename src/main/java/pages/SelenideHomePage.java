package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SelenideHomePage {
    public void checkURL() {
        webdriver().shouldHave(url("https://selenide.org/"));
    }

    public void checkSupportOfUkraine() {
        $(".donate_header h1")
                .shouldHave(Condition.text("Selenide Supports Ukraine \uD83C\uDDFA\uD83C\uDDE6"));


    }

}
