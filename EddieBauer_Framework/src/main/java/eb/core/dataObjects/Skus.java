package eb.core.dataObjects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name = "Skus")
@XmlAccessorType(XmlAccessType.FIELD)
public class Skus {
    @XmlElement(name = "Sku")
    private List<Sku> sku;

    public List<Sku> getSku() {
        return sku;
    }

    public void setSku(List<Sku> sku) {
        this.sku = sku;
    }
}
