package chess;

import java.util.ArrayList;
import java.util.List;

public interface BoardInitialize {
    public static final int ROW_SIZE = 8;
    List<Rank> ranks = new ArrayList<Rank>();

    void initialize();
    List<Rank> getRanks();
}
