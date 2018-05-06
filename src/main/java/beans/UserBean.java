package main.java.beans;

import main.java.controllers.UserController;
import main.java.entities.user.User;

import java.io.Serializable;

public class UserBean implements Serializable {

    private UserController userController;

    private String email;
    private String password;

    private Boolean loggedIn = false;

    public UserBean() {
        userController = new UserController();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isLoggedIn() {
        return this.loggedIn;
    }

    public String login() {
        User user = userController.getUserByEmail(email);

        if (user == null) {
            return "index";  // TODO: register user in this case
        }

        if (user.getPassword().equals(this.password)) {
            this.loggedIn = true;
            return "index";
        }

        return "login";
    }
}
