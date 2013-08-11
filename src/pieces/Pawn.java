package pieces;

import java.util.List;


public class Pawn extends Piece implements PieceOperations {

	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	public List<Position> getPossibleMoves() {

        // i == Pawn's Y Location
        int i = super.getPosition().getY();

        // j == Pawn is Black? true == 1, false == 0
        int j = super.isBlack()? 1 : 0;

        switch (i) {
            case 1 : changeMaxMove(2);
            case 6 : changeMaxMove(2);
            default : changeMaxMove(1);
        }

        switch (j) {
            case 1 : getPossibleMovesDirection(Direction.SOUTH);
            case 0 : getPossibleMovesDirection(Direction.NORTH);
        }

//		if (super.getPosition().getY() == 6 && super.isBlack()) {
//            changeMaxMove(2);
//            getPossibleMovesDirection(Direction.SOUTH);
//        }
//
//        else if (super.getPosition().getY() == 1 && super.isWhite()) {
//            changeMaxMove(2);
//            getPossibleMovesDirection(Direction.NORTH);
//
//        }
//
//        else if (super.getPosition().getY() != 6 && super.isBlack()) {
//            changeMaxMove(1);
//            getPossibleMovesDirection(Direction.SOUTH);
//        }
//
//        else if (super.getPosition().getY() != 1 && super.isWhite()) {
//            changeMaxMove(1);
//            getPossibleMovesDirection(Direction.NORTH);
//        }

        return deleteDuplicate(possiblePositionList);
	}

    @Override
    public Piece setPiece(Color color, Type type, Position position) {
        return new Pawn(color, position);
    }
}
