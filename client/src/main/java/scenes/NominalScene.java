/*

 Nominal Application
 Nominal Scene

 @author     Carlos Pomares
 Date        2021-04-23

 Last revision
 Date        2021-04-24

*/

package scenes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.net.URL;

public abstract class NominalScene implements Scene {

    private final Parent root;
    private views.Manager viewManager;
    private Manager sceneManager;

    public NominalScene(URL xfmlFile) throws Exception {
        this.root = FXMLLoader.load(xfmlFile);
    }

    @Override
    public void bindManager(Manager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @Override
    public Parent getRoot() {
        return root;
    }

}
