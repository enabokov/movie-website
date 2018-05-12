package controllers;

import helpers.DataHelper;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class MovieController implements Serializable {

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
            list = session.createQuery("from Movie m").getResultList();
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
