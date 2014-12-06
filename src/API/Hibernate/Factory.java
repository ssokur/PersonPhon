package API.Hibernate;

public class Factory {
    private static API.Hibernate.DAO_Hibernate DAO_Hibernate = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public DAO_Hibernate getDAO_Hibernate() {
        if (DAO_Hibernate == null) DAO_Hibernate = new DAO_Hibernate();
        return DAO_Hibernate;
    }
}

