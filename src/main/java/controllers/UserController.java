package controllers;

import helpers.DataHelper;
import entities.user.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class UserController implements Serializable {

    private DataHelper dataHelper;

    public UserController() {
        dataHelper = DataHelper.getInstance();
    }

    public Boolean saveUser(User user) {
        Session session = this.dataHelper.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.persist(user);
        } catch (Exception exc) {
            if (transaction != null)
                transaction.rollback();
            session.close();
            return false;
        }

        return true;
    }

    public User getUserByEmail(String email) {
        Session session = this.dataHelper.getSession();
        Transaction transaction = session.beginTransaction();

        List list = session.createQuery("from User u where u.email = :email")
                .setParameter("email", email).getResultList();

        transaction.commit();
        session.close();

        if (list.size() == 0)
            return null;

        return (User) list.get(0);
    }
}
