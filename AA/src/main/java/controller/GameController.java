package controller;

import javafx.stage.Stage;
import model.User;
import view.game.Game;
import view.menu.EndMenu;

public class GameController {
    private Game game;
    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }


    public void setGame(Game game) {
        this.game = game;
    }

    public void endGame(String result , Stage stage) throws Exception {
        EndMenu endMenu = new EndMenu();
        endMenu.result.setText(result);
        endMenu.result.setVisible(true);
        endMenu.start(stage);
    }
}
