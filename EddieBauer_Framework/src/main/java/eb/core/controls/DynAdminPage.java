package eb.core.controls;


import eb.core.dataObjects.SkuData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynAdminPage extends BasePage {

    private static DynAdminPage page;

    public static DynAdminPage get() {
        if (page == null) {
            page = new DynAdminPage();
        }
        return page;
    }

    @FindBy(css = "textarea")
    private WebElement textArea;

    @FindBy(css="form input[value='Enter']")
    private WebElement submitButton;

    @FindBy(css="code")
    private WebElement resultOfQuery;

    public WebElement getTextArea() {
        return textArea;
    }

    public void setTextArea(WebElement textArea) {
        this.textArea = textArea;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(WebElement submitButton) {
        this.submitButton = submitButton;
    }

    public WebElement getResultOfQuery() {
        return resultOfQuery;
    }

    public void setResultOfQuery(WebElement resultOfQuery) {
        this.resultOfQuery = resultOfQuery;
    }

    public static Map<String,List<SkuData>> getListSkuByProductId() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(DynAdminPage.get().getResultOfQuery().getText()));
        // key = style+color, value = list of such SKUs
        Map<String, List<SkuData>> skus = new HashMap<>();
        SkuData currentSku = null;
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            if (line == null){
                break;
            }
            line = line.trim();
            if (currentSku != null){
                if (line.startsWith("</add-item>")){
                    String styleColor = currentSku.getStyle() + "_" + currentSku.getColor();
                    List<SkuData> skuDatas;
                    if (skus.containsKey(styleColor)){
                        skuDatas = skus.get(styleColor);
                    } else {
                        skuDatas = new ArrayList<>();
                    }
                    skuDatas.add(currentSku);
                    skus.put(styleColor, skuDatas);
                    currentSku = null;
                    continue;
                }
                if (line.contains("name=\"colorId\"")){
                    int colorInd = line.indexOf("CDATA[");
                    String color = line.substring(colorInd + 6, line.length() - 18);
                    currentSku.setColor(color);
                } else if (line.contains("name=\"styleId\"")) {
                    int styleInd = line.indexOf("CDATA[");
                    String styleId = line.substring(styleInd + 6, line.length() - 18);
                    currentSku.setStyle(styleId);
                }
            } else if (line.startsWith("<add-item")){
                currentSku = new SkuData();
                int idStartIndex = line.indexOf("id=");
                String skuId = line.substring(idStartIndex + 4, line.length() - 2);
                currentSku.setSkuId(skuId);
            }

        }
       return skus;


    }

}
