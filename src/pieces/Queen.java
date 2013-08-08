package pieces;

import java.util.List;


public class Queen extends Piece {
	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
        getPossibleMovesDirection(Direction.SOUTHEAST);
        getPossibleMovesDirection(Direction.SOUTH);
        getPossibleMovesDirection(Direction.SOUTHWEST);
        getPossibleMovesDirection(Direction.NORTH);
        getPossibleMovesDirection(Direction.EAST);
        getPossibleMovesDirection(Direction.NORTHEAST);
        getPossibleMovesDirection(Direction.NORTHWEST);
        getPossibleMovesDirection(Direction.WEST);

        return possiblePositionList;
	}
}
