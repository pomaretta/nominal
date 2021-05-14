package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class LoaderManager {

    public Parent load(String fxmlPath,StageManager manager) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        BaseController controller = loader.getController();
        controller.setManager(manager);
        return root;
    }

}
