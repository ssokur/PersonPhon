package API;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CRUD_Function
{
    void create(Person p) throws SQLException, ClassNotFoundException;

    ArrayList read() throws SQLException, ClassNotFoundException;

    void delete(Person p) throws SQLException, ClassNotFoundException;

    void update(Person p) throws SQLException, ClassNotFoundException;
}
