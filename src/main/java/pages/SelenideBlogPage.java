package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SelenideBlogPage {
    public void searchBlog() {
        SelenideElement blogLink =
                $x("/html/body/div[1]/div/header/div/div[2]/a[4]");
        blogLink.shouldBe(Condition.visible).click();
    }

    public void getCurrentBlogURL() {

        webdriver().shouldHave(url("https://selenide.org/blog.html"));
    }
}
