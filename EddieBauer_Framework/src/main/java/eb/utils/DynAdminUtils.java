package eb.utils;


import eb.core.controls.DynAdminPage;
import org.w3c.dom.Document;

import javax.xml.transform.TransformerException;


public class DynAdminUtils {

    public static void dataSet(String testAreaText) throws Exception {
        DynAdminPage.get().getTextArea().sendKeys(testAreaText);
        DynAdminPage.get().getSubmitButton().click();
        DynAdminPage.get().getTextArea().clear();
    }


}
