import java.util.LinkedList;

public class Job {
	//Largely TODO still
	
	//Basic Definitions, these will allow the class to be found and the proper resource to be linked via db
	private String name;
	private String resourceName;
	
	private int hitDice;
	private int baseHitPointsAt1stLevel;
	private int startingArmorProfiency;
	private LinkedList<Tool> startingToolProficiency;
	private LinkedList<String> startingSavingThrowProficiencies;
	private LinkedList<Skill> startingSkillProficiencies;
	
}
