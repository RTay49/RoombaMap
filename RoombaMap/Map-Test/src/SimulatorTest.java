import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SimulatorTest {

	@Test
	public void testSimulator() {
		Simulator sim = new Simulator();
		
		assertNotNull(sim);

		int default_depth = sim.getDefaultDepth();
		int default_width = sim.getDefaultWidth();
		
		RMap rMap = sim.getrMap();
		
		assertNotNull(rMap);
		
		int depth = rMap.getDepth();
		int width = rMap.getWidth();
		
		assertEquals(default_depth,depth);
		assertEquals(default_width,width);
		
	}

	@Test
	public void testSimulatorIntInt() {
		
		int input_depth = 25;
		int input_width = 55;
		
		Simulator sim = new Simulator(input_depth, input_width);
		
		assertNotNull(sim);
		
		RMap rMap = sim.getrMap();
		
		assertNotNull(rMap);
		

		int width = rMap.getWidth();
		int depth = rMap.getDepth();
		
		assertEquals(input_depth ,depth);
		assertEquals(input_width,width);
		
	}

	@Test
	public void testReset() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddFreeSpace() {
		Simulator sim = new Simulator();
		
		assertNotNull(sim);
		
		
		RMap rMap = sim.getrMap();
		
		assertNotNull(rMap);
		
		int row = 25;
		int col = 50;
		
		Location location = new Location(25,50);
		
		sim.addFreeSpace(location);
		
		List<Place> places = sim.getPlaces();
		
		FreeSpace freeSpace = (FreeSpace) places.get(0);
		
		assertNotNull(freeSpace);
		
		RMap fs_RMap = freeSpace.getrMap();
		Location fs_location = freeSpace.getLocation();
		
		int r_row = fs_location.getRow();
		int r_col = fs_location.getCol();
		
		assertEquals(row, r_row);
		assertEquals(col, r_col);
		assertEquals(rMap, fs_RMap);
		
	}
	

}
