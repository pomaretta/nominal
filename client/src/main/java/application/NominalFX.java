/*

 Nominal Application
 Nominal FX MAIN

 @author     Carlos Pomares
 Date        2021-04-28

*/

package application;

import javafx.application.Application;
import javafx.stage.Stage;
import view.StageManager;

public class NominalFX extends Application {

    protected StageManager stageManager;

    @Override
    public void start(Stage stage) throws Exception {
        stageManager = new StageManager(stage);
        displayFirstView();
    }

    public void displayFirstView(){
        stageManager.switchScenes(Views.MAIN);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
