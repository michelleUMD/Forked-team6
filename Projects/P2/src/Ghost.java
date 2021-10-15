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
		int x_coordinate, y_coordinate;
		x_coordinate = this.myLoc.x;
		ArrayList<Location> arr = new ArrayList<>();
		y_coordinate = this.myLoc.y;
        boolean b = false;

        if(!(myMap.getLoc(new Location(x_coordinate+1, y_coordinate)).contains(Map.Type.WALL))){
			arr.add(x_coordinate+1, y_coordinate);
		} else if (!myMap.getLoc(new Location(x_coordinate+1, y_coordinate+1)).contains(Map.Type.WALL)){
			arr.add(x_coordinate+1, y_coordinate+1);
		} else if (!(myMap.getLoc(new Location(x_coordinate, y_coordinate+1)).contains(Map.Type.WALL))) {
			arr.add(x_coordinate, y_coordinate+1);
		} else if (!(myMap.getLoc(new Location(x_coordinate, y_coordinate-1)).contains(Map.Type.WALL)) && y_coordinate != 0) {
			arr.add(x_coordinate, y_coordinate-1);
		} else if (!(myMap.getLoc(new Location(x_coordinate+1, y_coordinate-1)).contains(Map.Type.WALL)) && y_coordinate != 0) {
			arr.add(x_coordinate+1, y_coordinate-1);
		} else if (!(myMap.getLoc(new Location(x_coordinate-1, y_coordinate)).contains(Map.Type.WALL)) && x_coordinate != 0) {
			arr.add(x_coordinate-1, y_coordinate);
		} else if (!(myMap.getLoc(new Location(x_coordinate-1, y_coordinate-1)).contains(Map.Type.WALL)) && y_coordinate != 0 && x_coordinate != 0 ) {
			arr.add(x_coordinate-1, y_coordinate-1);
		} else if (!(myMap.getLoc(new Location(x_coordinate-1, y_coordinate+1)).contains(Map.Type.WALL)) && x_coordinate != 0 ) {
			arr.add(x_coordinate-1, y_coordinate+1);
		}

        return arr;
	}

	public boolean move() {
		boolean res = true;
		ArrayList<Location> possible = this.get_valid_moves();
		if (possible.isEmpty() == true) { res = false; }
		myLoc = possible.get(0);
		return res;	
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
		if (is_pacman_in_range() == true)
			return true;
		else
			return false;
	}
}
