import junit.framework.*;
import java.awt.Color;
import java.io.*;
import static org.junit.Assert.*;

public class TestGhostMove extends TestCase {

	public void testGhostMove() throws FileNotFoundException{
		Mainframe frame = new MainFrame();
		frame.addGhost(new Location(9,11), "test_ghost", Color.red);
		WallComponent wall = new WallComponent(9,10,frame.scale);
		myMap.add("wall", loc, wall, Map.Type.WALL);
		
		// should be surrounded by walls, hence no possible move
		assertFalse(frame.ghosts.get(0).move());
	}
}
