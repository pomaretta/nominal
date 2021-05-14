package application;

import configuration.DatabaseDeveloper;
import error.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import optimization.Cache;
import persistence.auth.AuthAPI;
import persistence.file.FileAPI;
import persistence.image.ImageAPI;
import persistence.report.ReportAPI;
import persistence.service.NominalAPI;
import persistence.xml.XmlAPI;
import view.StageManager;

import org.apache.commons.cli.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

public class NominalFX extends Application {

    public static FileAPI fileAPI;
    public static AuthAPI authAPI;
    public static NominalAPI nominalAPI;
    public static ReportAPI reportAPI;
    public static ImageAPI imageAPI;
    public static XmlAPI xmlAPI;

    // CONFIG
    public static String credentials;
    public static String configurationPath = System.getProperty("user.home") + System.getProperty("file.separator") + "nominal.xml";

    public static Properties configuration;

    public static Cache cache;
    public static Logger logger;

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
            xmlAPI = new XmlAPI();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {

        fileAPI = new FileAPI();

        logger = new Logger();

        try {
            configuration = fileAPI.getFromFile(configurationPath);
        } catch (IOException e){
            HashMap<String,Object> data = new HashMap<>();
            data.put("version","1.0");
            fileAPI.saveToFile(data,configurationPath,"Nominal Configuration");
        }

        try {
            authAPI = new AuthAPI(DatabaseDeveloper.AUTH.getURL(), DatabaseDeveloper.AUTH.getUser(),DatabaseDeveloper.AUTH.getPassword());
        } catch (SQLException exception){
            logger.add("AUTH FAILED");
        }

        cache = new Cache();

        Options options = new Options();

        Option conf = new Option("c","configuration",true,"Configuration file");
        conf.setRequired(false);
        options.addOption(conf);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter helpFormatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options,args);
            credentials = cmd.getOptionValue("configuration");
        } catch (ParseException p){
            // ignore
            helpFormatter.printHelp("utility-name",options);
        } catch (Exception e){
            // ignore
        }

        launch(args);
    }

}
