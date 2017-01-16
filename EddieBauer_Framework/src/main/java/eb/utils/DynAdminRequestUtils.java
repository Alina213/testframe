package eb.utils;

import org.w3c.dom.Document;

public class DynAdminRequestUtils {

    public static String queryItem(String itemDescrName, String fieldName, String fieldValue){
        StringBuilder sb = new StringBuilder();
        sb.append("<query-items item-descriptor=\"")
                .append(itemDescrName)
                .append("\">")
                .append(fieldName)
                .append("=\"")
                .append(fieldValue)
                .append("\"</query-items>");
        return sb.toString();
    }


}
