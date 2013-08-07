package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class PieceTest extends TestCase {
	public void testIsWhite() throws Exception {
		Piece whitePawn = new Pawn(Color.WHITE, null);
		assertTrue(whitePawn.isWhite());
	}

	public void testIsBlack() throws Exception {
		Piece blackPawn = new Pawn(Color.BLACK, null);
		assertTrue(blackPawn.isBlack());
	}
	
	public void testMove() throws Exception {
		Position source = new Position("a1");
		Position target = new Position("a2");
		Piece whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Pawn(Color.WHITE, target), whitePawn.move(target));
	}
	
	public void testLeave() throws Exception {
		Position source = new Position("a1");
		Piece whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Empty(Color.NOCOLOR, source), whitePawn.leave());
    }

    public void testBishopGetPossibleMove() throws Exception {
        Position source = new Position("c8");
        Piece Bishop = new Bishop(Color.BLACK, source);
        System.out.println(Bishop.getPossibleMoves());

        Position source2 = new Position("c3");
        Piece Bishop2 = new Bishop(Color.WHITE, source2);
        System.out.println(Bishop2.getPossibleMoves());
	}

    public void testEmptyGetPossibleMove() throws Exception {
        Position source = new Position("d4");
        Piece Empty = new Empty(Color.NOCOLOR, source);
        System.out.println(Empty.getPossibleMoves());
    }
}
