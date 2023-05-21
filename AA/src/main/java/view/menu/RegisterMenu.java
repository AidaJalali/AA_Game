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

public class RegisterMenu extends Application {
    public static Stage stage;
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    public TextField username;
    public PasswordField password;
    public Label Error;
    private static RegisterAndLoginAndProfileMenuController registerAndLoginAndProfileMenuController;
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/fxml/RegisterMenu.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        RegisterMenu.stage = stage;
    }

    public void register(ActionEvent event) throws Exception {
        String username = this.username.getText();
        String password = this.password.getText();
        String message = registerAndLoginAndProfileMenuController.register(username,password);
        if(!message.equals("Login was successful")){
            reset();
            Error.setText(message);
        }
        Error.setText("Login was successful");
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
        RegisterMenu.registerAndLoginAndProfileMenuController = registerAndLoginAndProfileMenuController;
    }
}
