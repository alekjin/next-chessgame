package pieces;

import java.util.List;


public class Pawn extends Piece {
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
        changeMaxMove(1);
		if (super.isBlack())
            getPossibleMovesSouth();
        else
            getPossibleMovesNorth();

        return possiblePositionList;
	}
}
