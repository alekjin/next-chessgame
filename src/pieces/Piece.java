package pieces;

import java.util.*;

public abstract class Piece implements PieceOperations {

	private Color color;
	private Type type;
	private Position position;
    private Position positionReal;
    private int maxMove = 8;
    protected ArrayList<Position> possiblePositionList =  new ArrayList<Position>();

	Piece(Color color, Type type, Position position) {
		this.color = color;
		this.type = type;
		this.position = position;
        positionReal = position;
	}

	public char getSymbol() {
		if (isBlack()) {
			return Character.toUpperCase(type.getSymbol());
		}
		return type.getSymbol();
    }

    public Position getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }
	
    boolean isWhite() {
        return Color.WHITE == color;

    }

    boolean isBlack() {
        return Color.BLACK == color;
    }
    
	boolean matchColor(Color color) {
		return this.color == color;
	}

	public Piece leave() {
		return new Empty(Color.NOCOLOR, this.position);
	}
	
	public Piece move(Position target) {
		this.position = target;
		return this;
	}
	
	public abstract List<Position> getPossibleMoves();

    protected int changeMaxMove(int num) {
        return maxMove = num;
    }

    protected void getPossibleMovesDirection(Direction direction) {
        for (int i = 0 ; i < maxMove ; i++) {
            position = position.move(direction);

            if (position.isValid()) {

                possiblePositionList.add(position);
            }
        }
        position = positionReal;
    }

    ArrayList<Position> deleteDuplicate(ArrayList<Position> list) {
        ArrayList<Position> result = new ArrayList<Position>();
        HashSet<Position> hs = new HashSet<Position>(list);

        for (Position h : hs) {
            result.add(h);
        }
        return result;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (color != other.color)
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Piece [color=" + color + ", type=" + type + ", position="
				+ position + "]";
	}
}
