/**
 * 
 */
package dao;

import static dao.util.JpaUtil.beginTransaction;
import static dao.util.JpaUtil.commit;
import static dao.util.JpaUtil.getEntityManager;

import javax.persistence.EntityManager;
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

//	@PersistenceContext(unitName = "critter-tourney")
	private final EntityManager entityManager = getEntityManager();

	@Override
	public Customer createCustomer(Customer customer) {
		entityManager.persist(customer);
		return customer;
	}

	@Override
	public Customer createCustomer(String email, String firstName, String lastName) {
		beginTransaction();

		Customer customer = new Customer(email, firstName, lastName);
		entityManager.persist(customer);

		commit();
		return customer;
	}

	@Override
	public Customer getByEmail(String email) {
		String qlString = "FROM Customer C WHERE C.email = :email";
		TypedQuery<Customer> query = entityManager.createQuery(qlString, Customer.class);
		query.setParameter("email", email);

		return query.getSingleResult();
	}

	@Override
	public Customer getById(long id) {
		return entityManager.find(Customer.class, id);
	}

}
