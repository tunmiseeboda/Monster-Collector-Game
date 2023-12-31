/**
 * GameResources - This class contains a static String array of the available
 * monsters and the static list of items.
 * 
 * @author
 * @copyright 2023 Howard Community College
 * @version 2.0
 */
package javaClass;

public class GameResources {

	public static final String[] ALL_MONSTERS = new String[] { "Plant Dinosaur", "Fire Lizard", "Water Turtle",
			"Flying Magnet", "Muscles", "Moon Fairy" };

	public static final Item[] ITEMS = new Item[] {
			// Combine the ALL_HEAL_ITEMS array and ALL_INCREASE_ITEMS 
			//array into a  single array
			// of Item objects called ITEMS
			new HealItem("Tonic", "Heal monster by 10 health points", 10.0, 10),
			new HealItem("Super Tonic", "Heal monster by 20 health points", 20.0, 20),
			new HealItem("Max Tonic", "Heal monster to full health", 40.0, -1),
			new IncreaseItem("Protein", "Increase a monster's attack by 20", 20, Stat.ATTACK, 20),
			new IncreaseItem("Fat", "Increase a monster's defense by 20", 20, Stat.DEFENSE, 20),
			new IncreaseItem("Carbs", "Increase a monster's speed by 20", 20, Stat.SPEED, 20),
			new IncreaseItem("Health Up", "Increase a monster's max health by 20", 20, Stat.MAX_HEALTH, 20) };

	/**
	 * Get a new monster based on the index in the ALL_MONSTERS array
	 * 
	 * @param index index of monster in ALL_MONSTERS array
	 * @return an instance of Monster type
	 */
	public static Monster get(int index) {
		Monster monster = null;

		switch (index) {
		case 0:
			// Create Plant Dinosaur monster
			monster = new PlantDinosaur();
			break;
		case 1:
			// Create Fire Lizard monster
			monster = new FireLizard();
			break;
		case 2:
			// Create Water Turtle monster
			monster = new WaterTurtle();
			break;
		case 3:
			// Create Flying Magnet monster
			monster = new FlyingMagnet(75, 95, 70, 45);
			break;
		case 4:
			// Create Muscles monster
			monster = new Muscles(210, 80, 50, 35);
			break;
		case 5:
			// Create Moon Fairy monster
			monster = new MoonFairy(210, 45, 48, 35);
			break;
		}

		return monster;
	}
	
	public static void attack(Monster trainers, Monster wild) {

		// Calculate base damage
		int baseDamage = (trainers.getAttack() * 50) / wild.getDefense();

		// Modifications for base damage using check ability and check resistance
		// methods
		double ability = trainers.checkAbility(wild);
		double resistance = wild.checkResistance(trainers);

		// adjust dame based on modifiers
		int damage = (int) (baseDamage * ability * resistance);
		damage = Math.max(0, damage);

		// Decrease health of wild monster
		wild.setCurrentHealth(Math.max(0,wild.getCurrentHealth() - damage));
		

		// Display output
		if (ability > 1.0 || resistance < 1.0 ) {
			System.out.println("Trainer's " + trainers.getName() + " attacks the wild " + wild.getName() + " for "
					+ baseDamage + " damage");
			System.out.println("Trainer's " + trainers.getName() + " attacks the wild " + wild.getName() + " for "
					+ damage + " damage after modifiers!");
		}else {
			System.out.println("Trainer's " + trainers.getName() + " attacks the wild " + wild.getName() + " for "
					+ baseDamage + " damage");
		}

		System.out.println("Trainer's " + trainers.getName() + " (" + trainers.getCurrentHealth() + "/"
				+ trainers.getMaxHealth() + "), wild " + wild.getName() + " (" + wild.getCurrentHealth() + "/"
				+ wild.getMaxHealth() + ")");
	} // end method attack

} // end class Monsters
