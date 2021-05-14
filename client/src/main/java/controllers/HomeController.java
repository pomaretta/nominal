/*
 Nominal Application
 Home

 Date        2021-04-23

 Last revision
 Date        2021-04-23

 Description:
 The HomeContoller class is a controller
 for the main_view fxml file.

*/

package controllers;

import application.NominalFX;
import application.Views;
import common.agreement.Agreement;
import common.auth.User;
import common.company.Company;
import common.company.Currency;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
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
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController extends BaseController implements Initializable {

    private double xOffset, yOffset;

    // Atributes for fxml class
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
    @FXML
    private Button payrollButton;

    private ViewManager formManager;

    @FXML
    private ComboBox companySelector;

    @FXML
    private MenuButton menuButton;

    @FXML
    private MenuItem usersMenu;

    // List for items
    private ObservableList<String> items;

    // List for companies.
    private ArrayList<Company> companies;

    // Atribute for current company
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

        updateCompanies();

        this.companyButton.setDisable(false);
        this.employeeButton.setDisable(true);
        this.payrollButton.setDisable(true);

        if(NominalFX.authAPI.getLogedUser().getPrivilege().getName().equals("admin")){
            this.usersMenu.setVisible(true);
        } else {
            this.usersMenu.setVisible(false);
        }

        setImage();

    }

    public void updateCompanies(){
        try {
            this.items = FXCollections.observableArrayList();
            this.companies = NominalFX.nominalAPI.getCompaniesMinimal();
            for(Company c : this.companies){
                items.add(c.getName());
            }
            companySelector.setItems(items);
        } catch (Exception e){
            NominalFX.logger.add("Error while obtaining companies.");
        }
    }

    private void allowConfiguration(){
        this.companyButton.setDisable(false);
        this.employeeButton.setDisable(false);
        this.payrollButton.setDisable(false);
    }

    //Handlers for change views.
    @FXML
    public void companyHandler(){
        this.formManager.switchScenes("/fxml/company/company_creation.fxml");
    }

    @FXML
    public void employeeHandler(){
        this.formManager.switchScenes("/fxml/employee/employee_creation.fxml");
    }

    @FXML
    public void payrollHandler(){
        this.formManager.switchScenes("/fxml/payroll/payroll_creation.fxml");
    }

    @FXML
    public void logoutHandler(){
        this.stageManager.switchScenes(Views.LOGIN);
    }

    @FXML
    public void configurationHandler(){
        this.formManager.switchScenes("/fxml/configuration/configuration.fxml");
    }

    @FXML
    public void usersHandler() {
        this.formManager.switchScenes("/fxml/users/user.fxml");
    }

    @FXML
    public void exitHandler() {
        Platform.exit();
    }

    @FXML
    public void check(ActionEvent actionEvent){
        Button button = (Button) actionEvent.getSource();
        if (!button.getStyleClass().contains("active")){
            overviewButton.getStyleClass().remove("active");
            companyButton.getStyleClass().remove("active");
            employeeButton.getStyleClass().remove("active");
            settingsButton.getStyleClass().remove("active");
            payrollButton.getStyleClass().remove("active");
            button.getStyleClass().add("active");
        }
    }

    // Method to select the company and get his information
    @FXML
    public void companySelection() {
        try {
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
        } catch (SQLException e){
            NominalFX.logger.add("Error while updating companies.");
        } catch (Exception e){
            NominalFX.logger.add("Error while selecting company.");
        }
    }

    private void setImage(){
        try {
            int id = NominalFX.imageAPI.getUserImageMinimal(NominalFX.authAPI.getLogedUser().getId());
            if(NominalFX.cache.containsImage(id)){
                this.avatar.setImage(NominalFX.cache.getImageById(id).getImage());
            } else {
                NominalFX.cache.add(NominalFX.imageAPI.getImageById(id),NominalFX.cache.getImages());
                setImage();
            }
        } catch (Exception e){
            this.avatar.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/unknown.jpg"))));
        }
    }


    // Return the current selected company
    public Company getCurrentCompany() {
        return currentCompany;
    }

}
