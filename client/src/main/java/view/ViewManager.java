package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class ViewManager {

    private final BaseController controller;
    private final Pane root;

    private final ArrayList<ViewController> viewControllers;

    public ViewManager(Pane root,BaseController baseController) {
        this.root = root;
        this.controller = baseController;
        this.viewControllers = new ArrayList<>();
    }

    public BaseController getController() {
        return controller;
    }

    public ArrayList<ViewController> getViewControllers() {
        return viewControllers;
    }

    private Parent loadView(String url) {
        Parent root = null;
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource(url));
            root = loader.load();
            ViewController viewController = loader.getController();
            viewController.setManager(this);
            viewController.run();
            this.viewControllers.add(viewController);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return root;
    }

    public void switchScenes(String url){
        Parent view = loadView(url);
        this.root.getChildren().clear();
        this.root.getChildren().add(view);
    }

}
