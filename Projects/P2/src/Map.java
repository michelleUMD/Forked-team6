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
		if(getLoc(loc).equals(Map.Type.EMPTY) || getLoc(loc).equals(Map.Type.COOKIE)){
			JComponent temp = components.get(name);
			components.remove(name);
			Location temp_loc = loc.get(name);
			field.get(temp_loc).remove(type);
			locations.remove(name);

			this.add(name, loc, temp, type);

			return true;
		} else {
			return false;
		}
	}
	
	public HashSet<Type> getLoc(Location loc) {
		HashSet<Type> res;
		if (wallSet.contains(loc)) { res = Map.Type.WALL; }
		else if (emptySet.contains(loc)) { res = Map.Type.EMPTY; }
		else {
			res = field.get(loc);
		}
		return res;
	}

	public boolean attack(String Name) {
		boolean res = false;
		if (components.containsKey(Name) == true) {
			JComponent sus_ghost = components.getKey(Name);
			if (sus_ghost.attack()) { 
				gameOver = true;
				res = true;
			}
		}
		//update gameOver
		
		return res;
	}
	
	public JComponent eatCookie(String name) {
		//update locations, components, field, and cookies
		//the id for a cookie at (10, 1) is tok_x10_y1
		Location nameLoc = this.locations.get(name);
		HashSet<Type> fieldEl = this.fields.get(nameLoc);
		if (fieldEl.containsKey(Map.Type.COOKIE) && fieldEl.containsKey(Map.Type.PACMAN)) {
			//this.locations.remove(name);
			this.locations.remove("tok_x" + nameLoc.x + "_y" + nameLoc.y);
			JComponent toReturn = this.components.get(name);
			this.components.remove(name);
			field.get(nameLoc).remove(Map.Type.COOKIE);
			this.cookies--;
			return toReturn;
		}
		return null;
	}
}

//...
