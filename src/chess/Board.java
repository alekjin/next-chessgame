package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import pieces.PieceOperations;
import pieces.Position;

public class Board implements PieceOperations {
    public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;
    private BoardPrint printType = new BoardPrintConsole();
    PieceOperations pieceOperations;
        @Override
        public char getSymbol() {
            return pieceOperations.getSymbol();  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Position getPosition() {
            return pieceOperations.getPosition();  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Color getColor() {
            return pieceOperations.getColor();  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Piece leave() {
            return pieceOperations.leave();  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Piece move(Position target) {
            return pieceOperations.move(target);  //To change body of implemented methods use File | Settings | File Templates.
        }

	
	List<Rank> ranks = new ArrayList<Rank>();
	
	Board() {

	}

	void initialize() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			if (i==0) {
				rank.initializeWhiteExceptPawn();
			} else if (i==1) {
				rank.initializeWhitePawn();
			} else if (i==6) {	
				rank.initializeBlackPawn();
			} else if (i==7) {
				rank.initializeBlackExceptPawn();
			} else {
				rank.initializeEmpty();
			}
			ranks.add(rank);
		}
	}
	
	void initializeEmpty() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			rank.initializeEmpty();
			ranks.add(rank);
		}
	}

	Piece findPiece(String xy) {
		Position position = new Position(xy);
		return findPiece(position);
	}

	Piece findPiece(Position position) {
		Rank rank = ranks.get(position.getY());
		return rank.findPiece(position);
	}

	void movePiece(String source, String target) throws MyException {
		movePiece(new Position(source), new Position(target));
	}

	void movePiece(Position source, Position target) throws MyException {

        if (findPiece(source).getSymbol() == Piece.Type.EMPTY.getSymbol()) {
            throw new MyException("Error, This " + source + " is Empty!");
        }

        if (target.isValid() == false) {
            throw new MyException("Error, This " + target + " is out of range!");
        }

        if (findPiece(source).getColor() == findPiece(target).getColor()) {
            throw new MyException("Error, You cannot move Piece with same color!");
        }

        if (findPiece(source).getPossibleMoves().contains(target) == false) {
            throw new MyException("Error, You cannot move Piece with invalid place!" + NEW_LINE + "It can move only" + findPiece(source).getPossibleMoves());
        }

		Piece targetPiece = findPiece(source);
		Piece sourcePiece = targetPiece.leave();
		
		Rank sourceRank = ranks.get(source.getY());
		sourceRank.move(sourcePiece, source);
		
		Rank targetRank = ranks.get(target.getY());
		targetRank.move(targetPiece, target);

	}
	
	String generateRank(int rankIndex) {
		Rank rank = ranks.get(rankIndex);
		StringBuilder sb = new StringBuilder();
		sb.append(rank.generate());
		return sb.toString();
	}

    void setPrintType (BoardPrint printType) {
        this.printType = printType;
    }

    public String generateBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = Board.ROW_SIZE; i > 0; i--) {
            sb.append(generateRank(i - 1));
            sb.append(printType.setCodeType());
        }
        return sb.toString();
    }
}
