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

	public boolean createItem(Item item);
	
	public Item createItem(String name);

	public Item getByName(String name);

	public Item getById(long id);
}
