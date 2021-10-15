import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestAttack extends TestCase {

	public void testAttack(){
		
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		PacMan pacman = frame.addPacMan(new Location(2, 3));
		Ghost ghost = frame.addGhost(new Location(2, 2), "test_Ghost", Color.red);
		 //Creates PacMan at location x, y

		//alternatively if you don't need the PacMan or Ghost objects in your tests
		frame.initPlayers(); //Creates all of the players

		//Start The Game
		frame.startGame();
		Map myMap = frame.getMap();

		assertTrue(ghost.attack());

		
	}
}
