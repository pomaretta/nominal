package application;

import common.company.Company;
import configuration.DatabaseDeveloper;
import javafx.application.Application;
import javafx.stage.Stage;
import optimization.Cache;
import persistence.auth.AuthAPI;
import persistence.image.ImageAPI;
import persistence.report.ReportAPI;
import persistence.service.NominalAPI;
import util.MD5;
import view.StageManager;

import java.sql.SQLException;
import java.util.ArrayList;

public class NominalFX extends Application {

    public static AuthAPI authAPI;
    public static NominalAPI nominalAPI;
    public static ReportAPI reportAPI;
    public static ImageAPI imageAPI;
    public static String configuration = System.getProperty("user.home") + System.getProperty("file.separator") + "nominal.xml";

    public static Cache cache;

    protected StageManager stageManager;

    @Override
    public void start(Stage stage) throws Exception {
        stageManager = new StageManager(stage);
        displayFirstView();
    }

    public void displayFirstView(){
        stageManager.switchScenes(Views.LOGIN);
    }

    public static void initializeServices(){
        try {
            nominalAPI = new NominalAPI(DatabaseDeveloper.NOMINAL.getURL(),DatabaseDeveloper.NOMINAL.getUser(),DatabaseDeveloper.NOMINAL.getPassword());
            reportAPI = new ReportAPI(DatabaseDeveloper.NOMINAL.getURL(),DatabaseDeveloper.NOMINAL.getUser(),DatabaseDeveloper.NOMINAL.getPassword());
            imageAPI = new ImageAPI(DatabaseDeveloper.IMAGE.getURL(),DatabaseDeveloper.IMAGE.getUser(),DatabaseDeveloper.IMAGE.getPassword());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            authAPI = new AuthAPI(DatabaseDeveloper.AUTH.getURL(), DatabaseDeveloper.AUTH.getUser(),DatabaseDeveloper.AUTH.getPassword());
        } catch (SQLException exception){
            //
        }
        cache = new Cache();
        launch(args);
    }

}
