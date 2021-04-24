/*

 Nominal Application
 View Manager

 @author     Carlos Pomares
 Date        2021-04-23

*/

package views;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import scenes.NominalScene;

import java.util.ArrayList;

public class Manager {

    private final Parent root;
    private final scenes.Manager sceneManager;
    private NominalView currentView;
    private final ArrayList<NominalView> views;

    public Manager(Parent root, scenes.Manager sceneManager) {
        this.root = root;
        this.sceneManager = sceneManager;
        this.views = new ArrayList<>();
    }

    public Parent getRoot() {
        return root;
    }

    public scenes.Manager getSceneManager() {
        return sceneManager;
    }

    public NominalView getCurrentView() {
        return currentView;
    }

    public ArrayList<NominalView> getViews() {
        return views;
    }

    private void loadScene(){
        this.root.getChildrenUnmodifiable().add(this.currentView.getRoot());
    }

    private void unloadScene(){
        this.root.getChildrenUnmodifiable().clear();
    }

    public void removeScene(NominalView view){
        if(currentView.equals(view)){
            unloadScene();
        }
        this.views.remove(view);
    }

    private void registerScene(NominalView view)
            throws Exception{
        if(this.views.contains(view)){
            throw new Exception("Already in scenes.");
        }
        this.views.add(view);
        view.bindManager(this);
    }

    public void changeScene(NominalView view)
            throws Exception {
        if(!this.views.contains(view)){
            throw new Exception("Not in scenes.");
        }
        unloadScene();
        this.currentView = view;
        loadScene();
    }

}
