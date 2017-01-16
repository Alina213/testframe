package eb.core.dataObjects;


import eb.core.EnvironmentConfigProvider;
import eb.utils.JsonUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestData {

    private static long currentId = System.currentTimeMillis();
    public static String generateNextPriceId(){
        return Long.toString(currentId++);
    }

    public static String generateIdRandomly() {
        final String numbers = "0123456789";

        final java.util.Random rand = new java.util.Random();
        StringBuilder phone = new StringBuilder();
        for (int i = 0; i < 9; i++)
            phone.append(numbers.charAt(rand.nextInt(numbers.length())));
        return phone.toString();
    }

    public static List<Sku> getSku() throws IOException {
        List<Sku> skuList = new ArrayList<Sku>();
        JSONArray skus = JsonUtils.getInputDataJSONObject(EnvironmentConfigProvider.obtainInputDataPathValue()).getJSONArray("sku");
        for (int i = 0; i < skus.length(); i++) {
            JSONObject skuJsonObject = skus.getJSONObject(i);
            JSONObject skuTestData = JsonUtils.getTestDataJSONObject("testData");
            PriceTypes priceTypes = new PriceTypes(getPriceTypeList(skuJsonObject.getJSONArray("priceTypes"), skuTestData));
            Sku sku = new Sku();
            if (skuJsonObject.has("skuId")) {
                sku.setSkuId(skuJsonObject.getString("skuId"));
            }
            if (skuTestData.has("ReferenceId")) {
                sku.setReferenceId(skuTestData.getString("ReferenceId"));
            }
            if (skuTestData.has("style")) {
                sku.setStyle(skuTestData.getString("style"));
            }
            if (skuTestData.has("EOB")) {
                sku.setEob(skuTestData.getString("EOB"));
            }
            if (skuJsonObject.has("priceTypes")) {
                sku.setPriceTypes(priceTypes);
            }
            skuList.add(sku);
        }

        return skuList;

    }

    public static List<PriceType> getPriceTypeList(JSONArray array, JSONObject testData) throws IOException {
        List<PriceType> priceTypeList = new ArrayList<PriceType>();
        for (int i = 0; i < array.length(); i++) {
            JSONObject priceTypeInputData = array.getJSONObject(i);
            JSONObject priceTypeTestData = testData;
            PriceType priceType = new PriceType();

            if (priceTypeInputData.has("effort")) {
                priceType.setEffort(priceTypeInputData.getString("effort"));
            }
            if (priceTypeInputData.has("priceType")) {
                priceType.setPriceType(priceTypeInputData.getString("priceType"));
            }
            if (priceTypeInputData.has("Price")) {
                priceType.setPrice(priceTypeInputData.getString("Price"));
            }
            if(priceTypeTestData.has("StartDate")){
                priceType.setStartDate(priceTypeTestData.getString("StartDate"));
            }
            if(priceTypeTestData.has("EndDate")){
                priceType.setEndDate(priceTypeTestData.getString("EndDate"));
            }
            priceTypeList.add(priceType);
        }
        return priceTypeList;
    }

    public static EBPriceFeed generatePriceFeed() throws IOException {
        EBPriceFeed xml = new EBPriceFeed();
        Skus skus = new Skus();
        skus.setSku(getSku());
        xml.setSkus(skus);

        return xml;
    }
}

