import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NominalFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane,600,600);

        stage.setScene(scene);
        stage.setTitle("Nominal");
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
        //  Application application = Application.init(args);
        //  application.getApplicationManager().getStage().show();
    }
}
