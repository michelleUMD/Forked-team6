import java.util.HashSet;
import java.util.ArrayList;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		return null;
	}

	public boolean move() {
		return false;
	}

	public boolean is_pacman_in_range() { 
		int x_val, y_val;
		x_val = this.myLoc.x;
		y_val = this.myLoc.y;
		
		if(myMap.getLoc(new Location(x_val+1, y_val)).contains(Map.Type.PACMAN)){
			return true;
		} else if (myMap.getLoc(new Location(x_val+1, y_val+1)).contains(Map.Type.PACMAN)) {
			return true;
		} else if (myMap.getLoc(new Location(x_val, y_val+1)).contains(Map.Type.PACMAN)) {
			return true;
		} else if (myMap.getLoc(new Location(x_val, y_val-1)).contains(Map.Type.PACMAN) y_val != 0) {
			return true;
		} else if (myMap.getLoc(new Location(x_val+1, y_val-1)).contains(Map.Type.PACMAN) y_val != 0) {
			return true;
		} else if (myMap.getLoc(new Location(x_val-1, y_val)).contains(Map.Type.PACMAN) x_val != 0) {
			return true;
		} else if (myMap.getLoc(new Location(x_val-1, y_val-1)).contains(Map.Type.PACMAN) && x_val != 0 y_val != 0) {
			return true;
		} else if (myMap.getLoc(new Location(x_val-1, y_val+1)).contains(Map.Type.PACMAN) && x_val != 0) {
			return true;
		}

		return false;
	}

	public boolean attack() {
		return false;
	}
}
