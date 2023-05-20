package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterAndLoginMenuController {
    private PasswordField password;
    private TextField username;
    public void register(ActionEvent event){
        String usernameError = checkUsernameError();
        String passwordError = checkPasswordError();
        if(usernameError == null && passwordError == null){
            //CreateAccount();
            //TODO this part is related to database
        }
        else if(usernameError != null){

        }
        else if (passwordError != null) {

        }
    }

    public void login(ActionEvent event){
        //TODO this part is related to database
    }
    public void reset(ActionEvent event){
        password.setText("");
        username.setText("");
    }
    public String checkUsernameError(){
     if(!username.getText().matches("\\S+"))
         return "Username is invalid!";
     if(username.getText().length() < 5)
         return "Username is too short!";
     if(username.getText().length() > 10)
         return "Username is too long!";
     return null;
    }
    public String checkPasswordError(){
        if(!username.getText().matches("\\S+"))
            return "Username is invalid!";
        if(username.getText().length() < 5)
            return "Password is week!";
        return null;
    }

}
