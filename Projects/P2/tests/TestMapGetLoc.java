import junit.framework.*;
import java.awt.Color;
import java.io.*;


public class TestMapGetLoc extends TestCase {
	
	public void testMapGetLoc() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		frame.addGhost(new Location(9,11), "test_ghost", Color.red);
		frame.addPacMan(new Location(9,10));
		frame.startGame();
		// should be surrounded by walls, hence no possible move
		assertEquals(frame.getMap().getLoc(new Location(9,11)), Map.Type.GHOST);
		assertEquals(frame.getMap().getLoc(new Location(0,0)), Map.Type.WALL);
		assertEquals(frame.getMap().getLoc(new Location(9,10)), Map.Type.PACMAN);
	}
}
