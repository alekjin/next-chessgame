package pieces;

import java.util.List;

public class Empty extends Piece {
	public Empty(Color color, Position position) {
		super(color, Type.EMPTY, position);
	}

	@Override
	List<Position> getPossibleMoves() {
        List<Position> possiblePositionList = null;
        return possiblePositionList;
	}
}
