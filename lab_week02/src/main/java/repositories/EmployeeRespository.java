package repositories;

import db.Connection;
import enums.EmployeeStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import models.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class EmployeeRespository {
    private EntityManager em= null;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeRespository() {
        this.em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
        this.trans = em.getTransaction();
    }

    public Employee searchById(long id){
        return em.find(Employee.class, id);
    }

    public void addEmployee(Employee employee){
        try{
            trans.begin();
            em.persist(employee);
            trans.commit();
        }catch (Exception e){
            trans.rollback();
            logger.error(e.getMessage());
        }

    }

    public void updateEmployee(Employee employee){
        try{
            trans.begin();
            em.merge(employee);
            trans.commit();
        }catch (Exception e){
            trans.rollback();
            logger.error(e.getMessage());
        }
    }

    public void setStatus(Employee employee, EmployeeStatus employeeStatus){
        employee.setStatus(employeeStatus);
    }

    public Optional<Employee> findbyID(long id){
        TypedQuery<Employee> query = em.createNamedQuery("findById", Employee.class);
        query.setParameter("id", id);
        Employee emp = query.getSingleResult();
        return emp == null ? Optional.empty() : Optional.of(emp);
    }

    public List<Employee> getAllEmp(){
        TypedQuery<Employee> query = em.createNamedQuery("getAllEmployee", Employee.class);
        List<Employee> listEmp = query.getResultList();
        return listEmp;
    }

    public Employee checkLogIn(String email, String phone){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql = "select e from Employee e where e.email = ?1 and e.phone =?2";
            Employee emp = em.createQuery(sql, Employee.class).setParameter(1, email).setParameter(2, phone).getSingleResult();
            tr.commit();
            return emp;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }

}
