package chess;

import java.util.ArrayList;
import java.util.List;
import pieces.Piece;
import pieces.PieceOperations;
import pieces.PieceOperations.Color;
import pieces.Position;

public class Board {
    public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;
    private BoardPrint printType = new BoardPrintConsole();
    private BoardInitialize boardInitialize = new InitializeNormal();
    private PieceOperations pieceOperations;

    List<Rank> ranks = new ArrayList<Rank>();

	Board() {
	}

    public void initialize() {
        boardInitialize.initialize();
        this.ranks = boardInitialize.getRanks();
    }

    void setBoardInitializeType(BoardInitialize boardInitialize) {
        this.boardInitialize = boardInitialize;
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

        if (findPiece(source).getSymbol() == PieceOperations.Type.EMPTY.getSymbol())
            throw new MyException("Error, This " + source + " is Empty!");

        if (!target.isValid())
            throw new MyException("Error, This " + target + " is out of range!");

        if (findPiece(source).getColor() == findPiece(target).getColor())
            throw new MyException("Error, You cannot move Piece with same color!");

        if (!findPiece(source).getPossibleMoves().contains(target))
            throw new MyException("Error, You cannot move Piece with invalid place!" + NEW_LINE + "It can move only" + findPiece(source).getPossibleMoves());

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
