package chess;

import junit.framework.TestCase;
import pieces.Empty;
import pieces.Pawn;
import pieces.Piece;
import pieces.PieceOperations.Color;
import pieces.Position;

public class BoardTest extends TestCase {
	private Board board;
	
	@Override
	protected void setUp() throws Exception {
		board = new Board();
	}
	
	public void testCreate() throws Exception {
		board.initialize();
		assertEquals(RankTest.WHITE_PAWN_RANK, board.generateRank(1));
		assertEquals(RankTest.BLACK_PAWN_RANK, board.generateRank(6));
	}
	
	public void testPrint() throws Exception {
		board.initialize();
		String expected = 
			RankTest.BLACK_EXCEPT_PAWN_RANK + Board.NEW_LINE +
			RankTest.BLACK_PAWN_RANK + Board.NEW_LINE +
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() +
			RankTest.WHITE_PAWN_RANK + Board.NEW_LINE +
			RankTest.WHITE_EXCEPT_PAWN_RANK + Board.NEW_LINE;
		assertEquals(expected, board.generateBoard());
		System.out.println(board.generateBoard());
	}
	
	private String createEmptyRank() {
		return RankTest.EMPTY_RANK + Board.NEW_LINE;
	}
	
	public void testFindPiece() throws Exception {
		board.initialize();
		assertEquals('R', board.findPiece("a8").getSymbol());
		assertEquals('k', board.findPiece("e1").getSymbol());
	}
	
	public void testInitializeEmpty() throws Exception {
        board.setBoardInitializeType(new InitializeEmpty());
		board.initialize();
        String expected =
                "........" + Board.NEW_LINE +
                "........" + Board.NEW_LINE +
                "........" + Board.NEW_LINE +
                "........" + Board.NEW_LINE +
                "........" + Board.NEW_LINE +
                "........" + Board.NEW_LINE +
                "........" + Board.NEW_LINE +
                "........" + Board.NEW_LINE;
        assertEquals(expected, board.generateBoard());
	}
	
	public void testMovePiece() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Piece sourcePiece = board.findPiece(source);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);
		
		Position target = new Position("a3");
		board.movePiece(source, target);
		assertEquals(new Empty(Color.NOCOLOR, source), board.findPiece(source));
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));

        String expected =
                "RNBQKBNR" + Board.NEW_LINE +
                "PPPPPPPP" + Board.NEW_LINE +
                "........" + Board.NEW_LINE +
                "........" + Board.NEW_LINE +
                "........" + Board.NEW_LINE +
                "p......." + Board.NEW_LINE +
                ".ppppppp" + Board.NEW_LINE +
                "rnbqkbnr" + Board.NEW_LINE;
        assertEquals(expected, board.generateBoard());

        try {
        // "a5" == Empty Place, "a9" == Invalid Place
        board.movePiece("a5", "a9");
        } catch (MyException error) {
            System.out.println(error);
        }

        try {
        board.movePiece("a5", "a1");
        } catch (MyException error) {
            System.out.println(error);
        }

        try {
        board.movePiece("a1", "a9");
        } catch (MyException error) {
            System.out.println(error);
        }

        try {
        // "c1" and "c2" are same color
        board.movePiece("c1", "c2");
        } catch (MyException error) {
            System.out.println(error);
        }

        try {
        // "e2" is Pawn, it cannot move to "c6"
        board.movePiece("e2", "c6");
        } catch (MyException error) {
            System.out.println(error);
        }

	}

    public void testBoardPrintType() throws Exception {
        board.initialize();
        board.setPrintType(new BoardPrintHTML());
        System.out.println(board.generateBoard());

        board.setPrintType(new BoardPrintConsole());
        System.out.println(board.generateBoard());
    }
}
