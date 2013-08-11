package pieces;

import pieces.PieceOperations.Color;
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
        // expected "[Position [x=3, y=6], Position [x=4, y=5], Position [x=5, y=4], Position [x=6, y=3], Position [x=7, y=2], Position [x=1, y=6], Position [x=0, y=5]]"

        Position source2 = new Position("c3");
        Piece Bishop2 = new Bishop(Color.WHITE, source2);
        System.out.println(Bishop2.getPossibleMoves());
        // expected "[Position [x=1, y=3], Position [x=0, y=4], Position [x=3, y=3], Position [x=4, y=4], Position [x=5, y=5], Position [x=6, y=6], Position [x=7, y=7], Position [x=3, y=1], Position [x=4, y=0], Position [x=1, y=1], Position [x=0, y=0]]"
	}

    public void testEmptyGetPossibleMove() throws Exception {
        Position source = new Position("d4");
        Piece Empty = new Empty(Color.NOCOLOR, source);
        System.out.println(Empty.getPossibleMoves());
        // expected []
    }

    public void testKingGetPossibleMove() throws Exception {
        Position source = new Position("e4");
        Piece King = new King(Color.BLACK, source);
        System.out.println(King.getPossibleMoves());
        // expected [Position [x=5, y=2], Position [x=4, y=2], Position [x=3, y=2], Position [x=4, y=4], Position [x=5, y=3], Position [x=5, y=4], Position [x=3, y=4], Position [x=3, y=3]]
    }

    public void testQueenGetPossibleMove() throws Exception {
        Position source = new Position("b6");
        Piece Queen = new Queen(Color.WHITE, source);
        System.out.println(Queen.getPossibleMoves());
        // expected "[Position [x=2, y=4], Position [x=3, y=3], Position [x=4, y=2], Position [x=5, y=1], Position [x=6, y=0], Position [x=1, y=4], Position [x=1, y=3], Position [x=1, y=2], Position [x=1, y=1], Position [x=1, y=0], Position [x=0, y=4], Position [x=1, y=6], Position [x=1, y=7], Position [x=2, y=5], Position [x=3, y=5], Position [x=4, y=5], Position [x=5, y=5], Position [x=6, y=5], Position [x=7, y=5], Position [x=2, y=6], Position [x=3, y=7], Position [x=0, y=6], Position [x=0, y=5]]"
    }

    public void testPawnGetPossibleMove() throws Exception {
        Position source = new Position("d5");
        Piece BlackPawn = new Pawn(Color.BLACK, source);
        System.out.println(BlackPawn.getPossibleMoves());
        // expected "[Position [x=3, y=5], Position [x=3, y=3]]"

        Piece WhitePawn = new Pawn(Color.WHITE, source);
        System.out.println(WhitePawn.getPossibleMoves());
        // expected "[Position [x=3, y=5]]"

        Position source2 = new Position("b2");
        Piece StartPawn = new Pawn(Color.WHITE, source2);
        System.out.println(StartPawn.getPossibleMoves());
        // expected "[Position [x=1, y=2]]"

        Position source3 = new Position("b7");
        Piece StartPawn2 = new Pawn(Color.BLACK, source3);
        System.out.println(StartPawn2.getPossibleMoves());
        // expected "[Position [x=1, y=5], Position [x=1, y=7]]"
    }

    public void testRookGetPossibleMove() throws Exception {
        Position source = new Position("f4");
        Piece Rook = new Rook(Color.BLACK, source);
        System.out.println(Rook.getPossibleMoves());
        // expected "[Position [x=5, y=4], Position [x=5, y=5], Position [x=5, y=6], Position [x=5, y=7], Position [x=5, y=2], Position [x=5, y=1], Position [x=5, y=0], Position [x=6, y=3], Position [x=7, y=3], Position [x=4, y=3], Position [x=3, y=3], Position [x=2, y=3], Position [x=1, y=3], Position [x=0, y=3]]"
    }
}
