package main.java.controllers;

import main.java.helpers.DataHelper;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class MovieController {

    private DataHelper dataHelper;

    public MovieController() {
        dataHelper = DataHelper.getInstance();
    }

    public List getMovies(int limit, int offset) {
        Session session = this.dataHelper.getSession();
        Transaction transaction = null;
        List list = null;

        try {
            transaction = session.getTransaction();
            if (!transaction.isActive())
                transaction.begin();
            list = session.createQuery("from Movie mov").getResultList();
            transaction.commit();
        } catch (HibernateException exc) {
            if (transaction != null)
                transaction.rollback();
            session.close();
            System.out.println(exc.getCause().toString());
        }

        return list;
    }
}
