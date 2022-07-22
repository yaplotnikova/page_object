package pages;

import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SelenideSearchPage {
    public void checkNumberOfResultsAndClickFirst() {
        $$x("//h3[contains(text(),'Selenide')]").
                shouldHave(CollectionCondition.sizeGreaterThanOrEqual(7)).
                get(0).click();
    }
}
