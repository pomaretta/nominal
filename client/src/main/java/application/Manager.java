/*

 Nominal Application
 Application Manager

 @author     Carlos Pomares
 Date        2021-04-23

*/

package application;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import scenes.NominalScene;

import java.util.ArrayList;
import java.util.Collection;

public class Manager extends Application {

    private Stage stage;
    private Parent root;
    private Collection<Scene> scenes;
    private NominalScene scene;

    @Override
    public void start(Stage stage) throws Exception {
        // ASSIGN
        this.stage = stage;
        this.root = new AnchorPane();
        this.scenes = new ArrayList<>();
        // this.scene = new NominalScene();
    }

    public Stage getStage() {
        return stage;
    }

}
