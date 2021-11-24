package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    @Test
    public void searchTest() {
        app.Search().fillSearchForm("Haifa", "12/25/2021", "12/30/2021");
        app.getHelperUser().submitForm();
        Assert.assertTrue(app.Search().isListOfCarsAppeared());
    }

    @Test
    public void searchTest2() {
        app.Search().fillSearchForm("Haifa", "12/25/2021", "12/30/2021");
        app.getHelperUser().submitForm();
        Assert.assertTrue(app.Search().isListOfCarsAppeared());
    }

    @Test
    public void searchTestYear() {
        app.Search().fillInputCity("Haifa");
        app.Search().selectPeriodNew("03/03/2022","06/06/2022");
        app.Search().pause(5000);
    }

    @AfterMethod
    public void post() {
        app.Search().returnToMainPage();
    }
}
