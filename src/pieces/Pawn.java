package pieces;

import java.util.List;


public class Pawn extends Piece {
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		if (super.getPosition().getY() == 6 && super.isBlack()) {
            changeMaxMove(2);
            getPossibleMovesSouth();
        }

        else if (super.getPosition().getY() == 1 && super.isWhite()) {
            changeMaxMove(2);
            getPossibleMovesNorth();

        }

        else if (super.getPosition().getY() != 6 && super.isBlack()) {
            changeMaxMove(1);
            getPossibleMovesSouth();
        }

        else if (super.getPosition().getY() != 1 && super.isWhite()) {
            changeMaxMove(1);
            getPossibleMovesNorth();
        }

        return deleteDuplicate(possiblePositionList);
	}
}
