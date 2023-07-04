package view.menu;

import controller.ScoreMenuController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DataBase;
import model.User;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class ScoreMenu extends Application implements Initializable {
    public static Stage stage;
    public String css = this.getClass().getResource("/css/style.css").toExternalForm();
    private static ScoreMenuController scoreMenuController;
    private ArrayList<User>players;

    public Button back;
    public VBox easy;
    public VBox mid;
    public VBox hard;

    public Label a_1;
    public Label a_2;
    public Label a_3;

    public Label b_1;
    public Label b_2;
    public Label b_3;

    public Label c_1;
    public Label c_2;
    public Label c_3;
    public void start(Stage stage) throws Exception {
        ScoreMenu.stage = stage;
        Parent parent = FXMLLoader.load(PrimaryMenu.class.getResource("/fxml/ScoreMenu.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        players = DataBase.getInstance().getUsers();
        setTableEasy();
        setTableMid();
        setTableHard();
        back.setOnAction(actionEvent -> {
            try {
                enterMainMenu();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void enterMainMenu() throws Exception {
        new MainMenu().start(stage);
    }

    public static ScoreMenuController getScoreMenuController() {
        return scoreMenuController;
    }

    public static void setScoreMenuController(ScoreMenuController scoreMenuController) {
        ScoreMenu.scoreMenuController = scoreMenuController;
    }


    private  void setTableHard() {
        Collections.sort(players , new scoreComparator());
        for(int i = 0 ; i < 10 ; i++){
            TextField textField = new TextField();
            textField.setText(players.get(i).getUsername() + "         " + players.get(i).getBestScore() + 50 + "            " + players.get(i).getBestTime() + 30);
            hard.getChildren().add(textField);
        }
        hard.setSpacing(10);
        a_1.setText(players.get(0).getUsername());
        a_2.setText(players.get(1).getUsername());
        a_3.setText(players.get(2).getUsername());
    }

    private void setTableMid() {
        Collections.sort(players , new scoreComparator());
        for(int i = 0 ; i < 10 ; i++){
            TextField textField = new TextField();
            textField.setText(players.get(i).getUsername() + "            " + players.get(i).getBestScore() + 20 + "          " + players.get(i).getBestTime() + 20);
            mid.getChildren().add(textField);
        }
        mid.setSpacing(10);
        b_1.setText(players.get(0).getUsername());
        b_2.setText(players.get(1).getUsername());
        b_3.setText(players.get(2).getUsername());
    }

    private void setTableEasy() {
        Collections.sort(players , new scoreComparator());
        Collections.sort(players , new scoreComparator());
        System.out.println(players.size());
        for(int i = 0 ; i < 10 ; i++){
            TextField textField = new TextField();
            textField.setText(players.get(i).getUsername() + "            " + players.get(i).getBestScore()  + 10 +  "            " + players.get(i).getBestTime() + 10);
            easy.getChildren().add(textField);
        }
        easy.setSpacing(10);
        c_1.setText(players.get(0).getUsername());
        c_2.setText(players.get(1).getUsername());
        c_3.setText(players.get(2).getUsername());
    }




    class scoreComparator implements Comparator<User> {

        public int compare(User s1, User s2)
        {
            if (s1.getBestScore() == s2.getBestScore()){
                if(s1.getBestTime() == s2.getBestTime())
                    return 0;
                if(s1.getBestTime() < s2.getBestTime())
                    return 1;
                else
                    return -1;
            }
            else if (s1.getBestScore() > s2.getBestScore())
                return 1;

            else
                return -1;
        }
    }

}
