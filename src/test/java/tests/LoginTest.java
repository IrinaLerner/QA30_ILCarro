package tests;

import manager.MyDataProvider;
import manager.NgListener;
import models.User;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//@Listeners(NgListener.class)
public class LoginTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.getHelperUser().isLoginPresent()) {
            app.getHelperUser().logout();

        }
    }

    @Test(dataProvider = "loginModelDto",dataProviderClass = MyDataProvider.class)
    public void loginSuccess(User user) {
        //User user = new User().withEmail("nevo@gmail.com").setPassword("Nn12345$");
        logger.info("With user --> "+user.toString());

        app.getHelperUser().openLoginForm();
        // app.getHelperUser().fillLoginForm("nevo@gmail.com","Nn12345$");
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitForm();
        Assert.assertTrue(app.getHelperUser().isLoggedSuccess());
    }




    @Test(dataProvider = "loginDto",dataProviderClass = MyDataProvider.class)
    public void loginSuccess2(String email, String password) {
        logger.info("Start with email -->"+email+ "With password-->"+ password);
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(email, password);
        app.getHelperUser().submitForm();
        Assert.assertTrue(app.getHelperUser().isLoggedSuccess());
    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();
    }
}
