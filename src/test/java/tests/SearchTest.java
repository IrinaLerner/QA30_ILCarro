package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

@Test
    public void searchTest(){
    app.Search().fillSearchForm("Haifa","11/25/2021","11/30/2021");
   // app.Search().clickYallaButton();
    app.getHelperUser().submitForm();
    //Assert.assertTrue(app.Search().isListOfCarsAppeared());
}
}
