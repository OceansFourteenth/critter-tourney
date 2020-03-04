/**
 * 
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Customer;

/**
 * @author OceansFourteenth
 *
 */
@Repository
@Transactional
public class CustomerDaoJpaImpl implements ICustomerDao {
	
	private EntityManagerFactory entityManagerFactory;

	@PersistenceContext(unitName = "critter-tourney")
	private EntityManager entityManager;

	@Override
	public Customer createCustomer(Customer customer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.persist(customer);
		entityManager.refresh(customer);
		entityManager.close();
		return customer;
	}

	@Override
	public Customer createCustomer(String email, String firstName, String lastName) {
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Customer customer = new Customer(email, firstName, lastName);
		entityManager.persist(customer);
		entityManager.refresh(customer);
		return customer;
	}

	@Override
	public Customer getByEmail(String email) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String qlString = "FROM Customer C WHERE C.email = :email";
		TypedQuery<Customer> query = entityManager.createQuery(qlString, Customer.class);
		query.setParameter("email", email);

		return query.getSingleResult();
	}

	@Override
	public Customer getById(long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Customer.class, id);
	}

}
