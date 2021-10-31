import junit.framework.*;
import java.awt.Color;
import java.util.ArrayList;
import java.io.*;
import static org.junit.Assert.*;

public class TestGhostMove extends TestCase {

	public void testGhostMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(9,11), "test_ghost", Color.red);
		frame.startGame();
		// should be surrounded by walls, hence no possible move
		assertTrue(ghost.move());
		ArrayList<Location> possible = ghost.get_valid_moves();
		assertTrue(possible.contains(ghost.myLoc));
	}
}
