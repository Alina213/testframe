package eb;

import eb.core.BaseTest;
import eb.core.BrowserStart;
import eb.core.EnvironmentConfigProvider;
import eb.core.Selenium;
import eb.core.controls.DynAdminPage;
import eb.core.dataObjects.*;
import eb.utils.DynAdminRequestUtils;
import eb.utils.DynAdminUtils;
import eb.utils.JsonUtils;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class Test1 extends BaseTest {

    @Test
    public void test1() throws Exception {
        InputParams inputParams = JsonUtils.getGsonObject(EnvironmentConfigProvider.obtainInputDataPathValue());
        BrowserStart.openDynAdminPage();
        //Query all SKUs under this product, result in DynAdminPage
        DynAdminUtils.dataSet(DynAdminRequestUtils.queryItem("sku", "parentProducts", inputParams.getProductId()));

        //All the SKUs grouped by style+color
        Map<String,List<SkuData>> productData = DynAdminPage.getListSkuByProductId();
        //Generating feed
        EBPriceFeed xml = new EBPriceFeed();
        Skus skus = new Skus();
        List<Sku> skuList = new ArrayList<>();
        skus.setSku(skuList);
        xml.setSkus(skus);
        for (StyleColorData styleColorData : inputParams.getStyColorList()){
            List<SkuData> skusToProcess =  productData.get(styleColorData.getStyleColor());

            if (skusToProcess != null && !skusToProcess.isEmpty()){
                for (SkuData curSkuToProc : skusToProcess){
                    Sku skuFeedBean = new Sku();
                    skuFeedBean.setSkuId(curSkuToProc.getSkuId() + "123");
                    skuFeedBean.setReferenceId("123123123");
                    skuFeedBean.setStyle("123123");
                    skuFeedBean.setEob("F");
                    if (styleColorData.getPriceTypes() != null && !styleColorData.getPriceTypes().isEmpty()){
                        PriceTypes priceTypes = new PriceTypes();
                        List<PriceType> priceTypeList = new ArrayList<>();
                        for (PriceTypeInputData priceTypeInputData : styleColorData.getPriceTypes()){
                            PriceType priceType = new PriceType();
                            priceType.setCountryCode(priceTypeInputData.getCountryCode());
                            priceType.setPriceType(priceTypeInputData.getPriceType());
                            priceType.setEffort(priceTypeInputData.getEffort());
                            priceType.setPrice(priceTypeInputData.getPrice());
                            priceType.setStartDate(priceTypeInputData.getStartDate());
                            priceType.setEndDate(priceTypeInputData.getEndDate());
                            priceType.setPriceId();
                            priceTypeList.add(priceType);
                        }
                        priceTypes.setPriceType(priceTypeList);
                        skuFeedBean.setPriceTypes(priceTypes);
                    }
                    skuList.add(skuFeedBean);
                }


            } else {
                //TODO add logging here
            }
        }
        //Saving results
        JAXBContext contextObj = JAXBContext.newInstance(EBPriceFeed.class);
        Marshaller jaxbMarshaller = contextObj.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        Date resultdate = new Date(System.currentTimeMillis());
        jaxbMarshaller.marshal(xml, new File("C:/Users/Administrator/Desktop/" + resultdate + "priceFeed.xml"));
        System.out.println("");
      //  PageFactory.initElements(new HtmlElementDecorator(Selenium.getWebDriver()), this);



    }


}
