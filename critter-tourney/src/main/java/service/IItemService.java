/**
 * 
 */
package service;

import model.Item;

/**
 * @author OceansFourteenth
 *
 */
public interface IItemService {

	public Item createItem(Item item);
	
	public Item createItem(String name, String description, double price);

	public Item getByName(String name);

	public Item getById(long id);
}
