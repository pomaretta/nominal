package controllers;

import application.NominalFX;
import application.Views;
import common.auth.User;
import common.company.Company;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import persistence.auth.AuthenticationException;
import util.MD5;
import view.BaseController;
import view.ViewController;
import view.ViewManager;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeController extends BaseController implements Initializable {

    private double xOffset, yOffset;

    @FXML
    private AnchorPane root;

    @FXML
    private Pane contentPane;

    @FXML
    private ImageView avatar;

    @FXML
    private Label userName;

    @FXML
    private Button overviewButton;
    @FXML
    private Button companyButton;
    @FXML
    private Button employeeButton;
    @FXML
    private Button settingsButton;

    private ViewManager formManager;

    @FXML
    private ComboBox companySelector;

    private ObservableList<String> items;
    private ArrayList<Company> companies;

    private Company currentCompany;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // When this controller in called with the stage manager calls this function.
        Font.loadFont(getClass().getResourceAsStream("/fonts/Poppings-Bold.ttf"),12);
        Font.loadFont(getClass().getResourceAsStream("/fonts/Poppings-Light.ttf"),12);
        Font.loadFont(getClass().getResourceAsStream("/fonts/Poppings-Medium.ttf"),12);
        Font.loadFont(getClass().getResourceAsStream("/fonts/Poppings-Regular.ttf"),12);

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                xOffset = mouseEvent.getSceneX();
                yOffset = mouseEvent.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stageManager.getPrimaryStage().setX(mouseEvent.getScreenX() - xOffset);
                stageManager.getPrimaryStage().setY(mouseEvent.getScreenY() - yOffset);
            }
        });

        this.userName.setText(NominalFX.authAPI.getLogedUser().getName());

        formManager = new ViewManager(this.contentPane,this);

        try {
            this.items = FXCollections.observableArrayList();
            this.companies = NominalFX.nominalAPI.getCompaniesMinimal();
            for(Company c : this.companies){
                items.add(c.getName());
            }
            companySelector.setItems(items);
        } catch (Exception e){
            //
        }

        this.companyButton.setDisable(true);
        this.employeeButton.setDisable(true);

    }

    private void allowConfiguration(){
        this.companyButton.setDisable(false);
        this.employeeButton.setDisable(false);
    }

    @FXML
    public void companyHandler(){
        this.formManager.switchScenes("/fxml/company/company_creation.fxml");
    }

    @FXML
    public void employeeHandler(){
        this.formManager.switchScenes("/fxml/employee/employee_creation.fxml");
    }

    @FXML
    public void logoutHandler(){
        this.stageManager.switchScenes(Views.LOGIN);
    }

    @FXML
    public void check(ActionEvent actionEvent){
        Button button = (Button) actionEvent.getSource();
        if (!button.getStyleClass().contains("active")){
            overviewButton.getStyleClass().remove("active");
            companyButton.getStyleClass().remove("active");
            employeeButton.getStyleClass().remove("active");
            settingsButton.getStyleClass().remove("active");
            button.getStyleClass().add("active");
        }
    }

    @FXML
    public void companySelection() throws SQLException {
        if(NominalFX.cache.containsCompany(this.companies.get(this.companySelector.getSelectionModel().getSelectedIndex()).getId())){
            this.currentCompany = NominalFX.cache.getCompanyById(this.companies.get(this.companySelector.getSelectionModel().getSelectedIndex()).getId());
            for (ViewController c : this.formManager.getViewControllers()){
                c.shouldUpdate();
            }
            allowConfiguration();
        } else {
            NominalFX.cache.add(NominalFX.nominalAPI.getCompanyById(this.companies.get(this.companySelector.getSelectionModel().getSelectedIndex()).getId()),NominalFX.cache.getCompanies());
            companySelection();
        }
    }

    public Company getCurrentCompany() {
        return currentCompany;
    }

}
