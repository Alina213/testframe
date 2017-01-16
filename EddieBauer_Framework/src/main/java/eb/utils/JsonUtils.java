package eb.utils;

import com.google.gson.Gson;
import eb.core.PropertiesProcessor;
import eb.core.dataObjects.InputParams;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;


public class JsonUtils {
    public static String testDataPath = PropertiesProcessor.getConfigurationFolderPath() + "testdata/";

    public static JSONObject getTestDataJSONObject(String fileName) throws IOException, JSONException {

        String absolutePath = testDataPath + fileName;

        InputStream file = null;
        try {
            file = new FileInputStream(absolutePath);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Cannot find '" + fileName + " file.");
        }
        JSONTokener tokener = new JSONTokener(file);
        JSONObject objectJSON = new JSONObject(tokener);
        return objectJSON;

    }

    public static JSONObject getInputDataJSONObject(String pathFile) throws IOException, JSONException {
        InputStream file = null;
        try {
            file = new FileInputStream(pathFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONTokener tokener = new JSONTokener(file);
        JSONObject objectJSON = new JSONObject(tokener);
        return objectJSON;
    }

    public static InputParams getGsonObject(String pathFile) throws FileNotFoundException {
      // String absolutePath = testDataPath + pathFile;
        Gson gson = new Gson();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(pathFile));

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Cannot find '" + pathFile + " file.");
        }
        InputParams gsonObject = gson.fromJson(br, InputParams.class);
        return gsonObject;
    }
}
