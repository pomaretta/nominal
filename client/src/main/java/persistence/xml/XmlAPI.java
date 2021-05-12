package persistence.xml;

import java.io.*;

public class XmlAPI {

    FileWriter writer;

    public void exportXml(String xml, String path) throws IOException {
        try {
            writer = new FileWriter(path);
            writer.write(xml);
        } finally {
            writer.close();
        }
    }

}
