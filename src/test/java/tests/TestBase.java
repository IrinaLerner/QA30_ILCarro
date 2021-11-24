package tests;

import manager.ApplicationManager;
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

    static ApplicationManager app = new ApplicationManager();
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
    public void startLogger(Method method){
        logger.info("Start test ---> "+method.getName());
    }
    @AfterMethod
    public void end(Method method){
        logger.info("************************************");
    }


}
