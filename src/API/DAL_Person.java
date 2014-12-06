package API;

import API.Hibernate.DAO_Hibernate;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class DAL_Person
{
    CRUD_Function pd = null; // init interface

    public DAL_Person() throws ParseException, UnknownHostException {

//        pd = new DAO_SQL();
//        pd = new DAO_Mongo();
        pd = new DAO_Hibernate();
    }

    void create(Person p) throws SQLException, ClassNotFoundException {
        pd.create(p);
    }

    public ArrayList<Person> read() throws SQLException, ClassNotFoundException {
        return pd.read();
    }

    void delete(Person p) throws SQLException, ClassNotFoundException {
        pd.delete(p);
    }

    void update(Person p) throws SQLException, ClassNotFoundException {
        pd.update(p);
    }
}
