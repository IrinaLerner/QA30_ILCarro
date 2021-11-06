package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarHelper extends HelperBase{

    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        click(By.id("1"));
    }

    public void fillCarForm(Car car) {
        if(isCarCreationFormPresent()){
            typeLocation(car.getAddress());
            type(By.id("make"),car.getMake());
            type(By.id("model"),car.getModel());
            type(By.id("year"),car.getYear());
            type(By.id("engine"),car.getEngine());

            select(By.id("fuel"),car.getFuel());
            select(By.id("gear"), car.getGear());
            select(By.id("wheelsDrive"),car.getWD());

            type(By.id("doors"),car.getDoors());
            type(By.id("seats"),car.getSeats());
            type(By.id("class"), car.getClasS());
            type(By.id("fuelConsumption"), car.getFuelConsumption());
            type(By.id("serialNumber"),car.getCarRegNumber());
            type(By.id("price"),car.getPrice());
            type(By.id("distance"),car.getDistanceIncluded());
            type(By.cssSelector(".feature-input"),car.getTypeFeature());
            type(By.id("about"),car.getAbout());


        }

    }

    public void select(By locator, String option) {
       // new Select(wd.findElement(locator)).selectByIndex(2);
        new Select(wd.findElement(locator)).selectByValue(option);
       // new Select(wd.findElement(locator)).selectByVisibleText(" Petrol ");



    }

    private void typeLocation(String address) {
        type(By.id("pickUpPlace"),address);
        click(By.cssSelector("div.pac-item"));
        pause(500);

    }

    private boolean isCarCreationFormPresent() {
        Boolean isForm = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector("h2")), "Write some details about your car to rent it out"));
        return isForm;

    }

    public void attachedPhoto(String link) {

        wd.findElement(By.id("photos"))
                .sendKeys(link);
    }
    public boolean isCarAdded() {
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.className("dialog-container"))));
        String text = wd.findElement(By.cssSelector(".dialog-container h1")).getText();
        return text.contains("Car added");
    }

    public void submitAddedCar() {

        click(By.xpath("//button[.='Search cars']"));
    }
}
