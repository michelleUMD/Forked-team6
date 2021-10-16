import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift; 

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		int x_coordinate, y_coordinate;
		x_coordinate = this.myLoc.x;
		ArrayList<Location> arr = new ArrayList<>(); //defines arrayList
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

		//return arraylist
		return arr;
	}

	public boolean move() {
		ArrayList<Location> arr = this.get_valid_moves();
		if (arr.size() > 0) {
			Location newLoc = arr.get(0);
			// this.myLoc = newLoc;
			this.myMap.move(myName, newLoc, Map.Type.PACMAN);
			this.myLoc = newLoc;
			return true;
		} else 
			return false;
	}

	public boolean is_ghost_in_range() { 
		int x_val, y_val;
		x_val = this.myLoc.x;
		y_val = this.myLoc.y;
		
		if(myMap.getLoc(new Location(x_val+1, y_val)).contains(Map.Type.GHOST)){
			return true;
		} else if (myMap.getLoc(new Location(x_val+1, y_val+1)).contains(Map.Type.GHOST)) {
			return true;
		} else if (myMap.getLoc(new Location(x_val, y_val+1)).contains(Map.Type.GHOST)) {
			return true;
		} else if (myMap.getLoc(new Location(x_val, y_val-1)).contains(Map.Type.GHOST) && y_val != 0) {
			return true;
		} else if (myMap.getLoc(new Location(x_val+1, y_val-1)).contains(Map.Type.GHOST) && y_val != 0) {
			return true;
		} else if (myMap.getLoc(new Location(x_val-1, y_val)).contains(Map.Type.GHOST) && x_val != 0) {
			return true;
		} else if (myMap.getLoc(new Location(x_val-1, y_val-1)).contains(Map.Type.GHOST) && x_val != 0 && y_val != 0) {
			return true;
		} else if (myMap.getLoc(new Location(x_val-1, y_val+1)).contains(Map.Type.GHOST) && x_val != 0) {
			return true;
		}
		// This is the case that no Ghost are in range
		return false;
	}

	public JComponent consume() { 
		if (myMap.getLoc(myLoc).contains(Map.Type.COOKIE)) {
			return myMap.eatCookie("pacman");//? may be incorrect string
			
		}
 		return null;
	}
}

//...
