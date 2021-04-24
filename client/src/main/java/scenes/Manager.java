/*

 Nominal Application
 Scene Manager

 @author     Carlos Pomares
 Date        2021-04-23

*/

package scenes;

import application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Manager {

    private final Stage stage;
    private final javafx.scene.Scene scene;
    private final Application toManage;
    private NominalScene currentScene;
    private final ArrayList<NominalScene> scenes;

    private int prefHeight,prefWidth;

    public Manager(Stage stage, Application toManage,int prefHeight,int prefWidth) {
        this.stage = stage;
        this.toManage = toManage;
        this.prefHeight = prefHeight;
        this.prefWidth = prefWidth;
        this.scene = new javafx.scene.Scene(new AnchorPane(),this.prefHeight,this.prefWidth);
        this.scenes = new ArrayList<>();
    }

    public Stage getStage() {
        return stage;
    }

    public Scene getScene() {
        return scene;
    }

    public Application getToManage() {
        return toManage;
    }

    public NominalScene getCurrentScene() {
        return currentScene;
    }

    public ArrayList<NominalScene> getScenes() {
        return scenes;
    }

    public int getPrefHeight() {
        return prefHeight;
    }

    public int getPrefWidth() {
        return prefWidth;
    }

    public void setPrefHeight(int prefHeight) {
        this.prefHeight = prefHeight;
    }

    public void setPrefWidth(int prefWidth) {
        this.prefWidth = prefWidth;
    }

    private void loadScene(){
        this.scene.setRoot(getCurrentScene().getRoot());
    }

    private void unloadScene(){
        this.scene.setRoot(new AnchorPane());
    }

    public void removeScene(NominalScene scene){
        if(currentScene.equals(scene)){
            unloadScene();
        }
        this.scenes.remove(scene);
    }

    private void registerScene(NominalScene scene)
            throws Exception{
        if(this.scenes.contains(scene)){
            throw new Exception("Already in scenes.");
        }
        this.scenes.add(scene);
        scene.bindManager(this);
    }

    public void changeScene(NominalScene scene)
            throws Exception {
        if(!this.scenes.contains(scene)){
            throw new Exception("Not in scenes.");
        }
        this.currentScene = scene;
        loadScene();
    }

}
