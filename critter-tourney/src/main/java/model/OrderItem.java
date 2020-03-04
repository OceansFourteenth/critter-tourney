package model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Represents a number of {@link Item}s for a specified {@link Order}
 * 
 * @author OceansFourteenth
 * @see Item
 *
 */
@Entity
//@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "orderId", "itemId" }) })
public class OrderItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4029752492746503675L;

	@ManyToOne
	@JoinColumn(name = "orderId")
	@Id
	private Order order;

	@ManyToOne
	@JoinColumn(name = "itemId")
	@Id
	private Item item;

	private int quantity;

	public OrderItem() {

	}

	/**
	 * @param order
	 * @param item
	 */
	public OrderItem(Order order, Item item) {
		this(order, item, 1);
	}

	/**
	 * @param order
	 * @param item
	 * @param quantity
	 */
	public OrderItem(Order order, Item item, int quantity) {
		super();
		this.order = order;
		this.item = item;
		this.quantity = quantity;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(item, order);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(item, other.item) && Objects.equals(order, other.order);
	}

	@Override
	public String toString() {
		return "OrderItem [order=" + order + ", item=" + item + ", quantity=" + quantity + "]";
	}
}
