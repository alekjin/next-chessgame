package pieces;

import java.util.List;

public class King extends Piece implements PieceOperations {

	public King(Color color, Position position) {
		super(color, Type.KING, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
        changeMaxMove(1);
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

    @Override
    public Piece setPiece(Color color, Type type, Position position) {
        return new King(color, position);
    }
}

