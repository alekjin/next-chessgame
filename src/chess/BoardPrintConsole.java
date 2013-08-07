package chess;

public class BoardPrintConsole implements BoardPrint{
    public static final String NEW_LINE = System.getProperty("line.separator");

    @Override
    public String setCodeType() {
        return NEW_LINE;
    }
}
