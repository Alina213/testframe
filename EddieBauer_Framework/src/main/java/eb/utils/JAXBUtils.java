package eb.utils;


import eb.core.dataObjects.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

public class JAXBUtils {

    public static void marshalling() throws JAXBException, IOException {
        JAXBContext contextObj = JAXBContext.newInstance(EBPriceFeed.class);
        Marshaller jaxbMarshaller = contextObj.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(TestData.generatePriceFeed(), new File("C:/Users/Alina_Piryatinets/Desktop/priceFeed.xml"));
      // jaxbMarshaller.marshal(TestData.generatePriceFeed(), System.out);


    }

}
