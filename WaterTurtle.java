/**
 * WaterTurtle - Represents the water turtle in the monster game
 * @author Tunmise Eboda
 * @copyright 2023 Howard Community College
 * @version 1.0
 *
 */

package javaClass;

public class WaterTurtle extends Monster {

	/**
	 * Constructor for Water Turtle class.
	 * 
	 * @param health  Value for maxHealth and initial currentHealth.
	 * @param attack  The value of the attack stat.
	 * @param defense The value of the defense stat.
	 * @param speed   The value of the speed stat.
	 */
	public WaterTurtle(int health, int attack, int defense, int speed) {
		super("Water Turtle", MonsterType.WATER, health, attack, defense, speed);
	}

	/**
	 * Default constructor for Water. Uses default values as specified in the
	 * requirements.
	 */
	public WaterTurtle() {
		this(132, 48, 65, 43);
	}

	@Override
	public double checkAbility(Monster defender) {
		if (defender.getCurrentHealth() == defender.getMaxHealth()) {
			System.out.println("Water Turtle attacks oppenent at full health activating drench ability. Damage increased 10%!");
			return BOOST_MODIFIER;
		} else {
			return STANDARD_MODIFIER;
		}
	}

	@Override
	public double checkResistance(Monster attacker) {
		if (attacker.getType() == MonsterType.FIRE) {
			System.out.println("Water Turtle takes reduced damage from Fire types. Damage reduced 10%!");
			return TYPE_RESISTANCE_MODIFIER;
		} else {
			return STANDARD_MODIFIER;
		}
	}

}
