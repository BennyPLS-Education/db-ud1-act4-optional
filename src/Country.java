import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
@XmlRootElement(name = "país")
@XmlType(propOrder = {"name", "cities"})
public class Country {
    @XmlElement(name = "nom")
    private String name;
    @XmlElementWrapper(name = "ciutats")
    @XmlElement(name = "ciutat")
    private ArrayList<City> cities = new ArrayList<>();

    public Country(String name, ArrayList<City> capital) {
        this.name = name;
        this.cities = capital;
    }

    public Country() {}

    public void addCity(City city) {
        cities.add(city);
    }

    public City[] getCities() {
        return cities.toArray(new City[0]);
    }
}
