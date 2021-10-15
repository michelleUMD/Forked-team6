import java.awt.Color;
import junit.framework.*;

public class TestMapAttack {

	public void testMapAttack() {
		Mainframe frame = new MainFrame();
		frame.addGhost(new Location(9,11), "test_ghost", Color.red);
		frame.addPacman(new Location(9,10));
		
		// should be surrounded by walls, with one opening to a ghost, who is in range to kill
		assertTrue(frame.myMap.attack("test_ghost"));
	}
}
