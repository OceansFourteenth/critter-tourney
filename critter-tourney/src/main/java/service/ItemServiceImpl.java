/**
 * 
 */
package service;

import dao.IItemDao;
import dao.ItemDaoJpaImpl;
import model.Item;

/**
 * @author OceansFourteenth
 *
 */
public class ItemServiceImpl implements IItemService {

	private IItemDao itemDao = new ItemDaoJpaImpl();

	@Override
	public Item createItem(Item item) {
		if (item == null)
			throw new IllegalArgumentException("Item cannot be null");

		return itemDao.createItem(item);
	}

	@Override
	public Item createItem(String name, String description, double price) {
		if (name == null || name.length() == 0)
			throw new IllegalArgumentException("Name must be non-null, non-empty string");

		if (description == null || description.length() == 0)
			throw new IllegalArgumentException("Description must be non-null, non-empty string");

		if (price <= 0)
			throw new IllegalArgumentException("Price must be a positive value");

		return itemDao.createItem(name, description, price);
	}

	@Override
	public Item getByName(String name) {
		if (name == null || name.length() == 0)
			throw new IllegalArgumentException("Name must be non-null, non-empty string.");

		return itemDao.getByName(name);
	}
	
	@Override
	public Item getById(long id) {
		return itemDao.getById(id);
	}

}
