package project.model.wrapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import project.model.wrapper.exceptions.DbCityWrapperException;

public class DBCityWrapper implements IWrapper {

    private String cityName;
    private String countryName;
    private String cityFileName;

    public DBCityWrapper(String cityName, String countryName) throws Exception {
        this.cityName = cityName;
        this.countryName = countryName;

        this.makeRequest();
    }

    private String makeCountryRequest() throws IOException {
        String link = "https://en.db-city.com/";

        String countryFileName = "dbcity_" + this.countryName;

        HttpRequestHelper.httpRequest1(link, this.countryName, countryFileName);

        return countryFileName;
    }

    private String findCityLink(String countryFileName) throws Exception {
        String regex = "List of major.*href=\\\"(.*?)\\\" title=\\\""+ this.cityName +"\\\"";

        try {
            return findPattern(
                new Scanner(new FileInputStream(countryFileName)),
                Pattern.compile(regex, Pattern.CASE_INSENSITIVE)
            ).group(1);
        } catch (FileNotFoundException e) {
            throw new Exception();
        }
    }

    private void makeCityRequest(String cityLink) throws IOException {
        String link = "https://en.db-city.com" + cityLink;

        this.cityFileName = "dbcity_" + this.cityName;

        HttpRequestHelper.httpRequest1(link, "", this.cityFileName);
    }

    /**
     * @throws Exception
     *
     */
    private void makeRequest() throws Exception {
        String countryFileName = this.makeCountryRequest();

        String cityLink = this.findCityLink(countryFileName);

        this.makeCityRequest(cityLink);
    }


    /**
     * Create new scanner from file fileName for other methods to use.
     *
     * @return Scanner
     * @throws DbCityWrapperException
     */
    private Scanner createScanner() throws DbCityWrapperException {
        try {
            return new Scanner(new FileInputStream(this.cityFileName));
        } catch (FileNotFoundException ex) {
            throw new DbCityWrapperException("fileNotFound" + ex);
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

    private String getMatch(String regex, int group) throws DbCityWrapperException {
        Scanner scanner = createScanner();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        try {
            matcher = findPattern(scanner, pattern);
        }
        catch (NoSuchElementException e) {
            throw new DbCityWrapperException("Data not found");
        }

        scanner.close();

        return matcher.group(group);
    }

    @Override
    public String getName() throws DbCityWrapperException {
        // TODO Auto-generated method stub
        throw new DbCityWrapperException("Data not found");
    }

    @Override
    public String getCountry() throws DbCityWrapperException {
        // TODO Auto-generated method stub
        throw new DbCityWrapperException("Data not found");
    }

    @Override
    public boolean isCapital() throws DbCityWrapperException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getCountryFlag() throws DbCityWrapperException {
        // TODO Auto-generated method stub
        throw new DbCityWrapperException("Data not found");
    }

    @Override
    public List<String> getCountryLanguages() throws DbCityWrapperException {
        // TODO Auto-generated method stub
        throw new DbCityWrapperException("Data not found");
    }

    @Override
    public String getCityFlag() throws DbCityWrapperException {
        // TODO Auto-generated method stub
        throw new DbCityWrapperException("Data not found");
    }

    @Override
    public List<String> getCityLandmarks() throws DbCityWrapperException {
        // TODO Auto-generated method stub
        throw new DbCityWrapperException("Data not found");
    }

    @Override
    public float getArea() throws DbCityWrapperException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getInhabitants() throws DbCityWrapperException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getPopulationDensity() throws DbCityWrapperException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getPostalCode() throws DbCityWrapperException {
        // TODO Auto-generated method stub
        throw new DbCityWrapperException("Data not found");
    }

    @Override
    public String getMayorName() throws DbCityWrapperException {
        throw new DbCityWrapperException("Data not found");
    }

    @Override
    public String getLatitude() throws DbCityWrapperException {
        String regex = "class=\\\"latitude\\\">(.*?)<";

        return getMatch(regex, 1);
    }

    @Override
    public String getLongitude() throws DbCityWrapperException {
        String regex = "class=\\\"longitude\\\">(.*?)<";

        return getMatch(regex, 1);
    }

    @Override
    public float getAltitude() throws DbCityWrapperException {
        String regex = "Altitude<.*?>([\\/w].*?)<";

        return Float.parseFloat(getMatch(regex, 1));
    }

    @Override
    public String getClimate() throws DbCityWrapperException {
        String regex = "Climate<.*?>([\\/w].*?)<";

        return getMatch(regex, 1);
    }

    @Override
    public String getTimezone() throws DbCityWrapperException {
        String regex = "Time zone.*?>(UTC)<\\/abbr>(.*?)<";

        return getMatch(regex, 1);
    }

    @Override
    public String getWebsite() throws DbCityWrapperException {
        String regex = "Website.*?href=\\\"(.*?)\\\"";

        return getMatch(regex, 1);
    }

    @Override
    public List<String> getTwinTowns() throws DbCityWrapperException {
        // TODO Auto-generated method stub
        throw new DbCityWrapperException("Data not found");
    }
    
}
