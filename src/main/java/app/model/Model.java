package app.model;

import app.entities.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Model {

    private static Model instance = new Model();

    private static List<User> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<>();
    }

    public void add(User user) {
        model.add(user);
    }

    public List<String> list() {
        return model.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public static void show(){
        for (User user : model) {
            System.out.println(user);
        }
    }

    public static boolean deleteUser(String name) {
        boolean deleted = false;
        for (User user: model) {
            if (model.remove(user))
                deleted = true;
        }
        return deleted;
    }

}
