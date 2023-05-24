package view.menu;

import controller.MainMenuController;
import controller.RegisterAndLoginAndProfileMenuController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginMenu extends Application {
    public static Stage stage;
    public TextField username;
    public PasswordField password;
    public Label label;
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
    public void login(ActionEvent event) throws Exception {
        String username = this.username.getText();
        String password = this.password.getText();
        String message = registerAndLoginAndProfileMenuController.login(username , password);
        if(!message.equals("Login was successful")){
            reset();
            label.setText(message);
        }
        label.setText("Login was successful");
        enterMainMenu();
    }

    public void reset(){
        this.username.setText("");
        this.password.setText("");
    }
    public void enterMainMenu() throws Exception {
        MainMenuController mainMenuController = new MainMenuController();
        mainMenuController.setCurrentUser(registerAndLoginAndProfileMenuController.getCurrentUser());
        MainMenu.setMainMenuController(mainMenuController);
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
