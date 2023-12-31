/**
 * PlantDinosaur  - Represents the Plant Dinosaur in the monster game
 * @author Tunmise Eboda
 * @copyright 2023 Howard Community College
 * @version 1.0
 *
 */

package javaClass;

public class PlantDinosaur extends Monster {
	
	/**
	 * Constructor for Water Turtle class.
	 * 
	 * @param health  Value for maxHealth and initial currentHealth.
	 * @param attack  The value of the attack stat.
	 * @param defense The value of the defense stat.
	 * @param speed   The value of the speed stat.
	 */
	public PlantDinosaur(int health, int attack, int defense, int speed) {
		super("Plant Dinosaur", MonsterType.GRASS, health, attack, defense, speed);
	}
	
	/**
	 * Default constructor for Water Turtle. Uses default values as specified in the
	 * requirements.
	 */
	public PlantDinosaur() {
		this(135, 49, 49, 45);
	}

	@Override
	public double checkAbility(Monster defender) {
		if (getAttack() < defender.getAttack()) {
			System.out.println("Plant Dinosaur has lower attack activating overgrowth ability. Damage increased by 10%!");
			return BOOST_MODIFIER;
		}else {
			return STANDARD_MODIFIER;
		}
	}

	@Override
	public double checkResistance(Monster attacker) {
		if(attacker.getType() == MonsterType.WATER) {
			System.out.println("Plant Dinosaur takes reduced damage from Water types. Damage reduced by 10%!");
			return TYPE_RESISTANCE_MODIFIER;
		}else {
			return STANDARD_MODIFIER;
		}
	}

	

}
