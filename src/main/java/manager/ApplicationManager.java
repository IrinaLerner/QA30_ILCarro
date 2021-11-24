package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    //WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser helperUser;
    CarHelper car;
    SearchHelper search;
    String browser;
    Properties properties;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties =new Properties();
    }

    public void init() throws IOException {
        String target =System.getProperty("target","config");
        properties.load(new FileReader(String.format("src/test/resources/%s.properties",target)));

        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Tests starts on Chrome Driver");
        }else if (browser.equals(BrowserType.FIREFOX)){
            wd= new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Tests starts on FireFox Driver");
        }
        wd= new EventFiringWebDriver(new ChromeDriver());
        logger.info("Tests starts on Chrome Driver");
        wd.manage().window().maximize();
        wd.navigate().to(properties.getProperty("web.baseURL"));
        //wd.navigate().to("https://ilcarro.xyz/search");
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

    public String email(){
        return properties.getProperty("web.email");
    }
    public String password(){
        return properties.getProperty("web.password");
    }
}

