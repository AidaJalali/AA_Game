package view.menu;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class RegisterMenu extends Application{
    public static Stage stage;
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        RegisterMenu.stage = stage;
        Parent parent = FXMLLoader.load(RegisterMenu.class.getResource("/fxml/RegisterMenu.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        }

    }



