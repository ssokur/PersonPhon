package API;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil

        // Класс HibernateUtil,
        // который будет отвечать за обработку xml файла hibernate.cfg.xml и установление соединения с нашей базой данных:

{
    private static SessionFactory sessionFactory = null;

    static {
        try
        {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

        } catch (Exception e)
        {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
