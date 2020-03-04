/**
 * 
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import model.Item;

/**
 * @author OceansFourteenth
 *
 */
@Transactional
public class ItemDaoJpaImpl implements IItemDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Item createItem(Item item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public Item createItem(String name, String description, double price) {
		Item item = new Item(name, description, price);
		entityManager.persist(item);
		return item;
	}

	@Override
	public Item getByName(String name) {
		String qlString = "FROM Item I WHERE I.name = :name";
		TypedQuery<Item> query = entityManager.createQuery(qlString, Item.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}

	@Override
	public Item getById(long id) {
		return entityManager.find(Item.class, id);
	}

}
