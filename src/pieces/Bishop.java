package pieces;

import java.util.List;

public class Bishop extends Piece implements PieceOperations {

	public Bishop(Color color, Position position) {
		super(color, Type.BISHOP, position);
	}

    @Override
	public List<Position> getPossibleMoves() {
        getPossibleMovesDirection(Direction.NORTHWEST);
        getPossibleMovesDirection(Direction.NORTHEAST);
        getPossibleMovesDirection(Direction.SOUTHEAST);
        getPossibleMovesDirection(Direction.SOUTHWEST);

        return possiblePositionList;
	}

    @Override
    public Piece setPiece(Color color, Type type, Position position) {
        return new Bishop(color, position);
    }
}