package view.menu;

import controller.RegisterAndLoginAndProfileMenuController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.DataBase;
import model.User;

public class RegisterMenu extends Application {
    public static Stage stage;
    @FXML
    Pane pane ;
    @FXML
    private TextField username ;
    @FXML
    private PasswordField password;
    private static RegisterAndLoginAndProfileMenuController registerAndLoginAndProfileMenuController;
    public void start(Stage stage) throws Exception {
        pane = FXMLLoader.load(this.getClass().getResource("/fxml/RegisterMenu.fxml"));
        Scene scene = new Scene(pane);
        scene.getStylesheets().add(this.getClass().getResource("/css/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        RegisterMenu.stage = stage;
    }

    public void register(MouseEvent mouseEvent) throws Exception {
        String username = this.username.getText();
        String password = this.password.getText();
        String message = registerAndLoginAndProfileMenuController.register(username,password);
        if(message == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Register Error");
            alert.setContentText("Empty Field!");
            alert.showAndWait();
            reset();
            return;
        }
        if(!message.equals("Registration was successful")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Register Error");
            alert.setContentText(message);
            alert.showAndWait();
            reset();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Register");
        alert.setHeaderText("Register");
        alert.setContentText("Register was successful");
        alert.showAndWait();
        reset();
        User user = new User(username , password);
        DataBase.getInstance().addUser(user);
    }

    public void reset(){
        username.setText("");
        password.setText("");
    }
    public void backToEnterMenu() throws Exception{
        new PrimaryMenu().start(stage);
    }
    public static RegisterAndLoginAndProfileMenuController getRegisterAndLoginAndProfileMenuController() {
        return registerAndLoginAndProfileMenuController;
    }

    public static void setRegisterAndLoginAndProfileMenuController(RegisterAndLoginAndProfileMenuController registerAndLoginAndProfileMenuController) {
        RegisterMenu.registerAndLoginAndProfileMenuController = registerAndLoginAndProfileMenuController;
    }
}
