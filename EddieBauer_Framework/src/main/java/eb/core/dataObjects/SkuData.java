package eb.core.dataObjects;


public class SkuData {
    private String skuId;
    private String style;
    private String color;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "SkuData{" +
                "skuId='" + skuId + '\'' +
                ", style='" + style + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
