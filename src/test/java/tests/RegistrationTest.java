package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @BeforeMethod
    public void precondition() {
        if (!app.getHelperUser().isLogInPresent()) {
            app.getHelperUser().logout();
        }
    }
//perepisat
    @Test(dataProvider = "registrationCSV",dataProviderClass = MyDataProvider.class)
    public void registrationPositiveTest(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        User user = new User().withName("Lis").withLastname("Snow").withEmail("snow"+i+"@gmail.com").setPassword("Snow12345$");
        logger.info("Tests Registration Positive starts with >>>");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitForm();
        //click(By.cssSelector(""));
        Assert.assertTrue(app.getHelperUser().isRegistered());
    }
    @Test
    public void registrationPasswordTest() {
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        User user = new User()
                .withName("Lis")
                .withLastname("Snow")
                .withEmail("snow"+i+"@gmail.com")
                .setPassword("S123");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        Assert.assertTrue(app.getHelperUser().isErrorPasswordDisplayed());
        Assert.assertFalse(app.getHelperUser().isLoggedSuccess().isYallaButtonActive();
    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }


}
