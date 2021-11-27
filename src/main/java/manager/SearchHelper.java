package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SearchHelper extends HelperBase{

    public SearchHelper(WebDriver wd) {
        super(wd);
    }


    public void fillSearchForm(String city, String from, String to) {
        fillInputCity(city);
        selectPeriod(from,to);
    }

    public void selectPeriodNew(String fromD, String toD) {
    LocalDate from = LocalDate.parse(fromD, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    LocalDate to = LocalDate.parse(toD, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    LocalDate now= LocalDate.now();
    click(By.id("dates"));

    selectData(from,now);

    //int monthDiff = from.getYear()-now.getYear()== 0?from.getMonthValue()- now.getMonthValue() : 12- now.getMonthValue()+from.getMonthValue();
    //for(int i =0;i< monthDiff;i++){
    //    click(By.xpath("//button[@aria-label='Next month']"));
    //}
        click(By.xpath(String.format("//div[.=' %s ']",from.getDayOfMonth())));
       // monthDiff= to.getYear()-from.getYear()==0 ? to.getMonthValue() - from.getMonthValue(): 12-from.getMonthValue()+ to.getMonthValue();
       // for(int i =0;i< monthDiff;i++){
      //      click(By.xpath("//button[@aria-label='Next month']"));
      //  }

        selectData(to,from);
        click(By.xpath(String.format("//div[.=' %s ']",from.getDayOfMonth())));



    }
    private void selectData(LocalDate first,LocalDate second){
        int monthDiff = first.getYear()-second.getYear()== 0?first.getMonthValue()- second.getMonthValue() : 12- second.getMonthValue()+first.getMonthValue();
        for(int i =0;i< monthDiff;i++){
            click(By.xpath("//button[@aria-label='Next month']"));
        }

    }
    private void selectPeriod(String from, String to) {
        //"11/25/2021","11/26/2021"
        String[] dataFrom =from.split("/");
        String[] dataTo=to.split("/");
        click(By.id("dates"));

        int diffStart=0;
        if(LocalDate.now().getMonthValue()!=Integer.parseInt(dataFrom[0])){
            diffStart= Integer.parseInt(dataFrom[0])-LocalDate.now().getMonthValue();
        }
        int diff =0 ;
        if (Integer.parseInt(dataFrom[0])!=Integer.parseInt(dataTo[0])){
          diff= Integer.parseInt(dataTo[0])- Integer.parseInt(dataFrom[0]);
        }
        for(int i=0;i< diffStart;i++){
            click(By.xpath("//button[@aria-label='Next month']"));
        }
        String locator = "//div[.=' 25 ']";
        String locator2 = "//div[.' "+dataFrom[1]+"']";
        String locator3= String.format("//div[.=' %s ']",dataTo[1]);
        click(By.xpath(locator3));

        for(int i =0;i< diff;i++){
            click(By.xpath("//button[@aria-label='Next month']"));
        }
        String locator4= String.format("//div[.=' %s ']",dataTo[1]);
        click(By.xpath(locator4));

    }

   public void fillInputCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector("div.pac-item"));
        pause(500);
    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector(".cars-container"));
    }


    public void returnToMainPage() {
        click(By.cssSelector(".logo"));
    }
}
