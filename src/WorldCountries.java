import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlRootElement(name = "PaïsosDelMón")
@XmlType(propOrder = {"count", "countries"})
public class WorldCountries {
    @XmlElementWrapper(name = "països")
    @XmlElement(name = "país")
    private final ArrayList<Country> countries = new ArrayList<>();

    public WorldCountries() {}

    public void addCountry(Country country) {
        countries.add(country);
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    @XmlElement(name = "recompta")
    public int getCount() {
        return countries.size();
    }

}
