package view.menu;

import controller.RegisterAndLoginAndProfileMenuController;
import enums.ImageEnum;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AvatarMenu extends Application implements Initializable {
    public static Stage stage;
    private static RegisterAndLoginAndProfileMenuController profileMenuController;
    public String css = Objects.requireNonNull(this.getClass().getResource("/css/style.css")).toExternalForm();

    public ChoiceBox choiceBox;
    public ImageView me;
    public Button add;

    private Image image;

    public static void setProfileMenuController(RegisterAndLoginAndProfileMenuController profileMenuController) {
        AvatarMenu.profileMenuController = profileMenuController;
    }

    @Override
    public void start(Stage stage) throws Exception {
        AvatarMenu.stage = stage;
        Pane pane = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/fxml/AvatarMenu.fxml")));
        Scene scene = new Scene(pane);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    private void handleMenuItem() {
        System.out.println("choice box is null " + (choiceBox.getValue() == null));
        System.out.println(choiceBox.getValue());
        if (choiceBox.getValue().equals("Avatar 1")) {
            image = (new Image(Objects.requireNonNull(ImageEnum.class.getResource(ImageEnum.AVATAR1.getImage())).toExternalForm()));
            System.out.println(image);

        }
        if (choiceBox.getValue().equals("Avatar 2"))
            image = (new Image(Objects.requireNonNull(ImageEnum.class.getResource(ImageEnum.AVATAR2.getImage())).toExternalForm()));
        if (choiceBox.getValue().equals("Avatar 3"))
            image = (new Image(Objects.requireNonNull(ImageEnum.class.getResource(ImageEnum.AVATAR3.getImage())).toExternalForm()));
        if (choiceBox.getValue().equals("Avatar 4"))
            image = (new Image(Objects.requireNonNull(ImageEnum.class.getResource(ImageEnum.AVATAR4.getImage())).toExternalForm()));
        if (choiceBox.getValue().equals("Avatar 5"))
            image = (new Image(Objects.requireNonNull(ImageEnum.class.getResource(ImageEnum.AVATAR5.getImage())).toExternalForm()));
        if (choiceBox.getValue().equals("Avatar 6"))
            image = (new Image(Objects.requireNonNull(ImageEnum.class.getResource(ImageEnum.AVATAR6.getImage())).toExternalForm()));
    }

    public void back(MouseEvent mouseEvent) throws Exception {
        (new MainMenu()).start(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setOnAction(actionEvent -> handleMenuItem());
        add.setOnAction(ae -> setImage());
    }

    private void setImage(){
        System.out.println(image);
        me.setImage(image);
    }
}
