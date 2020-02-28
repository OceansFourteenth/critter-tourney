package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Customer;
import service.CustomerServiceImpl;
import service.ICustomerService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerServiceTest {

	private ICustomerService customerService;

	@Before
	public void setUp() {
		customerService = new CustomerServiceImpl();
	}

	@Test
	public void _0_createCustomerByModel() {
		Customer customer = new Customer();
		customer = customerService.createCustomer(customer);
		assertNotNull(customer);
	}

	@Test
	public void _1_createCustomerByDetails() {
		Customer customer = customerService.createCustomer("email@email.com", "firstName", "lastName");
		assertNotNull(customer);
	}

	@Test
	public void _2_getCustomerByEmail() {
		String email = "test@test.com";
		Customer customer = customerService.createCustomer(email, "firstName", "lastName");

		Customer customer2 = customerService.getByEmail(email);
		assertEquals(customer, customer2);
	}

	@Test
	public void _3_getCustomerById() {
		Customer customer = customerService.createCustomer(new Customer());
		long id = customer.getId();

		Customer customer2 = customerService.getById(id);
		assertEquals(customer, customer2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void _4_createCustomerByModel_failOnNullModel() {
		customerService.createCustomer(null);
	}
	
	@After
	public void tearDown() {
		customerService = null;
	}
	
}
