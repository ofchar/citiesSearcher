package project.model.wrapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import project.model.wrapper.exceptions.WikipediaWrapperException;

public class WikipediaWrapper implements IWrapper {

    private String fileName;
    
    public WikipediaWrapper(String fileName) {
        this.fileName = fileName;
    }
    
    /**
     * Create new scanner from file fileName for other methods to use.
     * 
     * @return Scanner
     * @throws WikipediaWrapperException 
     */
    private Scanner createScanner() throws WikipediaWrapperException {
        try {
            return new Scanner(new FileInputStream(this.fileName));
        } catch (FileNotFoundException ex) {
            throw new WikipediaWrapperException("fileNotFound" + ex);
        }
    }
    
    /**
     * Find pattern in provided scanner, return Matcher instance or throw exception
     * when pattern was not found.
     * 
     * @param scanner scanner to search
     * @param pattern pattern to look for
     * @return Matcher
     * @throws NoSuchElementException 
     */
    private Matcher findPattern(Scanner scanner, Pattern pattern) throws NoSuchElementException {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            Matcher matcher = pattern.matcher(line);
            
            if (matcher.find()) {
                return matcher;
            }
        }
        
        throw new NoSuchElementException();
    }
    
    @Override
    public String getName() throws WikipediaWrapperException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getCountry() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isCapital() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getCountryFlag() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<String> getCountryLanguages() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getCityFlag() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<String> getCityLandmarks() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float getArea() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getInhabitants() throws WikipediaWrapperException {
        Scanner scanner = createScanner();
        
        Pattern pattern = Pattern.compile("Population.*>(\\d*,\\d*)<");
        Matcher matcher;
        
        try {        
            matcher = findPattern(scanner, pattern);
        }
        catch (NoSuchElementException e) {
            throw new WikipediaWrapperException("Data not found");
        }

        scanner.close();
        
        return Integer.parseInt(matcher.group(1).replace(",", ""));
    }

    @Override
    public float getPopulationDensity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getPostalCode() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getMayorName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float getLatitude() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float getLongitude() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float getAltitude() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getClimate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTimezone() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWebsite() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<String> getTwinTowns() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
