package view.menu;

import controller.MainMenuController;
import controller.RegisterAndLoginAndProfileMenuController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.DataBase;
import model.User;

public class RegisterMenu extends Application {
    public static Stage stage;
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private TextField username;
    private PasswordField password;
    private static RegisterAndLoginAndProfileMenuController registerAndLoginAndProfileMenuController;
    private Pane pane = new Pane();
    private Label unsuccessful;
    private Label successful;
    public void start(Stage stage) throws Exception {
        pane = FXMLLoader.load(this.getClass().getResource("/fxml/RegisterMenu.fxml"));
        Scene scene = new Scene(pane);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        RegisterMenu.stage = stage;
    }

    public void register(ActionEvent event) throws Exception {
        String username = String.valueOf(this.username.getText());
        String password = String.valueOf(this.password.getText());
        String message = registerAndLoginAndProfileMenuController.register(username,password);
        if(message == null){
            unsuccessful.setVisible(true);
            return;
        }
        if(!message.equals("Register was successful")){
            unsuccessful.setVisible(true);
            reset();
            ;
            return;
        }
        successful.setVisible(true);
        User user = new User(username , password);
        DataBase.getInstance().addUser(user);
        DataBase.getInstance().saveData();
    }

    public void reset(){
        username.setText("");
        password.setText("");
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
