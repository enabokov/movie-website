package main.java.beans;

import main.java.controllers.UserController;
import main.java.entities.user.User;

import java.io.Serializable;

public class UserBean implements Serializable {

    private UserController userController;

    // required
    private String email;
    private String password;
    private int age;

    // optional
    private String name;
    private String surname;
    private String sex;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Boolean isLoggedIn() {
        return this.loggedIn;
    }

    public Boolean login() {
        User user = userController.getUserByEmail(email);

        if (user != null && user.getPassword().equals(this.password)) {
            this.loggedIn = true;
        }

        return this.isLoggedIn();
    }

    public Boolean save() {
        User user = new User();
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setName(this.name);
        user.setSurname(this.surname);
        user.setAge(this.age);
        user.setSex(this.sex);
        return userController.saveUser(user);
    }
}
