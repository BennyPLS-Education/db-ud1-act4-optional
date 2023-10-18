import javax.xml.bind.JAXB;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private static final String CITIES_FILE = "cities.txt";
    private static final WorldCountries worldCountries = new WorldCountries();

    public static void main(String[] args) {
        csvReader();

        try (var writer = new FileWriter("countries.xml")) {
            JAXB.marshal(worldCountries, writer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    static void csvReader() {
        String[] lines = null;
        try (var reader = new BufferedReader(new FileReader(CITIES_FILE))) {
            lines = reader.lines().toArray(String[]::new);
        } catch (IOException ignore) {
            System.out.println("File not found");
            System.exit(1);
        }

        ArrayList<City> cities = new ArrayList<>();
        String lastCountry = lines[0].split(";")[1];
        for (String line : lines) {
            String[] tokens = line.split(";");

            if (!lastCountry.equals(tokens[1])) {
                worldCountries.addCountry(new Country(tokens[1], cities));
                cities = new ArrayList<>();
                lastCountry = tokens[1];
            }

            City city = parseCityFromLine(tokens);
            cities.add(city);
        }
    }

    static City parseCityFromLine(String[] tokens) {
        City city;

        if (tokens.length != 5) {
            System.out.println("Invalid number of tokens");
            throw new IllegalArgumentException("Invalid number of tokens");
        }

        if (tokens[3].equals("–")) {
            tokens[3] = null;
        }

        city = new City(Integer.parseInt(tokens[0]), tokens[2], tokens[3], tokens[4]);

        return city;
    }
}