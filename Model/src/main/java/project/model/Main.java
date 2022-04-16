package project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import project.model.wrapper.CityDataHelper;
import project.model.wrapper.exceptions.CityDataCouldNotBeFoundException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        CityDataHelper helper = new CityDataHelper("oporto");
        
        try {
            System.out.println(helper.getInhabitants());
        } catch (CityDataCouldNotBeFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
