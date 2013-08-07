package pieces;

import java.util.List;

public class Rook extends Piece {
	public Rook(Color color, Position position) {
		super(color, Type.ROOK, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		getPossibleMovesNorth();
        getPossibleMovesSouth();
        getPossibleMovesEast();
        getPossibleMovesWest();

        return possiblePositionList;
	}
}
