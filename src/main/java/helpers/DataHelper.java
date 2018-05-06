package main.java.helpers;

import main.java.entities.HibernateUtil;
import main.java.entities.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DataHelper {

    private SessionFactory sessionFactory = null;
    private static DataHelper dataHelper = null;

    private DataHelper() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static DataHelper getInstance() {
        return dataHelper == null ? new DataHelper() : dataHelper;
    }

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public User getUserByEmail(String email) {
        Session session = this.getSession();
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
