package chess;

import java.util.List;

public class InitializeEmpty implements BoardInitialize {

    @Override
    public void initialize() {
        for (int i = 0; i < ROW_SIZE; i++) {
            Rank rank = new Rank(i);
            rank.initializeEmpty();
            ranks.add(rank);
        }
    }

    @Override
    public List<Rank> getRanks() {
        return ranks;
    }
}
