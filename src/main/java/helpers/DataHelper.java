package helpers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DataHelper {

    private SessionFactory sessionFactory = null;
    private static DataHelper dataHelper = null;

    private DataHelper() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static DataHelper getInstance() {
        return dataHelper == null ? new DataHelper() : dataHelper;
    }

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
