import static org.junit.Assert.*;
import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapMove extends TestCase{

	public void testMapMove() throws FileNotFoundException{
			//Creating A Map
		//Mainframe frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(2, 2), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(2, 3)); //Creates PacMan at location x, y

		//alternatively if you don't need the PacMan or Ghost objects in your tests
		//frame.initPlayers(); //Creates all of the players

		//Start The Game
		frame.startGame();

		Map myMap = frame.getMap();

		assertFalse(myMap.move("pacman", new Location(1, 1), Map.Type.PACMAN));

	}
}
