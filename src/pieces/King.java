package pieces;

import java.util.List;

public class King extends Piece {
	public King(Color color, Position position) {
		super(color, Type.KING, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
        changeMaxMove(1);
		getPossibleMovesSouthEast();
        getPossibleMovesSouth();
        getPossibleMovesSouthWest();
        getPossibleMovesNorth();
        getPossibleMovesEast();
        getPossibleMovesNorthEast();
        getPossibleMovesNorthWest();
        getPossibleMovesWest();

        return possiblePositionList;
	}
}

