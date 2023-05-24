package view.menu;
import controller.MainMenuController;
import controller.RegisterAndLoginAndProfileMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class EnterMenu extends Application{
    public static Stage stage;
    private final String css = this.getClass().getResource("/css/style.css").toExternalForm();

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = FXMLLoader.load(this.getClass().getResource("/fxml/EnterMenu.fxml"));
        Scene scene = new Scene(pane);
        scene.getStylesheets().add(css);
        EnterMenu.stage = stage;
        stage.setScene(scene);
        stage.show();
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



