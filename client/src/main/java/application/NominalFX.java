/*

 Nominal Application
 Nominal FX MAIN

 @author     Carlos Pomares
 Date        2021-04-28

*/

package application;

import configuration.DatabaseDeveloper;
import javafx.application.Application;
import javafx.stage.Stage;
import persistence.auth.AuthAPI;
import persistence.service.NominalAPI;
import util.MD5;
import view.StageManager;

import java.sql.SQLException;

public class NominalFX extends Application {

    public static AuthAPI authAPI;
    public static NominalAPI nominalAPI;

    protected StageManager stageManager;

    @Override
    public void start(Stage stage) throws Exception {
        stageManager = new StageManager(stage);
        displayFirstView();
    }

    public void displayFirstView(){
        stageManager.switchScenes(Views.LOGIN);
    }

    public static void main(String[] args) throws Exception {

        try {
            authAPI = new AuthAPI(DatabaseDeveloper.AUTH.getURL(), DatabaseDeveloper.AUTH.getUser(),DatabaseDeveloper.AUTH.getPassword());
        } catch (SQLException exception){
            //
        }

        launch(args);
    }

}
