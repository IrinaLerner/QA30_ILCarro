package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> loginDto() {
        List<Object[]> list= new ArrayList<>();
        list.add(new Object[]{"nevo@gmail.com","Nn12345$"});
        list.add(new Object[]{"nevo@gmail.com","Nn12345$"});
        list.add(new Object[]{"nevo@gmail.com","Nn12345$"});

        return  list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginModelDto(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("nevo@gmail.com").setPassword("Nn12345$")});
        list.add(new Object[]{new User().withEmail("nevo@gmail.com").setPassword("Nn12345$")});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> registrationCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader= new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
       String line=  reader.readLine();
       while(line !=null){
           String[] split = line.split(",");
           list.add(new Object[]{new User().withName(split[0])
                   .withLastname(split[1])
                   .withEmail(split[2])
                   .setPassword(split[3])});
           line=reader.readLine();
       }

        return list.iterator();
    }

}
