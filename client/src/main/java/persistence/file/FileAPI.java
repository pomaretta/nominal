package persistence.file;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class FileAPI {

    public void saveToFile(HashMap<String,Object> data, String path,String comment) throws IOException {
        Properties properties = new Properties();
        OutputStream outputStream = new FileOutputStream(path);
        properties.putAll(data);
        properties.storeToXML(outputStream,comment);
    }

    public Properties getFromFile(String path) throws IOException {
        Properties properties = new Properties();
        properties.loadFromXML(new FileInputStream(path));
        return properties;
    }

}
