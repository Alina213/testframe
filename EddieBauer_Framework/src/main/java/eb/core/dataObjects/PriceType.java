package eb.core.dataObjects;


import eb.core.EnvironmentConfigProvider;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"priceId", "effort", "countryCode","priceType", "price", "startDate", "endDate"})
public class PriceType {

   private String priceId;
    private String effort;
    private  String countryCode;
    private  String priceType;
    private  String price;
    private String startDate;
    private  String endDate;

   public PriceType(){
        this.setPriceId();
    }

    @XmlElement(name = "PriceId")
    public String getPriceId() {
        return priceId;
    }


    public void setPriceId() {
        this.priceId = TestData.generateNextPriceId();

    }

    public String getEffort() {
        return effort;
    }

    @XmlElement(name = "effort")
    public void setEffort(String effort) {
        this.effort = effort;
    }

    @XmlElement(name = "CountryCode")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    /*public void setCountryCode() {
        if (EnvironmentConfigProvider.obtainCountryName().toString().equalsIgnoreCase(Country.US.getCountryName())) {
            this.countryCode = Country.US.getCountryName().toUpperCase();
        } else {
            this.countryCode = Country.CA.getCountryName().toUpperCase();
        }
    }*/


    public String getPriceType() {
        return priceType;
    }

    @XmlElement(name = "PriceType")
    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public String getPrice() {
        return price;
    }

    @XmlElement(name = "Price")
    public void setPrice(String price) {
        this.price = price;
    }

    public String getStartDate() {
        return startDate;
    }

    @XmlElement(name = "StartDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    @XmlElement(name = "EndDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
