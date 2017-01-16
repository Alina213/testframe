package eb.core.dataObjects;


import java.util.List;

public class InputParams {
    private String productId;
    private List<StyleColorData> styColorList;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<StyleColorData> getStyColorList() {
        return styColorList;
    }

    public void setStyColorList(List<StyleColorData> styColorList) {
        this.styColorList = styColorList;
    }

    @Override
    public String toString() {
        return "InputParams{" +
                "productId='" + productId + '\'' +
                ", styColorList=" + styColorList +
                '}';
    }
}
