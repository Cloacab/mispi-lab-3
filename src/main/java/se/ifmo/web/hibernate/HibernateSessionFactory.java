package se.ifmo.web.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import se.ifmo.web.model.Point;

/**
 * Singleton class for hibernate sessions
 * Shares one instance of {@code SessionFactory} across the application
 */
public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    /**
     * Checks whether there is an instance of <code>SessionFactory</code>, creates it if not
     * @return {@link SessionFactory}
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Point.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
