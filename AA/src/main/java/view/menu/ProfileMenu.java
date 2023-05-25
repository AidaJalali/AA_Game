package view.menu;

import controller.RegisterAndLoginAndProfileMenuController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ProfileMenu extends Application {
    public static Stage stage;
    private static RegisterAndLoginAndProfileMenuController profileMenuController;
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    @FXML
    private TextField newUsername;
    @FXML
    private TextField newPassword;

    public static RegisterAndLoginAndProfileMenuController getProfileMenuController() {
        return profileMenuController;
    }

    public static void setProfileMenuController(RegisterAndLoginAndProfileMenuController profileMenuController) {
        ProfileMenu.profileMenuController = profileMenuController;
    }

    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/fxml/ProfileMenu.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        ProfileMenu.stage = stage;
    }

    public void deleteAccount(MouseEvent mouseEvent) throws Exception {
        profileMenuController.deleteAccount();
        new LoginMenu().start(stage);
    }

    public void changeUsername(MouseEvent mouseEvent) {
        String message = profileMenuController.changeUsername(newUsername.getText());
        Alert alert;
        if(!message.equals("Username changed successfully")){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Change username");
            alert.setHeaderText("Duplicate username");
            alert.setContentText("User with this username already exists");
            alert.showAndWait();
        }
        else{
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Change username");
            alert.setHeaderText("Username changed");
            alert.setContentText("Username changed successfully");
            alert.showAndWait();
        }
        newUsername.setText("");
    }

    public void changePassword(MouseEvent mouseEvent) {
        String message = profileMenuController.changePassword(newPassword.getText());
        Alert alert;
        if(!message.equals("Password changed successfully")){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Change Password");
            alert.setHeaderText("Invalid Password");
            alert.setContentText("Password is invalid");
            alert.showAndWait();
        }
        else{
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Change Password");
            alert.setHeaderText("Password changed");
            alert.setContentText("Password changed successfully");
            alert.showAndWait();
        }
        newUsername.setText("");
    }

    public void goToLoginMenu(MouseEvent mouseEvent) throws Exception {
        new LoginMenu().start(stage);
    }

    public void goToAvatarMenu(MouseEvent mouseEvent) throws Exception {
        new AvatarMenu().start(stage);
    }

    public void backToMainMenu(MouseEvent mouseEvent) throws Exception {
        new MainMenu().start(stage);
    }
}
