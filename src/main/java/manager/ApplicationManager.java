package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    //WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser helperUser;
    CarHelper car;
    SearchHelper search;

    public void init(){
        wd= new EventFiringWebDriver(new ChromeDriver());
        logger.info("Tests starts on Chrome Driver");
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        helperUser =new HelperUser(wd);
        car=new CarHelper(wd);
        wd.register(new MyListener());
        search= new SearchHelper(wd);


    }

    public void stop(){
       wd.quit();
    }
    public HelperUser getHelperUser() {

        return helperUser;
    }

    public CarHelper getCar() {
        return car;
    }

    public SearchHelper Search() {
        return search;
    }
}

