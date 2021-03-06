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
import project.model.wrapper.exceptions.WikipediaWrapperException;

public class WikipediaWrapper implements IWrapper {

    private String cityName;
    private String countryName;
    private String fileName;

    public WikipediaWrapper(String cityName, String countryName) throws IOException {
        this.cityName = cityName;
        this.countryName = countryName;

        this.makeWikipediaRequest();
    }

    /**
     * Make request to Wikipedia with cityName as a query
     */
    private void makeWikipediaRequest() throws IOException {
        String link = "https://en.wikipedia.org/wiki/";

        this.fileName = "wikipedia_" + this.cityName;

        HttpRequestHelper.httpRequest1(link, this.cityName, this.fileName);
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

    private String getMatch(String regex, int group) throws WikipediaWrapperException {
        Scanner scanner = createScanner();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        try {
            matcher = findPattern(scanner, pattern);
        }
        catch (NoSuchElementException e) {
            throw new WikipediaWrapperException("Data not found");
        }

        scanner.close();

        return matcher.group(group);
    }

    @Override
    public String getName() throws WikipediaWrapperException {
        return this.cityName;
    }

    @Override
    public String getCountry() {
        return this.countryName;
    }

    @Override
    public boolean isCapital() throws WikipediaWrapperException {
        Scanner scanner = createScanner();

        Pattern pattern = Pattern.compile("class=\"category\".*?>(Capital city)");

        try {
            findPattern(scanner, pattern);
        }
        catch (NoSuchElementException e) {
            //Here we can assume that if nothing matching pattern was found, the city
            //simply isn't a capital.
            return false;
        }

        scanner.close();

        return true;
    }

    @Override
    public String getCountryFlag() throws WikipediaWrapperException {
        //Since there is not way to reliably get that data from Wikipedia city
        //page, we will simply throw this error every time.
        //We could however find that in country's page, but thats out of scope here.
        throw new WikipediaWrapperException("Data not found");
    }

    @Override
    public List<String> getCountryLanguages() throws WikipediaWrapperException {
        //Since there is not way to reliably get that data from Wikipedia city
        //page, we will simply throw this error every time.
        //We could however find that in country's page, but thats out of scope here.
        throw new WikipediaWrapperException("Data not found");
    }
    

    @Override
    public String getCityFlag() throws WikipediaWrapperException {
        String regex = "class=\"ib-settlement-cols-cell\".*?Flag.*?src=\"(.*?)\"";

        return getMatch(regex, 1);
    }

    @Override
    public List<String> getCityLandmarks() throws WikipediaWrapperException {
        Scanner scanner = createScanner();

        Pattern pattern = Pattern.compile("(?:class=\\\"category\\\"(\\S+)|(?!^)\\G)(?:(?!src=\\\"(.*?)\\\").)+(src=\\\".*?\\\")"); //Iloveregex

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
            throw new WikipediaWrapperException("Data not found");
        }

        return list;
    }

    @Override
    public float getArea() throws WikipediaWrapperException {
        String regex = "Area.*?>([0-9][0-9,.]+).*?km";

        return Float.parseFloat(getMatch(regex, 1).replace(",", ""));
    }

    @Override
    public int getInhabitants() throws WikipediaWrapperException {
        String regex = "Population<.*?<td class=\"infobox-data\">(\\d+,\\d*[,*\\d*]*).?<";

        return Integer.parseInt(getMatch(regex, 1).replace(",", ""));
    }

    @Override
    public float getPopulationDensity() throws WikipediaWrapperException {
        String regex = "Density.*?>([0-9\\\\,]+).*?km";

        return Float.parseFloat(getMatch(regex, 1).replace(",", ""));
    }

    @Override
    public String getPostalCode() throws WikipediaWrapperException {
        String regex = "class=\"postal-code\".*>(.*?)</div>";

        return getMatch(regex, 1);
    }

    @Override
    public String getMayorName() throws WikipediaWrapperException {
        String regex = "Mayor<.*?>([A-Z].*?)<";

        return getMatch(regex, 1);
    }

    @Override
    public String getLatitude() throws WikipediaWrapperException {
        String regex = "class=\\\"latitude\\\">(.*?)<";

        return getMatch(regex, 1);
    }

    @Override
    public String getLongitude() throws WikipediaWrapperException {
        String regex = "class=\\\"longitude\\\">(.*?)<";

        return getMatch(regex, 1);
    }

    @Override
    public float getAltitude() throws WikipediaWrapperException {
        String regex = "[eE]levation<.*?<td class=\"infobox-data\">.*?(\\d*?[???\\d]*?)\\&#160;m";

        return Float.parseFloat(getMatch(regex, 1).replace(",", "").split("???")[0]);
    }

    @Override
    public String getClimate() throws WikipediaWrapperException {
        //Since there is not way to reliably get that data from Wikipedia city
        //page, we will simply throw this error every time.
        //We could however find that in country's page, but thats out of scope here.
        throw new WikipediaWrapperException("Data not found");
    }

    @Override
    public String getTimezone() throws WikipediaWrapperException {
        String regex = "Time zone.*?title=\\\"(.*?)\\\"";

        return getMatch(regex, 1);
    }

    @Override
    public String getWebsite() throws WikipediaWrapperException {
        String regex = "Website.*?\" href=\"(.*?)\">";

        return getMatch(regex, 1);
    }

    @Override
    public List<String> getTwinTowns() throws WikipediaWrapperException {
        //Since there is not way to reliably get that data from Wikipedia city
        //page, we will simply throw this error every time.
        //We could however find that in country's page, but thats out of scope here.
        throw new WikipediaWrapperException("Data not found");
    }

    @Override
    public String getPhoneNumber() throws WikipediaWrapperException {
        //Since there is not way to reliably get that data from Wikipedia city
        //page, we will simply throw this error every time.
        throw new WikipediaWrapperException("Data not found");
    }

    @Override
    public String getDemonym() throws WikipediaWrapperException {
        String regex = "Demonym\\(s\\)<.*?>([\\w].*?)<";

        return getMatch(regex, 1);
    }
}
