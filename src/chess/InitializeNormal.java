package chess;

import pieces.PieceOperations.Color;
import java.util.ArrayList;
import java.util.List;

public class InitializeNormal implements BoardInitialize {
    public static final int ROW_SIZE = 8;
    List<Rank> ranks = new ArrayList<Rank>();

    @Override
    public void initialize() {
        for (int i = 0; i < ROW_SIZE; i++) {
            Rank rank = new Rank(i);
            if (i==0) {
                rank.initializeExceptPawn(Color.WHITE);
            } else if (i==1) {
                rank.initializePawn(Color.WHITE);
            } else if (i==6) {
                rank.initializePawn(Color.BLACK);
            } else if (i==7) {
                rank.initializeExceptPawn(Color.BLACK);
            } else {
                rank.initializeEmpty();
            }
            ranks.add(rank);
        }
    }

    @Override
    public List<Rank> getRanks() {
        return ranks;
    }
}
