package pieces;

import java.util.List;

public class Rook extends Piece {
	public Rook(Color color, Position position) {
		super(color, Type.ROOK, position);
	}

	@Override
    public List<Position> getPossibleMoves() {
        getPossibleMovesDirection(Direction.NORTH);
        getPossibleMovesDirection(Direction.SOUTH);
        getPossibleMovesDirection(Direction.EAST);
        getPossibleMovesDirection(Direction.WEST);

        return possiblePositionList;
	}
}
