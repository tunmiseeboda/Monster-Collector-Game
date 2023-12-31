/**
 * Item - Represents an Item that can appear in the monster hunter game.
 * 
 * @author Tunmise Eboda
 * @copyright 2023 Howard Community College
 * @version 1.0
 *
 */

package javaClass;

public class Item {

	/*** INSTANCE VARIABLES ***/
	 String name;
	 String description;
	 double cost;

	/*** CONSTRUCTORS ***/
	/**
	 * Default constructor for Item. Sets values: name = none description = none
	 * cost = 0.0
	 */

	public Item() {
		name = "None";
		description = "None";
		cost = 0.0;
	}// end constructor Item()

	/**
	 * Create an instance of the Item class
	 * 
	 * @param name        The human readable name of the item
	 * @param description of the item
	 * @param cost        of the item
	 */

	public Item(String name, String description, double cost) {
		this.name = name;
		this.description = description;
		this.cost = cost;
	}// end constructor Item(String name, String description, double cost) 

	
	/*** MUTATORS ***/
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description =description;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost =cost;
	}
	
	@Override
	public String toString() {
		return "Item [" + 
				"Name =" + name + 
				", Description=" + description + 
				", cost=" + cost+  
				']';
	}
	
	public void use (Monster monster) {}
}
