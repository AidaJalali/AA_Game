package view.menu;
import controller.EnterMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EnterMenu extends Application{
    private static Stage stage;
    private final EnterMenuController enterMenuController = new EnterMenuController();
    private String css = this.getClass().getResource("/css/style.css").toExternalForm();

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        EnterMenu.stage = stage;
        Parent parent = FXMLLoader.load(EnterMenu.class.getResource("/fxml/EnterMenu.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        }

        public void enterLoginMenu(){

        }

        public void enterRegisterMenu(){

        }

        public void enterMainMenuAsGuest(){

        }

    }



