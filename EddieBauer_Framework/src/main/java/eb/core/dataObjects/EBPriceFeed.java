package eb.core.dataObjects;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "EBPriceFeed")
@XmlSeeAlso({EBPriceFeed.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class EBPriceFeed {

    @XmlElement(name = "Skus")
    private Skus skus;

    public Skus getSkus() {
        return skus;
    }

    public void setSkus(Skus skus) {
        this.skus = skus;
    }
}
