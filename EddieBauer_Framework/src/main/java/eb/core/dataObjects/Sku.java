package eb.core.dataObjects;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Sku")
@XmlType(name="", propOrder={"skuId", "referenceId", "style","eob", "priceTypes"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Sku {

    @XmlElement(name = "sku_id")
    private String skuId;
    @XmlElement(name = "ReferenceId")
    private String referenceId;
    @XmlElement(name = "style")
    private String style;
    @XmlElement(name = "EOB")
    private String eob;
    @XmlElement(name = "price_types")
    private PriceTypes priceTypes;


    public String getReferenceId() {
        return referenceId;
    }


    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getStyle() {
        return style;
    }


    public void setStyle(String style) {
        this.style = style;
    }

    public String getEob() {
        return eob;
    }


    public void setEob(String eob) {
        this.eob = eob;
    }

    public PriceTypes getPriceTypes() {
        return priceTypes;
    }

    public void setPriceTypes(PriceTypes priceTypes) {
        this.priceTypes = priceTypes;
    }


    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }
}
