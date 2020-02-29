package service;

import dao.IOrderDao;
import dao.OrderDaoImpl;
import model.Customer;
import model.Item;
import model.Order;
import model.OrderItem;

public class OrderServiceImpl implements IOrderService {

	private IOrderDao orderDao = new OrderDaoImpl();

	@Override
	public Order createOrder(Customer customer) {
		if (customer == null)
			throw new IllegalArgumentException("Customer cannot be null");

		return orderDao.createOrder(customer);
	}

	@Override
	public boolean addItem(Order order, Item item, int quantity) {
		if (order == null)
			throw new IllegalArgumentException("Order cannot be null");

		if (item == null)
			throw new IllegalArgumentException("Item cannot be null");

		if (quantity <= 0)
			throw new IllegalArgumentException("Quantity must be positive value");

		if (orderDao.addItem(order, item, quantity))
			return order.add(new OrderItem(order, item, quantity));
		else
			return false;
	}

	@Override
	public boolean removeItem(Order order, Item item) {
		if (order == null)
			throw new IllegalArgumentException("Order cannot be null");

		if (item == null)
			throw new IllegalArgumentException("Item cannot be null");

		if (orderDao.removeItem(order, item))
			return order.remove(new OrderItem(order, item));
		else
			return false;
	}

	@Override
	public boolean updateItem(Order order, Item item, int newQuantity) {
		if (order == null)
			throw new IllegalArgumentException("Order cannot be null");

		if (item == null)
			throw new IllegalArgumentException("Item cannot be null");

		if (newQuantity <= 0)
			throw new IllegalArgumentException("Quantity must be positive value");

		if (orderDao.updateItem(order, item, newQuantity))
			return order.remove(new OrderItem(order, item)) && order.add(new OrderItem(order, item, newQuantity));
		else
			return false;
	}

}
