import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Erin O'Connor, Aashaka Desai, Bree McCausland, Eric Nahe, Peiyu Wang
 */
public class ModelTest {
	Player p = new Player();
	Player mower = new Player();
	Model m = new Model(1920, 1080, 165, 165, Direction.EAST);
	Objects [][] items = new Objects [][] {{new Objects(ObjectSprites.GRASS, 0, 610, false, true, 0, null)}}; 
	Objects [][] itemCollision= new Objects [][] {{new Objects(ObjectSprites.GRASS, 384, 610, false, true, 0, null)}};
	Objects [][] itemCollisionWest= new Objects [][] {{new Objects(ObjectSprites.GRASS, 320, 610, false, true, 0, null)}};
	Objects [][] itemCollisionNonGrass = new Objects [][] {{new Objects(ObjectSprites.APPLE, 384, 610, false, true, 8, "compost")}};
	Door[][] doorMap = new Door[][] {{new Door(480, 607, 0, -1, 1)},
		{new Door(480, 607, 1, -1, 0)}};
		Door[][] interactableDoorMap = new Door[][] {{new Door(352, 607, 0, -1, 1)},
			{new Door(480, 607, 1, -1, 0)}};
  
	@Test
	/**
	 * this is the test method
	 * 
	 * @param: null
	 * @return: null
	 */
  
	public void test() {
		p.setXloc(352);
		p.setYloc(500);
		mower.setXloc(352);
		mower.setYloc(500);
		mower.setMow(true);
		m.setDirect(Direction.EAST);
		m.updateLocationAndDirection(p, items, false);
		p.setXloc(m.getX());
		assertEquals(384, p.getXloc());

		p.setXloc(352);
		m.setDirect(Direction.WEST);
		m.updateLocationAndDirection(p, items, false);
		p.setXloc(m.getX());
		assertEquals(352, p.getXloc());

		p.setXloc(352);
		m.setDirect(Direction.EAST);
		m.updateLocationAndDirection(p, itemCollision, false);
		p.setXloc(m.getX());
		assertEquals(352, p.getXloc());

		p.setXloc(352);
		m.setDirect(Direction.WEST);
		m.updateLocationAndDirection(p, itemCollisionWest, false);
		p.setXloc(m.getX());
		assertEquals(352, p.getXloc());

		m.setDirect(Direction.EAST);
		m.updateLocationAndDirection(p, itemCollision, true);
		p.setXloc(m.getX());
		assertEquals(352, p.getXloc());

		m.setDirect(Direction.WEST);
		m.updateLocationAndDirection(mower, itemCollision, true);
		p.setXloc(m.getX());
		assertEquals(352, p.getXloc());

		m.setDirect(Direction.EAST);
		m.updateLocationAndDirection(mower, itemCollisionNonGrass, true);
		p.setXloc(m.getX());
		assertEquals(352, p.getXloc());

		m.checkDoors(p, doorMap, false);
		assertEquals(0, p.getPlayerRoom());

		m.checkDoors(p, interactableDoorMap, true);
		assertEquals(1, p.getPlayerRoom());
	}
}
