package chess;

import chess.Board;

public class BoardPrintHTML implements BoardPrint{

    public static final String NEW_LINE = "<br />";

    @Override
    public String setCodeType() {
        return NEW_LINE;
    }
}
