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

	public Item createItem(Item item) throws IllegalArgumentException;
	
	public Item createItem(String name, String description, double price) throws IllegalArgumentException;

	public Item getByName(String name) throws IllegalArgumentException;

	public Item getById(long id);
}
