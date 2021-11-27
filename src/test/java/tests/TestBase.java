package tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import javax.imageio.IIOException;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {

    static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() throws IOException {
        app.init();

    }

    @AfterSuite
    public void tearDown(){

        app.stop();
    }


   @BeforeMethod
    public void startLogger(Method m){
        logger.info("Start test ---> "+m.getName());
    }
    @AfterMethod
    public void stoptTest(Method m){
        logger.info("The end of test --->" +m.getName());
    }


}
