import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ciutat")
@XmlType(propOrder = {"id", "name", "district", "population"})
public class City {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "ciutat")
    private String name;
    @XmlElement(name = "districte")
    private String district;
    @XmlElement(name = "poblacio")
    private String population;

    public City(int id, String name, String district, String population) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.population = population;
    }

    public City() {}
}
