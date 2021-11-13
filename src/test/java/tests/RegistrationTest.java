package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @Test
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


}
