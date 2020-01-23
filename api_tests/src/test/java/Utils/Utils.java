package Utils;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Utils {
    public String propFileName = "config.properties";
    public String host = "";

    public JSONObject getJSONData(String filePath)
    {
        return new JSONObject(new Scanner(Utils.class.getClassLoader().getResourceAsStream(filePath)).useDelimiter("\\Z").next());
    }

    public Utils(){
        host = getHost();
    }

    public String getHost(){
        try {
            Properties properties = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            properties.load(inputStream);
            return properties.getProperty("host");
        }
        catch (IOException e){
            System.out.println(" Fail read of properties file ");
        }
        return null;

    }
}
