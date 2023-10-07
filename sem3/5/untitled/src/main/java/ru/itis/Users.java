package ru.itis;

import java.util.ArrayList;
import java.util.List;

public class Users {
    public static List<User> users = new ArrayList<>();
    public static boolean findUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
