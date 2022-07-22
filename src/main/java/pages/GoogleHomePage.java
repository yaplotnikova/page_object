package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class GoogleHomePage {
    public void acceptEverything() {
        $("#W0wltc > div").shouldBe(Condition.visible).click();
    }

    public void searchFieldClick() {
        $("[name='q']").shouldBe(Condition.visible).setValue("selenide").pressEnter();

    }
}
