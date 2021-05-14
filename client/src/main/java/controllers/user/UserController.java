package controllers.user;

import application.NominalFX;
import common.auth.Privilege;
import common.auth.User;
import common.employee.Employee;
import controllers.HomeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.MD5;
import view.ViewController;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class UserController extends ViewController {

    private HomeController controller;

    private ObservableList userList;

    private User currentUser;

    private ArrayList<User> users;

    private ObservableList privilegeList;
    private ArrayList<Privilege> privileges;

    @FXML
    private ComboBox userSelector;

    @FXML
    private ComboBox privilegeSelector;

    @FXML
    private Button newUser;

    @FXML
    private Button successUser;

    @FXML
    private TextField identificatorField;

    @FXML
    private TextField nameUser;

    @FXML
    private PasswordField passwordUser;

    @FXML
    private Button changeImageButton;

    @FXML
    private ImageView userImage;

    private boolean editable;

    @Override
    public void run() {
        this.controller = (HomeController) this.manager.getController();
        this.users = new ArrayList<>();
        this.privileges = new ArrayList<>();
        this.userList = FXCollections.observableArrayList();
        this.privilegeList = FXCollections.observableArrayList();
        updateUsers();
    }

    // Update the list of employees for the employeeSelector
    private void updateUsers(){
        this.userSelector.getSelectionModel().clearSelection();
        this.userList.clear();
        try {
            this.users = NominalFX.authAPI.getUsers();
            for(User u : users){
                this.userList.add(u.getName());
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            NominalFX.logger.add("Error while trying to get users.");
        }
        this.userSelector.setItems(this.userList);
        this.userSelector.getSelectionModel().select(0);
        userSelection();
    }

    @FXML
    private void userSelection(){
        try {
            this.currentUser = this.users.get(this.userSelector.getSelectionModel().getSelectedIndex());
        } catch (IndexOutOfBoundsException e){
            //
        }
        disableCreation();
        updateFields();
    }

    private void updateFields(){

        this.nameUser.setText(this.currentUser.getName());
        this.passwordUser.setText(this.currentUser.getPassword());
        this.identificatorField.setText(String.format("%d",this.currentUser.getId()));

        setPrivilege();
        setImage();

    }

    private void setPrivilege(){
        this.privilegeList.clear();
        int index = 0;
        int count = 0;
        try {
            this.privileges = NominalFX.authAPI.getPrivileges();
        } catch (SQLException e){
            NominalFX.logger.add("Error while trying to get privileges");
        }
        for(Privilege p : this.privileges){
            if(p.getId() == this.currentUser.getPrivilege().getId()){
                index = count;
            }
            this.privilegeList.add(p.getName());
            count++;
        }
        this.privilegeSelector.setItems(this.privilegeList);
        this.privilegeSelector.getSelectionModel().select(index);
    }

    private void disableCreation(){

        this.changeImageButton.setDisable(false);
        this.newUser.setText("New user");
        this.newUser.getStyleClass().remove("success");

    }

    private void clearAllFields(){

        this.editable = true;

        this.changeImageButton.setDisable(true);

        this.identificatorField.setText("");
        this.nameUser.setText("");
        this.nameUser.setEditable(true);
        this.passwordUser.setText("");

        this.newUser.setText("Create user");
        this.newUser.getStyleClass().add("success");

    }

    @FXML
    private void saveChanges(){
        try {
            this.currentUser.setPassword(MD5.getMD5(this.passwordUser.getText()));
            NominalFX.authAPI.updateUserPassword(this.currentUser);
        } catch (Exception e){
            NominalFX.logger.add("Error while trying to save changes of an user.");
        }
    }

    @FXML
    private void uploadImage(){
        try {
            File file = NominalFX.imageAPI.chooseFile(this.manager.getController().getStageManager().getPrimaryStage());
            NominalFX.imageAPI.registerNewUserImage(this.currentUser,file);
            setImage();
        } catch (Exception e){
            NominalFX.logger.add("Error while trying to upload new employee image.");
        }
    }

    private void setImage(){
        try {
            int id = NominalFX.imageAPI.getUserImageMinimal(this.currentUser.getId());
            if(NominalFX.cache.containsImage(id)){
                this.userImage.setImage(NominalFX.cache.getImageById(id).getImage());
            } else {
                NominalFX.cache.add(NominalFX.imageAPI.getImageById(id),NominalFX.cache.getImages());
                setImage();
            }
        } catch (Exception e){
            this.userImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/unknown.jpg"))));
        }
    }

    @FXML
    private void newUser(){
        if(!this.editable){
            clearAllFields();
        } else {
            try {
                User user = new User(this.nameUser.getText(), MD5.getMD5(this.passwordUser.getText()),this.privileges.get(this.privilegeSelector.getSelectionModel().getSelectedIndex()));
                NominalFX.authAPI.setUser(user);
            } catch (SQLException e){
                NominalFX.logger.add("Error while trying to register new user.");
            } catch (Exception e) {
                NominalFX.logger.add("Error while trying to create new user.");
            }

            this.editable = false;

            updateUsers();
        }
    }

    @Override
    public void shouldUpdate() {

    }
}
