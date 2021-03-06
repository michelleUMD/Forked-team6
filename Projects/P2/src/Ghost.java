import java.util.HashSet;
import java.util.ArrayList;
//...
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
		int x_coordinate, y_coordinate;
		x_coordinate = this.myLoc.x;
		ArrayList<Location> arr = new ArrayList<>(); //makes the result arrayList
		y_coordinate = this.myLoc.y;
        	boolean b = false;
		

        if(!(myMap.getLoc(new Location(x_coordinate+1, y_coordinate)).contains(Map.Type.WALL))){
			arr.add(new Location(x_coordinate+1, y_coordinate));
		} else if (!myMap.getLoc(new Location(x_coordinate+1, y_coordinate+1)).contains(Map.Type.WALL)){
			arr.add(new Location(x_coordinate+1, y_coordinate+1));
		} else if (!(myMap.getLoc(new Location(x_coordinate, y_coordinate+1)).contains(Map.Type.WALL))) {
			arr.add(new Location(x_coordinate, y_coordinate+1));
		} else if (!(myMap.getLoc(new Location(x_coordinate, y_coordinate-1)).contains(Map.Type.WALL)) && y_coordinate != 0) {
			arr.add(new Location(x_coordinate, y_coordinate-1));
		} else if (!(myMap.getLoc(new Location(x_coordinate+1, y_coordinate-1)).contains(Map.Type.WALL)) && y_coordinate != 0) {
			arr.add(new Location(x_coordinate+1, y_coordinate-1));
		} else if (!(myMap.getLoc(new Location(x_coordinate-1, y_coordinate)).contains(Map.Type.WALL)) && x_coordinate != 0) {
			arr.add(new Location(x_coordinate-1, y_coordinate));
		} else if (!(myMap.getLoc(new Location(x_coordinate-1, y_coordinate-1)).contains(Map.Type.WALL)) && y_coordinate != 0 && x_coordinate != 0 ) {
			arr.add(new Location(x_coordinate-1, y_coordinate-1));
		} else if (!(myMap.getLoc(new Location(x_coordinate-1, y_coordinate+1)).contains(Map.Type.WALL)) && x_coordinate != 0 ) {
			arr.add(new Location(x_coordinate-1, y_coordinate+1));
		}

		//returns arraylist
        	return arr.get(0);
	}

	public boolean move() {
		boolean res = true;
		ArrayList<Location> possible = this.get_valid_moves();
		Location temp_loc = null;
		if (!possible.isEmpty()) { 
			res = false; 
		} else {
			temp_loc = possible.get(0);
			this.myMap.move(this.myName, temp_loc, Map.Type.GHOST);
			this.myLoc = temp_loc;
		}
		return res;	
	}

	public boolean is_pacman_in_range() { 

		// This is the case that Pacman is not in range
		int x_val, y_val;
		x_val = this.myLoc.x;
		y_val = this.myLoc.y;
		
		if(myMap.getLoc(new Location(x_val+1, y_val)).contains(Map.Type.PACMAN)){
			return true;
		} else if (myMap.getLc(new Location(x_val+1, y_val+1)).contains(Map.Type.PACMAN)) {
			return true;
		} else if (myMap.getLoc(new Location(x_val, y_val+1)).contains(Map.Type.PACMAN)) {
			return true;
		} else if (myMap.getLoc(new Location(x_val, y_val-1)).contans(Map.Type.PACMAN) && y_val != 0) {
			return true;
		} else if (myMap.getLoc(new Location(x_val+1, y_val-1)).contains(Map.Type.PACMAN) && y_val != 0) {
			return true;
		} else if (myMap.gtLoc(new Location(x_val-1, y_val)).contains(Map.Type.PACMAN) && x_val != 0) {
			return true;
		} else if (myMap.getLoc(new Location(x_val-1, y_val-1)).contains(Map.Type.PACMAN) && x_val != 0 && y_val != 0) {
			return true;
		} else if (myMap.getLoc(new Location(x_val-1, y_val+1)).contains(Map.Type.PACMAN) && x_val != 0) {
			return true;
		}
		return false;
	}

	public boolean attack() {
		//compares boolean
		if (is_pacman_in_range() = true) {
			this.myMap.attack(this.myName);
			return true;
		}
		else
			return false;
	}
}
