package tests.ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.RozetkaAccountPage;
import ui.RozetkaSearchPage;


public class SelenideTest extends BaseTest {
    @BeforeMethod
    public void parentSetUp() {
        super.parentSetUp();
    }

   @Test
    public static void rozetkaSearch() {
       RozetkaSearchPage rozetkaSearchPage = new RozetkaSearchPage();
       rozetkaSearchPage.searchMilka();
       rozetkaSearchPage.openMilkaPage();
       rozetkaSearchPage.checkingBuyButton();
    }
    @Test
    public static void rozetkaCheckAccountPage(){
        RozetkaAccountPage rozetkaAccountPage = new RozetkaAccountPage();
        rozetkaAccountPage.clickAccountButton();
        rozetkaAccountPage.checkingDisplayingModalLogin();
        rozetkaAccountPage.checkingElementsOfModalLogin();
    }
}
