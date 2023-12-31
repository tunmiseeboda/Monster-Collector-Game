/**
 * Monster - Represents how much healing can be applied to the player in the game.
 * 
 * @author Tunmise Eboda
 * @copyright 2023 Howard Community College
 * @version 1.0
 *
 */

package javaClass;

public class HealItem extends Item {

	/*** INSTANCE VARIABLES ***/
	int healAmount;

	
	/*** CONSTRUCTORS ***/
	/**
	 * Default constructor for HealthItem. 
	 * calls the default constructor for Item
	 * healAmount = 0
	 */
	public HealItem() {
		super();
		healAmount = 0;
	}// end constructor HealthItem()

	
	/**
	 * Create an instance of the Item class
	 * 
	 * @param name        The human readable name of the item
	 * @param description of the item
	 * @param cost        of the item
	 * @param healAmount the amount of healing dealt
	 */
	
	public HealItem(String name, String description, double cost, int healAmount) {
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.healAmount = healAmount;
	}// end constructor HealthItem(String name, String description, double cost, int healAmount)
	
	/*** MUTATORS ***/
	public int getHealAmount() {
		return healAmount;
	}
	
	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}
	
	@Override
	public void use (Monster monster) {
		if(healAmount == -1) {
			monster.setCurrentHealth(monster.getMaxHealth());
		}else {
			int newHealth = monster.getCurrentHealth() + healAmount;
			int maxHealth = monster.getMaxHealth();
			monster.setCurrentHealth(Math.min(newHealth, maxHealth));
		}
	}

}
