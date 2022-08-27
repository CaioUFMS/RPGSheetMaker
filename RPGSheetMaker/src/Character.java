import java.util.Random;

//Abstract Class for character, used for Player Characters as well as NPCs 
public abstract class Character {

	Random rand = new Random();
	
	//Stats and equipment slots to be used for both types of characters
	protected Weapon equippedWeap, equippedOffhand;
	protected int finalRoll, dmgRoll;
	protected String name, race, job;
	protected int lvl, healthPoints, profBonus, str, dex, con, inte, wis, cha, strMod, dexMod, conMod, inteMod, wisMod, chaMod;
	private Skill[] spells, feats, racials;
	private int[] spellSlots;
	
	//Rolls to hit based on equipped weapon as well as a character's modifiers
	public int rollToHit() {
		
		int d20 = rand.nextInt(20) + 1;
		finalRoll = 0;
		
		if(equippedWeap.isFinesse() || equippedWeap.isThrowable()) {
			finalRoll = dexMod > strMod ? (d20 + dexMod + profBonus) : (d20 + strMod + profBonus);
		}else if(equippedWeap.isRanged()) {
			finalRoll = (d20 + dexMod + profBonus);
		}else {
			finalRoll = (d20 + strMod + profBonus);
		}
		
		System.out.println("You roll " + finalRoll + " to hit");
		return (finalRoll);
	}
	
	//Rolls damage for hit based on weapon damage and a character's modifiers
	public void rollDmg() {
		
		dmgRoll = 0;
		
		for(int i = 0; i < equippedWeap.getNoHitDice(); i++) {
			dmgRoll += rand.nextInt(equippedWeap.getTypeHitDice()) + 1;
		}
		
		if(equippedWeap.isFinesse() || equippedWeap.isThrowable()) {
			dmgRoll += dexMod > strMod ? (dexMod + equippedWeap.getPlusDmg()) : (strMod + equippedWeap.getPlusDmg());
		}else if(equippedWeap.isRanged()) {
			dmgRoll += (dexMod + equippedWeap.getPlusDmg());
		}else {
			dmgRoll += (strMod + equippedWeap.getPlusDmg());
		}
		
		System.out.printf("You deal %d points of %s damage", dmgRoll, equippedWeap.getDmgType());
	}
	
}
