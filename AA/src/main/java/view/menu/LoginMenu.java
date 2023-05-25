package view.menu;

import controller.MainMenuController;
import controller.RegisterAndLoginAndProfileMenuController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.DataBase;
import model.User;

public class LoginMenu extends Application {
    public static Stage stage;
    @FXML
    public TextField username;
    @FXML
    public PasswordField password;
    private final String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private static RegisterAndLoginAndProfileMenuController registerAndLoginAndProfileMenuController;
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/fxml/LoginMenu.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        LoginMenu.stage = stage;
    }
    public void login(MouseEvent mouseEvent) throws Exception {
        String username = this.username.getText();
        String password = this.password.getText();
        String message = registerAndLoginAndProfileMenuController.login(username , password);
        if(!message.equals("Login was successful")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login");
            alert.setHeaderText("Incorrect information");
            alert.setContentText("Incorrect username or password");
            alert.showAndWait();
            reset();
            return;
        }
        reset();
        User user = DataBase.getInstance().getUserByUsername(username);
        System.out.println(user.getUsername());
        enterMainMenu(user);
    }

    public void reset(){
        this.username.setText("");
        this.password.setText("");
    }
    public void enterMainMenu(User user) throws Exception {
        MainMenuController mainMenuController = new MainMenuController();
        mainMenuController.setCurrentUser(registerAndLoginAndProfileMenuController.getCurrentUser());
        MainMenu.setMainMenuController(mainMenuController);
        mainMenuController.setCurrentUser(user);
        new MainMenu().start(stage);
    }

    public void backToEnterMenu() throws Exception{
        new EnterMenu().start(stage);
    }
    public static RegisterAndLoginAndProfileMenuController getRegisterAndLoginAndProfileMenuController() {
        return registerAndLoginAndProfileMenuController;
    }

    public static void setRegisterAndLoginAndProfileMenuController(RegisterAndLoginAndProfileMenuController registerAndLoginAndProfileMenuController) {
        LoginMenu.registerAndLoginAndProfileMenuController = registerAndLoginAndProfileMenuController;
    }
}
