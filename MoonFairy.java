/*
 * MoonFairy - Represents the Moon Fairy in the monster game
 * @author Tunmise Eboda
 * @copyright 2023 Howard Community College
 * @version 1.0
 *
 */
package javaClass;

public class MoonFairy extends Monster {
	/**
	 * Constructor for FireLizard class.
	 * 
	 * @param health  Value for maxHealth and initial currentHealth.
	 * @param attack  The value of the attack stat.
	 * @param defense The value of the defense stat.
	 * @param speed   The value of the speed stat.
	 */
	public MoonFairy(int health, int attack, int defense, int speed) {
		super("Moon Fairy", MonsterType.FAIRY, health, attack, defense, speed);

	}

	/**
	 * Default constructor for FireLizard. Uses default values as specified in the
	 * requirements.
	 */
	public MoonFairy() {
		this(210, 45, 48,35);
	}

	@Override
	public double checkAbility(Monster defender) {
		if (getSpeed() < defender.getSpeed()) {
			System.out.println(
					"Moon Fairy has low speed activating patient ability. Damage increased by 10%!");
			return BOOST_MODIFIER;
		} else {
			return STANDARD_MODIFIER;
		}
	}

	@Override
	public double checkResistance(Monster attacker) {
		if (attacker.getType() == MonsterType.FIGHTING) {
			System.out.println("Moon Fairy takes reduced damage from Fighting types. Damage reduced 10%!");
			return TYPE_RESISTANCE_MODIFIER;
		} else {
			return STANDARD_MODIFIER;
		}
	}

}
