package view.menu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EnterMenu extends Application{
    public static Stage stage;
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
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

    }



