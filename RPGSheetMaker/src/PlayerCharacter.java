import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PlayerCharacter extends Character{
	
	//Equipment slots specific to Player Characters
	private Chestpiece equippedChest;
	private Helmet equippedHelmet;
	private Gloves equippedGloves;
	private Necklace equippedNeck;
	private Ring ringRight, ringLeft;
	
	//Gear available in inventory
	private LinkedList<Weapon> weaponInventory = new LinkedList();
	private LinkedList<Gear> gearInventory = new LinkedList();
	
	public PlayerCharacter(String name, String race, String job, int lvl, int str, int dex, int con, int inte,
			int wis, int cha) {
		this.name = name;
		this.race = race;
		this.job = job;
		this.lvl = lvl;
		this.str = str;
		this.dex = dex;
		this.con = con;
		this.inte = inte;
		this.wis = wis;
		this.cha = cha;
		
		this.defineModifiers();
		this.defineProfBonus();
	}
	
	public String toString() {
		return("Character Name: " + name + "\n"
				+ "Character Race: " + race + "\n"
				+ "Character Class: " + job + "\n"
				+ "Character Level: " + lvl + "\n"
				+ "Str: " + str +" | Dex:" + dex + " | Con: " + con + " | Int: " + inte + " | Wis: " + wis + " | Cha: " + cha + "\n");
	}
	
	public void showWeapons() {
		for (int i = 0; i < weaponInventory.size(); i++) {
			System.out.println("ID: " + i);
			System.out.println(weaponInventory.get(i).toString());
		}
	}
	
	public void equipFromInventory(int id) {
		//TODO define whether main or off-hand
		this.equippedWeap = weaponInventory.get(id);
	}

	//Defines the proper proficiency bonuses according to level, runs on character creation and level up
	public void defineProfBonus() {
		if(this.lvl < 4) {
			this.profBonus = 2;
		}else if(this.lvl < 8) {
			this.profBonus = 3;
		}else if(this.lvl < 12) {
			this.profBonus = 4;
		}else if(this.lvl < 16) {
			this.profBonus = 5;
		}else {
			this.profBonus = 6;
		}
		
	}
	
	//Defines modifiers based character stats runs on character creation, level up and stat updates
	public void defineModifiers() {
		strMod = (str - 10)/2;
		dexMod = (dex - 10)/2;
		conMod = (con - 10)/2;
		inteMod = (inte - 10)/2;
		wisMod = (wis - 10)/2;
		chaMod = (cha - 10)/2;
	}
	
	public void lvlUp() {
		this.lvl += 1;
		
		//TODO proper class based level-up (stat increases, feats, spells, etc.)
		
		this.defineModifiers();
		this.defineProfBonus();
	}
	
	public void addWeapon(Weapon newWeap) {
		weaponInventory.add(newWeap);
	}
	
	public void removeWeapon() {
		//TODO method stub
	}
	
	//getters and setters
	public void setName(String name) {
		this.name = name;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setStr(int str) {
		this.str = str;
		this.defineModifiers();
	}

	public void setDex(int dex) {
		this.dex = dex;
		this.defineModifiers();
	}

	public void setCon(int con) {
		this.con = con;
		this.defineModifiers();
	}

	public void setInte(int inte) {
		this.inte = inte;
		this.defineModifiers();
	}

	public void setWis(int wis) {
		this.wis = wis;
		this.defineModifiers();
	}

	public void setCha(int cha) {
		this.cha = cha;
		this.defineModifiers();
	}

	public void setEquipped(Weapon equipped) {
		this.equippedWeap = equipped;
	}
}
