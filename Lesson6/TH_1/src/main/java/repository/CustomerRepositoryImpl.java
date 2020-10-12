package repository;

import model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(int id) {
       Customer customer = entityManager.find(Customer.class, id);
       return customer;

    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() > 0) {
            entityManager.merge(customer);
        }else {
            entityManager.persist(customer);
        }
    }

    @Override
    public void remove(int id) {
        Customer customer = findById(id);
        if (customer != null) entityManager.remove(customer);
    }
}
