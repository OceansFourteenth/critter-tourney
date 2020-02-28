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

	public Customer createCustomer(Customer customer) throws IllegalArgumentException;
	
	public Customer createCustomer(String email, String firstName, String lastName) throws IllegalArgumentException;

	public Customer getByEmail(String email) throws IllegalArgumentException;

	public Customer getById(long id);
}
