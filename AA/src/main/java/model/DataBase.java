package model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.*;
import java.util.ArrayList;


public class DataBase {

    private static DataBase dataBase = null;

    ArrayList<User> users = new ArrayList<>();

    private DataBase() {
        loadData();
    }

    public static DataBase getInstance() {
        if (dataBase == null) {
            dataBase = new DataBase();
        }
        return dataBase;
    }

    private void loadData() {
        Reader reader;
        try {
            reader = new FileReader("data.json");
        } catch (FileNotFoundException e) {
            return;
        }
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);
        for (JsonElement jsonElement : jsonArray)
            users.add(gson.fromJson(jsonElement, User.class));

    }

    public void saveData() {
        loadData();
        try {
            Gson gson = new Gson();
            String json = gson.toJson(users);
            try {
                FileWriter myWriter = new FileWriter("data.json");
                myWriter.write(json);
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }


    public void addUser(User user) {
        users.add(user);
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void deleteUserByUsername(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
    }


}
