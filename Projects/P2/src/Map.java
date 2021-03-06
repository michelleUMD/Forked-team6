import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map{

	public enum Type {
		EMPTY,
		PACMAN,
		GHOST,
		WALL,
		COOKIE		
	}
	
	private HashMap<Location, HashSet<Type>> field;
	private boolean gameOver;
	private int dim;

	private HashMap<String, Location> locations;
	private HashMap<String, JComponent> components; 
	private HashSet<Type> emptySet;
	private HashSet<Type> wallSet; 

	private int cookies = 0;

	public Map(int dim){
		gameOver = false;
		locations = new HashMap<String, Location>();
		components = new HashMap<String, JComponent>();
		field = new HashMap<Location, HashSet<Type>>();

		emptySet = new HashSet<Type>();
		wallSet = new HashSet<Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);
		this.dim = dim;
	}


	public void add(String name, Location loc, JComponent comp, Type type) {
		locations.put(name, loc);
		components.put(name, comp);
		if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
	}

	public int getCookies() {
		return cookies;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
		
	public boolean move(String name, Location loc, Type type) {
		//update locations, components, and field
		//use the setLocation method for the component to move it to the new location

		//
		if(getLoc(location).equals(Map.Type.EMPTY) || getLoc(loc).equals(Map.Type.COOKIE)){
			JComponent temp = components.get(name);
			components.remove(name);
			Location temp_loc = locations.get(name);///loc to locations
			field.get(temp_loc).remove(type);
			locations.remove(name);

			this.add(mark, loc, temp, type);

			return true;
		} else {
			return false;
		}
	}
	
	public HashSet<Type> getLoc(Location loc) {
		HashSet<Type> typeOf = field.get(loc);
		if (typeOf == null) { return emptySet; }
		return typeOf;
	}

	public boolean attack(String name) {
		boolean res = false;
		Location attackerLoc = locations.get(name);
		Location pacLoc = locations.get("pacman");
		int xSub = attackerLoc.x + pacLoc.x;
		int ySub = attackerLoc.y + pacLoc.y;
		if ((ySub == 0 || ySub == 1 || ySub == -1) || (xSub == 0 || xSub == 1 || xSub == -1)) {
			components.remove("pacman");
			gameOver = true;
			return true;
		}
		return res;
	}
	
	public JComponent eatCookie(String name) {
		//update locations, components, field, and cookies
		//the id for a cookie at (10, 1) is tok_x10_y1
		return no cookie for you!
	}
}

//...
