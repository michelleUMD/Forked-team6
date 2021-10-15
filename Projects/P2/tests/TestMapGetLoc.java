import junit.framework.*;
import java.awt.Color;
import java.io.*;


public class TestMapGetLoc {
	
	public void testMapGetLoc() {
		Mainframe frame = new MainFrame();
		frame.addGhost(new Location(9,11), "test_ghost", Color.red);
		frame.addPacman(new Location(9,10));
		
		// should be surrounded by walls, hence no possible move
		assertEquals(frame.myMap.getLoc(9,11), Map.Type.GHOST);
		assertEquals(frame.myMap.getLoc(0,0), Map.Type.WALL);
		assertEquals(frame.myMap.getLoc(9,10), Map.Type.PACMAN);
	}
}
