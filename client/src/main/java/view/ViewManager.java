/*

 Nominal Application
 Nominal Views Manager

 @author     Carlos Pomares
 Date        2021-04-28

*/

package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ViewManager {

    private final BaseController controller;
    private final Parent root;

    public ViewManager(Parent root,BaseController baseController) {
        this.root = root;
        this.controller = baseController;
    }

    public BaseController getController() {
        return controller;
    }

    private void switchScenes(String url){
        Parent view = loadView(url);
        this.root.getChildrenUnmodifiable().clear();
        this.root.getChildrenUnmodifiable().add(view);
    }

    private Parent loadView(String url) {
        Parent root = null;
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource(url));
            root = loader.load();
            ViewController viewController = loader.getController();
            viewController.setManager(this);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return root;
    }

}
