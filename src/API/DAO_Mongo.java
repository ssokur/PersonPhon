package API;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_Mongo implements CRUD_Function {
    /**
     * * Connect to MongoDB ***
     */
    // Since 2.10.0, uses MongoClient
    MongoClient mongo;

    public DAO_Mongo() throws UnknownHostException {
        mongo = new MongoClient("localhost", 27017);
        db = mongo.getDB("Person");
        table = db.getCollection("person");
    }
// =================================================================================
    /**
     * * Get database ***
     */
    // if database doesn't exists, MongoDB will create it for you
    DB db;

    /**
     * * Get collection / table from 'testdb' ***
     */
    // if collection doesn't exists, MongoDB will create it for you
    DBCollection table;
// =================================================================================

    @Override
    public void create(Person p) throws SQLException, ClassNotFoundException {
        System.out.println(p.getAge());
        /**** Insert ****/
        // create a document to store key and value
        BasicDBObject document = new BasicDBObject();
        document.put("ID", p.getId());
        document.put("FName", p.getFName());
        document.put("LName", p.getLName());
        document.put("Age", p.getAge());
        System.out.println(document);
        table.insert(document);
    }

    @Override
    public ArrayList read() throws SQLException, ClassNotFoundException {
        /**** Find and display ****/
        DBCursor cursor = table.find();
        System.out.println(table);

        ArrayList<Person> pp = new ArrayList<Person>();

        while (cursor.hasNext()) {
            DBObject actpers = cursor.next();
            Person p = new Person();
            p.setId((Integer) actpers.get("ID"));
            p.setFName(String.valueOf(actpers.get("FName")));
            p.setLName(String.valueOf(actpers.get("LName")));
            p.setAge((Integer) actpers.get("Age"));
            pp.add(p);
        }
        return pp;
    }

    @Override
    public void delete(Person p) throws SQLException, ClassNotFoundException {
        DBCollection table = db.getCollection("person");
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("ID", p.getId());
        table.remove(searchQuery);
    }

    @Override
    public void update(Person p) throws SQLException, ClassNotFoundException {
        /**** Update ****/
        // search document where ID="...." and update it with new values

        BasicDBObject query = new BasicDBObject();
        query.put("Id", p.getId());               // old data, find key Id

        BasicDBObject newDocument = new BasicDBObject();

//        newDocument.put("Id",    p.getId());        // new data
        newDocument.put("FName", p.getFName());     // new data
        newDocument.put("LName", p.getLName());     // new data
        newDocument.put("Age", p.getAge());       // new data
        System.out.println(newDocument);

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);
        System.out.println(updateObj);

        table.update(query, updateObj);
    }
}
