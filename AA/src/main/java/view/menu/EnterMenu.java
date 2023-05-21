package view.menu;
import controller.MainMenuController;
import controller.RegisterAndLoginAndProfileMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EnterMenu extends Application{
    public static Stage stage;
    private final String css = this.getClass().getResource("/css/style.css").toExternalForm();

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/fxml/EnterMenu.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        EnterMenu.stage = stage;
        }

        public void enterLoginMenu() throws Exception {
            LoginMenu.setRegisterAndLoginAndProfileMenuController(new RegisterAndLoginAndProfileMenuController());
            new LoginMenu().start(stage);
        }

        public void enterRegisterMenu() throws Exception {
            LoginMenu.setRegisterAndLoginAndProfileMenuController(new RegisterAndLoginAndProfileMenuController());
            new RegisterMenu().start(stage);
        }


        public void enterMainMenuAsGuest() throws Exception {
            MainMenu.setMainMenuController(new MainMenuController());
            new MainMenu().start(stage);
        }



    }



