package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    static{

        try {
            String filePath = "configruation.properties";
            FileInputStream fis = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found");
        } catch (IOException e) {
            System.out.println("Could not be able to load property file");
        }
    }

    public static String getProperty(String key){            //qualityDemyUrl
        return properties.getProperty(key);                  //https://www.qualitydemy.com/
    }
}
