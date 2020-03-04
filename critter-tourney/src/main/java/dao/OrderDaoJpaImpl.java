/**
 * 
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import model.Customer;
import model.Item;
import model.Order;
import model.OrderItem;

/**
 * @author OceansFourteenth
 *
 */
@Transactional
public class OrderDaoJpaImpl implements IOrderDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Order createOrder(Customer customer) {
		Order order = new Order(customer);
		entityManager.persist(order);
		return order;
	}

	@Override
	public boolean addItem(Order order, Item item, int quantity) {
		OrderItem orderItem = new OrderItem(order, item, quantity);
		entityManager.persist(orderItem);
		return true;
	}

	@Override
	public boolean removeItem(Order order, Item item) {
		OrderItem orderItem = new OrderItem(order, item);
		entityManager.remove(orderItem);
		return true;
	}

	@Override
	public boolean updateItem(Order order, Item item, int newQuantity) {
		String hql = "UPDATE OrderItem SET quantity = :quantity WHERE orderId = :orderId AND item_id = :item_id";
		Query query = entityManager.createQuery(hql);
		query.setParameter("quantity", newQuantity);
		query.setParameter("orderId", order.getId());
		query.setParameter("item_id", item.getId());

		return query.executeUpdate() == 1;
	}

}
