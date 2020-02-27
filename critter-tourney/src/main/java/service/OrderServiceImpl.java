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
			return null;

		return orderDao.createOrder(customer);
	}

	@Override
	public boolean addItem(Order order, Item item, int quantity) {
		if (order == null || item == null || quantity <= 0)
			return false;

		return orderDao.addItem(order, item, quantity);
	}

	@Override
	public boolean removeItem(Order order, Item item) {
		if (order == null || item == null)
			return false;

		return orderDao.removeItem(order, item);
	}

	@Override
	public boolean updateItem(Order order, Item item, int newQuantity) {
		if (order == null || item == null || newQuantity <= 0)
			return false;

		return orderDao.updateItem(order, item, newQuantity);
	}

}
