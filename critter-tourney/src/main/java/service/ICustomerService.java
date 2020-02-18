/**
 * 
 */
package service;

import model.Customer;

/**
 * @author OceansFourteenth
 *
 */
public interface ICustomerService {

	public boolean createCustomer(Customer customer);
	
	public Customer createCustomer(String email, String firstName, String lastName);

	public Customer getByEmail(String email);

	public Customer getById(long id);
}
