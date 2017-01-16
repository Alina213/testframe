package eb.core.dataObjects;

import java.util.List;

/**
 * Created by Alina_Piryatinets on 4/26/2016.
 */
public class StyleColorData {

    private String styleColor;
    private List<PriceTypeInputData> priceTypes;

    public String getStyleColor() {
        return styleColor;
    }

    public void setStyleColor(String styleColor) {
        this.styleColor = styleColor;
    }

    public List<PriceTypeInputData> getPriceTypes() {
        return priceTypes;
    }

    public void setPriceTypes(List<PriceTypeInputData> priceTypes) {
        this.priceTypes = priceTypes;
    }

    @Override
    public String toString() {
        return "StyleColorData{" +
                "styleColor='" + styleColor + '\'' +
                ", priceTypes=" + priceTypes +
                '}';
    }
}
