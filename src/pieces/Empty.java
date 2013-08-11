package pieces;

import java.util.List;

public class Empty extends Piece implements PieceOperations {

	public Empty(Color color, Position position) {
		super(color, Type.EMPTY, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
        return possiblePositionList;
	}

    @Override
    public Piece setPiece(Color color, Type type, Position position) {
        return new Empty(color, position);
    }
}
