/*

 Nominal Application
 Scene Manager

 @author     Carlos Pomares
 Date        2021-04-23

*/

package scenes;

import application.Application;
import javafx.stage.Stage;

public class Manager {

    private final Stage stage;
    private final Application toManage;
    private NominalScene currentScene;

    public Manager(Stage stage, Application toManage) {
        this.stage = stage;
        this.toManage = toManage;
    }

}
