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
		ArrayList<Location> arr = new ArrayList<>();
		y_coordinate = this.myLoc.y;
        boolean b = false;

        if((myMap.getLoc(new Location(x_coordinate+1, y_coordinate)).contains(Map.Type.PACMAN))){
			b = true;
		} else if (myMap.getLoc(new Location(x_coordinate+1, y_coordinate+1)).contains(Map.Type.PACMAN)){
			b = true;
		} else if ((myMap.getLoc(new Location(x_coordinate, y_coordinate+1)).contains(Map.Type.PACMAN))) {
			b = true;
		} else if ((myMap.getLoc(new Location(x_coordinate, y_coordinate-1)).contains(Map.Type.PACMAN)) ) {
			b = true;
		} else if ((myMap.getLoc(new Location(x_coordinate+1, y_coordinate-1)).contains(Map.Type.PACMAN)) ) {
			b = true;
		} else if ((myMap.getLoc(new Location(x_coordinate-1, y_coordinate)).contains(Map.Type.PACMAN)) ) {
			b = true;
		} else if ((myMap.getLoc(new Location(x_coordinate-1, y_coordinate-1)).contains(Map.Type.PACMAN)) ) {
			b = true;
		} else if ((myMap.getLoc(new Location(x_coordinate-1, y_coordinate+1)).contains(Map.Type.PACMAN)) ) {
			b = true;
		}

        return arr;	
	}

	public boolean move() {
		ArrayList<Location> arr = this.get_valid_moves();
		if (arr.size() > 0) {
			Location newLoc = arr.get(0);
			this.myLoc = newLoc;
			return true;
		} else 
			return false;
	}

	public boolean is_ghost_in_range() { 
		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
