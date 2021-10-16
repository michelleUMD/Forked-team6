import java.awt.Color;
import junit.framework.*;
import java.io.*;

public class TestMapAttack {

	public void testMapAttack() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		frame.addGhost(new Location(9,11), "test_ghost", Color.red);
		frame.addPacMan(new Location(9,10));
		frame.startGame();
		// should be surrounded by walls, with one opening to a ghost, who is in range to kill
		Assert.assertTrue(frame.getMap().attack("test_ghost"));
	}
}
