package eb.core.dataObjects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "price_types" )
public class PriceTypes {
  private  List<PriceType> priceType;

    public PriceTypes() {
    }

    public PriceTypes(List<PriceType> priceType) {
        this.priceType = priceType;
    }

    public List<PriceType> getPriceType() {
        return priceType;
    }

    @XmlElement(name = "price_type" )
    public void setPriceType(List<PriceType> priceType) {
        this.priceType = priceType;
    }
}
