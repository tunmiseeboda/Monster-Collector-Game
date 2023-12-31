/*
 * Muscles - Represents the Muscles monster in the monster game
 * @author Tunmise Eboda
 * @copyright 2023 Howard Community College
 * @version 1.0
 *
 */
package javaClass;

public class Muscles extends Monster {
	/**
	 * Constructor for FireLizard class.
	 * 
	 * @param health  Value for maxHealth and initial currentHealth.
	 * @param attack  The value of the attack stat.
	 * @param defense The value of the defense stat.
	 * @param speed   The value of the speed stat.
	 */
	public Muscles(int health, int attack, int defense, int speed) {
		super("Muscles", MonsterType.FIGHTING, health, attack, defense, speed);

	}

	/**
	 * Default constructor for FireLizard. Uses default values as specified in the
	 * requirements.
	 */
	public Muscles() {
		this(210, 80, 50, 35);
	}

	@Override
	public double checkAbility(Monster defender) {
		if (getCurrentHealth() == getMaxHealth()) {
			System.out.println(
					"Muscles has max health activating battle stance ability. Damage increased by 10%!");
			return BOOST_MODIFIER;
		} else {
			return STANDARD_MODIFIER;
		}
	}

	@Override
	public double checkResistance(Monster attacker) {
		if (attacker.getType() == MonsterType.STEEL) {
			System.out.println("Muscles takes reduced damage from Steel types. Damage reduced 10%!");
			return TYPE_RESISTANCE_MODIFIER;
		} else {
			return STANDARD_MODIFIER;
		}
	}

}
