package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    HelperUser helperUser;
    CarHelper car;

    public void init(){
        wd=new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        helperUser =new HelperUser(wd);
        car=new CarHelper(wd);


    }

    public void stop(){

       // wd.quit();
    }
    public HelperUser getHelperUser() {
        return helperUser;
    }

    public CarHelper getCar() {
        return car;
    }
}
