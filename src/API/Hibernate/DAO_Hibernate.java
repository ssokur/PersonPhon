package API.Hibernate;

import API.CRUD_Function;
import API.Hibernate.HibernateUtil;
import API.Person;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Hibernate implements CRUD_Function

{
    @Override
    public void create(Person p) throws SQLException, ClassNotFoundException
    {
        Session session = null; // init session from HibernateUtil
        try
        {
            session = HibernateUtil.getSessionFactory().openSession(); // Open session
            session.beginTransaction(); // Begin Transaction with DB
            session.save(p);    // Save data into DB
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public ArrayList read() throws SQLException, ClassNotFoundException
    {
        Session session = null; // init session from HibernateUtil
        List<Person> pers   = new ArrayList<Person>();
//        ArrayList<Person> pers = new ArrayList<Person>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            pers = session.createCriteria(Person.class).list();
//            pers = (ArrayList<Person>) session.createCriteria(Person.class).list();
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
//        return pers;
        return (ArrayList)pers;
    }

    @Override
    public void delete(Person p) throws SQLException, ClassNotFoundException
    {
        Session session = null; // init session from HibernateUtil
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(p);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Person p) throws SQLException, ClassNotFoundException
    {
        Session session = null; // init session from HibernateUtil
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(p);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
