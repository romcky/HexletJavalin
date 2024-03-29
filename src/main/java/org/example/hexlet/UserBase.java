package org.example.hexlet;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.hexlet.User;

public class UserBase {
    private final List<User> users = new ArrayList<>();

    public UserBase() {
        users.add(new User(1, "Anton"));
        users.add(new User(2, "Ivan"));
        users.add(new User(3, "Petr"));
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean existId(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().isPresent();
    }

    public Optional<User> getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny();
    }

}
