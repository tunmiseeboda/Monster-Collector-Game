/**
* Driver - The driver will handle the main gameplay loop. 
*
* Copyright 2023 Howard Community College
* @author Oluwatunmise Eboda
* @version 3.0
*
*/
package javaClass;

import java.security.KeyRep.Type;
import java.util.Scanner;

public class Driver {

	// Constants variables
	private final static int MENU_BATTLE = 1;
	private final static int MENU_TRAINER = 2;
	private final static int MENU_HEAL = 3;
	private final static int MENU_SHOP = 4;
	private final static int MENU_QUIT = 5;
	private final static double HEALING_COST = 80.0;
	private final static double BATTLE_WINNINGS = 12.5;
	private final static double STARTING_MONEY = 100.0;
	private final static int MAX_TEAM_SIZE = 6;

	public static void main(String[] args) {
		int Menu_selection = 0;
		int min = 1;
		int max = GameResources.ALL_MONSTERS.length;

		Scanner input = new Scanner(System.in);

		// Get Trainers name form user
		System.out.print("Please enter your name, trainer: ");
		String trainerName = input.nextLine();

		System.out.println("\nPick a starter monsters from the list below:");

		for (int a = 0; a < max; a++) {
			System.out.println((a + 1 + ". ") + GameResources.ALL_MONSTERS[a]);
		}
		int selection = getValidatedSelection(input, min, max);
		Monster monster = GameResources.get(selection - 1);

		// Create an instance of Trainer with $10 for money
		Trainer trainer = new Trainer(trainerName, STARTING_MONEY, monster);

		System.out.println("\nWelcome to CMSY-166 monster hunter game, " + trainerName + "!");

		// While loop that switches the case based on the user selection
		while (Menu_selection != MENU_QUIT) {
			printMenu();
			Menu_selection = getValidatedSelection(input, min, max);
			input.nextLine();

			switch (Menu_selection) {

			case (MENU_BATTLE):
				menuBattle(input, trainer, monster);
				break;

			case (MENU_TRAINER):
				menuTrainer(input, trainer);
				break;

			case (MENU_HEAL):
				menuHeal(input, trainer, monster);
				break;

			case (MENU_SHOP):
				menuShop(input, trainer, monster);
				break;

			case (MENU_QUIT):
				System.out.println("Thanks for playing " + trainerName);
				break;
			}
		}

	}

	// Method that validates user input through a boolean value.
	private static boolean getValidatedYN(Scanner input, String prompt, String errorMessage) {
		System.out.println(prompt);
		String response = input.nextLine();
		while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
			System.out.println(errorMessage);
			response = input.nextLine();

		}
		if (response.equalsIgnoreCase("n")) {
			return false;
		}
		return true;

	}

	// Method that validates user integer input.
	private static int getValidatedSelection(Scanner input, int min, int max) {
		int selection;
		boolean isValid = false;

		do {
			System.out.print("Enter your selection: ");
			selection = input.nextInt();

			if (selection >= min && selection <= max) {
				isValid = true;
			} else {
				System.out.println("\nError: Select must be between " + min + " and " + max + ", inclusively.");
			}

		} while (!isValid);

		return selection;
	}

	private static void printMenu() {
		System.out.println("\n1. Battle");
		System.out.println("2. Trainer");
		System.out.println("3. Heal");
		System.out.println("4. Shop");
		System.out.println("5. Quit");
	}

	// method that allows the user to battle an opponent
	private static void menuBattle(Scanner input, Trainer trainer, Monster monster) {
		int min = 1;
		int max = GameResources.ALL_MONSTERS.length;
		String prompt = "Would you like to add this monster to your team? (Y/N)";
		String errorMessage = "Error: Please enter Y or N";

		System.out.println("\nPick a monster to battle from the list below: ");
		for (int a = 0; a < max; a++) {
			System.out.println((a + 1 + ". ") + GameResources.ALL_MONSTERS[a]);
		}
		System.out.print("Enter your slection: ");
		int Battle_selection = getValidatedSelection(input, min, max);
		input.nextLine();

		Monster opponent = GameResources.get(Battle_selection - 1);
		Monster activeMonster = trainer.getTeam().get(trainer.getActiveMonsterIndex());

		System.out.println("\nA wild " + opponent.getName() + " has appeared");

		while (activeMonster.getCurrentHealth() > 0 && opponent.getCurrentHealth() > 0) {
			if (activeMonster.getSpeed() >= opponent.getSpeed()) {
				GameResources.attack(activeMonster, opponent);
				System.out.println();
				if (opponent.getCurrentHealth() > 0) {
					GameResources.attack(opponent, activeMonster);
					System.out.println();
				}
			} else {
				GameResources.attack(opponent, activeMonster);
				System.out.println();
				if (activeMonster.getCurrentHealth() > 0) {
					GameResources.attack(activeMonster, opponent);
					System.out.println();
				}
			}

			if (activeMonster.getCurrentHealth() == 0) {
				System.out.println("Your " + activeMonster.getName() + " was defeated by the " + opponent.getName());
				return;
			} else if (opponent.getCurrentHealth() == 0) {
				trainer.setBattlesWon(trainer.getBattlesWon() + 1);
				trainer.setMoney(trainer.getMoney() + BATTLE_WINNINGS);
				System.out.println("Your " + activeMonster + " has defeated " + opponent.getName());
				boolean addOpponentToTeam = getValidatedYN(input, prompt, errorMessage);

				if (addOpponentToTeam == true && trainer.getTeam().size() <= MAX_TEAM_SIZE) {
					trainer.getTeam().add(opponent);
				} else if (addOpponentToTeam == true && trainer.getTeam().size() > MAX_TEAM_SIZE) {
					System.out.println("Your team is full. Choose a monster to replace with the defeated monster:");
					for (int a = 0; a < trainer.getTeam().size(); a++) {
						System.out.println((a + 1 + ". ") + trainer.getTeam().get(a).getName());
					}

					int selection = getValidatedSelection(input, 0, trainer.getTeam().size());
					if (selection != 0) {
						trainer.getTeam().remove(selection - 1);
						trainer.getTeam().add(opponent);
						System.out.println(opponent.getName() + "has been added to trainer's team!");
					}
				}

			}
		}

	}

	// method that prints out ream information
	private static void menuTrainer(Scanner input, Trainer trainer) {
		int min = 1;
		int max = trainer.getTeam().size();

		String prompt = "\nwould you like to change active monster? (Y or N): ";
		String errorMessage = "Error: Please enter Y or N";

		System.out.println("Trainer Information");
		System.out.println("--------------------");
		System.out.println("Trainer name: " + trainer.getName());
		System.out.println("Battles Won: " + trainer.getBattlesWon());
		System.out.println("Current Money: $" + trainer.getMoney());
		System.out.println("\nTeam");
		System.out.println("-------");

		int n = 1;
		for (int i = 0; i < trainer.getTeam().size(); i++) {
			if (i == trainer.getActiveMonsterIndex()) {
				System.out.println((n++) + "*. " + trainer.getTeam().get(i));
			} else {
				System.out.println((n++) + ". " + trainer.getTeam().get(i));
			}
		}

		if (max >= 2) {
			boolean changeActiveMonster = getValidatedYN(input, prompt, errorMessage);
			if (changeActiveMonster == true) {
				int selection = getValidatedSelection(input, min, max);
				trainer.setActiveMonsterIndex(selection - 1);
			}
		}
	}

	// method for to validate the heal menu option
	private static void menuHeal(Scanner input, Trainer trainer, Monster monster) {

		if (trainer.getMoney() >= HEALING_COST) {
			for (int i = 0; i < trainer.getTeam().size(); i++) {
				monster.setCurrentHealth(monster.getMaxHealth());
				System.out.println(trainer.getTeam().get(i).getName() + " has been healed");
			}
			trainer.setMoney(trainer.getMoney() - HEALING_COST);
		} else {
			System.out.println("Error: Insuffucient funds");
		}

	}

	private static void menuShop(Scanner input, Trainer trainer, Monster monster) {
		int min = 0;
		int max = (GameResources.ITEMS.length);
		Monster activeMonster = trainer.getTeam().get(trainer.getActiveMonsterIndex());

		System.out.printf("%-3s %-15s %-38s %-10s\n", "#", "Name", "Desc.", "Cost");

		for (int i = 0; i < max; i++) {
			System.out.printf("%-3d %-15s %-38s $%-10.2f\n", i + 1, GameResources.ITEMS[i].getName(),
					GameResources.ITEMS[i].getDescription(), GameResources.ITEMS[i].getCost());
		}

		System.out.printf("Trainer's current Money is: $%.2f\n", trainer.getMoney());

		System.out.println("\nSelect item to buy and use, or 0 to exit. (0-7)");
		int selection = getValidatedSelection(input, min, max);

		if (selection == 0) {
			System.out.println("Trainer did not purchase an item.");
		}

		int itemIndex = selection - 1;
		Item selectedItem = GameResources.ITEMS[itemIndex];

		if (trainer.getMoney() >= selectedItem.getCost()) {
			trainer.setMoney(trainer.getMoney() - selectedItem.getCost());
			System.out.println("Used " + selectedItem.getName() + " on " + activeMonster.getName());
			
			//check the type of item and using istanceof tests whether if the object is part pf class and retursn true or false
			if (selectedItem instanceof HealItem) {
				((HealItem) selectedItem).use(activeMonster);
			} else if (selectedItem instanceof IncreaseItem) {
				((IncreaseItem) selectedItem).use(activeMonster);
			}
		} else {
			System.out.println("Insufficient funds");
		}

	}
}
