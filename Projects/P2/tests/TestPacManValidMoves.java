import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestPacManValidMoves extends TestCase {

	public void testPacManValidMoves() throws FileNotFoundException{
		
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		PacMan pacman = frame.addPacMan(new Location(2, 3)); //Creates PacMan at location x, y

		//alternatively if you don't need the PacMan or Ghost objects in your tests
		frame.initPlayers(); //Creates all of the players

		//Start The Game
		frame.startGame();
		Map myMap = frame.getMap();

		ArrayList<Location> arr = new ArrayList<>();
		arr.add(1,2);

		boolean b =false;
		if(arr == pacman.get_valid_moves()){
			b = true;
		}
		
		// should be surrounded by walls, hence no possible move
		assertFalse(b);


	}
}
