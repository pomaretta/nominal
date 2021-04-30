/*

 Nominal Application
 Nominal Stage Manager

 @author     Carlos Pomares
 Date        2021-04-28

*/

package view;

import application.Views;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class StageManager {

    private final Stage primaryStage;
    private final LoaderManager loaderManager;

    public StageManager(Stage stage) {
        loaderManager = new LoaderManager();
        this.primaryStage = stage;
    }

    public void switchScenes(final Views view){
        Parent root = loadView(view.getFile());
        show(root,view.getTitle());
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private void show(final Parent root, String title){
        Scene scene = prepareScene(root);

        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);

        try {
            primaryStage.show();
        } catch (Exception e){
            Platform.exit();
        }
    }

    private Scene prepareScene(Parent root){
        Scene scene = primaryStage.getScene();

        if (scene == null) {
            scene = new Scene(root);
        }
        scene.setRoot(root);
        return scene;
    }

    private Parent loadView(String fxmlFilePath) {
        Parent rootNode = null;
        try {
            rootNode = this.loaderManager.load(fxmlFilePath,this);
            Objects.requireNonNull(rootNode, "A Root FXML node must not be null");
        } catch (Exception exception) {
            Platform.exit();
        }
        return rootNode;
    }

}
