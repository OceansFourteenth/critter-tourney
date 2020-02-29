package boot;

import model.Customer;
import model.Item;
import model.Order;
import service.CustomerServiceImpl;
import service.ICustomerService;
import service.IItemService;
import service.IOrderService;
import service.ItemServiceImpl;
import service.OrderServiceImpl;

public class ApplicationInitializer {

	public static void main(String[] args) {
		ICustomerService customerService = new CustomerServiceImpl();
		IOrderService orderService = new OrderServiceImpl();
		IItemService itemService = new ItemServiceImpl();

		Customer customer = customerService.createCustomer("john@email.com", "John", "Doe");
		Order order = orderService.createOrder(customer);
		Item item = itemService.createItem("Apple", "Red fruit", 1.5);

		boolean itemAdded = orderService.addItem(order, item, 2);
		System.out.println("Item added? " + itemAdded);

		boolean itemUpdated = orderService.updateItem(order, item, 3);
		System.out.println("Item updated? " + itemUpdated);
		
		System.out.println(order);

		boolean itemRemoved = orderService.removeItem(order, item);
		System.out.println("Item removed? " + itemRemoved);
	}

}
