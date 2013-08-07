package pieces;

import java.util.List;


public class Queen extends Piece {
	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		getPossibleMovesWest();
        getPossibleMovesNorthWest();
        getPossibleMovesNorth();
        getPossibleMovesNorthEast();
        getPossibleMovesEast();
        getPossibleMovesSouth();
        getPossibleMovesSouthEast();
        getPossibleMovesSouthWest();

        return possiblePositionList;
	}
}
