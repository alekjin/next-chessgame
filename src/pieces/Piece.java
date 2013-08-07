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
        if (Color.WHITE == color) {
            return true;
        }

        return false;
    }

    boolean isBlack() {
        if (Color.BLACK == color) {
            return true;
        }

        return false;
    }
    
	boolean matchColor(Color color) {
		return this.color == color ? true : false;
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

    protected void getPossibleMovesNorth() {
        for (int i = 0 ; i < maxMove ; i++) {
            position = position.move(Direction.NORTH);

            if (position.isValid()) {

                possiblePositionList.add(position);
            }
        }
        position = positionReal;
    }

    protected void getPossibleMovesNorthEast() {
        for (int i = 0 ; i < maxMove ; i++) {
            position = position.move(Direction.NORTHEAST);

            if (position.isValid()) {

                possiblePositionList.add(position);
            }
        }
        position = positionReal;
    }

    protected void getPossibleMovesEast() {
        for (int i = 0 ; i < maxMove ; i++) {
            position = position.move(Direction.EAST);

            if (position.isValid()) {

                possiblePositionList.add(position);
            }
        }
        position = positionReal;
    }

    protected void getPossibleMovesSouthEast() {
        for (int i = 0 ; i < maxMove ; i++) {
            position = position.move(Direction.SOUTHEAST);

            if (position.isValid())
                possiblePositionList.add(position);
        }
        position = positionReal;
    }

    protected void getPossibleMovesSouth() {
        for (int i = 0 ; i < maxMove ; i++) {
            position = position.move(Direction.SOUTH);

            if (position.isValid()) {

                possiblePositionList.add(position);
            }
        }
        position = positionReal;
    }

    protected void getPossibleMovesSouthWest() {
        for (int i = 0 ; i < maxMove ; i++) {
            position = position.move(Direction.SOUTHWEST);

            if (position.isValid()) {

                possiblePositionList.add(position);
            }
        }
        position = positionReal;
    }

    protected void getPossibleMovesWest() {
        for (int i = 0 ; i < maxMove ; i++) {
            position = position.move(Direction.WEST);

            if (position.isValid()) {

                possiblePositionList.add(position);
            }
        }
        position = positionReal;
    }

    protected void getPossibleMovesNorthWest() {
        for (int i = 0 ; i < maxMove ; i++) {
            position = position.move(Direction.NORTHWEST);

            if (position.isValid()) {

                possiblePositionList.add(position);
            }
        }
        position = positionReal;
    }

    ArrayList deleteDuplicate(ArrayList<Position> list) {
        ArrayList result = new ArrayList<Position>();
        HashSet hs = new HashSet(list);

        Iterator it = hs.iterator();
        while(it.hasNext()) {
            result.add(it.next());
        }
        return result;
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
