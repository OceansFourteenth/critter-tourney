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
	public Customer createCustomer(Customer customer) {
		if (customer == null)
			return null;

		return customerDao.createCustomer(customer);
	}

	@Override
	public Customer createCustomer(String email, String firstName, String lastName) {
		if (email == null || email.length() == 0)
			return null;
		if (firstName == null || firstName.length() == 0)
			return null;
		if (lastName == null || lastName.length() == 0)
			return null;

		String emailRegex = "^\\w{2,}@(\\w{2,}\\.)+\\w{2,}$";
		if (!email.trim().matches(emailRegex))
			return null;

		return customerDao.createCustomer(email.trim(), firstName.trim(), lastName.trim());
	}

	@Override
	public Customer getByEmail(String email) {
		if (email == null || email.length() == 0)
			return null;

		return customerDao.getByEmail(email);
	}

	@Override
	public Customer getById(long id) {
		return customerDao.getById(id);
	}

}
