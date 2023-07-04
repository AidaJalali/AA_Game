package controller;
import model.DataBase;
import model.User;

import java.io.FileNotFoundException;

import static java.lang.System.exit;

public class RegisterAndLoginAndProfileMenuController {
    private User currentUser;
    public String register(String username , String password)  {
        if (DataBase.getInstance().getUserByUsername(username)!= null) return "User already exists";
        String usernameError = checkUsernameError(username);
        String passwordError = checkPasswordError(password);
        if(usernameError != null) return usernameError;
        if(passwordError != null) return passwordError;
        User user = new User(username, password);
        DataBase.getInstance().addUser(user);
        DataBase.getInstance().saveData();
        return "Registration was successful";
    }

    public String login(String username , String password){
        User user = DataBase.getInstance().getUserByUsername(username);
        if (user == null) return "User doesn't exist";
        if (!user.getPassword().equals(password)) return "Wrong Password!";
        currentUser = user;
        return "Login was successful";
    }

    public String changeUsername(String username){
        if(DataBase.getInstance().getUserByUsername(username) != null) return "User with this username already exists";
        String usernameError = checkUsernameError(username);
        if(usernameError != null) return usernameError;
        currentUser.setUsername(username);
        DataBase.getInstance().saveData();
        return "Username changed successfully";
    }
    public String changePassword(String password){
        String passwordError = checkPasswordError(password);
        if(passwordError != null) return passwordError;
        currentUser.setPassword(password);
        DataBase.getInstance().saveData();
        return "Password changed successfully";
    }

    public String deleteAccount(){
        DataBase.getInstance().deleteUserByUsername(currentUser.getUsername());
        currentUser = null;
        return "Account deleted";
    }

    public String checkUsernameError(String username){
        if(!username.matches(".+")) return "Username is invalid!";
        if(username.length() < 5) return "Username is too short!";
        if(username.length() > 20) return "Username is too long!";
        return null;
    }
    public String checkPasswordError(String password){
        if(!password.matches(".+")) return "Username is invalid!";
        if(password.length() < 5) return "Password is week!";
        return null;
    }
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
