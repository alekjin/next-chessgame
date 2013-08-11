package chess;

import java.util.ArrayList;
import java.util.List;
import pieces.*;
import pieces.PieceOperations;
import pieces.PieceOperations.Color;
import pieces.PieceOperations.Type;

public class Rank {
	private List<Piece> rank = new ArrayList<Piece>();
	
	private int rankPosition;
    private PieceOperations pieceOperations = new PieceMaker();

	
	Rank(int yPosition) {
		this.rankPosition = yPosition;
	}

	void initializeEmpty() {
		for (int i = 0; i < Board.COLUMN_SIZE; i++) {
			rank.add(pieceOperations.setPiece(Color.NOCOLOR, Type.EMPTY, new Position(i, rankPosition)) );
		}
	}
	
	void initializePawn(Color color) {
		for (int i = 0; i < Board.COLUMN_SIZE; i++) {
			rank.add(pieceOperations.setPiece(color, Type.PAWN, new Position(i, rankPosition)));
		}
	}
	
	void initializeExceptPawn(Color color) {
		rank.add(pieceOperations.setPiece(color, Type.ROOK, new Position(0, rankPosition)) );
        rank.add(pieceOperations.setPiece(color, Type.KNIGHT, new Position(1, rankPosition)) );
        rank.add(pieceOperations.setPiece(color, Type.BISHOP, new Position(2, rankPosition)) );
        rank.add(pieceOperations.setPiece(color, Type.QUEEN, new Position(3, rankPosition)) );
        rank.add(pieceOperations.setPiece(color, Type.KING, new Position(4, rankPosition)) );
        rank.add(pieceOperations.setPiece(color, Type.BISHOP, new Position(5, rankPosition)) );
        rank.add(pieceOperations.setPiece(color, Type.KNIGHT, new Position(6, rankPosition)) );
        rank.add(pieceOperations.setPiece(color, Type.ROOK, new Position(7, rankPosition)) );
	}


	String generate() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Board.COLUMN_SIZE; i++) {
			sb.append(rank.get(i).getSymbol());
		}
		return sb.toString();
	}

	Piece findPiece(Position position) {
		return rank.get(position.getX());
	}

	void changePiece(int xPosition, Piece targetPiece) {
		rank.set(xPosition, targetPiece);
	}

	Piece move(Piece sourcePiece, Position target) {
		sourcePiece.move(target);
		rank.set(target.getX(), sourcePiece);
		return sourcePiece;
	}
}
