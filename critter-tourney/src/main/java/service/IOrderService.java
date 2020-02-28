package service;

import model.Customer;
import model.Item;
import model.Order;

public interface IOrderService {

	public Order createOrder(Customer customer) throws IllegalArgumentException;

	public boolean addItem(Order order, Item item, int quantity) throws IllegalArgumentException;

	public boolean removeItem(Order order, Item item) throws IllegalArgumentException;

	public boolean updateItem(Order order, Item item, int newQuantity) throws IllegalArgumentException;
}
