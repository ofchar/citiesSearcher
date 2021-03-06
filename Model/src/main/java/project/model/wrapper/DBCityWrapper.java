package project.model.wrapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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

        HttpRequestHelper.httpRequest2(link, this.countryName, countryFileName);

        return countryFileName;
    }

    private String findCityLink(String countryFileName) throws Exception {
        String regex = "List of major.*href=\\\"(.*?)\\\" title=\\\""+ this.cityName +"\\\"";

        try {
            return findPattern(
                new Scanner(new FileInputStream(countryFileName), "UTF-8"),
                Pattern.compile(regex, Pattern.CASE_INSENSITIVE)
            ).group(1);
        } catch (FileNotFoundException e) {
            throw new Exception();
        }
    }

    private void makeCityRequest(String cityLink) throws IOException {
        String link = "https://en.db-city.com" + cityLink;

        this.cityFileName = "dbcity_" + this.cityName;

        HttpRequestHelper.httpRequest2(link, "", this.cityFileName);
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
        // Cannot get that information from DBCity.
        throw new DbCityWrapperException("Data not found");
    }

    @Override
    public String getCountryFlag() throws DbCityWrapperException {
        String regex = "Flag\"><img src=\"//(.*?)\"";

        return getMatch(regex, 1);
    }

    @Override
    public List<String> getCountryLanguages() throws DbCityWrapperException {
        Scanner scanner = createScanner();

        Pattern pattern = Pattern.compile("(?:Official language</th>(\\S)|(?!^)\\G)(?:(?!<li> :).)*?(?:<li>(.*?) :)");

        List<String> list = new ArrayList<String>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                list.add(matcher.group(2));
            }
        }

        scanner.close();

        if(list.isEmpty()) {
            throw new DbCityWrapperException("Data not found");
        }

        return list;
    }

    @Override
    public String getCityFlag() throws DbCityWrapperException {
        //There is no possibility to get that data from DBCity.
        throw new DbCityWrapperException("Data not found");
    }

    @Override
    public List<String> getCityLandmarks() throws DbCityWrapperException {
        //There is no possibility to get that data from DBCity.
        throw new DbCityWrapperException("Data not found");
    }

    @Override
    public float getArea() throws DbCityWrapperException {
        String regex = "Area.*?>([0-9,]+[.*0-9]*).*?km";

        return Float.parseFloat(getMatch(regex, 1).replace(",", "").split("-")[0]) * 100;
    }

    @Override
    public int getInhabitants() throws DbCityWrapperException {
        String regex = "inhabitants.*?>(\\d+,\\d*[,*\\d*]*).*?<";

        return Integer.parseInt(getMatch(regex, 1).replace(",", "").split("-")[0]);
    }

    @Override
    public float getPopulationDensity() throws DbCityWrapperException {
        String regex = "Density.*?>([0-9,]+[.*0-9]*).*?km";

        return Float.parseFloat(getMatch(regex, 1).replace(",", "").split("-")[0]);
    }

    @Override
    public String getPostalCode() throws DbCityWrapperException {
        String regex = "Postal address<.*?><span class=\"locality\">([\\w].*?)<";

        return getMatch(regex, 1);
    }

    @Override
    public String getMayorName() throws DbCityWrapperException {
        String regex = "Mayor<.*?>([\\w].*?)<";

        return getMatch(regex, 1);
    }

    @Override
    public String getLatitude() throws DbCityWrapperException {
        String regex = "class=\"latitude\">(.*?)<";

        return getMatch(regex, 1);
    }

    @Override
    public String getLongitude() throws DbCityWrapperException {
        String regex = "class=\"longitude\">(.*?)<";

        return getMatch(regex, 1);
    }

    @Override
    public float getAltitude() throws DbCityWrapperException {
        String regex = "Altitude<.*?([\\d]+).*?<";

        return Float.parseFloat(getMatch(regex, 1).replace(",", "").split("-")[0]);
    }

    @Override
    public String getClimate() throws DbCityWrapperException {
        String regex = "Climate<.*?>([\\w].*?)<";

        return getMatch(regex, 1);
    }

    @Override
    public String getTimezone() throws DbCityWrapperException {
        String regex = "Time zone.*?>(UTC)</abbr>(.*?)<";

        return getMatch(regex, 1);
    }

    @Override
    public String getWebsite() throws DbCityWrapperException {
        String regex = "Website<.*?href=\"(.*?)\"";

        return getMatch(regex, 1);
    }
    
    @Override
    public List<String> getTwinTowns() throws DbCityWrapperException {
        Scanner scanner = createScanner();

        Pattern pattern = Pattern.compile("(?:Twin towns, Sister cities</h2>(\\S+)|(?!^)\\G)(?:(?!\" title.*?>(.*?)</a>).)+(\" title.*?>(.*?)</a>)");

        List<String> list = new ArrayList<String>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String match = matcher.group(4);

                if(match.length() > 30) {
                    break;
                }

                list.add(match);
            }
        }

        scanner.close();

        if(list.isEmpty()) {
            throw new DbCityWrapperException("Data not found");
        }

        return list;
    }

    @Override
    public String getDemonym() throws DbCityWrapperException {
        //There is no possibility to get that data from DBCity.
        throw new DbCityWrapperException("Data not found");
    }

    @Override
    public String getPhoneNumber() throws DbCityWrapperException {
        String regex = "Phone<.*?><em class=\"internat\">([\\w].*?)<";

        return getMatch(regex, 1);
    }
}
