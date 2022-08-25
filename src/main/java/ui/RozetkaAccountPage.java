package ui;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RozetkaAccountPage {
    public void clickAccountButton() {
        $x("/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[3]/rz-user/button")
                .shouldBe(Condition.visible).click();
    }
    public void checkingDisplayingModalLogin(){
        $x("/html/body/app-root/rz-single-modal-window/div[3]").isDisplayed();
    }
    public void checkingElementsOfModalLogin(){
        $(By.id("auth_email")).isDisplayed();
        $(By.id("auth_pass")).isDisplayed();
        $x("/html/body/app-root/rz-single-modal-window/div[3]/div[2]/rz-user-identification/rz-auth/div/" +
                "form/fieldset/div[5]/button[1]").isDisplayed();
    }
}
