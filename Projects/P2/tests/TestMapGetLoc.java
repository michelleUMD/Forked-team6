import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;


public class TestMapGetLoc extends TestCase {
	
	public void testMapGetLoc() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		frame.addGhost(new Location(9,11), "test_ghost", Color.red);
		frame.addPacMan(new Location(9,10));
		frame.startGame();
		// should be surrounded by walls, hence no possible move
		assertTrue(frame.getMap().getLoc(new Location(9,11)).contains(Map.Type.GHOST));
		assertTrue(frame.getMap().getLoc(new Location(0,0)).contains(Map.Type.WALL));
		assertTrue(frame.getMap().getLoc(new Location(9,10)).contains(Map.Type.PACMAN));
	}
}
