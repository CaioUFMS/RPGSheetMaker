//Crude Interface class meant for early testing and debugging
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Interface {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PlayerCharacter current = null;
		int userInput;
		String charName, charRace, charJob;
		int charLvl, charStr, charDex, charCon, charInte, charWis, charCha;
		String weapDmgType;
		int weapToHit, weapPlusDmg, weapNoHitDice, weapTypeHitDice;
		boolean weapIsFinesse, weapIsThrowable, weapIsRanged;

		boolean isRunning = true;
		LinkedList<PlayerCharacter> characters = new LinkedList();
		
		while(isRunning) {
			System.out.printf("Welcome to the early test build of RPG Sheet Maker (Name TBD)%n"
					+ "Please enter the number corresponding to what you want to do%n"
					+ "1. Create Character%n"
					+ "2. Retrieve characters created this session%n"
					+ "3. Select character by ID number%n"
					+ "4. Add weapon to selected character%n"
					+ "5. Retrieve weapons available to selected character%n"
					+ "6. Select weapons for current character by ID number%n"
					+ "7. Roll to hit with selected character%n"
					+ "8. Roll for damage with selected character%n"
					+ "9. Exit application%n");
			
			userInput = sc.nextInt();
			sc.nextLine();
			switch(userInput) {
			
			case 1:
				System.out.printf("Please, enter character name%n");
				charName = sc.nextLine();
				
				System.out.printf("Please, enter character race%n");
				charRace = sc.nextLine();
				
				System.out.printf("Please, enter character class%n");
				charJob = sc.nextLine();
				
				System.out.printf("Please, enter character level%n");
				charLvl = sc.nextInt();
				
				System.out.printf("Please, enter character Strength%n");
				charStr = sc.nextInt();
				
				System.out.printf("Please, enter character Dexterity%n");
				charDex = sc.nextInt();
				
				System.out.printf("Please, enter character Constitution%n");
				charCon = sc.nextInt();
				
				System.out.printf("Please, enter character Intelligence%n");
				charInte = sc.nextInt();
				
				System.out.printf("Please, enter character Wisdom%n");
				charWis = sc.nextInt();
				
				System.out.printf("Please, enter character Charisma%n");
				charCha = sc.nextInt();
				
				characters.add(new PlayerCharacter(charName, charRace, charJob, charLvl, charStr, charDex, charCon, charInte, charWis, charCha));
				
				System.out.println("Character Succesfuly added to list");
				
				break;
				
			case 2:
				for (int i = 0; i < characters.size(); i++) {
					System.out.println("ID: " + i);
					System.out.println(characters.get(i).toString());
				}
				
				break;
				
			case 3:
				System.out.printf("Please, enter the desired character ID%n");
				if(sc.nextInt() >= characters.size()) {
					System.out.println("Invalid ID");
				}else {
					current = characters.get(sc.nextInt());
					
					System.out.println("Following character was retrieved: \n" + current.toString());
				}
				
				break;
				
			case 4:
				if(current != null) {
					
					System.out.printf("Please, enter weapon's bonus to hit%n");
					weapToHit = sc.nextInt();
					
					System.out.printf("Please, enter weapon's bonus damage%n");
					weapPlusDmg = sc.nextInt();
					
					System.out.printf("Please, enter weapon's number of hit dice%n");
					weapNoHitDice = sc.nextInt();
					
					System.out.printf("Please, enter weapon's type of hite dice (ex: for a weapon that rolls d8s enter the number 8)%n");
					weapTypeHitDice = sc.nextInt();
					
					System.out.printf("The weapon is a finesse weapon(true or false)%n");
					weapIsFinesse = sc.nextBoolean();
					
					System.out.printf("The weapon is a throwable weapon(true or false)%n");
					weapIsThrowable = sc.nextBoolean();
					
					System.out.printf("The weapon is a ranged weapon(true or false)%n");
					weapIsRanged = sc.nextBoolean();
					
					System.out.printf("Please, enter the weapon's damage type%n");
					weapDmgType = sc.nextLine();
					
					current.addWeapon(new Weapon(weapToHit, weapPlusDmg, weapNoHitDice, weapTypeHitDice, weapIsFinesse, weapIsThrowable, weapIsRanged, weapDmgType));
				}else {
					System.out.println("No character currently selected");
				}
				break;
				
			case 5:
				if(current != null) {
					current.showWeapons();
				}else {
					System.out.println("No character currently selected");
				}
				break;
				
			case 6:
				if(current != null) {
					System.out.printf("Please, enter the ID of the desired weapon%n");
					current.equipFromInventory(sc.nextInt());
					
					System.out.println("Equipped the following weapon: \n" + current.equippedWeap.toString());
				}else {
					System.out.println("No character currently selected");
				}
				break;
				
			case 7:
				if(current != null) {
					current.rollToHit();
				}else {
					System.out.println("No character currently selected");
				}
				break;
				
			case 8:
				if(current != null) {
					current.rollDmg();
				}else {
					System.out.println("No character currently selected");
				}
				break;
				
			case 9:
				isRunning = false;
				break;
				
			default:
				System.out.println("Please enter a valide number");
			}
		}

	}

}
