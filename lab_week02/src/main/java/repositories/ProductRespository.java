package repositories;

import db.Connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class ProductRespository {
    private EntityManager em= null;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductRespository() {
        this.em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
        this.trans = em.getTransaction();
    }

    public Product findById(long id){
        return em.find(Product.class, id);
    }

    public boolean addProduct(Product product){
        try {
            trans.begin();
            em.persist(product);
            trans.commit();
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            trans.rollback();
        }
        return false;
    }

    public boolean updateProduct(Product product){
        try {
            trans.begin();
            em.merge(product);
            trans.commit();
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            trans.rollback();
        }
        return false;
    }

    public boolean deleteProduct(long id){
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


    public Optional<List<Product>> getProductList(){
        TypedQuery<Product> query = em.createNamedQuery("getAllProduct", Product.class);
        List<Product> productList = query.getResultList();
        return productList == null ? Optional.empty() : Optional.of(productList);
    }


    public  Optional<List<Product>> getProductListIsActive(){
        TypedQuery<Product> query = em.createNamedQuery("getAllProductIsAcive", Product.class);
        List<Product> productList  = query.getResultList();
        return productList == null ? Optional.empty() : Optional.of(productList);
    }

}
