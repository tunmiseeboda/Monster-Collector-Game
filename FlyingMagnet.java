/*
 * FlyingMagnet - Represents the Flying Magnet in the monster game
 * @author Tunmise Eboda
 * @copyright 2023 Howard Community College
 * @version 1.0
 *
 */
package javaClass;

public class FlyingMagnet extends Monster {

	/**
	 * Constructor for FireLizard class.
	 * 
	 * @param health  Value for maxHealth and initial currentHealth.
	 * @param attack  The value of the attack stat.
	 * @param defense The value of the defense stat.
	 * @param speed   The value of the speed stat.
	 */
	public FlyingMagnet(int health, int attack, int defense, int speed) {
		super("Flying Magnet", MonsterType.STEEL, health, attack, defense, speed);

	}

	/**
	 * Default constructor for FireLizard. Uses default values as specified in the
	 * requirements.
	 */
	public FlyingMagnet() {
		this(75, 95, 70, 45);
	}

	@Override
	public double checkAbility(Monster defender) {
		if (getAttack() > defender.getDefense()) {
			System.out.println(
					"Flying Magnet has high attack activating electromagnet ability. Damage increased by 10%!");
			return BOOST_MODIFIER;
		} else {
			return STANDARD_MODIFIER;
		}
	}

	@Override
	public double checkResistance(Monster attacker) {
		if (attacker.getType() == MonsterType.FAIRY) {
			System.out.println("Flying Magnet takes reduced damage from Fairy types. Damage reduced 10%!");
			return TYPE_RESISTANCE_MODIFIER;
		} else {
			return STANDARD_MODIFIER;
		}
	}

}
