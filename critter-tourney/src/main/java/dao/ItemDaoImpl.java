/**
 * 
 */
package dao;

import java.util.HashSet;
import java.util.Set;

import model.Item;

/**
 * @author OceansFourteenth
 *
 */
public class ItemDaoImpl implements IItemDao {

	private Set<Item> items = new HashSet<>();
	private static long itemCount = 0;

	@Override
	public Item createItem(Item item) {
		item.setId(++itemCount);

		if (items.add(item))
			return item;
		else
			return null;
	}

	@Override
	public Item createItem(String name, String description, double price) {
		Item item = new Item(name, description, price);
		return createItem(item);
	}

	@Override
	public Item getByName(String name) {
		for (Item i : items)
			if (i.getName().equalsIgnoreCase(name))
				return i;

		return null;
	}

	@Override
	public Item getById(long id) {
		for (Item i : items)
			if (i.getId() == id)
				return i;

		return null;
	}

}
