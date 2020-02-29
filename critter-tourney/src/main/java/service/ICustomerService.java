/**
 * 
 */
package service;

import model.Customer;

/**
 * Service-layer interface to perform all Customer related operations. Methods
 * check parameters before passing functionality to DAO layer.
 * 
 * @author OceansFourteenth
 * @see Customer
 */
public interface ICustomerService {

	/**
	 * Creates a Customer.
	 * 
	 * @param customer the customer to be created
	 * @return the Customer if it was created or null if it was not
	 * @throws IllegalArgumentException if customer parameter is null
	 * @apiNote {@link #createCustomer(String, String, String)} is preferred since
	 *          this method may bypass security checks
	 */
	public Customer createCustomer(Customer customer) throws IllegalArgumentException;

	/**
	 * Creates a customer
	 * 
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Customer createCustomer(String email, String firstName, String lastName) throws IllegalArgumentException;

	/**
	 * Retrieves the first Customer found with the given email
	 * 
	 * @param email
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Customer getByEmail(String email) throws IllegalArgumentException;

	/**
	 * Retrieves the first Customer found with the given id.
	 * 
	 * @param id
	 * @return
	 */
	public Customer getById(long id);
}
