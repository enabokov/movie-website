package helpers;

import entities.user.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

class HibernateUtil {
    private static SessionFactory sessionFactory ;
    static {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(User.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
