package ui;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class RozetkaSearchPage {

    public void searchMilka() {
        $("body > app-root > div > div > rz-header > rz-main-header > " +
                "header > div > div > div > form > div > div > input")
                .shouldBe(Condition.visible).setValue("milka").pressEnter();

    }

    public void openMilkaPage() {
       $x("/html/body/app-root/div/div/rz-search/rz-catalog/div/div[2]/section/rz-grid/ul/li[1]" +
               "/rz-catalog-tile/app-goods-tile-default/div/div[2]").shouldBe(Condition.visible).click();
    }
    public void checkingBuyButton(){
        $("body > app-root > div > div > rz-product > aside > rz-product-carriage > div >" +
                " div.product-carriage__buy > div > rz-product-buy-btn > app-buy-button > button").is(Condition.enabled);
    }


}


