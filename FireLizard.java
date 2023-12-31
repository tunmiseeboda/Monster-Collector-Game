/**
 * FireLizard - Represents the Fire Lizard in the monster game
 * @author Tunmise Eboda
 * @copyright 2023 Howard Community College
 * @version 1.0
 *
 */

package javaClass;

public class FireLizard extends Monster {

	// PRIVATE FINAL CONSTANST
	private static final double ABILITY_THRESHOLD = .2;

	/**
	 * Constructor for FireLizard class.
	 * 
	 * @param health  Value for maxHealth and initial currentHealth.
	 * @param attack  The value of the attack stat.
	 * @param defense The value of the defense stat.
	 * @param speed   The value of the speed stat.
	 */
	public FireLizard(int health, int attack, int defense, int speed) {
		super("Fire Lizard", MonsterType.FIRE, health, attack, defense, speed);

	}

	/**
	 * Default constructor for FireLizard. Uses default values as specified in the
	 * requirements.
	 */
	public FireLizard() {
		this(117, 52, 43, 65);
	}

	@Override
	public double checkAbility(Monster defender) {
		if (getCurrentHealth() < (getMaxHealth() * ABILITY_THRESHOLD)) {
			System.out.println("Fire Lizard has low health activating blaze ability. Damage increased by 10%!");
			return BOOST_MODIFIER;
		} else {
			return STANDARD_MODIFIER;
		}
	}

	@Override
	public double checkResistance(Monster attacker) {
		if(attacker.getType() == MonsterType.GRASS) {
			System.out.println("Fire Lizard takes reduced damage from Grass types. Damage reduced 10%!");
			return TYPE_RESISTANCE_MODIFIER;
		}else {
			return STANDARD_MODIFIER;
		}
	}

}
