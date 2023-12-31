/**
 * IncreaseItem - Represents how much the item increases the stats by
 * @author Tunmise Eboda
 * @copyright 2023 Howard Community College
 * @version 1.0
 *
 */


package javaClass;

public class IncreaseItem extends Item {

	/*** INSTANCE VARIABLES ***/
	Stat stat;
	int increase;

	/*** CONSTRUCTORS ***/
	/**
	 * Default constructor for IncreaseItem. Sets values: stat = stat.CURRENT_HEALTH
	 * increase = 0
	 */

	public IncreaseItem() {
		stat = stat.CURRENT_HEALTH;
		increase = 0;
	}// end of default constructor

	/**
	 * Create an instance of the Item class
	 * 
	 * @param name        The human readable name of the item
	 * @param description of the item
	 * @param cost        of the item
	 * @param stat        the stat the is going to be increased
	 * @param increase    the value it is going to be increased by
	 */

	public IncreaseItem(String name, String description, double cost, Stat stat, int increase) {
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.stat = stat;
		this.increase = increase;
	}// end constructor IncreaseItem(String name, String description, double cost,
		// Stat stat, int increase)

	/*** MUTATORS ***/

	public Stat getStat() {
		return stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}

	public int getIncrease() {
		return increase;
	}

	public void setIncrease(int increase) {
		this.increase = increase;
	}

	@Override
	public void use(Monster monster) {
		switch (stat) {
		case ATTACK:
			monster.setAttack(monster.getAttack() + increase);
			break;
		case DEFENSE:
			monster.setDefense(monster.getDefense() + increase);
			break;
		case SPEED:
			monster.setSpeed(monster.getSpeed() + increase);
			break;
		case CURRENT_HEALTH:
			monster.setCurrentHealth(monster.getCurrentHealth() + increase);
			break;
		case MAX_HEALTH:
			monster.setMaxHealth(monster.getMaxHealth() + increase);
			break;
		}

	}

}
