/**
 * Data access objects
 */
package dao;

import java.util.HashSet;
import java.util.Set;

import model.Customer;

/**
 * @author OceansFourteenth
 *
 */
public class CustomerDaoImpl implements ICustomerDao {

	private Set<Customer> customers = new HashSet<Customer>();
	private static long customerCount = 0;

	@Override
	public Customer createCustomer(Customer customer) {
		customer.setId(++customerCount);
		if (customers.add(customer))
			return customer;
		else
			return null;
	}

	@Override
	public Customer createCustomer(String email, String firstName, String lastName) {
		Customer customer = new Customer(email, firstName, lastName);
		return createCustomer(customer);
	}

	@Override
	public Customer getByEmail(String email) {
		for (Customer c : customers)
			if (c.getEmail().equals(email))
				return c;
		
		return null;
	}

	@Override
	public Customer getById(long id) {
		for (Customer c : customers)
			if (c.getId() == id)
				return c;
		
		return null;
	}

}
