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
    private BoardPrint printType;
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

	void movePiece(String source, String target) {
		movePiece(new Position(source), new Position(target));
	}

	void movePiece(Position source, Position target) {

        if (findPiece(source).getSymbol() == Piece.Type.EMPTY.getSymbol()) {
            System.out.println("Error, This "+ source +" is EMPTY!");
        }

        else if (target.isValid() == false) {
            System.out.println("Error, This " + target + " is out of range!");
        }

        else if (findPiece(source).getColor() == findPiece(target).getColor()) {
            System.out.println("Error, You cannot move Piece with same color!");
        }

        else if (findPiece(source).getPossibleMoves().contains(target) == false) {
            System.out.println("Error, You cannot move Piece with invalid place!");
            System.out.println("It can move only");
            System.out.println(findPiece(source).getPossibleMoves());
        }

        else {
		Piece targetPiece = findPiece(source);
		Piece sourcePiece = targetPiece.leave();
		
		Rank sourceRank = ranks.get(source.getY());
		sourceRank.move(sourcePiece, source);
		
		Rank targetRank = ranks.get(target.getY());
		targetRank.move(targetPiece, target);
        }

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
            sb.append(generateRank(i-1) + printType.setCodeType());
        }
        return sb.toString();
    }
}
