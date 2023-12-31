/**
 * Monster - Represents a monster that can appear in the monster hunter game.
 * 
 * @author ______
 * @copyright 2023 Howard Community College
 * @version 1.0
 *
 */

package javaClass;
public abstract class Monster {
	
	/*** PROTECTED FINAL CONTANSTS ***/
	protected final static double STANDARD_MODIFIER = 1.0;
	protected final static double TYPE_RESISTANCE_MODIFIER = .9;
	protected final static double BOOST_MODIFIER = 1.1;
	
	// abstract methods
	public abstract double checkAbility(Monster defender);
	public abstract double checkResistance(Monster attacker);
	
	/*** FINAL INSTANCE VARIABLES ***/
	// Add MonsterType to constructors
	private final MonsterType type;
	private final String name;
	
	/*** INSTANCE VARIABLES ***/
	private int maxHealth;
	private int currentHealth;
	private int attack;
	private int defense;
	private int speed;
	
	/*** CONSTRUCTORS ***/
	/**
	 * Default constructor for Monster. Sets values:
	 * name = Plant Dinosaur
	 * type = MonsterType.GRASS
	 * maxHealth = 120
	 * currentHealth = 120
	 * attack = 55
	 * defense = 40
	 * speed = 90
	 */
	public Monster() {
		maxHealth = 120;
		currentHealth = 120;
		attack = 55;
		defense = 40;
		speed = 90;
		type = null;
		name = "";
	} // end constructor Monster()
	
	/**
	 * Create an instance of the monster class
	 * 
	 * @param name The human readable name of the Monster
	 * @param type the MonsterType of the monster
	 * @param health value for maxHealth and initial currentHealth
	 * @param attack the value of the attack stat
	 * @param defense the value of the defense stat
	 * @param speed the value of the speed stat
	 */
	public Monster(String name, MonsterType type, int health, int attack, int defense, int speed) {
		maxHealth = health;
		currentHealth = health;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.type = type;
		this.name = name;
	} // end constructor Monster(MonsterType, String, int, int, int, int)
	
	/*** MUTATORS ***/
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public String getName() {
		return name;
	}

	public MonsterType getType() {
		return type;
	}

	@Override
	public String toString() {
		return String.format("%s [maxHealth=%s, currentHealth=%s, attack=%s, defense=%s, speed=%s, type=%s]",
				name, maxHealth, currentHealth, attack, defense, speed, type.getReadable());
	}
	
	
	

}
