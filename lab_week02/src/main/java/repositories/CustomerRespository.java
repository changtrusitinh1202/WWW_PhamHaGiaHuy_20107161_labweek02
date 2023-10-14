package repositories;

import db.Connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import models.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class CustomerRespository {
    private EntityManager em= null;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public CustomerRespository() {
        this.em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
        this.trans = em.getTransaction();
    }


    public Customer findById(long id){
        return em.find(Customer.class, id);
    }

    public boolean addCustomer(Customer customer){
        try {
            trans.begin();
            em.persist(customer);
            trans.commit();
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            trans.rollback();
        }
        return false;
    }

    public boolean updadatCustomer(Customer customer){
        try {
            trans.begin();
            em.merge(customer);
            trans.commit();
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            trans.rollback();
        }
        return false;
    }

    public boolean deleteCustomer(long id){
        try {
            trans.begin();
            em.remove(findById(id));
            trans.commit();
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            trans.rollback();
        }
        return false;
    }

    public Optional<List<Customer>> getListCustomer(){
        TypedQuery<Customer> query = em.createNamedQuery("getAllCustomer", Customer.class);
        List<Customer> list = query.getResultList();
        return list == null ? Optional.empty() : Optional.of(list);
    }

}
