package dao;

import model.Customer;
import model.Item;
import model.Order;

public interface IOrderDao {

	public Order createOrder(Customer customer);

	public boolean addItem(Order order, Item item, int quantity);

	public boolean removeItem(Order order, Item item);

	public boolean updateItem(Order order, Item item, int newQuantity);
}
