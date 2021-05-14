package persistence.xml;

import application.NominalFX;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.*;

public class XmlAPI {

    public void exportXml(String xml, String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        writer.write(xml);
        writer.close();
    }

    public void exportXmlWithDialog(String xml, String key, Stage stage) throws IOException {
        DirectoryChooser chooser = new DirectoryChooser();
        File file = chooser.showDialog(stage);
        if (file != null){
            exportXml(xml,String.format("%s%s%s",file.getPath(),System.getProperty("file.separator"),key));
        }
    }

}
