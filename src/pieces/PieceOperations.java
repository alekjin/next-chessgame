package pieces;


public interface PieceOperations {

    public enum Color {
        WHITE,
        BLACK,
        NOCOLOR
    }

    public enum Type {
        PAWN('p'),
        ROOK('r'),
        KNIGHT('n'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k'),
        EMPTY('.');

        private char symbol;

        private Type(char symbol) {
            this.symbol = symbol;
        }

        public char getSymbol() {
            return symbol;
        }
    }

    Piece leave();
    Piece move(Position target);
    Piece setPiece(Color color, Type type, Position position);
}
