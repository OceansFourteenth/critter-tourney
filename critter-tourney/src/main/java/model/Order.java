/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author brain
 *
 */
@Entity
public class Order {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", referencedColumnName = "id")
	private Customer customer;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "orderId")
	private List<OrderItem> orderItems;

	/**
	 * @param customer
	 */
	public Order(Customer customer) {
		super();
		this.customer = customer;
		this.orderItems = new ArrayList<OrderItem>();
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @param item
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(OrderItem item) {
		return orderItems.add(item);
	}

	/**
	 * 
	 * @see java.util.List#clear()
	 */
	public void clear() {
		orderItems.clear();
	}

	/**
	 * @param item
	 * @return
	 * @see java.util.List#contains(java.lang.Object)
	 */
	public boolean contains(OrderItem item) {
		return orderItems.contains(item);
	}

	/**
	 * @return
	 * @see java.util.List#isEmpty()
	 */
	public boolean isEmpty() {
		return orderItems.isEmpty();
	}

	/**
	 * @param item
	 * @return
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean remove(OrderItem item) {
		return orderItems.remove(item);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + "]";
	}
}
