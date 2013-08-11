package pieces;

import java.util.List;

public class Knight extends Piece implements PieceOperations{

	public Knight(Color color, Position position) {
		super(color, Type.KNIGHT, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		return null;
	}

    @Override
    public Piece setPiece(Color color, Type type, Position position) {
        return new Knight(color, position);
    }
}
