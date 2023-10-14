package repositories;

import db.Connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.ProductImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ProductImageRespository {

    private EntityManager em= null;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductImageRespository() {
        this.em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
        this.trans = em.getTransaction();
    }

    public ProductImage findById(long id){
        return em.find(ProductImage.class, id);
    }

    public boolean addProductImage(ProductImage productImage){
        try {
            trans.begin();
            em.persist(productImage);
            trans.commit();
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            trans.rollback();
        }
        return false;
    }

    public boolean updateProductImage(ProductImage productImage){
        try {
            trans.begin();
            em.merge(productImage);
            trans.commit();
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            trans.rollback();
        }
        return false;
    }

    public boolean deleteProductImage(long id){
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

//    public List<ProductImage> getAll() {
//
//    }




}
