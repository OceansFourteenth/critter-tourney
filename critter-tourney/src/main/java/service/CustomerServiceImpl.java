/**
 * 
 */
package service;

import dao.CustomerDaoImpl;
import dao.ICustomerDao;
import model.Customer;

/**
 * @author OceansFourteenth
 *
 */
public class CustomerServiceImpl implements ICustomerService {

	private ICustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public Customer createCustomer(Customer customer) throws IllegalArgumentException {
		if (customer == null)
			throw new IllegalArgumentException("Customer is null");

		return customerDao.createCustomer(customer);
	}

	@Override
	public Customer createCustomer(String email, String firstName, String lastName) {
		if (email == null || email.length() == 0)
			throw new IllegalArgumentException("Email must be non-null, non-empty");
		if (firstName == null || firstName.length() == 0)
			throw new IllegalArgumentException("First name must be non-null, non-empty");
		if (lastName == null || lastName.length() == 0)
			throw new IllegalArgumentException("Last name must be non-null, non-empty");

		String emailRegex = "^\\w{2,}@(\\w{2,}\\.)+\\w{2,}$";
		if (!email.trim().matches(emailRegex))
			throw new IllegalArgumentException("'email' parameter does not match email address format");

		return customerDao.createCustomer(email.trim(), firstName.trim(), lastName.trim());
	}

	@Override
	public Customer getByEmail(String email) {
		if (email == null || email.length() == 0)
			throw new IllegalArgumentException("Email must be non-null, non-empty");

		return customerDao.getByEmail(email);
	}

	@Override
	public Customer getById(long id) {
		return customerDao.getById(id);
	}

}
