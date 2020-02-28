package service;

import dao.IOrderDao;
import dao.OrderDaoImpl;
import model.Customer;
import model.Item;
import model.Order;

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

		return orderDao.addItem(order, item, quantity);
	}

	@Override
	public boolean removeItem(Order order, Item item) {
		if (order == null)
			throw new IllegalArgumentException("Order cannot be null");

		if (item == null)
			throw new IllegalArgumentException("Item cannot be null");

		return orderDao.removeItem(order, item);
	}

	@Override
	public boolean updateItem(Order order, Item item, int newQuantity) {
		if (order == null)
			throw new IllegalArgumentException("Order cannot be null");

		if (item == null)
			throw new IllegalArgumentException("Item cannot be null");

		if (newQuantity <= 0)
			throw new IllegalArgumentException("Quantity must be positive value");

		return orderDao.updateItem(order, item, newQuantity);
	}

}
