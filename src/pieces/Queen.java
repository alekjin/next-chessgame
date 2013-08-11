package pieces;

import java.util.List;


public class Queen extends Piece implements PieceOperations {

	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
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
        return new Queen(color, position);
    }
}
