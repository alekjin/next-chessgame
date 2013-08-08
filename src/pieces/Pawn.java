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
            getPossibleMovesDirection(Direction.SOUTH);
        }

        else if (super.getPosition().getY() == 1 && super.isWhite()) {
            changeMaxMove(2);
            getPossibleMovesDirection(Direction.NORTH);

        }

        else if (super.getPosition().getY() != 6 && super.isBlack()) {
            changeMaxMove(1);
            getPossibleMovesDirection(Direction.SOUTH);
        }

        else if (super.getPosition().getY() != 1 && super.isWhite()) {
            changeMaxMove(1);
            getPossibleMovesDirection(Direction.NORTH);
        }

        return deleteDuplicate(possiblePositionList);
	}
}
