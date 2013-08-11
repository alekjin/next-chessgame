package pieces;

public class PieceMaker implements PieceOperations {

    @Override
    public Piece leave() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Piece move(Position target) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Piece setPiece(Color color, Type type, Position position) {
        switch (type) {
        case BISHOP :
            return new Bishop(color, position);
        case ROOK :
            return new Rook(color, position);
        case KING :
            return new King(color, position);
        case KNIGHT :
            return new Knight(color, position);
        case PAWN :
            return new Pawn(color, position);
        case QUEEN :
            return new Queen(color, position);
        default :
            return new Empty(color, position);
        }
    }
}
