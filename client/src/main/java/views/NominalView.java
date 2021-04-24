/*

 Nominal Application
 Nominal View

 @author     Carlos Pomares
 Date        2021-04-23

*/

package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.net.URL;

public class NominalView implements View {

    private final Parent root;
    private views.Manager manager;

    public NominalView(URL url) throws Exception {
        this.root = FXMLLoader.load(url);
    }

    @Override
    public Parent getRoot() {
        return root;
    }

    public Manager getManager() {
        return manager;
    }

    @Override
    public void bindManager(views.Manager viewManager) {
        this.manager = viewManager;
    }

}
