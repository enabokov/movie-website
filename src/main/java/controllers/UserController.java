package main.java.controllers;

import main.java.helpers.DataHelper;
import main.java.entities.user.User;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean
@ApplicationScoped
public class UserController implements Serializable {

    private DataHelper dataHelper;

    public UserController() {
        dataHelper = DataHelper.getInstance();
    }

    public User getUserByEmail(String email) {
        return dataHelper.getUserByEmail(email);
    }
}
