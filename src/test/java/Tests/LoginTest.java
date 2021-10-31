package Tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(!app.getHelperUser().isLogInPresent()){
            app.getHelperUser().logout();

        }
    }

    @Test
    public void loginSuccess(){
        User user = new User().withEmail("nevo@gmail.com").setPassword("Nn12345$");

        app.getHelperUser().openLoginForm();
       // app.getHelperUser().fillLoginForm("nevo@gmail.com","Nn12345$");
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitForm();
        Assert.assertTrue(app.getHelperUser().isLoggedSuccess());
    }

    @Test
    public void loginSuccess2(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("nevo@gmail.com","Nn12345$");
        app.getHelperUser().submitForm();
        Assert.assertTrue(app.getHelperUser().isLoggedSuccess());
    }

    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }
}
