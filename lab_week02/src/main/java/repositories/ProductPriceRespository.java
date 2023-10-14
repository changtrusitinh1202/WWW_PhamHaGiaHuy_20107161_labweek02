package repositories;

import db.Connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import models.ProductPrice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;


public class ProductPriceRespository {
    private EntityManager em= null;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public ProductPriceRespository() {
        this.em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
        this.trans = em.getTransaction();
    }
    public ProductPrice findById(ProductPrice id){
        return em.find(ProductPrice.class, id);
    }

    public List<ProductPrice> getAll(long id){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            List<ProductPrice> list = em.createNativeQuery("select * from product_price where product_id = "+id+" order by price_date_time DESC", ProductPrice.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }


    public boolean addProductPrice(ProductPrice productPrice){
        try {
            trans.begin();
            em.persist(productPrice);
            trans.commit();
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            trans.rollback();
        }
        return false;
    }

    public boolean updateProductPrice(ProductPrice productPrice){
        try {
            trans.begin();
            em.merge(productPrice);
            trans.commit();
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            trans.rollback();
        }
        return false;
    }

    public boolean deleteProductPrice(ProductPrice id){
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

    public Optional<Double> getPriceOfProduct(long id){
        TypedQuery<Double> query = em.createNamedQuery("getPriceOfProduct", Double.class);
        query.setParameter("id", id).getSingleResult();
        Double price = query.getSingleResult();
        return price == null ? Optional.empty() : Optional.of(price);
    }

}
