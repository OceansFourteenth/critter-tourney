/**
 * 
 */
package service;

import dao.IItemDao;
import dao.ItemDaoImpl;
import model.Item;

/**
 * @author OceansFourteenth
 *
 */
public class ItemServiceImpl implements IItemService {

	private IItemDao itemDao = new ItemDaoImpl();

	@Override
	public Item createItem(Item item) {
		if (item == null)
			return null;

		return itemDao.createItem(item);
	}

	@Override
	public Item createItem(String name, String description, double price) {
		if (name == null || name.length() == 0)
			return null;

		if (description == null || description.length() == 0)
			return null;

		if (price <= 0)
			return null;

		return itemDao.createItem(name, description, price);
	}

	@Override
	public Item getByName(String name) {
		if (name == null || name.length() == 0)
			return null;

		return itemDao.getByName(name);
	}

	@Override
	public Item getById(long id) {
		return itemDao.getById(id);
	}

}
