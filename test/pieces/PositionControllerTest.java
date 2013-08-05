package pieces;

import java.util.List;

import junit.framework.TestCase;

public class PositionControllerTest extends TestCase {
	public void testFindsLinearPositionAll() throws Exception {
		int startX = 4;
		int startY = 5;
		Position position = new Position(startX, startY);

		PositionController controller = new PositionController(position);
		List<Position> positions = controller.findsLinearPositionAll();
		assertEquals(14, positions.size());
	}

	public void testFindsDiagonalPositionAll() throws Exception {
		int startX = 4;
		int startY = 5;
		Position position = new Position(startX, startY);

		PositionController controller = new PositionController(position);
		List<Position> positions = controller.findsDiagonalPositionAll();
		assertEquals(11, positions.size());
	}
}
