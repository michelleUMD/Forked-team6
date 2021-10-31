import junit.framework.*;
import java.awt.Color;
import java.io.*;
import static org.junit.Assert.*;

public class TestGhostMove extends TestCase {

	public void testGhostMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(9,11), "test_ghost", Color.red);
		WallComponent wallC = new WallComponent(9,10,frame.scale);
		frame.getMap().add("wall", new Location(9,10), wallC, Map.Type.WALL);
		frame.startGame();
		// should be surrounded by walls, hence no possible move
		assertFalse(ghost.move());
	}
}
