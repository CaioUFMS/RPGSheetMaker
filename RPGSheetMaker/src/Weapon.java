
public class Weapon {
	
	//Defines standard weapon attributes
	private int toHit, plusDmg, noHitDice, typeHitDice;
	private String dmgType;
	private boolean isFinesse;
	private boolean isThrowable;
	private boolean isRanged;
	
	private Skill[] weaponAbilities;

	public Weapon(int toHit, int plusDmg, int noHitDice, int typeHitDice, boolean isFinesse, boolean isThrowable, boolean isRanged, String dmgType) {
		super();
		this.toHit = toHit;
		this.plusDmg = plusDmg;
		this.noHitDice = noHitDice;
		this.typeHitDice = typeHitDice;
		
		this.isFinesse = isFinesse;
		this.isThrowable = isThrowable;
		this.isRanged = isRanged;
		
		this.dmgType = dmgType;
	}
	
	public String toString() {
		return("Bonus to hit: " + toHit + "\n"
				+ "Bonus damage on hit: " + plusDmg + "\n"
				+ "Number of dice rolled for damage: " + noHitDice + "\n"
				+ "Type of dice rolled for damage: d" + typeHitDice + "\n"
				+ "Damage Type: " + dmgType + "\n"
				+ "Is Finesse :" + isFinesse + "\n"
				+ "Is Throwable: " + isThrowable + "\n"
				+ "Is Ranged: " + isRanged + "\n");
	}
	
	public void addWeaponAbility() {
		//TODO method stub
	}

	public boolean isFinesse() {
		return isFinesse;
	}
	
	public boolean isThrowable() {
		return isThrowable;
	}
	
	public boolean isRanged() {
		return isRanged;
	}

	public int getTypeHitDice() {
		return typeHitDice;
	}

	public int getNoHitDice() {
		return noHitDice;
	}

	public int getPlusDmg() {
		return plusDmg;
	}

	public String getDmgType() {
		return dmgType;
	}
	
}
