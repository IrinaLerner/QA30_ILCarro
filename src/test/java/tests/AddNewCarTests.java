package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(app.getHelperUser().isLogInPresent()){
            app.getHelperUser().login(new User().withEmail("nevo@gmail.com").setPassword("Nn12345$"));
        }


    }
    @Test
    public void addNewCarTestPositive(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        Car car = Car.builder()
                .address("Tel aviv")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("2.3")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsumption("5.6")
                .carRegNumber("100-55-"+i)
                .price("65")
                .distanceIncluded("500")
                .typeFeature("type")
                .about("don't smoky")
                .build();
        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getCar().attachedPhoto();
        app.getHelperUser().submitForm();



    }


}
