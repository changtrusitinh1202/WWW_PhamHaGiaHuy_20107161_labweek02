package repositories;

import db.Connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderRespository {
    private EntityManager em= null;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public OrderRespository() {
        this.em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
        this.trans = em.getTransaction();
    }

//    public List<Order> getAll() {
//
//    }


    public Order findById(long id){
        return em.find(Order.class,id);
    }

    public boolean addOrder(Order order){
        try {
            trans.begin();
            em.persist(order);
            trans.commit();
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            trans.rollback();
        }
        return false;
    }

    public boolean updateOrder(Order order){
        try {
            trans.begin();
            em.merge(order);
            trans.commit();
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            trans.rollback();
        }
        return false;
    }

    public boolean deleteOrder(long id){
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

}
