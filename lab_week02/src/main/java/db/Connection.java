package db;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
    private static Connection instance;
    private EntityManagerFactory emf;

    private Connection(){
        emf = Persistence.createEntityManagerFactory("20107161_phamhagiahuy_week2");
    }

    public static Connection getInstance(){
        if(instance == null)
            instance = new Connection();
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
}
