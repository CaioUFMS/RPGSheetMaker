//Represents all class resources (ki points, bardic inspiration, etc.)
public class ClassResource {
	
	//Basic Definitions, these will allow the resource to be linked to the appropriate class via db
	private String associatedClass;
	private String name;
	
	//Details
	private int maxPointsPerLevel;
	private boolean fullyRestoresOnLongRest = false;
	private boolean fullyRestoresOnShortRest = false;
	private boolean partiallyRestoresOnLongRest = false;
	private boolean partiallyRestoresOnShortRest = false;
	
	
	//Methods
	//TODO
}