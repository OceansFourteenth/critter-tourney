/**
 * 
 */
package dao;

import java.util.HashSet;
import java.util.Set;

import model.Customer;
import model.Item;
import model.Order;
import model.OrderItem;

/**
 * @author OceansFourteenth
 *
 */
public class OrderDaoImpl implements IOrderDao {

	private static long orderCount = 0;
	private Set<Order> orders = new HashSet<Order>();
	private Set<OrderItem> orderItems = new HashSet<>();

	@Override
	public Order createOrder(Customer customer) {
		Order order = new Order(customer);
		order.setId(++orderCount);

		if (orders.add(order))
			return order;
		else
			return null;
	}

	@Override
	public boolean addItem(Order order, Item item, int quantity) {
		OrderItem orderItem = new OrderItem(order, item, quantity);
		return orderItems.add(orderItem);
	}

	@Override
	public boolean removeItem(Order order, Item item) {
		OrderItem orderItem = new OrderItem(order, item);
		return orderItems.remove(orderItem);
	}

	@Override
	public boolean updateItem(Order order, Item item, int newQuantity) {
		OrderItem orderItem = new OrderItem(order, item, newQuantity);
		return orderItems.remove(orderItem) && orderItems.add(orderItem);
	}

}
